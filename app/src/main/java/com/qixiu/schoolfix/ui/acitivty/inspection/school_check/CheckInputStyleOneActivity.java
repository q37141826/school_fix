package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

public class CheckInputStyleOneActivity extends RequestActivity {

    @BindView(R.id.edttextCode)//端口号
            EditText edittextCode;
    @BindView(R.id.edittextChipCode)//电信纤芯号
            EditText edittextChipCode;
    @BindView(R.id.edittextModuleType)//网线
            EditText edittextModuleType;
    @BindView(R.id.editextNetLine)//网线
            EditText editextNetLine;
    @BindView(R.id.edittextInterface)//跳纤接口
            EditText edittextInterface;
    @BindView(R.id.edittextInterfaceLength)//跳纤长度
            EditText edittextInterfaceLength;
    @BindView(R.id.edittextInterface02)//机框式
            EditText edittextInterface02;
    @BindView(R.id.edittextInterfaceLength02)//1U机架式
            EditText edittextInterfaceLength02;
    @BindView(R.id.edittextEnergeNum)//安装电源数量
            EditText edittextEnergeNum;
    @BindView(R.id.switchPowerSafe)//电源线是否固定安全
            SwitchAndOpenView switchPowerSafe;
    @BindView(R.id.switchLineState)//是否整齐
            SwitchAndOpenView switchLineState;
    @BindView(R.id.switchPowerNewlyAdded)//是否新增
            SwitchAndOpenView switchPowerNewlyAdded;
    @BindView(R.id.switchPowerIsWarning)//是否报警
            SwitchAndOpenView switchPowerIsWarning;
    @BindView(R.id.switchPowerClear)//是否清理
            SwitchAndOpenView switchPowerClear;
    @BindView(R.id.edittextOther)//交换机其他
            EditText edittextOther;
    @BindView(R.id.lineConSign)
    LineControllerView lineConSign;
    @BindView(R.id.btnConfirm)
    Button btnConfirm;

    @BindView(R.id.edittextOpticalApertureNum)
    EditText edittextOpticalApertureNum;
    @BindView(R.id.edittextOpticalApertureUsedNum)
    TextView edittextOpticalApertureUsedNum;
    @BindView(R.id.edittextElectricNum)
    EditText edittextElectricNum;
    @BindView(R.id.edittextElectricUsedNum)
    EditText edittextElectricUsedNum;


    private CheckMainSchoolBean.ResultBean.DataListBean dataListBean;
    private CheckStepMoudleBean checkStepOneMoudleBean;
    private CheckInputTypeName checkInputTypeName;

    private String signUrl;//签名地址


