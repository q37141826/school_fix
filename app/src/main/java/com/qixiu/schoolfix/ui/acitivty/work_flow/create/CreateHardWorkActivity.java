package com.qixiu.schoolfix.ui.acitivty.work_flow.create;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.qixiu.qixiu.google.zxing.client.android.CaptureActivity;
import com.qixiu.qixiu.request.OKHttpRequestModel;
import com.qixiu.qixiu.request.OKHttpUIUpdataListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.CommonUtils;
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
import com.qixiu.schoolfix.ui.acitivty.home.binding.MechineCodeListBean;
import com.qixiu.schoolfix.ui.acitivty.home.binding.MechineDetailsBean;
import com.qixiu.schoolfix.ui.acitivty.home.binding.SelectedMechineCodeActivity;
import com.qixiu.schoolfix.utils.reuestutil.RequestMaker;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.ProblemDataBean;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.ProblemSelectActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.schoolfix.utils.reuestutil.UploadFileRequest;
import com.qixiu.widget.LineControllerView;
import com.qixiu.wigit.picker.MyPopOneListPicker;
import com.qixiu.wigit.picker.SelectedDataBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

import static com.qixiu.qixiu.google.zxing.client.android.CaptureActivity.ZXING_INTENT;

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
    LineControllerView lineSchoolName;
    @BindView(R.id.lineCreatePerson)
    LineControllerView lineCreatePerson;
    @BindView(R.id.lineCreatePhone)
    LineControllerView lineCreatePhone;
    @BindView(R.id.lineExpectTime)
    LineControllerView lineExpectTime;
    @BindView(R.id.lineRepairAddress)
    LineControllerView lineSchoolAddress;
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
    @BindView(R.id.textViewPrblems)
    TextView textViewPrblems;
    @BindView(R.id.lineSoft)
    LineControllerView lineSoft;
    @BindView(R.id.lineSystemName)
    LineControllerView lineSystemName;
    @BindView(R.id.lineConstructure)
    LineControllerView lineConstructure;
    @BindView(R.id.lineBrand)
    LineControllerView lineBrand;
    @BindView(R.id.linearlayout_soft)
    LinearLayout linearlayoutSoft;
    @BindView(R.id.linearlayout_hard)
    LinearLayout linearlayoutHard;

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
    private SchoolListBean.ResultBean.DataListBean schoolBean;
    private String selecteProblemIds;
    private ProductListBean.ResultBean.DataListBean productBean;
    private MechineCodeListBean.ResultBean.DataListBean selectMechineCode;
    private boolean is_soft = false;//目前是创建软件还是创建硬件维修


    @Override
    protected void onInitData() {
        EventBus.getDefault().register(this);
        setMaxPictureCount(3);
//        mTitleView.setRightImage(getContext(), R.drawable.tab_btn_sma);
//        mTitleView.getRightText().setVisibility(View.VISIBLE);
        lineExpectTime.setSecondaryText(TimeDataUtil.getTimeStamp(new Date().getTime(), TimeDataUtil.DEFULT_TIME_FORMAT));
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent, ZXING_INTENT);
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
            if (requestCode == ZXING_INTENT) {
                scanId = data.getStringExtra(CaptureActivity.ZXING_VALUE);
                post(ConstantUrl.mechineDetailsUrl + "?id=" + scanId, new HashMap(), new MechineDetailsBean());
            }
        }
    }

    public void uploadConfrim(View view) {
        if (schoolBean == null) {
            ToastUtil.toast("请先选择单位");
            return;
        }
        if (TextUtils.isEmpty(productGUID) && !is_soft) {
            ToastUtil.toast("请选择产品");
            return;
        }
        if (!is_soft && selectMechineCode == null) {
            ToastUtil.toast("请选择设备码");
            return;
        }
        if (TextUtils.isEmpty(selecteProblemIds)) {
            ToastUtil.toast("请选择问题描述");
            return;
        }
        fileIds = new ArrayList<>();
        fileNums = selectPhotos.size();
        if (selectPhotos.size() == 0 && TextUtils.isEmpty(voice_file_path)) {
            createWork();
            return;
        }
        for (int i = 0; i < selectPhotos.size(); i++) {
            uploadFile(selectPhotos.get(i));
        }
        if (!TextUtils.isEmpty(voice_file_path)) {
            voiceUrl = "";
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
                if (fileIds.size() == fileNums) {
                    if (!TextUtils.isEmpty(voice_file_path) && !TextUtils.isEmpty(voiceUrl)) {
                        createWork();
                    } else {
                        createWork();
                    }
                }
            }

            @Override
            public void onError(Call call, Exception e, int i) {
                ToastUtil.toast(R.string.link_error);
                mZProgressHUD.dismiss();
            }

            @Override
            public void onFailure(C_CodeBean c_codeBean) {
                try {
                    ToastUtil.toast(c_codeBean.getM());
                } catch (Exception e) {
                }
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
//        map.put("workOrderGUID",);//
        if (selectMechineCode != null) {
            map.put("deviceGUID", selectMechineCode.getId());
        }
//
        map.put("repairUserGUID", LoginStatus.getLoginBean().getO().getId());
//
//        map.put("serviceUserGUID",);
//
//        map.put("workOrderSubmitName",);
//
//        map.put("workOrderSubmitUnit",);
//
//        map.put("workOrderSubmitTel",);
//
        map.put("workOrderType", "待接单");
//
//        map.put("workOrderServiceNo",);
//
        map.put("workOrderExpectTime", lineExpectTime.getSecondaryText().toString());
//
        map.put("workOrderCstProblemRemark", textViewPrblems.getText().toString());
//
        CommonUtils.putDataIntoMap(map, "workOrderProblemMP3Url", voiceUrl);
//
//        map.put("workOrderMP3",);
//
        CommonUtils.putDataIntoMap(map, "workOrderCstProblemImgUrl", UploadFileRequest.getUrlsStringSpell(fileIds, ";"));
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
//        map.put("workOrderCreatime", TimeDataUtil.getTimeStamp(new Date().getTime()));
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
        map.put("cstProductProblemGUIDs", selecteProblemIds);
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
//        map.put("createTime", TimeDataUtil.getTimeStamp(new Date().getTime()));
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
        post(ConstantUrl.createWorkUrl, map, new BaseBean());
        mZProgressHUD.show();
    }

    public void selectProblem(View view) {
        if (TextUtils.isEmpty(productGUID) && !is_soft) {
            ToastUtil.toast("请先选择设备信息");
            return;
        }
        Preference.put(ConstantString.FROM_WHERE, this.getClass().getSimpleName());
        ProblemSelectActivity.start(getContext(), ProblemSelectActivity.class, productGUID);
    }


    @Override
    public void onSuccess(BaseBean data) {
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
            lineSchoolAddress.setSecondaryText(detailsBean.getO().getSchoolUnitAddress());
            lineSchoolName.setSecondaryText(detailsBean.getO().getSchoolUnitName());
            lineProductName.setSecondaryText(productName);
        }
        if (data instanceof SchoolListBean) {//选择学校
            SchoolListBean bean = (SchoolListBean) data;
            List<SelectedDataBean> selectedDataBeans = new ArrayList<>();
            for (int i = 0; i < bean.getO().getDataList().size(); i++) {
                SelectedDataBean selectedDataBean = new SelectedDataBean(bean.getO().getDataList().get(i).getId(), bean.getO().getDataList().get(i).getSchoolUnitName());
                selectedDataBean.setData(bean.getO().getDataList().get(i));
                selectedDataBeans.add(selectedDataBean);
            }
            MyPopOneListPicker schoolPicker = new MyPopOneListPicker(getContext(), selectedDataBeans, new MyPopOneListPicker.Pop_selectedListenner() {
                @Override
                public void getData(SelectedDataBean data) {
                    schoolBean = (SchoolListBean.ResultBean.DataListBean) data.getData();
                    schoolUnitGUID = schoolBean.getSchoolUnitGUID();
                    lineSchoolName.setSecondaryText(schoolBean.getSchoolUnitName());
                    lineSchoolAddress.setSecondaryText(schoolBean.getRepairBusinessAddress());
                    lineCreatePhone.setSecondaryText(schoolBean.getSchoolUnitTel());
                    lineCreatePerson.setSecondaryText(schoolBean.getSchoolUnitMaster());
                    //选择学校之后要清除产品 问题描述信息
                    clearProduct();
                    if (!is_soft) {
                        clearMechineCode();
                    }
                    //选择学校或者选择产品后，问题要清除
                    clearProblem();
                }
            });
            schoolPicker.show();
        }
        if (data instanceof ProductListBean) {
            ProductListBean bean = (ProductListBean) data;
            List<SelectedDataBean> selectedDataBeans = new ArrayList<>();
            for (int i = 0; i < bean.getO().getDataList().size(); i++) {
                SelectedDataBean selectedDataBean = new SelectedDataBean(bean.getO().getDataList().get(i).getId(), bean.getO().getDataList().get(i).getProductName());
                selectedDataBean.setData(bean.getO().getDataList().get(i));
                selectedDataBeans.add(selectedDataBean);
            }
            MyPopOneListPicker productPicker = new MyPopOneListPicker(getContext(), selectedDataBeans, new MyPopOneListPicker.Pop_selectedListenner() {
                @Override
                public void getData(SelectedDataBean data) {
                    productBean = (ProductListBean.ResultBean.DataListBean) data.getData();
                    lineProductName.setSecondaryText(productBean.getProductName());
                    lineProductModel.setSecondaryText(productBean.getProductModel());
                    lineProductBrand.setSecondaryText(productBean.getProductBrand());
                    productBean.setSoft(!is_soft);
                    productGUID = productBean.getProductGUID();
                    clearMechineCode();
                    clearProblem();
                }
            });
            productPicker.show();
        }

        if (data instanceof SoftListBean) {
            SoftListBean bean = (SoftListBean) data;
            List<SelectedDataBean> selectedDataBeans = new ArrayList<>();
            for (int i = 0; i < bean.getO().getDataList().size(); i++) {
                SelectedDataBean selectedDataBean = new SelectedDataBean(bean.getO().getDataList().get(i).getId(),
                        bean.getO().getDataList().get(i).getDeviceSoftName());
                selectedDataBean.setData(bean.getO().getDataList().get(i));
                selectedDataBeans.add(selectedDataBean);
            }
            MyPopOneListPicker popOneListPicker = new MyPopOneListPicker(getContext(), selectedDataBeans, new MyPopOneListPicker.Pop_selectedListenner() {
                @Override
                public void getData(SelectedDataBean data) {
                    SoftListBean.ResultBean.DataListBean bean = (SoftListBean.ResultBean.DataListBean) data.getData();
                    productGUID = bean.getProductGUID();
                    lineBrand.setSecondaryText(bean.getDeviceSoftBrand());
                    lineSystemName.setSecondaryText(bean.getDeviceSoftName());
                    lineConstructure.setSecondaryText(bean.getDeviceSoftFrameworkStr());
                    clearProblem();
                }
            });
            popOneListPicker.show();
        }


        super.onSuccess(data);
        mZProgressHUD.dismiss();
        if (data.getUrl().equals(ConstantUrl.createWorkUrl)) {
            ToastUtil.toast("创建成功");
            finish();
            return;
        }
    }

    //清除设备码
    private void clearMechineCode() {
        selectMechineCode = null;
        lineMechineCode.setSecondaryText("-");
        lineMechinAddress.setSecondaryText("-");
        lineDeviceCode.setSecondaryText("-");
    }

    //清除问题
    private void clearProblem() {
        textViewPrblems.setText("");
        selecteProblemIds = "";
    }

    //清除产品
    private void clearProduct() {
        productGUID = "";
        lineProductName.setSecondaryText("-");
        lineProductModel.setSecondaryText("-");
        lineBrand.setSecondaryText("-");
        lineSystemName.setSecondaryText("-");
        lineConstructure.setSecondaryText("-");
        lineProductBrand.setSecondaryText("-");
    }

    @Override
    public void onError(Exception e) {
        mZProgressHUD.dismiss();
    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {
        mZProgressHUD.dismiss();
    }

    @Subscribe
    public void getMechineCodeEvent(MechineCodeListBean.ResultBean.DataListBean bean) {
        selectMechineCode = bean;
        lineMechineCode.setSecondaryText(bean.getDeviceMachineCode());
        lineMechinAddress.setSecondaryText(bean.getDeviceAddress());
        lineDeviceCode.setSecondaryText(bean.getDeviceCode());
        //选完之后清除一下问题
        clearProblem();
    }

    @Subscribe
    public void getProblemsEvent(ArrayList<ProblemDataBean.ResultBean.DataListBean> dataListBean) {
        selecteProblemIds = UploadFileRequest.getIdsStringSpell(dataListBean, ";");
        StringBuffer problemRemarks = new StringBuffer("");
        for (int i = 0; i < dataListBean.size(); i++) {
            if (i == dataListBean.size() - 1) {
                problemRemarks.append(dataListBean.get(i).getProductProblemRemark());
            } else {
                problemRemarks.append(dataListBean.get(i).getProductProblemRemark() + ";\n");
            }
        }
        textViewPrblems.setText(problemRemarks.toString());

    }

    public void gotoSelectMechineCode(View view) {
        if (TextUtils.isEmpty(productGUID)) {
            ToastUtil.toast("请先选择设备信息");
            return;
        }
        MechineDetailsBean.ResultBean resultBean = new MechineDetailsBean.ResultBean();
        resultBean.setProductGUID(productGUID);
        resultBean.setSchoolUnitGUID(schoolUnitGUID);
        resultBean.setRepairBusinessGUID(schoolBean.getRepairBusinessGUID());
        SelectedMechineCodeActivity.start(getContext(), SelectedMechineCodeActivity.class, resultBean);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    //选择设备
    public void selectDevice(View view) {
        if (schoolBean == null) {
            ToastUtil.toast("请先选择单位");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("schoolUnitGUID", schoolBean.getSchoolUnitGUID());
        RequestBean request = RequestMaker.getRequest(map);
        request.setOrder("productName desc");
        post(ConstantUrl.productListUrl02, request, new ProductListBean());
    }

    //选择学校
    public void selecteUnit(View view) {
        Map<String, String> map = new HashMap<>();
        map.put("repairBusinessGUID", LoginStatus.getLoginBean().getO().getRepairBusinessGUID());
        RequestBean request = RequestMaker.getRequest(map);
        request.setOrder("repairBusinessName desc");
        post(ConstantUrl.schoolListUrl, request, new SchoolListBean());
    }


    //切换是软件还是硬件
    public void changeHardSoft(View view) {
        List<SelectedDataBean> datas = new ArrayList<>();
        SelectedDataBean selectedDataBean = new SelectedDataBean("0", "软件设备");
        datas.add(selectedDataBean);
        selectedDataBean = new SelectedDataBean("1", "硬件设备");
        datas.add(selectedDataBean);
        MyPopOneListPicker popOneListPicker = new MyPopOneListPicker(getContext(), datas, new MyPopOneListPicker.Pop_selectedListenner() {
            @Override
            public void getData(SelectedDataBean data) {
                if (data.getId().equals("0")) {
                    is_soft = true;
                } else {
                    is_soft = false;
                }
                linearlayoutSoft.setVisibility(is_soft ? View.VISIBLE : View.GONE);
                linearlayoutHard.setVisibility(!is_soft ? View.VISIBLE : View.GONE);
                clearProblem();
                clearMechineCode();
                clearProduct();
            }
        });
        popOneListPicker.show();
    }


    //选择软件名称
    public void selectSoft(View view) {
        Map<String, String> map = new HashMap<>();
        map.put("deviceType", "软件");
        RequestBean request = RequestMaker.getRequest(map, "CreateTime desc", "nvarchar", "eq");
//        List<String[]> datas = new ArrayList<>();
//        String data01[] = {"deviceType", "uniqueidentifier", "eq", "软件"};
//        String data03[]={"qrCodeGUID","uniqueidentifier","eq",ConstantString.NULL_ID};
//        String data02[]={"deviceMachineCode","nvarchar","like",ConstantString.NULL_ID};
//        datas.add(data01);
//        datas.add(data02);
//        datas.add(data03);
        post(ConstantUrl.mechineCodeList, request, new SoftListBean());
    }
}
