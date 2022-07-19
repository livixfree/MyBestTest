package com.livix.lib_base.api.interceptor;

import androidx.annotation.NonNull;

import com.livix.lib_base.api.EnvironmentUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author LIVIX
 * @date: 2022/7/4
 */
public class BaseUrlInterceptor implements Interceptor {

    public static final String KEY_BASE_URL = "baseUrl";
    public static final String MASTER = "master_value";
    public static final String PROXY = "proxy_value";
    public static final String GIDC = "gidc_value";
    public static final String OPEN_ACC = "open_acc_value";
    public static final String ORDER_OPEN_ACC = "order_open_acc_value";

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl oldHttpUrl = request.url();
        Request.Builder builder = request.newBuilder();
        List<String> headerValues = request.headers(KEY_BASE_URL);
        if (headerValues.size() > 0) {
            //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
            builder.removeHeader(KEY_BASE_URL);

            //匹配获得新的BaseUrl
            String headerValue = headerValues.get(0);
            HttpUrl newBaseUrl = null;
            //重要：这里替换前置服务host
            switch (headerValue) {
                case MASTER:
                    newBaseUrl = HttpUrl.parse(EnvironmentUtil.get().getBaseHost().getMasterUrl());
                    break;
                case PROXY:
                    newBaseUrl = HttpUrl.parse(EnvironmentUtil.get().getBaseHost().getProxyUrl());
                    break;
                case GIDC:
                    newBaseUrl = HttpUrl.parse(EnvironmentUtil.get().getBaseHost().getGidcUrl());
                    break;
                case OPEN_ACC:
                    newBaseUrl = HttpUrl.parse(EnvironmentUtil.get().getBaseHost().getOpenAccUrl());
                    break;
                case ORDER_OPEN_ACC:
                    newBaseUrl = HttpUrl.parse(EnvironmentUtil.get().getBaseHost().getOrderOpenAccUrl());
                    break;
            }

            HttpUrl newFullUrl = oldHttpUrl
                    .newBuilder()
                    .host(newBaseUrl.host())
                    .port(newBaseUrl.port())
                    .build();
            return chain.proceed(builder.url(newFullUrl).build());
        }
        return chain.proceed(request);
    }
}
