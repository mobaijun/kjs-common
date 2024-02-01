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

import com.mobaijun.common.tool.ExceptionUtil;
import com.mobaijun.common.tool.PrintUtil;
import org.junit.Test;

/**
 * Description: [ExceptionUtilTest测试类]
 * Author: [mobaijun]
 * Date: [2023/12/26 17:23]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class ExceptionUtilTest {

    @Test
    public void testGetStackTrace() {
        try {
            // 触发一个异常
            int result = 1 / 0;
        } catch (Exception e) {
            String stackTrace = ExceptionUtil.getStackTrace(e);
            PrintUtil.println(stackTrace);
        }
    }

    @Test
    public void testStackTraceToString() {
        try {
            // 触发一个异常
            int result = 1 / 0;
        } catch (Exception e) {
            String exceptionName = e.getClass().getName();
            String exceptionMessage = e.getMessage();
            StackTraceElement[] elements = e.getStackTrace();

            String result = ExceptionUtil.stackTraceToString(exceptionName, exceptionMessage, elements);
            PrintUtil.println(result);
        }
    }

    @Test
    public void testToString() {
        try {
            // 触发一个异常
            int result = 1 / 0;
        } catch (Exception e) {
            String result = ExceptionUtil.toString(e);
            PrintUtil.println(result);
        }
    }
}