package com.livix.lib_base.api.interceptor;

import androidx.annotation.NonNull;

import com.livix.lib_base.api.HeaderConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author LIVIX
 * @date: 2022/6/29
 */
public class HeaderInterceptor implements Interceptor {
    private static final String X_SERIAL_NUMBER_VALUE = "A0AE5BA8-6B51-43E3-9465-F156CBCB874C";
    private static final String X_DEVICE_MODEL_VALUE = "unknown";


    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        HttpUrl url = chain.request().url();

        builder.addHeader(HeaderConfig.HOST, url.host());
        builder.addHeader(HeaderConfig.X_SERIAL_NUMBER, X_SERIAL_NUMBER_VALUE);
        builder.addHeader(HeaderConfig.X_DEVICE_MODEL, X_DEVICE_MODEL_VALUE);
        builder.addHeader(HeaderConfig.X_DEVICE_ID, "4bc230fa2a97d405");
        builder.addHeader(HeaderConfig.X_I18N, "zh_CN");
        builder.addHeader(HeaderConfig.X_CHANNEL, "EBANK_PERSONAL.APP");
//        builder.addHeader(HeaderConfig.X_ACCESS_TOKEN, "");
//        builder.addHeader(HeaderConfig.TOKEN_NAME, "");
//        builder.addHeader(HeaderConfig.GRAY_MARK, "0");

        return chain.proceed(builder.build());
    }
}
