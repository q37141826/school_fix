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
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by my on 2018/8/23.
 */

public abstract class RequestActivity extends TitleActivity implements OKHttpUIUpdataListener<BaseBean> {

    public OKHttpRequestModel okHttpRequestModel = new OKHttpRequestModel(this);
    public ZProgressHUD mZProgressHUD;


    public void post(String url, Map map, BaseBean bean) {
        RequestUtils.okPost(url, map, bean, this, this);
        showProgress();
    }

    public void showProgress() {
        if (mZProgressHUD != null) {
            mZProgressHUD.show();
        }
    }

    public void post(String url, BaseRequestIntef ReuestBean, BaseBean bean) {
        Gson gson = new Gson();
        String json = gson.toJson(ReuestBean);
        RequestUtils.post(url, json, bean, this, this);
        showProgress();
    }

    public void get(String url, Map map, BaseBean bean) {
        okHttpRequestModel.okHttpGet(url, map, bean);
        mZProgressHUD.show();
    }

    @Override
    protected void onInitView() {
        mZProgressHUD = new ZProgressHUD(getContext());
        super.onInitView();
    }

    @Override
    public void onSuccess(BaseBean data, int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mZProgressHUD.dismiss();
                onSuccess(data);
            }
        });
    }

    @Override
    public void onError(Call call, Exception e, int i) {
        if (call!=null&&call.isCanceled()) {
            return;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mZProgressHUD.dismiss();
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
                    mZProgressHUD.dismiss();
                    try {
                        ToastUtil.toast(errorBeanOne.getError().getMessage());
                        onFailure(c_codeBean, c_codeBean.getM());
                    } catch (Exception e) {

                    }
                }
            });
        }
    }


    public abstract void onSuccess(BaseBean data);

    public abstract void onError(Exception e);

    public abstract void onFailure(C_CodeBean c_codeBean, String m);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(getActivity());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mZProgressHUD != null) {
            mZProgressHUD.dismiss();
        }
    }


}
