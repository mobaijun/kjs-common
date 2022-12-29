package com.mobaijun.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: SensitiveTypeEnum<br>
 * enum description: 脱敏类型<br>
 *
 * @author MoBaiJun 2022/12/29 11:13
 */
@Getter
@AllArgsConstructor
public enum SensitiveTypeEnum {

    /**
     * 中文名
     */
    CHINESE_NAME,

    /**
     * 身份证号
     */
    ID_CARD,

    /**
     * 座机号
     */
    FIXED_PHONE,

    /**
     * 手机号
     */
    MOBILE_PHONE,

    /**
     * 地址
     */
    ADDRESS,

    /**
     * 电子邮件
     */
    EMAIL,

    /**
     * 银行卡
     */
    BANK_CARD,

    /**
     * 公司开户银行联号
     */
    CAPS_CODE
}
