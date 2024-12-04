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
package com.mobaijun.common.collection.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 封装操作值的工具类，提供一系列针对单一值（如对象或集合）的常用操作。
 *
 * @param <V> 值的类型
 */
public class Op<V> {

    /**
     * 操作的值。
     */
    private final V v;

    /**
     * 构造方法，初始化操作值。
     *
     * @param v 操作的值
     */
    public Op(V v) {
        this.v = v;
    }

    /**
     * 对当前值应用映射函数，并返回一个新的 {@link Op} 实例。
     *
     * @param <R>  映射后的值类型
     * @param func 映射函数
     * @return 映射后的 {@link Op} 实例
     */
    public <R> Op<R> map(Function<V, R> func) {
        R r = func.apply(v);
        return new Op<>(r);
    }

    /**
     * 判断当前值是否不为空（不为空即值不为 null，且不为空字符串、集合、数组等）。
     *
     * @return 如果值不为空，返回 {@code true}，否则返回 {@code false}
     */
    public boolean isNotBlank() {
        return !isBlank();
    }

    /**
     * 如果当前值为空（即为 null，空字符串、空集合等），则执行指定的消费者操作。
     *
     * @param consumer 值为空时执行的操作
     */
    public void isBlank(Consumer<V> consumer) {
        if (isBlank()) {
            consumer.accept(v);
        }
    }

    /**
     * 如果当前值为空，则执行指定的消费者操作，否则执行指定的 {@link Runnable} 操作。
     *
     * @param consumer 值为空时执行的操作
     * @param runnable 值不为空时执行的操作
     */
    public void isBlankOrElse(Consumer<V> consumer, Runnable runnable) {
        if (isBlank()) {
            consumer.accept(v);
        } else {
            runnable.run();
        }
    }

    /**
     * 如果当前值不为空（即值非 null，且非空字符串、集合、数组等），则执行指定的消费者操作。
     *
     * @param consumer 值不为空时执行的操作
     */
    public void isNotBlank(Consumer<V> consumer) {
        if (isNotBlank()) {
            consumer.accept(v);
        }
    }

    /**
     * 如果当前值不为空，则执行指定的消费者操作，否则执行指定的 {@link Runnable} 操作。
     *
     * @param consumer 值不为空时执行的操作
     * @param runnable 值为空时执行的操作
     */
    public void isNotBlankOrElse(Consumer<V> consumer, Runnable runnable) {
        if (isNotBlank()) {
            consumer.accept(v);
        } else {
            runnable.run();
        }
    }

    /**
     * 判断当前值是否为空。判断标准包括：null、空字符串、空集合、空数组等。
     *
     * @return 如果值为空，返回 {@code true}，否则返回 {@code false}
     */
    public boolean isBlank() {
        if (v == null) {
            return true;
        } else if (v instanceof Optional) {
            return ((Optional<?>) v).isEmpty();
        } else if (v instanceof CharSequence vStr) {
            return vStr.isEmpty();
        } else if (v instanceof Collection) {
            return ((Collection<?>) v).isEmpty();
        } else if (v.getClass().isArray()) {
            return Array.getLength(v) == 0;
        } else if (v instanceof Map) {
            return ((Map<?, ?>) v).isEmpty();
        }
        return false;
    }

    /**
     * 获取当前值。如果值为 null，则抛出 {@link NoSuchElementException} 异常。
     *
     * @return 当前值
     * @throws NoSuchElementException 如果当前值为 null
     */
    public V get() {
        if (v == null) {
            throw new NoSuchElementException("No value present");
        }
        return v;
    }

    /**
     * 获取当前值。如果值为 null，则返回指定的默认值。
     *
     * @param defaultValue 默认值
     * @return 当前值，如果当前值为 null，则返回默认值
     */
    public V get(V defaultValue) {
        if (v == null) {
            return defaultValue;
        }
        return v;
    }
}