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

import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: DateField<br>
 * enum description: 日期各个部分的枚举<br>
 * 与Calendar相应值对应
 *
 * @author MoBaiJun 2023/2/22 0:12
 */
@Getter
@AllArgsConstructor
public enum DateFieldType {

    /**
     * 世纪
     *
     * @see Calendar#ERA
     */
    ERA(Calendar.ERA),

    /**
     * 年
     *
     * @see Calendar#YEAR
     */
    YEAR(Calendar.YEAR),

    /**
     * 月
     *
     * @see Calendar#MONTH
     */
    MONTH(Calendar.MONTH),

    /**
     * 一年中第几周
     *
     * @see Calendar#WEEK_OF_YEAR
     */
    WEEK_OF_YEAR(Calendar.WEEK_OF_YEAR),

    /**
     * 一月中第几周
     *
     * @see Calendar#WEEK_OF_MONTH
     */
    WEEK_OF_MONTH(Calendar.WEEK_OF_MONTH),

    /**
     * 一月中的第几天
     *
     * @see Calendar#DAY_OF_MONTH
     */
    DAY_OF_MONTH(Calendar.DAY_OF_MONTH),

    /**
     * 一年中的第几天
     *
     * @see Calendar#DAY_OF_YEAR
     */
    DAY_OF_YEAR(Calendar.DAY_OF_YEAR),

    /**
     * 周几，1表示周日，2表示周一
     *
     * @see Calendar#DAY_OF_WEEK
     */
    DAY_OF_WEEK(Calendar.DAY_OF_WEEK),

    /**
     * 天所在的周是这个月的第几周
     *
     * @see Calendar#DAY_OF_WEEK_IN_MONTH
     */
    DAY_OF_WEEK_IN_MONTH(Calendar.DAY_OF_WEEK_IN_MONTH),

    /**
     * 上午或者下午
     *
     * @see Calendar#AM_PM
     */
    AM_PM(Calendar.AM_PM),

    /**
     * 小时，用于12小时制
     *
     * @see Calendar#HOUR
     */
    HOUR(Calendar.HOUR),

    /**
     * 小时，用于24小时制
     *
     * @see Calendar#HOUR
     */
    HOUR_OF_DAY(Calendar.HOUR_OF_DAY),

    /**
     * 分钟
     *
     * @see Calendar#MINUTE
     */
    MINUTE(Calendar.MINUTE),

    /**
     * 秒
     *
     * @see Calendar#SECOND
     */
    SECOND(Calendar.SECOND),

    /**
     * 毫秒
     *
     * @see Calendar#MILLISECOND
     */
    MILLISECOND(Calendar.MILLISECOND);

    /**
     * 枚举值
     */
    private final int value;

    /**
     * 将 {@link Calendar}相关值转换为DatePart枚举对象<br>
     *
     * @param calendarPartIntValue Calendar中关于Week的int值
     * @return DateField
     */
    public static DateFieldType of(int calendarPartIntValue) {
        return switch (calendarPartIntValue) {
            case Calendar.ERA -> ERA;
            case Calendar.YEAR -> YEAR;
            case Calendar.MONTH -> MONTH;
            case Calendar.WEEK_OF_YEAR -> WEEK_OF_YEAR;
            case Calendar.WEEK_OF_MONTH -> WEEK_OF_MONTH;
            case Calendar.DAY_OF_MONTH -> DAY_OF_MONTH;
            case Calendar.DAY_OF_YEAR -> DAY_OF_YEAR;
            case Calendar.DAY_OF_WEEK -> DAY_OF_WEEK;
            case Calendar.DAY_OF_WEEK_IN_MONTH -> DAY_OF_WEEK_IN_MONTH;
            case Calendar.AM_PM -> AM_PM;
            case Calendar.HOUR -> HOUR;
            case Calendar.HOUR_OF_DAY -> HOUR_OF_DAY;
            case Calendar.MINUTE -> MINUTE;
            case Calendar.SECOND -> SECOND;
            case Calendar.MILLISECOND -> MILLISECOND;
            default -> null;
        };
    }
}
