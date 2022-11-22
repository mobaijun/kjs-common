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

import com.mobaijun.common.util.constant.StringConstant;
import com.mobaijun.common.util.regx.RegxConstant;

import java.util.regex.Matcher;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: NamingUtils
 * class description: 命名工具类
 *
 * @author MoBaiJun 2022/11/22 11:33
 */
public class NamingUtils {

    /**
     * 驼峰转中划线
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String humpToMidline(String name) {
        return getString(name);
    }

    /**
     * 驼峰转中划线
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String humpToUnderline(String name) {
        return getString(name);
    }

    private static String getString(String name) {
        if (StringUtils.isEmpty(name)) {
            return StringConstant.BLANK;
        }
        Matcher matcher = RegxConstant.HUMP_PATTERN.matcher(name);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, StringConstant.HIPHEN + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * 下划线转驼峰
     *
     * @param name 待转换的名称
     * @return 转换后的名称
     */
    public static String underlineToHump(String name) {
        if (StringUtils.isEmpty(name)) {
            return StringConstant.BLANK;
        }
        name = name.toLowerCase();
        Matcher matcher = RegxConstant.UNDERLINE_PATTERN.matcher(name);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}