package com.mobaijun.common.util.sensitive;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: Mask
 * annotation description： 脱敏
 *
 * @author MoBaiJun 2022/5/18 10:48
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mask {

    /**
     * 前置不需要打码的长度
     *
     * @return int
     */
    int prefixNoMaskLen() default 0;

    /**
     * 后置不需要打码的长度
     *
     * @return int
     */
    int suffixNoMaskLen() default 0;

    /**
     * 用什么打码
     *
     * @return int
     */
    String maskStr() default "*";
}
