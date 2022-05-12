package com.mobaijun.common.util.sql;

import cn.hutool.db.DbUtil;
import cn.hutool.db.handler.RsHandler;
import cn.hutool.db.sql.SqlExecutor;
import cn.hutool.extra.spring.SpringUtil;
import com.mobaijun.common.util.PrintUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: SqlExe
 * class description： sql 操作工具类
 *
 * @author MoBaiJun 2022/5/12 11:42
 */
public class SqlExe {

    /**
     * 获取一条数据
     *
     * @param dataSource 数据源名称
     * @param sql        被执行的sql(sql中有参数用?代替)
     * @param params     sql执行时候的参数
     */
    public static Map<String, Object> selectOne(DataSource dataSource, String sql, Object... params) {

        RsHandler<Map<String, Object>> rsHandler = SqlUtils::resultSet2Map;

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            return SqlExecutor.query(conn, sql, rsHandler, params);
        } catch (SQLException e) {
            PrintUtils.print("sql执行错误!");
            return new HashMap<>();
        } finally {
            DbUtil.close(conn);
        }
    }

    /**
     * 获取一条数据
     *
     * @param sql    被执行的sql(sql中有参数用?代替)
     * @param params sql执行时候的参数
     * @return map
     */
    public static Map<String, Object> selectOne(String sql, Object... params) {
        DataSource dataSource = SpringUtil.getBean(DataSource.class);
        return selectOne(dataSource, sql, params);
    }

    /**
     * 查询多条记录
     *
     * @param dataSource 数据源名称
     * @param sql        被执行的sql(sql中有参数用?代替)
     * @param params     sql执行时候的参数
     * @return List
     */
    public static List<Map<String, Object>> selectList(DataSource dataSource, String sql, Object... params) {

        RsHandler<List<Map<String, Object>>> rsHandler = SqlUtils::resultSet2ListMap;

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            return SqlExecutor.query(conn, sql, rsHandler, params);
        } catch (SQLException e) {
            PrintUtils.print("sql执行错误!");
            return new ArrayList<>();
        } finally {
            DbUtil.close(conn);
        }
    }

    /**
     * 查询多条记录
     *
     * @param sql    被执行的sql(sql中有参数用?代替)
     * @param params sql执行时候的参数
     * @return List
     */
    public static List<Map<String, Object>> selectList(String sql, Object... params) {
        DataSource dataSource = SpringUtil.getBean(DataSource.class);
        return selectList(dataSource, sql, params);
    }

    /**
     * 更新数据
     *
     * @param dataSource 数据源名称
     * @param sql        被执行的sql(sql中有参数用?代替)
     * @param params     sql执行时候的参数
     * @return int
     */
    public static int update(DataSource dataSource, String sql, Object... params) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            return SqlExecutor.execute(conn, sql, params);
        } catch (SQLException e) {
            PrintUtils.print("sql执行错误!");
            return 0;
        } finally {
            DbUtil.close(conn);
        }
    }

    /**
     * 更新数据
     *
     * @param sql    被执行的sql(sql中有参数用?代替)
     * @param params sql执行时候的参数
     * @return int
     */
    public static int update(String sql, Object... params) {
        DataSource dataSource = SpringUtil.getBean(DataSource.class);
        return update(dataSource, sql, params);
    }

    /**
     * 新增数据
     *
     * @param dataSource 数据源名称
     * @param sql        被执行的sql(sql中有参数用?代替)
     * @param params     sql执行时候的参数
     * @return int
     */
    public static int insert(DataSource dataSource, String sql, Object... params) {
        return update(dataSource, sql, params);
    }

    /**
     * 新增数据
     *
     * @param sql    被执行的sql(sql中有参数用?代替)
     * @param params sql执行时候的参数
     * @return int
     */
    public static int insert(String sql, Object... params) {
        DataSource dataSource = SpringUtil.getBean(DataSource.class);
        return insert(dataSource, sql, params);
    }

    /**
     * 查询多条记录
     *
     * @param dataSource 数据源名称
     * @param sql        被执行的sql(sql中有参数用?代替)
     * @param params     sql执行时候的参数
     * @return int
     */
    public static int delete(DataSource dataSource, String sql, Object... params) {
        return update(dataSource, sql, params);
    }

    /**
     * 查询多条记录
     *
     * @param sql    被执行的sql(sql中有参数用?代替)
     * @param params sql执行时候的参数
     * @return int
     */
    public static int delete(String sql, Object... params) {
        DataSource dataSource = SpringUtil.getBean(DataSource.class);
        return delete(dataSource, sql, params);
    }
}
