/*
 * Copyright (C) 2022 www.mobaijun.com
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
 * software：IntelliJ IDEA 2022.1<br>
 * class name: DesUtils<br>
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