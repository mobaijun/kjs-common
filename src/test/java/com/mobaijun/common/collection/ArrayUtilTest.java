/*
 * Copyright (C) 2022 [%s]
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

import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

/**
 * Description: [ArrayUtilTest测试类]
 * Author: [mobaijun]
 * Date: [2023/12/29 8:49]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class ArrayUtilTest {


    /**
     * Test for write.
     */
    @Test
    public void testWrite() {
        // Perform the method call
        ArrayUtil.write(new byte[]{(byte) 0}, 0, 0L, 0);
    }

    /**
     * Test for writeIntLong.
     */
    @Test
    public void testWriteIntLong() {
        // Perform the method call
        ArrayUtil.writeIntLong(new byte[]{(byte) 0}, 0, 0L);
    }

    /**
     * Test for getIntLong.
     */
    @Test
    public void testGetIntLong() {
        // Perform the method call
        long result = ArrayUtil.getIntLong(new byte[]{(byte) 0}, 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for getInt3.
     */
    @Test
    public void testGetInt3() {
        // Perform the method call
        int result = ArrayUtil.getInt3(new byte[]{(byte) 0}, 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for getInt2.
     */
    @Test
    public void testGetInt2() {
        // Perform the method call
        int result = ArrayUtil.getInt2(new byte[]{(byte) 0}, 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for getInt1.
     */
    @Test
    public void testGetInt1() {
        // Perform the method call
        int result = ArrayUtil.getInt1(new byte[]{(byte) 0}, 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for ip2long.
     */
    @Test
    public void testIp2long() {
        // Perform the method call
        long result = ArrayUtil.ip2long("ip");

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for long2ip.
     */
    @Test
    public void testLong2ip() {
        // Perform the method call
        String result = ArrayUtil.long2ip(0L);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for arrayToString.
     */
    @Test
    public void testArrayToString() {
        // Perform the method call
//        String result = ArrayUtil.arrayToString();

        // Print the result using your PrintUtil
//        PrintUtil.println(result);
    }

    /**
     * Test for getFirst.
     */
    @Test
    public void testGetFirst() {
    }

    /**
     * Test for arrayToList.
     */
    @Test
    public void testArrayToList() {
    }

    /**
     * Test for findIgnoreCase.
     */
    @Test
    public void testFindIgnoreCase() {
        // Perform the method call
        int result = ArrayUtil.findIgnoreCase(new String[]{"arr"}, "target");

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

}