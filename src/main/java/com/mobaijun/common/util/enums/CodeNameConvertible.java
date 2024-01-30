package com.mobaijun.common.util.enums;

/**
 * Description: [根据 code 获取名称接口]
 * Author: [mobaijun]
 * Date: [2024/1/24 9:54]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public interface CodeNameConvertible {

    /**
     * 获取 code
     *
     * @return code 值
     */
    String getCode();

    /**
     * 获取 value
     *
     * @return value 值
     */
    String getValue();
}
