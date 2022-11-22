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
 * software：IntelliJ IDEA 2022.2.3
 * enum name: DeleteType
 * enum description: 逻辑删除
 *
 * @author MoBaiJun 2022/11/22 12:19
 */
@Getter
@AllArgsConstructor
public enum DeleteType {

    /**
     * 未删除
     */
    IS_DEFAULT((byte) 0, "未删除"),

    /**
     * 已删除
     */
    IS_DELETE((byte) 1, "已删除");

    /**
     * 状态码
     */
    private final Byte code;

    /**
     * 描述
     */
    private final String description;
}