package com.mobaijun.common.algorithm;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: MergeSort<br>
 * class description: 归并排序
 * <p/>
 * 归并排序是一种分治算法，其原理是将一个待排序的数组（或链表）分成两个子数组（或子链表），然后分别对子数组进行递归排序，最后将两个有序的子数组合并成一个有序的数组。
 * 具体地，归并排序的实现可以分为以下几个步骤：
 * <p>
 * 1.分解：将待排序的数组分成两个子数组，即将数组从中间位置分成左右两部分。可以使用递归实现，不断地将子数组进行分解，直到每个子数组只有一个元素。
 * <p>
 * 2.合并：将两个有序的子数组合并成一个有序的数组。可以使用双指针法实现，将左右两个子数组的第一个元素进行比较，将较小的元素放入合并后的数组中，
 * 同时移动指针，直到其中一个子数组的元素全部放入合并后的数组中，然后将另一个子数组的剩余元素放入合并后的数组中。
 * <p>
 * 3.返回：将所有子数组的合并结果返回即可。
 * <p>
 * 归并排序的时间复杂度为 O(nlogn)，其中 n 表示待排序的数组长度，空间复杂度为 O(n)。相比于快速排序，归并排序的优点在于其稳定性和适用于链表等数据结构。
 *
 * @author MoBaiJun 2023/2/20 0:11
 */
public final class MergeSort {

    /**
     * 对数组 arr 进行归并排序
     * <img src="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015230557043-37375010.gif"/>
     *
     * @param arr 待排序的数组
     */
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        // 临时数组
        int[] temp = new int[n];
        // 调用归并排序辅助函数
        mergeSortHelper(arr, 0, n - 1, temp);
    }

    /**
     * 归并排序辅助函数，对数组 arr 在区间 [l, r] 中进行排序
     *
     * @param arr  待排序的数组
     * @param l    左区间的起始下标
     * @param r    右区间的结束下标
     * @param temp 临时数组
     */
    private static void mergeSortHelper(int[] arr, int l, int r, int[] temp) {
        if (l < r) {
            // 计算中间位置
            int mid = l + (r - l) / 2;
            // 对左半边数组进行归并排序
            mergeSortHelper(arr, l, mid, temp);
            // 对右半边数组进行归并排序
            mergeSortHelper(arr, mid + 1, r, temp);
            // 将两个有序的子数组进行归并
            merge(arr, l, mid, r, temp);
        }
    }

    /**
     * 归并函数，将两个有序的子数组 arr[l...mid] 和 arr[mid+1...r] 归并为一个有序的数组
     *
     * @param arr 待归并的数组
     * @param l   左子数组的起始下标
     * @param mid 左子数组的结束下标
     * @param r   右子数组的结束下标
     * @param tmp 临时数组
     */
    private static void merge(int[] arr, int l, int mid, int r, int[] tmp) {
        // 左子数组的起始下标
        int i = l;
        // 右子数组的起始下标
        int j = mid + 1;
        // 临时数组的下标
        int k = l;
        // 比较左右子数组的元素，将较小的元素放入临时数组
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        // 将左子数组中剩余的元素放入临时数组
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        // 将右子数组中剩余的元素放入临时数组
        while (j <= r) {
            tmp[k++] = arr[j++];
        }
        // 将临时数组中排好序的元素复制回原数组
        System.arraycopy(tmp, l, arr, l, r - l + 1);
    }
}
