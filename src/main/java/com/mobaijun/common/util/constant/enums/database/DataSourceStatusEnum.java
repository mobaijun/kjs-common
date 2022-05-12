package com.mobaijun.common.util.constant.enums.database;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: DataSourceStatusEnum
 * enum description：数据库连接的状态枚举
 *
 * @author MoBaiJun 2022/5/12 13:15
 */
@Getter
public enum DataSourceStatusEnum {
    /**
     * 正常
     */
    ENABLE(1, "正常"),

    /**
     * 无法连接
     */
    ERROR(2, "无法连接");

    private final Integer code;

    private final String message;

    DataSourceStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
