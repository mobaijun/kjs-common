package com.mobaijun.common.annotation;

import com.mobaijun.common.enums.database.DataSourceType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: DataSource
 * annotation description： 自定义多数据源切换
 *
 * @author MoBaiJun 2022/5/12 10:47
 */
@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    /**
     * 切换数据源名称
     *
     * @return 数据源类型
     */
    DataSourceType value() default DataSourceType.MASTER;
}
