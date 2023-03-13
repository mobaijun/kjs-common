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
 * class name: HeapSort<br>
 * class description: 堆排序算法
 * <p>
 * 堆排序是一种基于完全二叉树结构的排序算法，基本思路是将待排序的数组构造成一个二叉堆，并将堆顶元素与堆尾元素进行交换，然后调整剩余的元素，
 * 使得它们重新满足堆的性质，再将堆顶元素与当前堆尾的前一个元素进行交换，重复执行该操作直到整个数组有序。
 * <p>
 * 堆排序的实现基于二叉堆，二叉堆是一种完全二叉树，满足每个节点都比它的子节点大或小，即大根堆或小根堆。堆排序的过程可以分为两个步骤：
 * <p>
 * 1.建立堆：将无序数组构造成一个堆，可以通过从最后一个非叶子节点开始向上遍历，对于每个节点执行下沉操作，使得它满足堆的性质，遍历完所有节点后，整个数组就成为了一个堆。
 * <p>
 * 2.排序：每次将堆顶元素与堆尾元素交换，然后对剩余的元素进行堆化，重复执行该操作直到整个数组有序。
 * <p>
 * 堆排序的时间复杂度为O(nlogn)，空间复杂度为O(1)，它不仅适用于静态数据，还适用于动态数据，因为它可以在任意时刻动态添加或删除元素，并且可以保持堆的性质。
 * </P>
 *
 * @author MoBaiJun 2023/2/20 8:16
 */
public final class HeapSort {

    /**
     * 对数组进行堆排序
     * <img src="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015231308699-356134237.gif"/>
     *
     * @param arr 待排序数组
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 建立最大堆
        buildMaxHeap(arr);
        // 排序
        int n = arr.length;
        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    /**
     * 建立最大堆
     *
     * @param arr 待建堆数组
     */
    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    /**
     * 调整堆
     *
     * @param arr 待调整数组
     * @param i   待调整节点下标
     * @param n   数组长度
     */
    private static void heapify(int[] arr, int i, int n) {
        // 最大元素下标
        int largest = i;
        // 左子节点下标
        int left = 2 * i + 1;
        // 右子节点下标
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, n);
        }
    }

    /**
     * 交换数组中的两个元素
     *
     * @param arr 待交换数组
     * @param i   下标1
     * @param j   下标2
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
