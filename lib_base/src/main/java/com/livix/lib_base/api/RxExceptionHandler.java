package com.livix.lib_base.api;

/**
 * @author LIVIX
 * @date: 2022/7/7
 */
public final class RxExceptionHandler {
    /**
     * 默认的错误信息处理者
     */
    private static IExceptionHandler sIExceptionHandler;

    /**
     * 默认的错误信息处理者
     */
    public static void setsIExceptionHandler(IExceptionHandler exceptionHandler) {
        sIExceptionHandler = exceptionHandler;
    }

    /**
     * 处理过滤错误信息
     * @param e
     * @return
     */
    public static RxException handleException(Throwable e) {
        if (sIExceptionHandler == null) {
            return sIExceptionHandler.handleException(e);
        } else {
            return new RxException(e, RxException.DEFAULT_ERROR);
        }
    }
}
