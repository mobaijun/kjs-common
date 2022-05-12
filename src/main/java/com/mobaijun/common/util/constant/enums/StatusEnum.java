package com.mobaijun.common.util.constant.enums;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: StatusEnum
 * enum description： 公共状态，一般用来表示开启和关闭
 *
 * @author MoBaiJun 2022/5/12 11:21
 */
@Getter
public enum StatusEnum {
    /**
     * 启用
     */
    ENABLE(1, "启用"),

    /**
     * 禁用
     */
    DISABLE(2, "禁用");

    private final Integer code;

    private final String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
