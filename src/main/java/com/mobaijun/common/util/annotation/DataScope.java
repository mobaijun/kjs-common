package com.mobaijun.common.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: DataScope
 * annotation description： 数据权限过滤注解
 *
 * @author MoBaiJun 2022/5/12 11:05
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataScope {

    /**
     * 部门表的别名
     *
     * @return String
     */
    String deptAlias() default "";

    /**
     * 用户表的别名
     *
     * @return String
     */
    String userAlias() default "";
}
