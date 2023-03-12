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
package com.mobaijun.common.test;

import com.mobaijun.common.collection.CollectionUtil;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.number.RandomUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: MoBaiJunTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 15:03
 */
public class MoBaiJunTest {

    public static final int[] chars = RandomUtil.generateRandomArray(10000000, 1, 1000000);

    @Test
    public void foreachTest() {
        long start = System.currentTimeMillis();
        for (int i : chars) {
            System.out.println("i = " + i);
        }
        long end = System.currentTimeMillis();
        PrintUtil.println((end - start) / 1000);
    }


    @Test
    public void streamTest() {
        long start = System.currentTimeMillis();
        Arrays.stream(chars).forEach(System.out::println);
        long end = System.currentTimeMillis();
        PrintUtil.println((end - start) / 1000);
    }

    @Test
    public void stringAndStringBuild() {
        List<String> list = CollectionUtil.newArrayList();
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        PrintUtil.println(sb);
    }
}
