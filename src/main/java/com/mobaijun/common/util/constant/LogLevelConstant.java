/*
 * Copyright (C) 2022 www.mobaijun.com
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
package com.mobaijun.common.util.constant;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: LogLevelConstant
 * class description: 日志级别
 *
 * <p>
 * debug, info, warn, Error, Fatal;
 * </p>
 * <p>
 * ALL	各级包括自定义级别
 * DEBUG	指定细粒度信息事件是最有用的应用程序调试
 * ERROR	错误事件可能仍然允许应用程序继续运行
 * FATAL	指定非常严重的错误事件，这可能导致应用程序中止
 * INFO	指定能够突出在粗粒度级别的应用程序运行情况的信息的消息
 * OFF	这是最高等级，为了关闭日志记录
 * TRACE	指定细粒度比DEBUG更低的信息事件
 * WARN	指定具有潜在危害的情况
 *
 * @author MoBaiJun 2022/11/22 11:22
 */
public class LogLevelConstant {

    /**
     * 各级包括自定义级别
     */
    public static final String ALL = "ALL";

    /**
     * 指定细粒度信息事件是最有用的应用程序调试
     */
    public static final String DEBUG = "DEBUG";

    /**
     * 错误事件可能仍然允许应用程序继续运行
     */
    public static final String ERROR = "ERROR";

    /**
     * 指定非常严重的错误事件，这可能导致应用程序中止
     */
    public static final String FATAL = "FATAL";

    /**
     * 指定能够突出在粗粒度级别的应用程序运行情况的信息的消息
     */
    public static final String INFO = "INFO";

    /**
     * 这是最高等级，为了关闭日志记录
     */
    public static final String OFF = "OFF";

    /**
     * 指定细粒度比DEBUG更低的信息事件
     */
    public static final String TRACE = "TRACE";

    /**
     * 指定具有潜在危害的情况
     */
    public static final String WARN = "WARN";
}