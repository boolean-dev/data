package com.booleandev.data.entity;

import javax.persistence.Column;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AppFilter
 * @date 2020/9/9 10:00
 */


public interface AppFilter extends BaseFilter {

    public static final String APP_FILTER_PARAMETER = "appIds";
    public static final String  APP_FILTER_NAME = "appFilter";

    @Column(name = "app_id")
    Long getAppId();

    void setAppId(Long appId);
}
