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
package com.mobaijun.common.enums.sys.log;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: LogType<br>
 * enum description： 日志类型
 *
 * @author MoBaiJun 2022/5/12 9:28
 */
@Getter
@AllArgsConstructor
public enum LogType {

    /**
     * 正常日志类型
     */
    NORMAL("0", "正常日志"),

    /**
     * 登录日志
     */
    LOGIN("1", "登录日志"),

    /**
     * 登录失败日志
     */
    LOGIN_FAIL("2", "登录失败日志"),

    /**
     * 退出日志
     */
    EXIT("3", "退出日志"),

    /**
     * 异常日志
     */
    EXCEPTION("4", "异常日志"),

    /**
     * 业务日志
     */
    BUSINESS("5", "业务日志"),

    /**
     * 错误日志类型
     */
    ERROR("6", "错误日志");

    /**
     * 类型
     */
    private final String type;

    /**
     * 日志类型
     */
    private final String message;
}