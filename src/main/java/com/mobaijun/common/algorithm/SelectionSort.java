package com.mobaijun.common.algorithm;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: SelectionSort<br>
 * class description: 选择排序算法<p>
 * 选择排序算法是一种简单的排序算法，其思想是每次从未排序的序列中选出最小的元素，将其放到已排序的序列的末尾。
 * 重复此过程，直到整个序列都有序。
 * <p>
 * 以下是选择排序算法的实现过程：<br/>
 * 1.从未排序的序列中找到最小的元素，记录其下标为minIndex；<br/>
 * 2.将未排序序列中的第一个元素与minIndex处的元素交换；<br/>
 * 3.将已排序序列的末尾指针向后移动一位；<br/>
 * 4.重复步骤1-3，直到所有元素都被排序。<br/>
 *
 * @author MoBaiJun 2023/2/19 23:01
 */
public final class SelectionSort {

    /**
     * 1.原始算法
     * 在这个实现中，我们使用两个嵌套的循环来遍历序列中的元素。
     * 外部循环控制已排序序列的末尾指针，内部循环用于查找未排序序列中的最小元素，并将其交换到已排序序列的末尾。
     * <p>
     * 选择排序算法的时间复杂度为O(n^2)，与冒泡排序算法相同，但是其常数项较小，因此在某些情况下会比冒泡排序更快。
     * <img src="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif"/>
     *
     * @param arr 待排序的数组
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    /**
     * 2.减少交换次数
     * 每次找到最小元素后，直接将其记录下来，而不是立即进行交换，最后再将最小元素交换到相应位置。这样可以减少交换的次数。
     *
     * @param arr 待排序的数组
     */
    public static void selectionSortImproved(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * 3.减少比较次数
     * 在内层循环中，可以同时找到最小值和最大值，将它们一起记录下来。这样可以减少比较的次数。
     *
     * @param arr 待排序的数组
     */
    public static void selectionSortWithTwoPointers(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int minIndex = i;
            int maxIndex = i;
            for (int j = i + 1; j < n - i; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                } else if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            if (maxIndex != n - i - 1) {
                int temp = arr[n - i - 1];
                arr[n - i - 1] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
}
