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