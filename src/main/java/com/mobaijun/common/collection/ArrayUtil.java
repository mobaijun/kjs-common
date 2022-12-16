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
package com.mobaijun.common.collection;

import com.mobaijun.common.constant.NumberConstant;
import com.mobaijun.common.enhance.EnhanceAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: ArrayUtils<br>
 * class description： 数组工具类
 *
 * @author MoBaiJun 2022/6/6 9:35
 */
public class ArrayUtil extends cn.hutool.core.util.ArrayUtil {

    /**
     * write specified bytes to a byte array start from offset
     *
     * @param b      b
     * @param offset offset
     * @param v      v
     * @param bytes  bytes
     */
    public static void write(byte[] b, int offset, long v, int bytes) {
        for (int i = 0; i < bytes; i++) {
            b[offset++] = (byte) ((v >>> (8 * i)) & 0xFF);
        }
    }

    /**
     * write an int to a byte array
     *
     * @param b      b
     * @param offset offset
     * @param v      v
     */
    public static void writeIntLong(byte[] b, int offset, long v) {
        b[offset++] = (byte) ((v) & 0xFF);
        b[offset++] = (byte) ((v >> 8) & 0xFF);
        b[offset++] = (byte) ((v >> 16) & 0xFF);
        b[offset] = (byte) ((v >> 24) & 0xFF);
    }

    /**
     * get an int from a byte array start from the specified offset
     *
     * @param b      b
     * @param offset offset
     */
    public static long getIntLong(byte[] b, int offset) {
        return (
                ((b[offset++] & 0x000000FFL)) |
                        ((b[offset++] << 8) & 0x0000FF00L) |
                        ((b[offset++] << 16) & 0x00FF0000L) |
                        ((b[offset] << 24) & 0xFF000000L)
        );
    }

    /**
     * get an int from a byte array start from the specified offset
     *
     * @param b      b
     * @param offset offset
     */
    public static int getInt3(byte[] b, int offset) {
        return (
                (b[offset++] & 0x000000FF) |
                        (b[offset++] & 0x0000FF00) |
                        (b[offset] & 0x00FF0000)
        );
    }

    public static int getInt2(byte[] b, int offset) {
        return (
                (b[offset++] & 0x000000FF) |
                        (b[offset] & 0x0000FF00)
        );
    }

    public static int getInt1(byte[] b, int offset) {
        return (
                (b[offset] & 0x000000FF)
        );
    }

    /**
     * string ip to long ip
     *
     * @param ip ip
     * @return long
     */
    public static long ip2long(String ip) {
        String[] p = ip.split("\\.");
        if (p.length != NumberConstant.FOUR) {
            return 0;
        }

        int p1 = ((Integer.parseInt(p[0]) << 24) & 0xFF000000);
        int p2 = ((Integer.parseInt(p[1]) << 16) & 0x00FF0000);
        int p3 = ((Integer.parseInt(p[2]) << 8) & 0x0000FF00);
        int p4 = ((Integer.parseInt(p[3])) & 0x000000FF);

        return ((p1 | p2 | p3 | p4) & 0xFFFFFFFFL);
    }

    /**
     * int to ip string
     *
     * @param ip ip
     * @return string
     */
    public static String long2ip(long ip) {
        return String.valueOf((ip >> 24) & 0xFF) + '.' +
                ((ip >> 16) & 0xFF) + '.' +
                ((ip >> 8) & 0xFF) + '.' +
                ((ip) & 0xFF);
    }

    /**
     * check to validate of the specified ip address
     *
     * @param ip ip
     * @return boolean
     */
    public static boolean isIpAddress(String ip) {
        String[] p = ip.split("\\.");
        if (p.length != NumberConstant.FOUR) {
            return false;
        }

        for (String pp : p) {
            if (pp.length() > 3) {
                return false;
            }
            int val = Integer.parseInt(pp);
            if (val > 255) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将数组转成字符串
     *
     * @param object 必须确保是数组，否则会抛出异常
     * @return String
     */
    public static String toString(Object object) {
        if (object == null) {
            return null;
        } else {
            EnhanceAssert.isTrue(isArray(object), "请确保实参是数组类型");
            Class<?> targetClass = object.getClass();
            if (targetClass == int[].class) {
                return Arrays.toString((int[]) object);
            } else if (targetClass == byte[].class) {
                return Arrays.toString((byte[]) object);
            } else if (targetClass == short[].class) {
                return Arrays.toString((short[]) object);
            } else if (targetClass == long[].class) {
                return Arrays.toString((long[]) object);
            } else if (targetClass == char[].class) {
                return Arrays.toString((char[]) object);
            } else if (targetClass == boolean[].class) {
                return Arrays.toString((boolean[]) object);
            } else if (targetClass == float[].class) {
                return Arrays.toString((float[]) object);
            } else if (targetClass == double[].class) {
                return Arrays.toString((double[]) object);
            } else {
                return Arrays.toString((Object[]) object);
            }
        }
    }

    /**
     * 获取数组第一个元素
     *
     * @param array 数组
     * @return 元素
     */
    public static <T> T getFirst(T[] array) {
        return isNotEmpty(array) ? array[0] : null;
    }

    /**
     * 数组转换为 list 集合,安全的，可增删改查的
     *
     * @param data 数据
     * @param <T>  类型
     * @return 集合
     */
    public static <T> List<T> arrayList(T[] data) {
        return Arrays.stream(data).collect(Collectors.toList());
    }
}