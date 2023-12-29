package com.mobaijun.common.util;

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