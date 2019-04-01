package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.model.UploadFileBean;
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

public class CheckInputHouseActivity extends RequestActivity {
    String signUrl;

    CheckMainSchoolBean.ResultBean.DataListBean dataListBean;
    @BindView(R.id.switchPowerSwitch)
    SwitchAndOpenView switchPowerSwitch;
    @BindView(R.id.switchFoorWater)
    SwitchAndOpenView switchFoorWater;
    @BindView(R.id.switchFireInPeriod)
    SwitchAndOpenView switchFireInPeriod;
    @BindView(R.id.switchWarningMechine)
    SwitchAndOpenView switchWarningMechine;
    @BindView(R.id.switchDampToxin)
    SwitchAndOpenView switchDampToxin;
    @BindView(R.id.switchEnvironmentalData)
    SwitchAndOpenView switchEnvironmentalData;
    @BindView(R.id.switchLineNeat)
    SwitchAndOpenView switchLineNeat;
    @BindView(R.id.switchNewlyAddLine)
    SwitchAndOpenView switchNewlyAddLine;
    @BindView(R.id.switchIsLinked)
    SwitchAndOpenView switchIsLinked;
    @BindView(R.id.switchSignClear)
    SwitchAndOpenView switchSignClear;
    @BindView(R.id.switchDustClean)
    SwitchAndOpenView switchDustClean;
    @BindView(R.id.switchHouseClean)
    SwitchAndOpenView switchHouseClean;
    @BindView(R.id.switchImpurityStacking)
    SwitchAndOpenView switchImpurityStacking;
    @BindView(R.id.switchCameraRecord)
    SwitchAndOpenView switchCameraRecord;
    @BindView(R.id.edittextOther)
    EditText edittextOther;
    @BindView(R.id.lineConSign)
    LineControllerView lineConSign;
    private CheckInputTypeName checkInputTypeName;
    private CheckStepMoudleBean checkStepOneMoudleBean;

