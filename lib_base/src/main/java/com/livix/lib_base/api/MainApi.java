package com.livix.lib_base.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * @author LIVIX
 * @date: 2022/7/6
 */
public interface MainApi {

    /**
     * 获取Token
     * @return
     */
    @Headers(BaseUrlHeaderConstant.MASTER_HEADER)
    @GET("/api/auth/v1/anonymous/token")
    Observable<Response<TokenBean>> getToken();
}
