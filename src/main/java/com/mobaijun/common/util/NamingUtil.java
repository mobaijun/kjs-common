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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: NamingUtils<br>
 * class description: 命名工具类<br>
 *
 * @author MoBaiJun 2022/11/22 11:33
 */
public class NamingUtil {

    private static final Pattern HUMP_PATTERN = Pattern.compile("[A-Z]");

    private static final Pattern UNDERLINE_PATTERN = Pattern.compile("_(\\w)");

    /**
     * 驼峰转下划线
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String toUnderline(String name) {
        if (name.isEmpty()) {
            return "";
        }
        Matcher matcher = HUMP_PATTERN.matcher(name);
        StringBuilder buffer = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * 下划线转驼峰
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String toCamel(String name) {
        if (name.isEmpty()) {
            return "";
        }
        name = name.toLowerCase();
        Matcher matcher = UNDERLINE_PATTERN.matcher(name);
        StringBuilder buffer = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * 将小写字符串转换为下划线大写形式
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
     * 下划线转驼峰Map集
     *
     * @param map 源Map
     * @return 转换后的Map
     */
    public static <T> Map<String, T> toCamelMap(Map<String, T> map) {
        Map<String, T> newMap = new HashMap<>();
        for (String key : map.keySet()) {
            String camel = toCamel(key);
            newMap.put(camel, map.get(key));
        }
        return newMap;
    }

    /**
     * Map集 驼峰转下划线
     *
     * @param map 源Map
     * @return 转换后的Map
     */
    public static <T> Map<String, T> toUnderlineMap(Map<String, T> map) {
        Map<String, T> newMap = new HashMap<>();
        for (String key : map.keySet()) {
            String underline = toUnderline(key);
            newMap.put(underline, map.get(key));
        }
        return newMap;
    }

    /**
     * 驼峰法转下划线List套Map集
     *
     * @param list 源List
     * @return 转换后的List套Map
     */
    public static <T> List<Map<String, T>> toCamelListMap(List<Map<String, T>> list) {
        List<Map<String, T>> returnList = new ArrayList<>();
        for (Map<String, T> map : list) {
            Map<String, T> newMap = toCamelMap(map);
            returnList.add(newMap);
        }
        return returnList;
    }

    /**
     * 下划线转驼峰法List套Map集
     *
     * @param list 源List
     * @return 转换后的List套Map
     */
    public static <T> List<Map<String, T>> toUnderlineListMap(List<Map<String, T>> list) {
        List<Map<String, T>> returnList = new ArrayList<>();
        for (Map<String, T> map : list) {
            Map<String, T> newMap = toUnderlineMap(map);
            returnList.add(newMap);
        }
        return returnList;
    }

    /**
     * 下划线转驼峰法List
     *
     * @param list 源List
     * @return 转换后的List
     */
    public static List<String> toCamelList(List<String> list) {
        List<String> returnList = new ArrayList<>();
        for (String key : list) {
            String camel = toCamel(key);
            returnList.add(camel);
        }
        return returnList;
    }
}