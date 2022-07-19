package com.livix.lib_base.api;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author LIVIX
 * @date: 2022/6/29
 */
@StringDef({HeaderConfig.HOST, HeaderConfig.X_SERIAL_NUMBER, HeaderConfig.X_DEVICE_MODEL
        , HeaderConfig.X_DEVICE_ID, HeaderConfig.X_I18N, HeaderConfig.X_CHANNEL
        , HeaderConfig.X_ACCESS_TOKEN, HeaderConfig.TOKEN_NAME, HeaderConfig.GRAY_MARK})
@Retention(RetentionPolicy.SOURCE)
public @interface HeaderConfig {

    String HOST = "Host";

    String X_SERIAL_NUMBER = "x-serial-number";

    String X_DEVICE_MODEL = "x-device-model";

    String X_DEVICE_ID = "x-device-id";

    String X_I18N = "x-i18n";

    String X_CHANNEL = "x-channel";

    String X_ACCESS_TOKEN = "x-access-token";

    String TOKEN_NAME = "_token_name";

    String GRAY_MARK = "grayMark";

}
