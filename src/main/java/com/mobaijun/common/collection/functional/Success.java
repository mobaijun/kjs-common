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
import java.util.Objects;

/**
 * 表示操作成功的 {@link Try} 对象，封装了成功的值。
 * <p>
 * 该类继承自 {@link Try}，用于表示操作成功时的结果，其中包含一个成功的值。它提供了一些方法来访问成功的值，并判断该 {@link Try} 对象是否表示成功或失败。
 * </p>
 *
 * @param <T> 封装的成功值的类型
 */
public final class Success<T> extends Try<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 成功值。
     */
    private final T value;

    /**
     * 构造一个 {@link Success} 对象，用于表示操作成功的结果。
     *
     * @param value 成功的值
     * @throws NullPointerException 如果 {@code value} 为 null，则抛出空指针异常
     */
    public Success(T value) {
        this.value = value;
    }

    /**
     * 获取当前 {@link Success} 对象中的成功值。
     *
     * @return 成功的值
     */
    @Override
    public T get() {
        return value;
    }

    /**
     * 获取当前 {@link Success} 对象中的错误原因。
     * 由于 {@link Success} 表示成功的结果，因此该方法返回 {@code null}。
     *
     * @return {@code null}，表示没有错误原因
     */
    @Override
    public Throwable getCause() {
        return null;
    }

    /**
     * 判断当前 {@link Success} 对象是否为空。
     * 对于 {@link Success} 来说，始终返回 {@code false}，表示该对象不为空。
     *
     * @return {@code false}，表示 {@link Success} 对象不为空
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 判断当前 {@link Success} 对象是否表示失败。
     * 对于 {@link Success} 来说，始终返回 {@code false}，表示它不表示失败。
     *
     * @return {@code false}，表示 {@link Success} 对象不表示失败
     */
    @Override
    public boolean isFailure() {
        return false;
    }

    /**
     * 判断当前 {@link Success} 对象是否表示成功。
     * 对于 {@link Success} 来说，始终返回 {@code true}，表示它表示成功。
     *
     * @return {@code true}，表示 {@link Success} 对象表示成功
     */
    @Override
    public boolean isSuccess() {
        return true;
    }

    /**
     * 判断当前 {@link Success} 对象是否与其他对象相等。
     * 通过比较成功值来判断是否相等。
     *
     * @param obj 要比较的对象
     * @return 如果 {@code obj} 是 {@link Success} 且其成功值与当前对象一致，则返回 {@code true}
     */
    @Override
    public boolean equals(Object obj) {
        return (obj == this) || (obj instanceof Success && Objects.equals(value, ((Success<?>) obj).value));
    }

    /**
     * 计算当前 {@link Success} 对象的哈希码。
     * 使用成功值的哈希码来计算哈希值。
     *
     * @return 当前 {@link Success} 对象的哈希码
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    /**
     * 获取 {@link Success} 对象的前缀字符串。
     *
     * @return {@code "Success"} 字符串
     */
    @Override
    public String stringPrefix() {
        return "Success";
    }

    /**
     * 返回 {@link Success} 对象的字符串表示。
     * 格式为 "Success(value)"，表示成功的值。
     *
     * @return 当前 {@link Success} 对象的字符串表示
     */
    @Override
    public String toString() {
        return stringPrefix() + "(" + value + ")";
    }
}