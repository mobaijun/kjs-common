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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: WeekEnum<br>
 * enum description: 日期枚举
 *
 * @author MoBaiJun 2022/11/22 10:58
 */
@Getter
@AllArgsConstructor
public enum Week {

    /**
     * 星期一
     */
    MON(1, "星期一"),

    /**
     * 星期二
     */
    TUES(2, "星期二"),

    /**
     * 星期三
     */
    WEB(3, "星期三"),

    /**
     * 星期四
     */
    THUR(4, "星期四"),

    /**
     * 星期五
     */
    FRI(5, "星期五"),

    /**
     * 星期六
     */
    SAT(6, "星期六"),

    /**
     * 星期七
     */
    SUN(7, "星期七");

    /**
     * 索引
     */
    private final Integer index;

    /**
     * 说明
     */
    private final String desc;
}