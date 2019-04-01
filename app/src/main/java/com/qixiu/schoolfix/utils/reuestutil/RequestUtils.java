package com.qixiu.schoolfix.utils.reuestutil;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.qixiu.qixiu.request.OKHttpUIUpdataListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.ErrorBeanOne;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.schoolfix.constant.ConstantString;

import java.io.IOException;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/11/22.
 */

public class RequestUtils {
    public static String header01 = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMDAxIiwianRpIjoiN2UyNDY2MWMtOTAwOC00YTM3LWIzMmUtM2ZjOTg3ODM1M2VmIiwiaWF0IjoxNTQyNjgzNDI1LCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJhZG1pbiIsIm5iZiI6MTU0MjY4MzQyNSwiZXhwIjoyMTQyNjgzMzY1LCJpc3MiOiJNeUFCUFZ1ZUNvcmUiLCJhdWQiOiJNeUFCUFZ1ZUNvcmUifQ.cdxYfBH8r7GmlEPGzrKX_GI3XARv2Y94AgJno8EEMd0";
    public static String header02 = "XMLHttpRequest";
    public static Exception exception;


    public static String getHeader01() {
        return header01;
    }

    public static void setHeader01(String header01) {
        RequestUtils.header01 = header01;
    }

    public static String getHeader02() {
        return header02;
    }

    public static void setHeader02(String header02) {
        RequestUtils.header02 = header02;
    }

    public static OkHttpClient okHttpClient = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void okPost(String url, Map<String, String> map, BaseBean baseBean, OKHttpUIUpdataListener listener, Activity activity) {
        Gson gson = new Gson();
        String json = gson.toJson(map);
        baseBean.setUrl(url);
        if (map.keySet().size() == 0) {
            json = "{}";
        }
        post(url, json, baseBean, listener, activity);
    }


    public static void post(String url, String json, BaseBean baseBean, OKHttpUIUpdataListener listener, Activity activity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                exception = null;
                //业务内容
                RequestBody body = RequestBody.create(JSON, json);
                Request request = new Request.Builder()
                        .addHeader("Authorization", header01)
                        .addHeader("X-Requested-With", header02)
                        .addHeader("YdmSessionId", (Preference.get(ConstantString.USERID, "")))
                        .url(url)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {

                    } else {
                        exception = new IOException("Unexpected code " + response);
                    }

                    if (exception == null) {
                        if (response.isSuccessful()) {
                            String result = null;
                            try {
                                result = response.body().string();
                                Log.e("data", result);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            //这个地方进行解析
                            Gson gson = new Gson();
                            try {
                                BaseBean resultBean = gson.fromJson(result, baseBean.getClass());
                                resultBean.setUrl(url);
                                if (!resultBean.getC()) {
                                    ErrorBeanOne errorBeanOne = gson.fromJson(result, ErrorBeanOne.class);
                                    listener.onFailure(errorBeanOne);
                                    Log.e("step", "有结果失败" + errorBeanOne.getM());
                                } else {
                                    listener.onSuccess(resultBean, 0);
                                    Log.e("step", "有结果成功");
                                }
                            } catch (Exception e) {
                                try {
                                    ErrorBeanOne errorBeanOne = gson.fromJson(result, ErrorBeanOne.class);
                                    listener.onFailure(errorBeanOne);
                                } catch (Exception e0) {
                                    try {

                                    } catch (Exception e2) {

                                    }
                                }
                            }
                        }
                    } else {
                        listener.onError(null, exception, 0);
                        Log.e("step", exception.toString());
                    }
                } catch (IOException e) {
                    exception = e;
                    Log.e("step", exception.toString());
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void get(String url, OKHttpUIUpdataListener listener) {
        Request request = new Request.Builder()
                .addHeader("Authorization", header01)
                .addHeader("X-Requested-With", header02)
                .url(url).get().build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {

            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