    @Override
    protected void onInitData() {
        dataListBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
        mTitleView.setTitle("网络设备一检测");
        mTitleView.setRightText("测试");
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckNetEquipmentActivity.start(getContext(), CheckNetEquipmentActivity.class, dataListBean);
            }
        });
        //获取字段
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

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_check_input_house;
    }

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
        if (data.getUrl().equals(ConstantUrl.saveReportKeyUrl)) {
            ToastUtil.toast("保存成功");
            CheckNetEquipmentActivity.start(getContext(), CheckNetEquipmentActivity.class, dataListBean);
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

    public void confirmCheck(View v) {
        //  "groupName": "机房环境",
        //   "key": "电力箱电闸是否正常",
        putDataIn((switchPowerSwitch.isOpened() ? "1" : "0"), "机房环境", "电力箱电闸是否正常");
        //  "key": "处置情况",
        putDataIn(switchPowerSwitch.getInput().toString(), "机房环境", "电力箱电闸是否正常处置情况");//todo 填写完整参数
        //     "key": "静电地板下是否有杂物积水",
        putDataIn((switchFoorWater.isOpened() ? "1" : "0"), "机房环境", "静电地板下是否有杂物积水");
        //      "key": "处置情况",
        putDataIn((switchFoorWater.getInput().toString()), "机房环境", "静电地板下是否有杂物积水处置情况");
        //   "key": "机房内灭火器是否在有效期内",
        putDataIn((switchFireInPeriod.isOpened() ? "1" : "0"), "机房环境", "机房内灭火器是否在有效期内");
        //      "key": "处置情况",
        putDataIn((switchFireInPeriod.getInput().toString()), "机房环境", "机房内灭火器是否在有效期内处置情况");
        //                      "key": "空调、烟感、警铃、防爆灯、UPS是否正常",
        putDataIn((switchWarningMechine.isOpened() ? "1" : "0"), "机房环境", "空调、烟感、警铃、防爆灯、UPS是否正常");
        //   "key": "处置情况",
        putDataIn((switchWarningMechine.getInput().toString()), "机房环境", "空调、烟感、警铃、防爆灯、UPS是否正常处置情况");
        //                "key": "机房、机柜内温湿度及传感器数据是否正常",
        putDataIn((switchDampToxin.isOpened() ? "1" : "0"), "机房环境", "机房、机柜内温湿度及传感器数据是否正常");
        //  "key": "处置情况",
        putDataIn((switchDampToxin.getInput().toString()), "机房环境", "机房、机柜内温湿度及传感器数据是否正常处置情况");
        //                "key": "机房内环控监测设备数据采集是否正常",
        putDataIn((switchEnvironmentalData.isOpened() ? "1" : "0"), "机房环境", "机房内环控监测设备数据采集是否正常");
        //   "key": "处置情况",
        putDataIn((switchEnvironmentalData.getInput().toString()), "机房环境", "机房内环控监测设备数据采集是否正常处置情况");

        //  "groupName": "线路检查",
        // "key": "强弱电线路是否整齐",
        putDataIn((switchLineNeat.isOpened() ? "1" : "0"), "线路检查", "强弱电线路是否整齐");
        //"key": "处置情况",
        putDataIn((switchLineNeat.getInput().toString()), "线路检查", "机房内环控监测设备数据采集是否正常处置情况");
        //  "key": "机房内是否无新增线缆",
        putDataIn((switchNewlyAddLine.isOpened() ? "1" : "0"), "线路检查", "机房内是否无新增线缆");
        //  "key": "处置情况",
        putDataIn((switchNewlyAddLine.getInput().toString()), "线路检查", "机房内是否无新增线缆处置情况");

        //  "key": "设备电源线是否整齐、合理，所有设备电源线是否连接到PDU上",
        putDataIn((switchIsLinked.isOpened() ? "1" : "0"), "线路检查", "设备电源线是否整齐、合理，所有设备电源线是否连接到PDU上");
        //  "key": "处置情况",
        putDataIn((switchIsLinked.getInput().toString()), "线路检查", "设备电源线是否整齐、合理，所有设备电源线是否连接到PDU上处置情况");

        //   "key": "所有线路、设备以及电源线标签是否清楚",
        putDataIn((switchSignClear.isOpened() ? "1" : "0"), "线路检查", "所有线路、设备以及电源线标签是否清楚");
        //  "key": "处置情况",
        putDataIn((switchSignClear.getInput().toString()), "线路检查", "所有线路、设备以及电源线标签是否清楚处置情况");

        // "groupName": "机房卫生检查",
        //                  "key": "设备除尘",
        putDataIn((switchDustClean.isOpened() ? "0" : "1"), "机房卫生检查", "设备除尘");
        //  "key": "处置情况",
        putDataIn((switchDustClean.getInput().toString()), "机房卫生检查", "设备除尘处置情况");

        //   "key": "机房清扫",
        putDataIn((switchHouseClean.isOpened() ? "0" : "1"), "机房卫生检查", "机房清扫");
        //  "key": "处置情况",
        putDataIn((switchHouseClean.getInput().toString()), "机房卫生检查", "机房清扫处置情况");
        //              "key": "机房无杂物堆放",
        putDataIn((switchImpurityStacking.isOpened() ? "0" : "1"), "机房卫生检查", "机房无杂物堆放");
        //  "key": "处置情况",
        putDataIn((switchImpurityStacking.getInput().toString()), "机房卫生检查", "机房无杂物堆放处置情况");
        //     "key": "各机房拍照记录",
        putDataIn((switchCameraRecord.isOpened() ? "0" : "1"), "机房卫生检查", "各机房拍照记录");
        //  "key": "处置情况",
        putDataIn((switchCameraRecord.getInput().toString()), "机房卫生检查", "各机房拍照记录处置情况");


        saveData();
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
        map.put("checkReportDate",checkStepOneMoudleBean.getO().getCheckReportDate());
        post(ConstantUrl.saveReportKeyUrl, map, new BaseBean());
    }

    //签名
    public void signNameClick(View view) {
        Intent intent = new Intent(this, SignNameActivity.class);
        startActivityForResult(intent, 1000);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
