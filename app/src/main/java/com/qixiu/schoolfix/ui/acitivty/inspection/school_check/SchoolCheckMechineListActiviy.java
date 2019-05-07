package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceSearch;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qixiu.alimaplib.location.LoactionUtils;
import com.qixiu.qixiu.google.zxing.client.android.CaptureActivity;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.NumUtils;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.model.check_mechine.CheckMainSchoolBean;
import com.qixiu.schoolfix.model.check_mechine.CheckMechineBean;
import com.qixiu.schoolfix.model.check_mechine.IsInRangeBean;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.check_details.CheckDetailsActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.utils.reuestutil.RequestMaker;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolCheckMechineListActiviy extends RequestActivity implements XRecyclerView.LoadingListener, OnRecyclerItemListener {

    String permissions[] = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
    @BindView(R.id.xrecyclerView)
    XRecyclerView xrecyclerView;
    SchoolCheckAdapter adapter;
    private CheckMainSchoolBean.ResultBean.DataListBean dataListBean;
    private CheckMechineBean checkMechineBean;
    private boolean isPause;
    private String code;

    @Override
    protected void onInitData() {
        dataListBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
        mTitleView.setTitle("检查学校名称");
        mTitleView.setRightImage(getContext(), R.drawable.tab_btn_sma);
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasPermission(permissions)) {
                    hasRequse(1, permissions);
                    return;
                }
                gotoScan();
            }
        });
        if (!Preference.getBoolean(ConstantString.IS_EDIBLE)) {
            mTitleView.setRightTextVisible(View.GONE);
            adapter.setCheckBle(false);
        }
        getData();
    }

    private void gotoScan() {
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        startActivityForResult(intent, CaptureActivity.ZXING_INTENT);//
        //扫描
//        LoactionUtils.getLoacation(getContext(), new LoactionUtils.LocationResultListenner() {
//            @Override
//            public void getResult(Location location) {
//                if (!isPause) {//离开界面就不要重复跳转了
//                    isPart(location, new DistanceSearch.OnDistanceSearchListener() {//判断当前和目标距离的本地方法
//                        @Override
//                        public void onDistanceSearched(DistanceResult distanceResult, int i) {
//                            if (distanceResult.getDistanceResults().get(0).getDistance() / 1000 < 1) {
//                                isPause = true;
//                            } else {
//                                ToastUtil.toastNew("未到达指定地点");
//                            }
//                        }
//                    });
//                }
//            }
//        });
    }

