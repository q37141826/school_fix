package com.qixiu.schoolfix.ui.acitivty.work_flow.problem;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequstActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.RequestMaker;
import com.qixiu.widget.LineControllerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProblemSelectActivity extends RequstActivity implements OnRecyclerItemListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.lineOther)
    LineControllerView lineOther;
    @BindView(R.id.edittextOtherProblem)
    EditText edittextOtherProblem;
    @BindView(R.id.linearlayoutOtherProblem)
    LinearLayout linearlayoutOtherProblem;
    private String productGUID;
    private ProblemSelectAdapter adapter;

    ArrayList<Parcelable> selectedDatas = new ArrayList<>();//被选中的id
    ProblemDataBean.ResultBean.DataListBean lastBean;
    @Override
    protected void onInitData() {
        //这个是输入的edittext内容
        lastBean=new ProblemDataBean.ResultBean.DataListBean();
        lastBean.setId(ConstantString.NULL_ID);
        lastBean.setProductProblemRemark("");
        mTitleView.setTitle("问题定位");
        productGUID = getIntent().getStringExtra(IntentDataKeyConstant.DATA);
        RequestBean mechineRequest = RequestMaker.getMechineRequest(productGUID);
        post(ConstantUrl.problemListUrl, mechineRequest, new ProblemDataBean());
        mTitleView.setRightText("确定");
        mTitleView.getRightText().setTextColor(getResources().getColor(R.color.theme_color));
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedDatas.size() == 0) {
                    ToastUtil.toast("请选中问题");
                    return;
                }
                gotoSolution();
            }
        });
//        post(ConstantUrl.problemListUrl, map, requestIntef,new BaseBean());
    }

    private void gotoSolution() {
        ResovleActivity.start(getContext(), ResovleActivity.class, selectedDatas);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_problem_select;
    }

    @Override
    public void adustTitle() {
//        super.adustTitle();
    }

    @Override
    protected void onInitViewNew() {
        adapter = new ProblemSelectAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        lineOther.getRightImageView().setImageResource(R.drawable.yuan);
        lineOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastBean.setSelected(!lastBean.isSelected());
                setLineState();
            }
        });
        edittextOtherProblem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                lastBean.setProductProblemRemark(s.toString());
            }
        });
    }

    private void setLineState() {
        if (lastBean.isSelected()) {
            selectedDatas.add(lastBean);
        } else {
            selectedDatas.remove(lastBean);
        }
        lineOther.getRightImageView().setImageResource(lastBean.isSelected() ? R.drawable.yuan2 : R.drawable.yuan);
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof ProblemDataBean) {
            ProblemDataBean bean = (ProblemDataBean) data;
            List dataList = bean.getO().getDataList();
            adapter.refreshData(dataList);

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
    public void onItemClick(View v, RecyclerView.Adapter adapter, Object data) {
        if (data instanceof ProblemDataBean.ResultBean.DataListBean) {
            ProblemDataBean.ResultBean.DataListBean dataListBean = (ProblemDataBean.ResultBean.DataListBean) data;
            dataListBean.setSelected(!dataListBean.isSelected());
            if (dataListBean.isSelected()) {
                selectedDatas.add(dataListBean);
            } else {
                selectedDatas.remove(dataListBean);
            }
            adapter.notifyDataSetChanged();
        }

    }
}
