package com.mobaijun.util;

import java.util.Collection;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * Author: https://www.mobaijun.com
 * Date: 2022/2/25 17:37
 * ClassName:PrintUtil
 * 类描述： 打印工具类
 * https://blog.51cto.com/u_15080022/3462878
 * 解决【java: 非法字符: '\ufeff'】非法问题
 */
public class PrintUtil {

    /**
     * 不换行输出
     *
     * @param obj
     */
    public static void print(Object obj) {
        System.out.print(obj);
    }

    /**
     * 换行打印输出
     *
     * @param obj
     */
    public static void println(Object obj) {
        System.out.print(obj);
    }

    /**
     * 单列集合打印
     *
     * @param collection
     */
    public static void println(Collection collection) {
        collection.forEach(System.out::println);
    }

    /**
     * 打印空格
     */
    public static void print() {
        System.out.println();
    }

    /**
     * 格式化输出
     *
     * @param format
     * @param obj
     */
    public static void printf(String format, Object obj) {
        System.out.printf(format, obj);
    }
}
