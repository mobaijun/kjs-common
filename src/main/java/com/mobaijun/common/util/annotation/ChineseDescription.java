package com.mobaijun.common.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: ChineseDescription
 * annotation description：加在字段上，描述字段的中文名称
 * 用来解决资源扫描时候，扫描的类的字段上的中文注释获取的问题
 *
 * @author MoBaiJun 2022/5/12 11:18
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChineseDescription {

    /**
     * 中文注释的值
     */
    String value() default "";
}
