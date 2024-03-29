/*
 * Copyright (C) 2022 [www.mobaijun.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.common.annotation.log;

import com.mobaijun.common.enums.log.BusinessType;
import com.mobaijun.common.enums.log.LogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * AnnotationName: Log
 * <br>
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
     * @return String
     */
    String value() default "";

    /**
     * 操作类型  ， 默认新增
     *
     * @return 操作类型
     */
    BusinessType businessType() default BusinessType.INSERT;

    /**
     * 日志类型
     *
     * @return 默认业务日志
     */
    LogType logType() default LogType.BUSINESS;

    /**
     * 操作模块
     *
     * @return 业务模块
     */
    String module() default "";

    /**
     * 是否保存方法入参
     *
     * @return boolean
     */
    boolean recordParams() default true;

    /**
     * 是否保存方法返回值
     *
     * @return boolean
     */
    boolean recordResult() default true;
}