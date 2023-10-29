package com.mobaijun.common.util.jdbc;

import lombok.Getter;

/**
 * Description: [数据库类型]
 * Author: [mobaijun]
 * Date: [2023/10/29 16:37]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
public enum DatabaseType {

    SQL_SERVER("com.microsoft.sqlserver.jdbc.SQLServerDriver"),

    ORACLE("oracle.jdbc.driver.OracleDriver"),

    MYSQL("com.mysql.cj.jdbc.Driver");

    private final String driver;

    DatabaseType(String driver) {
        this.driver = driver;
    }
}
