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

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

/**
 * Description: [JdbcDriverUtilTest测试类]
 * Author: [mobaijun]
 * Date: [2024/4/23 10:57]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class JdbcDriverUtilTest {

    @Test
    public void getConnection() {
        try {
            Connection connection = JdbcDriverUtil.getConnection(DatabaseType.MYSQL, "jdbc:mysql://localhost:3306/test", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void closeConnection() {
    }

    @Test
    public void execute() {
    }

    @Test
    public void executeBatch() {
    }

    @Test
    public void executeProcedure() {
    }

    @Test
    public void findAll() {
    }
}