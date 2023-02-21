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
package com.mobaijun.common.enums.date;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: Quarter<br>
 * enum description: 季度枚举
 *
 * @author MoBaiJun 2023/2/22 0:11
 */
public enum Quarter {

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

    private final int value;

    Quarter(int value) {
        this.value = value;
    }

    /**
     * 将 季度int转换为Season枚举对象<br>
     *
     * @param intValue 季度int表示
     * @return {@link Quarter}
     * @see #Q1
     * @see #Q2
     * @see #Q3
     * @see #Q4
     */
    public static Quarter of(int intValue) {
        switch (intValue) {
            case 1:
                return Q1;
            case 2:
                return Q2;
            case 3:
                return Q3;
            case 4:
                return Q4;
            default:
                return null;
        }
    }

    public int getValue() {
        return this.value;
    }
}
