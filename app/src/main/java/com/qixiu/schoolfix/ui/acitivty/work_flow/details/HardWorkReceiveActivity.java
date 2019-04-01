package com.qixiu.schoolfix.ui.acitivty.work_flow.details;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.DownLoadFileUtils;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.qixiu.utils.audio.SoundUtils;
import com.qixiu.schoolfix.BuildConfig;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.schoolfix.utils.reuestutil.RequestMaker;
import com.qixiu.widget.LineControllerView;
import com.qixiu.wigit.picker.MyPopOneListPicker;
import com.qixiu.wigit.picker.SelectedDataBean;
import com.qixiu.wigit.show_dialog.ArshowContextUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.qixiu.schoolfix.constant.ConstantUrl.giveOrderUrl;
import static com.qixiu.schoolfix.ui.acitivty.work_flow.details.HardWorkDetailsActivity.ORDER_WATING;

public class HardWorkReceiveActivity extends RequestActivity {


    @BindView(R.id.iamgeViewProduct)
    ImageView iamgeViewProduct;
    @BindView(R.id.textViewProductName)
    TextView textViewProductName;
    @BindView(R.id.textViewMechineCode)
    LineControllerView textViewMechineCode;
    @BindView(R.id.textViewDeviceCode)
    LineControllerView textViewDeviceCode;
    @BindView(R.id.textViewServiceObject)
    LineControllerView textViewServiceObject;
    @BindView(R.id.textViewDepartName)
    LineControllerView textViewDepartName;
    @BindView(R.id.textViewCity)
    LineControllerView textViewCity;
    @BindView(R.id.textViewAddress)
    LineControllerView textViewAddress;
    @BindView(R.id.textViewContactPerson)
    LineControllerView textViewContactPerson;
    @BindView(R.id.textViewContactPhone)
    LineControllerView textViewContactPhone;
    @BindView(R.id.textViewExpectTime)
    LineControllerView textViewExpectTime;
    @BindView(R.id.textViewHandelPerson)
    LineControllerView textViewHandelPerson;
    @BindView(R.id.textViewTicketNumber)
    LineControllerView textViewTicketNumber;
    @BindView(R.id.textViewCommitTime)
    LineControllerView textViewCommitTime;
    @BindView(R.id.lineearLayoutSignOrFinish)
    LinearLayout lineearLayoutSignOrFinish;
    @BindView(R.id.btnRecice)
    Button btnRecice;
    @BindView(R.id.textViewPrblems)
    TextView textViewPrblems;
    @BindView(R.id.recyclerViewPic)
    RecyclerView recyclerViewPic;
    @BindView(R.id.imageViewSound)
    ImageView imageViewSound;
    @BindView(R.id.iamgeView_play_voice)
    ImageView iamgeViewPlayVoice;
    @BindView(R.id.linearProblem)
    LinearLayout linearProblem;
    private String id;
    private WorkDetailsBean workDetailsBean;

    SelectedDataBean selectePerson;//选中的人

    @BindView(R.id.imageViewGotoProblem)
    ImageView imageViewGotoProblem;

