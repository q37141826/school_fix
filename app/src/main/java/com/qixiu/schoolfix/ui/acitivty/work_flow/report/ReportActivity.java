package com.qixiu.schoolfix.ui.acitivty.work_flow.report;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.model.UploadFileBean;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.upload.UploadPictureActivityNew;
import com.qixiu.schoolfix.ui.acitivty.work_flow.details.WorkDetailsBean;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.ProblemSelectActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.SelectedProblemResoveListBeans;
import com.qixiu.schoolfix.utils.reuestutil.UploadFileRequest;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReportActivity extends UploadPictureActivityNew {

    @BindView(R.id.recyclerPic)
    RecyclerView recyclerPic;
    @BindView(R.id.imageViewGotoSign)
    ImageView imageViewGotoSign;
    @BindView(R.id.textViewProblems)
    TextView textViewProblems;
    @BindView(R.id.linearGotoProblem)
    LinearLayout linearGotoProblem;
    @BindView(R.id.textViewSolutions)
    TextView textViewSolutions;
    WorkDetailsBean.ResultBean resultBean;
    SelectedProblemResoveListBeans selectedProblemResoveListBeans;
    String signPath;
    private String signUrl;

    @Override
    protected void onInitViewNew() {
        EventBus.getDefault().register(this);
        mTitleView.setTitle("实施报告");
        recyclerPic.setLayoutManager(new GridLayoutManager(getContext(), 3));
        resultBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
        mTitleView.setRightText("保存");
        mTitleView.getRightText().setTextColor(getResources().getColor(R.color.theme_color));
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startUpload();
            }
        });
    }

    private void startUpload() {
        mZProgressHUD.show();
        if (selectedProblemResoveListBeans == null || selectedProblemResoveListBeans.getProblemBeans().size() == 0) {
            ToastUtil.toast("请选择问题描述以及对应方案");
            return;
        }
        if (selectPhotos.size() == 0) {
            ToastUtil.toast("请选择现场照片");
            return;
        }
        if (TextUtils.isEmpty(signPath)) {
            ToastUtil.toast("请填写签名");
            return;
        }

        List<String> imagesUrls = new ArrayList<>();
        for (int i = 0; i < selectPhotos.size(); i++) {
            UploadFileRequest.uploadFile(selectPhotos.get(i), new UploadFileRequest.UploadFileCallBack<UploadFileBean>() {
                @Override
                public void call(UploadFileBean uploadFileBean) {
                    imagesUrls.add(uploadFileBean.getO());
                    checkAndSave(imagesUrls);
                }

                @Override
                public void onError() {

                }

                @Override
                public void onFailue() {

                }
            });
        }
        UploadFileRequest.uploadFile(signPath, new UploadFileRequest.UploadFileCallBack<UploadFileBean>() {
            @Override
            public void call(UploadFileBean uploadFileBean) {
                signUrl = uploadFileBean.getO();
                checkAndSave(imagesUrls);
            }

            @Override
            public void onError() {

            }

            @Override
            public void onFailue() {

            }
        });

    }

    private void checkAndSave(List<String> imagesUrls) {
        if (selectPhotos.size() == imagesUrls.size() &&! TextUtils.isEmpty(signUrl)) {
            String urlsStringSpell = UploadFileRequest.getUrlsStringSpell(imagesUrls, ";");
            String repairProductProblemGUIDs = UploadFileRequest.getIdsStringSpell(selectedProblemResoveListBeans.getProblemBeans(), ";");
            String productProblemSolutionGUID = UploadFileRequest.getIdsStringSpell(selectedProblemResoveListBeans.getResoveBeans(), ";");

            Map<String, String> map = new HashMap();
            map.put("id",resultBean.getId());
            map.put("workOrderErrorImgUrls", urlsStringSpell);
            map.put("workOrderUserSignImgUrl", signUrl);
            map.put("repairProductProblemGUIDs", repairProductProblemGUIDs);
            map.put("workOrderRepairProblemRemark", textViewProblems.getText().toString());
            map.put("productProblemSolutionGUID", productProblemSolutionGUID);
            map.put("workOrderRepairSolutionRemark", textViewSolutions.getText().toString());
            post(ConstantUrl.saveReportUrl, map, new BaseBean());
        }
    }

    @Override
    protected void onUpLoad(Object data) {

    }

    @Override
    public void initUpLoadView() {

    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerPic;
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data.getUrl().equals(ConstantUrl.saveReportUrl)) {
            ToastUtil.toast("保存成功");
            finish();
        }
    }

    @Override
    public void onError(Exception e) {
        mZProgressHUD.dismiss();;
    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {
        mZProgressHUD.dismiss();

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onInitData() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_report;
    }

    @OnClick({R.id.linearGotoProblem})
    public void selectProblem(View view) {
        ProblemSelectActivity.start(getContext(), ProblemSelectActivity.class, resultBean.getProductGUID());
    }

    public void selectSulotions(View view) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void gotoSign(View view) {
        SignNameActivity.start(getContext(), SignNameActivity.class);
    }


    @Subscribe
    public void getResultEvent(SelectedProblemResoveListBeans data) {
        selectedProblemResoveListBeans = data;
        StringBuffer problems = new StringBuffer("");
        for (int i = 0; i < data.getProblemBeans().size(); i++) {
            problems.append(data.getProblemBeans().get(i).getProductProblemRemark() + "\n");
        }
        textViewProblems.setText(problems.toString());
        StringBuffer resovels = new StringBuffer("");
        for (int i = 0; i < data.getResoveBeans().size(); i++) {
            resovels.append(data.getResoveBeans().get(i).getProductProblemRemark() + "\n");
        }
        textViewSolutions.setText(resovels.toString());

    }

    @Subscribe
    public void getSignEvent(String path) {
        signPath=path;
        Glide.with(getContext()).load(path).into(imageViewGotoSign);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
