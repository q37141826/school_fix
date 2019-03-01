package com.qixiu.schoolfix.ui.acitivty.inspection.check_route;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.BR;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.model.check_mechine.CheckRouteBean;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.utils.AddressStatus;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.schoolfix.utils.reuestutil.RequestMaker;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckRouteActivity extends RequestActivity implements OnRecyclerItemListener {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    CheckRouteAdapter adapter;

    @Override
    protected void onInitData() {
        mTitleView.setTitle("其他路线");
        getData();
    }

    private void getData() {
        Map<String, String[]> map = new HashMap<>();
        String data[] = {"userGUID", "uniqueidentifier", "eq", LoginStatus.getToken()};
        map.put(data[0], data);
        RequestBean requests = RequestMaker.getRequests(map, "createTime", "and");
        post(ConstantUrl.checkRoutListUrl, requests, new CheckRouteBean());

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_check_route;
    }

    @Override
    protected void onInitViewNew() {
        adapter = new CheckRouteAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setVarableId(BR.route);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof CheckRouteBean) {
            CheckRouteBean checkRouteBean = (CheckRouteBean) data;
            adapter.refreshData(checkRouteBean.getO().getDataList());
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
    public void onItemClick(View v, RecyclerView.Adapter adapter, Object data) {
        AddressStatus.saveDefultAddress(data);
        EventBus.getDefault().post(data);
    }
}
