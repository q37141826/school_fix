package com.qixiu.qixiu.request;


import android.util.Log;

import com.google.gson.Gson;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.zhy.http.okhttp.builder.OkHttpRequestBuilder;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.ref.WeakReference;

import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class OKHttpExecutor {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public    final static String header01 = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMDAxIiwianRpIjoiN2UyNDY2MWMtOTAwOC00YTM3LWIzMmUtM2ZjOTg3ODM1M2VmIiwiaWF0IjoxNTQyNjgzNDI1LCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJhZG1pbiIsIm5iZiI6MTU0MjY4MzQyNSwiZXhwIjoyMTQyNjgzMzY1LCJpc3MiOiJNeUFCUFZ1ZUNvcmUiLCJhdWQiOiJNeUFCUFZ1ZUNvcmUifQ.cdxYfBH8r7GmlEPGzrKX_GI3XARv2Y94AgJno8EEMd0";
    public   final static String header02="XMLHttpRequest";
    public static void okHttpExecut(BaseBean baseBean, OkHttpRequestBuilder okHttpRequestBuilder, OKHttpUIUpdataListener okHttpUIUpdataListener) {
        okHttpRequestBuilder.addHeader("Content-Type", "application/json");
        okHttpRequestBuilder.addHeader("Authorization",header01);//todo 验证请求头是否正确
        okHttpRequestBuilder.addHeader("X-Requested-With", header02);//todo 验证请求头是否正确
//        okHttpRequestBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");



        okHttpRequestBuilder.build().execute(new OKHttpExecutorCallback(baseBean, okHttpUIUpdataListener));
    }


    public static class OKHttpExecutorCallback extends StringCallback {

        private final WeakReference<OKHttpUIUpdataListener> mOkHttpUIUpdataListenerWeakReference;
        private final BaseBean baseBean;


        public OKHttpExecutorCallback(BaseBean baseBean, OKHttpUIUpdataListener okHttpUIUpdataListener) {

            mOkHttpUIUpdataListenerWeakReference = new WeakReference<>(okHttpUIUpdataListener);
            this.baseBean = baseBean;
        }

//        @Override
//        public void onError(Call call, Exception e, int i) {
//
//
//        }

        @Override
        public void onError(okhttp3.Call call, Exception e, int i) {
            Log.e("LOGCAT", e.getMessage());
            OKHttpUIUpdataListener okHttpUIUpdataListener = mOkHttpUIUpdataListenerWeakReference.get();
            if (okHttpUIUpdataListener != null) {
                okHttpUIUpdataListener.onError(call, e, i);
            }
        }

        @Override
        public void onResponse(String s, int i) {
            Log.e("data", s);
            OKHttpUIUpdataListener okHttpUIUpdataListener = mOkHttpUIUpdataListenerWeakReference.get();
            if (okHttpUIUpdataListener != null && baseBean != null) {
                Gson gson = new Gson();
                C_CodeBean c_codeBean = gson.fromJson(s, C_CodeBean.class);
                c_codeBean.setUrl(baseBean.getUrl());
                Log.e("dataUrl", (baseBean.getUrl()));
                if (c_codeBean.getC() ==true) {
                    try {
                        BaseBean resultBean = gson.fromJson(s, baseBean.getClass());
                        resultBean.setUrl(baseBean.getUrl());
                        okHttpUIUpdataListener.onSuccess(resultBean, i);

                    } catch (Exception e) {

                        okHttpUIUpdataListener.onSuccess(c_codeBean, i);
                    }
                } else {
                    okHttpUIUpdataListener.onFailure(c_codeBean);

                }
            }

        }
    }
}
