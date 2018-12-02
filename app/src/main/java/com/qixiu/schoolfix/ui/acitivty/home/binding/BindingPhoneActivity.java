package com.qixiu.schoolfix.ui.acitivty.home.binding;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
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

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A login screen that offers login via email/password.
 */
public class BindingPhoneActivity extends RequstActivity {


    @BindView(R.id.lineCompanyName)
    LineControllerView lineCompanyName;
    @BindView(R.id.lineServiceName)
    LineControllerView lineServiceName;
    @BindView(R.id.linePhone)
    LineControllerView linePhone;
    @BindView(R.id.lineAddress)
    LineControllerView lineAddress;
    @BindView(R.id.lineProductName)
    LineControllerView lineProductName;
    @BindView(R.id.lineMechineCode)
    LineControllerView lineMechineCode;
    @BindView(R.id.lineMechineAddress)
    LineControllerView lineMechineAddress;
    @BindView(R.id.lineBuyDate)
    LineControllerView lineBuyDate;
    @BindView(R.id.lineLimitYear)
    LineControllerView lineLimitYear;
    @BindView(R.id.lineRepairPeriod)
    LineControllerView lineRepairPeriod;
    @BindView(R.id.lineNetIP)
    LineControllerView lineNetIP;
    @BindView(R.id.lineMaintenance)
    LineControllerView lineMaintenance;
    @BindView(R.id.lineMaintainPhone)
    LineControllerView lineMaintainPhone;
    @BindView(R.id.lineMaintainAddress)
    LineControllerView lineMaintainAddress;
    @BindView(R.id.btnBinding)
    Button btnBinding;
    private MechineDetailsBean mechineDetailsBean;
    private MechineCodeListBean.ResultBean.DataListBean selectedData;
    private String mechineId;

    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("扫描绑定");
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof MechineDetailsBean) {
            mechineDetailsBean = (MechineDetailsBean) data;

            //如果 没有设备ID那么就是需要绑定的，否则就是需要解绑的
            if (TextUtils.isEmpty(mechineDetailsBean.getO().getDeviceGUID())) {
                mTitleView.setTitle("扫描绑定");
                btnBinding.setText("绑定");
            } else {
                btnBinding.setText("解除绑定");
                mTitleView.setTitle("解除绑定");
                lineMaintenance.setEnabled(false);
                lineMechineCode.setEnabled(false);
            }
            lineCompanyName.setSecondaryText(mechineDetailsBean.getO().getSchoolUnitName());
            lineAddress.setSecondaryText(mechineDetailsBean.getO().getSchoolUnitAddress());
            linePhone.setSecondaryText(mechineDetailsBean.getO().getSchoolUnitTel());
            lineProductName.setSecondaryText(mechineDetailsBean.getO().getProductName());



            lineMaintainAddress.setSecondaryText(LoginStatus.getLoginBean().getO().getRepairBusinessAddress());
            lineMaintainPhone.setSecondaryText(LoginStatus.getLoginBean().getO().getRepairBusinessTel());
            lineMaintenance.setSecondaryText(LoginStatus.getLoginBean().getO().getRepairBusinessName());

            mechineDetailsBean.getO().setRepairBusinessGUID(LoginStatus.getLoginBean().getO().getRepairBusinessGUID());

            if(!TextUtils.isEmpty(mechineDetailsBean.getO().getDeviceGUID())){
                lineMechineCode.setSecondaryText(mechineDetailsBean.getO().getDeviceMachineCode());
                lineProductName.setSecondaryText(mechineDetailsBean.getO().getProductName());
                lineMechineAddress.setSecondaryText(mechineDetailsBean.getO().getDeviceAddress());
                lineBuyDate.setSecondaryText(mechineDetailsBean.getO().getDeviceBuyDate());
                lineLimitYear.setSecondaryText(mechineDetailsBean.getO().getDeviceNotUseYears() + "");
                lineRepairPeriod.setSecondaryText(mechineDetailsBean.getO().getDeviceRepairBeginDate().substring(0,10)
                        + "至" + mechineDetailsBean.getO().getDeviceRepairEndDate().substring(0,10));
                lineNetIP.setSecondaryText(mechineDetailsBean.getO().getDeviceIpAddress());
            }
        }

        if (data instanceof RepairCompanyBean) {
            RepairCompanyBean bean = (RepairCompanyBean) data;
            List<SelectedDataBean> datas = new ArrayList<>();
            for (int i = 0; i < bean.getO().getDataList().size(); i++) {
                RepairCompanyBean.ResultBean.DataListBean dataListBean = bean.getO().getDataList().get(i);
                SelectedDataBean selectedDataBean = new SelectedDataBean(dataListBean.getRepairBusinessGUID(), dataListBean.getRepairBusinessName());
                selectedDataBean.setData(dataListBean);
                datas.add(selectedDataBean);
            }
            MyPopOneListPicker picker = new MyPopOneListPicker(getContext(), datas, new MyPopOneListPicker.Pop_selectedListenner() {
                @Override
                public void getData(SelectedDataBean data) {
                    mechineDetailsBean.getO().setRepairBusinessGUID(data.getId());
                    RepairCompanyBean.ResultBean.DataListBean dataListBean = (RepairCompanyBean.ResultBean.DataListBean) data.getData();
                    lineMaintainAddress.setSecondaryText(dataListBean.getRepairBusinessAddress());
                    lineMaintenance.setSecondaryText(dataListBean.getRepairBusinessName());
                    lineMaintainPhone.setSecondaryText(dataListBean.getRepairBusinessTel());
                }
            });
            picker.show();
        }

        if (ConstantUrl.bindingUrl.equals(data.getUrl())) {
            if (btnBinding.getText().toString().equals("解除绑定")) {
                ToastUtil.toast("解绑成功");
            } else {
                ToastUtil.toast("绑定成功");
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
        mechineId = getIntent().getStringExtra(IntentDataKeyConstant.DATA);
        Map<String, String> map = new HashMap<>();
        post(ConstantUrl.mechineDetailsUrl + "?id=" + mechineId, map, new MechineDetailsBean());
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_binding_phone;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void binding(View view) {
        Map<String, String> map = new HashMap<>();
        if (btnBinding.getText().toString().equals("解除绑定")) {
            map.put("qrCodeGUID", "00000000-0000-0000-0000-000000000000");
            map.put("id", mechineDetailsBean.getO().getDeviceGUID());

        } else {
            if (selectedData == null) {
                ToastUtil.toast("请先选择设备码");
                return;
            }
            map.put("qrCodeGUID", mechineDetailsBean.getO().getId());
            map.put("id", selectedData.getId());
        }
        post(ConstantUrl.bindingUrl, map, new BaseBean());
    }

    public void cancle(View view) {

    }


    public void selectCode(View view) {
        try {
            SelectedMechineCodeActivity.start(getContext(), SelectedMechineCodeActivity.class, mechineDetailsBean.getO());
        } catch (Exception e) {
            SelectedMechineCodeActivity.start(getContext(), SelectedMechineCodeActivity.class);
        }
    }

    public void selectRepairCompany(View view) {
        Map<String, String> map = new HashMap<>();
        map.put("schoolUnitGUID", mechineDetailsBean.getO().getSchoolUnitGUID());
        RequestBean mechineRequest = RequestMaker.getRequest(map);
        post(ConstantUrl.getRepairCompanyList, mechineRequest, new RepairCompanyBean());
    }


    @Subscribe
    public void getMechineCodeEvent(MechineCodeListBean.ResultBean.DataListBean dataListBean) {
        lineMechineCode.setSecondaryText(dataListBean.getDeviceMachineCode());
        lineProductName.setSecondaryText(dataListBean.getProductName());
        lineMechineAddress.setSecondaryText(dataListBean.getDeviceAddress());
        lineBuyDate.setSecondaryText(dataListBean.getDeviceBuyDate());
        lineLimitYear.setSecondaryText(dataListBean.getDeviceNotUseYears() + "");
        lineRepairPeriod.setSecondaryText(dataListBean.getDeviceRepairBeginDate().substring(0,10)
                + "至" + dataListBean.getDeviceRepairEndDate().substring(0,10));
        lineNetIP.setSecondaryText(dataListBean.getDeviceIpAddress());
        selectedData = dataListBean;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}

