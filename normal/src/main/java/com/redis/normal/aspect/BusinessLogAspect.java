package com.redis.normal.aspect;

import com.redis.normal.annotation.BusinessLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static com.netflix.hystrix.contrib.javanica.utils.AopUtils.getMethodFromTarget;

/**
 * 业务日志切面
 * @author shimingming
 * @date 2018-10-29
 */
@Aspect
@Component
@Slf4j
public class BusinessLogAspect {


//    @Pointcut("execution(public * com.redis.com.redis.normal.controller..*.*(..))&& @com.redis.normal.annotation(com.yunniao.sparrow.engine.com.redis.normal.annotation.BusinessLog)" )
    @Pointcut("execution(public * com.redis.normal.controller..*.*(..))" )
    public void businessLogAnnotationPointcut(){}

    @Around(value = "businessLogAnnotationPointcut()")
    public Object methodsAnnotatedWithBusinessLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = getMethodFromTarget(joinPoint);
        Validate.notNull(method, "failed to get method from joinPoint: %s", joinPoint);
        Annotation p = method.getAnnotation(BusinessLog.class);
        Method m = p.getClass().getDeclaredMethod("logInfo");
        String values = (String) m.invoke(p);
        String name = joinPoint.getSignature().getName();
        String clazz = joinPoint.getTarget().getClass().toString();
        clazz = clazz.substring(5);
        log.info("耗时统计：" + clazz + "." + name + "()" +  values + " 开始处理...");
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("耗时统计：" + clazz + "." + name + "()" +  values + " -> 耗时" + (endTime - startTime) + "ms");
        return obj;
    }
}
