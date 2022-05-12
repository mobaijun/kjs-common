package com.mobaijun.common.util.constant.enums.http;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: FieldMetadataTypeEnum
 * enum description：字段元数据类型
 *
 * @author MoBaiJun 2022/5/12 13:28
 */
@Getter
public enum FieldMetadataTypeEnum {
    /**
     * 字段
     */
    FIELD(1),

    /**
     * 泛型
     */
    GENERIC(2);

    FieldMetadataTypeEnum(Integer code) {
        this.code = code;
    }

    private final Integer code;
}
