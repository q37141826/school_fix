package com.qixiu.schoolfix.ui.acitivty.mine;

import android.text.TextUtils;
import android.view.View;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.ui.acitivty.LoginActivity;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.wigit.myedittext.MyEditTextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class ChanngePasswordActivity extends RequestActivity {

    @BindView(R.id.ediitextOriginPsw)
    MyEditTextView ediitextOriginPsw;
    @BindView(R.id.ediitextNewPsw)
    MyEditTextView ediitextNewPsw;
    @BindView(R.id.ediitextRepeatPsw)
    MyEditTextView ediitextRepeatPsw;

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
        return R.layout.activity_channge_password;
    }

    public void resetPsw(View view) {
        String oldPsw = ediitextOriginPsw.getText().toString().trim();
        String newPsw = ediitextNewPsw.getText().toString().trim();
        String repeatPsw = ediitextRepeatPsw.getText().toString().trim();
        if (TextUtils.isEmpty(oldPsw)) {
            ToastUtil.toast("请输入原密码");
            return;
        }
        if (TextUtils.isEmpty(newPsw)) {
            ToastUtil.toast("请输入新密码");
            return;
        }
        if (TextUtils.isEmpty(repeatPsw)) {
            ToastUtil.toast("请再次输入新密码");
            return;
        }
        if (!repeatPsw.equals(newPsw)) {
            ToastUtil.toast("两次密码不一致");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("password", newPsw);
        map.put("oldPassword", oldPsw);
        map.put("id",LoginStatus.getLoginBean().getO().getId());
        post(ConstantUrl.changePswUrl, map, new BaseBean());
    }

    @Override
    public void onSuccess(BaseBean data) {
        ToastUtil.toast("修改成功");
        LoginActivity.start(getContext());
        finish();
    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }
}
