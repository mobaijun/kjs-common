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

import com.mobaijun.common.algorithm.BubbleSort;
import com.mobaijun.common.test.algorithm.constant.Constant;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: BubbleSortTest
 * class description: 冒泡排序测试
 *
 * @author MoBaiJun 2023/2/15 21:52
 */
public class BubbleSortTest {

    @Test
    public void bubbleSort1() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        int[] arrays = BubbleSort.bubbleSort(Constant.RANDOM_INT_ARRAY);
        // 创建随机数组并排序
        for (int i : arrays) {
            PrintUtil.println(i);
        }
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }

    @Test
    public void bubbleSort2() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        int[] arrays = BubbleSort.bubbleSortWithOptimization(Constant.RANDOM_INT_ARRAY);
        // 创建随机数组并排序
        for (int i : arrays) {
            PrintUtil.println(i);
        }
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }
}
