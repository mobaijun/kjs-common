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

import com.mobaijun.common.assertions.Assert;
import com.mobaijun.common.constant.NumberConstant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: ArrayUtils<br>
 * class description： 数组工具类
 *
 * @author MoBaiJun 2022/6/6 9:35
 */
public class ArrayUtil {

    /**
     * 数组中元素未找到的下标，值为-1
     */
    private static final int INDEX_NOT_FOUND = -1;

    /**
     * 将一个long类型的数值写入一个byte数组指定的位置，写入的字节数为指定的bytes，
     * 写入的方式是将long类型的数值按照二进制位逐个取出，然后分别写入byte数组中，
     * 每个byte代表一个二进制位，从最高位开始写入。
     *
     * @param b      需要写入的byte数组
     * @param offset 写入的起始位置
     * @param v      需要写入的long类型数值
     * @param bytes  需要写入的字节数
     */
    public static void write(byte[] b, int offset, long v, int bytes) {
        for (int i = 0; i < bytes; i++) {
            b[offset++] = (byte) ((v >>> (8 * i)) & 0xFF);
        }
    }

    /**
     * 将 long 类型的整数写入字节数组中，共占4个字节，高位字节在前，低位字节在后
     *
     * @param b      目标字节数组
     * @param offset 开始写入的偏移量
     * @param v      要写入的 long 型整数
     */
    public static void writeIntLong(byte[] b, int offset, long v) {
        // 写入低位字节
        b[offset++] = (byte) ((v) & 0xFF);
        // 写入次低位字节
        b[offset++] = (byte) ((v >> 8) & 0xFF);
        // 写入次高位字节
        b[offset++] = (byte) ((v >> 16) & 0xFF);
        // 写入高位字节
        b[offset] = (byte) ((v >> 24) & 0xFF);
    }


    /**
     * 从字节数组中获取long类型的整数
     *
     * @param b      字节数组
     * @param offset 数组中long类型整数的起始偏移量
     * @return 解析出的long类型整数
     */
    public static long getIntLong(byte[] b, int offset) {
        return (
                // 获取偏移位置对应的字节，无符号右移24位并进行位或操作
                ((b[offset++] & 0x000000FFL)) |
                        // 获取偏移位置+1对应的字节，左移8位并进行位或操作
                        ((b[offset++] << 8) & 0x0000FF00L) |
                        // 获取偏移位置+2对应的字节，左移16位并进行位或操作
                        ((b[offset++] << 16) & 0x00FF0000L) |
                        // 获取偏移位置+3对应的字节，左移24位并进行位或操作
                        ((b[offset] << 24) & 0xFF000000L)
        );
    }

    /**
     * 从字节数组中获取3字节的int值
     *
     * @param b      字节数组
     * @param offset 开始位置
     * @return 获取的int值
     */
    public static int getInt3(byte[] b, int offset) {
        return (
                // 第1个字节的低8位
                (b[offset++] & 0x000000FF) |
                        // 第2个字节的低8位
                        (b[offset++] & 0x0000FF00) |
                        // 第3个字节的高8位
                        (b[offset] & 0x00FF0000)
        );
    }

    /**
     * 从字节数组的指定偏移量处读取2个字节，转换为int类型返回。
     * 字节数组中从偏移量offset开始的两个字节按照大端序解析为一个16位的整数值。
     *
     * @param b      字节数组
     * @param offset 偏移量
     * @return 16位整数值
     */
    public static int getInt2(byte[] b, int offset) {
        return (
                // 取第一个字节，转为int类型
                (b[offset++] & 0x000000FF) |
                        // 取第二个字节，转为int类型
                        (b[offset] & 0x0000FF00)
        );
    }

    /**
     * 从字节数组中获取1字节整数值，按照小端字节序转换
     *
     * @param b      字节数组
     * @param offset 偏移量
     * @return 1字节整数值
     */
    public static int getInt1(byte[] b, int offset) {
        return (
                (b[offset] & 0x000000FF)
        );
    }

    /**
     * 将 IP 地址转换成对应的 long 类型数值
     *
     * @param ip IP 地址字符串，例如 "192.168.0.1"
     * @return 转换后的 long 类型数值
     */
    public static long ip2long(String ip) {
        // 将 IP 地址按照 "." 分割为 4 个字符串
        String[] p = ip.split("\\.");
        if (p.length != NumberConstant.FOUR) {
            // 如果分割后字符串数量不为 4，则返回 0 表示转换失败
            return 0;
        }

        // 将 4 个字符串转换为对应的整数，左移并位运算得到最终的 long 类型数值
        int p1 = ((Integer.parseInt(p[0]) << 24) & 0xFF000000);
        int p2 = ((Integer.parseInt(p[1]) << 16) & 0x00FF0000);
        int p3 = ((Integer.parseInt(p[2]) << 8) & 0x0000FF00);
        int p4 = ((Integer.parseInt(p[3])) & 0x000000FF);

        return ((p1 | p2 | p3 | p4) & 0xFFFFFFFFL);
    }

    /**
     * 将一个long类型的IP地址转换成IPv4地址格式的字符串
     *
     * @param ip 需要转换的long类型IP地址
     * @return 转换后的IPv4地址格式的字符串
     */
    public static String long2ip(long ip) {
        // 将long类型IP地址的高8位右移24位后与0xFF按位与得到第1个字节（最高位）
        // 将long类型IP地址的第2个字节的高8位右移16位后与0xFF按位与得到第2个字节
        // 将long类型IP地址的第3个字节的高8位右移8位后与0xFF按位与得到第3个字节
        // 将long类型IP地址的低8位与0xFF按位与得到第4个字节（最低位）
        // 将每个字节用"."拼接成IPv4地址格式的字符串返回
        return String.valueOf((ip >> 24) & 0xFF) + '.' +
                ((ip >> 16) & 0xFF) + '.' +
                ((ip >> 8) & 0xFF) + '.' +
                ((ip) & 0xFF);
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
            Assert.assertTrue(CollectionUtil.isArray(object), "请确保实参是数组类型");
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
        return !CollectionUtil.isArray(array) ? array[0] : null;
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

    /**
     * 返回数组中指定元素所在位置，忽略大小写，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param arr    数组
     * @param target 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int findIgnoreCase(String[] arr, String target) {
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i].equalsIgnoreCase(target))
                .findFirst()
                .orElse(INDEX_NOT_FOUND);
    }
}