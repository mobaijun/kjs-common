package com.mobaijun.common.enums.client;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: SourceEnum
 * enum description：客户端类型枚举
 *
 * @author MoBaiJun 2022/5/12 13:41
 */
@Getter
public enum SourceEnum {
    /**
     * APP
     */
    APP(1),

    /**
     * PC
     */
    PC(2),

    /**
     * OTHER
     */
    OTHER(3);

    private final Integer code;

    SourceEnum(Integer code) {
        this.code = code;
    }
}
