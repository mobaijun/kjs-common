package com.mobaijun.common.enums.user;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: OnlineStatus
 * enum description： 用户状态
 *
 * @author MoBaiJun 2022/5/12 9:19
 */
@Getter
public enum OnlineStatus {

    ON_LINE("在线"),
    OFF_LINE("离线");

    private final String info;

    OnlineStatus(String info) {
        this.info = info;
    }
}
