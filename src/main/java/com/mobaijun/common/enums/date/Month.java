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

import com.mobaijun.common.assertions.Assert;
import com.mobaijun.common.collection.ArrayUtil;

import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: Month<br>
 * enum description:
 * 月份枚举<br>
 * 与Calendar中的月份int值对应
 *
 * @author potatoxf
 * @author MoBaiJun 2023/2/22 0:13
 * @see Calendar#JANUARY
 * @see Calendar#FEBRUARY
 * @see Calendar#MARCH
 * @see Calendar#APRIL
 * @see Calendar#MAY
 * @see Calendar#JUNE
 * @see Calendar#JULY
 * @see Calendar#AUGUST
 * @see Calendar#SEPTEMBER
 * @see Calendar#OCTOBER
 * @see Calendar#NOVEMBER
 * @see Calendar#DECEMBER
 * @see Calendar#UNDECIMBER
 */
public enum Month {

    /**
     * 一月
     */
    JANUARY(Calendar.JANUARY),

    /**
     * 二月
     */
    FEBRUARY(Calendar.FEBRUARY),

    /**
     * 三月
     */
    MARCH(Calendar.MARCH),

    /**
     * 四月
     */
    APRIL(Calendar.APRIL),

    /**
     * 五月
     */
    MAY(Calendar.MAY),

    /**
     * 六月
     */
    JUNE(Calendar.JUNE),

    /**
     * 七月
     */
    JULY(Calendar.JULY),

    /**
     * 八月
     */
    AUGUST(Calendar.AUGUST),

    /**
     * 九月
     */
    SEPTEMBER(Calendar.SEPTEMBER),

    /**
     * 十月
     */
    OCTOBER(Calendar.OCTOBER),

    /**
     * 十一月
     */
    NOVEMBER(Calendar.NOVEMBER),

    /**
     * 十二月
     */
    DECEMBER(Calendar.DECEMBER),

    /**
     * 十三月，仅用于农历
     */
    UNDECIMBER(Calendar.UNDECIMBER);

    /**
     * Months aliases.
     */
    private static final String[] ALIASES = {
            "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"
    };

    private static final Month[] ENUMS = Month.values();

    /**
     * 对应值，见{@link Calendar}
     */
    private final int value;

    /**
     * 构造
     *
     * @param value 对应值，见{@link Calendar}
     */
    Month(int value) {
        this.value = value;
    }

    /**
     * 将 {@link Calendar}月份相关值转换为Month枚举对象<br>
     * 未找到返回{@code null}
     *
     * @param calendarMonthIntValue Calendar中关于Month的int值，从0开始
     * @return Month
     * @see Calendar#JANUARY
     * @see Calendar#FEBRUARY
     * @see Calendar#MARCH
     * @see Calendar#APRIL
     * @see Calendar#MAY
     * @see Calendar#JUNE
     * @see Calendar#JULY
     * @see Calendar#AUGUST
     * @see Calendar#SEPTEMBER
     * @see Calendar#OCTOBER
     * @see Calendar#NOVEMBER
     * @see Calendar#DECEMBER
     * @see Calendar#UNDECIMBER
     */
    public static Month of(int calendarMonthIntValue) {
        if (calendarMonthIntValue >= ENUMS.length || calendarMonthIntValue < 0) {
            return null;
        }
        return ENUMS[calendarMonthIntValue];
    }

    /**
     * 解析别名为Month对象，别名如：jan或者JANUARY，不区分大小写
     *
     * @param name 别名值
     * @return 月份枚举Month，非空
     * @throws IllegalArgumentException 如果别名无对应的枚举，抛出此异常
     */
    public static Month of(String name) throws IllegalArgumentException {
        Assert.notNull(name, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
        Month of = of(ArrayUtil.findIgnoreCase(ALIASES, name));
        if (null == of) {
            of = Month.valueOf(name.toUpperCase());
        }
        return of;
    }

    /**
     * {@link java.time.Month}转换为Month对象
     *
     * @param month {@link java.time.Month}
     * @return Month
     */
    public static Month of(java.time.Month month) {
        return of(month.ordinal());
    }

    /**
     * 获得指定月的最后一天
     *
     * @param month      月份，从0开始
     * @param isLeapYear 是否为闰年，闰年只对二月有影响
     * @return 最后一天，可能为28,29,30,31
     */
    public static int getLastDay(int month, boolean isLeapYear) {
        final Month of = of(month);
        Assert.notNull(of, "Invalid Month base 0: " + month);
        return of.getLastDay(isLeapYear);
    }

    /**
     * 获取{@link Calendar}中的对应值<br>
     * 此值从0开始，即0表示一月
     *
     * @return {@link Calendar}中的对应月份值，从0开始计数
     */
    public int getValue() {
        return this.value;
    }

    /**
     * 获取月份值，此值与{@link java.time.Month}对应<br>
     * 此值从1开始，即1表示一月
     *
     * @return 月份值，对应{@link java.time.Month}，从1开始计数
     */
    public int getValueBaseOne() {
        Assert.assertTrue(this == UNDECIMBER, "Unsupported UNDECIMBER Field");
        return getValue() + 1;
    }

    /**
     * 获取此月份最后一天的值，不支持的月份（例如UNDECIMBER）返回-1
     *
     * @param isLeapYear 是否闰年
     * @return 此月份最后一天的值
     */
    public int getLastDay(boolean isLeapYear) {
        return switch (this) {
            case FEBRUARY -> isLeapYear ? 29 : 28;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            default -> 31;
        };
    }

    /**
     * 转换为{@link java.time.Month}
     *
     * @return {@link java.time.Month}
     */
    public java.time.Month toJdkMonth() {
        return java.time.Month.of(getValueBaseOne());
    }

    /**
     * 获取显示名称
     *
     * @param style 名称风格
     * @return 显示名称
     */
    public String getDisplayName(TextStyle style) {
        return getDisplayName(style, Locale.getDefault());
    }

    /**
     * 获取显示名称
     *
     * @param style  名称风格
     * @param locale {@link Locale}
     * @return 显示名称
     */
    public String getDisplayName(TextStyle style, Locale locale) {
        return toJdkMonth().getDisplayName(style, locale);
    }
}
