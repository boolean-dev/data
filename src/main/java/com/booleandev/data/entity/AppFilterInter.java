package com.booleandev.data.entity;

import org.hibernate.annotations.*;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import java.lang.annotation.Inherited;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AppFilter
 * @date 2020/9/9 10:00
 */


public interface AppFilterInter extends FtlJpaFilter{

    public static final String APP_FILTER_PARAMETER = "appIds";
    public static final String  APP_FILTER_NAME = "appFilter";

    @Column(name = "app_id")
    Long getAppId();

    void setAppId(Long appId);
}
