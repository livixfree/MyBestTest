package com.livix.lib_base;

import android.app.Application;

import com.livix.lib_base.api.EnvironmentType;
import com.livix.lib_base.api.EnvironmentUtil;

/**
 * @author LIVIX
 * @date: 2022/7/4
 */
public class BaseApplication extends Application {
    private static BaseApplication application;

    public static BaseApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        EnvironmentUtil.init(EnvironmentType.UAT);
    }
}
