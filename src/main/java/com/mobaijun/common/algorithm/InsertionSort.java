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

import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: InsertionSort<br>
 * class description: 插入排序<br/>
 * 插入排序是一种简单直观的排序算法，其基本思想是将待排序的元素按照大小顺序依次插入到已排序的序列中。
 * <p>
 * 插入排序可以通过以下步骤来实现：<br/>
 * 1.从第一个元素开始，该元素可以认为已经被排序。<br/>
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描。<br/>
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置。<br/>
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置。<br/>
 * 5.将新元素插入到该位置后。<br/>
 * 6.重复步骤2~5，直到整个序列被排序。<br/>
 *
 * @author MoBaiJun 2023/2/19 22:50
 */
public final class InsertionSort {

    /**
     * 在代码中，我们使用了两个循环来实现插入排序。第一个循环从第二个元素开始遍历数组，
     * 第二个循环向前遍历已排序的元素，将大于新元素的元素向右移动一位，
     * 最终将新元素插入到正确的位置。该算法的时间复杂度为 O(n^2)，空间复杂度为 O(1)。
     * <img src="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015225645277-1151100000.gif"/>
     *
     * @param arr 待排序的数组
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 减少比较次数：在第二个循环中，可以使用二分查找的方法来确定新元素的位置，从而减少比较次数。
     * 具体实现时，可以使用 Arrays.binarySearch() 函数来查找新元素的插入位置。
     * <p>
     * 减少交换次数：在第二个循环中，每次将大于新元素的元素向右移动一位，直到找到新元素的插入位置。
     * 如果数组中的元素比较大，这将导致多次元素的移动。可以将每个元素的插入位置计算出来，并在最后一次交换时一次性将元素插入到正确的位置。
     *
     * @param arr 待排序的数组
     */
    public static void insertionSortOptimized(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int pos = Arrays.binarySearch(arr, 0, i, key);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            System.arraycopy(arr, pos, arr, pos + 1, i - pos);
            arr[pos] = key;
        }
    }
}