//    private boolean isInPart(Location location) {//判断目标和当前位置的距离是否在一公里内
//        double y = Double.parseDouble(dataListBean.getSchoolUnitMapY());
//        double x = Double.parseDouble(dataListBean.getSchoolUnitMapX());
//        double xC = location.getLongitude();
//        double yC = location.getLatitude();
//        double powY = Math.pow(y - yC, 2);
//        double powX = Math.pow(x - xC, 2);
//        double distance = Math.pow(powX + powY, 0.5) * 111;
//        return distance < 1;
//    }

    private void isPart(Location location, DistanceSearch.OnDistanceSearchListener distanceSearchListener) {
        DistanceSearch.DistanceQuery distanceQuery = new DistanceSearch.DistanceQuery();
        LatLonPoint start = new LatLonPoint(location.getLatitude(), location.getLongitude());
        LatLonPoint end = new LatLonPoint(Double.parseDouble(dataListBean.getSchoolUnitMapY()), Double.parseDouble(dataListBean.getSchoolUnitMapX()));
        List<LatLonPoint> latLonPoints = new ArrayList<LatLonPoint>();
        latLonPoints.add(start);
        distanceQuery.setOrigins(latLonPoints);
        distanceQuery.setDestination(end);
        DistanceSearch distanceSearch = new DistanceSearch(getContext());
        distanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        distanceSearch.setDistanceSearchListener(distanceSearchListener);

    }

    private void getData() {
        List<String[]> datas = new ArrayList<>();
        String[] data01 = {"checkRecordGUID", "uniqueidentifier", "eq", dataListBean.getId()};
        datas.add(data01);
        RequestBean requests = RequestMaker.getRequests(datas, "createTime", "and");
        post(ConstantUrl.mechineListUrl, requests, new CheckMechineBean());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_school_check_list_activiy;
    }

    @Override
    protected void onInitViewNew() {
        XrecyclerViewUtil.setXrecyclerView(xrecyclerView, this, this, false, 1, null);
        adapter = new SchoolCheckAdapter();
        xrecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
//        adapter.setClickListenner(new RecyclerBaseAdapter.ClickListenner() {
//            @Override
//            public void click(View view, Object o) {
//                //跳转检查事项  这个只是查看
//                Preference.putBoolean(ConstantString.IS_EDIBLE, false);
//                CheckItemsActivity.start(getContext(), CheckItemsActivity.class);
//            }
//        });
        adapter.setItemChildClick(new RecyclerBaseAdapter.ClickListenner2() {
            @Override
            public void itemChildclick(View view, Object o, int type, View itemView) {
                if (o instanceof CheckMechineBean.ResultBean.DataListBean) {
                    CheckMechineBean.ResultBean.DataListBean bean = (CheckMechineBean.ResultBean.DataListBean) o;
                    CheckDetailsActivity.start(getContext(), CheckDetailsActivity.class, bean.getDeviceGUID());
                }
            }
        });
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof CheckMechineBean) {
            checkMechineBean = (CheckMechineBean) data;
            adapter.refreshData(checkMechineBean.getO().getDataList());
            gotoInput(checkMechineBean);//跳转检查填写界面
        }
        if (data.getUrl().equals(ConstantUrl.updateMechineUrl)) {
            getData();
        }
        if (data instanceof IsInRangeBean) {
            IsInRangeBean bean = (IsInRangeBean) data;
            if (bean.getO().getIsInRange() == 1) {
                markeMechineData(code);
            } else {
                ToastUtil.toast("未到达指定地点");
            }
        }
    }

    private void gotoInput(CheckMechineBean bean) {
        boolean gotoInput = true;
        for (int i = 0; i < bean.getO().getDataList().size(); i++) {
            if (bean.getO().getDataList().get(i).getIsChecked() == 0) {
                gotoInput = false;
                break;
            }
        }
        if (gotoInput && Preference.getBoolean(ConstantString.IS_EDIBLE)) {
            CheckInputStyleOneActivity.start(getContext(), CheckInputStyleOneActivity.class, dataListBean);
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
    public void onRefresh() {
        xrecyclerView.loadMoreComplete();
        xrecyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        xrecyclerView.loadMoreComplete();
        xrecyclerView.refreshComplete();
    }

    @Override
    public void onItemClick(View v, RecyclerView.Adapter adapter, Object data) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Preference.putBoolean(ConstantString.IS_EDIBLE, true);
            code = data.getStringExtra(CaptureActivity.ZXING_VALUE);
            mZProgressHUD.show();
            LoactionUtils.getOneceLoction(getContext(), new LoactionUtils.LocationResultListenner() {
                @Override
                public void getResult(Location location) {
                    Map<String, String> map = new HashMap<>();
                    CheckMechineBean.ResultBean.DataListBean listBean = searchMechine(code);
                    if (listBean == null) {
                        return;
                    }
                    map.put("deviceGUID", listBean.getDeviceGUID());
                    map.put("xLocation", NumUtils.formatDouble3(location.getLongitude(), 7));
                    map.put("yLocation", NumUtils.formatDouble3(location.getLatitude(), 7));
                    post(ConstantUrl.isInRangeUrl, map, new IsInRangeBean());
                }
            });
        }
    }


    private CheckMechineBean.ResultBean.DataListBean searchMechine(String code) {
        CheckMechineBean.ResultBean.DataListBean bean = null;
        //先签到，所有的设备都签到OK之后跳转检查页面
        for (int i = 0; i < checkMechineBean.getO().getDataList().size(); i++) {
            if (checkMechineBean.getO().getDataList().get(i).getQrCodeGUID() != null && checkMechineBean.getO().getDataList().get(i).getQrCodeGUID().equals(code)) {
                bean = checkMechineBean.getO().getDataList().get(i);
            }
        }
        if (bean == null) {
            ToastUtil.toast("设备不在检查任务内");
            return null;
        }
        return bean;
    }


    private void markeMechineData(String code) {
        CheckMechineBean.ResultBean.DataListBean listBean = searchMechine(code);
        if (listBean == null) {
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("id", listBean.getId());
        map.put("checkDeviceRecordTime", TimeDataUtil.getTimeStamp(new Date().getTime(), TimeDataUtil.DEFULT_TIME_FORMAT));
        post(ConstantUrl.updateMechineUrl, map, new BaseBean());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (hasPermission(permissions)) {
            gotoScan();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        isPause = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isPause = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isPause = true;
    }

}
