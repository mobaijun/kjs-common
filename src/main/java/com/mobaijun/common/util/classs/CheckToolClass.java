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
package com.mobaijun.common.util.classs;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mobaijun.common.util.ObjectUtil;
import com.mobaijun.common.util.StringUtil;
import com.mobaijun.common.util.collection.CollectionUtil;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: CheckToolClass<br>
 * class description：校验工具类
 *
 * @author MoBaiJun 2022/10/17 17:16
 */
public class CheckToolClass {

    /**
     * 参数是否为空的校验
     *
     * @param data    数据
     * @param message 消息
     */
    public static <T> void assertNotNull(T data, String message) {
        if (ObjectUtil.isEmpty(data)) {
            throw new NullPointerException(message);
        }
    }

    /**
     * json 数组是否合法的校验{是否为JSONObject类型字符串，首尾都为大括号判定为JSONObject字符串}，
     * 本方法不全面，但会在 json 解析是自动校验
     *
     * @param json    json 字符串
     * @param message 消息
     */
    public static void assertIsJsonArrayLegal(String json, String message) {
        if (!JSONUtil.isTypeJSONArray(json)) {
            throw new ArrayIndexOutOfBoundsException(message);
        }
    }

    /**
     * json 是否合法的校验{是否为JSONObject类型字符串，首尾都为大括号判定为JSONObject字符串}，
     * 本方法不全面，但会在 json 解析是自动校验
     *
     * @param json    json 字符串
     * @param message 消息
     */
    public static void assertIsJsonLegal(String json, String message) {
        if (!JSONUtil.isTypeJSONObject(json)) {
            throw new ArrayIndexOutOfBoundsException(message);
        }
    }

    /**
     * 参数是否为空的校验
     *
     * @param str     字符串
     * @param message 消息
     */
    public static void assertNotEmpty(String str, String message) {
        if (StringUtil.isEmpty(str)) {
            throw new NullPointerException(message);
        }
    }

