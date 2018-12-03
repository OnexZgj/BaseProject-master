package com.onexzgj.onexproject.api;
import com.onexzgj.onexproject.model.GankIoWelfareListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by OnexZgj on 2017/10/7.
 * <p>
 */

public interface GankioApi {
    public final String HOST = "http://gank.io";

    /**
     * 分类数据: http://gank.io/api/data/福利/请求个数/第几页
     * 数据类型： 福利
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     * eg: http://gank.io/api/data/福利/10/1
     */
    @GET("/api/data/福利/{pre_page}/{page}")
    Observable<GankIoWelfareListBean> getGankIoWelfareList(@Path("pre_page") int pre_page,
                                                           @Path("page") int page);
}
