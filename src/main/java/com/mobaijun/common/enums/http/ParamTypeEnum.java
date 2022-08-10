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
package com.mobaijun.common.enums.http;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: ParamTypeEnum
 * enum description：请求参数类型
 *
 * @author MoBaiJun 2022/5/12 13:27
 */
@Getter
public enum ParamTypeEnum {
    /**
     * query param参数
     */
    QUERY_PARAM(1),

    /**
     * body param参数，请求是json传来的
     */
    REQUEST_BODY(2);

    ParamTypeEnum(Integer code) {
        this.code = code;
    }

    private final Integer code;
}