package com.booleandev.data.aop;

import com.booleandev.data.enums.FilterType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AppFilter
 * @date 2020/8/13 22:40
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RUNTIME)
public @interface DbFilter {

    /**
     * JPA 开启的拦截器类型<br>
     * 现支持的拦截器类型有：
     * <li>App:APP 行权限</li>
     * <li>CLIENT： 客户行权限</li>
     * <li>NONE： 不添加拦截器</li>
     * <li>ALL： 执行所有的拦截器</li>
     * @return  JpaFilterType
     */
    FilterType[] filters() default FilterType.ALL;

    /**
     * 是否开启拦截器
     * @return  是否开启 JpaFilter 拦截器
     */
    boolean enable() default true;
}
