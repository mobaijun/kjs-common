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
package com.mobaijun.common.constant;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: Constant
 * 类描述： 通用常量
 *
 * @author MoBaiJun 2022/5/5 9:01
 */
public class Constant {

    /**
     * UTF_8 编码
     * 推荐使用：{@link java.nio.charset.StandardCharsets}
     */
    @Deprecated
    public static final String UTF_8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * MD5
     */
    public static final String MD5 = "MD5";

    /**
     * 正则
     */
    public static final String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+";

    /**
     * 大写十六进制数
     */
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 小写十六进制
     */
    public static final char[] HEX_DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 接口文档的菜单名
     */
    public static final String API_MENU_NAME = "接口文档";
}