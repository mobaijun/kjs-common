package com.mobaijun.common.util.constant.enums.sms;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: SendStatusEnum
 * enum description：消息发送状态
 *
 * @author MoBaiJun 2022/5/12 13:41
 */
@Getter
public enum SendStatusEnum {
    /**
     * 未发送
     */
    WAITING(0, "未发送"),

    /**
     * 发送成功
     */
    SUCCESS(1, "发送成功"),

    /**
     * 发送失败
     */
    FAILED(2, "发送失败"),

    /**
     * 失效
     */
    INVALID(3, "失效");

    private final Integer code;

    private final String message;

    SendStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
