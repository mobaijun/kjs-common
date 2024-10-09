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
     * 月份格式，例：MM（美国）
     */
    public static final DateTimeFormatter MONTH_US = DateTimeFormatter.ofPattern("MM", Locale.US);

    /**
     * 短月份格式，例：MMM（美国）
     */
    public static final DateTimeFormatter SHORT_MONTH_US = DateTimeFormatter.ofPattern("MMM", Locale.US);

    /**
     * 完整月份格式，例：MMMM（美国）
     */
    public static final DateTimeFormatter FULL_MONTH_US = DateTimeFormatter.ofPattern("MMMM", Locale.US);

    /**
     * 月份格式，例：MM（简体中文）
     */
    public static final DateTimeFormatter MONTH_ZH_CN = DateTimeFormatter.ofPattern("MM", Locale.SIMPLIFIED_CHINESE);

    /**
     * 短月份格式，例：MMM（简体中文）
     */
    public static final DateTimeFormatter SHORT_MONTH_ZH_CN = DateTimeFormatter.ofPattern("MMM", Locale.SIMPLIFIED_CHINESE);

    /**
     * 完整月份格式，例：MMMM（简体中文）
     */
    public static final DateTimeFormatter FULL_MONTH_ZH_CN = DateTimeFormatter.ofPattern("MMMM", Locale.SIMPLIFIED_CHINESE);

    /**
     * 月份格式，例：MM（繁体中文）
     */
    public static final DateTimeFormatter MONTH_ZH_TW = DateTimeFormatter.ofPattern("MM", Locale.TRADITIONAL_CHINESE);

    /**
     * 短月份格式，例：MMM（繁体中文）
     */
    public static final DateTimeFormatter SHORT_MONTH_ZH_TW = DateTimeFormatter.ofPattern("MMM", Locale.TRADITIONAL_CHINESE);

    /**
     * 完整月份格式，例：MMMM（繁体中文）
     */
    public static final DateTimeFormatter FULL_MONTH_ZH_TW = DateTimeFormatter.ofPattern("MMMM", Locale.TRADITIONAL_CHINESE);

    /**
     * 时分秒格式，例：HH:mm:ss
     */
    public static final DateTimeFormatter TIME_HH_MM_SS = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 时分格式，例：HH:mm
     */
    public static final DateTimeFormatter TIME_HH_MM = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * 中文时分秒格式，例：HH时mm分ss秒
     */
    public static final DateTimeFormatter TIME_HH_MM_SS_CHINESE = DateTimeFormatter.ofPattern("HH时mm分ss秒");

    /**
     * 中文时分格式，例：HH时mm分
     */
    public static final DateTimeFormatter TIME_HH_MM_CHINESE = DateTimeFormatter.ofPattern("HH时mm分");

    /**
     * 时分秒毫秒格式，例：HH:mm:ss.SSS
     */
    public static final DateTimeFormatter TIME_HH_MM_SS_MILLIS = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    /**
     * 时分秒毫秒无分隔符格式，例：HHmmssSSS
     */
    public static final DateTimeFormatter TIME_HHMMSS_MILLIS = DateTimeFormatter.ofPattern("HHmmssSSS");

    /**
     * 年份格式，例：yyyy
     */
    public static final DateTimeFormatter YEAR = DateTimeFormatter.ofPattern("yyyy");

    /**
     * 年月格式，例：yyyy-MM
     */
    public static final DateTimeFormatter YEAR_MONTH = DateTimeFormatter.ofPattern("yyyy-MM");

    /**
     * 年月日格式，例：yyyy-MM-dd
     */
    public static final DateTimeFormatter YEAR_MONTH_DAY = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 年月日无分隔符格式，例：yyyyMMdd
     */
    public static final DateTimeFormatter YEAR_MONTH_DAY_COMPACT = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 中文年月日格式，例：yyyy年MM月dd日
     */
    public static final DateTimeFormatter YEAR_MONTH_DAY_CHINESE = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    /**
     * 中文年月格式，例：yyyy年MM月
     */
    public static final DateTimeFormatter YEAR_MONTH_CHINESE = DateTimeFormatter.ofPattern("yyyy年MM月");

    /**
     * 中文月日格式，例：MM月dd日
     */
    public static final DateTimeFormatter MONTH_DAY_CHINESE = DateTimeFormatter.ofPattern("MM月dd日");

    /**
     * 年月日 时分秒格式，例：yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter DATE_TIME_FULL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 年月日 时分格式，例：yyyy-MM-dd HH:mm
     */
    public static final DateTimeFormatter DATE_TIME_MINUTES = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * 年月日 时分秒无分隔符格式，例：yyyyMMddHHmmss
     */
    public static final DateTimeFormatter DATE_TIME_COMPACT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * 中文年月日 时分秒格式，例：yyyy年MM月dd日 HH:mm:ss
     */
    public static final DateTimeFormatter DATE_TIME_FULL_CHINESE = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    /**
     * 中文年月日 时分格式，例：yyyy年MM月dd日 HH:mm
     */
    public static final DateTimeFormatter DATE_TIME_MINUTES_CHINESE = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");

    /**
     * 中文年月日 时分秒完整格式，例：yyyy年MM月dd日 HH时mm分ss秒
     */
    public static final DateTimeFormatter DATE_TIME_FULL_WITH_CHINESE_UNITS = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");

    /**
     * 年月日 时分秒 毫秒格式，例：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final DateTimeFormatter DATE_TIME_MILLIS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * 年月日 时分秒 毫秒无分隔符格式，例：yyyyMMddHHmmssSSS
     */
    public static final DateTimeFormatter DATE_TIME_COMPACT_MILLIS = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    /**
     * 中文年月日 时分秒 毫秒格式，例：yyyy年MM月dd日 HH时mm分ss秒SSS毫秒
     */
    public static final DateTimeFormatter DATE_TIME_MILLIS_CHINESE = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒SSS毫秒");

    /**
     * 中文年月日 时分秒 毫秒无分隔符格式，例：yyyy年MM月dd日HH时mm分ss秒SSS毫秒
     */
    public static final DateTimeFormatter DATE_TIME_COMPACT_MILLIS_CHINESE = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒SSS毫秒");

    /**
     * 年月日 斜杠分隔格式，例：yyyy/MM/dd
     */
    public static final DateTimeFormatter DATE_SLASH = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /**
     * 日月年 斜杠分隔格式，例：dd/MM/yyyy
     */
    public static final DateTimeFormatter DATE_DD_SLASH_MM_SLASH_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * 月日年 斜杠分隔格式，例：MM/dd/yyyy
     */
    public static final DateTimeFormatter DATE_MM_SLASH_DD_SLASH_YYYY = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /**
     * 日月年 点分隔格式，例：dd.MM.yyyy
     */
    public static final DateTimeFormatter DATE_DOT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * ISO 8601 日期格式，例：yyyy-MM-dd'T'HH:mm:ss.SSSZ
     */
    public static final DateTimeFormatter ISO8601 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    /**
     * RFC 1123 日期格式，例：EEE, dd MMM yyyy HH:mm:ss z（美国）
     */
    public static final DateTimeFormatter RFC_1123 = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);

    /**
     * 常见日志日期格式，例：dd/MMM/yyyy:HH:mm:ss Z（美国）
     */
    public static final DateTimeFormatter LOG_COMMON = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.US);
    /**
     * 时分秒毫秒，格式：HH:mm:ss,SSS
     */
    public static final DateTimeFormatter TIME_WITH_COMMA = DateTimeFormatter.ofPattern("HH:mm:ss,SSS");

    /**
     * 时分秒，24小时制，格式：HH:mm:ss
     */
    public static final DateTimeFormatter TIME_24_HOUR = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 时分秒，12小时制，格式：hh:mm:ss a
     */
    public static final DateTimeFormatter TIME_12_HOUR = DateTimeFormatter.ofPattern("hh:mm:ss a");

    /**
     * 时分秒，带时区，格式：HH:mm:ss Z
     */
    public static final DateTimeFormatter TIME_WITH_TIMEZONE = DateTimeFormatter.ofPattern("HH:mm:ss Z");

    /**
     * 时分秒，带毫秒和时区，格式：HH:mm:ss.SSS Z
     */
    public static final DateTimeFormatter TIME_WITH_MILLIS_AND_TIMEZONE = DateTimeFormatter.ofPattern("HH:mm:ss.SSS Z");

    /**
     * 12小时制，时分秒，带AM/PM，格式：hh:mm:ss a z
     */
    public static final DateTimeFormatter TIME_12_HOUR_WITH_TIMEZONE = DateTimeFormatter.ofPattern("hh:mm:ss a z");

    /**
     * 年.月.日，格式：yyyy.MM.dd
     */
    public static final DateTimeFormatter DATE_DOT_FULL = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    /**
     * 年月（无日），格式：yyyyMM
     */
    public static final DateTimeFormatter DATE_YEAR_MONTH_COMPACT = DateTimeFormatter.ofPattern("yyyyMM");

    /**
     * 年月日时分秒带时区，格式：yyyy-MM-dd'T'HH:mm:ssZ
     */
    public static final DateTimeFormatter DATE_TIME_WITH_TIMEZONE = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    /**
     * 中文年月日 时分秒，带时区，格式：yyyy年MM月dd日 HH时mm分ss秒 Z
     */
    public static final DateTimeFormatter DATE_TIME_CHINESE_WITH_TIMEZONE = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒 Z");

    /**
     * 中文年月日 时分秒，带毫秒和时区，格式：yyyy年MM月dd日 HH时mm分ss秒SSS Z
     */
    public static final DateTimeFormatter DATE_TIME_CHINESE_WITH_MILLIS_AND_TIMEZONE = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒SSS Z");

    /**
     * ISO 8601 日期时间带毫秒格式，例：yyyy-MM-dd'T'HH:mm:ss.SSSXXX
     */
    public static final DateTimeFormatter ISO8601_WITH_MILLIS = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    /**
     * UTC 时间，格式：yyyy-MM-dd'T'HH:mm:ss'Z'
     */
    public static final DateTimeFormatter UTC_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    /**
     * 美式日期时间格式（月/日/年 时分秒），例：MM/dd/yyyy HH:mm:ss
     */
    public static final DateTimeFormatter US_DATE_TIME = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    /**
     * 英式日期时间格式（日/月/年 时分秒），例：dd/MM/yyyy HH:mm:ss
     */
    public static final DateTimeFormatter UK_DATE_TIME = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * 邮件头日期格式，例：EEE, dd MMM yyyy HH:mm:ss Z（美国）
     */
    public static final DateTimeFormatter EMAIL_DATE = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

    /**
     * 日志文件日期格式，例：yyyy_MM_dd_HH_mm_ss
     */
    public static final DateTimeFormatter LOG_FILE_FORMAT = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
}
