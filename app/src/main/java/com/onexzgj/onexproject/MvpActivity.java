package com.onexzgj.onexproject;

import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.onexzgj.onexlibrary.base.BaseContract;
import com.onexzgj.onexlibrary.base.BaseMvpActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MvpActivity extends BaseMvpActivity {


    @BindView(R.id.tv_am_mvp)
    TextView tvAmMvp;

    @Override
    protected BaseContract.BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        BarUtils.addMarginTopEqualStatusBarHeight(tvAmMvp);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    public void onRetry() {

    }


    @OnClick(R.id.tv_am_mvp)
    public void onViewClicked() {
        showLoading("正在加载中....");
    }
}
