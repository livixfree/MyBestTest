package com.livix.lib_base.api;

import com.livix.lib_base.api.bean.EnvHostBaseBean;
import com.livix.lib_base.api.bean.EnvHostTypeBean;

/**
 * @author LIVIX
 * @date: 2022/7/1
 */
public class EnvironmentUtil {
    private EnvHostBaseBean bean = null;
    private volatile static EnvironmentUtil singleton;

    /**
     * 初始化网络环境
     *
     * @param evn 环境类型
     */
    public static void init(@EnvironmentType String evn) {
        if (singleton == null) {
            synchronized (EnvironmentUtil.class) {
                if (singleton == null) {
                    singleton = new EnvironmentUtil(evn);
                }
            }
        }
    }

    private EnvironmentUtil(String evn) {
        switch (evn) {
            case EnvironmentType.UAT:
                bean = new EnvHostTypeBean.Uat();
                break;
            case EnvironmentType.NEW_UAT:
                bean = new EnvHostTypeBean.NewUat();
                break;
            case EnvironmentType.SIT:
                bean = new EnvHostTypeBean.Sit();
                break;
            case EnvironmentType.RELEASE:
                bean = new EnvHostTypeBean.Release();
                break;
            default:
                break;
        }
    }

    public static EnvironmentUtil get() {
        return singleton;
    }

    public EnvHostBaseBean getBaseHost() {
        if (bean == null) {
            throw new NullPointerException("please init env");
        }
        return bean;
    }

}
