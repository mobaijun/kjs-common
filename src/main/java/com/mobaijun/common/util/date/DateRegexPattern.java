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
package com.mobaijun.common.util.date;

import java.util.regex.Pattern;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: DateRegexPattern<br>
 * class description: 时间正则表达式
 *
 * @author MoBaiJun 2022/11/23 13:47
 */
public final class DateRegexPattern {

    /**
     * WEEK_OF_MONTH
     */
    public static final Pattern WEEK_OF_MONTH = Pattern.compile("(?<![W])W(?![W])");

    /**
     * WEEK_OF_MONTH2
     */
    public static final Pattern WEEK_OF_MONTH2 = Pattern.compile("(?<![W])[W]{2}(?![W])");

    /**
     * DAY_OF_MONTH
     */
    public static final Pattern DAY_OF_MONTH = Pattern.compile("(?<![d])d(?![d])");

    /**
     * DAY_OF_MONTH2
     */
    public static final Pattern DAY_OF_MONTH2 = Pattern.compile("(?<![d])[d]{2}(?![d])");

    /**
     * HOUR_OF_DAY
     */
    public static final Pattern HOUR_OF_DAY = Pattern.compile("(?<![H])H(?![H])");

    /**
     * HOUR_OF_DAY2
     */
    public static final Pattern HOUR_OF_DAY2 = Pattern.compile("(?<![H])[H]{2}(?![H])");

    /**
     * CLOCK_HOUR_OF_AM_PM12
     */
    public static final Pattern CLOCK_HOUR_OF_AM_PM12 = Pattern.compile("(?<![h])h(?![h])");

    /**
     * CLOCK_HOUR_OF_AM_PM12_2
     */
    public static final Pattern CLOCK_HOUR_OF_AM_PM12_2 = Pattern.compile("(?<![h])[h]{2}(?![h])");

    /**
     * HOUR_OF_AM_PM
     */
    public static final Pattern HOUR_OF_AM_PM = Pattern.compile("(?<![K])K(?![K])");

    /**
     * HOUR_OF_AM_PM2
     */
    public static final Pattern HOUR_OF_AM_PM2 = Pattern.compile("(?<![K])[K]{2}(?![K])");

    /**
     * CLOCK_HOUR_OF_AM_PM24
     */
    public static final Pattern CLOCK_HOUR_OF_AM_PM24 = Pattern.compile("(?<![k])k(?![k])");

    /**
     * CLOCK_HOUR_OF_AM_PM24_2
     */
    public static final Pattern CLOCK_HOUR_OF_AM_PM24_2 = Pattern.compile("(?<![k])[k]{2}(?![k])");

    /**
     * MINUTE_OF_HOUR
     */
    public static final Pattern MINUTE_OF_HOUR = Pattern.compile("(?<![m])m(?![m])");

    /**
     * MINUTE_OF_HOUR2
     */
    public static final Pattern MINUTE_OF_HOUR2 = Pattern.compile("(?<![m])[m]{2}(?![m])");

    /**
     * SECOND_OF_MINUTE
     */
    public static final Pattern SECOND_OF_MINUTE = Pattern.compile("(?<![s])s(?![s])");

    /**
     * SECOND_OF_MINUTE2
     */
    public static final Pattern SECOND_OF_MINUTE2 = Pattern.compile("(?<![s])[s]{2}(?![s])");

    /**
     * FRACTION_OF_SECOND3
     */
    public static final Pattern FRACTION_OF_SECOND3 = Pattern.compile("(?<![S])[S]{3}(?![S])");
}
