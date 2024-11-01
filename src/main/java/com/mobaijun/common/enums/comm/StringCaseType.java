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
package com.mobaijun.common.enums.comm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: StringCase<br>
 * enum description: 字符串大小写
 *
 * @author MoBaiJun 2023/2/21 23:56
 */
@Getter
@RequiredArgsConstructor
public enum StringCaseType {

    /**
     * 大小写敏感，默认大写
     */
    SENSITIVE_CASE_DEFAULT_UPPER(true, true),

    /**
     * 大小写不敏感，默认大写
     */
    INSENSITIVE_CASE_DEFAULT_UPPER(true, false),

    /**
     * 大小写敏感，默认小写
     */
    SENSITIVE_CASE_DEFAULT_LOWER(false, true),

    /**
     * 大小写不敏感，默认小写
     */
    INSENSITIVE_CASE_DEFAULT_LOWER(false, false);

    private final boolean defaultUpper;

    private final boolean ignoredCase;

    /**
     * 处理字符串大小写
     *
     * <p>根据{@code defaultUpper}值来处理后是大写还是小写 根据{@code ignoredCase}值来是否对字符进行处理
     *
     * @param str 字符串
     * @return 处理过后的字符串
     */
    public final String handleStringCase(String str) {
        return ignoredCase ? (defaultUpper ? str.toUpperCase() : str.toLowerCase()) : str;
    }

    /**
     * 比较两个字符串，考虑大小写敏感性规则。
     *
     * <p>此方法模仿 {@link String#compareTo}，但考虑了大小写敏感性。
     *
     * @param str1 第一个要比较的字符串，不能为null
     * @param str2 第二个要比较的字符串，不能为null
     * @return 如果使用大小写规则相等则返回true
     * @throws NullPointerException 如果任一字符串为null
     */
    public int checkCompareTo(String str1, String str2) {
        return isCaseSensitive() ? str1.compareTo(str2) : str1.compareToIgnoreCase(str2);
    }

    /**
     * 比较两个字符串，考虑大小写敏感性规则。
     *
     * <p>此方法模仿 {@link String#equals}，但考虑了大小写敏感性。
     *
     * @param str1 第一个要比较的字符串，不能为null
     * @param str2 第二个要比较的字符串，不能为null
     * @return 如果使用大小写规则相等则返回true
     * @throws NullPointerException 如果任一字符串为null
     */
    public final boolean checkEquals(String str1, String str2) {
        return isCaseSensitive() ? str1.equals(str2) : str1.equalsIgnoreCase(str2);
    }

    /**
     * 检查一个字符串是否以另一个字符串开头，考虑大小写敏感性规则。
     *
     * <p>此方法模仿 {@link String#startsWith(String)}，但考虑了大小写敏感性。
     *
     * @param str   要检查的字符串，不能为null
     * @param start 要比较的起始字符串，不能为null
     * @return 如果根据大小写规则相等则返回true
     * @throws NullPointerException 如果任一字符串为null
     */
    public final boolean checkStartsWith(String str, String start) {
        return str.regionMatches(isIgnoredCase(), 0, start, 0, start.length());
    }

    /**
     * 检查一个字符串是否以另一个字符串结尾，考虑大小写敏感性规则。
     *
     * <p>此方法模仿 {@link String#endsWith}，但考虑了大小写敏感性。
     *
     * @param str 要检查的字符串，不能为null
     * @param end 要比较的结束字符串，不能为null
     * @return 如果根据大小写规则相等则返回true
     * @throws NullPointerException 如果任一字符串为null
     */
    public final boolean checkEndsWith(String str, String end) {
        final int endLen = end.length();
        return str.regionMatches(isIgnoredCase(), str.length() - endLen, end, 0, endLen);
    }

    /**
     * 检查一个字符串是否包含另一个字符串，从指定索引开始，考虑大小写敏感性规则。
     *
     * <p>此方法模仿部分 {@link String#indexOf(String, int)}，但考虑了大小写敏感性。
     *
     * @param str           要检查的字符串，不能为null
     * @param strStartIndex 开始的索引
     * @param search        要搜索的字符串，不能为null
     * @return 搜索字符串的第一个索引，如果没有匹配则返回-1或{@code null}字符串输入
     * @throws NullPointerException 如果任一字符串为null
     */
    public final int checkIndexOf(String str, int strStartIndex, String search) {
        final int endIndex = str.length() - search.length();
        if (endIndex >= strStartIndex) {
            for (int i = strStartIndex; i <= endIndex; i++) {
                if (checkRegionMatches(str, i, search)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 检查一个字符串是否在另一个字符串的特定索引处包含，考虑大小写敏感性规则。
     *
     * <p>此方法模仿部分 {@link String#regionMatches(boolean, int, String, int, int)}，但考虑了大小写敏感性。
     *
     * @param str           要检查的字符串，不能为null
     * @param strStartIndex 开始的索引
     * @param search        要搜索的字符串，不能为null
     * @return 如果根据大小写规则相等则返回true
     * @throws NullPointerException 如果任一字符串为null
     */
    public final boolean checkRegionMatches(String str, int strStartIndex, String search) {
        return str.regionMatches(isIgnoredCase(), strStartIndex, search, 0, search.length());
    }

    /**
     * 是否忽略大小写
     *
     * @return true忽略否则false
     */
    public final boolean isIgnoredCase() {
        return this.ignoredCase;
    }

    /**
     * 是否大小写敏感
     *
     * @return true忽略否则false
     */
    public final boolean isCaseSensitive() {
        return !isIgnoredCase();
    }
}
