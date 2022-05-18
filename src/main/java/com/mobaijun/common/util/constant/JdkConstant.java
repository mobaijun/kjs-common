package com.mobaijun.common.util.constant;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: JdkConstant
 * class description： JDK 命令常量
 *
 * @author MoBaiJun 2022/5/18 14:10
 */
public class JdkConstant {
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
     * 获取主机
     */
    public static final String HOME = "java.home";

    /**
     * 64位JDK：amd64 ，32位JDK：x86
     */
    public static final String OS_ARCH = "os.arch";

    /**
     * 获取主机名
     */
    public static final String OS_NAME = "os.name";

    /**
     * 64位JDK：64 ，32位JDK：32
     */
    public static final String ARCH_DATA_MODEL = "sun.arch.data.model";
}
