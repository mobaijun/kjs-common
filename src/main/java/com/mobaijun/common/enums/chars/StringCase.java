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
package com.mobaijun.common.enums.chars;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: StringCase<br>
 * enum description: 字符串大小写
 *
 * @author MoBaiJun 2023/2/21 23:56
 */
@Getter
@AllArgsConstructor
public enum StringCase {

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
     * Compares two strings using the case-sensitivity rule.
     *
     * <p>This method mimics {@link String#compareTo} but takes case-sensitivity into account.
     *
     * @param str1 the first string to compare, not null
     * @param str2 the second string to compare, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
     */
    public int checkCompareTo(String str1, String str2) {
        return isCaseSensitive() ? str1.compareTo(str2) : str1.compareToIgnoreCase(str2);
    }

    /**
     * Compares two strings using the case-sensitivity rule.
     *
     * <p>This method mimics {@link String#equals} but takes case-sensitivity into account.
     *
     * @param str1 the first string to compare, not null
     * @param str2 the second string to compare, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
     */
    public final boolean checkEquals(String str1, String str2) {
        return isCaseSensitive() ? str1.equals(str2) : str1.equalsIgnoreCase(str2);
    }

    /**
     * Checks if one string starts with another using the case-sensitivity rule.
     *
     * <p>This method mimics {@link String#startsWith(String)} but takes case-sensitivity into
     * account.
     *
     * @param str   the string to check, not null
     * @param start the start to compare against, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
     */
    public final boolean checkStartsWith(String str, String start) {
        return str.regionMatches(isIgnoredCase(), 0, start, 0, start.length());
    }

    /**
     * Checks if one string ends with another using the case-sensitivity rule.
     *
     * <p>This method mimics {@link String#endsWith} but takes case-sensitivity into account.
     *
     * @param str the string to check, not null
     * @param end the end to compare against, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
     */
    public final boolean checkEndsWith(String str, String end) {
        final int endLen = end.length();
        return str.regionMatches(isIgnoredCase(), str.length() - endLen, end, 0, endLen);
    }

    /**
     * Checks if one string contains another starting at a specific index using the case-sensitivity
     * rule.
     *
     * <p>This method mimics parts of {@link String#indexOf(String, int)} but takes case-sensitivity
     * into account.
     *
     * @param str           the string to check, not null
     * @param strStartIndex the index to start at in str
     * @param search        the start to search for, not null
     * @return the first index of the search String, -1 if no match or {@code null} string input
     * @throws NullPointerException if either string is null
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
     * Checks if one string contains another at a specific index using the case-sensitivity rule.
     *
     * <p>This method mimics parts of {@link String#regionMatches(boolean, int, String, int, int)} but
     * takes case-sensitivity into account.
     *
     * @param str           the string to check, not null
     * @param strStartIndex the index to start at in str
     * @param search        the start to search for, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
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
