package com.mobaijun.common.util;

import java.util.Collection;
import java.util.Map;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * Date: 2022/2/25 17:37
 * ClassName:PrintUtil
 * 类描述： 打印工具类
 * <a href="https://blog.51cto.com/u_15080022/3462878">...</a>
 * 解决【java: 非法字符: '\ufeff'】非法问题
 *
 * @author mobaijun
 */
public class PrintUtils {

    /**
     * 不换行输出
     *
     * @param data data
     */
    public static <T> void print(T data) {
        if (ObjectUtils.isEmpty(data)) {
            return;
        }
        System.out.print(data);
    }

    /**
     * 换行打印输出
     *
     * @param data obj
     */
    public static <T> void println(T data) {
        if (ObjectUtils.isEmpty(data)) {
            return;
        }
        System.out.println(data);
    }

    /**
     * 单列集合打印
     *
     * @param collection collection
     */
    public static void println(Collection<?> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return;
        }
        collection.forEach(System.out::println);
    }

    /**
     * 打印空格
     */
    public static void print() {
        System.out.println();
    }

    /**
     * 打印异常消息
     *
     * @param message 内容
     * @param clazz   消息
     */
    public static void print(String message, String clazz) {
        System.out.println(message + clazz);
    }

    /**
     * 格式化输出
     *
     * @param format format
     * @param obj    obj
     */
    public static void printf(String format, Object obj) {
        if (ObjectUtils.isEmpty(obj)) {
            return;
        }
        System.out.printf(format, obj);
    }

    /**
     * println String map key and value
     *
     * @param map map
     */
    public static void println(Map<?, ?> map) {
        if (map.size() == 0) {
            return;
        }
        map.entrySet().forEach(System.out::println);
    }

    /**
     * println  map values
     *
     * @param map map
     */
    public static void mapValue(Map<?, ?> map) {
        if (map.size() == 0) {
            return;
        }
        map.values().forEach(System.out::println);
    }

    /**
     * println String map key
     *
     * @param map map
     */
    public static void mapKey(Map<?, ?> map) {
        if (map.size() == 0) {
            return;
        }
        map.keySet().forEach(System.out::println);
    }
}
