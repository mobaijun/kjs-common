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
package com.mobaijun.common.util;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: MacAddressUtil<br>
 * class description：获取mac地址的工具类<br>
 *
 * @author MoBaiJun 2022/5/12 11:36
 */
public class MacAddressUtil {

    /**
     * 获取mac的地址信息列表
     * <br>
     * 一台机器不一定有多个网卡，所以返回的是数组
     *
     * @return 包含地址信息的 Optional 列表，可能为空
     */
    public static Optional<List<String>> getMacList() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            List<String> macList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();

                for (InterfaceAddress interfaceAddress : interfaceAddresses) {
                    InetAddress ip = interfaceAddress.getAddress();
                    NetworkInterface associatedNetwork = NetworkInterface.getByInetAddress(ip);

                    if (associatedNetwork == null) {
                        continue;
                    }

                    byte[] mac = associatedNetwork.getHardwareAddress();

                    if (mac != null) {
                        sb.delete(0, sb.length());
                        for (int i = 0; i < mac.length; i++) {
                            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                        }
                        macList.add(sb.toString());
                    }
                }
            }

            // 去重，同一个网卡的 IPv4 和 IPv6 得到的 mac 都是一样的
            return Optional.of(macList.stream().distinct().collect(Collectors.toList()));
        } catch (SocketException e) {
            return Optional.empty();
        }
    }
}