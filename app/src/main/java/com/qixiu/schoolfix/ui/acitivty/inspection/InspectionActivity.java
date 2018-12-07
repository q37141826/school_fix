package com.qixiu.schoolfix.ui.acitivty.inspection;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qixiu.alimaplib.location.LoactionUtils;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.check_route.CheckRouteActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.history.HistoryActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.school_check.SchoolCheckMechineListActiviy;

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

    @Override
    protected void onInitViewNew() {
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
        XrecyclerViewUtil.refreshFictiousData(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onSuccess(BaseBean data) {

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
        Preference.putBoolean(ConstantString.IS_EDIBLE,true);
        SchoolCheckMechineListActiviy.start(getContext(), SchoolCheckMechineListActiviy.class);
    }


    //巡检路线
    public void checkRoute(View view) {
        CheckRouteActivity.start(getContext(), CheckRouteActivity.class);

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
}
