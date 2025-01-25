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
package com.mobaijun.common.text;

import java.text.DecimalFormat;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: [控制台进度条工具类]
 * Author: [mobaijun]
 * Date: [2025/1/24 18:54]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class ProgressBarUtil {

    /**
     * 进度条默认参数、进度条长度（字符数）
     */
    private static final int DEFAULT_BAR_LENGTH = 50;

    /**
     * 进度填充字符
     */
    private static final char DEFAULT_PROGRESS_CHAR = '=';

    /**
     * 进度头字符
     */
    private static final char DEFAULT_HEAD_CHAR = '>';

    /**
     * 未完成部分字符
     */
    private static final char DEFAULT_REMAINING_CHAR = ' ';
    /**
     * 锁
     */
    private static final ReentrantLock lock = new ReentrantLock();
    /**
     * 进度状态变量/总任务量
     */
    private static long total;
    /**
     * 当前进度
     */
    private static long current;
    /**
     * 是否正在运行
     */
    private static boolean isRunning;
    /**
     * 可配置的进度条参数
     */
    private static int barLength = DEFAULT_BAR_LENGTH;
    private static char progressChar = DEFAULT_PROGRESS_CHAR;
    private static char headChar = DEFAULT_HEAD_CHAR;
    private static char remainingChar = DEFAULT_REMAINING_CHAR;

    /**
     * 禁止实例化
     */
    private ProgressBarUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * 初始化进度条
     *
     * @param total 总任务量
     */
    public static void init(long total) {
        lock.lock();
        try {
            ProgressBarUtil.total = total;
            current = 0;
            isRunning = true;
            printProgress();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 更新进度（自动累加）
     *
     * @param increment 增加量
     */
    public static void update(long increment) {
        if (!isRunning) return;
        lock.lock();
        try {
            current = Math.min(current + increment, total);
            printProgress();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 直接设置当前进度
     *
     * @param current 当前进度值
     */
    public static void setCurrent(long current) {
        if (!isRunning) return;
        lock.lock();
        try {
            ProgressBarUtil.current = Math.min(current, total);
            printProgress();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 完成进度条
     */
    public static void complete() {
        lock.lock();
        try {
            isRunning = false;
            current = total;
            printProgress();
            System.out.println("\n任务已完成!");
        } finally {
            lock.unlock();
        }
    }

    /**
     * 中断进度条
     */
    public static void interrupt() {
        lock.lock();
        try {
            isRunning = false;
            System.out.println("\n任务已中断!");
        } finally {
            lock.unlock();
        }
    }

    /**
     * 绘制进度条
     */
    private static void printProgress() {
        if (total <= 0) return;

        double percent = (double) current / total;
        DecimalFormat df = new DecimalFormat("0.00%");
        String percentStr = df.format(percent);

        int progressChars = (int) (percent * barLength);
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < progressChars) {
                bar.append(progressChar);
            } else if (i == progressChars) {
                bar.append(headChar);
            } else {
                bar.append(remainingChar);
            }
        }
        bar.append("] ").append(percentStr);

        // 输出进度（使用回车符覆盖当前行）
        System.out.print("\r" + bar);
    }

    /**
     * 用于自定义进度条参数的构造方法
     */
    public static class Builder {
        private int barLength = DEFAULT_BAR_LENGTH;
        private char progressChar = DEFAULT_PROGRESS_CHAR;
        private char headChar = DEFAULT_HEAD_CHAR;
        private char remainingChar = DEFAULT_REMAINING_CHAR;

        public Builder setBarLength(int barLength) {
            this.barLength = Math.max(1, barLength);
            return this;
        }

        public Builder setProgressChar(char progressChar) {
            this.progressChar = progressChar;
            return this;
        }

        public Builder setHeadChar(char headChar) {
            this.headChar = headChar;
            return this;
        }

        public Builder setRemainingChar(char remainingChar) {
            this.remainingChar = remainingChar;
            return this;
        }

        public void apply() {
            ProgressBarUtil.barLength = this.barLength;
            ProgressBarUtil.progressChar = this.progressChar;
            ProgressBarUtil.headChar = this.headChar;
            ProgressBarUtil.remainingChar = this.remainingChar;
        }
    }
}