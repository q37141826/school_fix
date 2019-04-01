package com.qixiu.schoolfix.ui.acitivty.guidepage;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.WindowManager;

import com.qixiu.qixiu.application.BaseApplication;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.ui.acitivty.LoginActivity;
import com.qixiu.schoolfix.ui.acitivty.MainActivity;
import com.qixiu.schoolfix.utils.LoginStatus;
import com.qixiu.schoolfix.utils.reuestutil.TokenRequestUtils;

import me.leolin.shortcutbadger.ShortcutBadger;


public class StartPageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);
        onInitData();
        TokenRequestUtils.requestToken();
    }


    protected void onInitData() {
        //// TODO: 2017/8/2 清空app角标，后续可以改到具体位置
//        Preference.put(ConstantString.broadCastMessageCount, 0);
        BaseApplication.NOTICE_NUM = 0;
        ShortcutBadger.applyCount(this, 0);

        if (TextUtils.isEmpty(Preference.get(ConstantString.USERID, ""))) {

        } else {
            MainActivity.start(StartPageActivity.this);
        }


        try {
//            if (!Preference.getBoolean(ConstantString.IS_FIRST_LOGIN)) {
//                GuidePageActivity.start(this);
//                Preference.putBoolean(ConstantString.IS_FIRST_LOGIN, true);
//                StartPageActivity.this.finish();
//                return;
//            }
        } catch (Exception e) {
        }
        try {
            if (TextUtils.isEmpty(Preference.get(ConstantString.USERID, ""))) {
                handeler.postDelayed(new MyRunnable(1), 10);
            } else {
                handeler.postDelayed(new MyRunnable(2), 10);
            }
        } catch (Exception e) {
        }
    }


    //跳转的延迟线程
    Handler handeler = new Handler();

    class MyRunnable implements Runnable {
        private int type;

        public MyRunnable(int type) {
            this.type = type;
        }

        @Override
        public void run() {
            if (type == 1) {
                LoginActivity.start(StartPageActivity.this);
            } else {
                LoginStatus.setLoginBean();
                MainActivity.start(StartPageActivity.this);
            }
            StartPageActivity.this.finish();
        }
    }
}
