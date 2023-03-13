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

import com.mobaijun.common.algorithm.MergeSort;
import com.mobaijun.common.test.algorithm.constant.Constant;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: MergeSortTest<br>
 * class description: 归并排序算法测试
 *
 * @author MoBaiJun 2023/2/20 0:15
 */
public class MergeSortTest {

    @Test
    public void mergeSortTest() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        // 执行算法并打印
        MergeSort.mergeSort(Constant.RANDOM_INT_ARRAY);
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }
}
