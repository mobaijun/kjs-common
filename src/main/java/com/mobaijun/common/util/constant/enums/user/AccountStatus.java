package com.mobaijun.common.util.constant.enums.user;

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

    private int code;
    private String message;

    AccountStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
