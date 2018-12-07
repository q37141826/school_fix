package com.qixiu.schoolfix.ui.acitivty.mine;

import android.view.View;

import com.qixiu.qixiu.application.AppManager;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.ui.acitivty.LoginActivity;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;

public class SettingActivity extends RequestActivity {


    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("设置");
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onInitData() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_setting;
    }



    public void gotoChangePsw(View view) {
        ChanngePasswordActivity.start(getContext(),ChanngePasswordActivity.class);
    }

    public void outLogin(View view) {
        Preference.clearAllFlag();
        AppManager.getAppManager().finishAllActivity();
        LoginActivity.start(getContext());
    }

    @Override
    public void onSuccess(BaseBean data) {

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }
}
