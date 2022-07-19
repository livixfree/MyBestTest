package com.livix.lib_base.api.bean;

/**
 * @author LIVIX
 * @date: 2022/7/1
 */
public class EnvHostTypeBean {

    /**
     * 旧中台环境
     */
    public static class Uat extends EnvHostBaseBean {
        public Uat() {
            setMasterUrl("https://app.wlbank.tech");
            setProxyUrl("http://103.39.218.165:8888");
            setGidcUrl("http://103.39.218.164:20032");
            setOpenAccUrl("https://onlineopen.wlbank.tech");
            setOrderOpenAccUrl("https://opening.wlbank.com.mo:2001/zh_hk/biz/homePage");
        }
    }

    /**
     * 新中台环境
     */
    public static class NewUat extends EnvHostBaseBean {
        public NewUat() {
            setMasterUrl("https://appmiddle.wlbank.tech:9529");
            setProxyUrl("http://103.39.218.165:8888");
            setGidcUrl("http://103.39.218.164:20032");
            setOpenAccUrl("https://appmiddle.wlbank.tech:9529");
            setOrderOpenAccUrl("https://opening.wlbank.com.mo:2001/zh_hk/biz/homePage");
        }
    }

    /**
     * Sit环境
     */
    public static class Sit extends EnvHostBaseBean {
        public Sit() {
            setMasterUrl("https://appsit.zbjjt.com");
            setProxyUrl("http://114.119.40.251:8888");
            setGidcUrl("http://183.62.118.51:20032");
            setOpenAccUrl("https://onlineopensit.zbjjt.com");
            setOrderOpenAccUrl("http://opening.wlbank.tech/zh_hk/biz/login");
        }
    }

    /**
     * 生产环境
     */
    public static class Release extends EnvHostBaseBean {
        public Release() {
            setMasterUrl("https://app.wlbank.com.mo");
            setProxyUrl("https://mobile.wlbank.com.mo");
            setGidcUrl("https://mobile.wlbank.com.mo");
            setOpenAccUrl("https://onlineopen.wlbank.com.mo");
            setOrderOpenAccUrl("https://opening.wlbank.com.mo:2001/zh_hk/biz/homePage");
        }
    }

}
