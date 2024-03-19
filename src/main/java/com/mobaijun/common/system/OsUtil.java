package com.mobaijun.common.system;

import java.util.Locale;

/**
 * Description: [OSUtil工具类提供了一些操作系统相关的方法。]
 * Author: [mobaijun]
 * Date: [2024/3/19 8:55]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class OsUtil {

    private static final String OS_NAME = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);

    /**
     * 检查操作系统是否是Windows。
     *
     * @return 如果操作系统是Windows，则返回true，否则返回false。
     */
    public static boolean isWindows() {
        return OS_NAME.contains("windows");
    }

    /**
     * 检查操作系统是否是Linux。
     *
     * @return 如果操作系统是Linux，则返回true，否则返回false。
     */
    public static boolean isLinux() {
        return OS_NAME.contains("linux");
    }

    /**
     * 检查操作系统是否是Mac OS X。
     *
     * @return 如果操作系统是Mac OS X，则返回true，否则返回false。
     */
    public static boolean isMac() {
        return OS_NAME.contains("mac");
    }

    /**
     * 获取操作系统名称。
     *
     * @return 返回操作系统名称。
     */
    public static String getOSName() {
        return OS_NAME;
    }

    /**
     * 获取操作系统架构。
     *
     * @return 返回操作系统架构。
     */
    public static String getOSArch() {
        return System.getProperty("os.arch");
    }

    /**
     * 获取操作系统版本。
     *
     * @return 返回操作系统版本。
     */
    public static String getOSVersion() {
        return System.getProperty("os.version");
    }

    /**
     * 获取操作系统临时目录。
     *
     * @return 返回操作系统临时目录路径。
     */
    public static String getTempDirectory() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     * 获取用户的主目录。
     *
     * @return 返回用户的主目录路径。
     */
    public static String getUserHomeDirectory() {
        return System.getProperty("user.home");
    }

    /**
     * 获取用户的当前工作目录。
     *
     * @return 返回用户的当前工作目录路径。
     */
    public static String getUserWorkingDirectory() {
        return System.getProperty("user.dir");
    }
}
