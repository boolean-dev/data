package com.booleandev.data.aop;

import com.booleandev.data.enums.JpaFilterType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
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
public @interface FtlFilter {
    JpaFilterType[] type() default JpaFilterType.NONE;
}
