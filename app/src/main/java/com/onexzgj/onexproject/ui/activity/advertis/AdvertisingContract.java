package com.onexzgj.onexproject.ui.activity.advertis;

import com.onexzgj.onexlibrary.base.BaseContract;

/**
 * Created by OnexZgj on 2018/12/1.
 */

public interface AdvertisingContract {

    interface View extends BaseContract.BaseView{
        /** 展示广告图片
         * @param imageUrl 图片地址
         * @param desc 图片描述
         */
        void showAdvertisingPic(String imageUrl,String desc);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        /** 获取广告图片 */
        void getAdvertisingPic();
    }


}
