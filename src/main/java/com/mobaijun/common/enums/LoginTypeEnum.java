package com.mobaijun.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: LoginTypeEnum
 * enum description： 登录类型
 *
 * @author MoBaiJun 2022/10/28 10:04
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {

    /**
     * 账号密码登录
     */
    PWD("PWD", "账号密码登录"),

    /**
     * 验证码登录
     */
    SMS("SMS", "验证码登录");

    /**
     * 类型
     */
    private final String type;

    /**
     * 描述
     */
    private final String description;
}
