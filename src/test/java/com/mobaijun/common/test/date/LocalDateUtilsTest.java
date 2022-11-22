package com.mobaijun.common.test.date;

import com.mobaijun.common.util.PrintUtils;
import com.mobaijun.common.util.constant.DateConstant;
import com.mobaijun.common.util.date.LocalDateUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: LocalDateUtilsTest
 * class description: 日期测试类
 *
 * @author MoBaiJun 2022/11/22 12:31
 */
public class LocalDateUtilsTest {

    public static void main(String[] args) {
        PrintUtils.println(LocalDateUtils.curYear());
        PrintUtils.println(LocalDateUtils.toDate(LocalDate.now()));
        PrintUtils.println(LocalDateUtils.toDate(LocalDateTime.now()));
        PrintUtils.println(LocalDateUtils.toTimestamp(LocalDate.now()));
        PrintUtils.println(LocalDateUtils.toString(LocalDate.now(), DateConstant.YYYY_MM_DD));
        PrintUtils.println(LocalDateUtils.toString(LocalDateTime.now(), DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtils.println(LocalDateUtils.toString(new Date(), DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtils.println(LocalDateUtils.toLocalDate("2022-11-22", DateConstant.YYYY_MM_DD));
        PrintUtils.println(LocalDateUtils.toLocalDateTime("2022-11-22 13:53:07", DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtils.println(LocalDateUtils.toLocalDate(new Date()));
        PrintUtils.println(LocalDateUtils.toLocalDateTime(new Date()));
        PrintUtils.println(LocalDateUtils.toMillisecond(LocalDateTime.now()));
        PrintUtils.println(LocalDateUtils.toMillisecond(LocalDate.now()));
        PrintUtils.println(LocalDateUtils.toLocalDateTime(Instant.now()));
        PrintUtils.println(LocalDateUtils.toInstant(new Date()));
        PrintUtils.println(LocalDateUtils.toSecond(LocalDateTime.now()));
        PrintUtils.println(LocalDateUtils.toFormat(LocalDateTime.now(), DateConstant.YMD));
        PrintUtils.println(LocalDateUtils.format(1669096646815L, DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtils.println(LocalDateUtils.format(Instant.now(), DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtils.println(LocalDateUtils.getFirstDayOfYear(2022));
        PrintUtils.println(LocalDateUtils.getFirstDayOfMonthMinYear(2022, 11));
        PrintUtils.println(LocalDateUtils.minusToMillsLocalDateTime(LocalDateTime.now(), LocalDateTime.now()));
        PrintUtils.println(LocalDateUtils.minusToMillsLocalTime(LocalTime.now(), LocalTime.now()));
        PrintUtils.println(LocalDateUtils.minusToMillsLocalDate(LocalDate.now(), LocalDate.now()));
        PrintUtils.println(LocalDateUtils.periodLocalDate(LocalDate.now(), LocalDate.now()));
        PrintUtils.println(LocalDateUtils.parseInstant("2022-11-09"));
        PrintUtils.println(LocalDateUtils.parseInstant("2022-11-22 13:57:26", DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtils.println(LocalDateUtils.isBefore(LocalDateTime.now(), LocalDateTime.now()));
        PrintUtils.println(LocalDateUtils.periodDate(new Date(), new Date()));
        PrintUtils.println(LocalDateUtils.toLocalDateTime(1669097261596L));
        PrintUtils.println(LocalDateUtils.getServerStartDate());
        PrintUtils.println(LocalDateUtils.getSecondValue(LocalDateTime.now()));
        PrintUtils.println(LocalDateUtils.formatNow(DateConstant.YY_YY_MM_DD));
        // 太多了，希望有人加入测试
    }
}
