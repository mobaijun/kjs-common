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
package com.mobaijun.common.assertions;

import com.mobaijun.common.util.StringUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: AssertChain<br>
 * class description: 断言工具类
 *
 * @author MoBaiJun 2023/3/11 11:50
 */
public class Assert {

    /**
     * 如果条件为 false，抛出一个 AssertionError，消息为 message。
     *
     * @param condition 条件
     * @param message   消息
     */
    public static void assertTrue(final boolean condition,
                                  final String message) {
        Optional.of(condition)
                .filter(c -> !c)
                .ifPresent(c -> {
                    throw new AssertionError(message);
                });
    }

    /**
     * 如果输入的集合为 null，则返回一个空集合；否则，返回输入的集合。
     *
     * @param collection 输入的集合
     * @param <T>        集合元素的类型
     * @return 输入的集合或空集合（如果输入的集合为 null）
     */
    public static <T> Collection<T> nullToEmptyCollection(final Collection<T> collection) {
        return Optional.ofNullable(collection)
                .orElseGet(Collections::emptyList);
    }

    /**
     * 如果输入的 Map 为 null，则返回一个空的 Map；否则，返回输入的 Map。
     *
     * @param map 输入的 Map
     * @param <K> Map 的键的类型
     * @param <V> Map 的值的类型
     * @return 输入的 Map 或空的 Map（如果输入的 Map 为 null）
     */
    public static <K, V> Map<K, V> nullToEmptyMap(final Map<K, V> map) {
        return Optional.ofNullable(map)
                .orElseGet(Collections::emptyMap);
    }

    /**
     * 确保对象不为空，否则抛出异常
     *
     * @param object 要判断的对象
     * @param name   对象名称
     * @throws AssertionError 如果对象为空，则抛出异常，包含错误信息和对象名
     */
    public static void notNull(final Object object,
                               final String name) {
        Optional.ofNullable(object)
                .orElseThrow(() -> new AssertionError(String.format("%s", name)));
    }

    /**
     * 确保对象不为空，否则抛出异常
     *
     * @param object 要判断的对象
     * @param name   对象名称
     * @param errMsg 错误信息
     * @throws AssertionError 如果对象为空，则抛出异常，包含错误信息和对象名
     */
    public static void notNull(final Object object,
                               final String name,
                               final String errMsg) {
        Optional.ofNullable(object)
                .orElseThrow(() -> new AssertionError(String.format("%s %s", name, errMsg)));
    }

    /**
     * 校验字符串非空
     *
     * @param string 待检查的字符串
     * @param name   字符串的名称
     */
    public static void notEmpty(final String string,
                                final String name) {
        if (string == null || string.trim().isEmpty()) {
            throw new AssertionError(name + " can not be null!");
        }
    }

    /**
     * 断言两个对象相等
     *
     * @param expected 期望值
     * @param actual   实际值
     * @param message  错误消息
     */
    public static void assertEquals(final Object expected,
                                    final Object actual,
                                    final String message) {
        Optional.of(expected.equals(actual))
                .filter(b -> !b)
                .ifPresent(b -> {
                    throw new AssertionError(buildErrorMsg(expected, actual, message));
                });
    }


    /**
     * 断言指定长度是否等于某个值
     * 1.空值校验则认为长度为0；
     * 2.想对空值校验,请使用判断非空。
     *
     * @param string 字符串
     * @param len    期望长度
     * @param desc   描述
     * @since 0.1.157
     */
    public static void assertEqualsLen(final String string,
                                       final int len,
                                       final String desc) {
        if (isNotEqualsLen(string, len)) {
            String errorMsg = buildErrorMsg(len, string.length(), desc);
            throw new AssertionError(errorMsg);
        }
    }


