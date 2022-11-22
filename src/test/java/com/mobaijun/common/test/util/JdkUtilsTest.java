package com.mobaijun.common.test.util;

import com.mobaijun.common.util.JdkUtils;
import com.mobaijun.common.util.PrintUtils;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: JdkUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 18:43
 */
public class JdkUtilsTest {
    public static void main(String[] args) {
        // 获取 JDK 的详细版本号，例如：1.8.0_91 ， 1.7.0_79，1.6.0
        PrintUtils.println(JdkUtils.getJdkVersion());

        // 获取 jdk的标准版本 ，例如： 1.8 , 1.7 , 1.6
        PrintUtils.println(JdkUtils.getJdkSpeVersion());

        // 包含 "64",即可64位 JDK , 否则 32位
        PrintUtils.println(JdkUtils.getJdkVmVersion());

        // 64位JDK：amd64 ，32位JDK：x86
        PrintUtils.println(JdkUtils.getJdkOsVersion());

        // 64位JDK：64 ，32位JDK：32
        PrintUtils.println(JdkUtils.getJdkSunDataVersion());

        // 获取当前服务器逻辑处理器数量
        PrintUtils.println(JdkUtils.getServerCpuNum());

        // 获取Java 供应商的 URL
        PrintUtils.println(JdkUtils.getVendorUrl());

        // 获取Java 虚拟机规范版本
        PrintUtils.println(JdkUtils.getVmSpecificationVersion());

        // 获取Java 虚拟机规范供应商
        PrintUtils.println(JdkUtils.getVmSpecificationName());

        // 获取Java 运行时环境规范版本
        PrintUtils.println(JdkUtils.getVmVersion());

        // 获取Java 运行时环境规范供应商
        PrintUtils.println(JdkUtils.getSpecificationVendor());

        // 获取Java 运行时环境规范名称
        PrintUtils.println(JdkUtils.getSpecificationName());

        // 获取Java 类格式版本号
        PrintUtils.println(JdkUtils.getClassVersion());

        // 获取Java 类路径
        PrintUtils.println(JdkUtils.getClassPath());

        // 获取加载库时搜索的路径列表
        PrintUtils.println(JdkUtils.getLibraryPath());

        // 获取默认的临时文件路径
        PrintUtils.println(JdkUtils.getTmpdir());

        // 获取要使用的 JIT 编译器的名称
        PrintUtils.println(JdkUtils.getCompiler());

        // 获取一个或多个扩展目录的路径
        PrintUtils.println(JdkUtils.getExtDirs());

        // 获取操作系统的版本
        PrintUtils.println(JdkUtils.getOsVersion());

        // 获取文件分隔符（在 UNIX 系统中是“/”）
        PrintUtils.println(JdkUtils.getSileSeparator());

        // 获取路径分隔符（在 UNIX 系统中是“:”）
        PrintUtils.println(JdkUtils.getPathSeparator());

        // 获取行分隔符（在 UNIX 系统中是“/n”）
        PrintUtils.println(JdkUtils.getLineSeparator());

        // 获取用户的账户名称
        PrintUtils.println(JdkUtils.getUserName());

        // 获取用户的主目录
        PrintUtils.println(JdkUtils.getUserHome());

        // 获取用户的当前工作目录
        PrintUtils.println(JdkUtils.getUserDir());
    }
}
