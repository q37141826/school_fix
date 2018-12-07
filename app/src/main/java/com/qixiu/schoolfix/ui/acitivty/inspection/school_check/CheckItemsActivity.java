package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckItemsActivity extends RequestActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    CheckItemsAdapter adapter;

    @Override
    protected void onInitData() {
        mTitleView.setTitle("-检测");
        mTitleView.setRightText("确定");
        mTitleView.getRightText().setTextColor(getResources().getColor(R.color.theme_color));
        mTitleView.getRightText().setBackgroundResource(R.drawable.shape_text_title);
        if (!Preference.getBoolean(ConstantString.IS_EDIBLE)) {
            mTitleView.setRightTextVisible(View.GONE);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_check_items;
    }

    @Override
    protected void onInitViewNew() {
        adapter=new CheckItemsAdapter();
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
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
