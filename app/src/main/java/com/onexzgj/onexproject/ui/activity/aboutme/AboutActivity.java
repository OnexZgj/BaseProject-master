package com.onexzgj.onexproject.ui.activity.aboutme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.onexzgj.onexlibrary.base.BaseActivity;
import com.onexzgj.onexlibrary.base.WebActivity;
import com.onexzgj.onexlibrary.constant.Constant;
import com.onexzgj.onexproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity {


    @BindView(R.id.iv_aa_github)
    ImageView ivAaGithub;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }



    @OnClick({R.id.iv_aa_github, R.id.tv_version})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_aa_github:
                Intent intent=new Intent(AboutActivity.this,WebActivity.class);
                intent.putExtra(Constant.AIM_URL,"https://github.com/OnexZgj/BaseProject-master");
                startActivity(intent);
                break;
            case R.id.tv_version:
                break;
        }
    }
}
