package com.qixiu.schoolfix.ui.acitivty.inspection.check_route;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckRouteActivity extends RequestActivity {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    CheckRouteAdapter adapter;
    @Override
    protected void onInitData() {
        mTitleView.setTitle("其他路线");
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_check_route;
    }

    @Override
    protected void onInitViewNew() {
        adapter=new CheckRouteAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        XrecyclerViewUtil.refreshFictiousData(adapter);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
