package com.mobaijun.common.util.constant.enums.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: MenuStatus
 * enum description： 菜单状态
 *
 * @author MoBaiJun 2022/5/12 9:30
 */
@Getter
@AllArgsConstructor
public enum MenuStatus {

    DELETE(-1, "删除"),
    ENABLE(1, "启用"),
    DISABLE(2, "禁用");

    final int code;
    final String name;
}
