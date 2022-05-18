package com.mobaijun.common.enums.sms;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: SmsTypeEnum
 * enum description：
 *
 * @author MoBaiJun 2022/5/12 13:42
 */
@Getter
public enum SmsTypeEnum {
    /**
     * 验证类短信
     */
    SMS(1, "验证类短信"),

    /**
     * 纯发送短信
     */
    MESSAGE(2, "纯发送短信");

    private final Integer code;

    private final String message;

    SmsTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
