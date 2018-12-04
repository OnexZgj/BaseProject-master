package com.onexzgj.onexproject.ui.activity.home;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.onexzgj.onexlibrary.base.BaseActivity;
import com.onexzgj.onexlibrary.base.BaseFragment;
import com.onexzgj.onexproject.R;
import com.onexzgj.onexproject.ui.fragment.AFragment;
import com.onexzgj.onexproject.ui.fragment.BFragment;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

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


    /**
     * 上一次的Fragment实例的索引
     */
    private int mLastFgIndex;

    private ArrayList<BaseFragment> mFragments=new ArrayList<>();

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
        if (position >= mFragments.size()) {
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        BaseFragment targetFg = mFragments.get(position);

        Slide slideTransition;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Gravity.START部分机型崩溃java.lang.IllegalArgumentException: Invalid slide direction
            slideTransition = new Slide(Gravity.BOTTOM);
            slideTransition.setDuration(500);
            targetFg.setEnterTransition(slideTransition);
            targetFg.setExitTransition(slideTransition);
        }


        Fragment lastFg = mFragments.get(mLastFgIndex);
        mLastFgIndex = position;
        ft.hide(lastFg);
        if (!targetFg.isAdded())
            ft.add(R.id.layout_fragment, targetFg);

        ft.show(targetFg);
        ft.commitAllowingStateLoss();
    }

    private void initFragment() {
        mFragments.add(AFragment.getInstance());
        mFragments.add(BFragment.getInstance());

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
        return true;
    }
}
