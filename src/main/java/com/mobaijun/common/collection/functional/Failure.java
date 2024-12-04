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
package com.mobaijun.common.collection.functional;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * 表示一个失败的结果，封装了失败的原因（即抛出的异常）。
 *
 * @param <T> 封装的值的类型
 */
public class Failure<T> extends Try<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 失败的原因（异常）
     */
    private final Throwable cause;

    /**
     * 构造一个 Failure 对象，用于表示一个失败的结果。
     *
     * @param cause 失败的原因，通常是一个 Throwable
     * @throws NullPointerException 如果 `cause` 为 null，则抛出空指针异常
     */
    public Failure(Throwable cause) {
        // 确保失败的原因不为空
        Objects.requireNonNull(cause, "cause is null");

        // 如果失败的原因是致命的，则通过 sneakyThrow 处理（绕过编译器的检查）
        if (TryModule.isFatal(cause)) {
            TryModule.sneakyThrow(cause);
        }

        // 设置失败的原因
        this.cause = cause;
    }

    /**
     * 获取失败的结果。由于是失败状态，直接抛出失败的原因。
     *
     * @return 无返回值（抛出异常）
     */
    @Override
    public T get() {
        // 通过 sneakyThrow 抛出原因异常
        return TryModule.sneakyThrow(cause);
    }

    /**
     * 获取失败的原因（Throwable）。
     *
     * @return 失败的原因
     */
    @Override
    public Throwable getCause() {
        return cause;
    }

    /**
     * 判断该结果是否为空。对于 Failure 来说，始终返回 true。
     *
     * @return 总是返回 true，表示结果为空
     */
    @Override
    public boolean isEmpty() {
        return true;
    }

    /**
     * 判断该结果是否表示失败。对于 Failure 来说，始终返回 true。
     *
     * @return 总是返回 true，表示失败
     */
    @Override
    public boolean isFailure() {
        return true;
    }

    /**
     * 判断该结果是否表示成功。对于 Failure 来说，始终返回 false。
     *
     * @return 总是返回 false，表示失败
     */
    @Override
    public boolean isSuccess() {
        return false;
    }

    /**
     * 判断该 Failure 对象是否与其他对象相等。
     * 通过比较失败的原因的栈跟踪信息来判断是否相等。
     *
     * @param obj 要比较的对象
     * @return 如果 `obj` 是 Failure 且其 cause 的栈跟踪信息与当前对象一致，则返回 true
     */
    @Override
    public boolean equals(Object obj) {
        // 如果是同一个对象，直接返回 true
        return (obj == this) ||
                (obj instanceof Failure && Arrays.deepEquals(cause.getStackTrace(), ((Failure<?>) obj).cause.getStackTrace()));
    }

    /**
     * 获取 Failure 对象的字符串前缀。
     *
     * @return 字符串前缀 "Failure"
     */
    @Override
    public String stringPrefix() {
        return "Failure";
    }

    /**
     * 计算 Failure 对象的哈希码。
     * 使用失败原因的栈跟踪信息来计算哈希码。
     *
     * @return 哈希码
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(cause.getStackTrace());
    }

    /**
     * 返回 Failure 对象的字符串表示。
     *
     * @return "Failure" + "(" + cause + ")" 的格式字符串，表示失败原因
     */
    @Override
    public String toString() {
        return stringPrefix() + "(" + cause + ")";
    }
}