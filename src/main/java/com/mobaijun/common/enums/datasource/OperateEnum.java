package com.mobaijun.common.enums.datasource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Description: [操作枚举]
 * Author: [mobaijun]
 * Date: [2024/8/21 17:18]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@RequiredArgsConstructor
public enum OperateEnum {

    /**
     * 通过一个 Map 来设置多个字段的相等条件。
     */
    ALL_EQ(0, "多个字段相等"),

    /**
     * 等于
     */
    EQ(1, "等于"),

    /**
     * 不等于
     */
    NE(2, "不等于"),

    /**
     * 大于
     */
    GT(3, "大于"),

    /**
     * 大于等于
     */
    GE(4, "大于等于"),

    /**
     * 小于
     */
    LT(5, "小于"),

    /**
     * 小于等于
     */
    LE(6, "小于等于"),

    /**
     * 指定字段的 BETWEEN 条件
     */
    BETWEEN(7, "between"),

    /**
     * 设置单个字段的 NOT BETWEEN 条件
     */
    NOT_BETWEEN(8, "not between"),

    /**
     * like模糊查询需要加% 例如 %张三%
     */
    LIKE(9, "模糊查询"),

    /**
     * 指定字段的 Not Like 条件
     */
    NOT_LIKE(10, "not like"),

    /**
     * 设置单个字段的右模糊匹配条件。
     */
    LIKE_LEFT(11, "like left"),

    /**
     * 设置单个字段的左模糊匹配条件。
     */
    LIKE_RIGHT(12, "like right"),

    /**
     * 设置单个字段的非右模糊匹配条件
     */
    NOT_LIKE_LEFT(13, "not like left"),

    /**
     * 设置单个字段的非左模糊匹配条件
     */
    NOT_LIKE_RIGHT(14, "not like right"),

    /**
     * In操作 例如 name in ("小明","小红","张三")
     */
    IN(15, "in"),

    /**
     * Not in
     */
    NOT_IN(16, "not in");

    /**
     * 编码
     * 此处不需要 @EnumValue , 数据并不会传入数据库
     */
    private final Integer code;

    /**
     * 标签
     */
    private final String label;
}
