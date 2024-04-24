package com.mobaijun.common.tool;

import java.util.concurrent.TimeUnit;

/**
 * Description: [ExecutionMonitor 类用于监控代码执行时间和测量内存使用量。]
 * Author: [mobaijun]
 * Date: [2024/4/23 16:37]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class ExecutionMonitor {

    /**
     * JVM 运行时对象。
     */
    private static final Runtime runtime = Runtime.getRuntime();
    /**
     * 记录开始时间和结束时间。
     */
    private static long startTime;
    private static long endTime;

    /**
     * 开始计时。
     */
    public static void startTimer() {
        startTime = System.nanoTime();
    }

    /**
     * 停止计时并打印执行时间（毫秒）。
     */
    public static void stopInMillis() {
        endTimer();
        long elapsedTimeInMillis = getElapsedTime(TimeUnit.MILLISECONDS);
        Console.println("执行时间： " + elapsedTimeInMillis + " 毫秒");
    }

    /**
     * 停止计时并打印执行时间（纳秒）。
     */
    public static void stopInNanos() {
        endTimer();
        long elapsedTimeInNanos = getElapsedTime(TimeUnit.NANOSECONDS);
        Console.println("执行时间： " + elapsedTimeInNanos + " 纳秒");
    }

    /**
     * 停止计时并打印内存使用量。
     */
    public static void stopAndPrintMemoryUsage() {
        endTimer();
        long memoryUsed = getMemoryUsage();
        Console.println("内存使用量： " + memoryUsed + " 字节");
    }

    /**
     * 停止计时并打印执行时间和内存使用量（毫秒）。
     */
    public static void stopAndPrintInMillis() {
        endTimer();
        long elapsedTimeInMillis = getElapsedTime(TimeUnit.MILLISECONDS);
        long memoryUsed = getMemoryUsage();
        Console.println("执行时间： " + elapsedTimeInMillis + " 毫秒，内存使用量： " + formatMemory(memoryUsed));
    }

    /**
     * 停止计时并打印执行时间和内存使用量（纳秒）。
     */
    public static void stopAndPrintInNanos() {
        endTimer();
        long elapsedTimeInNanos = getElapsedTime(TimeUnit.NANOSECONDS);
        long memoryUsed = getMemoryUsage();
        Console.println("执行时间： " + elapsedTimeInNanos + " 纳秒，内存使用量： " + formatMemory(memoryUsed));
    }

    /**
     * 停止计时并打印执行时间和内存使用量（秒）。
     */
    public static void stopAndPrintInSeconds() {
        endTimer();
        long elapsedTimeInSeconds = getElapsedTime(TimeUnit.SECONDS);
        long memoryUsed = getMemoryUsage();
        Console.println("执行时间： " + elapsedTimeInSeconds + " 秒，内存使用量： " + formatMemory(memoryUsed));
    }

    /**
     * 停止计时。
     */
    private static void endTimer() {
        endTime = System.nanoTime();
    }

    /**
     * 计算开始计时和停止计时之间的执行时间，并以指定时间单位返回。
     *
     * @param timeUnit 时间单位
     * @return 执行时间
     */
    private static long getElapsedTime(TimeUnit timeUnit) {
        long elapsedTime = endTime - startTime;
        return timeUnit.convert(elapsedTime, TimeUnit.NANOSECONDS);
    }

    /**
     * 获取 JVM 的内存使用量（经过垃圾回收后）。
     *
     * @return JVM 的内存使用量（字节）
     */
    private static long getMemoryUsage() {
        // 提醒 JVM 进行垃圾回收
        runtime.gc();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    /**
     * 格式化内存使用量，自动选择合适的单位（MB、KB、Bytes）。
     *
     * @param memoryBytes 内存使用量（字节）
     * @return 格式化后的内存使用量字符串
     */
    private static String formatMemory(long memoryBytes) {
        if (memoryBytes < 1024) {
            return memoryBytes + " Bytes";
        } else if (memoryBytes < 1024 * 1024) {
            return memoryBytes / 1024 + " KB";
        } else {
            return String.format("%.2f MB", (double) memoryBytes / (1024 * 1024));
        }
    }
}
