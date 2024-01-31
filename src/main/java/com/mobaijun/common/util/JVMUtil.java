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
package com.mobaijun.common.util;

import com.mobaijun.common.constant.NumberConstant;
import com.mobaijun.common.constant.StringConstant;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: JVMUtil<br>
 * class description： 提供与 JVM 相关的实用方法<br>
 *
 * @author MoBaiJun 2022/7/11 10:02
 */
public class JVMUtil {

    private static final AtomicInteger SHUTDOWN_HOOK_THREAD_INDEX = new AtomicInteger(0);

    /**
     * 获取当前进程的 PID。
     *
     * @return 当前进程的 PID，获取失败时返回 -1。
     */
    public static int getProcessId() {
        // 格式: "pid@hostname"
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        String[] split = jvmName.split(StringConstant.AT);
        if (split.length != NumberConstant.TWO) {
            return NumberConstant.MINUS_ONE;
        }
        try {
            return Integer.parseInt(split[NumberConstant.ZERO]);
        } catch (NumberFormatException e) {
            return NumberConstant.MINUS_ONE;
        }
    }

    /**
     * 获取应用启动到现在的毫秒数。
     *
     * @return 应用启动到现在的毫秒数。
     */
    public static long getUptime() {
        return ManagementFactory.getRuntimeMXBean().getUptime();
    }

    /**
     * 获取 JVM 的输入参数列表。
     *
     * @return JVM 输入参数列表的字符串表示。
     */
    public static String getVMArguments() {
        List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        return String.join(StringConstant.BLANK, vmArguments);
    }

    /**
     * 获取 CPU 核数。
     *
     * @return CPU 核数。
     */
    public static int getCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * 注册 JVM 关闭时的钩子程序。
     *
     * @param runnable 关闭时执行的任务。
     */
    public static void addShutdownHook(Runnable runnable) {
        Runtime.getRuntime().addShutdownHook(
                new Thread(runnable, "ShutdownHook-" + SHUTDOWN_HOOK_THREAD_INDEX.incrementAndGet()));
    }

    /**
     * 通过 StackTrace 获得调用者的类名。
     *
     * @return 调用者的类名。
     */
    public static String getCallerClass() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= NumberConstant.FOUR) {
            StackTraceElement element = stackTrace[NumberConstant.THREE];
            return element.getClassName();
        } else {
            return StringConstant.EMPTY_STRING;
        }
    }

    /**
     * 通过 StackTrace 获得调用者的 "类名.方法名()"。
     *
     * @return 调用者的 "类名.方法名()"。
     */
    public static String getCallerMethod() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= NumberConstant.FOUR) {
            StackTraceElement element = stackTrace[NumberConstant.THREE];
            return element.getClassName() + StringConstant.DOT + element.getMethodName() + StringConstant.PARENTHESES;
        } else {
            return StringConstant.EMPTY_STRING;
        }
    }

    /**
     * 通过 StackTrace 获得当前方法的类名。
     *
     * @return 当前方法的类名。
     */
    public static String getCurrentClass() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= NumberConstant.THREE) {
            StackTraceElement element = stackTrace[NumberConstant.TWO];
            return element.getClassName();
        } else {
            return StringConstant.EMPTY_STRING;
        }
    }

    /**
     * 通过 StackTrace 获得当前方法的 "类名.方法名()"。
     *
     * @return 当前方法的 "类名.方法名()"。
     */
    public static String getCurrentMethod() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= NumberConstant.THREE) {
            StackTraceElement element = stackTrace[NumberConstant.TWO];
            return element.getClassName() + StringConstant.DOT + element.getMethodName() + StringConstant.PARENTHESES;
        } else {
            return StringConstant.EMPTY_STRING;
        }
    }
}