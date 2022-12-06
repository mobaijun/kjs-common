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
package com.mobaijun.common.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3
 * enum name: LanguageEnums
 * enum description: 语言枚举
 *
 * @author MoBaiJun 2022/12/5 9:15
 */
@Getter
@AllArgsConstructor
public enum LanguageEnum {

    /**
     * Chinese
     */
    ZH_CN("zh-CN"),

    /**
     * English
     */
    EN("en-US");

    /**
     * 值
     */
    private final String value;
}