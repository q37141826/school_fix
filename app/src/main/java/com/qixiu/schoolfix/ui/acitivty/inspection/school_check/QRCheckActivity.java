package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qixiu.qixiu.google.zxing.client.android.utils.QRCodeUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.TitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QRCheckActivity extends TitleActivity {


    @BindView(R.id.imageView)
    ImageView imageView;
    private String url;

    @Override
    protected void onInitData() {
        url = getIntent().getStringExtra(IntentDataKeyConstant.DATA);
        mTitleView.setTitle("学校老师签名");
        Bitmap qrCodeBitmap = QRCodeUtil.createQRCodeBitmap(url, 480, 480);
        imageView.setImageBitmap(qrCodeBitmap);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_qrcheck;
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
