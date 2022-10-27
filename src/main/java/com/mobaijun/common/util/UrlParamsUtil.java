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

import com.mobaijun.common.util.constant.NumberConstant;
import com.mobaijun.common.util.constant.StringConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: UrlParamsUtil
 * class description： url 工具类
 *
 * @author MoBaiJun 2022/9/13 14:19
 */
public class UrlParamsUtil {

    /**
     * 将Map转成String, 可以指定分隔符
     *
     * @param map       map
     * @param separator 分隔符
     * @return res
     */
    public static String join(Map<String, String> map, String separator) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.append(entry.getKey()).append("=").append(entry.getValue()).append(separator);
        }
        if (builder.length() > 0) {
            builder.delete(builder.length() - separator.length(), builder.length());
        }
        return builder.toString();
    }

    /**
     * 解析ulr参数为map
     *
     * @param paramsPath url
     * @return map
     */
    public static Map<String, String> split(String paramsPath) {
        return split(paramsPath, "=");
    }

    /**
     * 解析ulr参数为map
     *
     * @param paramsPath url
     * @return map
     */
    public static Map<String, String> split(String paramsPath, String separator) {
        if (paramsPath == null || !paramsPath.contains(StringConstant.QUESTION_MARK)
                || !paramsPath.contains(separator)) {
            return null;
        }
        String[] paramsArr = paramsPath.split("\\?");
        String paramsStr = paramsArr[paramsArr.length - 1];
        String[] paramsItems = paramsStr.split(StringConstant.AND);
        if (paramsItems.length == 0) {
            return null;
        }
        Map<String, String> result = new HashMap<>(10);
        for (String item : paramsItems) {
            if (item == null || item.length() == 0 || !item.contains(separator)) {
                continue;
            }
            String[] keyValue = item.split(separator);
            result.put(keyValue[0], keyValue[1]);
        }
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    /**
     * 将keyValues转成Map
     *
     * @param keyValues kayValue
     * @return map
     */
    public static Map<String, String> build(String... keyValues) {
        if (keyValues == null || keyValues.length == 0) {
            return null;
        }
        Map<String, String> result = new HashMap<>(10);
        for (int i = 0; i < keyValues.length; i += NumberConstant.TWO) {
            result.put(keyValues[i], keyValues[i + 1]);
        }
        return result;
    }

    /**
     * 在原Map添加keyValues
     *
     * @param originMap origin Map
     * @param keyValues keyValues
     */
    public static void add(Map<String, String> originMap, String... keyValues) {
        if (originMap == null || originMap.size() == 0) {
            return;
        }
        for (int i = 0; i < keyValues.length; i += NumberConstant.TWO) {
            originMap.put(keyValues[i], keyValues[i + 1]);
        }
    }
}