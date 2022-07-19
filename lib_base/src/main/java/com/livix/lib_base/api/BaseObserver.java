package com.livix.lib_base.api;

import android.util.Log;

import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * @author LIVIX
 * @date: 2022/7/6
 */
public abstract class BaseObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T t) {
        try {
            onSuccess(t);
        } catch (Throwable e) {
            onFailure(e.getMessage());
        }

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Log.e("BaseObserver", "-->Subscriber is onError");
        try {
            if (e instanceof SocketTimeoutException) {
                e.printStackTrace();
                // 超时异常更换文案
                onFailure("请求超时");
            } else if (e instanceof HttpException) {
                e.printStackTrace();
                // HTTP异常更换文案

            } else {

            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        onFailure(e.getMessage());
    }

    @Override
    protected void onStart() {
        Log.e("BaseObserver", "-->BaseObserver is onStart");
    }

    @Override
    public void onComplete() {
        Log.e("BaseObserver", "-->BaseObserver is onComplete");
    }

    public abstract void onSuccess(T t);

    public abstract void onFailure(String string);


}
