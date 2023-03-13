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
package com.mobaijun.common.constant;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: JdkConstant<br>
 * class description： JDK 命令常量
 *
 * @author MoBaiJun 2022/5/18 14:10
 */
public final class JdkConstant {
    /**
     * 获取 jdk、 版本
     */
    public static final String VERSION = "java.version";

    /**
     * 获取 jdk的标准版本 ，例如： 1.8 , 1.7 , 1.6
     */
    public static final String VERSION_TOW = "java.specification.version";

    /**
     * 包含 "64",即可64位 JDK , 否则 32位
     */
    public static final String VM_NAME = "java.vm.name";

    /**
     * Java 安装目录
     */
    public static final String HOME = "java.home";

    /**
     * 操作系统的架构
     */
    public static final String OS_ARCH = "os.arch";

    /**
     * 操作系统的名称
     */
    public static final String OS_NAME = "os.name";

    /**
     * 64位JDK：64 ，32位JDK：32
     */
    public static final String ARCH_DATA_MODEL = "sun.arch.data.model";

    /**
     * Java 运行时环境供应商
     */
    public static final String VENDOR = "java.vendor";

    /**
     * Java 供应商的 URL
     */
    public static final String VENDOR_URL = "java.vendor.url";

    /**
     * Java 虚拟机规范版本
     */
    public static final String VM_SPECIFICATION_VERSION = "java.vm.specification.version";

    /**
     * Java 虚拟机规范供应商
     */
    public static final String VM_SPECIFICATION_NAME = "java.vm.specification.name";

    /**
     * Java 运行时环境规范版本
     */
    public static final String VM_VERSION = "java.vm.version";

    /**
     * Java 运行时环境规范供应商
     */
    public static final String SPECIFICATION_VENDOR = "java.specification.vendor";

    /**
     * Java 运行时环境规范名称
     */
    public static final String SPECIFICATION_NAME = "java.specification.name";

    /**
     * Java 类格式版本号
     */
    public static final String CLASS_VERSION = "java.class.version";

    /**
     * Java 类路径
     */
    public static final String CLASS_PATH = "java.class.path";

    /**
     * 加载库时搜索的路径列表
     */
    public static final String LIBRARY_PATH = "java.library.path";

    /**
     * 默认的临时文件路径
     */
    public static final String TMPDIR = "java.io.tmpdir";

    /**
     * 要使用的 JIT 编译器的名称
     */
    public static final String COMPILER = "java.compiler";

    /**
     * 一个或多个扩展目录的路径
     */
    public static final String EXT_DIRS = "java.ext.dirs";

    /**
     * 操作系统的版本
     */
    public static final String OS_VERSION = "os.version";

    /**
     * 文件分隔符（在 UNIX 系统中是“/”）
     */
    public static final String FILE_SEPARATOR = "file.separator";

    /**
     * 路径分隔符（在 UNIX 系统中是“:”）
     */
    public static final String PATH_SEPARATOR = "path.separator";

    /**
     * 行分隔符（在 UNIX 系统中是“/n”）
     */
    public static final String LINE_SEPARATOR = "line.separator";

    /**
     * 用户的账户名称
     */
    public static final String USER_NAME = "user.name";

    /**
     * 用户的主目录
     */
    public static final String USER_HOME = "user.home";

    /**
     * 用户的当前工作目录
     */
    public static final String USER_DIR = "user.dir";
}