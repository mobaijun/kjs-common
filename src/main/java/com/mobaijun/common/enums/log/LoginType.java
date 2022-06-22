package com.mobaijun.common.enums.log;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: LoginType
 * enum description： 登录类型
 *
 * @author MoBaiJun 2022/5/12 9:26
 */
@Getter
public enum LoginType {

    /**
     * 其他
     */
    OTHER(0, "Other"),

    /**
     * 平台
     */
    PORTAL(1, "Portal");

    private final int code;
    private final String name;

    LoginType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
