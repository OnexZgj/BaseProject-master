package com.onexzgj.onexproject.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.onexzgj.onexlibrary.base.BaseActivity;
import com.onexzgj.onexproject.R;
import com.onexzgj.onexproject.ui.activity.advertis.AdvertisingActivity;

import butterknife.BindView;

/**
 * 闪屏页面
 */
public class SplashActivity extends BaseActivity implements Animation.AnimationListener {


    private static final int ANIM_TIME = 500;

    @BindView(R.id.tv_as_show)
    TextView tvAsShow;
    @BindView(R.id.iv_as_bg)
    ImageView ivAsBg;
    @BindView(R.id.iv_as_icon)
    ImageView ivAsIcon;
    private int mScreenHeight;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    protected void initView() {
        BarUtils.setStatusBarAlpha(this,0);
        mScreenHeight = ScreenUtils.getScreenHeight();
        initStartAnim();

    }


    /**
     * 启动动画
     */
    private void initStartAnim() {
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.4f, 1.0f);
        aa.setDuration(ANIM_TIME * 2);
        aa.setAnimationListener(this);
        ivAsBg.startAnimation(aa);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(ANIM_TIME);
        ivAsIcon.startAnimation(sa);

        LogUtils.w(mScreenHeight);
        TranslateAnimation ta=new TranslateAnimation(0,0,100,0);
        ta.setDuration(ANIM_TIME);

        tvAsShow.startAnimation(ta);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        startActivity(AdvertisingActivity.class);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
