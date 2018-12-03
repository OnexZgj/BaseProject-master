package com.onexzgj.onexlibrary;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by OnexZgj on 2017/9/1.
 * <p>
 * 全局Application
 */

public class GlobalApplication extends Application {
    protected static Context context;
    protected static Handler handler;
    protected static int mainThreadId;
    private static GlobalApplication mApp;

    public static synchronized GlobalApplication getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = android.os.Process.myTid();
        Utils.init(this);
//        intARouter();
        Logger.addLogAdapter(new AndroidLogAdapter());
        //配置ToastUtils的相关的属性
        ToastUtils.setGravity(Gravity.TOP,0, (int) (80 * Utils.getApp().getResources().getDisplayMetrics().density + 0.5));
        ToastUtils.setBgColor(getResources().getColor(R.color.pink));
        ToastUtils.setMsgColor(getResources().getColor(R.color.green));

    }



//    /**
//     * 初始化路由
//     */
//    private void intARouter() {
//        // 这两行必须写在init之前，否则这些配置在init过程中将无效
//        ARouter.openLog();     // 打印日志
//        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        ARouter.init(this); // 尽可能早，推荐在Application中初始化
//    }


    /**
     * 获取上下文对象
     *
     * @return context
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 获取全局handler
     *
     * @return 全局handler
     */
    public static Handler getHandler() {
        return handler;
    }

    /**
     * 获取主线程id
     *
     * @return 主线程id
     */
    public static int getMainThreadId() {
        return mainThreadId;
    }
}
