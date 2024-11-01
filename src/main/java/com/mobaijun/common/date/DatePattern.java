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

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: DatePattern<br>
 * class description: 日期格式
 *
 * @author MoBaiJun 2022/11/23 13:46
 */
public final class DatePattern {

    /**
     * 时分秒，格式：HH:mm:ss
     */
    public static final String HH_MM_SS = "HH:mm:ss";

    /**
     * 时分，格式：HH:mm
     */
    public static final String HH_MM = "HH:mm";

    /**
     * 年份，格式：yyyy
     */
    public static final String YYYY = "yyyy";

    /**
     * 年月日（无分隔符），格式：yyyyMMdd
     */
    public static final String YYYYMMDD = "yyyyMMdd";

    /**
     * 年月日，格式：yyyy年MM月dd日
     */
    public static final String YYYY_MM_DD_CHINESE = "yyyy年MM月dd日";

    /**
     * 年月日 时分，格式：yyyy-MM-dd HH:mm
     */
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * 年月日 时分秒（无分隔符），格式：yyyyMMddHHmmss
     */
    public static final String YYYYMMDD_HHMMSS = "yyyyMMddHHmmss";

    /**
     * 年月日 时分，格式：yyyy年MM月dd日 HH:mm
     */
    public static final String YYYY_MM_DD_HH_MM_CHINESE = "yyyy年MM月dd日 HH:mm";

    /**
     * 年月日 时分秒，格式：yyyy年MM月dd日 HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS_CHINESE = "yyyy年MM月dd日 HH:mm:ss";

    // 其他常用格式
    /**
     * 年月日时分秒毫秒，格式：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 年月日时分秒毫秒（无分隔符），格式：yyyyMMddHHmmssSSS
     */
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    /**
     * 日期格式：uuuu-MM-dd HH:mm:ss
     */
    public static final String UUUU_MM_DD_HH_MM_SS = "uuuu-MM-dd HH:mm:ss";

    /**
     * 日期格式：uuuu/MM/dd HH:mm:ss
     */
    public static final String UUUU_MM_DD_SLASH_HH_MM_SS = "uuuu/MM/dd HH:mm:ss";

    /**
     * 日期格式：uuuu.MM.dd HH:mm:ss
     */
    public static final String UUUU_MM_DD_DOT_HH_MM_SS = "uuuu.MM.dd HH:mm:ss";

    /**
     * 日期格式：uuuuMMddHHmmss
     */
    public static final String UUUUMMDDHHMMSS = "uuuuMMddHHmmss";

    /**
     * 日期格式：uuuu-MM-dd HH:mm
     */
    public static final String UUUU_MM_DD_HH_MM = "uuuu-MM-dd HH:mm";

    /**
     * 日期格式：uuuu/MM/dd HH:mm
     */
    public static final String UUUU_MM_DD_SLASH_HH_MM = "uuuu/MM/dd HH:mm";

    /**
     * 日期格式：uuuu.MM.dd HH:mm
     */
    public static final String UUUU_MM_DD_DOT_HH_MM = "uuuu.MM.dd HH:mm";

    /**
     * 日期格式：uuuu-MM-dd
     */
    public static final String UUUU_MM_DD = "uuuu-MM-dd";

    /**
     * 日期格式：uuuu/MM/dd
     */
    public static final String UUUU_MM_DD_SLASH = "uuuu/MM/dd";

    /**
     * 日期格式：uuuu.MM.dd
     */
    public static final String UUUU_MM_DD_DOT = "uuuu.MM.dd";

    /**
     * 日期格式：uuuu-MM
     */
    public static final String UUUU_MM = "uuuu-MM";

    /**
     * 日期格式：uuuu/MM
     */
    public static final String UUUU_MM_SLASH = "uuuu/MM";

    /**
     * 日期格式：uuuu.MM
     */
    public static final String UUUU_MM_DOT = "uuuu.MM";

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式：yyyy/MM/dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_SLASH_HH_MM_SS = "yyyy/MM/dd HH:mm:ss";

