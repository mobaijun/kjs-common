package com.mobaijun.common.enums.dict;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: DictTypeEnum
 * enum description： 字典类型枚举
 *
 * @author MoBaiJun 2022/5/12 14:11
 */
@Getter
public enum DictTypeEnum {
    /**
     * 字符串类型
     */
    STRING("string", "字符串类型"),

    /**
     * 文件类型
     */
    FILE("file", "文件类型");

    private final String code;

    private final String message;

    DictTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
