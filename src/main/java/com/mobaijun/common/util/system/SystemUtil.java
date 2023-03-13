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

import com.mobaijun.common.util.text.Charsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * 获取当前系统中运行的进程列表。
     */
    public static List<List<String>> processList() {
        try {
            // 构建进程管理器
            ProcessBuilder processBuilder = new ProcessBuilder("tasklist");
            // 启动进程
            Process process = processBuilder.start();
            // 读取进程输出信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charsets.GBK));
            String line;
            List<List<String>> processInfoList = new ArrayList<>();
            // 逐行读取进程输出信息，并将每列属性封装为一个集合
            while ((line = reader.readLine()) != null) {
                // 使用正则表达式将行字符串分割成多个属性
                String[] columns = line.split("\\s+");
                // 将分割后的属性列表添加到 processInfoList 中
                processInfoList.add(Arrays.asList(columns));
            }
            return processInfoList;
        } catch (IOException e) {
            // 如果发生异常，则抛出 RuntimeException
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取所有进程的 PID 和 名称
     */
    public static List<String> getPids() {
        try {
            List<String> pids = new ArrayList<>();
            ProcessBuilder processBuilder = new ProcessBuilder("jps", "-v");
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.trim().split("\\s+");
                if (tokens.length > 1) {
                    pids.add(tokens[0]);
                }
            }
            return pids;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取指定进程的详细信息
     */
    public static String getProcessInfo(String pid) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("jstat", "-gcutil", pid);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();
            builder.append("Process ID: ").append(pid).append("\n");
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
