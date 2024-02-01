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
package com.mobaijun.common.sql;

import com.mobaijun.common.constant.StringConstant;
import com.mobaijun.common.text.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: SqlUtils<br>
 * 类描述： sql 工具类<br>
 *
 * @author MoBaiJun 2022/4/22 17:06
 */
@Slf4j
public class SqlUtil {

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
        if (StringUtil.isNotEmpty(value) && !isValidOrderBySql(value)) {
            throw new RuntimeException("The parameter does not meet specifications and cannot be queried");
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
     * 根据集合的大小，输出相应个数"?"
     *
     * @param list list
     * @return String
     */
    public static String parse(List<?> list) {
        StringBuilder str = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            str.append(StringConstant.QUESTION_MARK);
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
            log.error("Conversion result set error!{}", e.getMessage());
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
            log.error("Error converting result set！{}", e.getMessage());
            // 返回空map
            return result;
        }
    }
}