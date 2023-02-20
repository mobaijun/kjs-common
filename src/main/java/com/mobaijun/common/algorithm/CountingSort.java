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
package com.mobaijun.common.algorithm;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: CountingSort<br>
 * class description: 计数排序算法实现
 * <p>
 * 计数排序是一种基于比较计数的排序算法，通过对每个元素出现的次数进行计数，然后依次输出，从而得到排序结果。它适用于数据范围较小，且元素值非负整数的情况。
 * </p>
 *
 * @author MoBaiJun 2023/2/20 8:23
 */
public final class CountingSort {

    /**
     * 该算法的时间复杂度为 $O(n+k)$，其中 $n$ 是数组的长度，$k$ 是数组中元素的取值范围。计数排序不需要进行比较和交换，因此它是一种非常高效的排序算法，适用于数据范围较小的场景。
     * 需要注意的是，该算法对元素的取值范围有一定的要求，如果取值范围过大，就需要消耗过多的空间，从而影响计数数组的初始化和使用。
     * <img src="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015231740840-6968181.gif"/>
     *
     * @param arr 待排序数组
     */
    public static void countingSort(int[] arr) {
        // 获取数组中的最大值和最小值
        int maxVal = arr[0], minVal = arr[0];
        for (int val : arr) {
            maxVal = Math.max(maxVal, val);
            minVal = Math.min(minVal, val);
        }

        // 初始化计数数组并进行计数
        int[] count = new int[maxVal - minVal + 1];
        for (int val : arr) {
            count[val - minVal]++;
        }

        // 累加计数数组中的元素，得到元素在有序序列中的位置
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 根据计数数组，将元素放入有序序列中
        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[count[arr[i] - minVal] - 1] = arr[i];
            count[arr[i] - minVal]--;
        }

        // 将有序序列赋值给原数组
        System.arraycopy(sortedArr, 0, arr, 0, arr.length);
    }
}
