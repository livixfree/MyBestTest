package com.livix.lib_base.api;

/**
 * @author LIVIX
 * @date: 2022/7/7
 */
public interface IExceptionHandler {

    /**
     * 处理过滤错误信息
     *
     * @param e
     * @return
     */
    RxException handleException(Throwable e);
}
