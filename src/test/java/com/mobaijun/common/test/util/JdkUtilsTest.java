package com.mobaijun.common.test.util;

import com.mobaijun.common.util.JdkUtil;
import com.mobaijun.common.util.PrintUtil;

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
        PrintUtil.println(JdkUtil.getJdkVersion());

        // 获取 jdk的标准版本 ，例如： 1.8 , 1.7 , 1.6
        PrintUtil.println(JdkUtil.getJdkSpeVersion());

        // 包含 "64",即可64位 JDK , 否则 32位
        PrintUtil.println(JdkUtil.getJdkVmVersion());

        // 64位JDK：amd64 ，32位JDK：x86
        PrintUtil.println(JdkUtil.getJdkOsVersion());

        // 64位JDK：64 ，32位JDK：32
        PrintUtil.println(JdkUtil.getJdkSunDataVersion());

        // 获取当前服务器逻辑处理器数量
        PrintUtil.println(JdkUtil.getServerCpuNum());

        // 获取Java 供应商的 URL
        PrintUtil.println(JdkUtil.getVendorUrl());

        // 获取Java 虚拟机规范版本
        PrintUtil.println(JdkUtil.getVmSpecificationVersion());

        // 获取Java 虚拟机规范供应商
        PrintUtil.println(JdkUtil.getVmSpecificationName());

        // 获取Java 运行时环境规范版本
        PrintUtil.println(JdkUtil.getVmVersion());

        // 获取Java 运行时环境规范供应商
        PrintUtil.println(JdkUtil.getSpecificationVendor());

        // 获取Java 运行时环境规范名称
        PrintUtil.println(JdkUtil.getSpecificationName());

        // 获取Java 类格式版本号
        PrintUtil.println(JdkUtil.getClassVersion());

        // 获取Java 类路径
        PrintUtil.println(JdkUtil.getClassPath());

        // 获取加载库时搜索的路径列表
        PrintUtil.println(JdkUtil.getLibraryPath());

        // 获取默认的临时文件路径
        PrintUtil.println(JdkUtil.getTmpdir());

        // 获取要使用的 JIT 编译器的名称
        PrintUtil.println(JdkUtil.getCompiler());

        // 获取一个或多个扩展目录的路径
        PrintUtil.println(JdkUtil.getExtDirs());

        // 获取操作系统的版本
        PrintUtil.println(JdkUtil.getOsVersion());

        // 获取文件分隔符（在 UNIX 系统中是“/”）
        PrintUtil.println(JdkUtil.getSileSeparator());

        // 获取路径分隔符（在 UNIX 系统中是“:”）
        PrintUtil.println(JdkUtil.getPathSeparator());

        // 获取行分隔符（在 UNIX 系统中是“/n”）
        PrintUtil.println(JdkUtil.getLineSeparator());

        // 获取用户的账户名称
        PrintUtil.println(JdkUtil.getUserName());

        // 获取用户的主目录
        PrintUtil.println(JdkUtil.getUserHome());

        // 获取用户的当前工作目录
        PrintUtil.println(JdkUtil.getUserDir());
    }
}
