package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.view.View;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;

public class TeacherSignActivity extends RequestActivity {

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
    protected void onInitViewNew() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onInitData() {
        mTitleView.setTitle("学校老师签名");
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_teacher_sign;
    }
}
