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
package com.mobaijun.common.common;

import java.util.regex.Pattern;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: CommonPattern<br>
 * class description: 公共正则匹配器
 *
 * @author MoBaiJun 2022/11/23 13:44
 */
public final class CommonPattern {

    /**
     * 左括号
     */
    public static final Pattern LEFT_ROUND_BRACES = Pattern.compile("\\(");

    /**
     * 右括号
     */
    public static final Pattern RIGHT_ROUND_BRACES = Pattern.compile("\\)");

    /**
     * 左括号
     */
    public static final Pattern LEFT_SQUARE_BRACES = Pattern.compile("\\[");

    /**
     * 右括号
     */
    public static final Pattern RIGHT_SQUARE_BRACES = Pattern.compile("]");

    /**
     * 左大括号
     */
    public static final Pattern LEFT_CURLY_BRACES = Pattern.compile("\\{");

    /**
     * 右大括号
     */
    public static final Pattern RIGHT_CURLY_BRACES = Pattern.compile("}");

    /**
     * 双引号
     */
    public static final Pattern DOUBLE_QUOTATION_MARK = Pattern.compile("\"");

    /**
     * 冒号
     */
    public static final Pattern COLON = Pattern.compile(":");

    /**
     * 左方括号
     */
    public static final Pattern LEFT_SQUARE_BRACKET = Pattern.compile("\\[");

    /**
     * 右方括号
     */
    public static final Pattern RIGHT_SQUARE_BRACKET = Pattern.compile("]");

    /**
     * 逗号
     */
    public static final Pattern COMMA = Pattern.compile(",");

    /**
     * 点
     */
    public static final Pattern DOT = Pattern.compile("\\.");

    /**
     * 问号
     */
    public static final Pattern QUESTION_MARK = Pattern.compile("\\?");

    /**
     * 加号
     */
    public static final Pattern PLUS_SIGN = Pattern.compile("\\+");

    /**
     * 星号
     */
    public static final Pattern ASTERISK = Pattern.compile("\\*");

    /**
     * 竖线
     */
    public static final Pattern VERTICAL_BAR = Pattern.compile("\\|");

    /**
     * 抑扬符
     */
    public static final Pattern CIRCUMFLEX = Pattern.compile("\\^");

    /**
     * 美元符号
     */
    public static final Pattern DOLLAR_SIGN = Pattern.compile("\\$");

    /**
     * 斜杠
     */
    public static final Pattern SLASH = Pattern.compile("/");

    /**
     * 反斜杠
     */
    public static final Pattern BACKSLASH = Pattern.compile("\\\\");

    /**
     * 单个汉字
     */
    public static final Pattern SINGLE_CHINESE_CHAR = Pattern.compile("[\u4e00-\u9fa5]");

    /**
     * 一个以上汉字
     */
    public static final Pattern MULTIPLE_CHINESE_CHAR = Pattern.compile("[\u4e00-\u9fa5]+");
}
