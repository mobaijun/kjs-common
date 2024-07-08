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
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: HttpRequestType<br>
 * enum description： http 请求标识
 *
 * @author MoBaiJun 2022/10/27 8:37
 */
@Getter
@AllArgsConstructor
public enum HttpRequestType {

    /**
     * Get
     */
    GET("GET", "请求指定的页面信息，并返回实体主体"),

    /**
     * Head
     */
    HEAD("HEAD", "类似于 GET 请求，只不过返回的响应中没有具体的内容，用于获取报头"),

    /**
     * Post
     */
    POST("POST", "向指定资源提交数据进行处理请求（例如提交表单或者上传文件）。数据被包含在请求体中。POST 请求可能会导致新的资源的建立和/或已有资源的修改。"),

    /**
     * PUT
     */
    PUT("PUT", "从客户端向服务器传送的数据取代指定的文档的内容。"),

    /**
     * DELETE
     */
    DELETE("DELETE", "请求服务器删除指定的页面。"),

    /**
     * OPTIONS
     */
    CONNECT("CONNECT", "HTTP/1.1 协议中预留给能够将连接改为管道方式的代理服务器。"),

    /**
     *
     */
    OPTIONS("OPTIONS", "允许客户端查看服务器的性能。"),

    /**
     * TRACE
     */
    TRACE("TRACE", "回显服务器收到的请求，主要用于测试或诊断。"),

    /**
     * PATCH
     */
    PATCH("PATCH", "是对 PUT 方法的补充，用来对已知资源进行局部更新 。");

    /**
     * 请求名称
     */
    private final String name;

    /**
     * 描述
     */
    private final String deScript;
}