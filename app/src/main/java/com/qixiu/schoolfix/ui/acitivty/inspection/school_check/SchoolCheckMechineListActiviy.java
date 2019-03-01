package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qixiu.qixiu.google.zxing.client.android.CaptureActivity;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
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


    @BindView(R.id.xrecyclerView)
    XRecyclerView xrecyclerView;
    SchoolCheckAdapter adapter;
    private CheckMainSchoolBean.ResultBean.DataListBean dataListBean;
    private CheckMechineBean checkMechineBean;

    @Override
    protected void onInitData() {
        dataListBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);

        mTitleView.setTitle("检查学校名称");
        mTitleView.setRightImage(getContext(), R.drawable.tab_btn_sma);
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //扫描
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, CaptureActivity.ZXING_INTENT);//todo 鲜花扫描后的UI  以后再打开这里
//                CheckInputStyleOneActivity.start(getContext(), CheckInputStyleOneActivity.class);
            }
        });
        if (!Preference.getBoolean(ConstantString.IS_EDIBLE)) {
            mTitleView.setRightTextVisible(View.GONE);
        }
        getData();
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

        //制造假数据
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
        if (data instanceof CheckMechineBean) {
            checkMechineBean = (CheckMechineBean) data;
            adapter.refreshData(checkMechineBean.getO().getDataList());
            gotoInput(checkMechineBean);//跳转检查填写界面
        }
        if (data.getUrl().equals(ConstantUrl.updateMechineUrl)) {
            getData();
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
        if (gotoInput) {
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
            String code = data.getStringExtra(CaptureActivity.ZXING_VALUE);
            markeMechineData(code);
        }
    }

    private void markeMechineData(String code) {
        String listId = "";
        //先签到，所有的设备都签到OK之后跳转检查页面
        for (int i = 0; i < checkMechineBean.getO().getDataList().size(); i++) {
            if (checkMechineBean.getO().getDataList().get(i).getQrCodeGUID() != null && checkMechineBean.getO().getDataList().get(i).getQrCodeGUID().equals(code)) {
                listId = checkMechineBean.getO().getDataList().get(i).getId();
            }
        }
        if (TextUtils.isEmpty(listId)) {
            ToastUtil.toast("设备不在检查任务内");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("id", listId);
        map.put("checkDeviceRecordTime", TimeDataUtil.getTimeStamp(new Date().getTime(), TimeDataUtil.DEFULT_TIME_FORMAT));
        post(ConstantUrl.updateMechineUrl, map, new BaseBean());
    }

}
