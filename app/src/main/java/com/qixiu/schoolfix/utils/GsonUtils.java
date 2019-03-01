package com.qixiu.schoolfix.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class GsonUtils<T> {
    static GsonUtils gsonUtils;

    public static GsonUtils builder() {
        if (gsonUtils == null) {
            gsonUtils = new GsonUtils();
        }
        return gsonUtils;
    }

    /**
     * 解析有数据头的纯数组
     */
    public List<T> parseHaveHeaderJArray(String json,T t) {
        //拿到本地JSON 并转成String
        //再转JsonArray 加上数据头
        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();

        Gson gson = new Gson();
        ArrayList<T> datas = new ArrayList<>();

        //循环遍历
        for (JsonElement user : jsonArray) {
            //通过反射 得到UserBean.class
             t = gson.fromJson(user, new TypeToken<T>() {
            }.getType());
            datas.add(t);
        }
        return datas;
    }

}
