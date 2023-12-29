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

import java.util.Arrays;
import java.util.HashMap;
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
     * 解析 URL 参数为 Map
     *
     * @param paramsPath URL
     * @return 参数 Map
     */
    public static Map<String, String> parseUrlParams(String paramsPath) {
        return parseUrlParams(paramsPath, "=");
    }

    /**
     * 解析 URL 参数为 Map
     *
     * @param paramsPath URL
     * @param separator  参数分隔符
     * @return 参数 Map
     */
    public static Map<String, String> parseUrlParams(String paramsPath, String separator) {
        Assert.notNull(paramsPath, "paramsPath不能为空");
        Assert.notNull(separator, "separator不能为空");

        // 判断是否包含 "?" 和参数分隔符
        if (!paramsPath.contains("?") || !paramsPath.contains(separator)) {
            return new HashMap<>();
        }

        // 获取 "?" 后的参数部分
        String[] paramsArr = paramsPath.split("\\?");
        String paramsStr = paramsArr[paramsArr.length - 1];

        // 判断是否存在参数项
        if (paramsStr.isEmpty()) {
            return new HashMap<>();
        }

        // 分割参数项
        String[] paramsItems = paramsStr.split("&");

        // 构建结果 Map
        Map<String, String> result = new HashMap<>();

        // 遍历参数项，解析并放入结果 Map
        Arrays.stream(paramsItems)
                .filter(item -> item != null && !item.isEmpty() && item.contains(separator))
                .map(item -> item.split(separator))
                .filter(keyValue -> keyValue.length == 2)
                .forEach(keyValue -> result.put(keyValue[0], keyValue[1]));

        return result;
    }
}