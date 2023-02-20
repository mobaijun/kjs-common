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
package com.mobaijun.common.test.date;

import com.mobaijun.common.constant.DateConstant;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.date.LocalDateUtil;
import org.junit.Test;

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

    @Test
    public void localDateUtilTest() {
        PrintUtil.println(LocalDateUtil.curYear());
        PrintUtil.println(LocalDateUtil.toDate(LocalDate.now()));
        PrintUtil.println(LocalDateUtil.toDate(LocalDateTime.now()));
        PrintUtil.println(LocalDateUtil.toTimestamp(LocalDate.now()));
        PrintUtil.println(LocalDateUtil.toString(LocalDate.now(), DateConstant.YYYY_MM_DD));
        PrintUtil.println(LocalDateUtil.toString(LocalDateTime.now(), DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtil.println(LocalDateUtil.toString(new Date(), DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtil.println(LocalDateUtil.toLocalDate("2022-11-22", DateConstant.YYYY_MM_DD));
        PrintUtil.println(LocalDateUtil.toLocalDateTime("2022-11-22 13:53:07", DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtil.println(LocalDateUtil.toLocalDate(new Date()));
        PrintUtil.println(LocalDateUtil.toLocalDateTime(new Date()));
        PrintUtil.println(LocalDateUtil.toMillisecond(LocalDateTime.now()));
        PrintUtil.println(LocalDateUtil.toMillisecond(LocalDate.now()));
        PrintUtil.println(LocalDateUtil.toLocalDateTime(Instant.now()));
        PrintUtil.println(LocalDateUtil.toInstant(new Date()));
        PrintUtil.println(LocalDateUtil.toSecond(LocalDateTime.now()));
        PrintUtil.println(LocalDateUtil.toFormat(LocalDateTime.now(), DateConstant.YMD));
        PrintUtil.println(LocalDateUtil.format(1669096646815L, DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtil.println(LocalDateUtil.format(Instant.now(), DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtil.println(LocalDateUtil.getFirstDayOfYear(2022));
        PrintUtil.println(LocalDateUtil.getFirstDayOfMonthMinYear(2022, 11));
        PrintUtil.println(LocalDateUtil.minusToMillsLocalDateTime(LocalDateTime.now(), LocalDateTime.now()));
        PrintUtil.println(LocalDateUtil.minusToMillsLocalTime(LocalTime.now(), LocalTime.now()));
        PrintUtil.println(LocalDateUtil.minusToMillsLocalDate(LocalDate.now(), LocalDate.now()));
        PrintUtil.println(LocalDateUtil.periodLocalDate(LocalDate.now(), LocalDate.now()));
        PrintUtil.println(LocalDateUtil.parseInstant("2022-11-09"));
        PrintUtil.println(LocalDateUtil.parseInstant("2022-11-22 13:57:26", DateConstant.YYYY_MM_DD_HH_MM_SS));
        PrintUtil.println(LocalDateUtil.isBefore(LocalDateTime.now(), LocalDateTime.now()));
        PrintUtil.println(LocalDateUtil.periodDate(new Date(), new Date()));
        PrintUtil.println(LocalDateUtil.toLocalDateTime(1669097261596L));
        PrintUtil.println(LocalDateUtil.getServerStartDate());
        PrintUtil.println(LocalDateUtil.getSecondValue(LocalDateTime.now()));
        PrintUtil.println(LocalDateUtil.formatNow(DateConstant.YY_YY_MM_DD));
        // 太多了，希望有人加入测试
    }
}
