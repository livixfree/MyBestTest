package com.livix.lib_base.api;

import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @author LIVIX
 * @date: 2022/7/7
 */
public class RxException extends Exception {

    /**
     * 默认错误码
     */
    public static final int DEFAULT_ERROR = -1;

    /**
     * 自定义的错误码
     */
    private int code;

    public RxException(String message, int code) {
        super(message);
        this.code = code;
    }

    public RxException(Throwable e, int code) {
        super(e);
        this.code = code;
    }

    /**
     * 获取自定义的错误码
     *
     * @return code
     */
    private int getCode() {
        return code;
    }

    @Nullable
    @Override
    public String getMessage() {
        return getDetailMessage();
    }

    /**
     * 获取详情信息
     *
     * @return Message
     */
    public String getDetailMessage() {
        return super.getMessage();
    }

    /**
     * 获取错误堆栈信息
     *
     * @return StackTraceString
     */
    public String getExceptionStackTraceInfo() {
        return Log.getStackTraceString(this);
    }
}
