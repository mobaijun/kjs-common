package com.mobaijun.common.util.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: Sex
 * enum description： 性别
 *
 * @author MoBaiJun 2022/5/11 11:36
 */
@Getter
@ToString
public enum Sex {

    /**
     * 男性
     */
    MAN(0, "男"),

    /**
     * 女性
     */
    WOMAN(1, "女");

    private final int code;
    private final String value;

    Sex(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
