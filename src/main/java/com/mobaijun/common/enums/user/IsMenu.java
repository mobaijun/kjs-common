package com.mobaijun.common.enums.user;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: IsMenu
 * enum description： 是否是菜单
 *
 * @author MoBaiJun 2022/5/12 9:23
 */
@Getter
public enum IsMenu {

    YES(1, "是"),
    /**
     * 不是菜单的是按钮
     */
    NO(0, "不是");

    private final int code;
    private final String message;

    IsMenu(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
