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
package com.mobaijun.common.util.http;

import cn.hutool.http.GlobalHeaders;
import cn.hutool.http.Header;
import cn.hutool.http.HttpConnection;
import cn.hutool.http.HttpUtil;
import cn.hutool.log.Log;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: HttpUtils
 * class description： http 工具类
 *
 * @author MoBaiJun 2022/7/18 10:05
 */
public class HttpUtils extends HttpUtil {

    /**
     * tools log
     */
    private static final Log log = Log.get(HttpUtils.class);

    /**
     * 获取 http 链接
     *
     * @param url url
     * @return HttpConnection
     */
    public static HttpConnection getHttpConnection(String url) {
        return HttpConnection.create(url, null).header(Header.USER_AGENT.getValue(),
                GlobalHeaders.INSTANCE.header(Header.USER_AGENT.getValue()), false);
    }

    /**
     * 创建 git 请求
     *
     * @param url      url 地址
     * @param hostname 代理地址
     * @param port     代理端口
     * @return 主体 body
     */
    public static String createGet(String url, String hostname, Integer port) {
        return HttpUtil.createGet(url).setHttpProxy(hostname, port).execute().body();
    }

    /**
     * 检测是否http或者https
     *
     * @param url URL
     * @return 是否 http
     */
    public static boolean isHttpOrHttps(String url) {
        return isHttp(url) || isHttps(url);
    }
}