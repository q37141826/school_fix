package com.qixiu.schoolfix.ui.acitivty.home.create_mechine;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.amap.api.maps.model.LatLng;
import com.qixiu.alimaplib.result.AmapClickResultBean;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequstActivity;
import com.qixiu.schoolfix.ui.acitivty.home.binding.MechineCodeListBean;
import com.qixiu.schoolfix.ui.acitivty.home.binding.MechineDetailsBean;
import com.qixiu.widget.LineControllerView;
import com.qixiu.wigit.myedittext.MyEditTextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateMechineActivity extends RequstActivity {
    @BindView(R.id.lineSchoolName)
    LineControllerView lineSchoolName;
    @BindView(R.id.lineProductName)
    LineControllerView lineProductName;
    @BindView(R.id.editextMechineCode)
    MyEditTextView editextMechineCode;
    @BindView(R.id.lineBuyDate)
    LineControllerView lineBuyDate;
    @BindView(R.id.lineLimitYears)
    LineControllerView lineLimitYears;
    @BindView(R.id.lineMatainYears)
    LineControllerView lineMatainYears;
    //    @BindView(R.id.lineIpAddress)
//    LineControllerView lineIpAddress;

    @BindView(R.id.editextIPAddress)
    MyEditTextView editextIPAddress;
    @BindView(R.id.lineAddress)
    LineControllerView lineAddress;
    private String loactionPermissions[] = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};
    private AmapClickResultBean amapClickResultBean;
    private MechineCodeListBean.ResultBean.DataListBean resultBean;


    @Override
    protected void onInitData() {
        EventBus.getDefault().register(this);

        resultBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
        if(resultBean.isModify()){
            mTitleView.setTitle("修改设备");
            editextIPAddress.setText(resultBean.getDeviceIpAddress());
            editextMechineCode.setText(resultBean.getDeviceMachineCode());
            lineAddress.setSecondaryText(resultBean.getDeviceAddress());
            amapClickResultBean=new AmapClickResultBean();
            amapClickResultBean.setAddress(resultBean.getDeviceAddress());
            double x=Double.parseDouble(resultBean.getDeviceMapX());
            double y=Double.parseDouble(resultBean.getDeviceMapX());
            LatLng latLng=new LatLng(x,y);
            amapClickResultBean.setLatLng(latLng);
        }else {
            mTitleView.setTitle("新增设备");

        }


        lineBuyDate.setSecondaryText(resultBean.getDeviceBuyDate());
        lineSchoolName.setSecondaryText(resultBean.getSchoolUnitName());
        lineProductName.setSecondaryText(resultBean.getProductName());

        lineLimitYears.setSecondaryText(resultBean.getDeviceNotUseYears()+"");
        lineMatainYears.setSecondaryText(resultBean.getDeviceRepairBeginDate().substring(0,10)
                +"至"+resultBean.getDeviceRepairEndDate().substring(0,10));
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_create_mechine;
    }

    @Override
    protected void onInitViewNew() {

    }

    @Override
    public void onSuccess(BaseBean data) {
        if(data.getUrl().equals(ConstantUrl.modifyEqupmentList)){
            ToastUtil.toast("修改成功");
            finish();
        }
        if(data.getUrl().equals(ConstantUrl.createEqupmentList)){
            ToastUtil.toast("创建成功");
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


    //跳转地图选择界面
    public void inputAddress(View view) {
        if (!hasPermission(loactionPermissions)) {
            hasRequse(1, loactionPermissions);
            return;
        }
        SelectAddressActivity.start(getContext(), SelectAddressActivity.class);
    }

    public void createMechineCode(View view) {
        Map<String, String> map = new HashMap<>();
        String ip = editextIPAddress.getText().toString().trim();
        String mechineCode = editextMechineCode.getText().toString().trim();
        if(TextUtils.isEmpty(mechineCode)){
            ToastUtil.toast("请输入设备码");
        }
        if(TextUtils.isEmpty(ip)){
            ToastUtil.toast("请输入网络IP");
            return;
        }


        map.put("deviceIpAddress", ip);
        map.put("deviceMachineCode", mechineCode);


        map.put("schoolUnitGUID", resultBean.getSchoolUnitGUID());
        map.put("deviceType",resultBean.getDeviceType()+"");

        map.put("deviceAddress", amapClickResultBean.getAddress());
        map.put("deviceMapX", amapClickResultBean.getLatLng().latitude + "");
        map.put("deviceMapY", amapClickResultBean.getLatLng().longitude + "");

        map.put("deviceBuyDate", resultBean.getDeviceBuyDate());
        map.put("deviceNotUseYears",resultBean.getDeviceNotUseYears()+"");
        map.put("deviceRepairEndDate", resultBean.getDeviceRepairEndDate()+ "");
        map.put("deviceRepairBeginDate",resultBean.getDeviceRepairBeginDate() + "");
        map.put("deviceRepairBeginDate",resultBean.getDeviceRepairBeginDate() + "");
        map.put("RepairBusinessGUID",resultBean.getRepairBusinessGUID() + "");
        map.put("productGUID",resultBean.getProductGUID() + "");
        if(resultBean.isModify()){
            map.put("id",resultBean.getId() + "");
            post(ConstantUrl.modifyEqupmentList,map,new BaseBean());
        }else {
            post(ConstantUrl.createEqupmentList,map,new BaseBean());
        }
    }

    @Subscribe
    public void getAddressEvent(AmapClickResultBean bean) {
        amapClickResultBean = bean;
        lineAddress.setSecondaryText(bean.getAddress());
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (hasPermission(loactionPermissions)) {
            SelectAddressActivity.start(getContext(), SelectAddressActivity.class);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
