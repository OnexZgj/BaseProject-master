package com.onexzgj.onexproject.ui.activity.advertis;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.onexzgj.onexlibrary.base.BaseContract;
import com.onexzgj.onexlibrary.base.BaseMvpActivity;
import com.onexzgj.onexlibrary.utils.RxHelper;
import com.onexzgj.onexproject.ui.activity.home.HomeActivity;
import com.onexzgj.onexproject.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * 广告页面
 */
public class AdvertisingActivity extends BaseMvpActivity<AdvertisPresenterImp> implements AdvertisingContract.View {

    @BindView(R.id.tv_count_down)
    TextView tvCountDown;
    @BindView(R.id.ll_skip)
    LinearLayout llSkip;
    @BindView(R.id.iv_aa_advertising)
    ImageView ivAaAdvertising;
    @BindView(R.id.tv_aa_advertising_title)
    TextView tvAaAdvertisingTitle;
    private int mTime = 3;

    /**
     * 是否取消加载广告
     */
    private boolean mIsCancle = false;


    @Override
    public void onRetry() {

    }

    @Override
    protected BaseContract.BasePresenter initPresenter() {
        return new AdvertisPresenterImp(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPresenter.getAdvertisingPic();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_advertising;
    }


    private void initCountDown() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(4)//计时次数
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return mTime - aLong;// 3-0 3-2 3-1
                    }
                })
                .compose(RxHelper.<Long>rxSchedulerHelper())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Long value) {
                        if (tvCountDown != null)
                            tvCountDown.setText(String.valueOf(value));
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        if (!mIsCancle) {
                            startActivity(HomeActivity.class);
                            finish();
                        }
                    }
                });
    }


    @OnClick({R.id.ll_skip, R.id.iv_aa_advertising})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_skip:
                //跳过广告，直接进入MainActivity
                mIsCancle = true;
                startActivity(HomeActivity.class);
                finish();

                break;
            case R.id.iv_aa_advertising:

                //TODO 广告详情页面

                break;
        }
    }

    @Override
    public void showAdvertisingPic(String imageUrl, String desc) {
        Glide.with(this).load(imageUrl).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                llSkip.setVisibility(View.VISIBLE);
                initCountDown();
                return false;
            }
        }).into(ivAaAdvertising);
        tvAaAdvertisingTitle.setText("Onex Project " + desc);

    }
}
