package com.onexzgj.onexproject.ui.activity.login;

import com.onexzgj.onexlibrary.base.BasePresenter;
import com.onexzgj.onexlibrary.net.RetrofitHelper;
import com.onexzgj.onexlibrary.utils.RxHelper;
import com.onexzgj.onexproject.model.DataResponse;
import com.onexzgj.onexproject.model.User;
import com.onexzgj.onexproject.api.ApiService;

import io.reactivex.functions.Consumer;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class LoginActivityImp extends BasePresenter<LoginActivityContract.View> implements LoginActivityContract.Presenter {

    public LoginActivityImp(LoginActivityContract.View view) {
        this.mView = view;

    }

    @Override
    public void Login(String account, String password) {

        mView.showLoading("正在登陆...");

        RetrofitHelper.createApi(ApiService.class,ApiService.HOST).login(account,password).compose(mView.<DataResponse<User>>bindToLife())
                .compose(RxHelper.<DataResponse<User>>rxSchedulerHelper())
                .subscribe(new Consumer<DataResponse<User>>() {
                    @Override
                    public void accept(DataResponse<User> userDataResponse) throws Exception {
                        if (userDataResponse.getErrorCode()!=0){
                            //表示出错
                            mView.showToast(userDataResponse.getErrorMsg().toString());
                        }else{
                            mView.showLoginSuccess();
                        }

                        mView.hideLoading();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
                        mView.showToast("请检查网络,稍后重试!");

                    }
                });
    }
}
