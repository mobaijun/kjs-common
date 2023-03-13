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
package com.mobaijun.common.util.system;

import com.mobaijun.common.constant.NumberConstant;
import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: DiskUtils<br>
 * class description： 获取电脑磁盘分区信息<br>
 *
 * @author MoBaiJun 2022/5/25 15:23
 */
public class DiskUtil {

    /**
     * disks 返回 ArrayList 形式的硬盘分区
     *
     * @return list 集合分区详情
     */
    public static ArrayList<File> diskInformation() {
        File[] disks = File.listRoots();
        if (disks.length == NumberConstant.ZERO) {
            return new ArrayList<>(Collections.emptyList());
        }
        return new ArrayList<>(Arrays.asList(disks));
    }

    /**
     * 获取内存使用情况
     *
     * @return map 集合
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