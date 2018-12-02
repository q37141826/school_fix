package com.qixiu.schoolfix.utils;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.ui.acitivty.LoginActivity;


/**
 * Created by Long on 2018/4/26
 */
public final class LoginStatus {

    private static LoginStatus instance = new LoginStatus();
    private static LoginActivity.LoginBean loginBean;
    /*是否已登录*/
    private volatile boolean logged;
    private String token;

    public static LoginActivity.LoginBean getLoginBean() {
        String loginStr = Preference.get(ConstantString.USERBEAN, "");
        Gson gson = new Gson();
        LoginStatus.loginBean = gson.fromJson(loginStr, LoginActivity.LoginBean.class);
        return loginBean;
    }

    public static void setLoginBean() {
        String loginStr = Preference.get(ConstantString.USERBEAN, "");
        Gson gson = new Gson();
        LoginStatus.loginBean = gson.fromJson(loginStr, LoginActivity.LoginBean.class);
    }

    public static boolean isLogged() {
        return !TextUtils.isEmpty(Preference.get(ConstantString.USERID, ""));
    }

    @Nullable
    public static String getToken() {
        return Preference.get(ConstantString.USERID, "");//测试的时候改变一下这个地方
    }

//    /*登录成功*/
//    public static void logged(LoginBean loginBean) {
//        Preference.put(ConstantString.USERID,loginBean.getO().getId());
//        Preference.put(ConstantString.NICK_NAME,loginBean.getO().getTrue_name());
//        Preference.put(ConstantString.TRUE_NAME,loginBean.getO().getTrue_name());
//        Preference.put(ConstantString.HEAD,loginBean.getO().getHead());
//        Preference.put(ConstantString.PHONE,loginBean.getO().getPhone());
//        Preference.put(ConstantString.EMAIL,loginBean.getO().getEmlia());
//    }

    /*退出登录*/
    public static void logout() {
        instance.logged = false;
        instance.token = null;
        Preference.clearAllFlag();
        Preference.putBoolean(ConstantString.IS_FIRST_LOGIN, true);
    }


}
