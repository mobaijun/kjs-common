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
package com.mobaijun.common.enums.datasource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: SortingType<br>
 * enum description： 排序
 *
 * @author MoBaiJun 2022/5/12 9:31
 */
@Getter
@RequiredArgsConstructor
public enum SortingType {

    /**
     * 升序
     */
    ASC("asc"),

    /**
     * 倒序
     */
    DESC("desc");

    /**
     * 描述
     */
    private final String des;
}