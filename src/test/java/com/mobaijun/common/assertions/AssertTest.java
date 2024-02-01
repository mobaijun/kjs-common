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
package com.mobaijun.common.assertions;

import com.mobaijun.common.tool.PrintUtil;
import org.junit.Test;

/**
 * Description: [AssertTest测试类]
 * Author: [mobaijun]
 * Date: [2023/12/29 8:47]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class AssertTest {


    /**
     * Test for assertTrue.
     */
    @Test
    public void testAssertTrue() {
        // Perform the method call
        Assert.assertTrue(true, "message");
    }

    /**
     * Test for nullToEmptyCollection.
     */
    @Test
    public void testNullToEmptyCollection() {
        // Perform the method call
    }

    /**
     * Test for nullToEmptyMap.
     */
    @Test
    public void testNullToEmptyMap() {
        // Perform the method call
    }

    /**
     * Test for notNull.
     */
    @Test
    public void testNotNull() {
        // Perform the method call
    }

    /**
     * Test for notNull.
     */
    @Test
    public void testNotNull2() {
    }

    /**
     * Test for notEmpty.
     */
    @Test
    public void testNotEmpty() {
        // Perform the method call
        Assert.notEmpty("string", "name");
    }

    /**
     * Test for assertEquals.
     */
    @Test
    public void testAssertEquals() {
    }

    /**
     * Test for assertEqualsLen.
     */
    @Test
    public void testAssertEqualsLen() {
        // Perform the method call
        Assert.assertEqualsLen("string", 0, "desc");
    }

    /**
     * Test for isEqualsLen.
     */
    @Test
    public void testIsEqualsLen() {
        // Perform the method call
        boolean result = Assert.isEqualsLen("string", 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isNotEqualsLen.
     */
    @Test
    public void testIsNotEqualsLen() {
        // Perform the method call
        boolean result = Assert.isNotEqualsLen("string", 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isFitMaxLen.
     */
    @Test
    public void testIsFitMaxLen() {
        // Perform the method call
        boolean result = Assert.isFitMaxLen("string", 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isNotFitMaxLen.
     */
    @Test
    public void testIsNotFitMaxLen() {
        // Perform the method call
        boolean result = Assert.isNotFitMaxLen("string", 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isFitMinLen.
     */
    @Test
    public void testIsFitMinLen() {
        // Perform the method call
        boolean result = Assert.isFitMinLen("string", 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isNotFitMinLen.
     */
    @Test
    public void testIsNotFitMinLen() {
        // Perform the method call
        boolean result = Assert.isNotFitMinLen("string", 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isNumber.
     */
    @Test
    public void testIsNumber() {
        // Perform the method call
        boolean result = Assert.isNumber("number");

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isNotNumber.
     */
    @Test
    public void testIsNotNumber() {
        // Perform the method call
        Boolean result = Assert.isNotNumber("number");

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isMatchesRegex.
     */
    @Test
    public void testIsMatchesRegex() {
        // Perform the method call
        boolean result = Assert.isMatchesRegex("string", "regex");

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isNotMatchesRegex.
     */
    @Test
    public void testIsNotMatchesRegex() {
        // Perform the method call
        Boolean result = Assert.isNotMatchesRegex("string", "regex");

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for positive.
     */
    @Test
    public void testPositive() {
        // Perform the method call
        Assert.positive(0, "paramName");
    }

    /**
     * Test for notNegative.
     */
    @Test
    public void testNotNegative() {
        // Perform the method call
        Assert.notNegative(0, "paramName");
    }

    /**
     * Test for positive.
     */
    @Test
    public void testPositive2() {
        // Perform the method call
        Assert.positive(0L, "paramName");
    }

    /**
     * Test for notNegative.
     */
    @Test
    public void testNotNegative2() {
        // Perform the method call
        Assert.notNegative(0L, "paramName");
    }

    /**
     * Test for positive.
     */
    @Test
    public void testPositive3() {
        // Perform the method call
        Assert.positive(0d, "paramName");
    }

    /**
     * Test for notNegative.
     */
    @Test
    public void testNotNegative3() {
        // Perform the method call
        Assert.notNegative(0d, "paramName");
    }

    /**
     * Test for assertFalse.
     */
    @Test
    public void testAssertFalse() {
        // Perform the method call
        Assert.assertFalse(true, "name");
    }

    /**
     * Test for notEmpty.
     */
    @Test
    public void testNotEmpty2() {
    }

    /**
     * Test for notEmpty.
     */
    @Test
    public void testNotEmpty3() {
    }

    /**
     * Test for gt.
     */
    @Test
    public void testGt() {
    }

    /**
     * Test for gte.
     */
    @Test
    public void testGte() {
    }

    /**
     * Test for lt.
     */
    @Test
    public void testLt() {
    }

    /**
     * Test for lte.
     */
    @Test
    public void testLte() {
    }

}