package com.mobaijun.common.util.pass;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: AESUtil
 * class description：AES 加密工具类
 *
 * @author MoBaiJun 2022/5/18 9:55
 */
public class AESUtil {
    private static final String AES = "AES";

    /**
     * 默认加密规则
     */
    private static final String DEFAULT_ENCODE_RULE = "com.mobaijun";

    /**
     * 加密
     * 1.构造密钥生成器
     * 2.根据ecnodeRules规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     *
     * @param encodeRules 加密规则
     * @param content     加密内容
     * @return 加密后的字符串
     * @throws Exception a case of encode exception
     */
    public static String encode(String encodeRules, String content) throws Exception {
        byte[] raw = getEncoded(encodeRules);
        SecretKey key = new SecretKeySpec(raw, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] byte_encode = content.getBytes(StandardCharsets.UTF_8);
        byte[] byte_AES = cipher.doFinal(byte_encode);
        return Base64.getEncoder().encodeToString(byte_AES);
    }

    /**
     * 解密
     * 解密过程：
     * 1.同加密1-4步
     * 2.将加密后的字符串反纺成byte[]数组
     * 3.将加密内容解密
     *
     * @param encodeRules 解密规则
     * @param content     解密内容
     * @return 解密后的原始字符串
     * @throws Exception a case of encode exception
     */
    public static String decode(String encodeRules, String content) throws Exception {
        byte[] raw = getEncoded(encodeRules);
        SecretKey key = new SecretKeySpec(raw, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] byte_content = Base64.getDecoder().decode(content);
        // 解密
        byte[] byte_decode = cipher.doFinal(byte_content);
        return new String(byte_decode, StandardCharsets.UTF_8);
    }

    /**
     * 获取加密码
     *
     * @param encodeRules encodeRules 解密规则
     * @return byte
     * @throws Exception 未知
     */
    private static byte[] getEncoded(String encodeRules) throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance(AES);
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(encodeRules.getBytes());
        keygen.init(128, secureRandom);
        SecretKey original_key = keygen.generateKey();
        return original_key.getEncoded();
    }
}
