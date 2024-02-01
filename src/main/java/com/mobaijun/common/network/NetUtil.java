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
package com.mobaijun.common.network;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: NetUtil<br>
 * class description： 网络工具类
 *
 * @author MoBaiJun 2022/5/18 10:05
 */
public class NetUtil {

    /**
     * 是否 ping 通
     *
     * @param host 主机地址
     * @return true false
     */
    public static boolean isHostReachable(String host) {
        try {
            boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
            ProcessBuilder processBuilder = new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", host);
            Process proc = processBuilder.start();
            int returnVal = proc.waitFor();
            return returnVal == 0;
        } catch (IOException | InterruptedException e) {
            return false;
        }
    }

    /**
     * 获取一个ping通的ip
     *
     * @param ipAddresses ip数组
     * @return ip
     */
    public static String getFirstReachableIpAddress(String[] ipAddresses) {
        AtomicReference<String> reachableIp = new AtomicReference<>(null);

        for (String ipAddress : ipAddresses) {
            if (isHostReachable(ipAddress)) {
                reachableIp.set(ipAddress);
                break;
            }
        }

        return reachableIp.get();
    }
}