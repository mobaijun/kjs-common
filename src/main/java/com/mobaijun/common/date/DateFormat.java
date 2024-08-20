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
package com.mobaijun.common.date;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: DateFormat<br>
 * class description: 日期格式化
 *
 * @author MoBaiJun 2022/11/23 13:45
 */
public final class DateFormat {

    /**
     * MM_US
     */
    public static final DateTimeFormatter MM_US = DateTimeFormatter.ofPattern("MM", Locale.US);

    /**
     * MMM_US
     */
    public static final DateTimeFormatter MMM_US = DateTimeFormatter.ofPattern("MMM", Locale.US);

    /**
     * MMMM_US
     */
    public static final DateTimeFormatter MMMM_US = DateTimeFormatter.ofPattern("MMMM", Locale.US);

    /**
     * MM_ZH_CN
     */
    public static final DateTimeFormatter MM_ZH_CN = DateTimeFormatter.ofPattern("MM", Locale.SIMPLIFIED_CHINESE);

    /**
     * MMM_ZH_CN
     */
    public static final DateTimeFormatter MMM_ZH_CN = DateTimeFormatter.ofPattern("MMM", Locale.SIMPLIFIED_CHINESE);

    /**
     * MMMM_ZH_CN
     */
    public static final DateTimeFormatter MMMM_ZH_CN = DateTimeFormatter.ofPattern("MMMM", Locale.SIMPLIFIED_CHINESE);

    /**
     * MM_ZH_TW
     */
    public static final DateTimeFormatter MM_ZH_TW = DateTimeFormatter.ofPattern("MM", Locale.TRADITIONAL_CHINESE);

    /**
     * MMM_ZH_TW
     */
    public static final DateTimeFormatter MMM_ZH_TW = DateTimeFormatter.ofPattern("MMM", Locale.TRADITIONAL_CHINESE);

    /**
     * MMMM_ZH_TW
     */
    public static final DateTimeFormatter MMMM_ZH_TW = DateTimeFormatter.ofPattern("MMMM", Locale.TRADITIONAL_CHINESE);

    // 时间格式
    /**
     * 时分秒，格式：HH:mm:ss
     */
    public static final DateTimeFormatter HH_MM_SS_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 时分，格式：HH:mm
     */
    public static final DateTimeFormatter HH_MM_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    // 日期格式
    /**
     * 年份，格式：yyyy
     */
    public static final DateTimeFormatter YYYY_FORMAT = DateTimeFormatter.ofPattern("yyyy");

    /**
     * 年月，格式：yyyy-MM
     */
    public static final DateTimeFormatter YYYY_MM_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM");

    /**
     * 年月日，格式：yyyy-MM-dd
     */
    public static final DateTimeFormatter YYYY_MM_DD_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 年月日（无分隔符），格式：yyyyMMdd
     */
    public static final DateTimeFormatter YYYYMMDD_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 年月日，格式：yyyy年MM月dd日
     */
    public static final DateTimeFormatter YYYY_MM_DD_CHINESE_FORMAT = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    // 日期时间格式
    /**
     * 年月日 时分秒，格式：yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 年月日 时分，格式：yyyy-MM-dd HH:mm
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * 年月日 时分秒（无分隔符），格式：yyyyMMddHHmmss
     */
    public static final DateTimeFormatter YYYYMMDD_HHMMSS_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * 年月日 时分，格式：yyyy年MM月dd日 HH:mm
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_CHINESE_FORMAT = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");

    /**
     * 年月日 时分秒，格式：yyyy年MM月dd日 HH:mm:ss
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS_CHINESE_FORMAT = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    // 其他常用格式
    /**
     * 年月日时分秒毫秒，格式：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS_SSS_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * 年月日时分秒毫秒（无分隔符），格式：yyyyMMddHHmmssSSS
     */
    public static final DateTimeFormatter YYYYMMDD_HHMMSS_SSS_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
}
