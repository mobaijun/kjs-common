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
 * class name: BubbleSort<br>
 * class description: 冒泡排序<br>
 * 冒泡排序是一种简单的排序算法。<br>
 * 1.它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。<br>
 * 2.走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。<br>
 * 3.这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。<br>
 *
 * @author MoBaiJun 2022/12/7 10:29
 */
public final class BubbleSort {

    /**
     * 冒泡排序<br>
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；<br>
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；<br>
     * 针对所有的元素重复以上的步骤，除了最后一个；<br>
     * 重复步骤1~3，直到排序完成。<br>
     * <img src="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015223238449-2146169197.gif"/>
     *
     * @param array 数组
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 1.对于已经排好序的部分，不需要再比较和交换。可以加入一个标志位来表示是否有交换操作，如果没有则直接返回，优化排序时间。
     * 2.可以在每一轮排序中记录最后一次交换的位置，因为该位置之后的数据已经有序了，下一轮排序时可以不必再次比较。
     *
     * @param array 数组
     * @return 排序后的数组
     */
    public static int[] bubbleSortWithOptimization(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            boolean hasSwap = false;
            int lastSwapIndex = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    hasSwap = true;
                    lastSwapIndex = j;
                }
            }
            if (!hasSwap) {
                // 没有发生交换，说明已经有序，直接返回
                return array;
            }
            i = array.length - 2 - lastSwapIndex;
        }
        return array;
    }
}