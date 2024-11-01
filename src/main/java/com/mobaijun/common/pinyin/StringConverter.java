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
package com.mobaijun.common.pinyin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: NamingUtils<br>
 * class description: 命名工具类<br>
 *
 * @author MoBaiJun 2022/11/22 11:33
 */
public class StringConverter {

    /**
     * 正则表达式模式，用于处理字符串转换。
     */
    private static final Pattern CAMEL_CASE_PATTERN = Pattern.compile("[A-Z]");

    /**
     * 正则表达式模式，用于匹配下划线后面的字母。
     */
    private static final Pattern SNAKE_CASE_PATTERN = Pattern.compile("_(\\w)");


    /**
     * 将驼峰命名法转换为下划线命名法。
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String toUnderline(String name) {
        if (name.isEmpty()) {
            return "";
        }
        Matcher matcher = CAMEL_CASE_PATTERN.matcher(name);
        StringBuilder buffer = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * 将下划线命名法转换为驼峰命名法。
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String toCamel(String name) {
        if (name.isEmpty()) {
            return "";
        }
        name = name.toLowerCase();
        Matcher matcher = SNAKE_CASE_PATTERN.matcher(name);
        StringBuilder buffer = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * 将小写字符串转换为下划线大写形式。
     *
     * @param input 小写字符串
     * @return 下划线大写形式的字符串
     */
    public static String toUpperUnderscore(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        boolean isFirstChar = true;

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                if (!isFirstChar) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(c));
            } else {
                result.append(Character.toUpperCase(c));
            }
            isFirstChar = false;
        }

        return result.toString();
    }

    /**
     * 将源 Map 的键从下划线命名法转换为驼峰命名法。
     *
     * @param map 源 Map
     * @return 转换后的 Map
     */
    public static <T> Map<String, T> toCamelMap(Map<String, T> map) {
        Map<String, T> newMap = new HashMap<>();
        map.forEach((key, value) -> newMap.put(toCamel(key), value));
        return newMap;
    }

    /**
     * 将源 Map 的键从驼峰命名法转换为下划线命名法。
     *
     * @param map 源 Map
     * @return 转换后的 Map
     */
    public static <T> Map<String, T> toUnderlineMap(Map<String, T> map) {
        Map<String, T> newMap = new HashMap<>();
        map.forEach((key, value) -> newMap.put(toUnderline(key), value));
        return newMap;
    }

    /**
     * 将 List 中的 Map 的键从驼峰命名法转换为下划线命名法。
     *
     * @param list 源 List
     * @return 转换后的 List
     */
    public static <T> List<Map<String, T>> toCamelListMap(List<Map<String, T>> list) {
        return convertList(list, StringConverter::toCamelMap);
    }

    /**
     * 将 List 中的 Map 的键从下划线命名法转换为驼峰命名法。
     *
     * @param list 源 List
     * @return 转换后的 List
     */
    public static <T> List<Map<String, T>> toUnderlineListMap(List<Map<String, T>> list) {
        return convertList(list, StringConverter::toUnderlineMap);
    }

    /**
     * 将 List 中的字符串从下划线命名法转换为驼峰命名法。
     *
     * @param list 源 List
     * @return 转换后的 List
     */
    public static List<String> toCamelList(List<String> list) {
        return convertList(list, StringConverter::toCamel);
    }

    /**
     * 通用方法，用于转换 List 中的元素。
     *
     * @param list      源 List
     * @param converter 转换函数
     * @return 转换后的 List
     */
    private static <T, R> List<R> convertList(List<T> list, Function<T, R> converter) {
        List<R> returnList = new ArrayList<>();
        list.forEach(item -> returnList.add(converter.apply(item)));
        return returnList;
    }
}