    /**
     * 日期格式：yyyy.MM.dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_DOT_HH_MM_SS = "yyyy.MM.dd HH:mm:ss";

    /**
     * 日期格式：yyyyMMddHHmmss
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 日期格式：yyyy/MM/dd HH:mm
     */
    public static final String YYYY_MM_DD_SLASH_HH_MM = "yyyy/MM/dd HH:mm";

    /**
     * 日期格式：yyyy.MM.dd HH:mm
     */
    public static final String YYYY_MM_DD_DOT_HH_MM = "yyyy.MM.dd HH:mm";

    /**
     * 按照 yyyy-MM-dd 格式的日期字符串常量
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 按照 yyyy/MM/dd 格式的日期字符串常量
     */
    public static final String YYYY_MM_DD_SLASH = "yyyy/MM/dd";

    /**
     * 按照 yyyy.MM.dd 格式的日期字符串常量
     */
    public static final String YYYY_MM_DD_DOT = "yyyy.MM.dd";

    /**
     * 按照 yyyy-MM 格式的日期字符串常量
     */
    public static final String YYYY_MM = "yyyy-MM";

    /**
     * 按照 yyyy/MM 格式的日期字符串常量
     */
    public static final String YYYY_MM_SLASH = "yyyy/MM";

    /**
     * 按照 yyyy.MM 格式的日期字符串常量
     */
    public static final String YYYY_MM_DOT = "yyyy.MM";

    /**
     * 按照 MM-dd HH:mm:ss 格式的日期字符串常量
     */
    public static final String MM_DD_HH_MM_SS = "MM-dd HH:mm:ss";

    /**
     * 按照 MM/dd HH:mm:ss 格式的日期字符串常量
     */
    public static final String MM_DD_SLASH_HH_MM_SS = "MM/dd HH:mm:ss";

    /**
     * 按照 MM.dd HH:mm:ss 格式的日期字符串常量
     */
    public static final String MM_DD_DOT_HH_MM_SS = "MM.dd HH:mm:ss";

    /**
     * 按照 MMddHHmmss 格式的日期字符串常量
     */
    public static final String MMDDHHMMSS = "MMddHHmmss";

    /**
     * 按照 MM-dd HH:mm 格式的日期字符串常量
     */
    public static final String MM_DD_HH_MM = "MM-dd HH:mm";

    /**
     * 按照 MM/dd HH:mm 格式的日期字符串常量
     */
    public static final String MM_DD_SLASH_HH_MM = "MM/dd HH:mm";

    /**
     * 按照 MM.dd HH:mm 格式的日期字符串常量
     */
    public static final String MM_DD_DOT_HH_MM = "MM.dd HH:mm";

    /**
     * 按照 MM-dd 格式的日期字符串常量
     */
    public static final String MM_DD = "MM-dd";

    /**
     * 按照 MM/dd 格式的日期字符串常量
     */
    public static final String MM_DD_SLASH = "MM/dd";

    /**
     * 按照 MM.dd 格式的日期字符串常量
     */
    public static final String MM_DD_DOT = "MM.dd";

    /**
     * ISO 8601 格式（基础格式），例如：2023-10-31T15:30:00Z
     */
    public static final String ISO_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    /**
     * ISO 8601 格式（包含毫秒），例如：2023-10-31T15:30:00.123Z
     */
    public static final String ISO_DATE_TIME_MILLIS = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /**
     * 带时区的日期格式，例如：2023-10-31T15:30:00+08:00
     */
    public static final String ISO_DATE_TIME_WITH_ZONE = "yyyy-MM-dd'T'HH:mm:ssXXX";

    /**
     * 带时区的日期格式（包含毫秒），例如：2023-10-31T15:30:00.123+08:00
     */
    public static final String ISO_DATE_TIME_WITH_ZONE_MILLIS = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

