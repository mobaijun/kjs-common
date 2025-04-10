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

import com.mobaijun.common.enums.http.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: R<br>
 * class description：返回体结构
 *
 * @author MoBaiJun 2022/6/30 15:01
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(title = "返回体结构")
public class R<T> implements Serializable {

    /**
     * 返回状态码
     */
    @Schema(title = "状态码", example = "200")
    private int code;

    /**
     * 返回信息
     */
    @Schema(title = "信息", example = "请求成功！")
    private String message;

    /**
     * 数据
     */
    @Schema(title = "数据列")
    private T data;

    /**
     * 默认成功返回
     *
     * @return R<T>
     */
    public static <T> R<T> ok() {
        return ok(null);
    }

    /**
     * 成功返回数据
     *
     * @param data 数据
     * @return R<T>
     */
    public static <T> R<T> ok(T data) {
        return ok(data, HttpStatus.OK);
    }

    /**
     * 不响应数据，自定义成功提示消息
     *
     * @param message 自定义消息内容
     * @param <T>     消息对象
     * @return R<T>
     */
    public static <T> R<T> ok(String message) {
        return ok(null, message);
    }

    /**
     * 返回数据，自定义成功消息
     *
     * @param status 自定义状态码
     * @return R<T>
     */
    public static <T> R<T> ok(T data, HttpStatus status) {
        return new R<T>().setCode(status.getCode())
                .setData(data)
                .setMessage(status.getMessage());
    }

    /**
     * 自定义返回消息内容
     *
     * @param data    数据
     * @param message 消息
     * @return R<T>
     */
    public static <T> R<T> ok(T data, String message) {
        return new R<T>().setCode(HttpStatus.OK.getCode())
                .setData(data)
                .setMessage(message);
    }

    /**
     * 自定义状态码和消息内容
     *
     * @param data    数据
     * @param message 消息
     * @return R<T>
     */
    public static <T> R<T> ok(T data, int code, String message) {
        return new R<T>().setCode(code)
                .setData(data)
                .setMessage(message);
    }

    /**
     * 返回 500 错误信息
     *
     * @return R<T>
     */
    public static <T> R<T> failed() {
        return failed(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 返回自定义错误信息和数据
     *
     * @return R<T>
     */
    public static <T> R<T> failed(T data, HttpStatus failCode) {
        return new R<T>().setCode(failCode.getCode())
                .setData(data)
                .setMessage(failCode.getMessage());
    }

    /**
     * 返回自定义错误信息和数据
     * <p>
     * 用于构建包含 HTTP 状态码、自定义数据和错误消息的响应对象。
     * 该方法适用于使用 Spring 提供的 {@link HttpStatus} 枚举来定义错误状态码的场景。
     * </p>
     *
     * @param failCode 错误状态码，使用 {@link HttpStatus} 枚举
     * @param data     错误附带的数据，可为具体异常信息或其他上下文数据
     * @param message  错误消息，用于描述错误原因
     * @param <T>      响应数据的类型
     * @return 返回构建好的 {@code R<T>} 对象，其中包含错误状态码、数据和错误消息
     */
    public static <T> R<T> failed(T data, HttpStatus failCode, String message) {
        return new R<T>()
                // 使用 HttpStatus 的状态码
                .setCode(failCode.getCode())
                // 设置响应数据
                .setData(data)
                // 设置错误消息
                .setMessage(message);
    }

    /**
     * 返回自定义错误信息和数据
     * <p>
     * 用于构建包含自定义状态码、自定义数据和错误消息的响应对象。
     * 该方法适用于需要手动指定错误状态码的场景。
     * </p>
     *
     * @param code    自定义错误状态码，例如 400、500 等
     * @param data    错误附带的数据，可为具体异常信息或其他上下文数据
     * @param message 错误消息，用于描述错误原因
     * @param <T>     响应数据的类型
     * @return 返回构建好的 {@code R<T>} 对象，其中包含错误状态码、数据和错误消息
     */
    public static <T> R<T> failed(T data, int code, String message) {
        return new R<T>()
                // 设置自定义状态码
                .setCode(code)
                // 设置响应数据
                .setData(data)
                // 设置错误消息
                .setMessage(message);
    }

    /**
     * 自定义错误状态码
     *
     * @param failStatus 状态码
     * @return R<T>
     */
    public static <T> R<T> failed(HttpStatus failStatus) {
        return new R<T>().setCode(failStatus.getCode())
                .setMessage(failStatus.getMessage());
    }

    /**
     * 自定义错误消息,状态码默认 500
     *
     * @param message 错误信息
     * @return R<T>
     */
    public static <T> R<T> failed(String message) {
        return new R<T>().setCode(HttpStatus.INTERNAL_SERVER_ERROR.getCode())
                .setMessage(message);
    }

    /**
     * 自定义错误状态码和返回消息
     *
     * @param code    状态码
     * @param message 消息
     * @return R<T>
     */
    public static <T> R<T> failed(int code, String message) {
        return new R<T>().setCode(code).setMessage(message);
    }

    /**
     * 返回指定状态码和错误信息
     *
     * @param failMsg 状态码
     * @param message 错误信息
     * @return R<T>
     */
    public static <T> R<T> failed(HttpStatus failMsg, String message) {
        return new R<T>().setCode(failMsg.getCode()).setMessage(message);
    }

    /**
     * 返回自定义警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static <T> R<T> warn(String msg) {
        return new R<T>().setCode(HttpStatus.WARN.getCode())
                .setMessage(msg);
    }

    /**
     * 返回自定义警告消息和数据
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static <T> R<T> warn(String msg, T data) {
        return new R<T>().setData(data).setCode(HttpStatus.WARN.getCode())
                .setMessage(msg);
    }

    /**
     * 返回响应结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    public static R<Void> toAjax(int rows) {
        return rows > 0 ? R.ok() : R.failed();
    }

    /**
     * 返回响应结果
     *
     * @param result 结果
     * @return 操作结果
     */
    public static R<Void> toAjax(boolean result) {
        return result ? R.ok() : R.failed();
    }
}