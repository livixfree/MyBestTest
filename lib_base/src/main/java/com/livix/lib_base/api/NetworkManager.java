package com.livix.lib_base.api;

import android.app.Application;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author LIVIX
 * @date: 2022/7/5
 */
public class NetworkManager {

    private static final String BASE_URL = EnvironmentUtil.get().getBaseHost().getMasterUrl();
    private volatile static NetworkManager singleton;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private NetworkManager() {
    }

    public static NetworkManager getInstance() {
        if (singleton == null) {
            synchronized (NetworkManager.class) {
                if (singleton == null) {
                    singleton = new NetworkManager();
                }
            }
        }
        return singleton;
    }

    public Retrofit getRetrofit(Application application, Interceptor... interceptors) {

        if (retrofit != null) {
            return retrofit;
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(Modifier.PROTECTED, Modifier.STATIC).create();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder()
                .readTimeout(20L, TimeUnit.SECONDS)
                .writeTimeout(20L, TimeUnit.SECONDS)
                .connectTimeout(20L, TimeUnit.SECONDS);

        for (Interceptor interceptor : interceptors) {
            httpBuilder.addInterceptor(interceptor);
        }

        HttpLoggingInterceptor.Logger logger = new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                try {
                    JSONObject object = new JSONObject(message);
                    Platform.get().log(gson.toJson(object), Platform.INFO, null);
                } catch (JSONException e) {
                    Platform.get().log(message, Platform.INFO, null);
                }
            }
        };

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpBuilder.addInterceptor(loggingInterceptor);

        okHttpClient = httpBuilder.build();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

}
