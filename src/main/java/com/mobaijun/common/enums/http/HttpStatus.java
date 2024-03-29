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
 * Software：IntelliJ IDEA 2021.3.2<br>
 * EnumName: BaseResultCode<br>
 * 枚举描述： 返回状态码
 * <a href="https://www.runoob.com/http/http-status-codes.html">学习链接</a>
 *
 * @author MoBaiJun 2022/4/22 17:30
 */
@Getter
@AllArgsConstructor
public enum HttpStatus {

    /**
     * 成功
     */
    OK(200, "OK"),

    /**
     * 客户端指定了无效参数，检查错误信息和错误详细信息以获取更多信息
     */
    INVALID_ARGUMENT(400, "客户端指定了无效参数，检查错误信息和错误详细信息以获取更多信息"),

    /**
     * 由于缺失、无效或过期的OAuth token，请求未通过身份验证
     */
    UNAUTHENTICATED(401, "由于缺失、无效或过期的OAuth token，请求未通过身份验证"),

    /**
     * 客户端没有足够的权限。这可能是因为OAuth token没有正确的范围，客户端没有权限，还没有为客户端项目启用API
     */
    PERMISSION_DENIED(403, "客户端没有足够的权限。这可能是因为OAuth token没有正确的范围，客户端没有权限，还没有为客户端项目启用API"),

    /**
     * 指定资源没有被发现，或者该请求被未公开的原因拒绝，例如白名单
     */
    NOT_FOUND(404, "指定资源没有被发现，或者该请求被未公开的原因拒绝，例如白名单"),

    /**
     * 客户端尝试创建的资源已经存在
     */
    ALREADY_EXISTS(409, "客户端尝试创建的资源已经存在"),

    /**
     * 资源配额或者达到限制速率
     */
    RESOURCE_EXHAUSTED(429, "资源配额或者达到限制速率"),

    /**
     * 请求被客户取消
     */
    CANCELLED(499, "请求被客户取消"),

    /**
     * 服务器内部异常
     */
    ERROR(500, "Internal Server Error"),

    /**
     * API方法未由服务器实现
     */
    NOT_IMPLEMENTED(501, "API方法未由服务器实现"),

    /**
     * 作为网关或者代理工作的服务器尝试执行请求时，从远程服务器接收到了一个无效的响应
     */
    BAD_GATEWAY(502, "作为网关或者代理工作的服务器尝试执行请求时，从远程服务器接收到了一个无效的响应"),

    /**
     * 服务不可用，一般是服务器宕机所致
     */
    UNAVAILABLE(503, "服务不可用，一般是服务器宕机所致"),

    /**
     * 请求超期，如果重复发生，请考虑减少请求的复杂性
     */
    DEADLINE_EXCEEDED(504, "请求超期，如果重复发生，请考虑减少请求的复杂性"),

    /**
     * 参数校验失败
     */
    CHECK_PARAM_FAIL(10001, "参数校验失败"),

    /**
     * 签名校验失败
     */
    CHECK_CHECKSUM_FAIL(10002, "签名校验失败"),

    /**
     * 数据库相关
     */
    DATABASE_INSERT_FAIL(20001, "数据库插入失败"),

    /**
     * 数据库更新失败
     */
    DATABASE_UPDATE_FAIL(20002, "数据库更新失败"),

    /**
     * 数据库删除失败
     */
    DATABASE_DELETE_FAIL(20003, "数据库删除失败"),

    /**
     * 数据库查询失败
     */
    DATABASE_SELECT_FAIL(20004, "数据库查询失败"),

    /**
     * 文件/流/编码 相关异常
     */
    FILE_NOT_EXISTS(30001, "指定文件不存在"),

    /**
     * 流相关
     */
    STREAM_HAS_BEEN_CLOSED(31001, "流已经关闭"),

    /**
     * 编码相关
     */
    CHARSET_NOT_EXISTS(32001, "指定编码不存在"),

    /**
     * 反射相关
     */
    REFLECT_NEW_INSTANCE_FAIL(40001, "反射新建对象失败"),

    /**
     * 数据库保存/更新异常
     */
    UPDATE_DATABASE_ERROR(90001, "Update Database Error"),

    /**
     * 通用的逻辑校验异常
     */
    LOGIC_CHECK_ERROR(90004, "Logic Check Error"),

    /**
     * 恶意请求
     */
    MALICIOUS_REQUEST(90005, "Malicious Request"),

    /**
     * 文件上传异常
     */
    FILE_UPLOAD_ERROR(90006, "File Upload Error"),

    /**
     * 重复执行
     */
    REPEATED_EXECUTE(90007, "Repeated execute"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(99999, "Unknown Error");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 消息
     */
    private final String message;
}