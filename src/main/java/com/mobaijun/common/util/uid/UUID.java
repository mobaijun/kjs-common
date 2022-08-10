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
package com.mobaijun.common.util.uid;

import com.mobaijun.common.exception.UtilException;
import com.mobaijun.common.result.enums.HttpStatus;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: UUID
 * class description：
 *
 * @author MoBaiJun 2022/5/12 14:23
 */
public class UUID implements Serializable, Comparable<UUID> {

    private static final long serialVersionUID = -1185015143654744140L;

    /**
     * SecureRandom 的单例
     */
    private static class Holder {
        static final SecureRandom NUMBER_GENERATOR = getSecureRandom();
    }

    /**
     * 此UUID的最高64有效位
     */
    private final long mostSigBits;

    /**
     * 此UUID的最低64有效位
     */
    private final long leastSigBits;

    /**
     * 私有构造
     *
     * @param data 数据
     */
    private UUID(byte[] data) {
        long msb = 0;
        long lsb = 0;
        assert data.length == 16 : "data must be 16 bytes in length";
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (data[i] & 0xff);
        }
        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (data[i] & 0xff);
        }
        this.mostSigBits = msb;
        this.leastSigBits = lsb;
    }

    /**
     * 使用指定的数据构造新的 UUID。
     *
     * @param mostSigBits  用于  UUID  的最高有效 64 位
     * @param leastSigBits 用于  UUID  的最低有效 64 位
     */
    public UUID(long mostSigBits, long leastSigBits) {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
    }

    /**
     * 获取类型 4（伪随机生成的）UUID 的静态工厂。 使用加密的本地线程伪随机数生成器生成该 UUID。
     *
     * @return 随机生成的   UUID
     */
    public static UUID fastUUID() {
        return randomUUID(false);
    }

    /**
     * 获取类型 4（伪随机生成的）UUID 的静态工厂。 使用加密的强伪随机数生成器生成该 UUID。
     *
     * @return 随机生成的 UUID
     */
    public static UUID randomUUID() {
        return randomUUID(true);
    }

    /**
     * 获取类型 4（伪随机生成的）UUID 的静态工厂。 使用加密的强伪随机数生成器生成该 UUID。
     *
     * @param isSecure 是否使用 secureRandom如果是可以获得更安全的随机码，否则可以得到更好的性能
     * @return 随机生成的   UUID
     */
    public static UUID randomUUID(boolean isSecure) {
        final Random ng = isSecure ? Holder.NUMBER_GENERATOR : getRandom();

        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        /* clear version */
        randomBytes[6] &= 0x0f;
        /* set to version 4 */
        randomBytes[6] |= 0x40;
        /* clear variant */
        randomBytes[8] &= 0x3f;
        /* set to IETF variant */
        randomBytes[8] |= 0x80;
        return new UUID(randomBytes);
    }

    /**
     * 根据指定的字节数组获取类型 3（基于名称的）UUID 的静态工厂。
     *
     * @param name 用于构造 UUID 的字节数组。
     * @return 根据指定数组生成的 UUID
     */
    public static UUID nameUUIDFromBytes(byte[] name) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsa) {
            throw new InternalError("MD5 not supported");
        }
        byte[] md5Bytes = md.digest(name);
        /* clear version */
        md5Bytes[6] &= 0x0f;
        /* set to version 3 */
        md5Bytes[6] |= 0x30;
        /* clear variant */
        md5Bytes[8] &= 0x3f;
        /* set to IETF variant */
        md5Bytes[8] |= 0x80;
        return new UUID(md5Bytes);
    }

    /**
     * 根据 toString() 方法中描述的字符串标准表示形式创建UUID。
     *
     * @param name 指定 UUID 字符串
     * @return 具有指定值的  UUID
     * @throws IllegalArgumentException 如果 name 与  #toString 中描述的字符串表示形式不符抛出此异常
     */
    public static UUID fromString(String name) {
        String[] components = name.split("-");
        if (components.length != 5) {
            throw new IllegalArgumentException("Invalid UUID string: " + name);
        }
        for (int i = 0; i < 5; i++) {
            components[i] = "0x" + components[i];
        }

        long mostSigBits = Long.decode(components[0]);
        mostSigBits <<= 16;
        mostSigBits |= Long.decode(components[1]);
        mostSigBits <<= 16;
        mostSigBits |= Long.decode(components[2]);

        long leastSigBits = Long.decode(components[3]);
        leastSigBits <<= 48;
        leastSigBits |= Long.decode(components[4]);

        return new UUID(mostSigBits, leastSigBits);
    }

    /**
     * 返回此 UUID 的 128 位值中的最低有效 64 位。
     *
     * @return 此 UUID 的 128 位值中的最低有效 64 位。
     */
    public long getLeastSignificantBits() {
        return leastSigBits;
    }

    /**
     * 返回此 UUID 的 128 位值中的最高有效 64 位。
     *
     * @return 此 UUID 的 128 位值中最高有效 64 位。
     */
    public long getMostSignificantBits() {
        return mostSigBits;
    }

    /**
     * 与此  UUID相关联的版本号. 版本号描述此   UUID 是如何生成的。
     * 版本号具有以下含意:
     * 1 基于时间的 UUID
     * 2 DCE 安全 UUID
     * 3 基于名称的 UUID
     * 4 随机生成的 UUID
     *
     * @return 此  UUID 的版本号
     */
    public int version() {
        // Version is bits masked by 0x000000000000F000 in MS long
        return (int) ((mostSigBits >> 12) & 0x0f);
    }

    /**
     * 与此  UUID 相关联的变体号。变体号描述  UUID 的布局。
     * <p>
     * 变体号具有以下含意：
     * <p>
     * 0 为 NCS 向后兼容保留
     * 2http://www.ietf.org/rfc/rfc4122.txt"(Leach-Salz), 用于此类
     * 6 保留，微软向后兼容
     * 7 保留供以后定义使用
     *
     * @return 此  UUID相关联的变体号
     */
    public int variant() {
        // This field is composed of a varying number of bits.
        // 0 - - Reserved for NCS backward compatibility
        // 1 0 - The IETF aka Leach-Salz variant (used by this class)
        // 1 1 0 Reserved, Microsoft backward compatibility
        // 1 1 1 Reserved for future definition.
        return (int) ((leastSigBits >>> (64 - (leastSigBits >>> 62))) & (leastSigBits >> 63));
    }

    /**
     * 与此 UUID 相关联的时间戳值。
     *
     * <p>
     * 60 位的时间戳值根据此  UUID 的 time_low、time_mid 和 time_hi 字段构造。
     * 所得到的时间戳以 100 毫微秒为单位，从 UTC（通用协调时间） 1582 年 10 月 15 日零时开始。
     *
     * <p>
     * 时间戳值仅在在基于时间的 UUID（其 version 类型为 1）中才有意义。<br>
     * 如果此 UUID 不是基于时间的 UUID，则此方法抛出 UnsupportedOperationException。
     *
     * @return long
     * @throws UnsupportedOperationException 如果此  UUID 不是 version 为 1 的 UUID。
     */
    public long timestamp() throws UnsupportedOperationException {
        checkTimeBase();
        return (mostSigBits & 0x0FFFL) << 48
                | ((mostSigBits >> 16) & 0x0FFFFL) << 32
                | mostSigBits >>> 32;
    }

    /**
     * 与此 UUID 相关联的时钟序列值。
     *
     * <p>
     * 14 位的时钟序列值根据此 UUID 的 clock_seq 字段构造。clock_seq 字段用于保证在基于时间的 UUID 中的时间唯一性。
     * <p>
     * clockSequence 值仅在基于时间的 UUID（其 version 类型为 1）中才有意义。 如果此 UUID 不是基于时间的 UUID，则此方法抛出
     * UnsupportedOperationException。
     *
     * @return 此 UUID 的时钟序列
     * @throws UnsupportedOperationException 如果此 UUID 的 version 不为 1
     */
    public int clockSequence() throws UnsupportedOperationException {
        checkTimeBase();
        return (int) ((leastSigBits & 0x3FFF000000000000L) >>> 48);
    }

    /**
     * 与此 UUID 相关的节点值。
     *
     * <p>
     * 48 位的节点值根据此 UUID 的 node 字段构造。此字段旨在用于保存机器的 IEEE 802 地址，该地址用于生成此 UUID 以保证空间唯一性。
     * <p>
     * 节点值仅在基于时间的 UUID（其 version 类型为 1）中才有意义。<br>
     * 如果此 UUID 不是基于时间的 UUID，则此方法抛出 UnsupportedOperationException。
     *
     * @return 此  UUID  的节点值
     * @throws UnsupportedOperationException 如果此 UUID 的 version 不为 1
     */
    public long node() throws UnsupportedOperationException {
        checkTimeBase();
        return leastSigBits & 0x0000FFFFFFFFFFFFL;
    }

    /**
     * 返回此 UUID 的字符串表现形式。
     * <p>
     * UUID 的字符串表示形式由此 BNF 描述：
     * UUID                   = time_low time_mid time_high_and_version variant_and_sequence
     * time_low               = 4*hexOctet
     * time_mid               = 2*hexOctet
     * time_high_and_version  = 2*hexOctet
     * variant_and_sequence   = 2*hexOctet
     * node                   = 6*hexOctet
     * hexOctet               = hexDigit
     * hexDigit               = [0-9a-fA-F]
     *
     * @return 此UUID 的字符串表现形式
     * @see #toString(boolean)
     */
    @Override
    public String toString() {
        return toString(false);
    }

    /**
     * 返回此 UUID 的字符串表现形式。
     * <p>
     * UUID 的字符串表示形式由此 BNF 描述：
     * <p>
     * UUID                   = time_low time_mid time_high_and_version variant_and_sequence
     * time_low               = 4*hexOctet
     * time_mid               = 2*hexOctet
     * time_high_and_version  = 2*hexOctet
     * variant_and_sequence   = 2*hexOctet
     * node                   = 6*hexOctet
     * hexOctet               = hexDigit
     * hexDigit               = [0-9a-fA-F]
     * }
     *
     * @param isSimple 是否简单模式，简单模式为不带'-'的UUID字符串
     * @return 此UUID 的字符串表现形式
     */
    public String toString(boolean isSimple) {
        final StringBuilder builder = new StringBuilder(isSimple ? 32 : 36);
        // time_low
        builder.append(digits(mostSigBits >> 32, 8));
        if (!isSimple) {
            builder.append('-');
        }
        // time_mid
        builder.append(digits(mostSigBits >> 16, 4));
        if (!isSimple) {
            builder.append('-');
        }
        // time_high_and_version
        builder.append(digits(mostSigBits, 4));
        if (!isSimple) {
            builder.append('-');
        }
        // variant_and_sequence
        builder.append(digits(leastSigBits >> 48, 4));
        if (!isSimple) {
            builder.append('-');
        }
        // node
        builder.append(digits(leastSigBits, 12));

        return builder.toString();
    }

    /**
     * 返回此 UUID 的哈希码。
     *
     * @return UUID 的哈希码值。
     */
    @Override
    public int hashCode() {
        long hilo = mostSigBits ^ leastSigBits;
        return ((int) (hilo >> 32)) ^ (int) hilo;
    }

    /**
     * 将此对象与指定对象比较。
     * 当且仅当参数不为 null、而是一个 UUID 对象、具有与此 UUID 相同的 variant、包含相同的值（每一位均相同）时，结果才为 {@code true}。
     *
     * @param obj 要与之比较的对象
     * @return 如果对象相同，则返回 true；否则返回 false
     */
    @Override
    public boolean equals(Object obj) {
        if ((null == obj) || (obj.getClass() != UUID.class)) {
            return false;
        }
        UUID id = (UUID) obj;
        return (mostSigBits == id.mostSigBits && leastSigBits == id.leastSigBits);
    }

    /**
     * 将此 UUID 与指定的 UUID 比较。
     * 如果两个 UUID 不同，且第一个 UUID 的最高有效字段大于第二个 UUID 的对应字段，则第一个 UUID 大于第二个 UUID。
     *
     * @param val 与此 UUID 比较的 UUID
     * @return 在此 UUID 小于、等于或大于 val 时，分别返回 -1、0 或 1。
     */
    @Override
    public int compareTo(UUID val) {
        return (this.mostSigBits < val.mostSigBits ? -1 : //
                (this.mostSigBits > val.mostSigBits ? 1 : //
                        (Long.compare(this.leastSigBits, val.leastSigBits))));
    }


    /**
     * 返回指定数字对应的hex值
     *
     * @param val    值
     * @param digits 位
     * @return 值
     */
    private static String digits(long val, int digits) {
        long hi = 1L << (digits * 4);
        return Long.toHexString(hi | (val & (hi - 1))).substring(1);
    }

    /**
     * 检查是否为time-based版本 UUID
     */
    private void checkTimeBase() {
        if (version() != 1) {
            throw new UnsupportedOperationException("Not a time-based UUID");
        }
    }

    /**
     * 获取SecureRandom，类提供加密的强随机数生成器 (RNG)
     *
     * @return SecureRandom
     */
    public static SecureRandom getSecureRandom() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new UtilException(HttpStatus.ERROR.getCode(), e.getMessage());
        }
    }

    /**
     * 获取随机数生成器对象
     * ThreadLocalRandom是JDK 7之后提供并发产生随机数，能够解决多个线程发生的竞争争夺。
     *
     * @return ThreadLocalRandom
     */
    public static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }
}