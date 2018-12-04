package com.onexzgj.onexproject.ui.activity.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.onexzgj.onexlibrary.base.BaseActivity;
import com.onexzgj.onexproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面的Activity
 *
 * @author onexzgj
 */
public class HomeActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.layout_fragment)
    FrameLayout layoutFragment;
    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mNavigation.setOnNavigationItemSelectedListener(this);
        getPersimmions();
        initFragment();
        switchFragment(0);
    }

    private void switchFragment(int position) {

    }

    private void initFragment() {

    }

    private void getPersimmions() {

    }

    @Override
    protected void initData() {

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_home:
                switchFragment(0);
                break;
            case R.id.navigation_me:
                switchFragment(1);
                break;
        }
        return false;
    }
}
