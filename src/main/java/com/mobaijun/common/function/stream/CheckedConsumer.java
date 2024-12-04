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
package com.mobaijun.common.function.stream;

/**
 * <p>
 * 函数式接口，表示一个可以抛出受检异常的 {@link java.util.function.Consumer} 操作。
 * <p>与 {@link java.util.function.Consumer} 接口不同，该接口的 {@code accept} 方法允许抛出受检异常。
 * 适用于需要在消费操作中处理或传播受检异常的场景。</p>
 *
 * @param <T> 输入参数的类型
 */
@FunctionalInterface
public interface CheckedConsumer<T> {

    /**
     * 接收一个输入并执行操作，允许抛出受检异常。
     *
     * @param t 输入的参数
     * @throws Throwable 允许抛出受检异常
     */
    void accept(T t) throws Throwable;
}
