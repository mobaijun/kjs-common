package com.mobaijun.common.util.log;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
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
     * 异步操作记录日志的线程池
     */
    public static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);

    private LogManager() {
    }

    public static LogManager logManager = new LogManager();

    public static LogManager me() {
        return logManager;
    }

    public void executeLog(TimerTask task) {
        // 日志记录操作延时
        int operateDelayTime = 10;
        executorService.schedule(task, operateDelayTime, TimeUnit.MILLISECONDS);
    }
}
