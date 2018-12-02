package com.qixiu.schoolfix.ui.acitivty.work_flow;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.audio.AudioRecoderUtils;
import com.qixiu.qixiu.utils.audio.SoundUtils;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.upload.UploadPictureActivityNew;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateSoftWorkActivity extends UploadPictureActivityNew {
    String permission[] = {Manifest.permission.RECORD_AUDIO};


    @BindView(R.id.recyclerViewProblemDesc)
    RecyclerView recyclerViewProblemDesc;
    @BindView(R.id.recyclerViewPic)
    RecyclerView recyclerViewPic;
    @BindView(R.id.imageViewSound)
    ImageView imageViewSound;
    @BindView(R.id.iamgeView_play_voice)
    ImageView iamgeViewPlayVoice;
    @BindView(R.id.btnConfirmCreateWork)
    Button btnConfirmCreateWork;
    AudioRecoderUtils mAudioRecoderUtils;
    public String voice_file_path;
    private ImageView imageViewPop;

    @Override
    protected void onInitData() {
        mTitleView.setTitle("创建工单");
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_create_soft_work;
    }

    @Override
    protected void onInitViewNew() {
        recyclerViewProblemDesc.setLayoutManager(new LinearLayoutManager(this));
        mAudioRecoderUtils = new AudioRecoderUtils();
        PopupWindow popupWindow = mAudioRecoderUtils.setDefaultView(getContext(), imageViewSound);
        imageViewPop = mAudioRecoderUtils.getPopImage();
        mAudioRecoderUtils.setOnAudioStatusUpdateListener(new AudioRecoderUtils.OnAudioStatusUpdateListener() {

            //录音中....db为声音分贝，time为录音时长
            @Override
            public void onUpdate(double db, long time) {
                //根据分贝值来设置录音时话筒图标的上下波动，下面有讲解
//                imageViewPop.getDrawable().setLevel((int) (3000 + 6000 * db / 100));
            }

            //录音结束，filePath为保存路径
            @Override
            public void onStop(String filePath) {
//                ToastUtil.toast("录音保存在：" + filePath);
                voice_file_path = filePath;
                iamgeViewPlayVoice.setVisibility(View.VISIBLE);
            }
        });
        if (!hasPermission(permission)) {
            hasRequse(1, permission);
        }
        iamgeViewPlayVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundUtils.playFile(getContext(), voice_file_path);
            }
        });
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onUpLoad(Object data) {

    }

    @Override
    public void initUpLoadView() {

    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerViewPic;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
}
