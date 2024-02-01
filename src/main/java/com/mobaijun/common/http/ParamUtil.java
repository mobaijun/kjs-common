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
package com.mobaijun.common.http;

import com.mobaijun.common.assertions.Assert;
import com.mobaijun.common.constant.StringConstant;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: ParamUtils<br>
 * class description: URL 参数处理工具类<br>
 *
 * @author MoBaiJun 2022/11/22 11:36
 */
public class ParamUtil {

    /**
     * 将Map转换为URL参数字符串。
     *
     * @param paramsMap 参数Map
     * @return URL参数字符串
     */
    public static <V> String convertMapToUrlParams(Map<String, V> paramsMap) {
        if (paramsMap.isEmpty()) {
            return "";
        }

        StringBuilder urlParamsBuilder = new StringBuilder();

        for (Map.Entry<String, V> entry : paramsMap.entrySet()) {
            String encodedValue = URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8);
            urlParamsBuilder.append(entry.getKey())
                    .append(StringConstant.EQUAL)
                    .append(encodedValue)
                    .append(StringConstant.AND);
        }

        urlParamsBuilder.deleteCharAt(urlParamsBuilder.length() - 1);
        return urlParamsBuilder.toString();
    }

    /**
     * 解析URL参数为Map。
     *
     * @param paramsPath URL
     * @return 参数Map
     */
    public static Map<String, String> parseUrlParams(String paramsPath) {
        return parseUrlParams(paramsPath, "=");
    }

    /**
     * 解析URL参数为Map。
     *
     * @param paramsPath URL
     * @param separator  参数分隔符
     * @return 参数Map
     */
    public static Map<String, String> parseUrlParams(String paramsPath, String separator) {
        Assert.notNull(paramsPath, "The params Path cannot be empty");
        Assert.notNull(separator, "separator cannot be empty");

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
        String[] paramsItems = paramsStr.split(StringConstant.AND);

        // 构建结果 Map
        Map<String, String> result = new HashMap<>();

        // 遍历参数项，解析并放入结果 Map
        Arrays.stream(paramsItems)
                .filter(item -> item != null && !item.isEmpty() && item.contains(separator))
                .map(item -> item.split(separator, 2))
                .filter(keyValue -> keyValue.length == 2)
                .forEach(keyValue -> result.put(keyValue[0], keyValue[1]));

        return result;
    }

    /**
     * 构建重定向 URL。
     *
     * @param baseUrl   原始的URL
     * @param paramsMap URL上要拼接的参数信息
     * @return 构建后的重定向URL
     */
    public static <V> String buildRedirectUrl(String baseUrl, Map<String, V> paramsMap) {
        URI uri;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URI: " + baseUrl, e);
        }

        String query = uri.getQuery();
        StringBuilder urlBuilder = new StringBuilder(baseUrl);

        if (query == null) {
            urlBuilder.append(StringConstant.QUESTION_MARK);
        } else {
            urlBuilder.append(StringConstant.AND);
        }

        for (Map.Entry<String, V> entry : paramsMap.entrySet()) {
            String key = entry.getKey();
            V value = entry.getValue();
            urlBuilder.append(key)
                    .append(StringConstant.EQUAL)
                    .append(value.toString())
                    .append(StringConstant.AND);
        }

        urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        return urlBuilder.toString();
    }
}