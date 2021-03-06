package com.booleandev.data.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * First 注解切面
 *
 * @author Jiantao Yan
 * @title: FirstAspect
 * @date 2020/9/27 10:51
 */

@Slf4j
@Component
@Aspect
@Order(1)
public class FirstAspect {

    @Pointcut("@annotation(com.booleandev.data.aop.First) || @within(com.booleandev.data.aop.First)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        log.info("--------------> ann,first注解执行");

        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

}
