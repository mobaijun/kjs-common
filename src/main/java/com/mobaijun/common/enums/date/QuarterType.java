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
package com.mobaijun.common.enums.date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: QuarterType<br>
 * enum description: 季度枚举
 *
 * @author MoBaiJun 2023/2/22 0:11
 */
@Getter
@RequiredArgsConstructor
public enum QuarterType {

    /**
     * 第一季度
     */
    Q1(1),

    /**
     * 第二季度
     */
    Q2(2),

    /**
     * 第三季度
     */
    Q3(3),

    /**
     * 第四季度
     */
    Q4(4);

    /**
     * 季度int表示
     */
    private final int value;

    /**
     * 将 季度int转换为Season枚举对象<br>
     *
     * @param intValue 季度int表示
     * @return {@link QuarterType}
     * @see #Q1
     * @see #Q2
     * @see #Q3
     * @see #Q4
     */
    public static QuarterType of(int intValue) {
        return switch (intValue) {
            case 1 -> Q1;
            case 2 -> Q2;
            case 3 -> Q3;
            case 4 -> Q4;
            default -> null;
        };
    }
}
