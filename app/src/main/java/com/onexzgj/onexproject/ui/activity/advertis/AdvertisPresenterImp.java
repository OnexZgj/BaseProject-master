package com.onexzgj.onexproject.ui.activity.advertis;


import com.onexzgj.onexlibrary.base.BasePresenter;
import com.onexzgj.onexlibrary.net.RetrofitHelper;
import com.onexzgj.onexlibrary.utils.RxHelper;
import com.onexzgj.onexproject.api.GankioApi;
import com.onexzgj.onexproject.model.GankIoWelfareListBean;

import io.reactivex.functions.Consumer;

/**
 * Created by OnexZgj on 2018/12/1.
 */

public class AdvertisPresenterImp extends BasePresenter<AdvertisingContract.View> implements AdvertisingContract.Presenter {

    public AdvertisPresenterImp(AdvertisingContract.View view) {
        this.mView=view;
    }

    @Override
    public void getAdvertisingPic() {
        mView.showLoading("请求广告中...");
        RetrofitHelper.createApi(GankioApi.class,GankioApi.HOST).getGankIoWelfareList(1,1)
                .compose(RxHelper.<GankIoWelfareListBean>rxSchedulerHelper())
                .compose(mView.<GankIoWelfareListBean>bindToLife())
                .subscribe(new Consumer<GankIoWelfareListBean>() {
                    @Override
                    public void accept(GankIoWelfareListBean datas) throws Exception {
                        mView.showAdvertisingPic(datas.getResults().get(0).getUrl(),datas.getResults().get(0).getDesc());
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showToast("服务器出错了...");
                        mView.hideLoading();
                    }
                });
    }
}
