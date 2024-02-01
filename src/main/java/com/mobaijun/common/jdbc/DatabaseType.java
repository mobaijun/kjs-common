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
package com.mobaijun.common.jdbc;

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
