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
package com.mobaijun.common.util;

import com.mobaijun.common.util.collection.CollectionUtils;

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
    public static <T> void println(Collection<T> collection) {
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
    public static <T> void printf(String format, T obj) {
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
    public static <K, V> void println(Map<K, V> map) {
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
    public static <K, V> void mapValue(Map<K, V> map) {
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
    public static <K, V> void mapKey(Map<K, V> map) {
        if (map.size() == 0) {
            return;
        }
        map.keySet().forEach(System.out::println);
    }
}