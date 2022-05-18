package com.mobaijun.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: Excels
 * annotation description： Excel注解集
 *
 * @author MoBaiJun 2022/5/12 10:48
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excels {

    /**
     * Excel注解集
     *
     * @return Excel注解集
     */
    Excel[] value();
}
