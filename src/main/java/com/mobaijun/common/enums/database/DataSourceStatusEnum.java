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
package com.mobaijun.common.enums.database;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: DataSourceStatusEnum<br>
 * enum description：数据库连接的状态枚举
 *
 * @author MoBaiJun 2022/5/12 13:15
 */
@Getter
public enum DataSourceStatusEnum {
    /**
     * 正常
     */
    ENABLE(1, "正常"),

    /**
     * 无法连接
     */
    ERROR(2, "无法连接");

    private final Integer code;

    private final String message;

    DataSourceStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}