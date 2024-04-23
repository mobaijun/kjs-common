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

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: JdbcDriverUtil<br>
 * class description： jdbc 链接工具类
 * <br>
 * 1.repairedStatement用于处理动态SQL语句，在执行前会有一个预编译过程，这个过程是有时间开销的，虽然相对数据库的操作，该时间开销可以忽略不计，
 * 但是PreparedStatement的预编译结果会被缓存，下次执行相同的预编译语句时，就不需要编译，只要将参数直接传入编译过的语句执行代码中就会得到执行，所以，对于批量处理可以大大提高效率。<br>
 * 2.Statement每次都会执行SQL语句，相关数据库都要执行SQL语句的编译。<br>
 * 作为开发者，应该尽可能以PreparedStatement代替Statement,原因如下：
 * 1.代码的可读性和可维护性。<br>
 * 2.PreparedStatement尽最大可能提高性能。<br>
 * 3.极大的提高了安全性。
 *
 * @author MoBaiJun 2022/5/18 9:29
 */
@Slf4j
public class JdbcDriverUtil {

    private JdbcDriverUtil() {
        // 私有构造方法，防止实例化
    }

    /**
     * 获取数据库连接
     *
     * @param dbType   数据库类型
     * @param url      数据库连接 URL
     * @param username 数据库用户名
     * @param password 数据库密码
     * @return 数据库连接对象
     * @throws SQLException 如果连接数据库时发生 SQL 异常
     */
    public static Connection getConnection(DatabaseType dbType, String url, String username, String password) throws SQLException {
        Objects.requireNonNull(dbType, "数据库类型不能为空");
        Objects.requireNonNull(url, "数据库连接 URL 不能为空");
        Objects.requireNonNull(username, "用户名不能为空");
        Objects.requireNonNull(password, "密码不能为空");

        try {
            Class.forName(dbType.getDriver());
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("数据库驱动未找到: " + e.getMessage(), e);
        }
    }

    /**
     * 关闭数据库连接
     *
     * @param conn 数据库连接对象
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("关闭数据库连接时发生错误: {}", e.getMessage());
            }
        }
    }

    /**
     * 执行单条 SQL 语句（insert、update、delete）
     *
     * @param conn   数据库连接对象
     * @param sql    SQL 语句
     * @param params SQL 参数
     */
    public static void execute(Connection conn, String sql, Object... params) {
        Objects.requireNonNull(conn, "数据库连接不能为空");
        Objects.requireNonNull(sql, "SQL 语句不能为空");

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            setParameters(pst, params);
            pst.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            handleSQLException(conn, e);
        }
    }

    /**
     * 批量执行 SQL 语句（insert、update、delete）
     *
     * @param conn        数据库连接对象
     * @param sql         SQL 语句
     * @param batchParams 批量参数列表
     */
    public static void executeBatch(Connection conn, String sql, List<Object[]> batchParams) {
        Objects.requireNonNull(conn, "数据库连接不能为空");
        Objects.requireNonNull(sql, "SQL 语句不能为空");

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            for (Object[] params : batchParams) {
                setParameters(pst, params);
                pst.addBatch();
            }
            pst.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            handleSQLException(conn, e);
        }
    }

    /**
     * 执行存储过程
     *
     * @param conn      数据库连接对象
     * @param sql       存储过程调用语句
     * @param inParams  输入参数
     * @param outParams 输出参数
     * @return 存储过程执行结果
     */
    public static Map<Integer, Object> executeProcedure(Connection conn, String sql, Map<Integer, Object> inParams, Map<Integer, Integer> outParams) {
        Objects.requireNonNull(conn, "数据库连接不能为空");
        Objects.requireNonNull(sql, "存储过程调用语句不能为空");

        try (CallableStatement cs = conn.prepareCall(sql)) {
            setParameters(cs, inParams);
            registerOutParameters(cs, outParams);
            cs.execute();
            return retrieveOutputParameters(cs, outParams);
        } catch (SQLException e) {
            handleSQLException(conn, e);
            return Collections.emptyMap();
        }
    }

    /**
     * 查询数据库记录（不带分页）
     *
     * @param conn   数据库连接对象
     * @param sql    查询 SQL 语句
     * @param params 查询参数
     * @return 查询结果列表
     */
    public static List<Map<String, Object>> findAll(Connection conn, String sql, Object... params) {
        Objects.requireNonNull(conn, "数据库连接不能为空");
        Objects.requireNonNull(sql, "查询 SQL 语句不能为空");

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            setParameters(pst, params);
            try (ResultSet rs = pst.executeQuery()) {
                return resultSetToList(rs);
            }
        } catch (SQLException e) {
            handleSQLException(conn, e);
            return Collections.emptyList();
        }
    }

    /**
     * 设置 PreparedStatement 的参数。
     *
     * @param pst    PreparedStatement 对象
     * @param params 参数数组
     * @throws SQLException 如果设置参数时发生 SQL 异常
     */
    private static void setParameters(PreparedStatement pst, Object... params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
        }
    }

    /**
     * 注册 CallableStatement 的输出参数。
     *
     * @param cs        CallableStatement 对象
     * @param outParams 输出参数的映射，key 是参数索引，value 是参数类型
     * @throws SQLException 如果注册输出参数时发生 SQL 异常
     */
    private static void registerOutParameters(CallableStatement cs, Map<Integer, Integer> outParams) throws SQLException {
        if (outParams != null) {
            for (Map.Entry<Integer, Integer> entry : outParams.entrySet()) {
                cs.registerOutParameter(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 获取 CallableStatement 的输出参数值。
     *
     * @param cs        CallableStatement 对象
     * @param outParams 输出参数的映射，key 是参数索引，value 是参数类型
     * @return 包含输出参数值的映射，key 是参数索引，value 是参数值
     * @throws SQLException 如果获取输出参数值时发生 SQL 异常
     */
    private static Map<Integer, Object> retrieveOutputParameters(CallableStatement cs, Map<Integer, Integer> outParams) throws SQLException {
        Map<Integer, Object> resultMap = new HashMap<>();
        if (outParams != null) {
            for (Map.Entry<Integer, Integer> entry : outParams.entrySet()) {
                resultMap.put(entry.getKey(), cs.getObject(entry.getKey()));
            }
        }
        return resultMap;
    }

    /**
     * 处理 SQL 异常，包括记录错误日志并回滚事务。
     *
     * @param conn 数据库连接
     * @param e    SQL 异常对象
     */
    private static void handleSQLException(Connection conn, SQLException e) {
        log.error("SQL 执行出错: {}", e.getMessage());
        try {
            conn.rollback();
        } catch (SQLException e1) {
            log.error("回滚事务出错: {}", e1.getMessage());
        }
    }

    /**
     * 将 ResultSet 转换为 List<Map<String, Object>> 结果集。
     *
     * @param rs ResultSet 对象
     * @return 包含 ResultSet 数据的 List<Map<String, Object>>
     * @throws SQLException 如果处理 ResultSet 时发生 SQL 异常
     */
    private static List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        List<Map<String, Object>> resultList = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        while (rs.next()) {
            Map<String, Object> rowMap = new HashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                Object columnValue = rs.getObject(i);
                rowMap.put(columnName.toUpperCase(), columnValue);
            }
            resultList.add(rowMap);
        }
        return resultList;
    }
}