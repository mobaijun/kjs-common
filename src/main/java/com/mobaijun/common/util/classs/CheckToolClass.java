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
import com.mobaijun.common.util.ObjectUtils;
import com.mobaijun.common.util.StringUtils;
import com.mobaijun.common.util.collection.CollectionUtils;

import java.util.Collection;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: CheckToolClass<br>
 * class description：对象判断工具类
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
        if (ObjectUtils.isEmpty(data)) {
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
        if (StringUtils.isEmpty(str)) {
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
        if (CollectionUtils.isEmpty(list)) {
            return CollectionUtils.newArrayList();
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
        if (StringUtils.isEmpty(json)) {
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
}