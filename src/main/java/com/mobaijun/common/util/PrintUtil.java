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
     * @param data data
     */
    public static <T> void print(T data) {
        if (Objects.isNull(data)) {
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
        if (Objects.isNull(data)) {
            return;
        }
        System.out.println(data);
    }

    /**
     * 单列集合打印
     *
     * @param collection collection
     */
    public static <T> void println(Collection<T> collection) {
        if (Objects.isNull(collection)) {
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
     * 打印异常信息
     *
     * @param message 内容
     * @param clazz   类
     * @param <T>     泛型
     */
    public static <T> void println(String message, Class<T> clazz) {
        System.out.printf("The exception comes from {%s} class，The error message is：{%s}", clazz.getName(), message);
    }

    /**
     * 格式化输出
     *
     * @param format format
     * @param obj    obj
     */
    public static <T> void printf(String format, T obj) {
        if (Objects.isNull(obj)) {
            return;
        }
        System.out.printf(format, obj);
    }

    /**
     * println String map key and value
     *
     * @param map map
     */
    public static <K, V> void println(Map<K, V> map) {
        if (map.isEmpty()) {
            return;
        }
        map.entrySet().forEach(System.out::println);
    }

    /**
     * println  map values
     *
     * @param map map
     */
    public static <K, V> void mapValue(Map<K, V> map) {
        if (map.isEmpty()) {
            return;
        }
        map.values().forEach(System.out::println);
    }

    /**
     * println String map key
     *
     * @param map map
     */
    public static <K, V> void mapKey(Map<K, V> map) {
        if (map.isEmpty()) {
            return;
        }
        map.keySet().forEach(System.out::println);
    }
}