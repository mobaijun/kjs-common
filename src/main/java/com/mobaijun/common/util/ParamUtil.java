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

import com.mobaijun.common.constant.StringConstant;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: ParamUtils<br>
 * class description: 参数处理工具类<br>
 *
 * @author MoBaiJun 2022/11/22 11:36
 */
public class ParamUtil {

    /**
     * 将Map型转为请求参数型
     *
     * @param data Map类型的参数
     * @return url请求的参数
     */
    public static String mapToUrlParams(Map<String, String> data) {
        if (data.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            sb.append(entry.getKey())
                    .append(StringConstant.EQUAL)
                    .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                    .append(StringConstant.AND);
        }

        String params = sb.toString();
        return params.substring(0, params.length() - 1);
    }

    /**
     * 将url参数转换成map
     *
     * @param param url参数字符串
     * @return 参数Map
     */
    public static Map<String, String> urlParamsToMap(String param) {
        Map<String, String> paramMap = new HashMap<>();
        if (param.isEmpty()) {
            return paramMap;
        }

        String[] params = param.split(StringConstant.AND);
        for (String pair : params) {
            String[] keyValue = pair.split(StringConstant.EQUAL);
            if (keyValue.length == 2) {
                paramMap.put(keyValue[0], keyValue[1]);
            }
        }

        return paramMap;
    }
}