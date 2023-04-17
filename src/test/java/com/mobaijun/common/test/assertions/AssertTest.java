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
package com.mobaijun.common.test.assertions;

import com.mobaijun.common.assertions.Assert;
import com.mobaijun.common.enums.http.HttpStatus;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: AssertTest<br>
 * class description:
 *
 * @author MoBaiJun 2023/3/13 12:05
 */
public class AssertTest {

    @Test
    public void assertTrue() {
        Assert.assertTrue(false, HttpStatus.CHECK_PARAM_FAIL.getMessage());
    }

    @Test
    public void nullToEmptyCollection() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.clear();
        PrintUtil.println(Assert.nullToEmptyCollection(list));
    }

    @Test
    public void nullToEmptyMap() {
        Map<String, String> map = new HashMap<>(5);
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        PrintUtil.println(Assert.nullToEmptyMap(map));
    }

    @Test
    public void notNull() {
        Assert.notNull(null, HttpStatus.INVALID_ARGUMENT.getMessage());
    }

    @Test
    public void testNotNull() {
        Assert.notNull(null, "mobaijun", HttpStatus.INVALID_ARGUMENT.getMessage());
    }

    @Test
    public void notEmpty() {
        Integer[] arrs = {1, 2, 3, 4, 5};
        // false
        Assert.notEmpty(arrs, "arrays");
        Arrays.stream(arrs).forEach(PrintUtil::println);
    }

    @Test
    public void assertEquals() {
        // false
        Assert.assertEquals(1, 2, HttpStatus.CHECK_PARAM_FAIL.getMessage());
    }

    @Test
    public void assertEqualsLen() {
        // false
        Assert.assertEqualsLen("mobaijun", 7, "校验失败！");
    }

    @Test
    public void isEqualsLen() {
        // true
        Assert.isEqualsLen("mobaijun", 8);
    }

    @Test
    public void isNotEqualsLen() {
    }

    @Test
    public void isFitMaxLen() {
    }

    @Test
    public void isNotFitMaxLen() {
    }

    @Test
    public void isFitMinLen() {
    }

    @Test
    public void isNotFitMinLen() {
    }

    @Test
    public void isNumber() {
    }

    @Test
    public void isNotNumber() {
    }

    @Test
    public void isMatchesRegex() {
    }

    @Test
    public void isNotMatchesRegex() {
    }

    @Test
    public void positive() {
    }

    @Test
    public void notNegative() {
    }

    @Test
    public void testPositive() {
    }

    @Test
    public void testNotNegative() {
    }

    @Test
    public void testPositive1() {
    }

    @Test
    public void testNotNegative1() {
    }

    @Test
    public void assertFalse() {
    }

    @Test
    public void testNotEmpty() {
    }

    @Test
    public void testNotEmpty1() {
    }

    @Test
    public void gt() {
    }

    @Test
    public void gte() {
    }

    @Test
    public void lt() {
    }

    @Test
    public void lte() {
    }
}
