package com.qixiu.schoolfix.ui.acitivty.work_flow.problem;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.qixiu.qixiu.application.AppManager;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.widget.LineControllerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResovleActivity extends RequestActivity implements OnRecyclerItemListener {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.lineOther)
    LineControllerView lineOther;
    @BindView(R.id.edittextOtherProblem)
    EditText edittextOtherProblem;
    @BindView(R.id.linearlayoutOtherProblem)
    LinearLayout linearlayoutOtherProblem;
    private List<ProblemDataBean.ResultBean.DataListBean> datas;
    ProblemSelectAdapter adapter;
    List<ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean> selectedDatas = new ArrayList<>();
    ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean lastBean = new ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean();

    @Override
    protected void onInitData() {
        //这个是输入的edittext内容
        lastBean.setId(ConstantString.NULL_ID);
        lastBean.setProductProblemRemark("");
        adapter = new ProblemSelectAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        datas = getIntent().getParcelableArrayListExtra(IntentDataKeyConstant.DATA);
        mTitleView.setTitle("解决方案");
        mTitleView.setRightText("确定");
        mTitleView.getRightText().setTextColor(getResources().getColor(R.color.theme_color));
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectedProblemResoveListBeans beans = new SelectedProblemResoveListBeans();
                beans.setProblemBeans(datas);
                beans.setResoveBeans(selectedDatas);
                EventBus.getDefault().post(beans);
                try {
                    AppManager.getAppManager().finishActivity(ProblemSelectActivity.class);
                } catch (Exception e) {
                }
                finish();
            }
        });
        requestData();
        adapter.setOnItemClickListener(this);
    }

    private void requestData() {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < datas.size(); i++) {
            if (i == datas.size() - 1) {
                stringBuffer.append(datas.get(i).getId());
            } else {
                stringBuffer.append(datas.get(i).getId() + ";");
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("productProblemGUIDs", stringBuffer.toString());
        post(ConstantUrl.getProductProblemSolutionList, map, new ResoveListBean());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_resovle;
    }

    @Override
    protected void onInitViewNew() {
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
        if (data instanceof ResoveListBean) {
            ResoveListBean bean = (ResoveListBean) data;
            List<ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean> datas
                    = bean.getO().getGetProductProblemSolutionDtos();
            adapter.refreshData(datas);
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
        if (data instanceof ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean) {
            ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean bean = (ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean) data;
            bean.setSelected(!bean.isSelected());
            if (bean.isSelected()) {
                selectedDatas.add(bean);
            } else {
                selectedDatas.remove(bean);
            }
            adapter.notifyDataSetChanged();
        }
    }
}
