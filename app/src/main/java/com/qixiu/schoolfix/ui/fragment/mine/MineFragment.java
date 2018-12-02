package com.qixiu.schoolfix.ui.fragment.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.ui.acitivty.mine.SettingActivity;
import com.qixiu.schoolfix.ui.fragment.basefragment.base.RequstFragment;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.widget.LineControllerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by my on 2018/11/15.
 */

public class MineFragment extends RequstFragment {


    @BindView(R.id.lineSetting)
    LineControllerView lineSetting;
    @BindView(R.id.lineUserName)
    LineControllerView lineUserName;
    @BindView(R.id.lineUserPhone)
    LineControllerView lineUserPhone;
    @BindView(R.id.lineCompanyName)
    LineControllerView lineCompanyName;
    Unbinder unbinder;

    @Override
    protected void onInitData() {
        mTitleView.setTitle("个人中心");
        mTitleView.getLeftView().setVisibility(View.GONE);
        lineCompanyName.setSecondaryText(LoginStatus.getLoginBean().getO().getRepairBusinessName());
        lineUserName.setSecondaryText(LoginStatus.getLoginBean().getO().getUserName());
        lineUserPhone.setSecondaryText(LoginStatus.getLoginBean().getO().getRepairBusinessTel());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mine;
    }

    @OnClick({R.id.lineCompanyName, R.id.lineSetting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lineCompanyName:
                break;
            case R.id.lineSetting:
                SettingActivity.start(getContext(), SettingActivity.class);
                break;
        }
    }

    @Override
    public void onSuccess(BaseBean data) {

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
