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
package com.mobaijun.common.util.number;

import cn.hutool.log.Log;
import com.mobaijun.common.constant.DateConstant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: NumberUtils
 * class description：数字处理工具类
 *
 * @author MoBaiJun 2022/5/12 14:27
 */
public class NumberUtils {

    /**
     * tools log
     */
    private static final Log log = Log.get(NumberUtils.class);

    private static final int CLASSIC_ID_LENGTH = 15;
    private static final int CURRENT_ID_LENGTH = 18;

    /**
     * 根据身份证号判断性别
     *
     * @param idNumber 身份证
     * @return int
     */
    public static int getGender(String idNumber) throws IllegalArgumentException {

        if (idNumber.length() != CURRENT_ID_LENGTH && idNumber.length() != CLASSIC_ID_LENGTH) {
            throw new IllegalArgumentException("Invalid ID length");
        }

        char c;
        if (idNumber.length() == CURRENT_ID_LENGTH) {
            c = idNumber.charAt(idNumber.length() - 2);
        } else {
            c = idNumber.charAt(idNumber.length() - 1);
        }
        return Integer.parseInt(String.valueOf(c));
    }

    /**
     * 根据身份证的号码算出当前身份证持有者的年龄
     *
     * @param idNumber 身份证
     * @return int
     */
    public static int countAge(String idNumber) {
        if (idNumber.length() != 18 && idNumber.length() != 15) {
            throw new IllegalArgumentException("身份证号长度错误");
        }
        String year;
        String yue;
        String day;
        if (idNumber.length() == 18) {
            year = idNumber.substring(6).substring(0, 4);
            yue = idNumber.substring(10).substring(0, 2);
            day = idNumber.substring(12).substring(0, 2);
        } else {
            year = "19" + idNumber.substring(6, 8);
            yue = idNumber.substring(8, 10);
            day = idNumber.substring(10, 12);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(DateConstant.YYYY_MM_DD);
        String fear = format.format(date).substring(0, 4);
        String flue = format.format(date).substring(5, 7);
        String days = format.format(date).substring(8, 10);
        int age = 0;
        int number = Integer.parseInt(fear) - Integer.parseInt(year);
        if (Integer.parseInt(yue) == Integer.parseInt(flue)) {
            if (Integer.parseInt(day) <= Integer.parseInt(days)) {
                age = number;
            }
        } else {

            if (Integer.parseInt(yue) < Integer.parseInt(flue)) {
                // 如果当前月份大于出生月份
                age = number;
            } else {
                // 如果当前月份小于出生月份,说明生日还没过
                age = Integer.parseInt(fear) - Integer.parseInt(year) - 1;
            }
        }
        System.out.println("age = " + age);
        return age;
    }

    /**
     * 四舍五入,小数点后保留几位
     *
     * @param v     数位1
     * @param scale 数位2
     * @return double
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 小于 0
     *
     * @param number 数字
     * @return 是否小于 0
     */
    public static boolean leThanZero(Number number) {
        return number.intValue() < 0;
    }

    /**
     * 小于等于 0
     *
     * @param number 数字
     * @return 是否小于等于 0
     */
    public static boolean leThanEqToZero(Number number) {
        return number.doubleValue() <= 0;
    }

    /**
     * 大于 0
     *
     * @param number 数字
     * @return 是否大于 0
     */
    public static boolean geThanZero(Number number) {
        return number.doubleValue() > 0;
    }

    /**
     * 大于等于 0
     *
     * @param number 数字
     * @return 是否大于等于 0
     */
    public static boolean geThanEqToZero(Number number) {
        return number.doubleValue() >= 0;
    }

    /**
     * 是否为整数
     *
     * @param str 字符串
     * @return 是否为整数
     */
    public static boolean isInteger(String str) {
        return str.matches("^[-+]?[\\d]*$");
    }

    /**
     * 解析为 Long
     *
     * @param s 字符串
     * @return Long 类型变量
     */
    public static Long parseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
            return 0L;
        }
    }
}