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
package com.mobaijun.common.code;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: UnicodeUtils<br>
 * class description：Unicode 工具类
 *
 * @author MoBaiJun 2022/7/12 14:22
 */
public class UnicodeUtils {

    /**
     * 转义 Unicode 字符输出 emoji
     *
     * @param unicode 字符
     * @return char 数组
     */
    public static char[] converterCodePoints(String unicode) {
        return Character.toChars(Integer.valueOf(unicode.substring(2), 16));
    }
}