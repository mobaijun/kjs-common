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
package com.mobaijun.common.enums.verification;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: VerificationType<br>
 * enum description: 字段属性类别
 *
 * @author MoBaiJun 2023/2/21 13:33
 */
@Getter
@AllArgsConstructor
public enum VerificationType {

    /**
     * 身份证
     */
    ID_CARD(1, "id_card", "身份证"),

    /**
     * 邮箱
     */
    EMAIL(2, "email", "邮箱"),

    /**
     * 手机号
     */
    PHONE(3, "phone", "手机号"),

    /**
     * URL
     */
    URL(4, "url", "网络地址");


    /**
     * 代码
     */
    private final int code;

    /**
     * 属性
     */
    private final String value;

    /**
     * 描述
     */
    private final String description;
}
