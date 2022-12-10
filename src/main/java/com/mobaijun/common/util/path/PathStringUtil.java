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
package com.mobaijun.common.util.path;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: PathStringUtil
 * class description:有关路径的工具类
 *
 * @author MoBaiJun 2022/12/10 17:36
 */
public class PathStringUtil {

    /**
     * 格式化日期路径
     */
    private final static String PATTERN = String.format("yyyy%sMM%sdd", File.separatorChar, File.separatorChar);

    /**
     * 获取日期格式文件目录
     *
     * @return 日期路径
     */
    public static String createDateDir() {
        return createDateDir(LocalDate.now());
    }

    /**
     * 获取日期格式文件目录
     *
     * @param localDate LocalDate实例
     * @return 日期路径
     */
    public static String createDateDir(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(PATTERN));
    }
}