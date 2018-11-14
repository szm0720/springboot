package com.redis.normal.annotation;

import java.lang.annotation.*;

/**
 * 业务日志注解
 * Created by shimingming
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface BusinessLog {

    /**
     * logInfo参数用来输出日志信息
     * <code>
     *      @BusinessLog(logInfo="根据ID获取名字")
     *      public String getNameById(String id) {...}
     *      <p>
     *      private String getByIdFallback(String id) {...}
     * </code>
     */
    String logInfo() default "";
}
