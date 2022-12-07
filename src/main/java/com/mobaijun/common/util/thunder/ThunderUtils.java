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
package com.mobaijun.common.util.thunder;

import cn.hutool.log.Log;
import lombok.SneakyThrows;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: ThunderUtils<br>
 * class description： 迅雷工具类<br>
 *
 * @author MoBaiJun 2022/7/18 10:20
 */
public class ThunderUtils {
    /**
     * log
     */
    private static final Log log = Log.get(ThunderUtils.class);

    /**
     * 迅雷前缀
     */
    private static final String THUNDER = "thunder://";
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final String STARTS_WITH = "AA";
    private static final String ENDS_WITH = "ZZ";

    /**
     * 判断是否是迅雷链接
     *
     * @param url url地址
     * @return 是否迅雷链接
     */
    public static boolean isThunderLink(String url) {
        return url.startsWith(THUNDER);
    }

    /**
     * 转换成 HTTP URL
     *
     * @param url URL
     * @return http url
     */
    @SneakyThrows
    public static String toHttpUrl(String url) {
        if (!isThunderLink(url)) {
            return url;
        }
        log.info("The current link is the Thunder link, start the conversion...");
        url = url.replaceFirst(THUNDER, "");
        // base 64 转换
        url = new String(Base64.getDecoder().decode(url.getBytes()), UTF8);
        // url 解码
        url = URLDecoder.decode(url, StandardCharsets.UTF_8.name());

        // 去头去尾
        if (url.startsWith(STARTS_WITH)) {
            url = url.substring(2);
        }

        if (url.endsWith(ENDS_WITH)) {
            url = url.substring(0, url.length() - 2);
        }
        log.info("The current link is the Thunder link, the conversion result:{}", url);
        return url;
    }
}