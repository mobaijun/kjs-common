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

import cn.hutool.log.Log;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: ThreadPrint<br>
 * class description： 打印线程池状态<br>
 *
 * @author MoBaiJun 2022/9/13 14:13
 */
public class ThreadPrint {

    /**
     * tools log
     */
    private static final Log log = Log.get(ThreadPrint.class);

    /**
     * 打印线程池状态
     *
     * @param executor 线程池
     */
    public static void printThreadPoolStatus(ThreadPoolExecutor executor) {
        int poolSize = executor.getPoolSize();
        int corePoolSize = executor.getCorePoolSize();
        int activeCount = executor.getActiveCount();
        long completedTaskCount = executor.getCompletedTaskCount();
        long taskCount = executor.getTaskCount();
        int queueCount = executor.getQueue().size();
        int largestPoolSize = executor.getLargestPoolSize();
        int maximumPoolSize = executor.getMaximumPoolSize();
        long time = executor.getKeepAliveTime(TimeUnit.MILLISECONDS);
        boolean isShutDown = executor.isShutdown();
        boolean isTerminated = executor.isTerminated();
        String info = String.format("初始线程数：%s、核心线程数：%s、正在执行的任务数量：%s、已完成任务数量：%s、任务总数：%s、" +
                        "队列里缓存的任务数量：%s、池中存在的最大线程数：%s、最大允许的线程数：%s、线程空闲时间：%s、线程池是否关闭：%s、" +
                        "线程池是否终止：%s", poolSize, corePoolSize, activeCount, completedTaskCount, taskCount, queueCount,
                largestPoolSize, maximumPoolSize, time, isShutDown, isTerminated);
        log.info(info);
    }
}