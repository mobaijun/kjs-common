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
package com.mobaijun.common.enums.sys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: LoginType<br>
 * enum description： 登录类型
 *
 * @author MoBaiJun 2022/10/28 10:04
 */
@Getter
@RequiredArgsConstructor
public enum LoginType {

    /**
     * 账号密码登录
     */
    PWD("PWD", "账号密码登录"),

    /**
     * 验证码登录
     */
    SMS("SMS", "验证码登录"),

    /**
     * 微信登录
     */
    WX("WX", "微信登录"),

    /**
     * 其他，第三方登录
     */
    OTHER("OTHER", "其他，第三方登录");

    /**
     * 类型
     */
    private final String type;

    /**
     * 描述
     */
    private final String description;
}