package com.mobaijun.common.annotation;

import com.mobaijun.common.util.base.BaseWrapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: Wrapper
 * annotation description：结果包装的注解，一般用在Controller层，给最后响应结果做包装
 *
 * @author MoBaiJun 2022/5/12 14:01
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Wrapper {

    /**
     * 具体包装类
     * @return Class
     */
    Class<? extends BaseWrapper<?>>[] value();
}

