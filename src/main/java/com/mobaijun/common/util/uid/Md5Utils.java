package com.mobaijun.common.util.uid;

import com.mobaijun.common.util.constant.Constant;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

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
            md5 = MessageDigest.getInstance(Constant.MD5);
            md5.reset();
            md5.update(str.getBytes(StandardCharsets.UTF_8));
            sgin = byteToStr(md5.digest()).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sgin;
    }

    /**
     * 对字符串 MD5 无盐值加密
     *
     * @param plainText 传入要加密的字符串
     * @return MD5加密后生成32位(小写字母 + 数字)字符串
     */
    public static String MD5Lower(String plainText) {
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest md = MessageDigest.getInstance(Constant.MD5);

            // 使用指定的字节更新摘要
            md.update(plainText.getBytes());

            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值。1 固定值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
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

    /**
     * 对字符串 MD5 加密
     *
     * @param plainText 传入要加密的字符串
     * @return MD5加密后生成32位(大写字母 + 数字)字符串
     */
    public static String MD5Upper(String plainText) {
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest md = MessageDigest.getInstance(Constant.MD5);

            // 使用指定的字节更新摘要
            md.update(plainText.getBytes());

            // 获得密文
            byte[] mdResult = md.digest();
            return hexDigits(mdResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对字符串 MD5 加盐值加密
     *
     * @param plainText 传入要加密的字符串
     * @param saltValue 传入要加的盐值
     * @return MD5加密后生成32位(小写字母 + 数字)字符串
     */
    public static String MD5Lower(String plainText, String saltValue) {
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest md = MessageDigest.getInstance(Constant.MD5);

            // 使用指定的字节更新摘要
            md.update(plainText.getBytes());
            md.update(saltValue.getBytes());

            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值。1 固定值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对字符串 MD5 加盐值加密
     *
     * @param plainText 传入要加密的字符串
     * @param saltValue 传入要加的盐值
     * @return MD5加密后生成32位(大写字母 + 数字)字符串
     */
    public static String MD5Upper(String plainText, String saltValue) {
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest md = MessageDigest.getInstance(Constant.MD5);

            // 使用指定的字节更新摘要
            md.update(plainText.getBytes());
            md.update(saltValue.getBytes());
            // 获得密文
            byte[] mdResult = md.digest();
            // 把密文转换成十六进制的字符串形式
            return hexDigits(mdResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 把密文转换成十六进制的字符串形式
     *
     * @param mdResult byte[]
     * @return String
     */
    private static String hexDigits(byte[] mdResult) {
        // 把密文转换成十六进制的字符串形式
        int j = mdResult.length;
        char[] str = new char[j * 2];
        int k = 0;
        for (byte byte0 : mdResult) {
            str[k++] = Constant.HEX_DIGITS[byte0 >>> 4 & 0xf];
            str[k++] = Constant.HEX_DIGITS[byte0 & 0xf];
        }
        return new String(str);
    }

    /**
     * MD5加密后生成32位(小写字母+数字)字符串
     * 同 MD5Lower() 一样
     *
     * @param plainText plainText
     * @return String
     */
    public static String MD5(String plainText) {
        try {
            MessageDigest mdTemp = MessageDigest.getInstance(Constant.MD5);

            mdTemp.update(plainText.getBytes(StandardCharsets.UTF_8));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = Constant.HEX_DIGITS_LOWER[byte0 >>> 4 & 0xf];
                str[k++] = Constant.HEX_DIGITS_LOWER[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验MD5码
     *
     * @param text 要校验的字符串
     * @param md5  md5值
     * @return 校验结果
     */
    public static boolean valid(String text, String md5) {
        return md5.equals(MD5(text)) || md5.equals(Objects.requireNonNull(MD5(text)).toUpperCase());
    }
}
