package com.qixiu.schoolfix.ui.acitivty.inspection.history;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.BR;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.model.check_mechine.CheckMainSchoolBean;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.schoolfix.ui.acitivty.inspection.school_check.SchoolCheckMechineListActiviy;
import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;
import com.qixiu.schoolfix.utils.AddressStatus;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.schoolfix.utils.reuestutil.RequestMaker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends RequestActivity implements XRecyclerView.LoadingListener, OnRecyclerItemListener {


    @BindView(R.id.xrecyclerView)
    XRecyclerView xrecyclerView;
    HistoryAdapter adapter;
    boolean isVisble = true;
    String addressId;

    String date;
    private CalendarView calenderView;
    private TextView textViewDate;

    @Override
    protected void onInitData() {
        mTitleView.setTitle("历史行程");
        date = TimeDataUtil.getTimeStamp(new Date().getTime());
        loadData();
    }

    private void loadData() {
        if (AddressStatus.getDefultAddress() != null) {
            addressId = AddressStatus.getDefultAddress().getCheckLineGUID();
        }
        if (!TextUtils.isEmpty(addressId)) {
            getData();
        }
    }

    private void getData() {
        textViewDate.setText(date);
        List<String[]> datas = new ArrayList<>();
        String[] datas1 = {"userGUID", "uniqueidentifier", "eq", LoginStatus.getToken()};
        String[] datas2 = {"checkLineGUID", "uniqueidentifier", "eq", addressId};
        String[] datas3 = {"checkRecordBeginTime", "datetime", "ge", date + " 00:00:00"};
        String[] datas4 = {"checkRecordBeginTime", "datetime", "le", date + " 23:59:59"};
        datas.add(datas1);
        datas.add(datas2);
        datas.add(datas3);
        datas.add(datas4);
        RequestBean createTime = RequestMaker.getRequests(datas, "createTime", "and");
        post(ConstantUrl.checkHomeUrl, createTime, new CheckMainSchoolBean());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_history;
    }

    @Override
    protected void onInitViewNew() {
        View view = View.inflate(getContext(), R.layout.head_history, null);
        findHeadView(view);
        xrecyclerView.addHeaderView(view);
        adapter = new HistoryAdapter();
        XrecyclerViewUtil.setXrecyclerView(xrecyclerView, this, this, false, 1, null);
        xrecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.setVaribleId(BR.checkListBean);
    }

    private void findHeadView(View view) {
        RelativeLayout relativeLayout = view.findViewById(R.id.relativeLayout);
        calenderView = view.findViewById(R.id.calenderView);
        textViewDate = view.findViewById(R.id.textViewDate);
        ImageView imageViewGoto = view.findViewById(R.id.imageViewGoto);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isVisble = !isVisble;
                if (isVisble) {
                    calenderView.setVisibility(View.VISIBLE);
                    imageViewGoto.setImageResource(R.drawable.lsxc_icon_xiala);
                } else {
                    imageViewGoto.setImageResource(R.drawable.pqgaojzx_btn_xiala);
                    calenderView.setVisibility(View.GONE);
                }
            }
        });
        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String mon = getDateMontStrFormat(month + 1);
                String day = getDateMontStrFormat(dayOfMonth);
                date = year + "-" + mon + "-" + day;
//                if (TimeDataUtil.strToDate(date, TimeDataUtil.DEFULT_DATE_FORMAT).getTime() > new Date().getTime()) {
//                    return;
//                }
                getData();
            }
        });
        calenderView.setMaxDate(new Date().getTime());
    }

    public String getDateMontStrFormat(int dateOrMonth) {
        String result = "";
        if (dateOrMonth < 10) {
            result = "0" + dateOrMonth;
        } else {
            result = "" + dateOrMonth;
        }
        return result;
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof CheckMainSchoolBean) {
            CheckMainSchoolBean listBean = (CheckMainSchoolBean) data;

            adapter.refreshData(listBean.getO().getDataList());
        }
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

    @Override
    public void onRefresh() {
        xrecyclerView.loadMoreComplete();
        xrecyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        xrecyclerView.loadMoreComplete();
        xrecyclerView.refreshComplete();
    }

    @Override
    public void onItemClick(View v, RecyclerView.Adapter adapter, Object data) {
        Preference.putBoolean(ConstantString.IS_EDIBLE, false);
        if (data instanceof CheckMainSchoolBean.ResultBean.DataListBean) {
            CheckMainSchoolBean.ResultBean.DataListBean dataListBean = (CheckMainSchoolBean.ResultBean.DataListBean) data;
            SchoolCheckMechineListActiviy.start(getContext(), SchoolCheckMechineListActiviy.class, dataListBean);

        }
    }
}
