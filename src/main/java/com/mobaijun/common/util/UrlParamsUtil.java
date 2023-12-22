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

import com.mobaijun.common.assertions.Assert;
import com.mobaijun.common.collection.CollectionUtil;
import com.mobaijun.common.constant.NumberConstant;

import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: UrlParamsUtil<br>
 * class description： url 工具类<br>
 *
 * @author MoBaiJun 2022/9/13 14:19
 */
public class UrlParamsUtil {

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
     * 解析 URL 参数为 Map
     *
     * @param paramsPath URL
     * @param separator  参数分隔符
     * @return 参数 Map
     */
    public static Map<String, String> split(String paramsPath, String separator) {
        Assert.notNull(paramsPath, "paramsPath不能为空");
        Assert.notNull(separator, "separator不能为空");

        // 判断是否包含 "?" 和参数分隔符
        if (!paramsPath.contains("?") || !paramsPath.contains(separator)) {
            return CollectionUtil.newHashMap();
        }

        // 获取 "?" 后的参数部分
        String[] paramsArr = paramsPath.split("\\?");
        String paramsStr = paramsArr[paramsArr.length - 1];

        // 判断是否存在参数项
        if (paramsStr.isEmpty()) {
            return CollectionUtil.newHashMap();
        }

        // 分割参数项
        String[] paramsItems = paramsStr.split("&");

        // 判断是否存在有效的参数项
        if (paramsItems.length == 0) {
            return CollectionUtil.newHashMap();
        }

        // 构建结果 Map
        Map<String, String> result = CollectionUtil.newHashMap();

        // 遍历参数项，解析并放入结果 Map
        for (String item : paramsItems) {
            if (item == null || item.isEmpty() || !item.contains(separator)) {
                continue;
            }

            String[] keyValue = item.split(separator);

            // 确保键值对格式正确
            if (keyValue.length == 2) {
                result.put(keyValue[0], keyValue[1]);
            }
        }

        return result;
    }

    /**
     * 将keyValues转成Map
     *
     * @param keyValues 键值对数组
     * @return 转换后的Map
     */
    public static Map<String, String> build(String... keyValues) {
        Assert.assertTrue(keyValues.length % 2 == 0, "键值对数量必须是偶数");

        if (keyValues.length == 0) {
            return CollectionUtil.newHashMap();
        }

        Map<String, String> result = CollectionUtil.newHashMap();

        for (int i = 0; i < keyValues.length; i += 2) {
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
        if (originMap == null || originMap.isEmpty()) {
            return;
        }
        for (int i = 0; i < keyValues.length; i += NumberConstant.TWO) {
            originMap.put(keyValues[i], keyValues[i + 1]);
        }
    }
}