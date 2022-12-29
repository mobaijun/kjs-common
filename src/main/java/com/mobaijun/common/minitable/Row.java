package com.mobaijun.common.minitable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: Row<br>
 * class description: 表格每行的类型和数据的实体类<br>
 *
 * @author MoBaiJun 2022/12/29 9:28
 */
@Getter
@Setter
@ToString
public class Row {

    /**
     * 行类型.
     */
    private RowType rowType;

    /**
     * 行数据.
     */
    private List<String> data;

    /**
     * 构造方法.
     *
     * @param rowType 行类型
     * @param data    行数据集
     */
    Row(RowType rowType, List<String> data) {
        this.rowType = rowType;
        this.data = data;
    }
}
