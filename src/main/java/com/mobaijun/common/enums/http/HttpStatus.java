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
     * 继续。客户端应继续其请求
     */
    CONTINUE(100, "Continue"),

    /**
     * 切换协议。服务器根据客户端的请求切换协议。只能切换到更高级的协议，例如，切换到HTTP的新版本协议
     */
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),

    /**
     * 客户端服务器已接受完整请求，但尚未完成请求。
     */
    PROCESSING(102, "Processing"),

    /**
     * 请求成功。一般用于GET与POST请求
     */
    OK(200, "OK"),

    /**
     * 已创建。成功请求并创建了新的资源
     */
    CREATED(201, "Created"),

    /**
     * 已接受。已经接受请求，但未处理完成
     */
    ACCEPTED(202, "Accepted"),

    /**
     * 非授权信息。请求成功。但返回的meta信息不在原始的服务器，而是一个副本
     */
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),

    /**
     * 无内容。服务器成功处理，但未返回内容。在未更新网页的情况下，可确保浏览器继续显示当前文档
     */
    NO_CONTENT(204, "No Content"),

    /**
     * 重置内容。服务器处理成功，用户终端（例如：浏览器）应重置文档视图。可通过此返回码清除浏览器的表单域
     */
    RESET_CONTENT(205, "Reset Content"),

    /**
     * 部分内容。服务器成功处理了部分GET请求
     */
    PARTIAL_CONTENT(206, "Partial Content"),

    /**
     * 表示所请求的资源已经存在，但返回的实体内容可能是部分内容，而不是完整的内容
     */
    MULTI_STATUS(207, "Multi-Status"),

    /**
     * 客户端告诉服务器之前提到的相同资源
     */
    ALREADY_REPORTED(208, "Already Reported"),

    /**
     * 这允许服务器向客户端发送资源的更改（差异）
     */
    IM_USED(226, "IM Used"),

    /**
     * 多种选择。请求的资源可包括多个位置，相应可返回一个资源特征与地址的列表用于用户终端（例如：浏览器）选择
     */
    MULTIPLE_CHOICES(300, "Multiple Choices"),

    /**
     * 永久移动。请求的资源已被永久的移动到新URI，返回信息会包括新的URI，浏览器会自动定向到新URI。今后任何新的请求都应使用新的URI代替
     */
    MOVED_PERMANENTLY(301, "Moved Permanently"),

    /**
     * 临时移动。与301类似。但资源只是临时被移动。客户端应继续使用原有URI
     */
    FOUND(302, "Found"),

    /**
     * 查看其它地址。与301类似。使用GET和POST请求查看
     */
    SEE_OTHER(303, "See Other"),

    /**
     * 未修改。所请求的资源未修改，服务器返回此状态码时，不会返回任何资源。客户端通常会缓存访问过的资源，通过提供一个头信息指出客户端希望只返回在指定日期之后修改的资源
     */
    NOT_MODIFIED(304, "Not Modified"),

    /**
     * 使用代理。所请求的资源必须通过代理访问
     */
    USE_PROXY(305, "Use Proxy"),

    /**
     * 临时重定向。与302类似。使用GET请求重定向
     */
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),

    /**
     * 永久重定向 – 具有与 301 重定向相同的功能，但你不能在 POST 和 GET 之间切换
     */
    PERMANENT_REDIRECT(308, "Permanent Redirect"),

    /**
     * 客户端请求的语法错误，服务器无法理解
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
     * 客户端请求中的方法被禁止
     */
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),

    /**
     * 服务器无法根据客户端请求的内容特性完成请求
     */
    NOT_ACCEPTABLE(406, "Not Acceptable"),

    /**
     * 请求要求代理的身份认证，与401类似，但请求者应当使用代理进行授权
     */
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),

    /**
     * 服务器等待客户端发送的请求时间过长，超时
     */
    REQUEST_TIMEOUT(408, "Request Timeout"),

    /**
     * 客户端尝试创建的资源已经存在
     */
    ALREADY_EXISTS(409, "客户端尝试创建的资源已经存在"),

    /**
     * 客户端请求的资源已经不存在。410不同于404，如果资源以前有现在被永久删除了可使用410代码，网站设计人员可通过301代码指定资源的新位置
     */
    GONE(410, "Gone"),

    /**
     * 服务器无法处理客户端发送的不带Content-Length的请求信息
     */
    LENGTH_REQUIRED(411, "Length Required"),

    /**
     * 客户端请求信息的先决条件错误
     */
    PRECONDITION_FAILED(412, "Precondition Failed"),

    /**
     * 由于请求的实体过大，服务器无法处理，因此拒绝请求。为防止客户端的连续请求，服务器可能会关闭连接。如果只是服务器暂时无法处理，则会包含一个Retry-After的响应信息
     */
    PAYLOAD_TOO_LARGE(413, "Payload Too Large"),

    /**
     * 请求的URI过长（URI通常为网址），服务器无法处理
     */
    URI_TOO_LONG(414, "URI Too Long"),

    /**
     * 服务器无法处理请求附带的媒体格式
     */
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),

    /**
     * 客户端请求的范围无效
     */
    RANGE_NOT_SATISFIABLE(416, "Range Not Satisfiable"),

    /**
     * 服务器无法满足请求头中 Expect 字段指定的预期行为。
     */
    EXPECTATION_FAILED(417, "Expectation Failed"),

    /**
     * 状态码 418 实际上是一个愚人节玩笑。
     * 它在 RFC 2324 中定义，该 RFC 是一个关于超文本咖啡壶控制协议（HTCPCP）的笑话文件。
     * 在这个笑话中，418 状态码是作为一个玩笑加入到 HTTP 协议中的。
     */
    IM_A_TEAPOT(418, "I'm a teapot"),

    /**
     * 被误导的请求 – 请求发送到的服务器无法响应。
     */
    MISDIRECTED_REQUEST(421, "Misdirected Request"),

    /**
     * 实体无法处理 – 请求中存在语义错误。
     */
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),

    /**
     * 锁定 – 请求的资源被锁定。
     */
    LOCKED(423, "Locked"),

    /**
     * 依赖失败 – 发生此故障是因为它需要另一个同样失败的请求。
     */
    FAILED_DEPENDENCY(424, "Failed Dependency"),

    /**
     * 过早请求 – 服务器此时不愿意处理请求，因为请求很可能稍后会再次出现。
     */
    TOO_EARLY(425, "Too Early"),

    /**
     * 需要升级 – 服务器拒绝请求，直到客户端使用更新的协议。 “升级” 标题中会指出需要升级的内容。
     */
    UPGRADE_REQUIRED(426, "Upgrade Required"),

    /**
     * 需要先决条件 – 服务器要求请求是有条件的。
     */
    PRECONDITION_REQUIRED(428, "Precondition Required"),

    /**
     * 资源配额或者达到限制速率
     */
    RESOURCE_EXHAUSTED(429, "资源配额或者达到限制速率"),

    /**
     * 请求标头字段太大 – 服务器不会处理请求，因为标头字段太大。
     */
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),

    /**
     * 因法律原因不可用 – 由于某种法律原因而被阻止。由于隐私或许可，你有时会在国家级屏蔽中看到它，
     * 例如，屏蔽新闻或视频。你可能会在 DMCA 删除时看到它。代码本身是对小说 Fahrenheit 451 (*注) 的引用。
     */
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),

    /**
     * 请求被客户取消
     */
    CANCELLED(499, "请求被客户取消"),

    /**
     * 服务器内部错误，无法完成请求
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    /**
     * 服务器不支持请求的功能，无法完成请求
     */
    NOT_IMPLEMENTED(501, "Not Implemented"),

    /**
     * 作为网关或者代理工作的服务器尝试执行请求时，从远程服务器接收到了一个无效的响应
     */
    BAD_GATEWAY(502, "Bad Gateway"),

    /**
     * 由于超载或系统维护，服务器暂时的无法处理客户端的请求。延时的长度可包含在服务器的Retry-After头信息中
     */
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),

    /**
     * 充当网关或代理的服务器，未及时从远端服务器获取请求
     */
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),

    /**
     * 服务器不支持请求的HTTP协议的版本，无法完成处理
     */
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported"),

    /**
     * 变体协商 – 当服务器有多个变体时，允许客户端获得资源的最佳变体。
     */
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),

    /**
     * 存储空间不足 – 服务器无法存储完成请求所需存储的内容。
     */
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),

    /**
     * 检测到环路 – 服务器在尝试处理请求时发现无限循环。
     */
    LOOP_DETECTED(508, "Loop Detected"),

    /**
     * 未扩展 – 在服务器完成请求之前，需要对请求进行更多扩展。
     */
    NOT_EXTENDED(510, "Not Extended"),

    /**
     * 需要网络身份验证 – 客户端需要在服务器允许访问之前，进行身份验证。
     */
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required"),

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
    UNKNOWN_ERROR(99999, "Unknown Error"),

    /**
     * 系统警告消息
     */
    WARN(6001, "系统警告消息");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 消息
     */
    private final String message;
}