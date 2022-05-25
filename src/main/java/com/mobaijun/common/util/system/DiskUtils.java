package com.mobaijun.common.util.system;

import com.mobaijun.common.util.constant.NumberConstant;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

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
}
