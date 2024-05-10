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
package com.mobaijun.common.system;

import java.io.File;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: [OSUtil工具类提供了一些操作系统相关的方法。]
 * Author: [mobaijun]
 * Date: [2024/3/19 8:55]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Slf4j
public class OsUtil {

    private static final String OS_NAME = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);

    /**
     * 检查操作系统是否是Windows。
     *
     * @return 如果操作系统是Windows，则返回true，否则返回false。
     */
    public static boolean isWindows() {
        return OS_NAME.contains("windows");
    }

    /**
     * 检查操作系统是否是Linux。
     *
     * @return 如果操作系统是Linux，则返回true，否则返回false。
     */
    public static boolean isLinux() {
        return OS_NAME.contains("linux");
    }

    /**
     * 检查操作系统是否是Mac OS X。
     *
     * @return 如果操作系统是Mac OS X，则返回true，否则返回false。
     */
    public static boolean isMac() {
        return OS_NAME.contains("mac");
    }

    /**
     * 获取操作系统名称。
     *
     * @return 返回操作系统名称。
     */
    public static String getOSName() {
        return OS_NAME;
    }

    /**
     * 获取操作系统架构。
     *
     * @return 返回操作系统架构。
     */
    public static String getOSArch() {
        return System.getProperty("os.arch");
    }

    /**
     * 获取操作系统版本。
     *
     * @return 返回操作系统版本。
     */
    public static String getOSVersion() {
        return System.getProperty("os.version");
    }

    /**
     * 获取操作系统临时目录。
     *
     * @return 返回操作系统临时目录路径。
     */
    public static String getTempDirectory() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     * 获取用户的主目录。
     *
     * @return 返回用户的主目录路径。
     */
    public static String getUserHomeDirectory() {
        return System.getProperty("user.home");
    }

    /**
     * 获取用户的当前工作目录。
     *
     * @return 返回用户的当前工作目录路径。
     */
    public static String getUserWorkingDirectory() {
        return System.getProperty("user.dir");
    }

    /**
     * 在操作系统默认浏览器中打开指定的URL。
     *
     * @param url 要打开的URL。
     * @return 如果成功打开URL，则返回true，否则返回false。
     */
    public static boolean openURLInDefaultBrowser(String url) {
        try {
            if (isWindows()) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (isMac()) {
                Runtime.getRuntime().exec("open " + url);
            } else if (isLinux()) {
                Runtime.getRuntime().exec("xdg-open " + url);
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            log.error("An error occurred while opening the URL: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 获取操作系统分隔符。
     *
     * @return 返回操作系统文件路径中的分隔符。
     */
    public static String getFileSeparator() {
        return File.separator;
    }
}
