package com.onexzgj.onexproject.ui.fragment;

import android.view.View;

import com.onexzgj.onexlibrary.base.BaseContract;
import com.onexzgj.onexlibrary.base.BaseFragment;
import com.onexzgj.onexproject.R;

public class AFragment extends BaseFragment {

    public static BaseFragment getInstance() {
        return new AFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected BaseContract.BasePresenter initPresenter() {
        return null;
    }

}