    /**
     * 年月（包含时区），例如：2023-10
     */
    public static final String YYYY_MM_WITH_ZONE = "yyyy-MM";

    /**
     * 年月日（包含时区），例如：2023-10-31
     */
    public static final String YYYY_MM_DD_WITH_ZONE = "yyyy-MM-dd";

    /**
     * 全写日期格式，格式：EEEE, MMMM dd, yyyy，例如：Tuesday, October 31, 2023
     */
    public static final String FULL_DATE = "EEEE, MMMM dd, yyyy";

    /**
     * 短日期格式，例如：10/31/23
     */
    public static final String SHORT_DATE = "MM/dd/yy";

    /**
     * 自定义日期时间格式，例如：dd-MMM-yyyy HH:mm:ss，例如：31-Oct-2023 15:30:00
     */
    public static final String CUSTOM_DATE_TIME = "dd-MMM-yyyy HH:mm:ss";

    /**
     * 年月日（短格式），例如：23/10/31
     */
    public static final String YY_MM_DD_SLASH = "yy/MM/dd";

    /**
     * 年月日（短格式），例如：23.10.31
     */
    public static final String YY_MM_DD_DOT = "yy.MM.dd";

    /**
     * 仅显示月份和年份，例如：October 2023
     */
    public static final String MONTH_YEAR = "MMMM yyyy";

    /**
     * 仅显示小时和分钟，例如：15:30
     */
    public static final String HH_MM_24 = "HH:mm";

    /**
     * 12小时制，格式：hh:mm a，例如：03:30 PM
     */
    public static final String HH_MM_12 = "hh:mm a";

    /**
     * 带秒的 12 小时制，格式：hh:mm:ss a，例如：03:30:00 PM
     */
    public static final String HH_MM_SS_12 = "hh:mm:ss a";

    /**
     * 年月日时分秒格式（短形式），例如：2023/10/31 15:30
     */
    public static final String YYYY_MM_DD_HH_MM_SHORT = "yyyy/MM/dd HH:mm";

    /**
     * 年月日时分秒格式（短形式），例如：2023.10.31 15:30
     */
    public static final String YYYY_MM_DD_HH_MM_DOT_SHORT = "yyyy.MM.dd HH:mm";

    /**
     * 自定义日期格式：yyyy年MM月dd日 HH:mm，例如：2023年10月31日 15:30
     */
    public static final String YYYY_MM_DD_HH_MM_CUSTOM = "yyyy年MM月dd日 HH:mm";

    /**
     * 年月日星期几，格式：yyyy-MM-dd EEEE，例如：2023-10-31 Tuesday
     */
    public static final String YYYY_MM_DD_DAY = "yyyy-MM-dd EEEE";

    /**
     * 时分秒（短），例如：15:30:00
     */
    public static final String HH_MM_SS_SHORT = "HH:mm:ss";

    /**
     * 年月（短格式），例如：2023/10
     */
    public static final String YYYY_MM_SHORT = "yyyy/MM";

    /**
     * 带秒的完整日期格式，格式：yyyy-MM-dd HH:mm:ss.SSS，例如：2023-10-31 15:30:00.123
     */
    public static final String YYYY_MM_DD_HH_MM_SS_SSS_FULL = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 年月（短格式），格式：yy/MM，例如：23/10
     */
    public static final String YY_MM_SLASH = "yy/MM";

    /**
     * 年月日（无分隔符，短格式），格式：yyMMdd，例如：231031
     */
    public static final String YYMMDD = "yyMMdd";

    /**
     * 年月（无分隔符），格式：yyyyMM，例如：202310
     */
    public static final String YYYYMM = "yyyyMM";

    /**
     * 年月（无分隔符，短格式），格式：yyMM，例如：2310
     */
    public static final String YYMM = "yyMM";

    /**
     * 年（两位），格式：yy，例如：23
     */
    public static final String YY = "yy";
}
