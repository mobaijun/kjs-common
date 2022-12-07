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
package com.mobaijun.common.enums.sms;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: SmsTypeEnum<br>
 * enum description：
 *
 * @author MoBaiJun 2022/5/12 13:42
 */
@Getter
public enum SmsTypeEnum {
    /**
     * 验证类短信
     */
    SMS(1, "验证类短信"),

    /**
     * 纯发送短信
     */
    MESSAGE(2, "纯发送短信");

    private final Integer code;

    private final String message;

    SmsTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}