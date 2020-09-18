package com.booleandev.data.aop;

import com.booleandev.data.entity.AppFilter;
import com.booleandev.data.enums.JpaFilterType;
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
import java.util.List;
import java.util.Random;

@Slf4j
@Component
@Aspect
public class DbFilterAspect {

    @PersistenceContext
    private EntityManager entityManager;

    @Pointcut("@annotation(com.booleandev.data.aop.DbFilter)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {

        try{
            //从上下文里面获取 owerId，这个 Id 在 web 中就已经存好了
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            Method method = methodSignature.getMethod();
            DbFilter dbFilter = method.getAnnotation(DbFilter.class);
            JpaFilterType [] filterTypes = dbFilter.type();

            if (filterTypes.length == 1 && JpaFilterType.NONE.equals(filterTypes[0])) {
                return pjp.proceed();
            }
            for (JpaFilterType filterType : filterTypes) {
                switch (filterType) {
                    case APP:
                        //do something
                        addAppFilter();
                        break;
                    case CLIENT:
                        // do something
                        addClientFilter();
                        break;
                    case NONE:
                        break;
                    default:
                        break;

                }
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

    private Long getApp() {
        return (long) new Random().nextInt(10);
    }
}
