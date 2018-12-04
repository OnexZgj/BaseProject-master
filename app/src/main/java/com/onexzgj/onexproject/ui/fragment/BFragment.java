package com.onexzgj.onexproject.ui.fragment;

import android.view.View;

import com.onexzgj.onexlibrary.base.BaseContract;
import com.onexzgj.onexlibrary.base.BaseFragment;
import com.onexzgj.onexproject.R;

public class BFragment extends BaseFragment {

    public static BaseFragment getInstance() {
        return new BFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_b;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected BaseContract.BasePresenter initPresenter() {
        return null;
    }

}


