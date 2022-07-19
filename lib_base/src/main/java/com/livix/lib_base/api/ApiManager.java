package com.livix.lib_base.api;

import com.livix.lib_base.BaseApplication;
import com.livix.lib_base.api.interceptor.BaseUrlInterceptor;
import com.livix.lib_base.api.interceptor.HeaderInterceptor;

import retrofit2.Retrofit;

/**
 * @author LIVIX
 * @date: 2022/7/6
 */
public class ApiManager {

    private volatile static ApiManager instance;

    private final MainApi mainApi;

    private ApiManager() {
        Retrofit retrofit = NetworkManager.getInstance().getRetrofit(BaseApplication.getApplication(), new HeaderInterceptor(), new BaseUrlInterceptor());
        mainApi = retrofit.create(MainApi.class);
    }

    public static ApiManager getInstance() {
        if (instance == null) {
            synchronized (ApiManager.class) {
                if (instance == null) {
                    instance = new ApiManager();
                }
            }
        }
        return instance;
    }

    public MainApi getMainApi() {
        return mainApi;
    }
}
