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
package com.mobaijun.common.util.collection;

import com.mobaijun.common.constant.NumberConstant;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ArrayUtils
 * class description： 数组工具类
 *
 * @author MoBaiJun 2022/6/6 9:35
 */
public class ArrayUtils {

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
}