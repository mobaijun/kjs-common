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

import com.mobaijun.common.constant.StringConstant;
import com.mobaijun.common.util.collection.CollectionUtil;
import com.mobaijun.common.util.regx.RegxConstant;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: NamingUtils<br>
 * class description: 命名工具类<br>
 *
 * @author MoBaiJun 2022/11/22 11:33
 */
public class NamingUtil {

    /**
     * 驼峰转中划线
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String humpToMidline(String name) {
        if (name.isEmpty()) {
            return StringConstant.BLANK;
        }
        Matcher matcher = RegxConstant.HUMP_PATTERN.matcher(name);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, StringConstant.HYPHEN + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * 驼峰转下划线
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String humpToUnderline(String name) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < name.length(); ++i) {
            char ch = name.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                char chars = (char) (ch + 32);
                if (i > 0) {
                    buf.append(StringConstant.UNDERLINE);
                }
                buf.append(chars);
            } else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

    /**
     * 下划线转驼峰
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String underlineToHump(String name) {
        if (name.isEmpty()) {
            return StringConstant.BLANK;
        }
        name = name.toLowerCase();
        Matcher matcher = RegxConstant.UNDERLINE_PATTERN.matcher(name);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * 下划线转驼峰Map集
     *
     * @param map 源字符串
     * @return 转换后的Map
     */
    public static Map<String, Object> underline2CamelMap(Map<String, Object> map) {
        Map<String, Object> newMap = CollectionUtil.newHashMap();
        for (String key : map.keySet()) {
            String camel = underlineToHump(key);
            // 存在 " " 转换为""
            if (" ".equals(map.get(key))) {
                newMap.put(camel, "");
            } else {
                newMap.put(camel, map.get(key));
            }
        }
        return newMap;
    }

    /**
     * Map集
     * 驼峰转下划线
     *
     * @param map 源字符串
     * @return 转换后的Map
     */
    public static Map<String, Object> camel2UnderlineMap(Map<String, Object> map) {
        Map<String, Object> newMap = CollectionUtil.newHashMap();
        for (String key : map.keySet()) {
            String camel = humpToUnderline(key);
            newMap.put(camel, map.get(key));
        }
        return newMap;
    }

    /**
     * 驼峰法转下划线List套Map集
     *
     * @param list 源字符串
     * @return 转换后的List套Map
     */
    public static List<Map<String, Object>> underline2CamelList(List<Map<String, Object>> list) {
        Map<String, Object> newMap = CollectionUtil.newHashMap();
        List<Map<String, Object>> returnList = CollectionUtil.newArrayList();
        for (Map<String, Object> map : list) {
            for (String key : map.keySet()) {
                String camel = humpToUnderline(key);
                newMap.put(camel, map.get(key));
            }
            returnList.add(newMap);
        }
        return returnList;
    }

    /**
     * 下划线转驼峰法List套Map集
     *
     * @param list 源字符串
     * @return 转换后的List套Map
     */
    public static List<Map<String, Object>> underlineList(List<Map<String, Object>> list) {
        Map<String, Object> newMap = CollectionUtil.newHashMap();
        List<Map<String, Object>> returnList = CollectionUtil.newArrayList();
        for (Map<String, Object> map : list) {
            for (String key : map.keySet()) {
                String camel = humpToUnderline(key);
                newMap.put(camel, map.get(key));
            }
            returnList.add(newMap);
        }
        return returnList;
    }

    /**
     * 下划线转驼峰法List
     *
     * @param list 源字符串
     * @return 转换后的List套String
     */
    public static List<String> getList(List<String> list) {
        List<String> returnList = CollectionUtil.newArrayList();
        System.out.println(list.get(0));
        for (String key : list) {
            String camel = humpToUnderline(key);
            returnList.add(camel);
        }
        return returnList;
    }
}