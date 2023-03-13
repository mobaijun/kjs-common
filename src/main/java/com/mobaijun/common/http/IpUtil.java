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
package com.mobaijun.common.http;

import com.mobaijun.common.constant.NumberConstant;
import com.mobaijun.common.util.StringUtil;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: IpUtils<br>
 * class description： IP工具类
 *
 * @author MoBaiJun 2022/5/12 10:17
 */
public class IpUtil {

    /**
     * 过滤受限的IP，剔除已经到期的限制IP
     *
     * @param limitedIpMap limitedIpMap
     */
    public static void filterLimitedIpMap(Map<String, Long> limitedIpMap) {
        if (limitedIpMap == null) {
            return;
        }
        Set<String> keys = limitedIpMap.keySet();
        Iterator<String> keyIt = keys.iterator();
        long currentTimeMillis = System.currentTimeMillis();
        while (keyIt.hasNext()) {
            long expireTimeMillis = limitedIpMap.get(keyIt.next());
            if (expireTimeMillis <= currentTimeMillis) {
                keyIt.remove();
            }
        }
    }

    /**
     * true : 被限制 | false : 正常
     * =========是否是被限制的IP=========
     *
     * @param limitedIpMap limitedIpMap
     * @param ip           ip
     * @return boolean
     */
    @SuppressWarnings("all")
    public static boolean isLimitedIP(Map<String, Long> limitedIpMap, String ip) {
        if (limitedIpMap.containsKey(ip)) {
            return true;
        }
        Set<String> keys = limitedIpMap.keySet();
        for (String key : keys) {
            if (key.equals(ip)) {
                // 被限制的IP
                return true;
            }
        }
        return false;
    }

    /**
     * 初始化用户访问次数和访问时间
     *
     * @param ipMap ipMap
     * @param ip    ip
     */
    public static void initIpVisitsNumber(Map<String, Long[]> ipMap, String ip) {
        Long[] ipInfo = new Long[2];
        // 访问次数
        ipInfo[0] = 0L;
        // 初次访问时间
        ipInfo[1] = System.currentTimeMillis();
        ipMap.put(ip, ipInfo);
    }

