package com.mobaijun.common.util.pass;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: Md5Utils
 * 类描述： md5工具类
 *
 * @author MoBaiJun 2022/4/22 18:55
 */
public class Md5Utils {

    /**
     * MD5加密
     *
     * @param str 字符串
     * @return String
     */
    public static String sign(String str) {
        MessageDigest md5;
        String sgin = "";
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(str.getBytes(StandardCharsets.UTF_8));
            sgin = byteToStr(md5.digest()).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sgin;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray byteArray
     * @return String
     */
    public static String byteToStr(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (byte b : byteArray) {
            strDigest.append(byteToHexStr(b));
        }
        return strDigest.toString();
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param bytes bytes
     * @return String
     */
    public static String byteToHexStr(byte bytes) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = digit[(bytes >>> 4) & 0X0F];
        tempArr[1] = digit[bytes & 0X0F];
        return new String(tempArr);
    }
}
