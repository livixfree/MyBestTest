package com.livix.lib_base.api;

import androidx.annotation.StringDef;

import com.livix.lib_base.api.interceptor.BaseUrlInterceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author LIVIX
 * @date: 2022/7/4
 */
@StringDef({BaseUrlHeaderConstant.MASTER_HEADER
        , BaseUrlHeaderConstant.PROXY_HEADER
        , BaseUrlHeaderConstant.GIDC_HEADER
        , BaseUrlHeaderConstant.OPEN_ACC_HEADER
        , BaseUrlHeaderConstant.ORDER_OPEN_ACC_HEADER})
@Retention(RetentionPolicy.SOURCE)
public @interface BaseUrlHeaderConstant {

    String MASTER_HEADER = BaseUrlInterceptor.KEY_BASE_URL + ":" + BaseUrlInterceptor.MASTER;

    String PROXY_HEADER = BaseUrlInterceptor.KEY_BASE_URL + ":" + BaseUrlInterceptor.PROXY;

    String GIDC_HEADER = BaseUrlInterceptor.KEY_BASE_URL + ":" + BaseUrlInterceptor.GIDC;

    String OPEN_ACC_HEADER = BaseUrlInterceptor.KEY_BASE_URL + ":" + BaseUrlInterceptor.OPEN_ACC;

    String ORDER_OPEN_ACC_HEADER = BaseUrlInterceptor.KEY_BASE_URL + ":" + BaseUrlInterceptor.ORDER_OPEN_ACC;

}
