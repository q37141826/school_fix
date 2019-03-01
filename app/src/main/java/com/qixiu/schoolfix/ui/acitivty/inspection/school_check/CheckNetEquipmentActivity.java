package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.view.View;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;

public class CheckNetEquipmentActivity extends RequestActivity {


    @Override
    public void onSuccess(BaseBean data) {
        mTitleView.setTitle("网络设备—检测");
        mTitleView.setRightText("测试");
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckInputHouseActivity.start(getContext(),CheckInputHouseActivity.class);
            }
        });
    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    @Override
    protected void onInitViewNew() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onInitData() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_check_net_equipment;
    }
}
