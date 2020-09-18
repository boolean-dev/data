package com.booleandev.data.entity;

import com.booleandev.data.filter.AppFilter;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static com.booleandev.data.filter.AppFilter.APP_FILTER_NAME;
import static com.booleandev.data.filter.AppFilter.APP_FILTER_PARAMETER;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: Account
 * @date 2020/8/14 11:49
 */

@Data
@Entity
@FilterDef(name = APP_FILTER_NAME, parameters = {@ParamDef(name = APP_FILTER_PARAMETER, type = "long")})
@Filter(name = APP_FILTER_NAME, condition = "app_id IN (:appIds)")
public class Account implements AppFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long appId;

    private String name;

    private Integer age;

    private String email;
}
