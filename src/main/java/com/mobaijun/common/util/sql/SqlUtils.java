package com.mobaijun.common.util.sql;

import cn.hutool.core.exceptions.UtilException;
import com.mobaijun.common.util.PrintUtils;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: SqlUtils
 * 类描述： sql 工具类
 *
 * @author MoBaiJun 2022/4/22 17:06
 */
public class SqlUtils {

    /**
     * 定义常用的 sql关键字
     */
    public static String SQL_REGEX = "select |insert |delete |update |drop |count |exec |chr |mid |master |truncate |char |and |declare ";

    /**
     * 仅支持字母、数字、下划线、空格、逗号、小数点（支持多个字段排序）
     */
    public static String SQL_PATTERN = "[a-zA-Z0-9_ ,.]+";

    /**
     * 检查字符，防止注入绕过
     *
     * @param value value
     * @return String
     */
    public static String escapeOrderBySql(String value) {
        if (StringUtils.isNotEmpty(value) && !isValidOrderBySql(value)) {
            throw new UtilException("参数不符合规范，不能进行查询");
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     *
     * @param value value
     * @return boolean
     */
    public static boolean isValidOrderBySql(String value) {
        return value.matches(SQL_PATTERN);
    }

    /**
     * SQL关键字检查
     *
     * @param value void
     */
    public static void filterKeyword(String value) {
        if (StringUtils.isEmpty(value)) {
            return;
        }
        String[] sqlKeywords = StringUtils.split(SQL_REGEX, "\\|");
        for (String sqlKeyword : sqlKeywords) {
            if (StringUtils.indexOfIgnoreCase(value, sqlKeyword) > -1) {
                throw new UtilException("参数存在SQL注入风险");
            }
        }
    }

    /**
     * 根据集合的大小，输出相应个数"?"
     *
     * @param list list
     * @return String
     */
    public static String parse(List<?> list) {
        StringBuilder str = new StringBuilder();
        if (list != null && list.size() > 0) {
            str.append("?");
            str.append(",?".repeat(list.size() - 1));
        }
        return str.toString();
    }

    /**
     * 结果集转化为map
     *
     * @param resultSet resultSet
     * @return Map
     */
    public static Map<String, Object> resultSet2Map(ResultSet resultSet) {
        try {
            HashMap<String, Object> result = new HashMap<>(100);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                Object columnValue = resultSet.getObject(i);
                result.put(columnName, columnValue);
            }
            return result;
        } catch (SQLException e) {
            PrintUtils.print(e.getMessage(), "转化结果集错误！");
            // 返回空map
            return new HashMap<>(1);
        }
    }

    /**
     * 结果集转化为map
     *
     * @param resultSet resultSet
     * @return List
     */
    public static List<Map<String, Object>> resultSet2ListMap(ResultSet resultSet) {
        ArrayList<Map<String, Object>> result = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Map<String, Object> map = resultSet2Map(resultSet);
                result.add(map);
            }
            return result;
        } catch (SQLException e) {
            PrintUtils.print(e.getMessage(), "转化结果集错误！");
            // 返回空map
            return result;
        }
    }
}
