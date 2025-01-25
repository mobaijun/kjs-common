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