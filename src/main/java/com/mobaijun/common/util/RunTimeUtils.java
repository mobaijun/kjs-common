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
package com.mobaijun.common.util;

import cn.hutool.core.util.StrUtil;
import com.mobaijun.common.util.constant.NumberConstant;
import com.mobaijun.common.util.constant.StringConstant;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: RunTimeUtils
 * class description： 运行时工具类
 *
 * @author MoBaiJun 2022/7/11 10:02
 */
public class RunTimeUtils {

    private static final AtomicInteger SHUTDOWN_HOOK_THREAD_INDEX = new AtomicInteger(0);

    /**
     * 获得当前进程的PID
     * <p>
     * 当失败时返回-1
     */
    public static int getPid() {
        // format: "pid@hostname"
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        String[] split = jvmName.split(StringConstant.AT);
        if (split.length != NumberConstant.TWO) {
            return NumberConstant.MINUS_ONE;
        }
        try {
            return Integer.parseInt(split[NumberConstant.ZERO]);
        } catch (Exception e) {
            return NumberConstant.MINUS_ONE;
        }
    }

    /**
     * 返回应用启动到现在的毫秒数
     */
    public static long getUpTime() {
        return ManagementFactory.getRuntimeMXBean().getUptime();
    }

    /**
     * 返回输入的JVM参数列表
     */
    public static String getVmArguments() {
        List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        return StrUtil.join(StringConstant.BLANK, vmArguments);
    }


    /**
     * 获取CPU核数
     */
    public static int getCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * 注册JVM关闭时的钩子程序
     */
    public static void addShutdownHook(Runnable runnable) {
        Runtime.getRuntime().addShutdownHook(
                new Thread(runnable, "Thread-ShutDownHook-" + SHUTDOWN_HOOK_THREAD_INDEX.incrementAndGet()));
    }

    /**
     * 通过StackTrace，获得调用者的类名.
     * <p>
     * 获取StackTrace有消耗，不要滥用
     */
    public static String getCallerClass() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        if (stacktrace.length >= NumberConstant.FOUR) {
            StackTraceElement element = stacktrace[NumberConstant.THREE];
            return element.getClassName();
        } else {
            return StringConstant.EMPTY_STRING;
        }
    }

    /**
     * 通过StackTrace，获得调用者的"类名.方法名()"
     * <p>
     * 获取StackTrace有消耗，不要滥用
     */
    public static String getCallerMethod() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        if (stacktrace.length >= NumberConstant.FOUR) {
            StackTraceElement element = stacktrace[NumberConstant.THREE];
            return element.getClassName() + StringConstant.DOT + element.getMethodName() + StringConstant.PARENTHESES;
        } else {
            return StringConstant.EMPTY_STRING;
        }
    }

    /**
     * 通过StackTrace，获得当前方法的类名.
     * <p>
     * 获取StackTrace有消耗，不要滥用
     */
    public static String getCurrentClass() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        if (stacktrace.length >= NumberConstant.THREE) {
            StackTraceElement element = stacktrace[NumberConstant.TWO];
            return element.getClassName();
        } else {
            return StringConstant.EMPTY_STRING;
        }
    }

    /**
     * 通过StackTrace，获得当前方法的"类名.方法名()"
     * <p>
     * 获取StackTrace有消耗，不要滥用
     */
    public static String getCurrentMethod() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        if (stacktrace.length >= NumberConstant.THREE) {
            StackTraceElement element = stacktrace[NumberConstant.TWO];
            return element.getClassName() + StringConstant.DOT + element.getMethodName() + StringConstant.PARENTHESES;
        } else {
            return StringConstant.EMPTY_STRING;
        }
    }
}