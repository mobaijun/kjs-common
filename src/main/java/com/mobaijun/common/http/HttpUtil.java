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

import com.mobaijun.common.enums.http.ProtocolType;

import java.net.URL;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: HttpUtils<br>
 * class description： http 工具类
 *
 * @author MoBaiJun 2022/7/18 10:05
 */
public class HttpUtil {

    /**
     * 判断是否为指定协议的链接
     *
     * @param urlString url链接
     * @param protocol  协议类型，可为 ProtocolType.HTTP 或 ProtocolType.HTTPS
     * @return 是|否
     */
    public static boolean isProtocol(String urlString, ProtocolType protocol) {
        try {
            URL url = new URL(urlString);
            String urlProtocol = url.getProtocol();
            return protocol.getValue().equalsIgnoreCase(urlProtocol);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}