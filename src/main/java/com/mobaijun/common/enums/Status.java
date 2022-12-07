/*
 * Copyright (C) 2022 www.mobaijun.com
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
package com.mobaijun.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * EnumName: Status<br>
 * 枚举描述： 通用状态字段
 *
 * @author MoBaiJun 2022/4/25 14:43
 */
@Getter
@AllArgsConstructor
public enum Status {

    /**
     * 成功
     */
    OK(200, "OK"),

    /**
     * 异常
     */
    ERROR(500, "ERROR"),

    /**
     * 未删除
     */
    NOT_DELETED(0, "未删除"),

    /**
     * 已删除
     */
    DELETED(1, "已删除"),

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 失败
     */
    FAIL(1, "失败");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 值
     */
    private final String value;
}