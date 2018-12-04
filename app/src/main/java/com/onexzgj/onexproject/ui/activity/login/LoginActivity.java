package com.onexzgj.onexproject.ui.activity.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.onexzgj.onexlibrary.base.BaseActivity;
import com.onexzgj.onexlibrary.base.BaseContract;
import com.onexzgj.onexlibrary.base.BaseMvpActivity;
import com.onexzgj.onexproject.R;

public class LoginActivity extends BaseMvpActivity {


    @Override
    protected BaseContract.BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onRetry() {

    }
}
