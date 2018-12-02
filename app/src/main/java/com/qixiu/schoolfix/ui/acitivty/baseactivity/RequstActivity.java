package com.qixiu.schoolfix.ui.acitivty.baseactivity;

import com.google.gson.Gson;
import com.qixiu.qixiu.request.OKHttpRequestModel;
import com.qixiu.qixiu.request.OKHttpUIUpdataListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.request.bean.ErrorBeanOne;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.model.BaseRequestIntef;
import com.qixiu.schoolfix.utils.reuestutil.RequestUtils;
import com.qixiu.wigit.zprogress.ZProgressHUD;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by my on 2018/8/23.
 */

public abstract class RequstActivity extends TitleActivity implements OKHttpUIUpdataListener<BaseBean> {

    OKHttpRequestModel okHttpRequestModel = new OKHttpRequestModel(this);
    private ZProgressHUD zProgressHUD;


    public void post(String url, Map map, BaseBean bean) {
//        okHttpRequestModel.okhHttpPost(url, map, bean);
        RequestUtils.okPost(url, map, bean, this, this);
        zProgressHUD.show();

    }

    public void post(String url, BaseRequestIntef ReuestBean, BaseBean bean) {
//        okHttpRequestModel.okhHttpPost(url, map, bean);
        Gson gson = new Gson();
        String json = gson.toJson(ReuestBean);
        RequestUtils.post(url, json, bean, this, this);
        zProgressHUD.show();
    }

    public void get(String url, Map map, BaseBean bean) {
        okHttpRequestModel.okHttpGet(url, map, bean);
        zProgressHUD.show();
    }

    @Override
    protected void onInitView() {
        zProgressHUD = new ZProgressHUD(getContext());
        super.onInitView();
    }

    @Override
    public void onSuccess(BaseBean data, int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                zProgressHUD.dismiss();
                onSuccess(data);
            }
        });
    }

    @Override
    public void onError(Call call, Exception e, int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                zProgressHUD.dismiss();
                onError(e);
            }
        });
    }

    @Override
    public void onFailure(C_CodeBean c_codeBean) {
        if (c_codeBean instanceof ErrorBeanOne) {
            ErrorBeanOne errorBeanOne = (ErrorBeanOne) c_codeBean;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    zProgressHUD.dismiss();
                    ToastUtil.toast(errorBeanOne.getError().getMessage());
                    onFailure(c_codeBean, c_codeBean.getM());
                }
            });
        }
    }


    public abstract void onSuccess(BaseBean data);

    public abstract void onError(Exception e);

    public abstract void onFailure(C_CodeBean c_codeBean, String m);


}
