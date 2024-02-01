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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: ExceptionUtil<br>
 * class description: 异常工具类<br>
 *
 * @author MoBaiJun 2022/12/8 9:38
 */
public class ExceptionUtil {

    /**
     * 获取异常的堆栈信息
     *
     * @param throwable 异常对象
     * @return 堆栈信息字符串
     */
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }

    /**
     * 将异常信息转换为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     * @return 转换后的字符串
     */
    public static String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuilder str = new StringBuilder();
        Arrays.stream(elements).forEach(item -> str.append(item).append("\n"));
        return exceptionName + ":" + exceptionMessage + "\n\t" + str;
    }

    /**
     * 将异常对象转换为字符串
     *
     * @param e 异常对象
     * @return 转换后的字符串
     */
    public static String toString(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        try (PrintWriter printWriter = new PrintWriter(stringWriter)) {
            e.printStackTrace(printWriter);
            return stringWriter.toString();
        }
    }
}