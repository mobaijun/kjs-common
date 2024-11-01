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
package com.mobaijun.common.number;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: SizeUnit<br>
 * enum description: <br>表示基本的大小单位，类似于 TimeUnit。
 * Usage example:<br>
 * assertTrue(SizeUnit.BYTES.toMegaBytes(1024 * 1024) == 1.0);<br/>
 * assertTrue(SizeUnit.GIGABYTES.toBytes(1) == 1024.0 * 1024.0 * 1024.0);<br>
 *
 * @author MoBaiJun 2022/12/9 8:48
 */
public enum SizeUnit {

    /**
     * 最小的内存单位。
     */
    BYTES,

    /**
     * 一千（1024）字节。
     */
    KILOBYTES,

    /**
     * 一百万（1024x1024）字节。
     */
    MEGABYTES,

    /**
     * 十亿（1024x1024x1024）字节。
     */
    GIGABYTES;

    /**
     * 每千字节的字节数。
     */
    private final double BYTES_PER_KILOBYTE = 1024.0;

    /**
     * 每兆字节的千字节数。
     */
    private final double KILOBYTES_PER_MEGABYTE = 1024.0;

    /**
     * 每千兆字节的兆字节数。
     */
    private final double MEGABYTES_PER_GIGABYTE = 1024.0;

    /**
     * 返回对应于给定输入的字节数，基于特定的内存单位。
     *
     * @param input 内存单位的数量。
     * @return 对应于提供的内存单位数量的字节数。
     */
    public double toBytes(final long input) {
        return switch (this) {
            case BYTES -> input;
            case KILOBYTES -> input * BYTES_PER_KILOBYTE;
            case MEGABYTES -> input * BYTES_PER_KILOBYTE * KILOBYTES_PER_MEGABYTE;
            case GIGABYTES -> input * BYTES_PER_KILOBYTE * KILOBYTES_PER_MEGABYTE * MEGABYTES_PER_GIGABYTE;
        };
    }

    /**
     * 返回对应于给定输入的千字节数，基于特定的内存单位。
     *
     * @param input 内存单位的数量。
     * @return 对应于提供的内存单位数量的千字节数。
     */
    public double toKiloBytes(final long input) {
        return switch (this) {
            case BYTES -> input / BYTES_PER_KILOBYTE;
            case KILOBYTES -> input;
            case MEGABYTES -> input * KILOBYTES_PER_MEGABYTE;
            case GIGABYTES -> input * KILOBYTES_PER_MEGABYTE * MEGABYTES_PER_GIGABYTE;
        };
    }

    /**
     * 返回对应于给定输入的兆字节数，基于特定的内存单位。
     *
     * @param input 内存单位的数量。
     * @return 对应于提供的内存单位数量的兆字节数。
     */
    public double toMegaBytes(final long input) {
        return switch (this) {
            case BYTES -> input / BYTES_PER_KILOBYTE / KILOBYTES_PER_MEGABYTE;
            case KILOBYTES -> input / KILOBYTES_PER_MEGABYTE;
            case MEGABYTES -> input;
            case GIGABYTES -> input * MEGABYTES_PER_GIGABYTE;
        };
    }

    /**
     * 返回对应于给定输入的千兆字节数，基于特定的内存单位。
     *
     * @param input 内存单位的数量。
     * @return 对应于提供的内存单位数量的千兆字节数。
     */
    public double toGigaBytes(final long input) {
        return switch (this) {
            case BYTES -> input / BYTES_PER_KILOBYTE / KILOBYTES_PER_MEGABYTE / MEGABYTES_PER_GIGABYTE;
            case KILOBYTES -> input / KILOBYTES_PER_MEGABYTE / MEGABYTES_PER_GIGABYTE;
            case MEGABYTES -> input / MEGABYTES_PER_GIGABYTE;
            case GIGABYTES -> input;
        };
    }
}