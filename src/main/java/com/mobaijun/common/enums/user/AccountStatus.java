package com.mobaijun.common.enums.user;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: AccountStatus
 * enum description： 账号状态
 *
 * @author MoBaiJun 2022/5/12 9:20
 */
@Getter
public enum AccountStatus {

    OK(1, "启用"),
    FREEZE(2, "冻结"),
    DELETED(-1, "被删除");

    private final int code;
    private final String message;

    AccountStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
