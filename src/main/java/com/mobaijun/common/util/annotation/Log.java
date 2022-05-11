package com.mobaijun.common.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * AnnotationName: Log
 * 注解描述： 日志注解 标记需要做业务日志的方法
 *
 * @author MoBaiJun 2022/4/22 16:52
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {

    /**
     * 业务的名称
     *
     * @return 返回路径
     */
    String value() default "";
}