    @Override
    protected void onInitData() {
        dataListBean = getIntent().getParcelableExtra(IntentDataKeyConstant.DATA);
        mTitleView.setTitle("交换机一检测");
        mTitleView.setRightText("测试");
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckInputHouseActivity.start(getContext(), CheckInputHouseActivity.class, dataListBean);
            }
        });
        //获取字段
        getData();
    }

    private void getData() {
        Map<String, String> map = new HashMap<>();
        map.put("userGUID", LoginStatus.getToken());
        map.put("checkPointGUID", dataListBean.getCheckPointGUID());
        map.put("checkReportType", 1 + "");//巡检报告类型(1,交换机;2,机房;3,网络设备) 传数值
        map.put("checkDate", TimeDataUtil.getTimeStamp(new Date().getTime(), TimeDataUtil.DEFULT_DATE_FORMAT) + " 00:00:00");
        post(ConstantUrl.checkReportKeyUrl, map, new CheckStepMoudleBean());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_check_input_style_one;
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (data.getUrl().equals(ConstantUrl.saveReportKeyUrl)) {
            ToastUtil.toast("保存成功");
            CheckInputHouseActivity.start(getContext(), CheckInputHouseActivity.class, dataListBean);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void confirmCheck(View v) {
//        saveData();

        //学校交换机当前与教育连接
        //"key": "端口号",
        putDataIn(edittextCode.getText().toString(), "学校交换机当前与教育连接的端口", "端口号");
        //学校交换机当前与教育连接
        //"key": "电信纤芯号",
        putDataIn(edittextChipCode.getText().toString(), "学校交换机当前与教育连接的端口", "电信纤芯号");
        //            "groupName": "学校交换机与教育网连接类型",
        // "key": "光模块型号",
        putDataIn(edittextModuleType.getText().toString(), "学校交换机与教育网连接类型", "光模块型号");
        //            "groupName": "学校交换机与教育网连接类型",
        //"key": "网线",
        putDataIn(editextNetLine.getText().toString(), "学校交换机与教育网连接类型", "网线");
        //            "groupName": "连接教育网的光纤模块光纤跳迁信息",
        //"key": "跳纤接口",
        putDataIn(edittextInterface.getText().toString(), "连接教育网的光纤模块光纤跳迁信息", "跳纤接口");
        //            "groupName": "连接教育网的光纤模块光纤跳迁信息",
        //"key": "跳纤长度",
        putDataIn(edittextInterfaceLength.getText().toString(), "连接教育网的光纤模块光纤跳迁信息", "跳纤长度");
        //            "groupName": "交换机外观及端口使用情况",
        //"key": "机框式",
        putDataIn(edittextInterface02.getText().toString(), "交换机外观及端口使用情况", "机框式");
        //            "groupName": "交换机外观及端口使用情况",
        //"key": "机框式",
        putDataIn(edittextInterfaceLength02.getText().toString(), "交换机外观及端口使用情况", "1U机架式");
        //"key": "光口数量",
        putDataIn(edittextOpticalApertureNum.getText().toString(), "交换机外观及端口使用情况", "光口数量");
        //"key": "光口使用数量",
        putDataIn(edittextOpticalApertureUsedNum.getText().toString(), "交换机外观及端口使用情况", "光口使用数量");
        //"key": "电口数量",
        putDataIn(edittextElectricNum.getText().toString(), "交换机外观及端口使用情况", "电口数量");    //"key": "电口数量",
        //   "key": "电口使用数量",
        putDataIn(edittextElectricUsedNum.getText().toString(), "交换机外观及端口使用情况", "电口使用数量");
        //    "groupName": 交换机电源信息
        //key 安装电源数量
        putDataIn(edittextEnergeNum.getText().toString(), "交换机电源信息", "安装电源数量");
        //                    "key": "电源线是否固定安全",就传 1和0 1是 0否
        putDataIn((switchPowerSafe.isOpened() ? "1" : "0"), "交换机电源信息", "电源线是否固定安全");
        //  "key": "处理措施",
        putDataIn(switchPowerSafe.getInput().toString(), "交换机电源信息", "处理措施");
        //    "groupName":  交换机线路连接情况
        //    "key": "是否整齐",
        putDataIn((switchLineState.isOpened() ? "1" : "0"), "交换机线路连接情况", "是否整齐");
        //  "key": "处理措施",
        putDataIn(switchLineState.getInput().toString(), "交换机线路连接情况", "处理措施");
        //            "groupName": "交换机上有新增线路",
        //  "key":    是否有新增
        putDataIn((switchPowerNewlyAdded.isOpened() ? "1" : "0"), "交换机上有新增线路", "是否有新增");
        //  "key": "处理措施",
        putDataIn(switchPowerNewlyAdded.getInput().toString(), "交换机上有新增线路", "处理措施");

        //            "groupName":  交换机散热风扇情况
        //  "key":    是否报警
        putDataIn((switchPowerIsWarning.isOpened() ? "1" : "0"), "交换机散热风扇情况", "是否报警");
        //  "key": "处理措施",
        putDataIn(switchPowerIsWarning.getInput().toString(), "交换机散热风扇情况", "处理措施");

        //            "groupName":   "交换机周边灰尘清理"
        // "key": "是否清理",
        putDataIn((switchPowerClear.isOpened() ? "1" : "0"), "交换机周边灰尘清理", "是否清理");
        //  "key": "处理措施",
        putDataIn(switchPowerClear.getInput().toString(), "交换机周边灰尘清理", "处理措施");

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
        map.put("checkReportType", 1 + "");
        map.put("checkReportValue", json);
        map.put("checkSignUrl", signUrl);
        map.put("checkReportDate", checkStepOneMoudleBean.getO().getCheckReportDate());
        post(ConstantUrl.saveReportKeyUrl, map, new BaseBean());
    }


    public void putDataIn(String text, String groupName, String key) {
        for (int i = 0; i < checkInputTypeName.getCheckReportValue().size(); i++) {
            if (groupName.equals(checkInputTypeName.getCheckReportValue().get(i).getGroupName())) {
                for (int j = 0; j < checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().size(); j++) {
                    if (checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().get(j).getKey().equals(key)) {
                        checkInputTypeName.getCheckReportValue().get(i).getReportTemplateOptionDtos().get(j).setValue(text);
                    }
                }
            }
        }
    }


    //签名
    public void signNameClick(View view) {
        Intent intent = new Intent(this, SignNameActivity.class);
        startActivityForResult(intent, 1000);
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
