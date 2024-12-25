package com.mobaijun.common.enums.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [客户端类型]
 * Author: [mobaijun]
 * Date: [2024/12/25 17:46]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@AllArgsConstructor
public enum ServerClient {

    /**
     * 前端
     */
    FRONT("front"),

    /**
     * 后端
     */
    BACKEND("backend");

    /**
     * 值
     */
    private final String value;
}
