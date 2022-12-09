package com.mobaijun.common.annotation.env;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * annotation name: Prod<br>
 * annotation description: 生产环境<br>
 * 表示当前方法性能安全性各方面达标，可以用于生产环境。
 *
 * @author MoBaiJun 2022/12/9 15:16
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Prod {
}
