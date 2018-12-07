package com.qixiu.schoolfix.ui.acitivty.inspection.history;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.school_check.SchoolCheckMechineListActiviy;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends RequestActivity implements XRecyclerView.LoadingListener, OnRecyclerItemListener {


    @BindView(R.id.xrecyclerView)
    XRecyclerView xrecyclerView;
    HistoryAdapter adapter;
    boolean isVisble=true;
    @Override
    protected void onInitData() {
        mTitleView.setTitle("历史行程");
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_history;
    }

    @Override
    protected void onInitViewNew() {
        View view = View.inflate(getContext(), R.layout.head_history, null);
        findHeadView(view);
        xrecyclerView.addHeaderView(view);
        adapter = new HistoryAdapter();
        XrecyclerViewUtil.setXrecyclerView(xrecyclerView, this, this, false, 1, null);
        xrecyclerView.setAdapter(adapter);
        XrecyclerViewUtil.refreshFictiousData(adapter);
        adapter.setOnItemClickListener(this);
    }

    private void findHeadView(View view) {
        RelativeLayout relativeLayout = view.findViewById(R.id.relativeLayout);
        CalendarView calenderView = view.findViewById(R.id.calenderView);
        ImageView imageViewGoto=view.findViewById(R.id.imageViewGoto);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isVisble=!isVisble;
                if(isVisble){
                    calenderView.setVisibility(View.VISIBLE);
                    imageViewGoto.setImageResource(R.drawable.lsxc_icon_xiala);
                }else {
                    imageViewGoto.setImageResource(R.drawable.pqgaojzx_btn_xiala);
                    calenderView.setVisibility(View.GONE);
                }
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
        Preference.putBoolean(ConstantString.IS_EDIBLE, false);
        SchoolCheckMechineListActiviy.start(getContext(), SchoolCheckMechineListActiviy.class);
    }
}
