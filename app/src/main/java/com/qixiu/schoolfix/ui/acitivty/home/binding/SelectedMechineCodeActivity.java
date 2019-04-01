package com.qixiu.schoolfix.ui.acitivty.home.binding;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.utils.reuestutil.RequestMaker;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.ui.acitivty.home.create_mechine.CreateMechineActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by my on 2018/11/23.
 */

public class SelectedMechineCodeActivity extends RequestActivity implements XRecyclerView.LoadingListener, OnRecyclerItemListener {
    @BindView(R.id.imageViewBack)
    ImageView imageViewBack;
    @BindView(R.id.editextMechineCode)
    EditText editextMechineCode;
    @BindView(R.id.recyclerViewMechineCode)
    XRecyclerView recyclerViewMechineCode;
    //    @BindView(R.id.textViewMechineCode)
//    TextView textViewMechineCode;
//    @BindView(R.id.imageViewSelected)
//    ImageView imageViewSelected;
    private String productGUID;
    private MechineDetailsBean.ResultBean detailsBean;
    private MechineCodeAdapter adapter;
    private MechineCodeListBean mechineCodeListBean;

    @Override
    protected void onInitViewNew() {
        mTitleView.getView().setVisibility(View.GONE);
        XrecyclerViewUtil.setXrecyclerView(recyclerViewMechineCode, this, getContext(), false, 1, null);
        adapter = new MechineCodeAdapter();
        recyclerViewMechineCode.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof MechineCodeListBean) {
            mechineCodeListBean = (MechineCodeListBean) data;
            List<MechineCodeListBean.ResultBean.DataListBean> datas = mechineCodeListBean.getO().getDataList();

            adapter.refreshData(mechineCodeListBean.getO().getDataList());
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
        detailsBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);

    }

    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_mechine_code_selecte;
    }

    public void finish(View view) {
        finish();
    }

    public void createCode(View view) {
        if (mechineCodeListBean.getO().getDataList().size() == 0) {
            ToastUtil.toast("前请联系系统管理员");
            return;
        }
        CreateMechineActivity.start(getContext(), CreateMechineActivity.class, mechineCodeListBean.getO().getDataList().get(0));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }


    @Override
    public void onItemClick(View v, RecyclerView.Adapter adapter, Object data) {
        if (data instanceof MechineCodeListBean.ResultBean.DataListBean) {
            MechineCodeListBean.ResultBean.DataListBean dataListBean = (MechineCodeListBean.ResultBean.DataListBean) data;
            EventBus.getDefault().post(dataListBean);
            finish();
        }
    }

    public void getData() {
        Map<String, String> map = new HashMap<>();
        map.put("productGUID", detailsBean.getProductGUID());
//        map.put("repairBusinessGUID", detailsBean.getRepairBusinessGUID());
        map.put("schoolUnitGUID", detailsBean.getSchoolUnitGUID());
//        RequestBean mechineRequest = RequestMaker.getRequest(map);
        List<String[]> datas = new ArrayList<>();
        String data01[] = {"productGUID", "uniqueidentifier", "eq", detailsBean.getProductGUID()};
        String data02[] = {"schoolUnitGUID", "uniqueidentifier", "eq", detailsBean.getSchoolUnitGUID()};
        String data03[] = {"qrCodeGUID", "uniqueidentifier", "eq", ConstantString.NULL_ID};
        String data04[] = {"approveState", "nvarchar", "eq", "已审批"};
        datas.add(data01);
        datas.add(data02);
        datas.add(data03);
        datas.add(data04);
        RequestBean mechineRequest = RequestMaker.getRequests(datas, "CreateTime desc", "and");
        post(ConstantUrl.mechineCodeList, mechineRequest, new MechineCodeListBean());
    }
}
