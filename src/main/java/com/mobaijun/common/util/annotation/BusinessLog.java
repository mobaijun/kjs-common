package com.mobaijun.common.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: BusinessLog
 * annotation description：用来标记在控制器类或方法上，进行判断是否需要对接口进行日志记录
 *
 * @author MoBaiJun 2022/5/12 11:18
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessLog {

    /**
     * 是否进行日志记录，默认是开启
     *
     * @return boolean
     */
    boolean openLog() default true;
}