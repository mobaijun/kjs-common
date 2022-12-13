package com.mobaijun.common.test.system;

import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.system.DiskUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: DiskUtilTest<br>
 * class description: <br>
 *
 * @author MoBaiJun 2022/12/13 11:15
 */
public class DiskUtilTest {
    public static void main(String[] args) {
        // 获取内存使用情况
        Map<String, String> memoryInfo = DiskUtil.getMemoryInfo();
        PrintUtil.println(memoryInfo);

        // disks 返回 ArrayList 形式的硬盘分区
        ArrayList<File> files = DiskUtil.diskInformation();
        PrintUtil.println(files);
    }
}
