package com.booleandev.data.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 测试注解顺序
 *
 * @author Jiantao Yan
 * @title: First
 * @date 2020/9/27 10:49
 */

@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RUNTIME)
public @interface First {
}
