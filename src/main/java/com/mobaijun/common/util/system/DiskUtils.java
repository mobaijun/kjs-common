package com.mobaijun.common.util.system;

import com.mobaijun.common.util.constant.NumberConstant;
import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: DiskUtils
 * class description： 获取电脑磁盘分区信息
 *
 * @author MoBaiJun 2022/5/25 15:23
 */
public class DiskUtils {

    /**
     * @return disks 返回ArrayList形式的硬盘分区
     */
    public static ArrayList<File> diskInformation() {
        File[] disks = File.listRoots();
        if (disks.length == NumberConstant.ZERO) {
            return null;
        }
        return new ArrayList<>(Arrays.asList(disks));
    }

    /**
     * @return 获取内存使用情况
     */
    public static Map<String, String> getMemoryInfo() {
        Map<String, String> map = new ConcurrentHashMap<>(1);
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        // 获取内存总容量
        map.put("totalMemorySize", transformation(mem.getTotalPhysicalMemorySize()));
        // 获取可用内存容量
        map.put("freeMemorySize", transformation(mem.getFreePhysicalMemorySize()));
        return map;
    }

    /**
     * 将字节容量转化为GB
     */
    public static String transformation(long size) {
        return size / 1024 / 1024 / 1024 + "GB";
    }
}
