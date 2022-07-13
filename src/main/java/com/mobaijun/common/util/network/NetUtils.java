package com.mobaijun.common.util.network;

import com.mobaijun.common.util.constant.JdkConstant;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: NetUtil
 * class description： 网络工具类
 *
 * @author MoBaiJun 2022/5/18 10:05
 */
public class NetUtils {

    /**
     * 是否 ping 通
     *
     * @param host 主机地址
     * @return true false
     */
    private static boolean ping(String host) {
        try {
            boolean isWindows = System.getProperty(JdkConstant.OS_NAME).toLowerCase().contains("win");
            ProcessBuilder processBuilder = new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", host);
            Process proc = processBuilder.start();
            int returnVal = proc.waitFor();
            return returnVal == 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取一个ping通的ip
     *
     * @param ipAdders ip数组
     * @return ip
     */
    public static String getOneUseFullIp(String[] ipAdders) {
        String ip = "";
        for (String ipAdder : ipAdders) {
            ip = ipAdder;
            if (ping(ip)) {
                break;
            }
        }
        return ip;
    }
}
