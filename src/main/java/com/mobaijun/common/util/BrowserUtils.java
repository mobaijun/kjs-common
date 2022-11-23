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

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: BrowserUtils
 * class description：调用默认浏览器打开指定网页
 *
 * @author MoBaiJun 2022/5/25 15:28
 */
public class BrowserUtils {

    /**
     * Invoke the default browser to open the specified webpage
     *
     * @param url 地址
     */
    public static void openUrl(String url) {
        // 判断是否支持Desktop扩展,如果支持则进行下一步
        if (Desktop.isDesktopSupported()) {
            try {
                URI uri = new URI(url);
                // 创建desktop对象
                Desktop desktop = Desktop.getDesktop();
                // 调用默认浏览器打开指定URL
                desktop.browse(uri);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // 如果没有默认浏览器时，将引发下列异常
                e.printStackTrace();
            }
        }
    }
}