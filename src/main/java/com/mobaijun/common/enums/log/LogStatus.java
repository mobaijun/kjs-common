package com.mobaijun.common.enums.log;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: LogStatus
 * enum description： 日志记录是否登录成功
 *
 * @author MoBaiJun 2022/5/12 9:27
 */
@Getter
@AllArgsConstructor
public enum LogStatus {

    /**
     * 未知
     */
    OTHER("未知"),

    /**
     * 成功
     */
    SUCCESS("成功"),

    /**
     * 失败
     */
    FAIL("失败");

    private final String message;
}
