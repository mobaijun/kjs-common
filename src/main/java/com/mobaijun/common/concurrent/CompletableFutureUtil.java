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
package com.mobaijun.common.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: [CompletableFuture的工具类，用于在并发环境中简化CompletableFuture的使用。]
 * Author: [mobaijun]
 * Date: [2024/2/1 11:03]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Slf4j
@Builder
@AllArgsConstructor
public class CompletableFutureUtil<T> {

    /**
     * 由该工具类封装的CompletableFuture实例。
     */
    private final CompletableFuture<T> future;

    /**
     * 用于异步执行任务的执行器。默认为CompletableFutureUtil.getDefaultExecutor()提供的默认执行器，除非另有指定。
     */
    @Builder.Default
    private final Executor executor = CompletableFutureUtil.getDefaultExecutor();

    /**
     * 使用由给定的Supplier提供的CompletableFuture创建一个新的CompletableFutureUtil实例。
     *
     * @param supplier 用于生成初始结果的供应商函数。
     * @param <T>      结果的类型。
     * @return 一个CompletableFutureUtil实例。
     */
    public static <T> CompletableFutureUtil<T> supplyAsync(Supplier<T> supplier) {
        return CompletableFutureUtil.<T>builder()
                .future(CompletableFuture.supplyAsync(supplier))
                .build();
    }

    /**
     * 检索该工具类使用的默认执行器。
     * 如果需要，自定义默认执行器。
     *
     * @return 默认执行器。
     */
    private static Executor getDefaultExecutor() {
        // 如果需要，自定义默认执行器
        return CompletableFuture.delayedExecutor(0, TimeUnit.MILLISECONDS, Runnable::run);
    }

    /**
     * 异步应用给定的函数到当前CompletableFutureUtil的结果。
     *
     * @param function 要应用的函数。
     * @return 具有应用函数的新CompletableFutureUtil实例。
     */
    public CompletableFutureUtil<T> thenApply(Function<T, T> function) {
        return CompletableFutureUtil.<T>builder()
                .future(future.thenApplyAsync(function, executor))
                .executor(executor)
                .build();
    }

    /**
     * 异步接受结果并在其上执行给定的操作。
     *
     * @param consumer 要对结果执行的操作。
     * @return 具有应用操作的新CompletableFutureUtil实例。
     */
    public CompletableFutureUtil<Void> thenAcceptAsync(Consumer<T> consumer) {
        return CompletableFutureUtil.<Void>builder()
                .future(future.thenAcceptAsync(consumer, executor))
                .executor(executor)
                .build();
    }

    /**
     * 等待必要时等待计算完成，然后返回结果。
     *
     * @return 计算出的结果。
     */
    public T join() {
        return future.join();
    }

    /**
     * 等待必要时等待计算完成，然后检索其结果。
     *
     * @return 计算出的结果。
     * @throws CompletionException 如果计算抛出异常。
     */
    @SneakyThrows
    public T get() {
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CompletionException(e);
        }
    }
}
