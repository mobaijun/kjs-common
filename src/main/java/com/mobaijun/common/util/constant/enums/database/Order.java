package com.mobaijun.common.util.constant.enums.database;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: Order
 * enum description： 排序
 *
 * @author MoBaiJun 2022/5/12 9:31
 */
@Getter
@AllArgsConstructor
public enum Order {

    /**
     * 升序
     */
    ASC("asc"),

    /**
     * 倒序
     */
    DESC("desc");

    private final String des;
}
