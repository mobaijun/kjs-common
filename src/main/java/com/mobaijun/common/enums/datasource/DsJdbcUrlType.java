/*
 * Copyright (C) 2022 [www.mobaijun.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.common.enums.datasource;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Description: [数据源类型枚举]
 * Author: [mobaijun]
 * Date: [2024/7/8 15:12]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@RequiredArgsConstructor
public enum DsJdbcUrlType {

    /**
     * mysql 数据库
     */
    MYSQL("mysql",
            "jdbc:mysql://%s:%s/%s?characterEncoding=utf8"
                    + "&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&allowMultiQueries=true&allowPublicKeyRetrieval=true",
            "select 1", "mysql8 链接"),

    /**
     * pg 数据库
     */
    PG("pg", "jdbc:postgresql://%s:%s/%s", "select 1", "postgresql 链接"),

    /**
     * SQL SERVER
     */
    MSSQL("mssql", "jdbc:sqlserver://%s:%s;database=%s;characterEncoding=UTF-8", "select 1", "sqlserver 链接"),

    /**
     * oracle
     */
    ORACLE("oracle", "jdbc:oracle:thin:@%s:%s:%s", "select 1 from dual", "oracle 链接"),

    /**
     * db2
     */
    DB2("db2", "jdbc:db2://%s:%s/%s", "select 1 from sysibm.sysdummy1", "DB2 TYPE4 连接"),

    /**
     * 达梦
     */
    DM("dm", "jdbc:dm://%s:%s/%s", "select 1 from dual", "达梦连接"),

    /**
     * pg 数据库
     */
    HIGHGO("highgo", "jdbc:highgo://%s:%s/%s", "select 1", "highgo 链接");

    /**
     * 数据库名称
     */
    private final String dbName;

    /**
     * 数据库连接地址
     */
    private final String url;

    /**
     * 数据库连接测试sql
     */
    private final String validationQuery;

    /**
     * 数据库连接描述
     */
    private final String description;

    /**
     * 获取数据库类型枚举
     *
     * @param dsType 数据库类型
     * @return 数据库类型枚举
     */
    public static DsJdbcUrlType get(String dsType) {
        return Arrays.stream(DsJdbcUrlType.values())
                .filter(dsJdbcUrlType -> dsType.equals(dsJdbcUrlType.getDbName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant for dsType: " + dsType));
    }
}
