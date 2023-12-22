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
package com.mobaijun.common.enums.log;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: LoginType<br>
 * enum description： 登录类型
 *
 * @author MoBaiJun 2022/5/12 9:26
 */
@Getter
public enum LoginType {

    /**
     * 其他
     */
    OTHER(0, "Other"),

    /**
     * 平台
     */
    PORTAL(1, "Portal");

    private final int code;

    private final String name;

    LoginType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}