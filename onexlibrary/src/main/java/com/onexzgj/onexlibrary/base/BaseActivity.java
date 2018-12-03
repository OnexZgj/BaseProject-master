package com.onexzgj.onexlibrary.base;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.BarUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 全局application
     */
    public Application mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getLayoutId()>0){
            setContentView(getLayoutId());
            ButterKnife.bind(this);
        }
        BarUtils.hideNotificationBar(this);
        BarUtils.hideNavBar(this);
        //初始化
        initView();
        initData();

    }

    protected abstract int getLayoutId();


    protected abstract void initView();


    protected abstract void initData();


    /** 跳转指定的activity */
    public void startActivity( Class<? extends Activity> cls){
        startActivity(new Intent(this,cls));
    }




}
