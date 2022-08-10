package com.mobaijun.common.util.pass;

import cn.hutool.core.codec.Base64;
import com.mobaijun.common.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: DesUtils
 * class description：
 *
 * @author MoBaiJun 2022/5/18 10:20
 */
public class DesUtils {

    private static final String DES = "DES";

    private DesUtils() {
    }

    /**
     * 加密
     *
     * @param str 加密字符
     * @param key key
     * @return 加密后内容
     */
    public static String encode(String str, String key) {
        if (StringUtils.isNotEmpty(str)) {
            try {
                DESKeySpec dks = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
                SecretKey secureKey = keyFactory.generateSecret(dks);
                Cipher cipher = Cipher.getInstance(DES);
                cipher.init(Cipher.ENCRYPT_MODE, secureKey, new SecureRandom());
                byte[] bytes = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
                return Base64.encode(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 解密
     *
     * @param str 字符
     * @param key key
     * @return 内容
     */
    public static String decode(String str, String key) {
        if (StringUtils.isNotEmpty(str)) {
            try {
                DESKeySpec dks = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
                SecretKey secureKey = keyFactory.generateSecret(dks);
                Cipher cipher = Cipher.getInstance(DES);
                cipher.init(Cipher.DECRYPT_MODE, secureKey, new SecureRandom());
                byte[] bytes = cipher.doFinal(Base64.decode(str));
                return new String(bytes, StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
