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
 * class name: QuickSort<br>
 * class description: 快速排序
 * <p/>
 * 快速排序是一种基于分治思想的排序算法。
 * 其基本思想是选择一个基准元素，然后将数组分为左右两个子数组，左边的元素均小于基准元素，
 * 右边的元素均大于基准元素，然后递归地对左右子数组进行排序，最终完成排序。
 *
 * @author MoBaiJun 2023/2/19 23:41
 */
public final class QuickSort {

    /**
     * 快速排序算法，使用递归实现。首先选择数组中的一个元素作为基准（pivot），然后将数组中小于基准的元素放在基准左边，
     * 大于基准的元素放在基准右边，然后分别对左右两个子数组进行递归排序，直到整个数组有序。
     * <img src="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015230936371-1413523412.gif"/>
     *
     * @param arr   待排序的数组
     * @param start 起始位置
     * @param end   结束位置（包含）
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            // 如果起始位置大于等于结束位置，则说明数组已经有序
            return;
        }
        // 选择基准，并将小于基准的元素放在基准左边，大于基准的元素放在基准右边
        int pivot = partition(arr, start, end);
        // 对左半部分进行递归排序
        quickSort(arr, start, pivot - 1);
        // 对右半部分进行递归排序
        quickSort(arr, pivot + 1, end);
    }

    /**
     * 划分函数，选择数组中的一个元素作为基准，然后将小于基准的元素放在基准左边，大于基准的元素放在基准右边。
     *
     * @param arr   待排序的数组
     * @param start 起始位置
     * @param end   结束位置（包含）
     * @return 基准的位置
     */
    private static int partition(int[] arr, int start, int end) {
        // 选择起始位置的元素作为基准
        int pivot = arr[start];
        // 左指针
        int left = start + 1;
        // 右指针
        int right = end;
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                // 移动左指针，直到找到第一个大于等于基准的元素
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                // 移动右指针，直到找到第一个小于等于基准的元素
                right--;
            }
            if (left <= right) {
                // 如果左指针仍然小于等于右指针，则交换左右指针指向的元素
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                // 移动左指针
                left++;
                // 移动右指针
                right--;
            }
        }
        // 将基准放到正确的位置上
        int temp = arr[start];
        arr[start] = arr[right];
        arr[right] = temp;
        return right;
    }
}
