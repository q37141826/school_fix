package com.qixiu.qixiu.application;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.qixiu.qixiu.request.OKHttpRequestModel;
import com.qixiu.qixiu.request.OKHttpUIUpdataListener;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.wigit.zprogress.ZProgressHUD;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * Created by Administrator on 2017/6/14 0014.
 */

public class BaseApplication extends MultiDexApplication implements OKHttpUIUpdataListener {
    private static BaseApplication app;
    private static Context mContext;
    private OKHttpRequestModel okHttpRequestModel;
    public static int NOTICE_NUM = 0;
    ZProgressHUD mZProgressHUD;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        okHttpRequestModel = new OKHttpRequestModel(this);
        app = this;
        mContext = this;
        mZProgressHUD=new ZProgressHUD(mContext);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }//加入这段话  用低版本的权限模式
        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
// 如果APP启用了远程的service，此application:onCreate会被调用2次
// 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
// 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回
        if (processAppName == null || !processAppName.equalsIgnoreCase(mContext.getPackageName())) {
            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }
        initSdk();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(60000L, TimeUnit.MILLISECONDS)
                .readTimeout(60000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
        // CrashHandler.getInstance().init(this);

    }



    public static BaseApplication getApp() {
        return app;
    }

    public static Context getContext() {
        return mContext;
    }

    public static boolean isLoginToLongin(Activity activity) {
        if (TextUtils.isEmpty(Preference.get("id", ""))) {
//            Intent intent = new Intent(activity, LoginActivity.class);
//            activity.startActivity(intent);
            return false;
        } else {
            return true;
        }
    }

    private void initSdk() {
        //初始化ShareSDK
        try {
//            ShareSDK.initSDK(getContext());
        } catch (Exception e) {
        }
//        //初始化极光推送
//        JpushEngine.initJPush(getContext());

    }

    @Override
    public void onSuccess(Object data, int i) {

    }

    @Override
    public void onError(okhttp3.Call call, Exception e, int i) {
        if (mZProgressHUD != null && mZProgressHUD.isShowing()) {
            mZProgressHUD.dismiss();
        }
    }


    @Override
    public void onFailure(C_CodeBean c_codeBean) {
        if (mZProgressHUD != null && mZProgressHUD.isShowing()) {
            mZProgressHUD.dismiss();
        }
    }





    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static BaseApplication getInstance() {
        return app;
    }

    /**
     * 判断某个界面是否在前台
     *
     * @param context   Context
     * @param className 界面的类名
     * @return 是否在前台显示
     */
    public static boolean isForeground(Context context, String className) {
        if (context ==null || TextUtils.isEmpty(className))
            return false;
        ActivityManager am = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(1);
//        boolean flag=false;
        for (ActivityManager.RunningTaskInfo taskInfo : list) {
            if (taskInfo.topActivity.getShortClassName().contains(className)) { // 说明它已经启动了
//                flag = true;
                return true;
            }
        }
        return false;
    }

}
