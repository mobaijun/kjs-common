/*
 * Copyright (C) 2022 [www.mobaijun.com]
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
package com.mobaijun.common.license;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: LicenseUtil<br>
 * class description: 许可证操作工具类
 *
 * @author MoBaiJun 2023/2/22 0:38
 */
public class LicenseUtil {

    /**
     * 忽略
     */
    public static final RuntimeExpireStrategy EXPIRE_STRATEGY_IGNORE = entity -> System.err.println("invalid license");

    /**
     * 异常
     */
    public static final RuntimeExpireStrategy EXPIRE_STRATEGY_THROWS = entity -> {
        throw new LicenseException("invalid license");
    };

    private static final String KEY_ALGORITHM = "RSA";

    private final byte[] readBuffer = new byte[8];

    /**
     * 过期策略
     */
    private final RuntimeExpireStrategy expireStrategy;
    private final long period;

    public LicenseUtil() {
        this(EXPIRE_STRATEGY_IGNORE, TimeUnit.HOURS.toMillis(1));
    }

    public LicenseUtil(RuntimeExpireStrategy expireStrategy, long period) {
        if (period < TimeUnit.SECONDS.toMillis(1)) {
            throw new IllegalArgumentException("period is too fast");
        }
        this.expireStrategy = expireStrategy;
        this.period = period;
    }

    /**
     * MD5
     *
     * @param data byte 数据集
     * @return 加密字符串
     */
    private static String md5(byte[] data) {
        final int m = 2;
        final int n = 4;
        final int a = 0xf;
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(data);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * m];
            int k = 0;
            byte byte0 = 0;
            for (byte b : md) {
                byte0 = b;
                str[k++] = hexDigits[byte0 >>> n & a];
                str[k++] = hexDigits[byte0 & a];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 使用公钥进行解密
     */
    private byte[] decryptByPublicKey(byte[] data, byte[] publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(encodedKeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, pubKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new LicenseException("decrypt exception", e);
        }
    }

    /**
     * 启动License过期监控
     */
    private void monitorExpireThread(final LicenseEntity licenseEntity) {
        // 用于同步的锁对象
        Object lock = new Object();
        Thread thread = new Thread(() -> {
            while (true) {
                long sleep = licenseEntity.getExpireTime() - System.currentTimeMillis();
                if (sleep <= 0) {
                    sleep = period;
                }
                if (sleep <= 0) {
                    sleep = 1000;
                }
                synchronized (lock) {
                    try {
                        // 等待指定时间
                        lock.wait(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 唤醒后执行的逻辑
                expireStrategy.expire(licenseEntity);
            }
        }, "licenseMonitor");
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * 加载许可证
     *
     * @param bytes 字节数组
     * @return 许可证实体
     * @throws IOException 流异常
     */
    public LicenseEntity loadLicense(byte[] bytes) throws IOException {
        // 将byte[]转化为输入流
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        // 读取magic number并进行校验
        byte[] magicBytes = new byte[LicenseEntity.MAGIC_NUM.length];
        inputStream.read(magicBytes);
        checkBytes(magicBytes);

        // 读取申请时间，并检查是否小于当前时间
        long applyTime = readLong(inputStream);
        if (applyTime > System.currentTimeMillis()) {
            throw new LicenseException("invalid license");
        }

        // 读取过期时间，并检查是否大于当前时间
        long expireTime = readLong(inputStream);
        if (expireTime < System.currentTimeMillis()) {
            throw new LicenseException("license expire");
        }

        // 读取md5值
        byte[] md5 = new byte[readInt(inputStream)];
        inputStream.read(md5);

        // 读取公钥
        byte[] publicKey = new byte[readInt(inputStream)];
        inputStream.read(publicKey);

        // 读取申请者
        byte[] applicant = new byte[readInt(inputStream)];
        inputStream.read(applicant);

        // 读取联系方式
        byte[] contact = new byte[readInt(inputStream)];
        inputStream.read(contact);

        // 解密数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int size = 0;
        while ((size = inputStream.read()) > 0) {
            byte[] part = new byte[size];
            inputStream.read(part);

            // 使用公钥解密
            byte[] decodeData = decryptByPublicKey(part, publicKey);
            byteArrayOutputStream.write(decodeData);

            // 验证数据是否被篡改
            if (readLong(inputStream) != expireTime % decodeData.length) {
                throw new LicenseException("invalid license");
            }
        }

        // 验证数据完整性
        byte[] data = byteArrayOutputStream.toByteArray();
        if (!Objects.equals(md5(data), new String(md5))) {
            throw new LicenseException("invalid license");
        }

        // 构造LicenseEntity实例并返回
        LicenseEntity entity = new LicenseEntity(expireTime, publicKey);
        entity.setApplicant(new String(applicant));
        entity.setContact(new String(contact));
        entity.setData(data);
        monitorExpireThread(entity);
        return entity;
    }

    private void checkBytes(byte[] b1) {
        if (b1.length != LicenseEntity.MAGIC_NUM.length) {
            throw new LicenseException("invalid license");
        }
        for (int i = 0; i < b1.length; i++) {
            if (b1[i] != LicenseEntity.MAGIC_NUM[i]) {
                throw new LicenseException("invalid license");
            }
        }
    }

    private long readLong(InputStream inputStream) throws IOException {
        int readCount = inputStream.read(readBuffer, 0, 8);
        if (readCount < 8) {
            throw new IOException("Unable to read 8 bytes for long value, only read " + readCount + " bytes.");
        }
        return (((long) readBuffer[0] << 56) +
                ((long) (readBuffer[1] & 255) << 48) +
                ((long) (readBuffer[2] & 255) << 40) +
                ((long) (readBuffer[3] & 255) << 32) +
                ((long) (readBuffer[4] & 255) << 24) +
                ((readBuffer[5] & 255) << 16) +
                ((readBuffer[6] & 255) << 8) +
                ((readBuffer[7] & 255)));
    }

    private int readInt(InputStream in) throws IOException {
        int ch1 = in.read();
        int ch2 = in.read();
        int ch3 = in.read();
        int ch4 = in.read();
        if ((ch1 | ch2 | ch3 | ch4) < 0) {
            throw new EOFException();
        }
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4));
    }
}
