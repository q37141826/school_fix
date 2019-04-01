package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.BaseWebActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GotoQrCodeWebActivity extends BaseWebActivity {

    @BindView(R.id.webView_goto)
    WebView webViewGoto;
    private String url;

    @Override
    protected void onInitData() {
        url = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_goto_qr_code_web;
    }

    @Override
    public WebView getWebView() {
        return webViewGoto;
    }

    @Override
    protected void onStart() {
        super.onStart();
        load(url);
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
}
