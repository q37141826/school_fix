package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.BuildConfig;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.model.UploadFileBean;
import com.qixiu.schoolfix.model.check_mechine.CheckFinnalResultBean;
import com.qixiu.schoolfix.model.check_mechine.CheckInputTypeName;
import com.qixiu.schoolfix.model.check_mechine.CheckMainSchoolBean;
import com.qixiu.schoolfix.model.check_mechine.CheckStepMoudleBean;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.report.SignNameActivity;
import com.qixiu.schoolfix.ui.wight.SwitchAndOpenView;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.schoolfix.utils.reuestutil.UploadFileRequest;
import com.qixiu.widget.LineControllerView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckNetEquipmentActivity extends RequestActivity {
    String signUrl;
    CheckMainSchoolBean.ResultBean.DataListBean dataListBean;


    @BindView(R.id.switchNoteCheck)
    SwitchAndOpenView switchNoteCheck;
    @BindView(R.id.edittextRegisterNum)
    EditText edittextRegisterNum;
    @BindView(R.id.edittextOnlineNum)
    EditText edittextOnlineNum;
    @BindView(R.id.edittextOfflineResion)
    EditText edittextOfflineResion;
    @BindView(R.id.edittextCoreToHouseChips)
    EditText edittextCoreToHouseChips;
    @BindView(R.id.switchHaveOpiticalTransceiver)
    SwitchAndOpenView switchHaveOpiticalTransceiver;
    @BindView(R.id.edittextRepCorrection)
    EditText edittextRepCorrection;
    @BindView(R.id.switchCanAccess)
    SwitchAndOpenView switchCanAccess;
    @BindView(R.id.switchNetLogCheck)
    SwitchAndOpenView switchNetLogCheck;
    @BindView(R.id.switchOpticalFiberLossCheck)
    SwitchAndOpenView switchOpticalFiberLossCheck;
    @BindView(R.id.switchNVR)
    SwitchAndOpenView switchNVR;
    @BindView(R.id.switchService)
    SwitchAndOpenView switchService;
    @BindView(R.id.edittextOther)
    EditText edittextOther;
    @BindView(R.id.lineConSign)
    LineControllerView lineConSign;
    @BindView(R.id.btnConfirm)
    Button btnConfirm;
    private CheckInputTypeName checkInputTypeName;
    private CheckStepMoudleBean checkStepOneMoudleBean;

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof CheckStepMoudleBean) {
            checkStepOneMoudleBean = (CheckStepMoudleBean) data;
            try {
                String json = checkStepOneMoudleBean.getO().getCheckReportValue().replace("\\", "");
                json = "{ \"checkReportValue\":" + json + "}";
                Gson gson = new Gson();
                checkInputTypeName = gson.fromJson(json, CheckInputTypeName.class);
                //菜鸟后台返回的数据没有ID，这个时候我自己拼接一个作为唯一识别
                setIds();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (data instanceof CheckFinnalResultBean) {
            CheckFinnalResultBean bean= (CheckFinnalResultBean) data;
            ToastUtil.toast("保存成功");
//            GoToActivity.WebBean webBean=new GoToActivity.WebBean();
//            webBean.setUrl(BuildConfig.BASE_URL + "EduAPP/Index.html#/inspectionSign?id=" + bean.getO().getId());
//            webBean.setTitle("巡检签名");
            QRCheckActivity.start(getContext(), QRCheckActivity.class,BuildConfig.BASE_URL + "EduAPP/Index.html#/inspectionSign?id=" + bean.getO().getId() );
        }
    }

    private void setIds() {
        for (int i = 0; i < checkInputTypeName.getCheckReportValue().size(); i++) {
            for (int j = 0; j < checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().size(); j++) {
                if (checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().get(j).getKey().equals("处置情况")) {
                    checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().get(j).setId
                            (checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().get(j - 1).getKey() + "处置情况");
                } else {
                    checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().get(j).setId
                            (checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().get(j).getKey());
                }
            }
        }
    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    @Override
    protected void onInitViewNew() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onInitData() {
        dataListBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
        mTitleView.setTitle("网络设备—检测");
        mTitleView.setRightText("测试");
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                GotoQrCodeWebActivity.start(getContext(), GotoQrCodeWebActivity.class, BuildConfig.BASE_URL + "EduAPP/Index.html#/inspectionSign?id=" + dataListBean.getId());
            }
        });
        getData();
    }

    private void getData() {
        Map<String, String> map = new HashMap<>();
        map.put("userGUID", LoginStatus.getToken());
        map.put("checkPointGUID", dataListBean.getCheckPointGUID());
        map.put("checkReportType", 2 + "");//巡检报告类型(1,交换机;2,机房;3,网络设备) 传数值
        map.put("checkDate", TimeDataUtil.getTimeStamp(new Date().getTime(), TimeDataUtil.DEFULT_DATE_FORMAT) + " 00:00:00");
        post(ConstantUrl.checkReportKeyUrl, map, new CheckStepMoudleBean());
    }

    public void confirmCheck(View v) {
        // "groupName": "行为管理设备日志检查",
        //          "key": "日志检查",
        putDataIn((switchNoteCheck.isOpened() ? "1" : "0"), "行为管理设备日志检查", "日志检查");
        //  "key": "处置情况",
        putDataIn(switchNoteCheck.getInput().toString(), "行为管理设备日志检查", "行为管理设备日志检查处置情况");
        //  "key": "无线AP登记数量",
        putDataIn(edittextRegisterNum.getText().toString(), "行为管理设备日志检查", "无线AP登记数量");
        //     "key": "无线AP在线数量",
        putDataIn(edittextOnlineNum.getText().toString(), "行为管理设备日志检查", "无线AP在线数量");
        //                "key": "无线AP不在线原因",
        putDataIn(edittextOfflineResion.getText().toString(), "行为管理设备日志检查", "无线AP不在线原因");
        //    "key": "核心到各分机房光缆可用芯数情况",
        putDataIn(edittextCoreToHouseChips.getText().toString(), "行为管理设备日志检查", "核心到各分机房光缆可用芯数情况");
        //  "key": "核心到各分机房是否无光纤收发器",
        putDataIn(switchHaveOpiticalTransceiver.isOpened() ? "1" : "0", "行为管理设备日志检查", "核心到各分机房是否无光纤收发器");
        //  "key": "处置情况",
        putDataIn(switchHaveOpiticalTransceiver.getInput().toString(), "行为管理设备日志检查", "核心到各分机房是否无光纤收发器处置情况");
        //  "key": "光纤收发器替换整改情况",
        putDataIn(edittextRepCorrection.getText().toString(), "行为管理设备日志检查", "光纤收发器替换整改情况");
        //  "key": "各机房网络设备网管地址是否可访问",
        putDataIn(switchCanAccess.isOpened() ? "1" : "0", "行为管理设备日志检查", "各机房网络设备网管地址是否可访问");
        //  "key": "处置情况",
        putDataIn(switchCanAccess.getInput().toString(), "行为管理设备日志检查", "各机房网络设备网管地址是否可访问处置情况");

        // "key": "各机房网络设备日志检查是否正常",
        putDataIn(switchNetLogCheck.isOpened() ? "1" : "0", "行为管理设备日志检查", "各机房网络设备日志检查是否正常");
        //  "key": "处置情况",
        putDataIn(switchNetLogCheck.getInput().toString(), "行为管理设备日志检查", "各机房网络设备日志检查是否正常处置情况");

        //    "key": "各机房网络设备光纤损耗检测是否正常",
        putDataIn(switchOpticalFiberLossCheck.isOpened() ? "1" : "0", "行为管理设备日志检查", "各机房网络设备光纤损耗检测是否正常");
        //  "key": "处置情况",
        putDataIn(switchOpticalFiberLossCheck.getInput().toString(), "行为管理设备日志检查", "各机房网络设备光纤损耗检测是否正常处置情况");
        //"key": "NVR监控主机是否正常",
        putDataIn(switchNVR.isOpened() ? "1" : "0", "行为管理设备日志检查", "NVR监控主机是否正常");
        //  "key": "处置情况",
        putDataIn(switchNVR.getInput().toString(), "行为管理设备日志检查", "NVR监控主机是否正常处置情况");
        //                "key": "服务器是否正常工作",
        putDataIn(switchService.isOpened() ? "1" : "0", "行为管理设备日志检查", "服务器是否正常工作");
        //  "key": "处置情况",
        putDataIn(switchService.getInput().toString(), "行为管理设备日志检查", "服务器是否正常工作处置情况");

        saveData();
    }

    public void putDataIn(String text, String groupName, String id) {
        for (int i = 0; i < checkInputTypeName.getCheckReportValue().size(); i++) {
            if (groupName.equals(checkInputTypeName.getCheckReportValue().get(i).getGroupName())) {
                for (int j = 0; j < checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().size(); j++) {
                    if (checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().get(j).getId().equals(id)) {
                        checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().get(j).setValue(text);
                    }
                }
            }
        }
    }

    private void saveData() {
        if (TextUtils.isEmpty(signUrl)) {
            ToastUtil.toast("请签字");
            return;
        }
        Gson gson = new Gson();
        String json = gson.toJson(checkInputTypeName);
        json = json.substring("checkReportValue".length() + 4, json.length() - 1);
        Map<String, String> map = new HashMap<>();
        map.put("id", checkStepOneMoudleBean.getO().getId());
        map.put("checkPointGUID", dataListBean.getCheckPointGUID());
        map.put("checkReportType", 2 + "");
        map.put("checkReportValue", json);
        map.put("checkSignUrl", signUrl);
        post(ConstantUrl.saveReportKeyUrl, map, new CheckFinnalResultBean());
    }


    //签名
    public void signNameClick(View view) {
        Intent intent = new Intent(this, SignNameActivity.class);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_check_net_equipment;
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
            String path = data.getStringExtra(IntentDataKeyConstant.FILE_PATH);
            if (!TextUtils.isEmpty(path)) {
                UploadFileRequest.uploadFile(path, new UploadFileRequest.UploadFileCallBack<UploadFileBean>() {
                    @Override
                    public void call(UploadFileBean baseBean) {
                        signUrl = baseBean.getO();
                        lineConSign.setSecondaryText("签名已保存");
                    }

                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onFailue() {

                    }
                });
            }
        }
    }
}
