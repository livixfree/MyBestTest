package com.livix.lib_base.api;

import java.io.Serializable;

/**
 * @author LIVIX
 * @date: 2022/7/6
 */
public class Response<T> implements Serializable {
    private String code;
    private String message;
    private boolean success;
    private T data;
    private Object errorDetail;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(Object errorDetail) {
        this.errorDetail = errorDetail;
    }
}
