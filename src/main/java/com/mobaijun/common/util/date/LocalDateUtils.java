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
package com.mobaijun.common.util.date;

import com.mobaijun.common.constant.DateConstant;

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

/**
 * software：IntelliJ IDEA 2022.1
 * class name: LocalDateUtils
 * class description： local date 日期工具类
 *
 * @author MoBaiJun 2022/10/28 8:42
 */
public class LocalDateUtils {


    /**
     * local date 转 date
     *
     * @param date LocalDate
     * @return date
     */
    public static Date toDate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将 LocalDateTime 转换成 Date
     *
     * @param dateTime LocalDateTime
     * @return Date
     */
    public static Date toDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * local date to timestamp
     *
     * @param date LocalDate
     * @return long
     */
    public static Long toTimestamp(LocalDate date) {
        return date.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * 将 localDate 按照一定的格式转换成 String
     *
     * @param localDate localDate
     * @param pattern   pattern
     * @return String
     */
    public static String toString(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将 localDateTime 按照一定的格式转换成String
     *
     * @param localDateTime localDateTime
     * @param pattern       pattern
     * @return String
     */
    public static String toString(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将date转换成String
     *
     * @param date    date
     * @param pattern pattern
     * @return String
     */
    public static String toString(Date date, String pattern) {
        return LocalDateUtils.toString(toLocalDateTime(date), pattern);
    }

    /**
     * 将 String 按照 pattern 转换成 LocalDate
     *
     * @param time    time
     * @param pattern pattern
     * @return LocalDate
     */
    public static LocalDate toLocalDate(String time, String pattern) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将 String 按照 pattern 转换成 LocalDateTime
     *
     * @param time    time
     * @param pattern pattern
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(String time, String pattern) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将 Date 转换成 LocalDate
     * atZone()方法返回在指定时区从此 Instant生成的 ZonedDateTime。
     *
     * @param date date
     * @return LocalDate
     */
    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将 Date 转换成LocalDateTime
     * atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
     *
     * @param date date
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    /**
     * 获取 LocalDateTime的毫秒数
     *
     * @param localDateTime 时间 LocalDateTime
     * @return 毫秒数
     */
    public static Long toMillisecond(LocalDateTime localDateTime) {
        if (Objects.isNull(localDateTime)) {
            return null;
        }
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取 LocalDate 的毫秒数
     *
     * @param localDate 时间 LocalDate
     * @return 毫秒数
     */
    public static Long toMillisecond(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            return null;
        }
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将 Instant 转换成 LocalDateTime
     *
     * @param instant Instant
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Instant instant) {
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将 Date 转换成 Instant
     *
     * @param date Date
     * @return Instant
     */
    public static Instant toInstant(Date date) {
        return date.toInstant();
    }

    /**
     * 获取 LocalDateTime的秒数
     *
     * @param localDateTime 时间 LocalDateTime
     * @return 时间戳（秒数）
     */
    public static Long toSecond(LocalDateTime localDateTime) {
        if (Objects.isNull(localDateTime)) {
            return null;
        }
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取指定时间的指定格式
     *
     * @param time    time
     * @param pattern pattern
     * @return String
     */
    public static String toFormat(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将时间格式化成字符串
     * <p>
     * 提示：不能转换秒
     * </p>
     *
     * @param timestamp 时间戳（毫秒）
     * @param pattern   描述日期和时间格式的模式
     * @return 满足指定格式的时间字符串
     */
    public static String format(Long timestamp, String pattern) {
        return new SimpleDateFormat(pattern).format(timestamp);
    }

    /**
     * 将时间格式化成字符串
     *
     * @param instant 时间点（Instant）
     * @param pattern 描述日期和时间格式的模式
     * @return 满足指定格式的时间字符串
     */
    public static String format(Instant instant, String pattern) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取指定年的第一天
     *
     * @param minus 年偏移量
     * @return 时间 yyyy-MM-dd
     */
    public static String getFirstDayOfYear(int minus) {
        return LocalDate.now().minusYears(minus).with(TemporalAdjusters.firstDayOfYear()).toString();
    }

    /**
     * 获取指定某年的某月的第一天
     *
     * @param minusYear 年偏移量
     *                  minusMonth:月偏移量
     * @return 时间 yyyy-MM-dd
     */
    public static String getFirstDayOfMonthMinYear(int minusYear, int minusMonth) {
        return LocalDate.now().minusYears(minusYear).minusMonths(minusMonth).with(TemporalAdjusters.firstDayOfMonth()).toString();
    }

    /**
     * 计算两个LocalDateTime 之间的毫秒数
     *
     * @param time1 time1
     * @param time2 time2
     * @return Long
     */
    public static Long minusToMillsLocalDateTime(LocalDateTime time1, LocalDateTime time2) {
        return Duration.between(time1, time2).toMillis();
    }

    /**
     * 计算两个LocalTime 之间的毫秒数
     *
     * @param time1 time1
     * @param time2 time2
     * @return Long
     */
    public static Long minusToMillsLocalTime(LocalTime time1, LocalTime time2) {
        return Duration.between(time1, time2).toMillis();
    }

    /**
     * 计算两个 LocalDate 之间的月份
     *
     * @param time1 time1
     * @param time2 time2
     * @return Long
     */
    public static Long minusToMillsLocalDate(LocalDate time1, LocalDate time2) {
        return Period.between(time1, time2).toTotalMonths();
    }

    /**
     * 计算两个LocalDate 之间的Period
     *
     * @param time1 time1
     * @param time2 time2
     * @return Period
     */
    public static Period periodLocalDate(LocalDate time1, LocalDate time2) {
        return Period.between(time1, time2);
    }

    /**
     * 将日期字符串(形如 {@code 2022-11-09} )转为 Instant，结果：{@code 2022-11-09T16:00:00Z}
     *
     * @param source 日期字符串，如 {@code 2022-11-09}
     * @return Instant {@code 2022-11-08T16:00:00Z}
     */
    public static Instant parseInstant(String source) {
        return LocalDate.parse(source)
                .atStartOfDay(ZoneId.systemDefault()).toInstant();
    }

    /**
     * 将 时间字符串 转为 Instant
     *
     * @param source  时间字符串
     * @param pattern 格式
     * @return Instant
     */
    public static Instant parseInstant(String source, String pattern) {
        return LocalDateTime.parse(source,
                        DateTimeFormatter.ofPattern(pattern))
                .atZone(ZoneOffset.systemDefault()).toInstant();
    }

    /**
     * 比较两个时间大小，简言之，{@code before < after} 是否成立
     * <p>
     * 假定有两个时间，before和after，如果before小于after，返回 {@code true }，
     * 反之，返回 {@code false}
     * </p>
     *
     * @param before 小的是
     * @param after  大的时间
     * @return {@code before < after} 是否成立
     */
    public static Boolean isBefore(LocalDateTime before, LocalDateTime after) {
        return before.isBefore(after);
    }

    /**
     * 计算两个Date 之间的Period
     *
     * @param date1 date1
     * @param date2 date2
     * @return Period
     */
    public static Period periodDate(Date date1, Date date2) {
        return periodLocalDate(toLocalDate(date1), toLocalDate(date2));
    }


    /**
     * 时间戳（毫秒）转为 LocalDateTime
     *
     * @param timestamp 时间戳（毫秒）
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Long timestamp) {
        if (Objects.isNull(timestamp)) {
            return null;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }

    /**
     * 获取服务器启动时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getServerStartDate() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(
                ManagementFactory.getRuntimeMXBean().getStartTime()), ZoneId.systemDefault());
    }

    /**
     * 获取指定日期的秒
     *
     * @param time time
     * @return Long
     */
    public static Long getSecondValue(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取当前时间的指定格式
     *
     * @param pattern pattern
     * @return String
     */
    public static String formatNow(String pattern) {
        return toFormat(LocalDateTime.now(), pattern);
    }

    /**
     * 日期加上一个数,根据field不同加不同值,field 为 ChronosUnit.*
     *
     * @param time   LocalDateTime
     * @param number long
     * @param field  TemporalUnit
     * @return LocalDateTime
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 日期减去一个数,根据field不同减不同值,field参数为ChronosUnit.*
     *
     * @param time   LocalDateTime
     * @param number long
     * @param field  TemporalUnit
     * @return LocalDateTime
     */
    public static LocalDateTime minus(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差  field参数为ChronosUnit.*
     *
     * @param startTime LocalDateTime
     * @param endTime   LocalDateTime
     * @param field     ChronosUnit 单位(年月日时分秒)
     * @return long
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
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
     * 获取一天的开始时间，2017,7,22 00:00
     *
     * @param time LocalDateTime
     * @return LocalDateTime
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 获取一天的结束时间，2017,7,22 23:59:59.999999999
     *
     * @param time LocalDateTime
     * @return LocalDateTime
     */
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

    /**
     * 一周的第一天
     *
     * @param localDate 当地日期
     * @return LocalDate
     */
    public static LocalDate firstDayOfWeek(LocalDate localDate) {
        return localDate.with(DayOfWeek.MONDAY);
    }

    /**
     * 一周的最后一天
     *
     * @param localDate 当地日期
     * @return LocalDate
     */
    public static LocalDate lastDayOfWeek(LocalDate localDate) {
        return localDate.with(DayOfWeek.SUNDAY);
    }

    /**
     * 月的第一天
     *
     * @param localDate 当地日期
     * @return LocalDate
     */
    public static LocalDate firstDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 月的最后一天
     *
     * @param localDate 当地日期
     * @return LocalDate
     */
    public static LocalDate lastDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 每年的第一天
     *
     * @param localDate 当地日期
     * @return LocalDate
     */
    public static LocalDate firstDayOfYear(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfYear());
    }

    /**
     * 每年的最后一天
     *
     * @param localDate 当地日期
     * @return LocalDate
     */
    public static LocalDate lastDayOfYear(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastDayOfYear());
    }

    /**
     * 每周的所有日期  即周一到周日
     *
     * @param localDate 当地日期
     * @return List<LocalDate>
     */
    public static List<LocalDate> allDaysOfWeek(LocalDate localDate) {
        List<LocalDate> allDays = new ArrayList<>();
        allDays.add(localDate.with(DayOfWeek.MONDAY));
        allDays.add(localDate.with(DayOfWeek.TUESDAY));
        allDays.add(localDate.with(DayOfWeek.WEDNESDAY));
        allDays.add(localDate.with(DayOfWeek.THURSDAY));
        allDays.add(localDate.with(DayOfWeek.FRIDAY));
        allDays.add(localDate.with(DayOfWeek.SATURDAY));
        allDays.add(localDate.with(DayOfWeek.SUNDAY));
        return allDays;
    }

    /**
     * 每月的所有日期  即1日到31日
     *
     * @param localDate 当地日期
     * @return List<LocalDate>
     */
    public static List<LocalDate> allDaysOfMonth(LocalDate localDate) {
        List<LocalDate> allDays = new ArrayList<>();
        LocalDate firstDayOfMonth = firstDayOfMonth(localDate);
        LocalDate lastDayOfMonth = lastDayOfMonth(localDate);
        allDays.add(firstDayOfMonth);
        int i = 1;
        LocalDate temp = firstDayOfMonth;
        while (!temp.isEqual(lastDayOfMonth)) {
            LocalDate day = firstDayOfMonth.plusDays(i);
            allDays.add(day);
            temp = day;
            i++;
        }
        return allDays;
    }

    /**
     * 计算两个时间差
     *
     * @param endDate 结束时间
     * @param nowDate 开始时间
     * @return 时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 检查是否闰年
     *
     * @param year 年份
     * @return boolean
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * 检查是否闰年
     *
     * @param date 日期
     * @return boolean
     */
    public static boolean isLeapYearDate(Date date) {
        int year = Integer.parseInt(String.format("%tY", date));
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * long 转 （yyyy-MM-dd HH:mm:ss）字符串日期格式
     *
     * @param time 时间
     * @return 时间字符串
     */
    public static String longToString(Long time) {
        // 要转换的时间格式
        SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.YYYY_MM_DD_HH_MM_SS);
        try {
            Date date = sdf.parse(sdf.format(time));
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取当前月的开始时间
     *
     * @param localDate 当前日期
     * @return 当前月的开始时间
     */
    public static LocalDateTime getStartOfMonth(LocalDate localDate) {
        LocalDateTime nowDateTime = localDate.atStartOfDay();
        return nowDateTime
                .with(TemporalAdjusters.firstDayOfMonth())
                .with(LocalTime.MIN);
    }

    /**
     * 判断是否在指定时间区间内
     *
     * @param time      检测时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return true-在区间内；false-不在区间内
     * @since 2.2.1
     */
    public static boolean judgeInTimeDuration(LocalTime time, LocalTime startTime, LocalTime endTime) {
        if (endTime.isAfter(startTime)) {
            return time.isAfter(startTime) && time.isBefore(endTime);
        }
        return time.isAfter(startTime) || time.isBefore(endTime);
    }

    /**
     * 判断是否在指定时间区间内，含边界
     *
     * @param time      检测时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return true-在区间内；false-不在区间内
     * @since 2.2.1
     */
    public static boolean judgeInTimeDurationWithBoundary(LocalTime time, LocalTime startTime, LocalTime endTime) {
        if (endTime.isAfter(startTime)) {
            return time.compareTo(startTime) >= 0 && time.compareTo(endTime) <= 0;
        }
        return time.compareTo(startTime) >= 0 || time.compareTo(endTime) <= 0;
    }

    /**
     * 获取当前年
     *
     * @return yyyy
     */
    public static int curYear() {
        return getYear(0);
    }

    /**
     * 获取指定年份
     *
     * @param minus 偏移量
     * @return 年
     */
    public static int getYear(int minus) {
        return LocalDate.now().minusYears(minus).getYear();
    }

    /**
     * 获取月；格式 yyyy-MM
     *
     * @param minus   前几个月
     * @param pattern 格
     * @return 格式化月份
     */
    public static String getYearOfMonth(int minus, String pattern) {
        LocalDate localDate = LocalDate.now().minusMonths(1);
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }
}
