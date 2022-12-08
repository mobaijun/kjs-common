package com.mobaijun.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: ThrowableUtils<br>
 * class description: 异常工具类<br>
 *
 * @author MoBaiJun 2022/12/8 9:38
 */
public class ThrowableUtils {

    /**
     * 获取堆栈信息
     */
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }

    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     */
    public static String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuilder str = new StringBuilder();
        for (StackTraceElement stet : elements) {
            str.append(stet).append("\n");
        }
        return exceptionName + ":" + exceptionMessage + "\n\t" + str;
    }

    /**
     * parse error to string
     *
     * @param e Throwable
     * @return String
     */
    public static String toString(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
