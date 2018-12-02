package com.qixiu.schoolfix.ui.acitivty.work_flow;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.qixiu.qixiu.google.zxing.client.android.CaptureActivity;
import com.qixiu.qixiu.request.OKHttpRequestModel;
import com.qixiu.qixiu.request.OKHttpUIUpdataListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.qixiu.utils.audio.AudioRecoderUtils;
import com.qixiu.qixiu.utils.audio.SoundUtils;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.model.UploadFileBean;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.upload.UploadPictureActivityNew;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.ProblemSelectActivity;
import com.qixiu.schoolfix.ui.acitivty.home.binding.MechineDetailsBean;
import com.qixiu.schoolfix.ui.acitivty.home.binding.SelectedMechineCodeActivity;
import com.qixiu.widget.LineControllerView;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class CreateHardWorkActivity extends UploadPictureActivityNew {
    String permission[] = {Manifest.permission.RECORD_AUDIO};

    @BindView(R.id.recyclerViewProblemDesc)
    RecyclerView recyclerViewProblemDesc;
    @BindView(R.id.recyclerViewPic)
    RecyclerView recyclerViewPic;
    @BindView(R.id.imageViewSound)
    ImageView imageViewSound;
    @BindView(R.id.btnConfirmCreateWork)
    Button btnConfirmCreateWork;
    @BindView(R.id.iamgeView_play_voice)
    ImageView iamgeViewPlayVoice;
    AudioRecoderUtils mAudioRecoderUtils;
    public String voice_file_path;
    @BindView(R.id.lineCreateDepartment)
    LineControllerView lineCreateDepartment;
    @BindView(R.id.lineCreatePerson)
    LineControllerView lineCreatePerson;
    @BindView(R.id.lineCreatePhone)
    LineControllerView lineCreatePhone;
    @BindView(R.id.lineExpectTime)
    LineControllerView lineExpectTime;
    @BindView(R.id.lineRepairAddress)
    LineControllerView lineRepairAddress;
    @BindView(R.id.lineProductType)
    LineControllerView lineProductType;
    @BindView(R.id.lineProductName)
    LineControllerView lineProductName;
    @BindView(R.id.lineProductModel)
    LineControllerView lineProductModel;
    @BindView(R.id.lineProductBrand)
    LineControllerView lineProductBrand;
    @BindView(R.id.lineMechineCode)
    LineControllerView lineMechineCode;
    @BindView(R.id.lineDeviceCode)
    LineControllerView lineDeviceCode;
    @BindView(R.id.lineMechinAddress)
    LineControllerView lineMechinAddress;

    private ImageView imageViewPop;
    private List<String> fileIds;
    private int fileNums;
    private String voiceUrl;
    private String scanId;

    private String productGUID;//产品 ID
    private String productTypeName;//产品类型
    private String productName;//
    private String productModel;//
    private String productBrand;//
    private String schoolUnitGUID;
    private String schoolUnitName;
    private String schoolUnitAddress;
    private String schoolUnitServiceName;
    private MechineDetailsBean detailsBean;


    @Override
    protected void onInitData() {
        setMaxPictureCount(3);
        mTitleView.setRightImage(getContext(), R.drawable.homepage_btn_sweep);
        mTitleView.getRightText().setVisibility(View.VISIBLE);
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent, CaptureActivity.ZXING_INTENT);
            }
        });
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
    protected int getLayoutResource() {
        return R.layout.activity_create_work;
    }

    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("创建工单");
        recyclerViewProblemDesc.setLayoutManager(new LinearLayoutManager(this));
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
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            scanId = data.getStringExtra(CaptureActivity.ZXING_VALUE);
            post(ConstantUrl.mechineDetailsUrl + "?id=" + scanId, new HashMap(), new MechineDetailsBean());
        }
    }

    public void uploadConfrim(View view) {
        mZProgressHUD.show();
        fileIds = new ArrayList<>();
        fileNums = selectPhotos.size();
        for (int i = 0; i < selectPhotos.size(); i++) {
            uploadFile(selectPhotos.get(i));
        }
        if (!TextUtils.isEmpty(voice_file_path)) {
            uploadFile(voice_file_path);
        }
    }

    private void uploadFile(String path) {
        OKHttpRequestModel okHttpRequestModel = new OKHttpRequestModel(new OKHttpUIUpdataListener() {
            @Override
            public void onSuccess(Object data, int i) {
                if (data instanceof UploadFileBean) {
                    UploadFileBean uploadFileBean = (UploadFileBean) data;
                    if (uploadFileBean.getO().endsWith("amr")) {
                        voiceUrl = uploadFileBean.getO();
                    } else {
                        fileIds.add(uploadFileBean.getO());
                    }
                }
                if (fileIds.size() == fileNums && !TextUtils.isEmpty(voiceUrl)) {
                    ToastUtil.toast("上传完成");// TODO: 2018/11/24 再去创建工单
                    createWork();
                }
            }

            @Override
            public void onError(Call call, Exception e, int i) {
                ToastUtil.toast(R.string.link_error);
                mZProgressHUD.dismiss();
            }

            @Override
            public void onFailure(C_CodeBean c_codeBean) {
                ToastUtil.toast(c_codeBean.getM());
                mZProgressHUD.dismiss();
            }
        });
        Map<String, File> mapFiles = new HashMap<>();
        try {
            mapFiles.put("File", new File(path));
        } catch (Exception e) {

        }
        okHttpRequestModel.okhHttpPost(ConstantUrl.uploadFile, null, new UploadFileBean(), mapFiles);
    }

    private void createWork() {
        Map<String, String> map = new HashMap<>();
//        map.put("workOrderGUID",);
//
//        map.put("deviceGUID",);
//
//        map.put("repairUserGUID",);
//
//        map.put("serviceUserGUID",);
//
//        map.put("workOrderSubmitName",);
//
//        map.put("workOrderSubmitUnit",);
//
//        map.put("workOrderSubmitTel",);
//
//        map.put("workOrderType",);
//
//        map.put("workOrderServiceNo",);
//
        map.put("workOrderExpectTime", lineExpectTime.getSecondaryText().toString());
//
//        map.put("workOrderCstProblemRemark",);
//
        map.put("workOrderProblemMP3Url", voiceUrl);
//
//        map.put("workOrderMP3",);
//
        map.put("workOrderCstProblemImgUrl", fileIds.get(0));
//
//        map.put("workOrderGoTime",);
//
//        map.put("workOrderGoAddress",);
//
//        map.put("workOrderSignInTime",);
//
//        map.put("workOrderSignInAddress",);
//
//        map.put("workOrderSignOutTime",);
//
//        map.put("workOrderSignOutAddress",);
//
//        map.put("workOrderErrorImgUrls",);
//
//        map.put("workOrderUserSignImgUrl",);
//
//        map.put("qrCodeGUID",);
//
        map.put("workOrderCreatime", TimeDataUtil.getTimeStamp(new Date().getTime()));
//
//        map.put("workOrderReceiveTime",);
//
//        map.put("workOrderAssignTime",);
//
//        map.put("destroyUserGUID",);
//
//        map.put("workOrderCancleReason",);
//
//        map.put("workOrderDestroyTime",);
//
//        map.put("cstProductProblemGUIDs",);
//
//        map.put("repairProductProblemGUIDs",);
//
//        map.put("productProblemSolutionGUID",);
//
//        map.put("workOrderRepairSolutionRemark",);
//
//        map.put("workOrderRepairProblemRemark",);
//
//        map.put("tenantId",);
//
//        map.put("isDeleted",);
//
        map.put("createTime", TimeDataUtil.getTimeStamp(new Date().getTime()));
//
//        map.put("createGUID",);
//
        map.put("createdName", Preference.get(ConstantString.USERNAME, ""));
//
//        map.put("modifiedTime",);
//
//        map.put("modifiedGUID",);
//
//        map.put("modifiedName",);
//
//        map.put("approveState",);
//
//        map.put("approveGUID",);
//
//        map.put("approveTime",);
//
//        map.put("workOrderSubmitId",);
//
//        map.put("workOrderFinishTime",);
//
//        map.put("workOrderRepairIsConfirmFinish",);
//
        map.put("workOrderSubmitAddress", "企秀测试");
//
//        map.put("workOrderExpectEndTime",);

    }

    public void selectProblem(View view) {
        if (TextUtils.isEmpty(scanId)) {
            ToastUtil.toast("请先选择设备信息");
            return;
        }
        Preference.put(ConstantString.FROM_WHERE,"CREATE");
        ProblemSelectActivity.start(getContext(), ProblemSelectActivity.class, productGUID);

    }

    @Override
    public void onSuccess(BaseBean data) {
        mZProgressHUD.dismiss();
        if (data instanceof MechineDetailsBean) {
            detailsBean = (MechineDetailsBean) data;
            productGUID = detailsBean.getO().getProductGUID();
            productTypeName = detailsBean.getO().getProductTypeName();
            productName = detailsBean.getO().getProductName();
            productModel = detailsBean.getO().getProductModel();
            productBrand = detailsBean.getO().getProductBrand();
            schoolUnitGUID = detailsBean.getO().getSchoolUnitGUID();
            schoolUnitName = detailsBean.getO().getSchoolUnitName();
            schoolUnitAddress = detailsBean.getO().getSchoolUnitAddress();
            schoolUnitServiceName = detailsBean.getO().getSchoolUnitServiceName();

            lineDeviceCode.setSecondaryText(detailsBean.getO().getDeviceCode());
            lineProductBrand.setSecondaryText(productBrand);
            lineProductModel.setSecondaryText(productModel);
            lineMechineCode.setSecondaryText(detailsBean.getO().getDeviceMachineCode());
            lineMechinAddress.setSecondaryText(detailsBean.getO().getDeviceAddress());
            lineRepairAddress.setSecondaryText(detailsBean.getO().getSchoolUnitAddress());
            lineCreateDepartment.setSecondaryText(detailsBean.getO().getSchoolUnitName());
            lineProductName.setSecondaryText(productName);


        }
        super.onSuccess(data);
    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    public void gotoSelectMechineCode(View view) {
        if (TextUtils.isEmpty(productGUID)) {
            ToastUtil.toast("请先扫描二维码");
            return;
        }
        SelectedMechineCodeActivity.start(getContext(), SelectedMechineCodeActivity.class,detailsBean.getO());
    }
}
