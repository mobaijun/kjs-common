package com.mobaijun.common.tool;

import org.junit.Test;

/**
 * Description: [ExecutionMonitorTest测试类]
 * Author: [mobaijun]
 * Date: [2024/4/23 17:17]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class ExecutionMonitorTest {

    @Test
    public void startTimer() {
        ExecutionMonitor.startTimer();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        ExecutionMonitor.stopAndPrintInMillis();
    }

    @Test
    public void stopInMillis() {
    }

    @Test
    public void stopInNanos() {
    }

    @Test
    public void stopAndPrintMemoryUsage() {
    }

    @Test
    public void stopAndPrintInMillis() {
    }

    @Test
    public void stopAndPrintInNanos() {
    }

    @Test
    public void stopAndPrintInSeconds() {
    }
}