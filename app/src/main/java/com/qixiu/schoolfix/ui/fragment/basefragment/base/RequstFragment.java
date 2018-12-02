package com.qixiu.schoolfix.ui.fragment.basefragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.gson.Gson;
import com.qixiu.qixiu.request.OKHttpRequestModel;
import com.qixiu.qixiu.request.OKHttpUIUpdataListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.model.BaseRequestIntef;
import com.qixiu.schoolfix.utils.reuestutil.RequestUtils;
import com.qixiu.wigit.zprogress.ZProgressHUD;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by my on 2018/11/14.
 */

public abstract class RequstFragment extends TitleFragment implements OKHttpUIUpdataListener<BaseBean> {

    OKHttpRequestModel okHttpRequestModel = new OKHttpRequestModel(this);
    private ZProgressHUD zProgressHUD;


    public void post(String url, Map map, BaseBean bean) {
//        okHttpRequestModel.okhHttpPost(url, map, bean);
        RequestUtils.okPost(url, map, bean, this,getActivity());
        zProgressHUD.show();

    }

    public void post(String url, BaseRequestIntef ReuestBean, BaseBean bean) {
//        okHttpRequestModel.okhHttpPost(url, map, bean);
        Gson gson = new Gson();
        String json = gson.toJson(ReuestBean);
        RequestUtils.post(url, json, bean, this, getActivity());
        zProgressHUD.show();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void get(String url, Map map, BaseBean bean) {
        okHttpRequestModel.okHttpGet(url, map, bean);
        zProgressHUD.show();
    }

    @Override
    protected void onInitViewNew(View view) {
        zProgressHUD = new ZProgressHUD(getContext());
    }

    @Override
    public void onSuccess(BaseBean data, int i) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                zProgressHUD.dismiss();
                onSuccess(data);
            }
        });
    }

    public abstract void onSuccess(BaseBean data);

    public abstract void onError(Exception e);

    public abstract void onFailure(C_CodeBean c_codeBean, String m);


    @Override
    public void onError(Call call, Exception e, int i) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                zProgressHUD.dismiss();
                onError(e);
            }
        });
    }

    @Override
    public void onFailure(C_CodeBean c_codeBean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                zProgressHUD.dismiss();
                onFailure(c_codeBean, c_codeBean.getM());
            }
        });
    }
}
