package com.booleandev.data.entity;

import com.booleandev.data.enums.JpaFilterType;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.MappedSuperclass;

import static com.booleandev.data.entity.AppFilterInter.APP_FILTER_NAME;
import static com.booleandev.data.entity.AppFilterInter.APP_FILTER_PARAMETER;


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
@Filter(name = APP_FILTER_NAME, condition = "app_id = :appIds")
public class AppBaseEntity implements AppFilterInter{

    private Long appId;
}
