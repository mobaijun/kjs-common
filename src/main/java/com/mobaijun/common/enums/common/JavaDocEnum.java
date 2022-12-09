package com.mobaijun.common.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: JavaDocEnum<br>
 * enum description: Java 注释常量<br>
 *
 * @author MoBaiJun 2022/12/9 15:23
 */
@Getter
@AllArgsConstructor
public enum JavaDocEnum {

    /**
     * 注释前缀
     */
    COMMENT_PREFIX("/**", "注释前缀"),

    /**
     * 注释后缀
     */
    COMMENT_SUFFIX("*/", "注释后缀"),

    /**
     * 换行
     */
    COMMENT_RETURN("\n", "换行");

    private final String name;

    private final String desc;
}
