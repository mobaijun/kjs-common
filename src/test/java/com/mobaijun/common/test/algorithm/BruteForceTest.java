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
package com.mobaijun.common.test.algorithm;

import com.mobaijun.common.algorithm.BruteForce;
import org.junit.Assert;
import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: BruteForceTest<br>
 * class description: 暴力匹配测试用例
 *
 * @author MoBaiJun 2023/2/20 8:09
 */
public class BruteForceTest {

    @Test
    public void testBruteForce() {
        String text = "hello world";
        String pattern = "world";
        int expectedIndex = 6;

        int actualIndex = BruteForce.bruteForceMatch(pattern, text);

        Assert.assertEquals("Test failure！", expectedIndex, actualIndex);
    }
}
