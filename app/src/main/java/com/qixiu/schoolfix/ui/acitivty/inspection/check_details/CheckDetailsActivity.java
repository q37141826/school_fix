package com.qixiu.schoolfix.ui.acitivty.inspection.check_details;

import android.os.Bundle;
import android.view.View;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.model.check_mechine.MechineDetailsCheckBean;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.widget.LineControllerView;
import com.qixiu.wigit.show_dialog.ArshowContextUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckDetailsActivity extends RequestActivity {


    @BindView(R.id.lineUnitName)
    LineControllerView lineUnitName;
    @BindView(R.id.lineUnitAddress)
    LineControllerView lineUnitAddress;
    @BindView(R.id.lineUnitPhone)
    LineControllerView lineUnitPhone;
    @BindView(R.id.lineProductName)
    LineControllerView lineProductName;
    @BindView(R.id.lineProductBrand)
    LineControllerView lineProductBrand;
    @BindView(R.id.lineProductModule)
    LineControllerView lineProductModule;
    @BindView(R.id.lineDeviceCode)
    LineControllerView lineDeviceCode;
    @BindView(R.id.lineIpAddress)
    LineControllerView lineIpAddress;
    @BindView(R.id.lineAddress)
    LineControllerView lineAddress;
    @BindView(R.id.lineMechineCode)
    LineControllerView lineMechineCode;
    @BindView(R.id.lineApproveTime)
    LineControllerView lineApproveTime;
    @BindView(R.id.lineState)
    LineControllerView lineState;

    @Override
    protected void onInitData() {
        String id = getIntent().getStringExtra(IntentDataKeyConstant.DATA);
        post(ConstantUrl.mechineUrl + id, new HashMap(), new MechineDetailsCheckBean());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_check_details;
    }

    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("机器名称");
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof MechineDetailsCheckBean) {
            MechineDetailsCheckBean bean = (MechineDetailsCheckBean) data;
            lineUnitName.setSecondaryText(bean.getO().getSchoolUnitName());
            lineUnitAddress.setSecondaryText(bean.getO().getSchoolUnitAddress());
            lineUnitPhone.setSecondaryText(bean.getO().getSchoolUnitTel());
            lineProductName.setSecondaryText(bean.getO().getProductName());
            lineProductBrand.setSecondaryText(bean.getO().getProductBrand());
            lineProductModule.setSecondaryText(bean.getO().getProductModel());
            lineDeviceCode.setSecondaryText(bean.getO().getDeviceCode());
            lineIpAddress.setSecondaryText(bean.getO().getDeviceIpAddress());
            lineAddress.setSecondaryText(bean.getO().getDeviceAddress());
            lineAddress.getSecondaryTextView().setPadding(ArshowContextUtil.dp2px(100), 0, 0, 0);
            lineMechineCode.setSecondaryText(bean.getO().getDeviceMachineCode());
            lineApproveTime.setSecondaryText(bean.getO().getModifiedTime());
            lineState.setSecondaryText(bean.getO().getApproveState());

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
}
