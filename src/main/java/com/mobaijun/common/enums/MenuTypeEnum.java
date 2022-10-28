package com.mobaijun.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: MenuTypeEnum
 * enum description： 菜单类型
 *
 * @author MoBaiJun 2022/10/28 10:05
 */
@Getter
@AllArgsConstructor
public enum MenuTypeEnum {

    /**
     * 左侧菜单
     */
    LEFT_MENU("0", "left"),

    /**
     * 顶部菜单
     */
    TOP_MENU("2", "top"),

    /**
     * 按钮
     */
    BUTTON("1", "button");

    /**
     * 类型
     */
    private final String type;

    /**
     * 描述
     */
    private final String description;
}
