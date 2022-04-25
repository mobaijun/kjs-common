package com.mobaijun.common.util;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: JdkUtils
 * 类描述： Jdk 工具类
 *
 * @author MoBaiJun 2022/4/22 18:32
 */
public class JdkUtils {

    /**
     * 获取 JDK 的详细版本号，例如：1.8.0_91 ， 1.7.0_79，1.6.0
     */
    public static void getJdkVersion() {
        System.out.println(System.getProperty("java.version"));
    }

    /**
     * 获取 jdk的标准版本 ，例如： 1.8 , 1.7 , 1.6
     */
    public static void getJdkSpeVersion() {
        System.out.println(System.getProperty("java.specification.version"));
    }

    /**
     * 包含 "64",即可64位 JDK , 否则 32位
     */
    public static void getJdkVmVersion() {
        System.out.println(System.getProperty("java.vm.name"));

    }

    /**
     * 64位JDK：amd64 ，32位JDK：x86
     */
    public static void getJdkOsVersion() {
        System.out.println(System.getProperty("os.arch"));
    }

    /**
     * 64位JDK：64 ，32位JDK：32
     */
    public static void getJdkSunDataVersion() {
        System.out.println(System.getProperty("sun.arch.data.model"));
    }
}
