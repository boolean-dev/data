package com.booleandev.data.filter;

import javax.persistence.Column;

/**
 * 客户行权限拦截器
 *
 * @author Jiantao Yan
 * @title: AppFilter
 * @date 2020/9/9 10:00
 */


public interface ClientFilter extends IFilter {

    String APP_FILTER_PARAMETER = "clientIds";
    String APP_FILTER_NAME = "clientFilter";

    @Column(name = "client")
    Long getAppId();

    void setAppId(Long appId);
}
