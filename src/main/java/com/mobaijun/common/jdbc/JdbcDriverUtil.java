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

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

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
import java.util.Map.Entry;

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
     * 获取Connection
     *
     * @param url      url
     * @param username username
     * @param password password
     * @return 链接对象
     */
    public static Connection getConnection(DatabaseType dbType, String url, String username, String password) {
        if (dbType == null || url == null || username == null || password == null) {
            throw new IllegalArgumentException("The parameters must not be null");
        }

        try {
            Class.forName(dbType.getDriver());
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            // 记录错误信息，这里可以使用日志框架来替代
            log.error("Error while connecting to the database: " + e.getMessage());
        }
        return null;
    }

    /**
     * 关闭数据库连接
     *
     * @param conn 数据库连接
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // 在关闭连接时发生异常，可以记录日志或采取其他处理措施
                log.error("Error closing connection:" + e.getMessage());
            }
        }
    }

    /**
     * 执行一条sql语句(insert, update, delete)
     *
     * @param conn 链接信息
     * @param sql  sql 语句
     * @param obj  对象数组
     */
    public static void execute(Connection conn, String sql, Object... obj) {
        if (conn == null || sql == null) {
            throw new IllegalArgumentException("Connection and SQL must not be null");
        }

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            if (obj != null && obj.length > 0) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);
                }
            }
            pst.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }


    /**
     * 批量执行多条sql语句(insert, update, delete)
     *
     * @param conn    链接信息
     * @param sql     sql语句
     * @param objList 对象
     */
    public static void executeBatch(Connection conn, String sql, List<Object[]> objList) {
        if (conn == null || sql == null) {
            throw new IllegalArgumentException("Connection and SQL must not be null");
        }

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);

            for (Object[] obj : objList) {
                if (obj != null && obj.length > 0) {
                    for (int i = 0; i < obj.length; i++) {
                        pst.setObject(i + 1, obj[i]);
                    }
                    pst.addBatch();
                }
            }

            pst.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 执行程序
     *
     * @param conn 链接信息
     * @param sql  sql
     * @param in   输入参数, key:参数位置(从1开始), value:参数值
     * @param out  输出参数, key:参数位置(从1开始), value:参数类型
     * @return key:参数位置(从1开始), value:输出的值
     */
    public static Map<Integer, Object> executeProcedure(Connection conn, String sql, Map<Integer, Object> in, Map<Integer, Integer> out) {
        if (conn == null || sql == null) {
            throw new IllegalArgumentException("Connection and SQL must not be null");
        }

        try (CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.getResultSet()) {

            // 输入参数
            if (in != null && !in.isEmpty()) {
                for (Entry<Integer, Object> entry : in.entrySet()) {
                    cs.setObject(entry.getKey(), entry.getValue());
                }
            }
            // 输出参数
            if (out != null && !out.isEmpty()) {
                for (Entry<Integer, Integer> entry : out.entrySet()) {
                    cs.registerOutParameter(entry.getKey(), entry.getValue());
                }
            }
            cs.execute();

            // 设置输出结果
            if (out != null && !out.isEmpty()) {
                Map<Integer, Object> map = new HashMap<>();
                for (Integer index : out.keySet()) {
                    Object obj = cs.getObject(index);

                    if (obj instanceof ResultSet) {
                        List<Map<String, Object>> rows = new ArrayList<>();
                        ResultSetMetaData read = rs.getMetaData();
                        while (rs.next()) {
                            Map<String, Object> columns = new HashMap<>();
                            for (int i = 1; i <= read.getColumnCount(); i++) {
                                String fieldName = read.getColumnName(i);
                                Object fieldValue = rs.getObject(fieldName);
                                columns.put(fieldName.toUpperCase(), fieldValue);
                            }
                            rows.add(columns);
                        }
                        map.put(index, rows);
                    } else if (obj instanceof java.sql.Clob) {
                        java.sql.Clob clob = (java.sql.Clob) obj;
                        map.put(index, clob.getSubString(1, (int) clob.length()));
                    } else if (obj instanceof java.sql.Date || obj instanceof java.sql.Timestamp) {
                        map.put(index, obj);
                    } else {
                        map.put(index, obj);
                    }
                }
                return map;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

    /**
     * 查询一条或多条记录(不带分页)
     *
     * @param conn 链接信息
     * @param sql  sql 语句
     * @param obj  对象数组
     * @return 集合
     */
    public static List<Map<String, Object>> findAll(Connection conn, String sql, Object... obj) {
        if (conn == null || sql == null) {
            throw new IllegalArgumentException("Connection and SQL must not be null");
        }

        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            ResultSetMetaData red = rs.getMetaData();
            List<Map<String, Object>> list = new ArrayList<>();

            if (obj != null && obj.length > 0) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);
                }
            }

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= red.getColumnCount(); i++) {
                    String fieldName = red.getColumnName(i);
                    Object fieldValue = rs.getObject(fieldName);
                    map.put(fieldName.toUpperCase(), fieldValue);
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * 查询一条或多条记录(带分页) - oracle, mysql
     *
     * @param conn        链接信息
     * @param sql         sql 语句
     * @param obj         对象数组
     * @param firstResult 前结果集
     * @param maxResults  最大结果集
     * @return 集合
     */
    @SneakyThrows
    public List<Map<String, Object>> find(Connection conn, String sql, Object[] obj, int firstResult, int maxResults) {
        if (conn == null || sql == null) {
            throw new IllegalArgumentException("Connection and SQL must not be null");
        }

        if (conn.isClosed()) {
            throw new IllegalArgumentException("Connection has been closed!");
        }

        StringBuilder sb = new StringBuilder();

        String DB_NAME = "DB_NAME";
        if ("oracle".equals(DB_NAME)) {
            sb.append("SELECT * FROM (");
            sb.append("SELECT TEMP_TABLE_.*, ROWNUM ROWNUM_ FROM (").append(sql).append(") TEMP_TABLE_");
            sb.append(" WHERE ROWNUM <= ").append(firstResult + maxResults).append(")");
            sb.append(" WHERE ROWNUM_ > ").append(firstResult);
        } else if ("mysql".equals(DB_NAME)) {
            sb.append("SELECT * FROM (").append(sql).append(") TEMP_TABLE_");
            sb.append(" LIMIT ").append(firstResult).append(",").append(maxResults);
        }

        return findAll(conn, sb.toString(), obj);
    }
}