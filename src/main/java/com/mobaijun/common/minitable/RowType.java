package com.mobaijun.common.minitable;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: RowType<br>
 * enum description: 区分是表头还是普通表格数据的枚举类<br>
 *
 * @author MoBaiJun 2022/12/29 9:28
 */
@Getter
public enum RowType {

    /**
     * 标题
     */
    TITLE,

    /**
     * 表头
     */
    HEADER,

    /**
     * 数据
     */
    DATA
}
