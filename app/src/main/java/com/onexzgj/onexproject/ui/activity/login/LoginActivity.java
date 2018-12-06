package com.onexzgj.onexproject.ui.activity.login;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.onexzgj.onexlibrary.base.BaseContract;
import com.onexzgj.onexlibrary.base.BaseMvpActivity;
import com.onexzgj.onexlibrary.widget.ClearEditText;
import com.onexzgj.onexproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseMvpActivity<LoginActivityImp> implements LoginActivityContract.View {


    @BindView(R.id.tb_login_title)
    Toolbar tbLoginTitle;
    @BindView(R.id.et_login_name)
    ClearEditText etLoginName;
    @BindView(R.id.et_login_password)
    ClearEditText etLoginPassword;
    @BindView(R.id.tv_login_forget)
    TextView tvLoginForget;
    @BindView(R.id.btn_login_login)
    Button btnLoginLogin;

    @Override
    protected BaseContract.BasePresenter initPresenter() {
        return new LoginActivityImp(this);
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

    @Override
    public void showLoginSuccess() {
        showToast("登陆成功!");
    }


    @OnClick({R.id.tv_login_forget, R.id.btn_login_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login_forget:
                break;
            case R.id.btn_login_login:
                if (TextUtils.isEmpty(etLoginName.getText().toString())||TextUtils.isEmpty(etLoginPassword.getText().toString())){
                    showToast("用户名或密码不能为空!");
                }else{
                    mPresenter.Login(etLoginName.getText().toString().trim(),etLoginPassword.getText().toString().trim());
                }
                break;
        }
    }
}
