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
package com.mobaijun.common.enums.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: FieldMetadataType<br>
 * enum description：字段元数据类型
 *
 * @author MoBaiJun 2022/5/12 13:28
 */
@Getter
@RequiredArgsConstructor
public enum FieldMetadataType {

    /**
     * 字段
     */
    FIELD(1),

    /**
     * 泛型
     */
    GENERIC(2);

    /**
     * 字段元数据类型
     */
    private final Integer code;
}