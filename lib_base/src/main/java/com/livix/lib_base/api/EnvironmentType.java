package com.livix.lib_base.api;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author LIVIX
 * @date: 2022/7/1
 */
@StringDef({EnvironmentType.NEW_UAT, EnvironmentType.UAT, EnvironmentType.SIT, EnvironmentType.RELEASE})
@Retention(RetentionPolicy.SOURCE)
public @interface EnvironmentType {

    /**
     * 旧中台
     */
    String UAT = "UAT";

    /**
     * 新中台
     */
    String NEW_UAT = "NEW_UAT";

    /**
     * SIT环境
     */
    String SIT = "SIT";

    /**
     * 生产环境
     */
    String RELEASE = "RELEASE";

}
