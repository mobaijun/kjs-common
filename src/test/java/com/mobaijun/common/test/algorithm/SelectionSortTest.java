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
package com.mobaijun.common.test.algorithm;

import com.mobaijun.common.algorithm.SelectionSort;
import com.mobaijun.common.test.algorithm.constant.Constant;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: SelectionSortTest
 * class description: 选择排序测试
 *
 * @author MoBaiJun 2023/2/19 23:10
 */
public class SelectionSortTest {

    @Test
    public void SelectionSortTest1() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 创建随机数组并执行排序
        SelectionSort.selectionSort(Constant.RANDOM_INT_ARRAY);
        PrintUtil.print("排序后---------------------------------");
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }

    @Test
    public void SelectionSortTest2() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 创建随机数组并执行排序
        SelectionSort.selectionSortImproved(Constant.RANDOM_INT_ARRAY);
        PrintUtil.print("排序后---------------------------------");
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }

    @Test
    public void SelectionSortTest3() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 创建随机数组并执行排序
        SelectionSort.selectionSortWithTwoPointers(Constant.RANDOM_INT_ARRAY);
        PrintUtil.print("排序后---------------------------------");
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }
}
