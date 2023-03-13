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

import java.io.IOException;
import java.net.HttpURLConnection;
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
     * 获取 http 链接
     *
     * @param url url
     * @return HttpConnection
     */
    public static HttpURLConnection getHttpConnection(String url, String requestMethod) throws IOException {
        URL requestUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
        connection.setRequestMethod(requestMethod);
        connection.connect();
        return connection;
    }

    /**
     * 判断是否为http链接
     *
     * @param urlString url链接
     * @return 是|否
     */
    public static boolean isHttp(String urlString) {
        try {
            URL url = new URL(urlString);
            String protocol = url.getProtocol();
            return "http".equals(protocol);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断是否为https链接
     *
     * @param urlString url链接
     * @return 是|否
     */
    public static boolean isHttps(String urlString) {
        try {
            URL url = new URL(urlString);
            String protocol = url.getProtocol();
            return "https".equals(protocol);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}