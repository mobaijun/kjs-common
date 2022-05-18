package com.mobaijun.common.util;

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
     * 根据身份证号判断性别
     *
     * @param idNumber 身份证
     * @return int
     */
    public static int getGender(String idNumber) throws IllegalArgumentException {
        int CLASSIC_ID_LENGTH = 15;
        int CURRENT_ID_LENGTH = 18;
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fyear = format.format(date).substring(0, 4);
        String fyue = format.format(date).substring(5, 7);
        String fday = format.format(date).substring(8, 10);
        int age = 0;
        int number = Integer.parseInt(fyear) - Integer.parseInt(year);
        if (Integer.parseInt(yue) == Integer.parseInt(fyue)) {
            if (Integer.parseInt(day) <= Integer.parseInt(fday)) {
                age = number;
            }
        } else {

            if (Integer.parseInt(yue) < Integer.parseInt(fyue)) {
                // 如果当前月份大于出生月份
                age = number;
            } else {
                // 如果当前月份小于出生月份,说明生日还没过
                age = Integer.parseInt(fyear) - Integer.parseInt(year) - 1;
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
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, RoundingMode.HALF_UP).doubleValue();
    }
}
