package com.mobaijun.common.test.algorithm;

import com.mobaijun.common.algorithm.BubbleSort;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.number.RandomUtil;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: BubbleSortTest
 * class description: 冒泡排序测试
 *
 * @author MoBaiJun 2023/2/15 21:52
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        int[] arrays = BubbleSort.bubbleSort1(RandomUtil.generateRandomArray(100000, 1, 100000));
        // 创建随机数组并排序
        for (int i : arrays) {
            PrintUtil.println(i);
        }
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }
}