    @Override
    protected void onInitData() {
        lineearLayoutSignOrFinish.setVisibility(View.GONE);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_hard_work_receive;
    }

    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("齐科信息");
        id = getIntent().getStringExtra(IntentDataKeyConstant.DATA);
        post(ConstantUrl.workDetailsUrl + id, new HashMap(), new WorkDetailsBean());
        imageViewGotoProblem.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof WorkDetailsBean) {
            workDetailsBean = (WorkDetailsBean) data;
            Glide.with(getContext()).load(workDetailsBean.getO().getProductImgUrl()).into(iamgeViewProduct);
            textViewProductName.setText(workDetailsBean.getO().getProductName());
            textViewMechineCode.setSecondaryText(workDetailsBean.getO().getDeviceMachineCode());
            textViewDeviceCode.setSecondaryText(workDetailsBean.getO().getDeviceCode());
            textViewServiceObject.setSecondaryText(workDetailsBean.getO().getSchoolUnitServiceName());
            textViewDepartName.setSecondaryText(workDetailsBean.getO().getWorkOrderSubmitUnit());

            textViewContactPerson.setSecondaryText(workDetailsBean.getO().getWorkOrderSubmitName());
            textViewContactPhone.setSecondaryText(workDetailsBean.getO().getWorkOrderSubmitTel());
            textViewAddress.setSecondaryText(workDetailsBean.getO().getSchoolUnitAddress());
            textViewAddress.getSecondaryTextView().setPadding(ArshowContextUtil.dp2px(40), 0, 0, 0);
            textViewCity.setSecondaryText(workDetailsBean.getO().getSchoolUnitArea());
            try {
                textViewExpectTime.setSecondaryText(workDetailsBean.getO().getWorkOrderExpectTime());
            } catch (Exception e) {
            }
            textViewHandelPerson.setSecondaryText(LoginStatus.getLoginBean().getO().getRepairBusinessName());
            textViewTicketNumber.setSecondaryText(workDetailsBean.getO().getWorkOrderServiceNo());
            textViewCommitTime.setSecondaryText(workDetailsBean.getO().getWorkOrderCreatime());

            if (workDetailsBean.getO().getWorkOrderTypeStr().equals(ORDER_WATING)) {
                btnRecice.setText("指派");
            }
            HardWorkDetailsDataSetting.setProblemPic(recyclerViewPic, workDetailsBean.getO().getWorkOrderCstProblemImgUrl(), getActivity());
            textViewPrblems.setText(workDetailsBean.getO().getWorkOrderCstProblemRemark());
            imageViewSound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (TextUtils.isEmpty(workDetailsBean.getO().getWorkOrderProblemMP3Url())) {
                        ToastUtil.toast("音频文件丢失了");
                        return;
                    }
                    showProgress();
                    String url = BuildConfig.BASE_URL + workDetailsBean.getO().getWorkOrderProblemMP3Url().replace("'", "");
                    DownLoadFileUtils.InitFile.callFile(url.replace("\\", "/"), new DownLoadFileUtils.FileCallBack() {
                        @Override
                        public void callBack(String path) {
                            mZProgressHUD.dismiss();
                            if (TextUtils.isEmpty(path)) {
                                ToastUtil.toast("音频文件丢失了");
                                return;
                            }
                            SoundUtils.playFile(getContext(), path);
                        }
                    });
                }
            });
        }
        if (data.getUrl().equals(ConstantUrl.receiveUrl)) {
            ToastUtil.toast(btnRecice.getText() + "成功");
            finish();
        }
        if (data instanceof RepairPersonBean) {
            RepairPersonBean repairPersonBean = (RepairPersonBean) data;
            List<SelectedDataBean> datas = new ArrayList<>();
            for (int i = 0; i < repairPersonBean.getO().getDataList().size(); i++) {
                SelectedDataBean selectedDataBean = new SelectedDataBean(repairPersonBean.getO().getDataList().get(i).getId(),
                        repairPersonBean.getO().getDataList().get(i).getUserName());
                selectedDataBean.setData(repairPersonBean.getO().getDataList().get(i));
                datas.add(selectedDataBean);
            }

            MyPopOneListPicker picker = new MyPopOneListPicker(getContext(), datas, new MyPopOneListPicker.Pop_selectedListenner() {
                @Override
                public void getData(SelectedDataBean data) {
                    selectePerson = data;
                    TimePickerView pvTime = new TimePickerView.Builder(getActivity(), new TimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {//选中事件回调
                            if (new Date().getTime() > date.getTime()) {
                                ToastUtil.toast("时间不正确");
                                return;
                            }
                            textViewExpectTime.setSecondaryText(TimeDataUtil.getTimeStamp(date.getTime(), TimeDataUtil.DEFULT_TIME_FORMAT));
                            setRecivePerson(TimeDataUtil.getTimeStamp(date.getTime(), TimeDataUtil.DEFULT_TIME_FORMAT));
                        }
                    })
                            .setType(new boolean[]{true, true, true, true, true, false})
                            .build();
                    Calendar instance = Calendar.getInstance();
                    instance.set(TimeDataUtil.getYear(), TimeDataUtil.getMonth(), TimeDataUtil.getDay());
                    pvTime.setDate(instance);//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                    pvTime.show();
                }
            });
            picker.setTitle("选择指派人");
            picker.show();
        }

    }


    public void setRecivePerson(String time) {
        Map<String, String> map = new HashMap();
        map.put("id", workDetailsBean.getO().getId());
        map.put("repairUserGUID", selectePerson.getId());
        map.put("workOrderAssignTime", time);
        map.put("workOrderExpectTime", time);
        map.put("workOrderType", "已派单");
        post(giveOrderUrl, map, new BaseBean());
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void receive(View view) {
        if (workDetailsBean.getO().getWorkOrderTypeStr().equals(ORDER_WATING)) {
            showRepairPerson();
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("id", workDetailsBean.getO().getId());
            map.put("serviceUserGUID", LoginStatus.getLoginBean().getO().getId());
            map.put("workOrderReceiveTime", TimeDataUtil.getTimeStamp(new Date().getTime(), "yyyy-MM-dd HH:mm:ss"));
            map.put("workOrderType", "待派单");
            post(ConstantUrl.receiveUrl, map, new BaseBean<>());
        }
//
    }

    private void showRepairPerson() {
        Map<String, String> map = new HashMap<>();
        map.put("repairBusinessGUID", workDetailsBean.getO().getRepairBusinessGUID());
        RequestBean request = RequestMaker.getRequest(map);
        request.setOrder("UserName asc");
        post(ConstantUrl.repairPersonUrl, request, new RepairPersonBean());
    }
}
