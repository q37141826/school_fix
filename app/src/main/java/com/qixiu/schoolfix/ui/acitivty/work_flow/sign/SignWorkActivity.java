package com.qixiu.schoolfix.ui.acitivty.work_flow.sign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.qixiu.alimaplib.location.LoactionUtils;
import com.qixiu.alimaplib.location.LocationResultStrIntf;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.details.WorkDetailsBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignWorkActivity extends RequestActivity implements SignAdapter.ClickListenner, AMapLocationListener, LocationResultStrIntf {

    static final int SIGN_GO = 1;
    static final int SIGN_IN = 2;
    static final int SIGN_OUT = 3;
    static final int SIGN_FINISH = 4;
    private int currentStep;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private SignAdapter adapter;
    private WorkDetailsBean.ResultBean resultBean;

    String timeFormat = "yyyy-MM-dd HH:mm:ss";
    //        workOrderAssignTime这个字段是指派时间
    long workOrderAssignTime;
    //定位参数
    //声明mlocationClient对象
    public AMapLocationClient mlocationClient;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    private String address;
    private double latitude;
    private double longitude;

    @Override
    protected void onInitData() {
        initePermission();
        initLocation();
        resultBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
        if(resultBean.getWorkOrderAssignTime()==null){
            ToastUtil.toast("数据非法");
            finish();
            return;
        }
        workOrderAssignTime = TimeDataUtil.timeStrToLong(resultBean.getWorkOrderAssignTime(), timeFormat);
        mTitleView.setTitle("考勤记录");
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SignAdapter();
        adapter.setListenner(this);
        recyclerview.setAdapter(adapter);
        makeData();
    }

    private void initePermission() {
        if(!hasPermission(LoactionUtils.loactionPermissions)){
            hasRequse(1,LoactionUtils.loactionPermissions);
            return;
        }
    }

    private void initLocation() {
        mlocationClient = new AMapLocationClient(this);
//初始化定位参数
        mLocationOption = new AMapLocationClientOption();
//设置定位监听
        mlocationClient.setLocationListener(this);
//设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
//设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
// 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
// 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
// 在定位结束后，在合适的生命周期调用onDestroy()方法
// 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
//启动定位
        mlocationClient.startLocation();
    }

    private void makeData() {
        List<TimeAddressBean> steps = new ArrayList<>();
        setCurrentStep();


        if (!TextUtils.isEmpty(resultBean.getWorkOrderGoTime())) {
            TimeAddressBean timeAddressBean = new TimeAddressBean();
            timeAddressBean.setTime(resultBean.getWorkOrderGoTime());
            timeAddressBean.setAddress(resultBean.getWorkOrderGoAddress());
            timeAddressBean.setBtnText("签到");
            timeAddressBean.setTitleText("开始出发");
            timeAddressBean.setBtnVisble(currentStep == SIGN_IN);
            timeAddressBean.setMinutus((int) (TimeDataUtil.timeStrToLong(resultBean.getWorkOrderGoTime(), timeFormat) -
                    workOrderAssignTime)
            );
            steps.add(timeAddressBean);
        } else {
            TimeAddressBean timeAddressBean = new TimeAddressBean();
            timeAddressBean.setMinutus(0);
            timeAddressBean.setAddress("");
            timeAddressBean.setBtnText("开始出发");
            timeAddressBean.setTitleText("开始出发");
            timeAddressBean.setBtnVisble(currentStep == SIGN_GO);
            steps.add(timeAddressBean);
        }

        if (!TextUtils.isEmpty(resultBean.getWorkOrderSignInTime())) {
            TimeAddressBean timeAddressBean = new TimeAddressBean();
            timeAddressBean.setTime(resultBean.getWorkOrderSignInTime());
            timeAddressBean.setAddress(resultBean.getWorkOrderSignInAddress());
            timeAddressBean.setMinutus((int) (TimeDataUtil.timeStrToLong(resultBean.getWorkOrderSignInTime(), timeFormat) -
                    TimeDataUtil.timeStrToLong(resultBean.getWorkOrderGoTime(), timeFormat))
            );
            timeAddressBean.setBtnText("签离");
            timeAddressBean.setTitleText("签到");
            timeAddressBean.setBtnVisble(currentStep == SIGN_OUT);
            steps.add(timeAddressBean);
        }

        if (!TextUtils.isEmpty(resultBean.getWorkOrderSignOutTime())) {
            TimeAddressBean timeAddressBean = new TimeAddressBean();
            timeAddressBean.setTime(resultBean.getWorkOrderSignOutTime());
            timeAddressBean.setAddress(resultBean.getWorkOrderSignOutAddress());
            timeAddressBean.setMinutus((int) (TimeDataUtil.timeStrToLong(resultBean.getWorkOrderSignOutTime(), timeFormat) -
                    TimeDataUtil.timeStrToLong(resultBean.getWorkOrderSignInTime(), timeFormat))
            );
            timeAddressBean.setTitleText("签离");
            timeAddressBean.setBtnText("完成");
            timeAddressBean.setBtnVisble(false);
            steps.add(timeAddressBean);
        }
        adapter.refreshData(steps);

    }

    private void setCurrentStep() {
        if (!TextUtils.isEmpty(resultBean.getWorkOrderSignOutTime())) {
            currentStep = SIGN_FINISH;
            return;
        }
        if (!TextUtils.isEmpty(resultBean.getWorkOrderSignInTime())) {
            currentStep = SIGN_OUT;
            return;
        }
        if (!TextUtils.isEmpty(resultBean.getWorkOrderGoTime())) {
            currentStep = SIGN_IN;
        } else {
            currentStep = SIGN_GO;
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_work;
    }

    @Override
    protected void onInitViewNew() {

    }

    @Override
    public void onSuccess(BaseBean data) {
        if(data.getUrl().equals(ConstantUrl.signUrl)){
            ToastUtil.toast("签名成功");
            finish();
        }
    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    public void click() {
        if(TextUtils.isEmpty(address)){
            ToastUtil.toast("定位中请稍等");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("id", resultBean.getId());
        switch (currentStep) {
            case SIGN_GO:
                map.put("workOrderGoTime", TimeDataUtil.getTimeStamp(new Date().getTime(),timeFormat));
                map.put("workOrderGoAddress", address);
                map.put("workOrderGoX", latitude+"");
                map.put("workOrderGoY", longitude+"");
                break;
            case SIGN_IN:
                map.put("workOrderSignInTime", TimeDataUtil.getTimeStamp(new Date().getTime(),timeFormat));
                map.put("workOrderSignInAddress", address);
                map.put("workOrderSignInX", latitude+"");
                map.put("workOrderSignInY", longitude+"");
                break;
            case SIGN_OUT:
                map.put("workOrderSignOutTime", TimeDataUtil.getTimeStamp(new Date().getTime(),timeFormat));
                map.put("workOrderSignOutAddress", address);
                map.put("workOrderSignOutTimeX", latitude+"");
                map.put("workOrderSignOutTimeY", longitude+"");
                break;
        }
        post(ConstantUrl.signUrl,map,new BaseBean());
    }


    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                //获取纬度
                latitude = amapLocation.getLatitude();
                //获取经度
                longitude = amapLocation.getLongitude();
                amapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(amapLocation.getTime());
                df.format(date);//定位时间
                LoactionUtils.searchAddress(latitude, longitude, getContext(), this);
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(!hasPermission(LoactionUtils.loactionPermissions)){
            ToastUtil.toast("请允许定位");
            return;
        }
    }

    @Override
    public void locationResult(String result) {
        address = result;
    }


}