    /**
     * 指定长度是否等于某个值
     * 1.空值校验则认为长度为0；
     * 2.想对空值校验,请使用判断非空。
     *
     * @param string 字符串
     * @param len    期望长度
     * @return {@code true} 是
     */
    public static boolean isEqualsLen(final String string,
                                      final int len) {
        return Optional.ofNullable(string)
                .map(s -> s.isEmpty() ? "" : s)
                .filter(s -> s.length() == len)
                .isPresent();
    }

    /**
     * 指定长度是否不等于某个值
     *
     * @param string 字符串
     * @param len    期望长度
     * @return {@code true} 是
     */
    public static boolean isNotEqualsLen(final String string,
                                         final int len) {
        return !isEqualsLen(string, len);
    }

    /**
     * 字符串是否满足最大长度
     * 1. 认为 null 字段长度为 0
     * 2. 比较校验
     *
     * @param string 字符串
     * @param maxLen 最大长度
     * @return {@code true} 是
     */
    public static boolean isFitMaxLen(final String string,
                                      final int maxLen) {
        return string == null ? maxLen >= 0 : string.length() <= maxLen;
    }

    /**
     * 字符串是否不满足最大长度
     *
     * @param string 字符串
     * @param maxLen 最大长度
     * @return {@code true} 是
     */
    public static boolean isNotFitMaxLen(final String string,
                                         final int maxLen) {
        return !isFitMaxLen(string, maxLen);
    }


    /**
     * 满足最小长度
     * 1. 如果为 null，则认为长度为0
     *
     * @param string 字符串
     * @param minLen 最小长度
     * @return {@code true} 是
     */
    public static boolean isFitMinLen(final String string,
                                      final int minLen) {
        return Optional.ofNullable(string)
                .map(str -> str.length() >= minLen)
                .orElse(0 >= minLen);
    }


    /**
     * 不满足最小长度
     *
     * @param string 字符串
     * @param minLen 最小长度
     * @return {@code true} 是
     */
    public static boolean isNotFitMinLen(final String string,
                                         final int minLen) {
        return !isFitMinLen(string, minLen);
    }

    /**
     * 校验字符串是否满足全是数字
     * 1. null 值通过
     * 2.
     *
     * @param number 数字字符串
     * @return {@code true} 是
     */
    public static boolean isNumber(final String number) {
        if (StringUtil.isEmpty(number)) {
            return true;
        }
        return number.matches("\\d+");
    }

    /**
     * 不是一个数字
     *
     * @param number 数字字符串
     * @return {@code true} 是
     */
    public static Boolean isNotNumber(final String number) {
        return !isNumber(number);
    }

    /**
     * 字符串是否满足正则表达式。
     *
     * @param string 字符串
     * @param regex  正则表达式
     * @return {@code true} 是
     */
    public static boolean isMatchesRegex(final String string,
                                         final String regex) {
        return Optional.ofNullable(string)
                .map(s -> s.matches(regex))
                .orElse(true);
    }

    /**
     * 字符串是否不满足正则表达式。
     *
     * @param string 字符串
     * @param regex  正则表达式
     * @return {@code true} 是
     */
    public static Boolean isNotMatchesRegex(final String string,
                                            final String regex) {
        return !isMatchesRegex(string, regex);
    }

    /**
     * 构建错误提示消息
     *
     * @param except 期望值
     * @param real   实际值
     * @param msg    错误信息
     * @return 错误提示消息
     */
    private static String buildErrorMsg(final Object except,
                                        final Object real,
                                        final String msg) {
        return String.format("Except:<%s>, Real:<%s>, Msg:<%s>",
                except, real, Optional.ofNullable(msg).orElse("Not meeting expectations!"));
    }

