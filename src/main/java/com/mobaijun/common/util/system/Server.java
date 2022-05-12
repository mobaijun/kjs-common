package com.mobaijun.common.util.system;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: Server
 * class description： 服务器相关信息
 *
 * @author MoBaiJun 2022/5/12 11:10
 */
@Getter
@Setter
public class Server {

    private static final int OSHI_WAIT_SECOND = 1000;

    /**
     * CPU相关信息
     */
    private SysCpu cpu = new SysCpu();

    /**
     * 內存相关信息
     */
    private SysMem mem = new SysMem();

    /**
     * JVM相关信息
     */
    private SysJvm jvm = new SysJvm();

    /**
     * 服务器相关信息
     */
    private System sys = new System();

    /**
     * 磁盘相关信息
     */
    private List<SysFile> sysFiles = new LinkedList<SysFile>();

    /**
     * 设置Java虚拟机
     */
    private void setJvmInfo() {
        Properties props = java.lang.System.getProperties();
        jvm.setTotal(Runtime.getRuntime().totalMemory());
        jvm.setMax(Runtime.getRuntime().maxMemory());
        jvm.setFree(Runtime.getRuntime().freeMemory());
        jvm.setVersion(props.getProperty("java.version"));
        jvm.setHome(props.getProperty("java.home"));
    }

    /**
     * 字节转换
     *
     * @param size 字节大小
     * @return 转换后值
     */
    public String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else {
            return String.format("%d B", size);
        }
    }
}
