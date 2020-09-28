package com.booleandev.data.aop;

import com.booleandev.data.filter.AppFilter;
import com.booleandev.data.filter.ClientFilter;
import com.booleandev.data.enums.FilterType;
import com.booleandev.data.filter.EnableFilter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
@Aspect
public class DbFilterAspect {

    @PersistenceContext
    private EntityManager entityManager;

    @Pointcut("@annotation(com.booleandev.data.aop.DbFilter) || @within(com.booleandev.data.aop.DbFilter)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {

        try{

            // 校验当前切点所在的类是否实现了 EnableFilter 接口
            if (!EnableFilter.class.isAssignableFrom(pjp.getTarget().getClass())) {
                return pjp.proceed();
            }

            EnableFilter enableFilter = (EnableFilter) pjp.getTarget();

            // 作用于方法上
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            DbFilter dbAnn = methodSignature.getMethod().getAnnotation(DbFilter.class);
            if (dbAnn != null) {
                return this.filterByAnn(dbAnn, pjp, enableFilter);
            }

            // 作用于类上
            DbFilter claDbAnn = (DbFilter) pjp.getTarget().getClass().getAnnotation(DbFilter.class);
            if (claDbAnn != null) {
                return this.filterByAnn(claDbAnn, pjp, enableFilter);
            }

            return pjp.proceed();
        }catch(Throwable e){
            e.printStackTrace();
            log.error("---------->error");
        }
        return null;
    }

    private void addClientFilter() {
        // do something
    }

    private void addAppFilter() {
        List<Long> appIds = new ArrayList<>();
        appIds.add(getApp());
        appIds.add(5L);
        appIds.add(1L);
        log.info("-------->appIds={}", appIds);
        entityManager.unwrap(Session.class)
                .enableFilter(AppFilter.APP_FILTER_NAME)
                .setParameterList(AppFilter.APP_FILTER_PARAMETER, appIds);
    }

    /**
     * 此方法在实际操作中，可从 localThread 中获取
     * @return  appList
     */
    private Long getApp() {
        return (long) new Random().nextInt(10);
    }

    private void addAllFilter(EnableFilter enableFilter) {
        Class c = enableFilter.getDomainClass();
        if (AppFilter.class.isAssignableFrom(c)) {
            // 添加 appFilter 行权限
            log.info("------------------>添加 app 行权限");
            addAppFilter();
        }
        if (ClientFilter.class.isAssignableFrom(c)) {
            // do something
            log.info("------------------>添加 client 行权限");
        }
    }

    private Object filterByAnn(DbFilter dbAnn, ProceedingJoinPoint pjp, EnableFilter enableFilter) throws Throwable {
        // 如果 enable 为 false，则不执行过滤
        if (!dbAnn.enable()) {
            return pjp.proceed();
        }

        FilterType[] types = dbAnn.filters();

        // 包含 NONE，则不添加
        if (Arrays.asList(types).contains(FilterType.NONE)) {
            return pjp.proceed();
        }

        // default ，如果包含 ALL，则添加所有拦截器
        if (Arrays.asList(types).contains(FilterType.ALL)) {
            this.addAllFilter(enableFilter);
            return pjp.proceed();
        }

        for (FilterType type : types) {
            switch (type) {
                case CLIENT:
                    // do something
                    break;
                case APP:
                    // do something
                    break;
                case NONE:
                case ALL:
                    break;
                default:
                    break;
            }
            return pjp.proceed();
        }
        return pjp.proceed();
    }
}
