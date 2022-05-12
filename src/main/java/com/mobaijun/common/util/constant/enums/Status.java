package com.mobaijun.common.util.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * EnumName: Status
 * 枚举描述： 通用状态字段
 *
 * @author MoBaiJun 2022/4/25 14:43
 */
@Getter
@AllArgsConstructor
public enum Status {

    /**
     * 成功
     */
    OK(200, "OK"),

    /**
     * 异常
     */
    ERROR(500, "ERROR"),

    /**
     * 未删除
     */
    NOT_DELETED(0, "未删除"),

    /**
     * 已删除
     */
    DELETED(1, "已删除"),

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 失败
     */
    FAIL(1, "失败");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 值
     */
    private final String value;
}
