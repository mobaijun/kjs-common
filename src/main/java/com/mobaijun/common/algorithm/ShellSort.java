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
package com.mobaijun.common.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: ShellSort<br>
 * class description: 希尔排序实现
 * <p>
 * 希尔排序是一种基于插入排序的排序算法，也称为“缩小增量排序”。其主要思想是将待排序的数组分割成若干个子序列，分别进行插入排序，最终整个序列就成为了有序序列。
 * <p>
 * 具体实现时，先确定一个初始的间隔值 gap，然后将数组中相距 gap 的元素作为一组进行插入排序，使得每一组内部的元素都尽可能有序。然后缩小间隔值，重复进行插入排序，直到间隔值为 1，最后对整个数组进行一次插入排序，完成排序。
 * <p>
 *
 * @author MoBaiJun 2023/2/20 8:21
 */
public final class ShellSort {

    /**
     * 相对于插入排序，希尔排序的优点是可以将较小的元素快速地移动到数组的左侧，加快排序的速度。
     * 同时，希尔排序的时间复杂度也比插入排序要低，最坏情况下为 O(n^2)，平均情况下为 O(n log n)。
     * <img src="https://images2018.cnblogs.com/blog/1192699/201803/1192699-20180319094116040-1638766271.png"/>
     *
     * @param arr 待排序的数组
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        // 生成增量序列
        for (int gap : generateIncrementSequence(n)) {
            // 对每个增量进行插入排序
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                // 对每个组进行插入排序
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    /**
     * 生成希尔排序的增量序列
     *
     * @param n 数组长度
     * @return 增量序列
     */
    private static List<Integer> generateIncrementSequence(int n) {
        List<Integer> increments = new ArrayList<>();
        int k = 1;
        // 生成增量序列
        while (k <= n / 3) {
            increments.add(k);
            k = 3 * k + 1;
        }
        if (k <= n) {
            increments.add(k);
        }
        // 增量序列倒序排列
        Collections.reverse(increments);
        return increments;
    }
}
