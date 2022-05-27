package com.mobaijun.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: BooleanEnum
 * description: BooleanEnum 枚举类型
 *
 * @author 2022/5/21 16:56 url:<a href="https://www.mobaijun.com">...</a>
 */
@Getter
@AllArgsConstructor
public enum BooleanEnum {

    /**
     * 否
     */
    FALSE(0),

    /**
     * 是
     */
    TRUE(1);

    private final int code;
}
