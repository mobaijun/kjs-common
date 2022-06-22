package com.mobaijun.common.util.log;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import com.mobaijun.common.util.constant.NumberConstant;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: LogManager
 * class description： 日志管理器
 *
 * @author MoBaiJun 2022/5/11 14:11
 */
public class LogManager {

    /**
     * 设置线程名称
     */
    public static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNamePrefix("thread-log-%d").build();

    /**
     * 异步操作记录日志的线程池
     */
    public static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(NumberConstant.TEN, threadFactory);

    private LogManager() {
    }

    public static LogManager logManager = new LogManager();

    public LogManager me() {
        return logManager;
    }

    public void executeLog(TimerTask task) {
        // 日志记录操作延时
        executorService.schedule(task, NumberConstant.TEN, TimeUnit.MILLISECONDS);
    }
}
