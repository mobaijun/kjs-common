package com.mobaijun.common.enums.log;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: LogType
 * enum description： 日志类型
 *
 * @author MoBaiJun 2022/5/12 9:28
 */
@Getter
@AllArgsConstructor
public enum LogType {

    /**
     * 登录日志
     */
    LOGIN("登录日志"),

    /**
     * 登录失败日志
     */
    LOGIN_FAIL("登录失败日志"),

    /**
     * 退出日志
     */
    EXIT("退出日志"),

    /**
     * 异常日志
     */
    EXCEPTION("异常日志"),

    /**
     * 业务日志
     */
    BUSSINESS("业务日志");

    private final String message;
}
