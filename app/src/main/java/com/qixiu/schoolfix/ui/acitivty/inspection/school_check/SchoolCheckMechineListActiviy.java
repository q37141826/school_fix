package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qixiu.qixiu.google.zxing.client.android.CaptureActivity;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.check_details.CheckDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolCheckMechineListActiviy extends RequestActivity implements XRecyclerView.LoadingListener, OnRecyclerItemListener {


    @BindView(R.id.xrecyclerView)
    XRecyclerView xrecyclerView;
    SchoolCheckAdapter adapter;

    @Override
    protected void onInitData() {
        mTitleView.setTitle("检查学校名称");
        mTitleView.setRightImage(getContext(), R.drawable.tab_btn_sma);
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //扫描
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, CaptureActivity.ZXING_INTENT);
            }
        });
        if (!Preference.getBoolean(ConstantString.IS_EDIBLE)) {
            mTitleView.setRightTextVisible(View.GONE);
        }
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

        //制造假数据
        XrecyclerViewUtil.refreshFictiousData(adapter);
        adapter.setClickListenner(new RecyclerBaseAdapter.ClickListenner() {
            @Override
            public void click(View view, Object o) {
                //跳转检查事项  这个只是查看
                Preference.putBoolean(ConstantString.IS_EDIBLE, false);
                CheckItemsActivity.start(getContext(), CheckItemsActivity.class);
            }
        });
        adapter.setItemChildClick(new RecyclerBaseAdapter.ClickListenner2() {
            @Override
            public void itemChildclick(View view, Object o, int type, View itemView) {
                CheckDetailsActivity.start(getContext(), CheckDetailsActivity.class);
            }
        });
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
        //跳转检查事项  这个可以编辑
        if (data != null) {
            Preference.putBoolean(ConstantString.IS_EDIBLE, true);
            String code = data.getStringExtra(CaptureActivity.ZXING_VALUE);
            CheckItemsActivity.start(getContext(), CheckItemsActivity.class);
        }
    }
}
