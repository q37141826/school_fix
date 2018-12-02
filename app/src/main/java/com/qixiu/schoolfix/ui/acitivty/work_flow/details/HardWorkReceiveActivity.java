package com.qixiu.schoolfix.ui.acitivty.work_flow.details;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequstActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.RequestMaker;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.widget.LineControllerView;
import com.qixiu.wigit.picker.MyPopOneListPicker;
import com.qixiu.wigit.picker.SelectedDataBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.qixiu.schoolfix.constant.ConstantUrl.giveOrderUrl;
import static com.qixiu.schoolfix.ui.acitivty.work_flow.details.HardWorkDetailsActivity.ORDER_WATING;

public class HardWorkReceiveActivity extends RequstActivity {


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
    @BindView(R.id.btnRecice)
    Button btnRecice;
    private String id;
    private WorkDetailsBean workDetailsBean;

    @Override
    protected void onInitData() {
        lineearLayoutSignOrFinish.setVisibility(View.GONE);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_hard_work_receive;
    }

    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("齐科信息");
        id = getIntent().getStringExtra(IntentDataKeyConstant.DATA);
        post(ConstantUrl.workDetailsUrl + id, new HashMap(), new WorkDetailsBean());
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof WorkDetailsBean) {
            workDetailsBean = (WorkDetailsBean) data;
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
            textViewExpectTime.setSecondaryText(workDetailsBean.getO().getWorkOrderExpectTime() .substring(0,10)+ "至" +
                    workDetailsBean.getO().getWorkOrderExpectEndTime().substring(0,10));

            textViewHandelPerson.setSecondaryText(LoginStatus.getLoginBean().getO().getRepairBusinessName());
            textViewTicketNumber.setSecondaryText(workDetailsBean.getO().getWorkOrderServiceNo());
            textViewCommitTime.setSecondaryText(workDetailsBean.getO().getWorkOrderCreatime());

            if (workDetailsBean.getO().getWorkOrderTypeStr().equals(ORDER_WATING)) {
                btnRecice.setText("指派");
            }

        }
        if (data.getUrl().equals(ConstantUrl.receiveUrl)) {
            ToastUtil.toast(mTitleView.getTitle()+"成功");
            finish();
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
                    map.put("id", workDetailsBean.getO().getId());
                    map.put("repairUserGUID", data.getId());
                    map.put("workOrderAssignTime", TimeDataUtil.getTimeStamp(new Date().getTime(), TimeDataUtil.DEFULT_TIME_FORMAT));
                    map.put("workOrderType", "已派单");
                    post(giveOrderUrl, map, new BaseBean());
                }
            });
            picker.setTitle("选择指派人");
            picker.show();
        }
//        if(giveOrderUrl.equals(data.getUrl())){
//            ToastUtil.toast("指派成功");
//        }

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

    public void receive(View view) {
        if (workDetailsBean.getO().getWorkOrderTypeStr().equals(ORDER_WATING)) {
            showRepairPerson();
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("id", workDetailsBean.getO().getId());
            map.put("serviceUserGUID", LoginStatus.getLoginBean().getO().getId());
            map.put("workOrderReceiveTime", TimeDataUtil.getTimeStamp(new Date().getTime(), "yyyy-MM-dd HH:mm:ss"));
            map.put("workOrderType", "待派单");
            post(ConstantUrl.receiveUrl, map, new BaseBean<>());
        }
//
    }

    private void showRepairPerson() {
        Map<String, String> map = new HashMap<>();
        map.put("repairBusinessGUID", workDetailsBean.getO().getRepairBusinessGUID());
        RequestBean request = RequestMaker.getRequest(map);
        request.setOrder("UserName asc");
        post(ConstantUrl.repairPersonUrl, request, new RepairPersonBean());
    }
}
