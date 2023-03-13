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

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: RadixSort<br>
 * class description: 基数排序算法实现
 * <p>
 * 基数排序是一种非比较排序算法，它将整数按位数切割成不同的数字，然后按每个位数分别进行排序。基数排序是一种稳定的排序算法，适用于待排序元素的位数较小但元素较多的序列。
 * <p/>
 * 基数排序的原理是：对于需要排序的元素，按照个位、十位、百位等“指数”进行排序，每一次排序都是对元素在某一“指数”下的统计和累加操作，最后得到有序的元素序列。
 * </p>
 *
 * @author MoBaiJun 2023/2/20 8:23
 */
public final class RadixSort {

    /**
     * 先获取数组中的最大值，以确定需要排序的“指数”位数，然后从个位开始循环，对每个“指数”进行排序。<br/>
     * 在排序过程中，采用计数排序的思想，统计每个“指数”出现的次数，并累加得到元素在有序序列中的位置。<br/>
     * 最后将元素按照有序序列中的位置放入新的序列中，最后将有序序列赋值给原数组。<br/>
     * <img src="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015232453668-1397662527.gif"/>
     *
     * @param arr 待排序的数组
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 获取数组中的最大值
        int maxVal = arr[0];
        for (int val : arr) {
            maxVal = Math.max(maxVal, val);
        }

        // 从个位开始，对数组按照“指数”进行排序
        for (int exp = 1; maxVal / exp > 0; exp *= 10) {
            // 计数排序的操作，统计每个“指数”的出现次数
            int[] count = new int[10];
            for (int val : arr) {
                count[(val / exp) % 10]++;
            }
            // 统计出现次数的累加操作，得到元素在有序序列中的位置
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            // 将元素放入有序序列中
            int[] sortedArr = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                sortedArr[count[(arr[i] / exp) % 10] - 1] = arr[i];
                count[(arr[i] / exp) % 10]--;
            }
            // 将有序序列赋值给原数组
            System.arraycopy(sortedArr, 0, arr, 0, arr.length);
        }
    }
}
