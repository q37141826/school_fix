package com.qixiu.schoolfix.ui.acitivty.inspection;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qixiu.alimaplib.location.LoactionUtils;
import com.qixiu.qixiu.application.AppManager;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.model.check_mechine.CheckMainSchoolBean;
import com.qixiu.schoolfix.model.check_mechine.CheckRouteBean;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.check_route.CheckRouteActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.history.HistoryActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.school_check.SchoolCheckMechineListActiviy;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.utils.AddressStatus;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.schoolfix.utils.reuestutil.RequestMaker;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InspectionActivity extends RequestActivity implements XRecyclerView.LoadingListener, OnRecyclerItemListener {


    @BindView(R.id.imageViewHead)
    ImageView imageViewHead;
    @BindView(R.id.textViewName)
    TextView textViewName;
    @BindView(R.id.textViewDate)
    TextView textViewDate;
    @BindView(R.id.textViewRoute)
    TextView textViewRoute;
    @BindView(R.id.imageViewAddressIcon)
    ImageView imageViewAddressIcon;
    @BindView(R.id.imageViewMarkIcon)
    ImageView imageViewMarkIcon;
    @BindView(R.id.textViewInspectPoint)
    TextView textViewInspectPoint;
    @BindView(R.id.textViewSelection)
    TextView textViewSelection;
    @BindView(R.id.xrecyclerView)
    XRecyclerView xrecyclerView;
    InspectionAdapter adapter;
    String addressId;

    @Override
    protected void onInitViewNew() {
        EventBus.getDefault().register(this);
        mTitleView.setTitle("巡检管理");
        mTitleView.setRightImage(getContext(), R.drawable.jcgl_icon_nz);
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoryActivity.start(getContext(), HistoryActivity.class);
            }
        });
        adapter = new InspectionAdapter();
        XrecyclerViewUtil.setXrecyclerView(xrecyclerView, this, getContext(), true, 1, null);
        xrecyclerView.setAdapter(adapter);
        //展示假数据
        adapter.setOnItemClickListener(this);
        loadData();
    }

    private void loadData() {
        if (AddressStatus.getDefultAddress() != null) {
            addressId = AddressStatus.getDefultAddress().getCheckLineGUID();
        }
        if (!TextUtils.isEmpty(addressId)) {
            getData();
        }
    }


    private void getData() {
        List<String[]> datas = new ArrayList<>();
        String[] datas1 = {"userGUID", "uniqueidentifier", "eq", LoginStatus.getToken()};
        String[] datas2 = {"checkLineGUID", "uniqueidentifier", "eq", addressId};
        String[] datas3 = {"checkRecordBeginTime", "datetime", "ge", TimeDataUtil.getTimeStamp(new Date().getTime()) + " 00:00:00"};
        String[] datas4 = {"checkRecordBeginTime", "datetime", "le", TimeDataUtil.getTimeStamp(new Date().getTime()) + " 23:59:59"};
        datas.add(datas1);
        datas.add(datas2);
        datas.add(datas3);
        datas.add(datas4);
        RequestBean createTime = RequestMaker.getRequests(datas, "createTime", "and");
        post(ConstantUrl.checkHomeUrl, createTime, new CheckMainSchoolBean());
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof CheckMainSchoolBean) {
            CheckMainSchoolBean listBean = (CheckMainSchoolBean) data;
            adapter.refreshData(listBean.getO().getDataList());
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
    protected void onInitData() {
        //设置点击了去哪里
        adapter.setClickListenner(new RecyclerBaseAdapter.ClickListenner() {
            @Override
            public void click(View view, Object o) {

            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_inspection;
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
        //跳转详情界面
        Preference.putBoolean(ConstantString.IS_EDIBLE, true);
        if (data instanceof CheckMainSchoolBean.ResultBean.DataListBean) {
            CheckMainSchoolBean.ResultBean.DataListBean listBean = (CheckMainSchoolBean.ResultBean.DataListBean) data;
            SchoolCheckMechineListActiviy.start(getContext(), SchoolCheckMechineListActiviy.class, listBean);
        }
    }


    //巡检路线
    public void checkRoute(View view) {
        CheckRouteActivity.start(getContext(), CheckRouteActivity.class);

    }

    //选择了巡检路线之后
    @Subscribe
    public void getAddressEvent(CheckRouteBean.ResultBean.DataListBean dataListBean) {
        AppManager.getAppManager().finishActivity(CheckRouteActivity.class);
    }

    //巡检地图
    public void gotoRouteMap(View view) {
        if (!hasPermission(LoactionUtils.loactionPermissions)) {
            hasRequse(1, LoactionUtils.loactionPermissions);
            return;
        }
        RouteMapActivity.start(getContext(), RouteMapActivity.class);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (hasPermission(LoactionUtils.loactionPermissions)) {
            RouteMapActivity.start(getContext(), RouteMapActivity.class);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        loadData();
    }
}
