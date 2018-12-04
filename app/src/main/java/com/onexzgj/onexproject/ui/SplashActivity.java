package com.onexzgj.onexproject.ui;

import android.Manifest;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.onexzgj.onexlibrary.base.BaseActivity;
import com.onexzgj.onexproject.R;
import com.onexzgj.onexproject.ui.activity.advertis.AdvertisingActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import io.reactivex.functions.Consumer;

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

        getPermissions();

    }

    public void getPermissions() {
        new RxPermissions(this).request(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (!aBoolean) {
                    ToastUtils.showShort("未能全部获取到权限，部分功能没法使用");
                }

                initStartAnim();
            }
        });


                //        rxPermission.requestEach(
                //                Manifest.permission.CAMERA,
                //                Manifest.permission.READ_PHONE_STATE,
                //                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                //                Manifest.permission.READ_EXTERNAL_STORAGE,
                //                Manifest.permission.ACCESS_COARSE_LOCATION)
                //                .subscribe(new Consumer<Permission>() {
                //                    @Override
                //                    public void accept(Permission permission) throws Exception {
                //                        if (permission.granted) {
                //                            // 用户已经同意该权限
                //                            Log.d(TAG, permission.name + " is granted.");
                //                        } else if (permission.shouldShowRequestPermissionRationale) {
                //                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                //                            Log.d(TAG, permission.name + " is denied. More info should
                // be provided.");
                //                        } else {
                //                            // 用户拒绝了该权限，并且选中『不再询问』
                //                            Log.d(TAG, permission.name + " is denied.");
                //                        }
                //                    }
                //                });


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
