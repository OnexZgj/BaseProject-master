package com.onexzgj.onexproject.ui.fragment.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.onexzgj.onexlibrary.base.BaseContract;
import com.onexzgj.onexlibrary.base.BaseFragment;
import com.onexzgj.onexproject.R;
import com.onexzgj.onexproject.ui.activity.login.LoginActivity;
import com.onexzgj.onexproject.ui.activity.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MeFragment extends BaseFragment {
    @BindView(R.id.btn_fm_login)
    Button btnFmLogin;
    @BindView(R.id.btn_fm_register)
    Button btnFmRegister;

    public static BaseFragment getInstance() {
        return new MeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected BaseContract.BasePresenter initPresenter() {
        return null;
    }



    @OnClick({R.id.btn_fm_login, R.id.btn_fm_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fm_login:

                startActivity(new Intent(getActivity(),LoginActivity.class));

                break;
            case R.id.btn_fm_register:

                startActivity(new Intent(getActivity(),RegisterActivity.class));

                break;
        }
    }
}
