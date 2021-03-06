package com.qixiu.schoolfix.ui.acitivty.knowledge_share;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.knowledge_share.details.KownledgeWebActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.schoolfix.utils.reuestutil.RequestMaker;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnowledgeShareListActivity extends RequestActivity implements OnRecyclerItemListener {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    KnowledgeAdapter adapter;

    @Override
    protected void onInitData() {
        mTitleView.setTitle("知识分享");
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new KnowledgeAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        getData();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_knowledge_share_list;
    }

    @Override
    protected void onInitViewNew() {
    }

    @Override
    public void onSuccess(BaseBean data) {
        if(data instanceof KnowledgeShareBean){
            KnowledgeShareBean bean= (KnowledgeShareBean) data;
            adapter.refreshData(bean.getO().getDataList());
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

    public void getData() {
        Map<String,String> map=new HashMap<>();
        map.put("tenantId", LoginStatus.getLoginBean().getO().getRepairBusinessGUID());
        RequestBean request = RequestMaker.getRequest(map);
        request.setOrder("createTime desc");
        post(ConstantUrl.shareTypeUrl,request,new KnowledgeShareBean());
    }

    @Override
    public void onItemClick(View v, RecyclerView.Adapter adapter, Object data) {
        if(data instanceof KnowledgeShareBean.ResultBean.DataListBean){
            KnowledgeShareBean.ResultBean.DataListBean bean= (KnowledgeShareBean.ResultBean.DataListBean) data;
            KownledgeWebActivity.start(getContext(),KownledgeWebActivity.class,bean);
        }
    }
}
