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

import com.mobaijun.common.constant.JdkConstant;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: JdkUtils<br>
 * 类描述： Jdk 工具类<br>
 *
 * @author MoBaiJun 2022/4/22 18:32
 */
public class JdkUtil {

    /**
     * 获取 JDK 的详细版本号，例如：1.8.0_91 ， 1.7.0_79，1.6.0
     */
    public static String getJdkVersion() {
        return System.getProperty(JdkConstant.VERSION);
    }

    /**
     * 获取 jdk的标准版本 ，例如： 1.8 , 1.7 , 1.6
     */
    public static String getJdkSpeVersion() {
        return System.getProperty(JdkConstant.VERSION_TOW);
    }

    /**
     * 包含 "64",即可64位 JDK , 否则 32位
     */
    public static String getJdkVmVersion() {
        return System.getProperty(JdkConstant.VM_NAME);

    }

    /**
     * 64位JDK：amd64 ，32位JDK：x86
     */
    public static String getJdkOsVersion() {
        return System.getProperty(JdkConstant.OS_ARCH);
    }

    /**
     * 64位JDK：64 ，32位JDK：32
     */
    public static String getJdkSunDataVersion() {
        return System.getProperty(JdkConstant.ARCH_DATA_MODEL);
    }

    /**
     * 获取当前服务器逻辑处理器数量
     */
    public static int getServerCpuNum() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * 获取Java 供应商的 URL
     */
    public static String getVendorUrl() {
        return System.getProperty(JdkConstant.VENDOR_URL);
    }

    /**
     * 获取Java 虚拟机规范版本
     */
    public static String getVmSpecificationVersion() {
        return System.getProperty(JdkConstant.VM_SPECIFICATION_VERSION);
    }

    /**
     * 获取Java 虚拟机规范供应商
     */
    public static String getVmSpecificationName() {
        return System.getProperty(JdkConstant.VM_SPECIFICATION_NAME);
    }

    /**
     * 获取Java 运行时环境规范版本
     */
    public static String getVmVersion() {
        return System.getProperty(JdkConstant.VM_VERSION);
    }

    /**
     * 获取Java 运行时环境规范供应商
     */
    public static String getSpecificationVendor() {
        return System.getProperty(JdkConstant.SPECIFICATION_VENDOR);
    }

    /**
     * 获取Java 运行时环境规范名称
     */
    public static String getSpecificationName() {
        return System.getProperty(JdkConstant.SPECIFICATION_NAME);
    }

    /**
     * 获取Java 类格式版本号
     */
    public static String getClassVersion() {
        return System.getProperty(JdkConstant.CLASS_VERSION);
    }

    /**
     * 获取Java 类路径
     */
    public static String getClassPath() {
        return System.getProperty(JdkConstant.CLASS_PATH);
    }

    /**
     * 获取加载库时搜索的路径列表
     */
    public static String getLibraryPath() {
        return System.getProperty(JdkConstant.LIBRARY_PATH);
    }

    /**
     * 获取默认的临时文件路径
     */
    public static String getTmpdir() {
        return System.getProperty(JdkConstant.TMPDIR);
    }

    /**
     * 获取要使用的 JIT 编译器的名称
     */
    public static String getCompiler() {
        return System.getProperty(JdkConstant.COMPILER);
    }

    /**
     * 获取一个或多个扩展目录的路径
     */
    public static String getExtDirs() {
        return System.getProperty(JdkConstant.EXT_DIRS);
    }

    /**
     * 获取操作系统的版本
     */
    public static String getOsVersion() {
        return System.getProperty(JdkConstant.OS_VERSION);
    }

    /**
     * 获取文件分隔符（在 UNIX 系统中是“/”）
     */
    public static String getSileSeparator() {
        return System.getProperty(JdkConstant.FILE_SEPARATOR);
    }

    /**
     * 获取路径分隔符（在 UNIX 系统中是“:”）
     */
    public static String getPathSeparator() {
        return System.getProperty(JdkConstant.PATH_SEPARATOR);
    }

    /**
     * 获取行分隔符（在 UNIX 系统中是“/n”）
     */
    public static String getLineSeparator() {
        return System.getProperty(JdkConstant.LINE_SEPARATOR);
    }

    /**
     * 获取用户的账户名称
     */
    public static String getUserName() {
        return System.getProperty(JdkConstant.USER_NAME);
    }

    /**
     * 获取用户的主目录
     */
    public static String getUserHome() {
        return System.getProperty(JdkConstant.USER_HOME);
    }

    /**
     * 获取用户的当前工作目录
     */
    public static String getUserDir() {
        return System.getProperty(JdkConstant.USER_DIR);
    }
}