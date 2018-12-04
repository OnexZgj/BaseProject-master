package com.onexzgj.onexlibrary.base;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpActivity<T extends BaseContract.BasePresenter> extends RxAppCompatActivity implements BaseContract.BaseView {

    private Unbinder unBinder;

    protected Application mApplication;

    protected Context mContext;
    private int mColor;

    protected T mPresenter;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            unBinder = ButterKnife.bind(this);
        }
//        BarUtils.setStatusBarAlpha(this);
        BarUtils.setStatusBarAlpha(this, 0);
//        mColor=0xff0000;
//        BarUtils.setStatusBarColor(this,mColor);
        if (mProgressDialog == null)
            mProgressDialog = new ProgressDialog(this, 0);
        mPresenter = (T) initPresenter();

        attachView();

        initView();

        initData();
        mApplication = getApplication();
        mContext = this;
        if (!NetworkUtils.isConnected()) showNoNet();


    }

    protected abstract BaseContract.BasePresenter initPresenter();


    private void attachView() {
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayoutId();

    @Override
    public void showLoading(String msg) {
        mProgressDialog.setMessage(msg);
        mProgressDialog.setCanceledOnTouchOutside(true);
        mProgressDialog.show();
    }


    @Override
    public void hideLoading() {
        if (mProgressDialog != null)
            mProgressDialog.hide();
    }


    @Override
    public void showNoNet() {
        ToastUtils.showShort("404 ERROR");

        //动态添加上网络错误的view
        //添加上错误view的点击事件

    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showShort(msg);
    }


    /**
     * 跳转指定的activity
     */
    public void startActivity(Class<? extends Activity> cls) {
        startActivity(new Intent(this, cls));
    }


    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }

}