    /**
     * 判断条件是否不符合
     *
     * @param condition 判断条件
     * @param message   消息
     */
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new NullPointerException(message);
        }
    }

    /**
     * 集合是否为 null,返回空集合
     */
    public static <T> Collection<T> assertListIsNull(Collection<T> list) {
        if (CollectionUtil.isEmpty(list)) {
            return CollectionUtil.newArrayList();
        }
        return list;
    }

    /**
     * 校验 json 格式是否正确，严格模式
     *
     * @param json json 字符串
     * @return 是否正确
     */
    private static boolean assertIfJsonIsLegal(String json) {
        if (StringUtil.isEmpty(json)) {
            return false;
        }
        Object parse;
        try {
            parse = JSONUtil.parse(json);
        } catch (JSONException e) {
            return false;
        }
        return parse instanceof JSONObject || parse instanceof JSONArray;
    }

    /**
     * 校验 json 是否合法 严格模式
     *
     * @param json    json 字符串
     * @param message 返回内容
     */
    public static void assertIsJsonLegals(String json, String message) {
        if (assertIfJsonIsLegal(json)) {
            throw new ArrayIndexOutOfBoundsException(message);
        }
    }

    /**
     * 判断 map 是否为 null ，返回空 map
     *
     * @param map map集合
     * @param <K> 键
     * @param <V> 值
     * @return map
     */
    public static <K, V> Map<K, V> assertIsMapNull(Map<K, V> map) {
        if (CollectionUtil.isEmpty(map)) {
            return CollectionUtil.newHashMap(10);
        }
        return map;
    }

    /**
     * 断言不为空
     *
     * @param object 对象
     * @param name   对象名称
     */
    public static void notNull(Object object, String name) {
        if (null == object) {
            throw new IllegalArgumentException(name + " can not be null!");
        }
    }

    /**
     * 不可为空
     *
     * @param object 对象
     * @param name   对象名称
     * @param errMsg 错误描述
     */
    public static void notNull(Object object, String name, String errMsg) {
        if (null == object) {
            String errorInfo = String.format("%s %s", name, errMsg);
            throw new IllegalArgumentException(errorInfo);
        }
    }

    /**
     * 校验字符串非空
     *
     * @param string 待检查的字符串
     * @param name   字符串的名称
     */
    public static void notEmpty(String string, String name) {
        if (StringUtil.isEmpty(string)) {
            throw new IllegalArgumentException(name + " can not be null!");
        }
    }

    /**
     * 断言: real 与 except 相等
     *
     * @param except 期望值
     * @param real   实际值
     * @param msg    错误消息
     */
    public static void equals(Object except, Object real, String msg) {
        if (except.equals(real)) {
            String errorMsg = buildErrorMsg(except, real, msg);
            throw new IllegalArgumentException(errorMsg);
        }
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
    public static void assertEqualsLen(String string,
                                       int len,
                                       String desc) {
        if (isNotEqualsLen(string, len)) {
            String errorMsg = buildErrorMsg(len, string.length(), desc);
            throw new IllegalArgumentException(errorMsg);
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
    public static boolean isEqualsLen(String string, int len) {
        if (StringUtil.isEmpty(string)) {
            return 0 == len;
        }

        return string.length() == len;
    }

    /**
     * 指定长度是否不等于某个值
     *
     * @param string 字符串
     * @param len    期望长度
     * @return {@code true} 是
     */
    public static boolean isNotEqualsLen(String string, int len) {
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
    public static boolean isFitMaxLen(String string, int maxLen) {
        if (StringUtil.isEmpty(string)) {
            return 0 <= maxLen;
        }
        return string.length() <= maxLen;
    }

    /**
     * 字符串是否不满足最大长度
     *
     * @param string 字符串
     * @param maxLen 最大长度
     * @return {@code true} 是
     */
    public static boolean isNotFitMaxLen(String string, int maxLen) {
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
    public static boolean isFitMinLen(String string, int minLen) {
        if (StringUtil.isEmpty(string)) {
            return 0 >= minLen;
        }
        return string.length() >= minLen;
    }

    /**
     * 不满足最小长度
     *
     * @param string 字符串
     * @param minLen 最小长度
     * @return {@code true} 是
     */
    public static boolean isNotFitMinLen(String string, int minLen) {
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
    public static Boolean isNumber(String number) {
        if (ObjectUtil.isNotNull(number)) {
            try {
                new BigDecimal(number);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    /**
     * 不是一个数字
     *
     * @param number 数字字符串
     * @return {@code true} 是
     */
    public static Boolean isNotNumber(String number) {
        return !isNumber(number);
    }


    /**
     * 字符串是否满足正则表达式。
     *
     * @param string 字符串
     * @param regex  正则表达式
     * @return {@code true} 是
     */
    public static Boolean isMatchesRegex(String string, String regex) {
        if (null != string) {
            return string.matches(regex);
        }
        return true;
    }

    /**
     * 字符串是否不满足正则表达式。
     *
     * @param string 字符串
     * @param regex  正则表达式
     * @return {@code true} 是
     */
    public static Boolean isNotMatchesRegex(String string, String regex) {
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
    private static String buildErrorMsg(Object except, Object real, String msg) {
        String resultMsg = msg;
        if (StringUtil.isEmpty(resultMsg)) {
            resultMsg = "与期望值不符合!";
        }
        return String.format("Except:<%s>, Real:<%s>, Msg:<%s>", except, real, resultMsg);
    }

    /**
     * 断言为正整数
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void positive(final int number, final String paramName) {
        if (number <= 0) {
            throw new IllegalArgumentException(paramName + " must be > 0!");
        }
    }

    /**
     * 断言为非负整数
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void notNegative(final int number, final String paramName) {
        if (number < 0) {
            throw new IllegalArgumentException(paramName + " must be >= 0!");
        }
    }

    /**
     * 断言为长正整数
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void positive(final long number, final String paramName) {
        if (number <= 0) {
            throw new IllegalArgumentException(paramName + " must be > 0!");
        }
    }

    /**
     * 断言为非负长整数
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void notNegative(final long number, final String paramName) {
        if (number < 0) {
            throw new IllegalArgumentException(paramName + " must be >= 0!");
        }
    }

    /**
     * 断言为正 double
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void positive(final double number, final String paramName) {
        if (number < 0) {
            throw new IllegalArgumentException(paramName + " must be > 0!");
        }
    }

    /**
     * 断言为非负 double
     *
     * @param number    入参
     * @param paramName 参数名称
     */
    public static void notNegative(final double number, final String paramName) {
        if (number < 0) {
            throw new IllegalArgumentException(paramName + " must be >= 0!");
        }
    }

    /**
     * 断言为 false
     *
     * @param condition 结果
     * @param name      参数名称
     */
    public static void assertFalse(boolean condition,
                                   final String name) {
        if (condition) {
            throw new IllegalArgumentException(name + " excepted false but is true!");
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
        if (CollectionUtil.isEmpty(array)) {
            throw new IllegalArgumentException(name + " excepted is not empty!");
        }

        for (Object object : array) {
            notNull(object, name + " element ");
        }
    }

    /**
     * 禁止为空，并且判断其中元素不准为空
     *
     * @param collection 集合
     * @param name       名称
     */
    public static void notEmpty(final Collection<?> collection,
                                final String name) {
        if (CollectionUtil.isEmpty(collection)) {
            throw new IllegalArgumentException(name + " excepted is not empty!");
        }

        for (Object object : collection) {
            notNull(object, name + " element ");
        }
    }

    /**
     * 必须大于指定的值
     *
     * @param actual   确切的值
     * @param expected 预期值
     */
    @Deprecated
    public static void gt(final long actual,
                          final long expected) {
        gt("", actual, expected);
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
        if (actual > expected) {
            return;
        }

        throw new IllegalArgumentException("[" + paramName + "] actual is <" + actual + ">" + ", expected is gt " + expected);
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

        throw new IllegalArgumentException("[" + paramName + "] actual is <" + actual + ">" + ", expected is gte " + expected);
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

        throw new IllegalArgumentException("[" + paramName + "] actual is <" + actual + ">" + ", expected is lt " + expected);
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

        throw new IllegalArgumentException("[" + paramName + "] actual is <" + actual + ">" + ", expected is lte " + expected);
    }
}