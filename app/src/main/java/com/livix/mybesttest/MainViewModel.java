package com.livix.mybesttest;

import androidx.lifecycle.MutableLiveData;

import com.livix.lib_base.BaseViewModel;
import com.livix.lib_base.api.ApiManager;
import com.livix.lib_base.api.BaseObserver;
import com.livix.lib_base.api.Response;
import com.livix.lib_base.api.TokenBean;

/**
 * @author LIVIX
 * @date: 2022/7/12
 */
public class MainViewModel extends BaseViewModel {
    private final MutableLiveData<TokenBean> tokenLiveData;

    public MainViewModel() {
        tokenLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<TokenBean> getTokenLiveData() {
        return tokenLiveData;
    }

    public void getToken() {

        httpRequest(ApiManager.getInstance().getMainApi().getToken(), new BaseObserver<Response<TokenBean>>() {
            @Override
            public void onSuccess(Response<TokenBean> tokenBeanResponse) {
                tokenLiveData.postValue(tokenBeanResponse.getData());
            }

            @Override
            public void onFailure(String string) {

            }
        });

    }
}