    /**
     * 获取当前机器的hostname
     *
     * @return String
     */
    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ignored) {
            return "未知";
        }
    }

    /**
     * 获取本机IP地址
     *
     * @return 本机IP地址
     */
    public static String getLocalIpAddress() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 用于判断该IP地址是否为内部IP地址
     *
     * @param ip IP地址
     * @return 如果是则返回true，否则返回false
     */
    public static boolean internalIp(String ip) {
        byte[] adder = textToNumericFormatV4(ip);
        return internalIp(adder) || "127.0.0.1".equals(ip);
    }

    @SuppressWarnings("all")
    private static boolean internalIp(byte[] adder) {
        if (StringUtil.isEmpty(Collections.singleton(adder)) || adder.length < NumberConstant.TWO) {
            return true;
        }
        final byte b0 = adder[0];
        final byte b1 = adder[1];
        // 10.x.x.x/8
        final byte SECTION_1 = 0x0A;
        // 172.16.x.x/12
        final byte SECTION_2 = (byte) 0xAC;
        final byte sECTION3 = (byte) 0x10;
        final byte sECTION4 = (byte) 0x1F;
        // 192.168.x.x/16
        final byte sECTION5 = (byte) 0xC0;
        final byte sECTION6 = (byte) 0xA8;
        switch (b0) {
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= sECTION3 && b1 <= sECTION4) {
                    return true;
                }
            case sECTION5:
                if (b1 == sECTION6) {
                    return true;
                }
            default:
                return false;
        }
    }

    /**
     * 将IPv4地址转换成字节
     *
     * @param text IPv4地址
     * @return byte 字节
     */
    public static byte[] textToNumericFormatV4(String text) {
        if (text.length() == 0) {
            return null;
        }

        byte[] bytes = new byte[4];
        String[] elements = text.split("\\.", -1);
        try {
            long l;
            int i;
            switch (elements.length) {
                case 1:
                    l = Long.parseLong(elements[0]);
                    if ((l < 0L) || (l > 4294967295L)) {
                        return null;
                    }
                    bytes[0] = (byte) (int) (l >> 24 & 0xFF);
                    bytes[1] = (byte) (int) ((l & 0xFFFFFF) >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 2:
                    l = Integer.parseInt(elements[0]);
                    if ((l < 0L) || (l > 255L)) {
                        return null;
                    }
                    bytes[0] = (byte) (int) (l & 0xFF);
                    l = Integer.parseInt(elements[1]);
                    if ((l < 0L) || (l > 16777215L)) {
                        return null;
                    }
                    bytes[1] = (byte) (int) (l >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 3:
                    for (i = 0; i < NumberConstant.TWO; ++i) {
                        l = Integer.parseInt(elements[i]);
                        if ((l < 0L) || (l > 255L)) {
                            return null;
                        }
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }
                    l = Integer.parseInt(elements[2]);
                    if ((l < 0L) || (l > 65535L)) {
                        return null;
                    }
                    bytes[2] = (byte) (int) (l >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 4:
                    for (i = 0; i < 4; ++i) {
                        l = Integer.parseInt(elements[i]);
                        if ((l < 0L) || (l > 255L)) {
                            return null;
                        }
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }
                    break;
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return bytes;
    }

    /**
     * 192.168.1.2 转为 192168001002
     *
     * @param ip IP地址
     * @return IP地址
     */
    public static String getRegroupIp(String ip) {
        String[] split = ip.split("\\.");
        StringBuilder leftPad = new StringBuilder();
        Arrays.stream(split).forEach(temp ->
                leftPad.append(StringUtil.leftPad(temp, 3, '0')));
        return leftPad.toString();
    }

    /**
     * 判断是网络地址还是本地地址（不知道这样准不准确）
     *
     * @param source 源地址
     */
    public static boolean isOnLineSource(String source) {
        return (source.toLowerCase().startsWith("http://")
                || source.toLowerCase().startsWith("https://"))
                || source.toLowerCase().startsWith("rtmp://")
                && !source.toLowerCase().startsWith("file:///");
    }

    /**
     * 获取服务端口
     *
     * @return 端口号
     */
    public static String getServicePort() {
        try {
            MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
            Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                    Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
            return objectNames.iterator().next().getKeyProperty("port");
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
            System.out.println("获取端口异常");
            return "";
        }
    }

    /**
     * 判断指定IP地址是否可访问
     *
     * @param ipAddress IP地址
     * @return true表示可访问，false表示不可访问
     */
    public static boolean isReachable(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            return address.isReachable(1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取局域网内的所有IP地址
     *
     * @return IP地址列表
     */
    public static String[] getLocalIpAddresses() {
        try {
            Process process = Runtime.getRuntime().exec("arp -a");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            String[] addresses = new String[255];
            int index = 0;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("接口") || line.startsWith("Internet") || line.startsWith("地址")) {
                    continue;
                }
                String[] cols = line.split("\\s+");
                if (cols.length > 1) {
                    String ip = cols[0];
                    if (ip.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
                        addresses[index++] = ip;
                    }
                }
            }
            String[] result = new String[index];
            System.arraycopy(addresses, 0, result, 0, index);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断给定的字符串是否是合法的IPv4地址
     *
     * @param ip 待验证的IPv4地址字符串
     * @return 若是合法的IPv4地址则返回true，否则返回false
     */
    public static boolean isIpAddress(String ip) {
        // 将IPv4地址字符串按照"."进行分隔
        String[] parts = ip.split("\\.");

        // 判断IPv4地址的分隔部分是否为四个，否则非法
        if (parts.length != NumberConstant.FOUR) {
            return false;
        }

        for (String part : parts) {
            // 检查每个分隔部分是否小于等于3位，否则非法
            if (part.length() > 3) {
                return false;
            }
            // 将分隔部分转换为整数，检查是否超过0~255范围，否则非法
            int value = Integer.parseInt(part);
            if (value < 0 || value > 255) {
                return false;
            }
        }
        return true;
    }
}