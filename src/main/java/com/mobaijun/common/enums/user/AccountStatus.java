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
package com.mobaijun.common.enums.user;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: AccountStatus<br>
 * enum description： 账号状态
 *
 * @author MoBaiJun 2022/5/12 9:20
 */
@Getter
public enum AccountStatus {

    /**
     * 启用
     */
    OK(1, "启用"),

    /**
     * 冻结
     */
    FREEZE(2, "冻结"),

    /**
     * 被删除
     */
    DELETED(-1, "被删除");

    private final int code;
    private final String message;

    AccountStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}