package com.mobaijun.common.enums.sys;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [消息类型]
 * Author: [mobaijun]
 * Date: [2024/12/31 11:57]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@AllArgsConstructor
public enum MessageType {
    /**
     * 短信模板类型。
     */
    SMS("0"),

    /**
     * 邮件模板类型。
     */
    EMAIL("1"),

    /**
     * 微信模板类型。
     */
    WECHAT("2");

    /**
     * 整数值。
     */
    private final String value;

    /**
     * 根据整数值获取对应的模板类型。
     *
     * @param value 整数值。
     * @return 对应的模板类型，如果不存在对应的值，则返回null。
     */
    public static MessageType getValue(String value) {
        for (MessageType type : MessageType.values()) {
            if (Objects.equals(type.getValue(), value)) {
                return type;
            }
        }
        return null;
    }

    /**
     * 判断传入的值是否与指定的模板类型值相等。
     *
     * @param value 需要判断的整数值。
     * @param type  指定的模板类型。
     * @return 如果值相等，返回true，否则返回false。
     */
    public static boolean isType(String value, MessageType type) {
        return Objects.equals(type.getValue(), value);
    }
}
