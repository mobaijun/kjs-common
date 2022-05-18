package com.mobaijun.common.annotation;

import com.mobaijun.common.enums.log.BusinessType;

/**
 * software：IntelliJ IDEA 2022.1
 * annotation name: OpenLog
 * annotation description： 操作日志注解，默认类型新增
 *
 * @author MoBaiJun 2022/5/17 10:51
 */
public @interface OperateLog {

    /**
     * 操作类型  ， 默认新增
     *
     * @return 操作类型
     */
    BusinessType type() default BusinessType.INSERT;
}
