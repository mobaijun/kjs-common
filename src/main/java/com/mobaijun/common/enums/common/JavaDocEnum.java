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
package com.mobaijun.common.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: JavaDocEnum<br>
 * enum description: Java 注释常量<br>
 *
 * @author MoBaiJun 2022/12/9 15:23
 */
@Getter
@AllArgsConstructor
public enum JavaDocEnum {

    /**
     * 注释前缀
     */
    COMMENT_PREFIX("/**", "注释前缀"),

    /**
     * 注释后缀
     */
    COMMENT_SUFFIX("*/", "注释后缀"),

    /**
     * 换行
     */
    COMMENT_RETURN("\n", "换行");

    private final String name;

    private final String desc;
}