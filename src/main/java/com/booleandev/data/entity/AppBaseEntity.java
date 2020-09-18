package com.booleandev.data.entity;

import com.booleandev.data.filter.AppFilter;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.MappedSuperclass;

import static com.booleandev.data.filter.AppFilter.APP_FILTER_NAME;
import static com.booleandev.data.filter.AppFilter.APP_FILTER_PARAMETER;


/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AppBaseEntity
 * @date 2020/9/9 17:03
 */
@Data
@MappedSuperclass
@FilterDef(name = APP_FILTER_NAME, parameters = {@ParamDef(name = APP_FILTER_PARAMETER, type = "long")})
@Filter(name = APP_FILTER_NAME, condition = "app_id IN (:appIds)")
public class AppBaseEntity implements AppFilter {

    private Long appId;
}
