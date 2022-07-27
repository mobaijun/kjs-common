package com.mobaijun.common.util.http;

import com.mobaijun.common.util.StringUtils;
import com.mobaijun.common.util.constant.NumberConstant;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: IpUtils
 * class description： IP工具类
 *
 * @author MoBaiJun 2022/5/12 10:17
 */
public class IpUtils {

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

    public static boolean internalIp(String ip) {
        byte[] adder = textToNumericFormatV4(ip);
        return internalIp(adder) || "127.0.0.1".equals(ip);
    }

    @SuppressWarnings("all")
    private static boolean internalIp(byte[] adder) {
        if (StringUtils.isEmpty(Collections.singleton(adder)) || adder.length < NumberConstant.TWO) {
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
        for (String ipStr : split) {
            leftPad.append(org.apache.commons.lang3.StringUtils.leftPad(ipStr, 3, '0'));
        }
        return leftPad.toString();
    }
}
