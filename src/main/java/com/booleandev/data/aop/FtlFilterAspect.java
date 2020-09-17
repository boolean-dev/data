package com.booleandev.data.aop;

import com.booleandev.data.entity.AppFilterInter;
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
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
@Aspect
public class FtlFilterAspect {

    @PersistenceContext
    private EntityManager entityManager;

    @Pointcut("@annotation(com.booleandev.data.aop.FtlFilter)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {

        try{
            //从上下文里面获取 owerId，这个 Id 在 web 中就已经存好了
            List<Long> appIds = List.of(getApp());
            log.info("-------->appIds={}", appIds);
            //获取查询中的 session
//            Session session = entityManager.unwrap(Session.class);
            // 在 session 中加入 filter
//            session.
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
//            Type type = ((ParameterizedType)pjp.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Method method = methodSignature.getMethod();
            FtlFilter ftlFilter = method.getAnnotation(FtlFilter.class);
            JpaFilterType [] filterTypes = ftlFilter.type();

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
//            Class[] classes = ftlFilter.entities();

//            for (Class aClass : classes) {
               /* if (aClass.isInstance(Object.class)) {
                    return pjp.proceed();
                }

                if (AppFilterInter.class.isAssignableFrom(aClass)) {
                    log.info("该类继承了 appFilter");
//                    org.hibernate.annotations.Filter filterAnnotation = AppFilterInter.class.getAnnotation(org.hibernate.annotations.Filter.class);
//                    String name = filterAnnotation.name();
                    FilterDef filterDef= AppFilterInter.class.getAnnotation(FilterDef.class);
                    String name = filterDef.name();
                    String parameter = filterDef.parameters()[0].name();
                    log.info("filter----->name={}", name);
//                    Filter filter = session.enableFilter("appFilter");
//                    filter.setParameter(parameter, getApp());
                    entityManager.unwrap(Session.class)
                            .enableFilter(name)
                            .setParameter(parameter, getApp());

                }*/

//                aClass.getAnnotation()

//                entityManager.unwrap(Session.class)
//                        .enableFilter("appFilter")
//                        .setParameter("appIds", getApp());
//            }
//            appFilter.

//            Filter filter = session.enableFilter("appFilter");
//            // filter 中加入数据
//            filter.setParameter("appIds", getApp());
//            filter.setParameterList("appIds", appIds);
            //执行 被拦截的方法
            return pjp.proceed();
        }catch(Throwable e){
            e.printStackTrace();
            log.error("---------->error");
        }
        return null;
    }

    private void addClientFilter() {
        entityManager.unwrap(Session.class)
                        .enableFilter(AppFilterInter.APP_FILTER_NAME)
                        .setParameter(AppFilterInter.APP_FILTER_PARAMETER, getApp());
    }

    private void addAppFilter() {

    }

    private Long getApp() {
        return (long) new Random().nextInt(10);
    }
}
