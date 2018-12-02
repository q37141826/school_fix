package com.qixiu.schoolfix.utils.reuestutil;

import com.qixiu.qixiu.request.OKHttpUIUpdataListener;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.schoolfix.BuildConfig;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.model.TokenBean;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by my on 2018/11/23.
 */

public class TokenRequestUtils {

    public static void requestToken(){
        Map<String,String>  map=new HashMap<>();
        map.put("userNameOrEmailAddress", BuildConfig.TOKEN_NAME);
        map.put("password", BuildConfig.TOKEN_PSW);

        RequestUtils.okPost(ConstantUrl.tokenUrl, map, new TokenBean(), new OKHttpUIUpdataListener() {
            @Override
            public void onSuccess(Object data, int i) {
                if(data instanceof TokenBean){
                    TokenBean bean= (TokenBean) data;
                    Preference.put(ConstantString.TOKEN,TokenBean.TOKEN_TAG+bean.getO().getAccessToken());
                    RequestUtils.setHeader01(TokenBean.TOKEN_TAG+bean.getO().getAccessToken());
                }
            }

            @Override
            public void onError(Call call, Exception e, int i) {

            }

            @Override
            public void onFailure(C_CodeBean c_codeBean) {

            }
        }, null);
    }


}
