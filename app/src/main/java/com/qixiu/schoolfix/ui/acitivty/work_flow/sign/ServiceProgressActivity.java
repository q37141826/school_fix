package com.qixiu.schoolfix.ui.acitivty.work_flow.sign;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.qixiu.qixiu.application.AppManager;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequstActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.details.HardWorkDetailsActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.details.WorkDetailsBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceProgressActivity extends RequstActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    ServiceAdapter adapter;
    private WorkDetailsBean.ResultBean resultBean;
    String timeFormat = "yyyy-MM-dd HH:mm:ss";

    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("服务进度");
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ServiceAdapter();
        recyclerview.setAdapter(adapter);
        resultBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);

        List<TimeAddressBean> datas = new ArrayList<>();
        TimeAddressBean addressBean = new TimeAddressBean();
        addressBean.setAddress(resultBean.getWorkOrderSubmitName() + "创建了工单，工单编号" + resultBean.getWorkOrderServiceNo());
        addressBean.setBtnVisble(false);
        addressBean.setTime(resultBean.getCreateTime());
        addressBean.setTitleText("发起工单");
        datas.add(addressBean);
        addressBean = new TimeAddressBean();
        addressBean.setAddress(resultBean.getRepairUserName() + "接收了工单，工单编号" + resultBean.getWorkOrderServiceNo());
        addressBean.setBtnVisble(false);
        addressBean.setTitleText("客服接单");
        addressBean.setTime(resultBean.getWorkOrderAssignTime());
        datas.add(addressBean);
        if (!TextUtils.isEmpty(resultBean.getWorkOrderSignOutTime())) {
            addressBean = new TimeAddressBean();
            addressBean.setAddress(resultBean.getRepairUserName() + "提交了工单，工单编号" + resultBean.getWorkOrderServiceNo());
            addressBean.setBtnVisble(true);
            addressBean.setBtnText("服务完成");
            addressBean.setTime(resultBean.getWorkOrderSignOutTime());
            addressBean.setTitleText("指派技术人员");
            datas.add(addressBean);
        }
        adapter.refreshData(datas);
        adapter.setClickListenner(new RecyclerBaseAdapter.ClickListenner() {
            @Override
            public void click(View view, Object o) {
                Map<String, String> map = new HashMap<>();
                map.put("id", resultBean.getId());
                map.put("workOrderRepairIsConfirmFinish", "1");
                post(ConstantUrl.completeWorkUrl, map, new BaseBean());
            }
        });
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data.getUrl().equals(ConstantUrl.completeWorkUrl)) {
            ToastUtil.toast("完成工单");
            try {
                AppManager.getAppManager().finishActivity(HardWorkDetailsActivity.class);
            } catch (Exception e) {

            }
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

    @Override
    protected void onInitData() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_work;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
