package com.mobaijun.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: RedisLock
 * annotation description： RedisLock
 *
 * @author MoBaiJun 2022/5/18 9:47
 */
@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLock {

    /**
     * 锁key
     *
     * @return String
     */
    String lockKey();

    /**
     * 锁释放时间 默认五秒
     *
     * @return long
     */
    long timeout() default 5 * 1000;

    /**
     * 时间格式 默认：毫秒
     *
     * @return TimeUnit
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
