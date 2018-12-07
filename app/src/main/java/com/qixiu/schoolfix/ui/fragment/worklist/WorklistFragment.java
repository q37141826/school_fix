package com.qixiu.schoolfix.ui.fragment.worklist;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.action.IntentAction;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.ui.acitivty.work_flow.create.CreateHardWorkActivity;
import com.qixiu.schoolfix.ui.fragment.basefragment.base.BaseFragment;
import com.qixiu.schoolfix.ui.fragment.basefragment.base.MenueFragment;
import com.qixiu.wigit.hviewpager.HackyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by my on 2018/11/15.
 */

public class WorklistFragment extends MenueFragment {
    @BindView(R.id.tableWorkList)
    TabLayout tableWorkList;
    @BindView(R.id.viewpagerWorklist)
    HackyViewPager viewpagerWorklist;
    String titles[] = {"待接单", "待处理", "历史工单"};
    String types[]={"待接单","待处理","历史工单"};
    @Override
    protected void onInitData() {
        mTitleView.setTitle("齐科信息");
        mTitleView.setRightTextVisible(View.VISIBLE);
        mTitleView.setRightImage(getContext(), R.drawable.gd_icon_tj);
        mTitleView.getLeftView().setVisibility(View.GONE);
        mTitleView.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateHardWorkActivity.start(getContext(),CreateHardWorkActivity.class);
            }
        });


        WorkListInnerFragment workListWaitHandler = new WorkListInnerFragment();
        workListWaitHandler.setType(types[0]);
        WorkListInnerFragment workListWaitHandle = new WorkListInnerFragment();
        workListWaitHandle.setType(types[1]);
        WorkListInnerFragment workListHistory = new WorkListInnerFragment();
        workListHistory.setType(types[2]);
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(workListWaitHandler);
        fragments.add(workListWaitHandle);
        fragments.add(workListHistory);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            list.add(titles[i]);
        }
        initFragment(fragments, list, tableWorkList, viewpagerWorklist);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_worklist;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        Preference.put(ConstantString.GOTO_WHERE,IntentAction.GOTO_ACTIVITY);
    }

    @Override
    public void onStart() {
        super.onStart();
        int action = Preference.get(ConstantString.GOTO_WHERE, IntentAction.GOTO_WAIT_HANDLER);
        if (action == IntentAction.GOTO_WAIT_HANDLER) {
            viewpagerWorklist.setCurrentItem(0);
        } else if (action == IntentAction.GOTO_WAIT_HANDLE) {
            viewpagerWorklist.setCurrentItem(1);
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
}
