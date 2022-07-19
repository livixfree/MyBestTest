package com.livix.lib_base.api.bean;

/**
 * @author LIVIX
 * @date: 2022/7/1
 */
public class EnvHostBaseBean {

    private String masterUrl;
    private String proxyUrl;
    private String gidcUrl;
    private String openAccUrl;
    private String orderOpenAccUrl;

    public String getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(String masterUrl) {
        this.masterUrl = masterUrl;
    }

    public String getProxyUrl() {
        return proxyUrl;
    }

    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    public String getGidcUrl() {
        return gidcUrl;
    }

    public void setGidcUrl(String gidcUrl) {
        this.gidcUrl = gidcUrl;
    }

    public String getOpenAccUrl() {
        return openAccUrl;
    }

    public void setOpenAccUrl(String openAccUrl) {
        this.openAccUrl = openAccUrl;
    }

    public String getOrderOpenAccUrl() {
        return orderOpenAccUrl;
    }

    public void setOrderOpenAccUrl(String orderOpenAccUrl) {
        this.orderOpenAccUrl = orderOpenAccUrl;
    }
}
