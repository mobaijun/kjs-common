package com.mobaijun.common.algorithm;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: BubbleSort<br>
 * class description: 冒泡排序<br>
 * 冒泡排序是一种简单的排序算法。<br>
 * 它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。<br>
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。<br>
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。<br>
 *
 * @author MoBaiJun 2022/12/7 10:29
 */
public class BubbleSort {

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
}
