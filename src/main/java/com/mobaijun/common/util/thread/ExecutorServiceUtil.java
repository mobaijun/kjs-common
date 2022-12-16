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
package com.mobaijun.common.util.thread;

import com.mobaijun.common.constant.DefaultValues;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: ExecutorServiceUtil<br>
 * class description：线程池工具类<br>
 *
 * @author MoBaiJun 2022/5/31 11:38
 */
public class ExecutorServiceUtil {
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {

        private final ThreadFactory defaultFactory = Executors.defaultThreadFactory();
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        private static final String THREAD_NAME_PREFIX = "april-";

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = defaultFactory.newThread(r);
            if (!thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setName(THREAD_NAME_PREFIX + threadNumber.getAndIncrement());
            return thread;
        }
    };

    /**
     * 创建一个定时调度线程池
     *
     * @return ScheduledExecutorService
     */
    static public ScheduledExecutorService newScheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(DefaultValues.Thread.SCHEDULED_EXECUTOR_POOL_SIZE, THREAD_FACTORY);
    }

    /**
     * 创建只有一个线程的调度线程池
     *
     * @return ScheduledExecutorService
     */
    static public ScheduledExecutorService newSingleScheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(1, THREAD_FACTORY);
    }

    /**
     * 创建单例线程池
     *
     * @return ExecutorService
     */
    static public ExecutorService newSingleExecutorService() {
        return Executors.newSingleThreadExecutor(THREAD_FACTORY);
    }


    /**
     * 创建一个通用连接池
     *
     * @return executor service
     */
    static public ExecutorService newExecutorService() {
        return new ThreadPoolExecutor(DefaultValues.Thread.CORE_POOL_SIZE,
                DefaultValues.Thread.MAX_POOL_SIZE, 0L,
                TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
                THREAD_FACTORY);
    }

    /**
     * 关闭一个线程连接池
     *
     * @param executorService 要关闭的线程池
     */
    static public void shutdown(ExecutorService executorService) {
        executorService.shutdownNow();
    }

    /**
     * 获取默认的线程工厂
     *
     * @return ThreadFactory
     */
    static public ThreadFactory getDefaultTreadFactory() {
        return THREAD_FACTORY;
    }
}