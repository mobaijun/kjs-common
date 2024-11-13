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
package com.mobaijun.common.exception;

import java.io.Serial;

/**
 * Description: [工具类异常]
 * Author: [mobaijun]
 * Date: [2024/7/30 10:16]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class UtilException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8247610319171014183L;

    /**
     * 构造方法：仅包含 Throwable
     *
     * @param e Throwable
     */
    public UtilException(Throwable e) {
        super(e.getMessage(), e);
    }

    /**
     * 构造方法：包含错误信息
     *
     * @param message 错误信息
     */
    public UtilException(String message) {
        super(message);
    }

    /**
     * 构造方法：包含错误信息模板和参数
     *
     * @param messageTemplate 错误信息模板
     * @param params          参数
     */
    public UtilException(String messageTemplate, Object... params) {
        super(String.format(messageTemplate, params));
    }

    /**
     * 构造方法：包含错误信息和 Throwable
     *
     * @param message   错误信息
     * @param throwable Throwable
     */
    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * 构造方法：支持是否启用抑制和是否可写堆栈跟踪
     *
     * @param message            message
     * @param throwable          throwable
     * @param enableSuppression  enableSuppression
     * @param writableStackTrace writableStackTrace
     */
    public UtilException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }

    /**
     * 构造方法：包含 Throwable，错误信息模板和参数
     *
     * @param throwable       Throwable
     * @param messageTemplate messageTemplate
     * @param params          params
     */
    public UtilException(Throwable throwable, String messageTemplate, Object... params) {
        super(String.format(messageTemplate, params), throwable);
    }
}