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

import cn.hutool.core.util.StrUtil;
import com.mobaijun.common.util.constant.DateConstant;
import lombok.SneakyThrows;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: DateUtils
 * 类描述： 日期工具类
 *
 * @author MoBaiJun 2022/4/22 18:51
 */
public class DateUtils {

    /**
     * 获取启动时间
     *
     * @return Date
     */
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }


    /**
     * 获取结束时间
     *
     * @return Date
     */
    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 获取服务器启动时间
     *
     * @return Date
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 时间日期转换
     *
     * @param format 格式
     * @param date   时间
     * @return string
     */
    public static String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
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
     * 获取YYYY-MM-DD格式
     *
     * @param date date
     * @return String
     */
    public static String getDay(Date date) {
        return formatDate(date, DateConstant.YYYY_MM_DD);
    }


    /**
     * 格式化日期
     *
     * @param date    date
     * @param pattern pattern
     * @return String
     */
    public static String formatDate(Date date, String pattern) {
        String formatDate;
        if (StrUtil.isBlank(pattern)) {
            formatDate = new SimpleDateFormat(pattern).format(date);
        } else {
            formatDate = new SimpleDateFormat(DateConstant.YYYY_MM_DD).format(date);
        }
        return formatDate;
    }

    /**
     * 获取两个日期之间相差的天数
     *
     * @param date1 日期
     * @param date2 日期
     * @return 相差天数
     */
    @SneakyThrows
    public static Long timeDifference(String date1, String date2) {
        // format date string
        SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.YYYY_MM_DD, Locale.SIMPLIFIED_CHINESE);
        // Calculate the number of days between dates
        return TimeUnit.DAYS.convert(Math.abs(sdf.parse(date1).getTime() - sdf.parse(date2).getTime()), TimeUnit.MILLISECONDS);
    }

    /**
     * 格式化 LocalDateTime
     *
     * @param format 格式
     * @return 格式化日期
     */
    public static String parseLocalDateTime(String format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
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
}