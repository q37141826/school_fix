package com.qixiu.schoolfix.ui.acitivty.knowledge_share.details;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.upload.UploadPictureActivityNew;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.schoolfix.utils.reuestutil.UploadFileRequest;
import com.qixiu.schoolfix.utils.reuestutil.UploadFilesBean;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UploadCommentsActiviity extends UploadPictureActivityNew {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.edittext)
    EditText edittext;
    private CommentBean commentbean;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_upload_comments_activiity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onInitData() {
        commentbean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
        mTitleView.setTitle("评论");
    }

    @Override
    protected void onInitViewNew() {
        mTitleView.setRightText("写评论");
        mTitleView.getRightText().setTextColor(getResources().getColor(R.color.theme_color));
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Map<String, File>> files = new ArrayList<>();
                if (selectPhotos.size() != 0) {
                    for (int i = 0; i < selectPhotos.size(); i++) {
                        File file = new File(selectPhotos.get(i));
                        Map<String, File> mapFile = new HashMap<>();
                        mapFile.put(ConstantString.FILE_KEY, file);
                        files.add(mapFile);
                    }
                    okHttpRequestModel.okhHttpPost(ConstantUrl.uploadFileMoreUrl, new HashMap<>(), new UploadFilesBean(), files);
                } else {
                    Map<String, String> map = new HashMap<>();
                    map.put("articleGUID", commentbean.getId());
                    map.put("userGUID", LoginStatus.getLoginBean().getO().getId());
                    map.put("articleReplyContent", edittext.getText().toString());
                    post(ConstantUrl.commentUrl, map, new BaseBean());
                }

            }
        });
    }

    @Override
    public void onSuccess(BaseBean data) {
        super.onSuccess(data);
        if (data instanceof UploadFilesBean) {
            UploadFilesBean bean = (UploadFilesBean) data;
            Map<String, String> map = new HashMap<>();
            map.put("articleGUID", commentbean.getId());
            map.put("userGUID", LoginStatus.getLoginBean().getO().getId());
            map.put("articleReplyContent", edittext.getText().toString());
            map.put("articleReplyImgUrls", UploadFileRequest.getUrlsStringSpell(bean.getO(), ";"));
            post(ConstantUrl.commentUrl, map, new BaseBean());
        }
        if (data.getUrl().equals(ConstantUrl.commentUrl)) {
            ToastUtil.toast("评论成功");
            finish();
        }

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    @Override
    protected void onUpLoad(Object data) {

    }

    @Override
    public void initUpLoadView() {

    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public void onClick(View v) {

    }
}
