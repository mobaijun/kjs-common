package com.mobaijun.common.util.constant.enums.dict;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: DictTypeClassEnum
 * enum description：字典类型的分类枚举
 *
 * @author MoBaiJun 2022/5/12 14:06
 */
@Getter
public enum DictTypeClassEnum {
    /**
     * 业务类型
     */
    BUSINESS_TYPE(1),

    /**
     * 系统类型
     */
    SYSTEM_TYPE(2);

    private final Integer code;

    DictTypeClassEnum(Integer code) {
        this.code = code;
    }
}