    /**
     * 断言为正整数
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void positive(final int number,
                                final String paramName) {
        Optional.of(number)
                .filter(n -> n > 0)
                .orElseThrow(() -> new AssertionError(paramName + " must be > 0!"));
    }

    /**
     * 断言为非负整数
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void notNegative(final int number,
                                   final String paramName) {
        Optional.of(number)
                .filter(n -> n < 0).orElseThrow(() -> new AssertionError(
                        paramName + " must be >= 0!"
                ));
    }

    /**
     * 断言为长正整数
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void positive(final long number,
                                final String paramName) {
        Optional.of(number).filter(n -> n <= 0)
                .orElseThrow(() -> new AssertionError(paramName + " must be > 0!"));
    }

    /**
     * 断言为非负长整数
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void notNegative(final long number,
                                   final String paramName) {
        Optional.of(number)
                .filter(n -> n < 0)
                .orElseThrow(() -> new AssertionError(paramName + " must be >= 0!"));
    }

    /**
     * 断言为正 double
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void positive(final double number,
                                final String paramName) {
        Optional.of(number)
                .filter(n -> n < 0)
                .orElseThrow(() -> new AssertionError(paramName + " must be > 0!"));
    }

    /**
     * 断言为非负 double
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void notNegative(final double number,
                                   final String paramName) {
        Optional.of(number)
                .filter(n -> n < 0)
                .orElseThrow(() -> new AssertionError(paramName + " must be >= 0!"));
    }

    /**
     * 断言为 false
     *
     * @param condition 结果
     * @param name      参数名称
     */
    public static void assertFalse(final boolean condition,
                                   final String name) {
        if (condition) {
            throw new AssertionError(String.format("%s excepted false but is true!", name));
        }
    }

    /**
     * 禁止为空，并且判断其中元素不准为空
     *
     * @param array 数组
     * @param name  名称
     */
    public static void notEmpty(final Object[] array,
                                final String name) {
        if (Arrays.stream(array).noneMatch(Objects::nonNull)) {
            throw new AssertionError(name + " expected is not empty!");
        }

        Arrays.stream(array).forEach(obj -> notNull(obj, name + " element "));
    }


    /**
     * 禁止为空，并且判断其中元素不准为空
     *
     * @param collection 集合
     * @param name       名称
     */
    public static <T> void notEmpty(final Collection<T> collection,
                                    final String name) {
        if (collection.isEmpty()) {
            throw new AssertionError(name + " excepted is not empty!");
        }
        collection.forEach(object -> notNull(object, name + " element "));
    }


    /**
     * 必须大于指定的值
     *
     * @param paramName 参数名称
     * @param actual    确切的值
     * @param expected  预期值
     */
    public static void gt(final String paramName,
                          final long actual,
                          final long expected) {
        Optional.ofNullable(paramName)
                .filter(name -> actual <= expected)
                .ifPresent(name -> {
                    throw new AssertionError("[" + name + "] actual is <" + actual + ">" + ", expected is gt " + expected);
                });
    }

    /**
     * 必须大于等于指定的值
     *
     * @param paramName 参数名称
     * @param actual    确切的值
     * @param expected  预期值
     */
    public static void gte(final String paramName,
                           final long actual,
                           final long expected) {
        if (actual >= expected) {
            return;
        }

        throw new AssertionError("[" + paramName + "] actual is <" + actual + ">" + ", expected is gte " + expected);
    }

    /**
     * 必须小于指定的值
     *
     * @param paramName 参数名称
     * @param actual    确切的值
     * @param expected  预期值
     */
    public static void lt(final String paramName,
                          final long actual,
                          final long expected) {
        if (actual < expected) {
            return;
        }

        throw new AssertionError("[" + paramName + "] actual is <" + actual + ">" + ", expected is lt " + expected);
    }

    /**
     * 必须小于等于指定的值
     *
     * @param paramName 参数名称
     * @param actual    确切的值
     * @param expected  预期值
     */
    public static void lte(final String paramName,
                           final long actual,
                           final long expected) {
        if (actual <= expected) {
            return;
        }
        throw new AssertionError("[" + paramName + "] actual is <" + actual + ">" + ", expected is lte " + expected);
    }
}
