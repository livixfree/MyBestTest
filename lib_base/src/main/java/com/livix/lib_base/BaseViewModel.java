package com.livix.lib_base;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;

import com.livix.lib_base.api.BaseObserver;
import com.livix.lib_base.api.RxUtils;
import com.uber.autodispose.AutoDisposeConverter;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author LIVIX
 * @date: 2022/7/8
 */
public class BaseViewModel extends ViewModel {

    private LifecycleOwner lifecycleOwner;

    /**
     * http统一请求方法
     *
     * @param observable 通过ApiManager类获取Api地址
     * @param observer   请求回调
     * @param <T>        数据类型
     */
    public <T> void httpRequest(Observable<T> observable, BaseObserver<T> observer) {
        observable.compose(RxUtils.schedulerTransformer())
                .as(bindLifecycle())
                .subscribe(observer);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public <T> AutoDisposeConverter<T> bindLifecycle() {
        if (lifecycleOwner == null) {
            throw new NullPointerException("lifecycleOwner == null");
        }
        return AutoDisposeUtil.bindLifecycle(lifecycleOwner);
    }


}
