package com.qixiu.schoolfix.ui.acitivty.work_flow.details;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.RequestMaker;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.ui.acitivty.work_flow.report.ReportActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.sign.ServiceProgressActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.sign.SignWorkActivity;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.widget.LineControllerView;
import com.qixiu.wigit.picker.MyPopOneListPicker;
import com.qixiu.wigit.picker.SelectedDataBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.qixiu.schoolfix.constant.ConstantUrl.transferOrderUrl;

public class HardWorkDetailsActivity extends RequestActivity {
    public static final String ORDER_WATING = "待派单";//工单状态(1,待接单;2,待派单;3,已派单;4,服务中;5,完成;6,作废)
    public static final String ORDER_RELEASE = "已派单";//工单状态(1,待接单;2,待派单;3,已派单;4,服务中;5,完成;6,作废)
    public static final String ORDER_PROCESSING = "服务中";//工单状态(1,待接单;2,待派单;3,已派单;4,服务中;5,完成;6,作废)
    public static final String ORDER_COMPLETE = "完成";//工单状态(1,待接单;2,待派单;3,已派单;4,服务中;5,完成;6,作废)
    public static final String ORDER_DELETE = "作废";//工单状态(1,待接单;2,待派单;3,已派单;4,服务中;5,完成;6,作废)


