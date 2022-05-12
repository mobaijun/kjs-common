package com.mobaijun.common.util.http;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
     * 解决IP地址转换为64位整数类型
     * 如: [192.168.31.4]转换为[192168031004]
     *
     * @param ip String
     * @return String
     */
    public static String ipSplit(String ip) {
        ip = ip.replace(".", "\\");
        String[] ips = ip.split("[^\\d]+");
        StringBuilder s1 = new StringBuilder();
        for (String value : ips) {
            String s = value;
            if (s.length() == 1) {
                s = "00" + s;
            } else if (s.length() == 2) {
                s = "0" + s;
            }
            s1.append(s);
        }
        return s1.toString();
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

    public static void main(String[] args) {
        System.out.println(IpUtils.getHostName());
    }
}
