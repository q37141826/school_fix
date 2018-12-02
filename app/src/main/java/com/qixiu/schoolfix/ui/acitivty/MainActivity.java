package com.qixiu.schoolfix.ui.acitivty;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.qixiu.qixiu.utils.Preference;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.action.IntentAction;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.BaseActivity;
import com.qixiu.schoolfix.ui.fragment.basefragment.base.BaseFragment;
import com.qixiu.schoolfix.ui.fragment.home.HomeFragment;
import com.qixiu.schoolfix.ui.fragment.home.HomeGotoBean;
import com.qixiu.schoolfix.ui.fragment.mine.MineFragment;
import com.qixiu.schoolfix.ui.fragment.worklist.WorklistFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    int notSelectedIcons[] = {R.drawable.sy_icon_sy, R.drawable.sy_icon_gd, R.drawable.sy_icon_wod};
    int selectedIcons[] = {R.drawable.sy_icon_sy_jh, R.drawable.sy_icon_gd_jh, R.drawable.sy_icon_wod_jh};
    @BindView(R.id.fragmen_for_fragment)
    FrameLayout fragmenForFragment;
    @BindView(R.id.radio_home)
    RadioButton radioHome;
    @BindView(R.id.radio_work_list)
    RadioButton radioWorkList;
    @BindView(R.id.radio_work_mine)
    RadioButton radioWorkMine;
    private List<BaseFragment> fragments = new ArrayList<>();
    HomeFragment homeFragment;
    private WorklistFragment worklistFragment;
    private MineFragment mineFragment;

    @Override
    protected void onInitData() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        radioHome.setChecked(true);
        homeFragment = new HomeFragment();
        worklistFragment = new WorklistFragment();
        mineFragment = new MineFragment();
        fragments.add(homeFragment);
        fragments.add(worklistFragment);
        fragments.add(mineFragment);

        FragmentTransaction fragmentTransaction = mSupportFragmentManager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            fragmentTransaction.add(R.id.fragmen_for_fragment, fragments.get(i),
                    fragments.get(i).getClass().getName());
        }
        fragmentTransaction.commit();
        switchFragment(homeFragment, fragmenForFragment.getId());

        setClick();

    }

    private void setClick() {
        radioHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(homeFragment, fragmenForFragment.getId());
                resetWorkCurrentPage();
            }
        });
        radioWorkList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(worklistFragment, fragmenForFragment.getId());
                resetWorkCurrentPage();
            }
        });
        radioWorkMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(mineFragment, fragmenForFragment.getId());
                resetWorkCurrentPage();
            }
        });

    }

    private void resetWorkCurrentPage() {
        //重置一下第二页当前页面所在页面的判断基准
        Preference.put(ConstantString.GOTO_WHERE, IntentAction.GOTO_WAIT_HANDLER);
    }

    @Override
    protected void onInitView() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }


    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Subscribe
    public void onEventThread(HomeGotoBean bean){
        Preference.put(ConstantString.GOTO_WHERE,bean.getAction());
        switchFragment(worklistFragment, fragmenForFragment.getId());
        radioWorkList.setChecked(true);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
