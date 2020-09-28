package com.booleandev.data.filter;

import com.booleandev.data.enums.FilterType;

import javax.persistence.Column;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AppFilter
 * @date 2020/9/9 10:00
 */


public interface AppFilter extends IFilter {

    @Override
    default FilterType getType() {
        return FilterType.APP;
    }

    /**
     * APP 行权限拦截器参数名称
     */
    String APP_FILTER_PARAMETER = "appIds";
    /**
     * APP 行权限拦截器名称
     */
    String APP_FILTER_NAME = "appFilter";

    /**
     * 定义 app_id get 方法
     * 限制行权限字段
     * @return  appId long
     */
    @Column(name = "app_id")
    Long getAppId();

    /**
     * 定义 app_id set 方法
     * 限制行权限字段
     * @param appId appId long
     */
    void setAppId(Long appId);
}
