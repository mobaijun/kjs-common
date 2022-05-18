package com.mobaijun.common.enums.user;

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
public enum SexEnum {

    /**
     * 男
     */
    M("M", "男"),

    /**
     * 女
     */
    F("F", "女");

    private final String code;

    private final String message;

    SexEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据code获取枚举
     *
     * @param code String
     * @return SexEnum
     */
    public static SexEnum codeToEnum(String code) {
        if (null != code) {
            for (SexEnum e : SexEnum.values()) {
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * 编码转化成中文含义
     *
     * @param code String
     * @return String
     */
    public static String codeToMessage(String code) {
        if (null != code) {
            for (SexEnum e : SexEnum.values()) {
                if (e.getCode().equals(code)) {
                    return e.getMessage();
                }
            }
        }
        return "未知";
    }
}
