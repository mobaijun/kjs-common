package com.mobaijun.common.enums.database;

import lombok.Getter;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: DataSourceType
 * 类描述： 数据源类型
 *
 * @author MoBaiJun 2022/4/25 15:18
 */
@Getter
public enum DataSourceType {

    /**
     * 主库
     */
    MASTER,

    /**
     * 从库
     */
    SLAVE,

}
