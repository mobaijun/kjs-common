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

/**
 * `TryModule` 接口包含了用于处理 `Throwable` 类型异常的工具方法。
 * <p>此接口的主要目的是帮助检测致命异常并提供一种方式通过反射机制"偷偷"抛出异常。</p>
 */
public interface TryModule {

    /**
     * 检查给定的异常是否属于致命异常。
     * <p>致命异常通常指的是系统级的错误，无法恢复，应用程序无法处理。</p>
     *
     * @param throwable 要检查的异常
     * @return 如果是致命异常（如 {@link InterruptedException}、{@link LinkageError} 等），返回 {@code true}；否则返回 {@code false}
     */
    static boolean isFatal(Throwable throwable) {
        return throwable instanceof InterruptedException
                || throwable instanceof LinkageError
                || throwable instanceof ThreadDeath
                || throwable instanceof VirtualMachineError;
    }

    /**
     * 通过反射机制抛出指定的异常。这种方式用于避免编译器在处理受检异常时的检查。
     * <p>此方法用于那些不希望显式声明抛出异常的场景，尤其是在某些特殊情况下绕过 Java 的类型系统。</p>
     *
     * @param <T> 异常的类型
     * @param <R> 返回值的类型
     * @param t   要抛出的异常
     * @throws T 被抛出的异常
     */
    // DEV-NOTE: we do not plan to expose this as public API
    @SuppressWarnings("unchecked")
    static <T extends Throwable, R> R sneakyThrow(Throwable t) throws T {
        throw (T) t;
    }
}