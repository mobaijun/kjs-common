package com.mobaijun.common.util;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: RandUtils
 * class description： 生成随机数
 *
 * @author MoBaiJun 2022/5/31 11:14
 */
public class RandUtils {

    /**
     * 在给定的区间内产生随机数
     *
     * @param min 区间最小值
     * @param max 区间最大数
     */
    public static double randNum(double min, double max) {
        double result = Math.random() * max + min;
        if (result > max) {
            result = max;
        }
        return result;
    }
}
