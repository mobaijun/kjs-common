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

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: LocalDateUtils<br>
 * class description： local date 日期工具类
 *
 * @author MoBaiJun 2022/10/28 8:42
 */
@Slf4j
public class LocalDateUtil {

    /**
     * 将 LocalDate 转换为 Date。
     *
     * @param localDate 要转换的 LocalDate
     * @return 转换后的 Date 对象
     */
    public static Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将 LocalDateTime 转换为 Date。
     *
     * @param localDateTime 要转换的 LocalDateTime
     * @return 转换后的 Date 对象
     */
    public static Date convertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将 LocalDate 转换为时间戳（毫秒）。
     *
     * @param localDate 要转换的 LocalDate
     * @return 转换后的时间戳（毫秒）
     */
    public static Long convertToTimestamp(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * 将 LocalDate 格式化为字符串。
     *
     * @param localDate 要格式化的 LocalDate
     * @param pattern   格式模式
     * @return 格式化后的字符串
     */
    public static String formatToString(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将 LocalDateTime 格式化为字符串。
     *
     * @param localDateTime 要格式化的 LocalDateTime
     * @param pattern       格式模式
     * @return 格式化后的字符串
     */
    public static String formatToString(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将 Date 转换为字符串。
     *
     * @param date    要转换的 Date
     * @param pattern 格式模式
     * @return 格式化后的字符串
     */
    public static String formatToString(Date date, String pattern) {
        if (date == null || pattern == null || pattern.isEmpty()) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 将字符串转换为 LocalDate，按照指定格式解析。
     *
     * @param time    要解析的时间字符串
     * @param pattern 格式模式
     * @return 解析后的 LocalDate
     */
    public static LocalDate parseToLocalDate(String time, String pattern) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将字符串转换为 LocalDateTime，按照指定格式解析。
     *
     * @param time    要解析的时间字符串
     * @param pattern 格式模式
     * @return 解析后的 LocalDateTime
     */
    public static LocalDateTime parseToLocalDateTime(String time, String pattern) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将 Date 转换为 LocalDate。
     * atZone() 方法返回在指定时区从此 Instant 生成的 ZonedDateTime。
     *
     * @param date 要转换的 Date 对象
     * @return 转换后的 LocalDate
     */
    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将 Date 转换为 LocalDateTime。
     * atZone() 方法返回在指定时区从此 Instant 生成的 ZonedDateTime。
     *
     * @param date 要转换的 Date 对象
     * @return 转换后的 LocalDateTime
     */
    public static LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 获取 LocalDateTime 的毫秒数。
     *
     * @param localDateTime 要获取毫秒数的 LocalDateTime
     * @return 对应的毫秒数，若为 null 则返回 null
     */
    public static Long getMilliseconds(LocalDateTime localDateTime) {
        if (Objects.isNull(localDateTime)) {
            return null;
        }
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取 LocalDate 的毫秒数。
     *
     * @param localDate 要获取毫秒数的 LocalDate
     * @return 对应的毫秒数，若为 null 则返回 null
     */
    public static Long getMilliseconds(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            return null;
        }
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将 Instant 转换为 LocalDateTime。
     *
     * @param instant 要转换的 Instant 对象
     * @return 转换后的 LocalDateTime
     */
    public static LocalDateTime convertToLocalDateTime(Instant instant) {
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将 Date 转换为 Instant。
     *
     * @param date 要转换的 Date 对象
     * @return 转换后的 Instant
     */
    public static Instant convertToInstant(Date date) {
        return date.toInstant();
    }

    /**
     * 获取 LocalDateTime 的秒数。
     *
     * @param localDateTime 要获取秒数的 LocalDateTime
     * @return 对应的秒数，若为 null 则返回 null
     */
    public static Long getSeconds(LocalDateTime localDateTime) {
        if (Objects.isNull(localDateTime)) {
            return null;
        }
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 将 LocalDateTime 格式化为指定格式的字符串。
     *
     * @param time    要格式化的 LocalDateTime
     * @param pattern 日期和时间格式模式
     * @return 格式化后的字符串
     */
    public static String format(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将时间戳（毫秒）格式化为字符串。
     * <br>
     * 提示：此方法不支持转换秒。
     *
     * @param timestamp 时间戳（毫秒）
     * @param pattern   日期和时间格式模式
     * @return 格式化后的时间字符串
     */
    public static String format(Long timestamp, String pattern) {
        return new SimpleDateFormat(pattern).format(new Date(timestamp));
    }

    /**
     * 将 Instant 格式化为指定格式的字符串。
     *
     * @param instant 要格式化的 Instant
     * @param pattern 日期和时间格式模式
     * @return 格式化后的字符串
     */
    public static String format(Instant instant, String pattern) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取指定年份的第一天的字符串表示（格式：yyyy-MM-dd）。
     *
     * @param yearsToSubtract 年偏移量（负数表示之前的年份）
     * @return 指定年份第一天的字符串
     */
    public static String getFirstDayOfYear(int yearsToSubtract) {
        return LocalDate.now().minusYears(yearsToSubtract).with(TemporalAdjusters.firstDayOfYear()).toString();
    }

    /**
     * 获取指定某年某月的第一天的字符串表示（格式：yyyy-MM-dd）。
     *
     * @param yearsToSubtract  年偏移量（负数表示之前的年份）
     * @param monthsToSubtract 月偏移量（负数表示之前的月份）
     * @return 指定某年某月第一天的字符串
     */
    public static String getFirstDayOfMonth(int yearsToSubtract, int monthsToSubtract) {
        return LocalDate.now().minusYears(yearsToSubtract).minusMonths(monthsToSubtract).with(TemporalAdjusters.firstDayOfMonth()).toString();
    }

    /**
     * 计算两个 LocalDateTime 之间的毫秒数。
     *
     * @param time1 第一个 LocalDateTime
     * @param time2 第二个 LocalDateTime
     * @return 两个时间之间的毫秒数
     */
    public static Long calculateMillisBetween(LocalDateTime time1, LocalDateTime time2) {
        return Duration.between(time1, time2).toMillis();
    }

    /**
     * 计算两个 LocalTime 之间的毫秒数。
     *
     * @param time1 第一个 LocalTime
     * @param time2 第二个 LocalTime
     * @return 两个时间之间的毫秒数
     */
    public static Long calculateMillisBetween(LocalTime time1, LocalTime time2) {
        return Duration.between(time1, time2).toMillis();
    }

    /**
     * 计算两个 LocalDate 之间的月份数。
     *
     * @param date1 第一个 LocalDate
     * @param date2 第二个 LocalDate
     * @return 两个日期之间的月份数
     */
    public static Long calculateMonthsBetween(LocalDate date1, LocalDate date2) {
        return Period.between(date1, date2).toTotalMonths();
    }

    /**
     * 计算两个 LocalDate 之间的 Period。
     *
     * @param date1 第一个 LocalDate
     * @param date2 第二个 LocalDate
     * @return 两个日期之间的 Period
     */
    public static Period calculatePeriodBetween(LocalDate date1, LocalDate date2) {
        return Period.between(date1, date2);
    }

    /**
     * 将格式为 {@code "yyyy-MM-dd"} 的日期字符串转换为 Instant。
     *
     * @param source 日期字符串，例如 {@code "2022-11-09"}
     * @return 对应的 Instant
     */
    public static Instant parseInstantFromDateString(String source) {
        return LocalDate.parse(source).atStartOfDay(ZoneId.systemDefault()).toInstant();
    }

    /**
     * 将时间字符串转换为 Instant。
     *
     * @param source  时间字符串
     * @param pattern 格式模式
     * @return 对应的 Instant
     */
    public static Instant parseInstantFromString(String source, String pattern) {
        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(pattern)).atZone(ZoneId.systemDefault()).toInstant();
    }

    /**
     * 比较两个时间，判断 {@code before < after} 是否成立。
     * <br>
     * 如果 {@code before} 小于 {@code after}，返回 {@code true}，否则返回 {@code false}。
     *
     * @param before 较小的时间
     * @param after  较大的时间
     * @return {@code before < after} 是否成立
     */
    public static Boolean isBefore(LocalDateTime before, LocalDateTime after) {
        return before.isBefore(after);
    }

    /**
     * 计算两个 Date 之间的 Period。
     *
     * @param date1 第一个 Date
     * @param date2 第二个 Date
     * @return 两个日期之间的 Period
     */
    public static Period periodBetweenDates(Date date1, Date date2) {
        return calculatePeriodBetween(convertToLocalDate(date1), convertToLocalDate(date2));
    }

    /**
     * 将时间戳（毫秒）转换为 LocalDateTime。
     *
     * @param timestamp 时间戳（毫秒）
     * @return 对应的 LocalDateTime，若时间戳为 null，则返回 null
     */
    public static LocalDateTime toLocalDateTime(Long timestamp) {
        if (Objects.isNull(timestamp)) {
            return null;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }

    /**
     * 获取服务器的启动时间。
     *
     * @return 服务器启动时间的 LocalDateTime
     */
    public static LocalDateTime getServerStartDate() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(ManagementFactory.getRuntimeMXBean().getStartTime()), ZoneId.systemDefault());
    }

    /**
     * 获取指定 LocalDateTime 的秒数。
     *
     * @param time 要获取秒数的 LocalDateTime
     * @return 该时间的秒数
     */
    public static Long getSecondValue(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取当前时间的指定格式字符串。
     *
     * @param pattern 日期和时间格式模式
     * @return 当前时间的格式化字符串
     */
    public static String formatNow(String pattern) {
        return format(LocalDateTime.now(), pattern);
    }

    /**
     * 将指定的时间加上指定的数值，依据给定的时间单位。
     *
     * @param time   要加的 LocalDateTime
     * @param number 要加的数值
     * @param field  时间单位（如 ChronoUnit.DAYS、ChronoUnit.HOURS 等）
     * @return 加法后的 LocalDateTime
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 将指定的时间减去指定的数值，依据给定的时间单位。
     *
     * @param time   要减的 LocalDateTime
     * @param number 要减的数值
     * @param field  时间单位（如 ChronoUnit.DAYS、ChronoUnit.HOURS 等）
     * @return 减法后的 LocalDateTime
     */
    public static LocalDateTime minus(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取两个 LocalDateTime 之间的差值，依据给定的时间单位。
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param field     时间单位（如 ChronoUnit.YEARS、ChronoUnit.MONTHS 等）
     * @return 两个时间之间的差值
     */
    public static long betweenTwoTimes(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12L + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 获取一天的开始时间（00:00）。
     *
     * @param time 指定的 LocalDateTime
     * @return 当天的开始时间
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.toLocalDate().atStartOfDay();
    }

    /**
     * 获取一天的结束时间（23:59:59.999999999）。
     *
     * @param time 指定的 LocalDateTime
     * @return 当天的结束时间
     */
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

    /**
     * 获取指定日期所在周的第一天（周一）。
     *
     * @param localDate 指定的 LocalDate
     * @return 当周的第一天（周一）
     */
    public static LocalDate firstDayOfWeek(LocalDate localDate) {
        return localDate.with(DayOfWeek.MONDAY);
    }

    /**
     * 获取指定日期所在周的最后一天（周日）。
     *
     * @param localDate 指定的 LocalDate
     * @return 当周的最后一天（周日）
     */
    public static LocalDate lastDayOfWeek(LocalDate localDate) {
        return localDate.with(DayOfWeek.SUNDAY);
    }

    /**
     * 获取指定日期所在月的第一天。
     *
     * @param localDate 指定的 LocalDate
     * @return 当月的第一天
     */
    public static LocalDate firstDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取指定日期所在月的最后一天。
     *
     * @param localDate 指定的 LocalDate
     * @return 当月的最后一天
     */
    public static LocalDate lastDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取指定日期所在年的第一天。
     *
     * @param localDate 指定的 LocalDate
     * @return 当年的第一天
     */
    public static LocalDate firstDayOfYear(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfYear());
    }

    /**
     * 获取指定日期所在年的最后一天。
     *
     * @param localDate 指定的 LocalDate
     * @return 当年的最后一天
     */
    public static LocalDate lastDayOfYear(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastDayOfYear());
    }

    /**
     * 获取指定日期所在周的所有日期（周一到周日）。
     *
     * @param localDate 指定的 LocalDate
     * @return 包含当周所有日期的列表
     */
    public static List<LocalDate> allDaysOfWeek(LocalDate localDate) {
        List<LocalDate> allDays = new ArrayList<>();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            allDays.add(localDate.with(dayOfWeek));
        }
        return allDays;
    }

    /**
     * 获取指定日期所在月的所有日期。
     *
     * @param localDate 指定的 LocalDate
     * @return 包含当月所有日期的列表
     */
    public static List<LocalDate> allDaysOfMonth(LocalDate localDate) {
        List<LocalDate> allDays = new ArrayList<>();
        LocalDate firstDayOfMonth = firstDayOfMonth(localDate);
        LocalDate lastDayOfMonth = lastDayOfMonth(localDate);

        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            allDays.add(date);
        }
        return allDays;
    }

    /**
     * 计算两个时间的差值。
     *
     * @param endDate 结束时间
     * @param nowDate 开始时间
     * @return 时间差（天、小时、分钟）
     */
    public static String getDateDifference(Date endDate, Date nowDate) {
        long millisecondsInDay = 1000 * 60 * 60 * 24;
        long millisecondsInHour = 1000 * 60 * 60;
        long millisecondsInMinute = 1000 * 60;

        // 计算时间差（毫秒）
        long diff = endDate.getTime() - nowDate.getTime();

        // 计算差值
        long days = diff / millisecondsInDay;
        long hours = (diff % millisecondsInDay) / millisecondsInHour;
        long minutes = (diff % millisecondsInDay % millisecondsInHour) / millisecondsInMinute;

        return days + "天" + hours + "小时" + minutes + "分钟";
    }

    /**
     * 检查指定年份是否为闰年。
     *
     * @param year 年份
     * @return true 如果是闰年；false 否则
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 检查指定日期是否为闰年。
     *
     * @param date 日期
     * @return true 如果是闰年；false 否则
     */
    public static boolean isLeapYear(Date date) {
        int year = Integer.parseInt(String.format("%tY", date));
        return isLeapYear(year);
    }

    /**
     * 将时间戳转换为格式化的日期字符串（yyyy-MM-dd HH:mm:ss）。
     *
     * @param time 时间戳（毫秒）
     * @return 格式化的日期字符串
     */
    public static String longToString(Long time) {
        if (time == null) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.YYYY_MM_DD_HH_MM_SS);
        return sdf.format(new Date(time));
    }

    /**
     * 获取指定日期所在月的开始时间（00:00）。
     *
     * @param localDate 指定日期
     * @return 当前月的开始时间
     */
    public static LocalDateTime getStartOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay();
    }

    /**
     * 判断指定时间是否在给定的时间区间内（不包含边界）。
     *
     * @param time      检测时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return true 如果在区间内；false 否则
     */
    public static boolean isWithinTimeRange(LocalTime time, LocalTime startTime, LocalTime endTime) {
        if (endTime.isAfter(startTime)) {
            return time.isAfter(startTime) && time.isBefore(endTime);
        }
        return time.isAfter(startTime) || time.isBefore(endTime);
    }

    /**
     * 判断指定时间是否在给定的时间区间内（包含边界）。
     *
     * @param time      检测时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return true 如果在区间内；false 否则
     */
    public static boolean isWithinTimeRangeInclusive(LocalTime time, LocalTime startTime, LocalTime endTime) {
        if (endTime.isAfter(startTime)) {
            return !time.isBefore(startTime) && !time.isAfter(endTime);
        }
        return !time.isBefore(startTime) || !time.isAfter(endTime);
    }

    /**
     * 获取当前年份。
     *
     * @return 当前年份
     */
    public static int currentYear() {
        return getYear(0);
    }

    /**
     * 获取当前月份。
     *
     * @return 当前月份
     */
    public static int currentMonth() {
        return getMonth(0);
    }

    /**
     * 获取当前日期。
     *
     * @return 当前日期
     */
    public static int currentDay() {
        return getDayOfYear(0);
    }

    /**
     * 获取指定年份（偏移量）。
     *
     * @param offset 偏移量
     * @return 年份
     */
    public static int getYear(int offset) {
        return LocalDate.now().minusYears(offset).getYear();
    }

    /**
     * 获取指定月份（偏移量）。
     *
     * @param offset 偏移量
     * @return 月份
     */
    public static int getMonth(int offset) {
        return LocalDate.now().minusMonths(offset).getMonthValue();
    }

    /**
     * 获取一年中的某天（偏移量）。
     *
     * @param offset 偏移量
     * @return 一年中的第几天
     */
    public static int getDayOfYear(int offset) {
        return LocalDate.now().minusWeeks(offset).getDayOfYear();
    }

    /**
     * 获取格式化的年月字符串（yyyy-MM）。
     *
     * @param offset  偏移量
     * @param pattern 格式
     * @return 格式化的年月字符串
     */
    public static String getFormattedYearMonth(int offset, String pattern) {
        return LocalDate.now().minusMonths(offset).format(DateTimeFormatter.ofPattern(pattern));
    }
}
