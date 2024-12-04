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

import com.mobaijun.common.function.stream.CheckedConsumer;
import com.mobaijun.common.function.stream.CheckedRunnable;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 尝试操作的封装类，表示操作的成功或失败。
 *
 * @param <T> 封装的成功值类型
 */
public abstract class Try<T> {

    /**
     * 判断当前Try对象是否表示失败。
     *
     * @return 如果是失败，返回true，否则返回false
     */
    public abstract boolean isFailure();

    /**
     * 获取当前Try对象中的成功值。
     *
     * @return 如果是成功，则返回存储的值，否则抛出异常
     */
    public abstract T get();

    /**
     * 获取当前Try对象中的错误原因。
     *
     * @return 如果是失败，则返回失败原因；成功时返回null
     */
    public abstract Throwable getCause();

    /**
     * 判断当前Try对象是否为空。
     *
     * @return 如果为空，返回true，否则返回false
     */
    public abstract boolean isEmpty();

    /**
     * 判断当前Try对象是否表示成功。
     *
     * @return 如果是成功，返回true，否则返回false
     */
    public abstract boolean isSuccess();

    /**
     * 返回Try对象的前缀字符串。
     *
     * @return 当前Try对象的前缀字符串
     */
    public abstract String stringPrefix();

    /**
     * 如果当前Try对象表示成功，则执行传入的`CheckedRunnable`，并返回当前Try对象。
     * 如果当前Try对象表示失败，则直接返回该Try对象。
     *
     * @param runnable 被执行的`CheckedRunnable`
     * @return 当前Try对象或执行后的Try对象
     * @throws NullPointerException 如果`runnable`为null
     */
    public final Try<T> andThen(CheckedRunnable runnable) {
        Objects.requireNonNull(runnable, "runnable is null");
        if (isFailure()) {
            return this;
        } else {
            try {
                runnable.run();
                return this;
            } catch (Throwable t) {
                return new Failure<>(t);
            }
        }
    }

    /**
     * 如果当前Try对象表示成功，则执行传入的`CheckedConsumer`，并返回当前Try对象。
     * 如果当前Try对象表示失败，则直接返回该Try对象。
     *
     * @param consumer 被执行的`CheckedConsumer`
     * @return 当前Try对象或执行后的Try对象
     * @throws NullPointerException 如果`consumer`为null
     */
    public final Try<T> andThen(CheckedConsumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        if (isFailure()) {
            return this;
        } else {
            try {
                consumer.accept(get());
                return this;
            } catch (Throwable t) {
                return new Failure<>(t);
            }
        }
    }

    /**
     * 如果当前Try对象表示失败，则执行传入的操作。
     *
     * @param action 失败时执行的操作
     * @return 当前Try对象
     * @throws NullPointerException 如果`action`为null
     */
    public final Try<T> onFailure(Consumer<? super Throwable> action) {
        Objects.requireNonNull(action, "action is null");
        if (isFailure()) {
            action.accept(getCause());
        }
        return this;
    }

    /**
     * 如果当前Try对象表示失败并且`isThrow`为true，则抛出失败的异常。
     *
     * @param isThrow 是否抛出异常
     * @return 当前Try对象
     */
    public final Try<T> onFailure(boolean isThrow) {
        if (isThrow && isFailure()) {
            throw new RuntimeException(getCause());
        }
        return this;
    }

    /**
     * 如果当前Try对象表示失败，则根据给定的处理函数将异常转换为另一种类型并抛出。
     *
     * @param action 失败时执行的转换操作
     * @param <E>    异常类型
     * @return 当前Try对象
     * @throws RuntimeException 转换后的异常
     */
    public final <E extends Throwable> Try<T> onFailure(Function<? super Throwable, E> action) {
        Objects.requireNonNull(action, "action is null");
        if (isFailure()) {
            final E apply = action.apply(getCause());
            throw new RuntimeException(apply);
        }
        return this;
    }

    /**
     * 如果当前Try对象表示失败，并且失败的异常类型与指定的异常类型匹配，则执行指定的操作。
     *
     * @param exceptionType 异常类型
     * @param action        异常处理操作
     * @param <X>           异常类型
     * @return 当前Try对象
     * @throws NullPointerException 如果`exceptionType`或`action`为null
     */
    @SuppressWarnings("unchecked")
    public final <X extends Throwable> Try<T> onFailure(Class<X> exceptionType, Consumer<? super X> action) {
        Objects.requireNonNull(exceptionType, "exceptionType is null");
        Objects.requireNonNull(action, "action is null");
        if (isFailure() && exceptionType.isAssignableFrom(getCause().getClass())) {
            action.accept((X) getCause());
        }
        return this;
    }

    /**
     * 执行一个`CheckedRunnable`，并返回当前Try对象。
     * 如果执行过程中发生异常，返回失败的Try对象。
     *
     * @param runnable 被执行的`CheckedRunnable`
     * @return 当前Try对象
     * @throws NullPointerException 如果`runnable`为null
     */
    public final Try<T> andFinally(CheckedRunnable runnable) {
        Objects.requireNonNull(runnable, "runnable is null");
        try {
            runnable.run();
            return this;
        } catch (Throwable t) {
            return new Failure<>(t);
        }
    }
}