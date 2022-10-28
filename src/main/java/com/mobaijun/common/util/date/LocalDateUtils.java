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

import java.lang.management.ManagementFactory;
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
     * @param date localdate
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
     * @param date localdate
     * @return long
     */
    public static Long toTimestamp(LocalDate date) {
        return date.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * 获取指定月份
     *
     * @param minus 偏移量
     * @return 月
     */
    public static int getMinusMonth(int minus) {
        return LocalDate.now().minusMonths(minus).getMonthValue();
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
     * 将 localDate 按照一定的格式转换成 String
     *
     * @param localDate localDate
     * @param pattern   pattern
     * @return String
     */
    public static String toSrting(LocalDate localDate, String pattern) {
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
    public static String toSrting(Date date, String pattern) {
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
     * 计算两个LocalDate 之间的毫秒数
     *
     * @param time1 time1
     * @param time2 time2
     * @return Long
     */
    public static Long minusToMillsLocalDate(LocalDate time1, LocalDate time2) {
        return Duration.between(time1, time2).toMillis();
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
     * 计算两个Date之间的 Period
     *
     * @param time1 time1
     * @param time2 time2
     * @return Long
     */
    public static Long minusToMillsDate(Date time1, Date time2) {
        return minusToMillsLocalDateTime(toLocalDateTime(time1), toLocalDateTime(time2));
    }

    /**
     * 获取服务器启动时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getServerStartDate() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(ManagementFactory.getRuntimeMXBean().getStartTime()), ZoneId.systemDefault());
    }

    /**
     * 获取指定日期的毫秒
     *
     * @param time time
     * @return Long
     */
    public static Long getMillisecondValue(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
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
     * 获取当前时间的指定格式
     *
     * @param pattern pattern
     * @return String
     */
    public static String formatNow(String pattern) {
        return toFormat(LocalDateTime.now(), pattern);
    }

    /**
     * 日期加上一个数,根据field不同加不同值,field 为 ChronoUnit.*
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
     * 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
     *
     * @param time   LocalDateTime
     * @param number long
     * @param field  TemporalUnit
     * @return LocalDateTime
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     *
     * @param startTime LocalDateTime
     * @param endTime   LocalDateTime
     * @param field     ChronoUnit 单位(年月日时分秒)
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
     * @return {@link LocalDate}
     */
    public static LocalDate firstDayOfWeek(LocalDate localDate) {
        return localDate.with(DayOfWeek.MONDAY);
    }

    /**
     * 一周的最后一天
     *
     * @param localDate 当地日期
     * @return {@link LocalDate}
     */
    public static LocalDate lastDayOfWeek(LocalDate localDate) {
        return localDate.with(DayOfWeek.SUNDAY);
    }

    /**
     * 月的第一天
     *
     * @param localDate 当地日期
     * @return {@link LocalDate}
     */
    public static LocalDate firstDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 月的最后一天
     *
     * @param localDate 当地日期
     * @return {@link LocalDate}
     */
    public static LocalDate lastDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 每年的第一天
     *
     * @param localDate 当地日期
     * @return {@link LocalDate}
     */
    public static LocalDate firstDayOfYear(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfYear());
    }

    /**
     * 每年的最后一天
     *
     * @param localDate 当地日期
     * @return {@link LocalDate}
     */
    public static LocalDate lastDayOfYear(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastDayOfYear());
    }

    /**
     * 每周的所有日期  即周一到周日
     *
     * @param localDate 当地日期
     * @return {@link List<LocalDate>}
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
     * @return {@link List<LocalDate>}
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
}
