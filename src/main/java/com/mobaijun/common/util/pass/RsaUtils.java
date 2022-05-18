package com.mobaijun.common.util.pass;

import com.mobaijun.common.util.image.Base64Utils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: RsaUtils
 * class description：
 *
 * @author MoBaiJun 2022/5/18 10:21
 */
public class RsaUtils {

    private static final String RSA = "RSA";
    /**
     * 算法名/工作模式/填充模式
     */
    public static final String RSA_ECB_PKCS5Padding = "RSA/ECB/PKCS1Padding";

    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "public";
    private static final String PRIVATE_KEY = "private";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 生成密钥对
     *
     * @return Object
     * @throws GeneralSecurityException Exception
     */
    public static Map<String, Object> getKeyMap() throws GeneralSecurityException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>();
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return String
     * @throws Exception GeneralSecurityException
     */
    public static String sign(byte[] data, String privateKey) throws GeneralSecurityException {
        byte[] keyBytes = Base64Utils.decode(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PrivateKey privateK = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return Base64Utils.encode(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data      已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @param sign      数字签名
     * @return byte
     * @throws Exception GeneralSecurityException
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws GeneralSecurityException {
        byte[] keyBytes = Base64Utils.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64Utils.decode(sign));
    }

    /**
     * 私钥加密
     *
     * @param data       源数据
     * @param privateKey 私钥(BASE64编码)
     * @return byte
     * @throws Exception GeneralSecurityException
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws GeneralSecurityException, IOException {
        byte[] keyBytes = Base64Utils.decode(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        Key privateK = keyFactory.generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance(RSA_ECB_PKCS5Padding);
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * 私钥解密
     *
     * @param encryptedData 已加密数据
     * @param privateKey    私钥(BASE64编码)
     * @return byte
     * @throws Exception GeneralSecurityException
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws GeneralSecurityException, IOException {
        byte[] keyBytes = Base64Utils.decode(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        Key privateK = keyFactory.generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance(RSA_ECB_PKCS5Padding);
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /**
     * 公钥加密
     *
     * @param data      源数据
     * @param publicKey 公钥(BASE64编码)
     * @return byte[]
     * @throws Exception IOException
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws GeneralSecurityException, IOException {
        byte[] keyBytes = Base64Utils.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        Key publicK = keyFactory.generatePublic(keySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(RSA_ECB_PKCS5Padding);
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * 公钥解密
     *
     * @param encryptedData 已加密数据
     * @param publicKey     公钥(BASE64编码)
     * @return byte[]
     * @throws Exception Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
        byte[] keyBytes = Base64Utils.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        Key publicK = keyFactory.generatePublic(keySpec);
        Cipher cipher = Cipher.getInstance(RSA_ECB_PKCS5Padding);
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /**
     * 获取私钥
     *
     * @param keyMap 密钥对
     * @return String
     */
    public static String getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return Base64Utils.encode(key.getEncoded());
    }

    /**
     * 获取公钥
     *
     * @param keyMap 密钥对
     * @return String
     */
    public static String getPublicKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return Base64Utils.encode(key.getEncoded());
    }

    /**
     * 移除微软前导0
     *
     * @param data data
     * @return byte[]
     */
    private static byte[] removeMSZero(byte[] data) {
        byte[] b;
        if (data[0] == 0) {
            b = new byte[data.length - 1];
            System.arraycopy(data, 1, b, 0, data.length - 1);
        } else {
            b = data;
        }
        return b;
    }

    /**
     * 获取私钥(C#格式)
     *
     * @param keyMap 密钥对
     * @return String
     */
    public static String getPrivateKey2CSharp(Map<String, Object> keyMap) throws GeneralSecurityException {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(key.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        RSAPrivateCrtKey privateK = (RSAPrivateCrtKey) keyFactory.generatePrivate(keySpec);

        return "<RSAKeyValue>" +
                "<Modulus>" + Base64Utils.encode(removeMSZero(privateK.getModulus().toByteArray())) + "</Modulus>" +
                "<Exponent>" + Base64Utils.encode(removeMSZero(privateK.getPublicExponent().toByteArray())) + "</Exponent>" +
                "<P>" + Base64Utils.encode(removeMSZero(privateK.getPrimeP().toByteArray())) + "</P>" +
                "<Q>" + Base64Utils.encode(removeMSZero(privateK.getPrimeQ().toByteArray())) + "</Q>" +
                "<DP>" + Base64Utils.encode(removeMSZero(privateK.getPrimeExponentP().toByteArray())) + "</DP>" +
                "<DQ>" + Base64Utils.encode(removeMSZero(privateK.getPrimeExponentQ().toByteArray())) + "</DQ>" +
                "<InverseQ>" + Base64Utils.encode(removeMSZero(privateK.getCrtCoefficient().toByteArray())) + "</InverseQ>" +
                "<D>" + Base64Utils.encode(removeMSZero(privateK.getPrivateExponent().toByteArray())) + "</D>" +
                "</RSAKeyValue>";
    }

    /**
     * 获取公钥(C#格式)
     *
     * @param keyMap 密钥对
     * @return String
     */
    public static String getPublicKey2CSharp(Map<String, Object> keyMap) throws GeneralSecurityException {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        RSAPublicKey publicK = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        return "<RSAKeyValue>" +
                "<Modulus>" + Base64Utils.encode(removeMSZero(publicK.getModulus().toByteArray())) + "</Modulus>" +
                "<Exponent>" + Base64Utils.encode(removeMSZero(publicK.getPublicExponent().toByteArray())) + "</Exponent>" +
                "</RSAKeyValue>";
    }
}
