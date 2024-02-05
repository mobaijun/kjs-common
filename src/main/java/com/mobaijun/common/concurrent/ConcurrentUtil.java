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

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Description: [并发工具类，用于执行并发任务。]
 * Author: [mobaijun]
 * Date: [2024/2/1 11:21]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class ConcurrentUtil {

    private static final int DEFAULT_THREAD_POOL_SIZE = 10;

    private final ExecutorService executorService;

    /**
     * 构造函数，使用默认线程池大小初始化并发工具类。
     */
    public ConcurrentUtil() {
        this(DEFAULT_THREAD_POOL_SIZE);
    }

    /**
     * 构造函数，使用指定的线程池大小初始化并发工具类。
     *
     * @param threadPoolSize 线程池大小。
     */
    public ConcurrentUtil(int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    /**
     * 创建一个带有延迟的任务，用于模拟耗时操作。
     *
     * @param result      任务的返回结果。
     * @param delayMillis 延迟的毫秒数。
     * @param <T>         任务的返回类型。
     * @return 带有延迟的任务。
     */
    public static <T> Callable<T> taskWithDelay(T result, long delayMillis) {
        return () -> {
            Thread.sleep(delayMillis);
            return result;
        };
    }

    /**
     * 执行给定的任务列表，并返回任务的异步执行结果。
     *
     * @param tasks 任务列表。
     * @param <T>   任务的返回类型。
     * @return 一组包含任务异步执行结果的 Future 对象。
     * @throws InterruptedException 如果等待中断。
     */
    public <T> List<Future<T>> executeTasks(List<Callable<T>> tasks) throws InterruptedException {
        try {
            return executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw e;
        }
    }

    /**
     * 关闭线程池，不再接受新的任务。
     */
    public void shutdown() {
        executorService.shutdown();
    }

    /**
     * 尝试停止所有正在执行的任务，暂停处理已提交的任务，并返回等待执行的任务列表。
     *
     * @return 等待执行的任务列表。
     */
    public List<Runnable> shutdownNow() {
        return executorService.shutdownNow();
    }

    /**
     * 如果此执行程序已关闭，则返回 true。
     *
     * @return 如果此执行程序已关闭，则返回 true。
     */
    public boolean isShutdown() {
        return executorService.isShutdown();
    }

    /**
     * 如果所有任务在关闭后立即完成，则返回 true。
     *
     * @return 如果所有任务在关闭后立即完成，则返回 true。
     */
    public boolean isTerminated() {
        return executorService.isTerminated();
    }

    /**
     * 在此执行程序的关闭之前，如果所有任务都已经完成，则返回 true。
     *
     * @param timeout 等待的最长时间。
     * @param unit    时间单位。
     * @return 如果在关闭之前所有任务都已经完成，则返回 true。
     * @throws InterruptedException 如果等待中断。
     */
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executorService.awaitTermination(timeout, unit);
    }
}
