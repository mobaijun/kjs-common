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
import com.mobaijun.common.util.text.Charsets;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
     * @throws UnsupportedEncodingException 异常
     */
    public static String getUrlParamsByMap(Map<String, String> data) throws UnsupportedEncodingException {
        if (data == null || data.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> i : data.entrySet()) {

            sb.append(i.getKey())
                    .append(StringConstant.EQUAL)
                    .append(URLEncoder.encode(i.getValue(), Charsets.UTF_8.name()))
                    .append(StringConstant.AND);

        }
        String str = sb.toString();

        return str.substring(0, str.length() - 1);
    }

    /**
     * 将url参数转换成map
     *
     * @param param [ellipsis]
     * @return 参数Map
     */
    public static Map<String, String> getUrlParams(String param) {
        Map<String, String> map = CollectionUtil.newHashMap();
        if (param.isEmpty()) {
            return map;
        }
        String[] params = param.split(StringConstant.AND);
        for (String s : params) {
            String[] p = s.split(StringConstant.EQUAL);
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }
}