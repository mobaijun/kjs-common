/*
 * Copyright (C) 2022 [www.mobaijun.com]
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
package com.mobaijun.common.util;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * Date: 2022/2/25 17:37<br>
 * ClassName:PrintUtil<br>
 * 类描述： 打印工具类<br>
 * <a href="https://blog.51cto.com/u_15080022/3462878">...</a><br>
 * 解决【java: 非法字符: '\ufeff'】非法问题<br>
 *
 * @author mobaijun
 */
public class PrintUtil {

    /**
     * 不换行输出
     *
     * @param data 数据
     */
    public static <T> void print(T data) {
        if (Objects.nonNull(data)) {
            System.out.print(data);
        }
    }

    /**
     * 换行打印输出
     *
     * @param data 数据
     */
    public static <T> void println(T data) {
        if (Objects.nonNull(data)) {
            System.out.println(data);
        }
    }

    /**
     * 打印集合元素，每个元素一行
     *
     * @param collection 集合
     */
    public static <T> void println(Collection<T> collection) {
        if (Objects.nonNull(collection)) {
            collection.forEach(System.out::println);
        }
    }

    /**
     * 打印空行
     */
    public static void printNewLine() {
        System.out.println();
    }

    /**
     * 打印异常信息
     *
     * @param message        异常信息
     * @param exceptionClass 异常类
     * @param <T>            泛型
     */
    public static <T extends Throwable> void logException(String message, Class<T> exceptionClass) {
        print(String.format("Exception from {%s} class: {%s}", exceptionClass.getName(), message));
    }

    /**
     * 格式化输出
     *
     * @param format 格式字符串
     * @param obj    对象
     */
    public static <T> void printf(String format, T obj) {
        if (Objects.nonNull(obj)) {
            System.out.printf(format, obj);
        }
    }

    /**
     * 打印 Map 的键值对，每个键值对一行
     *
     * @param map Map
     */
    public static <K, V> void println(Map<K, V> map) {
        if (Objects.nonNull(map) && !map.isEmpty()) {
            map.forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }

    /**
     * 打印 Map 的值，每个值一行
     *
     * @param map Map
     */
    public static <K, V> void mapValues(Map<K, V> map) {
        if (Objects.nonNull(map) && !map.isEmpty()) {
            map.values().forEach(System.out::println);
        }
    }

    /**
     * 打印 Map 的键，每个键一行
     *
     * @param map Map
     */
    public static <K, V> void mapKeys(Map<K, V> map) {
        if (Objects.nonNull(map) && !map.isEmpty()) {
            map.keySet().forEach(System.out::println);
        }
    }
}