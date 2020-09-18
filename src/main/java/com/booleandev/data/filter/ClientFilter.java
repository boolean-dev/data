package com.booleandev.data.filter;

import javax.persistence.Column;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AppFilter
 * @date 2020/9/9 10:00
 */


public interface ClientFilter{

    public static final String APP_FILTER_PARAMETER = "clientIds";
    public static final String  APP_FILTER_NAME = "clientFilter";

    @Column(name = "client")
    Long getAppId();

    void setAppId(Long appId);
}
