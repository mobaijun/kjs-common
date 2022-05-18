package com.mobaijun.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: RedisLimiting
 * annotation description： Redis 接口限流注解
 *
 * @author MoBaiJun 2022/5/17 10:42
 */
@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLimiting {

    /**
     * 单位时间（秒）,默认为 10 秒最大请求 1 次
     *
     * @return int
     */
    long seconds() default 10;

    /**
     * 单位时间最大请求次数,默认 1 次
     *
     * @return int
     */
    int maxCount() default 1;
}
