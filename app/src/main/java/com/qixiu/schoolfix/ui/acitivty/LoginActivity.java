package com.qixiu.schoolfix.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.wigit.myedittext.MyEditTextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends RequestActivity {

    @BindView(R.id.edittextId)
    MyEditTextView edittextId;
    @BindView(R.id.ediitextPsw)
    MyEditTextView ediitextPsw;
    @BindView(R.id.btn_login)
    Button btnLogin;

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onInitData() {
        mTitleView.getView().setVisibility(View.GONE);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitViewNew() {
        ediitextPsw.getEdittextView().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() != 0) {
                    btnLogin.setEnabled(true);
                    btnLogin.setTextColor(getResources().getColor(R.color.white));
                } else {
                    btnLogin.setEnabled(false);
                    btnLogin.setTextColor(getResources().getColor(R.color.login_btn_unable));
                }
            }
        });
    }

    @Override
    protected void setStatebar(int color) {
//        super.setStatebar(color);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof LoginBean) {
            LoginBean bean = (LoginBean) data;
            Gson gson=new Gson();
            String loginStr = gson.toJson(bean);
            LoginStatus.saveData(loginStr);
            LoginStatus.setLoginBean();
            Preference.put(ConstantString.USERID, bean.getO().getId());
            Preference.put(ConstantString.USERNAME, bean.getO().getUserName());
            Preference.put(ConstantString.CODE, bean.getO().getUserName());
            Preference.put(ConstantString.REPAIR_BUSINESS_NAME, bean.getO().getRepairBusinessName());
            Preference.put(ConstantString.REPAIR_BUSINESS_GUID, bean.getO().getRepairBusinessGUID());
            Preference.put(ConstantString.REPAIR_BUSINESS_TEL, bean.getO().getRepairBusinessTel());
            Preference.put(ConstantString.REPAIR_BUSINESS_ADDRESS, bean.getO().getRepairBusinessAddress());
            MainActivity.start(getContext());
            finish();
        }

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    public void login(View view) {
        String id = edittextId.getText().toString().trim();
        String psw = ediitextPsw.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            ToastUtil.toast("请输入账号");
            return;
        }
        if (TextUtils.isEmpty(psw)) {
            ToastUtil.toast("请输入面");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("userName", id);
        map.put("password", psw);
        post(ConstantUrl.loginUrl, map, new LoginBean());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public class LoginBean extends BaseBean<LoginBean.ResultBean> {

        public class ResultBean {
            private String id;
            private String userCode;
            private String userName;
            private String repairBusinessGUID;
            private String repairBusinessName;
            private String repairBusinessTel;
            private String repairBusinessAddress;
            private int userType;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserCode() {
                return userCode;
            }

            public void setUserCode(String userCode) {
                this.userCode = userCode;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getRepairBusinessGUID() {
                return repairBusinessGUID;
            }

            public void setRepairBusinessGUID(String repairBusinessGUID) {
                this.repairBusinessGUID = repairBusinessGUID;
            }

            public String getRepairBusinessName() {
                return repairBusinessName;
            }

            public void setRepairBusinessName(String repairBusinessName) {
                this.repairBusinessName = repairBusinessName;
            }

            public String getRepairBusinessTel() {
                return repairBusinessTel;
            }

            public void setRepairBusinessTel(String repairBusinessTel) {
                this.repairBusinessTel = repairBusinessTel;
            }

            public String getRepairBusinessAddress() {
                return repairBusinessAddress;
            }

            public void setRepairBusinessAddress(String repairBusinessAddress) {
                this.repairBusinessAddress = repairBusinessAddress;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }
        }
    }
}
