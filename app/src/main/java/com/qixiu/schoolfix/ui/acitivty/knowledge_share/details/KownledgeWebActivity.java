package com.qixiu.schoolfix.ui.acitivty.knowledge_share.details;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.qixiu.qixiu.utils.WebViewUtils;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.BaseWebActivity;
import com.qixiu.schoolfix.ui.acitivty.knowledge_share.KnowledgeShareBean;
import com.qixiu.schoolfix.utils.LoginStatus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KownledgeWebActivity extends BaseWebActivity {


    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onInitData() {
        mTitleView.setBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getWebView().canGoBack()) {
                    getWebView().goBack();
                } else {
                    finish();
                }
            }
        });
        KnowledgeShareBean.ResultBean.DataListBean dataListBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
        mTitleView.setTitle(dataListBean.getArticleTypeName());
        //JsBridge
        getWebView().addJavascriptInterface(new JsBridge(), "JsInterface");
        Map<String, String> map = new HashMap<>();
        map.put("GUID", LoginStatus.getLoginBean().getO().getId());
        map.put("tenantId", dataListBean.getTenantId());
        map.put("articleTypeGUID", dataListBean.getId());
        String url = WebViewUtils.resolveUrl(ConstantUrl.webKnowledgeUrl, map);
//        CommonUtils.setWebview(webView, url,false);
        getWebView().loadUrl(url);
        getWebView().getSettings().setTextSize(WebSettings.TextSize.NORMAL);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_kownledge_web;
    }

    @Override
    public WebView getWebView() {
        return webView;
    }

    @Override
    protected void onInitViewNew() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public CommentBean getParcelbleData(String json) {
        Gson gson = new Gson();
        CommentBean bean = gson.fromJson(json, CommentBean.class);
        return bean;
    }


    public class JsBridge {

        @JavascriptInterface
        public void comment(String json) {
            CommentBean parcelbleData = getParcelbleData(json);
            parcelbleData.setMethoed("comment");
            UploadCommentsActiviity.start(getContext(), UploadCommentsActiviity.class, parcelbleData);
        }

        @JavascriptInterface
        public void reply(String json) {
            CommentBean parcelbleData = getParcelbleData(json);
            parcelbleData.setMethoed("reply");
            UploadCommentsActiviity.start(getContext(), UploadCommentsActiviity.class, parcelbleData);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getWebView().canGoBack()) {
            getWebView().goBack();
        } else {
            finish();
        }
    }


}
