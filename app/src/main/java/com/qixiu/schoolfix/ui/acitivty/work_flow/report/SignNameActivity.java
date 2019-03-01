package com.qixiu.schoolfix.ui.acitivty.work_flow.report;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.PictureCut;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.wigit.PaletteView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignNameActivity extends RequestActivity {
    Bitmap signatuerBitamp;
    @BindView(R.id.paletteview)
    PaletteView paletteview;
    private BitmapDrawable signatuerDrawable;

    @Override
    protected void onInitData() {
        mTitleView.setTitle("签名");


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign;
    }

    @Override
    protected void onInitViewNew() {

    }

    @Override
    public void onSuccess(BaseBean data) {

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    @Override
    public void onClick(View v) {

    }

    public void saveSign(View view) {
        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                signatuerBitamp = paletteview.buildBitmap();
//                signatuerDrawable = new BitmapDrawable(signatuerBitamp);
                //上传图片
                String path = PictureCut.saveBitmapToSdcard(signatuerBitamp);
                EventBus.getDefault().post(path);
                Intent inent=new Intent();
                inent.putExtra(IntentDataKeyConstant.FILE_PATH,path);
                setResult(1000,inent);
                finish();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