    @BindView(R.id.iamgeViewProduct)
    ImageView iamgeViewProduct;
    @BindView(R.id.textViewProductName)
    TextView textViewProductName;
    @BindView(R.id.textViewMechineCode)
    LineControllerView textViewMechineCode;
    @BindView(R.id.textViewDeviceCode)
    LineControllerView textViewDeviceCode;
    @BindView(R.id.textViewServiceObject)
    LineControllerView textViewServiceObject;
    @BindView(R.id.textViewDepartName)
    LineControllerView textViewDepartName;
    @BindView(R.id.textViewCity)
    LineControllerView textViewCity;
    @BindView(R.id.textViewAddress)
    LineControllerView textViewAddress;
    @BindView(R.id.textViewContactPerson)
    LineControllerView textViewContactPerson;
    @BindView(R.id.textViewContactPhone)
    LineControllerView textViewContactPhone;
    @BindView(R.id.textViewExpectTime)
    LineControllerView textViewExpectTime;
    @BindView(R.id.textViewHandelPerson)
    LineControllerView textViewHandelPerson;
    @BindView(R.id.textViewTicketNumber)
    LineControllerView textViewTicketNumber;
    @BindView(R.id.textViewCommitTime)
    LineControllerView textViewCommitTime;
    @BindView(R.id.lineearLayoutSignOrFinish)
    LinearLayout lineearLayoutSignOrFinish;
    @BindView(R.id.lineGotoReport)
    LineControllerView lineGotoReport;
    @BindView(R.id.linearHardworeMessage)
    LinearLayout linearHardworeMessage;
    private String id;
    private WorkDetailsBean workDetailsBean;

    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("工单详情");
        mTitleView.setRightText("申请转交");
        mTitleView.getRightText().setBackgroundResource(R.drawable.shape_text_title);
        mTitleView.getRightText().setTextColor(getResources().getColor(R.color.theme_color));
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRepairPerson();
            }
        });
    }

    private void showRepairPerson() {
        Map<String, String> map = new HashMap<>();
        map.put("repairBusinessGUID", workDetailsBean.getO().getRepairBusinessGUID());
        RequestBean request = RequestMaker.getRequest(map);
        request.setOrder("UserName asc");
        post(ConstantUrl.repairPersonUrl, request, new RepairPersonBean());
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof WorkDetailsBean) {
            workDetailsBean = (WorkDetailsBean) data;
            if (workDetailsBean.getO().getDeviceType() == 1) {//设备类型(1,软件;2,硬件)
                linearHardworeMessage.setVisibility(View.GONE);
            } else {
                linearHardworeMessage.setVisibility(View.VISIBLE);
            }
            if (workDetailsBean.getO().getWorkOrderTypeStr().equals(ORDER_WATING) ||
                    workDetailsBean.getO().getWorkOrderTypeStr().equals(ORDER_COMPLETE) ||
                    workDetailsBean.getO().getWorkOrderTypeStr().equals(ORDER_DELETE)) {
                lineearLayoutSignOrFinish.setVisibility(View.GONE);
                lineGotoReport.setEnabled(false);
                mTitleView.setRightTextVisible(View.GONE);
            }
            Glide.with(getContext()).load(workDetailsBean.getO().getProductImgUrl()).into(iamgeViewProduct);
            textViewProductName.setText(workDetailsBean.getO().getProductName());
            textViewMechineCode.setSecondaryText(workDetailsBean.getO().getDeviceMachineCode());
            textViewDeviceCode.setSecondaryText(workDetailsBean.getO().getDeviceCode());
            textViewServiceObject.setSecondaryText(workDetailsBean.getO().getSchoolUnitServiceName());
            textViewDepartName.setSecondaryText(workDetailsBean.getO().getWorkOrderSubmitUnit());

            textViewContactPerson.setSecondaryText(workDetailsBean.getO().getWorkOrderSubmitName());
            textViewContactPhone.setSecondaryText(workDetailsBean.getO().getWorkOrderSubmitTel());
            textViewAddress.setSecondaryText(workDetailsBean.getO().getSchoolUnitAddress());
            textViewCity.setSecondaryText(workDetailsBean.getO().getSchoolUnitArea());
            try {
                textViewExpectTime.setSecondaryText(workDetailsBean.getO().getWorkOrderExpectTime().substring(5, workDetailsBean.getO().getWorkOrderExpectTime().length()) + "至" +
                        workDetailsBean.getO().getWorkOrderExpectEndTime().substring(10, workDetailsBean.getO().getWorkOrderExpectEndTime().length()));
            } catch (Exception e) {

            }
            textViewHandelPerson.setSecondaryText(workDetailsBean.getO().getRepairUserName());
            textViewTicketNumber.setSecondaryText(workDetailsBean.getO().getWorkOrderServiceNo());
            textViewCommitTime.setSecondaryText(workDetailsBean.getO().getWorkOrderCreatime());


        }

        if (data instanceof RepairPersonBean) {
            RepairPersonBean repairPersonBean = (RepairPersonBean) data;
            List<SelectedDataBean> datas = new ArrayList<>();
            for (int i = 0; i < repairPersonBean.getO().getDataList().size(); i++) {
                SelectedDataBean selectedDataBean = new SelectedDataBean(repairPersonBean.getO().getDataList().get(i).getId(),
                        repairPersonBean.getO().getDataList().get(i).getUserName());
                selectedDataBean.setData(repairPersonBean.getO().getDataList().get(i));
                datas.add(selectedDataBean);
            }
            MyPopOneListPicker picker = new MyPopOneListPicker(getContext(), datas, new MyPopOneListPicker.Pop_selectedListenner() {
                @Override
                public void getData(SelectedDataBean data) {
                    Map<String, String> map = new HashMap();
                    map.put("workOrderGUID", workDetailsBean.getO().getId());
                    map.put("oldReceiveUserGUID", LoginStatus.getLoginBean().getO().getId());
                    map.put("newReceiveUserGUID", data.getId());
                    post(transferOrderUrl, map, new BaseBean());
                }
            });
            picker.setTitle("选择转交人");
            picker.show();
        }
        if (data.getUrl().equals(transferOrderUrl)) {
            ToastUtil.toast("转交成功");
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
    protected void onStart() {
        super.onStart();
        id = getIntent().getStringExtra(IntentDataKeyConstant.DATA);
        post(ConstantUrl.workDetailsUrl + id, new HashMap(), new WorkDetailsBean());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_hard_work_details;
    }

    //完成
    public void completeWork(View view) {
        ServiceProgressActivity.start(getContext(), ServiceProgressActivity.class, workDetailsBean.getO());
    }


    //签到
    @OnClick({R.id.textViewGotoSign})
    public void signWork(View view) {
        SignWorkActivity.start(getContext(), SignWorkActivity.class, workDetailsBean.getO());
    }


    //去填写问题
    public void gotoProblem(View view) {
        Preference.put(ConstantString.FROM_WHERE, "DETAILS");
        ReportActivity.start(getContext(), ReportActivity.class, workDetailsBean.getO());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
