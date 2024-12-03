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
package com.mobaijun.common.result;

import com.mobaijun.common.date.DatePattern;
import com.mobaijun.common.date.LocalDateUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 错误数据信息类
 * <p>
 * 用于封装错误发生时的相关上下文信息，便于统一返回标准化的错误响应数据。
 * 包含请求路径、异常类型、请求方法、支持的方法列表，以及时间戳等信息。
 * </p>
 * Author: [mobaijun]
 * Date: [2024/11/25 9:23]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@Setter
@Builder
@ToString
@Schema(title = "错误详情", description = "错误详情")
public class ErrorDataInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 请求路径
     * <p>
     * 记录发生错误时的请求 URL，便于快速定位问题。
     * </p>
     */
    @Schema(title = "请求路径", example = "/xxx/xxx")
    private String path;

    /**
     * 异常类型
     * <p>
     * 捕获到的异常类的名称，例如 {@code NullPointerException}。
     * </p>
     */
    @Schema(title = "异常类型", example = "NullPointerException")
    private String exceptionType;

    /**
     * 请求方法
     * <p>
     * 记录导致错误的 HTTP 请求方法，例如 {@code GET}, {@code POST}。
     * </p>
     */
    @Schema(title = "请求方法", example = "GET")
    private String method;

    /**
     * 支持的方法列表
     * <p>
     * 如果当前请求方法不被支持，返回支持的 HTTP 方法列表，
     * 例如 {@code GET, POST}。如果没有限制，则为空字符串。
     * </p>
     */
    @Schema(title = "支持的方法列表", example = "GET, POST")
    private String methods;

    /**
     * 错误发生时间戳
     * <p>
     * 记录错误发生的时间，格式为 {@code yyyy年MM月dd日 HH:mm:ss}，
     * 例如 {@code 2024年11月25日 15:30:45}。
     * 默认值为当前时间。
     * </p>
     */
    @Builder.Default
    @Schema(title = "错误发生时间戳", example = "2024年11月25日 15:30:45")
    private String timestamp = LocalDateUtil.formatNow(DatePattern.YYYY_MM_DD_HH_MM_SS_CHINESE);

    /**
     * 错误信息
     * <p>
     * 记录错误的具体信息，例如 {@code 服务器内部错误}。
     * 默认值为 {@code 服务器内部错误}。
     * </p>
     */
    @Schema(title = "错误信息", example = "服务器内部错误")
    private String errorInfo;
}