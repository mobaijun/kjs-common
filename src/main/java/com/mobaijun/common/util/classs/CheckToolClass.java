package com.mobaijun.common.util.classs;

import cn.hutool.json.JSONUtil;
import com.mobaijun.common.util.ObjectUtils;
import com.mobaijun.common.util.StringUtils;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: CheckToolClass
 * class description：对象判断工具类
 *
 * @author MoBaiJun 2022/10/17 17:16
 */
public class CheckToolClass {

    /**
     * 参数是否为空的校验
     *
     * @param object  对象
     * @param message 消息
     */
    public static <T> void assertNotNull(T object, String message) {
        if (ObjectUtils.isEmpty(object)) {
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
    public static <T> void assertIsJsonArrayLegal(String json, String message) {
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
     * 判断条件是否符合
     *
     * @param condition 判断条件
     * @param message   消息
     */
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new NullPointerException(message);
        }
    }
}
