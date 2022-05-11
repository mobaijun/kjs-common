package com.mobaijun.common.util.image;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: Base64Utils
 * 类描述： Base64工具类
 *
 * @author MoBaiJun 2022/4/22 18:59
 */
@SuppressWarnings("restriction")
public class Base64Utils {

    // 字幕char数组以及索引的值得对应。
    private static final char[] alphabet =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    //
    private static final byte[] codes = new byte[256];

    // 完成数组下索引与b64值的对应关系
    static {
        // 数组赋值初始化值
        for (int i = 0; i < 256; i++)
            codes[i] = -1;

        // A-Z赋值
        for (int i = 'A'; i <= 'Z'; i++)
            codes[i] = (byte) (i - 'A');
        // a-z赋值
        for (int i = 'a'; i <= 'z'; i++)
            codes[i] = (byte) (26 + i - 'a');
        // 数字0-9赋值
        for (int i = '0'; i <= '9'; i++)
            codes[i] = (byte) (52 + i - '0');
        codes['+'] = 62;
        codes['/'] = 63;
    }

    /**
     * BASE64解密
     * sun公司原始base64解码
     *
     * @param base64Str base64Str
     * @return byte[]
     * @throws Exception Exception
     */
    public static byte[] decryptBASE64(String base64Str) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(base64Str);
    }

    /**
     * BASE64加密 sun公司原始base64编码
     *
     * @param key byte[]
     * @return String
     */
    public static String encryptBASE64(byte[] key) {
        return (new BASE64Encoder()).encodeBuffer(key);
    }


    /**
     * 自定义编码
     *
     * @param data byte[]
     * @return String
     */
    public static String encode(byte[] data) {
        // 准备扩充char 数组   (data.length + 2) / 3 保证3的倍数向上取整
        // 扩充后字节为原来的4/3
        char[] out = new char[((data.length + 2) / 3) * 4];
        for (int i = 0, index = 0; i < data.length; i += 3, index += 4) {
            boolean quad = false;
            boolean trip = false;
            int val = (0xFF & (int) data[i]);
            val <<= 8;
            if ((i + 1) < data.length) {
                val |= (0xFF & (int) data[i + 1]);
                trip = true;
            }
            val <<= 8;
            if ((i + 2) < data.length) {
                val |= (0xFF & (int) data[i + 2]);
                quad = true;
            }
            out[index + 3] = alphabet[(quad ? (val & 0x3F) : 64)];
            val >>= 6;
            out[index + 2] = alphabet[(trip ? (val & 0x3F) : 64)];
            val >>= 6;
            out[index + 1] = alphabet[val & 0x3F];
            val >>= 6;
            out[index + 0] = alphabet[val & 0x3F];
        }

        return new String(out);
    }

    /**
     * 自定义解码
     *
     * @param data char[]
     * @return byte[]
     */
    public static byte[] decode(char[] data) {
        // 计算转换后字节长度
        int len = ((data.length + 3) / 4) * 3;
        // 处理末尾补一个等号
        if (data.length > 0 && data[data.length - 1] == '=')
            --len;
        // 处理末尾补两个等号
        if (data.length > 1 && data[data.length - 2] == '=')
            --len;
        // 最终解密后的字节长度
        byte[] out = new byte[len];
        int shift = 0;
        int accum = 0;
        int index = 0;
        for (char datum : data) {
            int value = codes[datum & 0xFF];
            if (value >= 0) {
                accum <<= 6;
                shift += 6;
                accum |= value;
                if (shift >= 8) {
                    shift -= 8;
                    out[index++] = (byte) ((accum >> shift) & 0xff);
                }
            }
        }
        if (index != out.length)
            throw new Error("miscalculated data length!");
        return out;
    }

    /**
     * BASE64加密 util 包下的base64解码
     *
     * @param base64Str base64Str
     * @return base64Str
     */
    public static String decrypt64(String base64Str) {
        byte[] decode = Base64.getDecoder().decode(base64Str);
        return new String(decode, StandardCharsets.UTF_8);
    }

    /**
     * BASE64加密 util包下的base64编码
     *
     * @param key byte[]
     * @return String
     */
    public static String encrypt64(byte[] key) {
        return Base64.getEncoder().encodeToString(key);
    }
}
