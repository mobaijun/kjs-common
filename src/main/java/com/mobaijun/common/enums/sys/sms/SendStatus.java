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
package com.mobaijun.common.enums.sys.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: SendStatus<br>
 * enum description：消息发送状态
 *
 * @author MoBaiJun 2022/5/12 13:41
 */
@Getter
@AllArgsConstructor
public enum SendStatus {

    /**
     * 未发送
     */
    WAITING(0, "未发送"),

    /**
     * 发送成功
     */
    SUCCESS(1, "发送成功"),

    /**
     * 发送失败
     */
    FAILED(2, "发送失败"),

    /**
     * 失效
     */
    INVALID(3, "失效");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 状态描述
     */
    private final String message;
}