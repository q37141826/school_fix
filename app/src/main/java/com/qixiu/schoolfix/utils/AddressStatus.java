package com.qixiu.schoolfix.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.schoolfix.model.check_mechine.CheckRouteBean;

public class AddressStatus {
    private static Gson gson;
    private static final String ADRESS = "ADRESS";

    public static void saveDefultAddress(Object data) {
        Gson gson = getGson();
        String addressJson = gson.toJson(data);
        Preference.put(ADRESS, addressJson);
    }

    private static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static CheckRouteBean.ResultBean.DataListBean getDefultAddress() {
        String addressJson = Preference.get(ADRESS, "");
        if (TextUtils.isEmpty(addressJson)) {
            return null;
        } else {
            return getGson().fromJson(addressJson, CheckRouteBean.ResultBean.DataListBean.class);
        }

    }

}
