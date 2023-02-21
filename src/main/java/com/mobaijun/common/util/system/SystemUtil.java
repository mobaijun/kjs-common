/*
 * Copyright (C) 2022 www.mobaijun.com
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

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: SystemUtil<br>
 * class description: 系统操作工具类
 *
 * @author MoBaiJun 2023/2/21 23:45
 */
public class SystemUtil {

    /**
     * 获取操作系统信息
     *
     * @return 系统详情
     */
    public static List<Map<String, Object>> getSystemInfo() {
        List<Map<String, Object>> mapList = new ArrayList<>(6);
        Map<String, Object> initMap = new ConcurrentHashMap<>(5);
        // 获取操作系统相关信息
        OperatingSystemMXBean osInfo = ManagementFactory.getOperatingSystemMXBean();
        initMap.put("Operating system name", osInfo.getName());
        initMap.put("Operating system version", osInfo.getVersion());
        initMap.put("Operating system architecture", osInfo.getArch());
        initMap.put("Number of processors", osInfo.getAvailableProcessors());
        initMap.put("Average load of the operating system", osInfo.getSystemLoadAverage());
        mapList.add(initMap);
        return mapList;
    }
}
