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
package com.mobaijun.common.enums.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [常见Token名称枚举，封装常用的Token Header名称]
 * Author: [mobaijun]
 * Date: [2024/11/12 9:18]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@AllArgsConstructor
public enum TokenType {

    /**
     * 标准的HTTP认证Header名称，用于传递Bearer Token
     */
    AUTHORIZATION("Authorization"),

    /**
     * 通用Token名称，可用于传递访问令牌
     */
    TOKEN("Token"),

    /**
     * 访问Token名称，通常用于OAuth 2.0中的访问Token
     */
    ACCESS_TOKEN("Access-Token"),

    /**
     * 刷新Token名称，用于OAuth 2.0中获取新的访问Token
     */
    REFRESH_TOKEN("Refresh-Token"),

    /**
     * 自定义认证Token，常用于REST API请求中
     */
    X_AUTH_TOKEN("X-Auth-Token"),

    /**
     * JSON Web Token (JWT)的名称，可用于携带JWT Token
     */
    JWT("JWT"),

    /**
     * 自定义JWT Token名称，用于标识携带JWT的Header
     */
    X_JWT_TOKEN("X-JWT-Token"),

    /**
     * API密钥认证名称，通常用于公共API的访问
     */
    API_KEY("Api-Key"),

    /**
     * 用户会话Token，常用于表示用户的Session Token
     */
    SESSION_TOKEN("Session-Token"),

    /**
     * 防止跨站请求伪造(CSRF)的Token名称
     */
    CSRF_TOKEN("Csrf-Token"),

    /**
     * 自定义CSRF Token名称，防止跨站请求伪造
     */
    X_CSRF_TOKEN("X-CSRF-Token");

    /**
     * Token名称
     */
    private final String headerName;
}