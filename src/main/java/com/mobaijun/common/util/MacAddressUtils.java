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
package com.mobaijun.common.util;

import com.mobaijun.common.util.collection.CollectionUtils;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: MacAddressUtil
 * class description：获取mac地址的工具类
 *
 * @author MoBaiJun 2022/5/12 11:36
 */
public class MacAddressUtils {

    /**
     * 获取mac的地址信息列表
     * <p>
     * 一台机器不一定有多个网卡，所以返回的是数组
     *
     * @return 集合地址
     * @throws Exception Exception
     */
    public static List<String> getMacList() throws Exception {
        java.util.Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> tmpMacList = CollectionUtils.newArrayList();
        while (en.hasMoreElements()) {
            NetworkInterface face = en.nextElement();
            List<InterfaceAddress> adds = face.getInterfaceAddresses();
            for (InterfaceAddress addr : adds) {
                InetAddress ip = addr.getAddress();
                NetworkInterface network = NetworkInterface.getByInetAddress(ip);
                if (network == null) {
                    continue;
                }
                byte[] mac = network.getHardwareAddress();
                if (mac == null) {
                    continue;
                }
                sb.delete(0, sb.length());
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                tmpMacList.add(sb.toString());
            }
        }
        if (tmpMacList.size() <= 0) {
            return tmpMacList;
        }
        // 去重，同一个网卡的ipv4,ipv6得到的mac都是一样的
        return tmpMacList.stream().distinct().collect(Collectors.toList());
    }
}