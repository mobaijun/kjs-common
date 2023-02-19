package com.mobaijun.common.test.algorithm;

import com.mobaijun.common.algorithm.SelectionSort;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.number.RandomUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: SelectionSortTest
 * class description: 选择排序测试
 *
 * @author MoBaiJun 2023/2/19 23:10
 */
public class SelectionSortTest {

    private static final int[] RANDOM_INT_ARRAY = RandomUtil.generateRandomArray(100000, 1, 100000);

    @Test
    public void SelectionSortTest1() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        Arrays.stream(RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 创建随机数组并执行排序
        SelectionSort.selectionSort(RANDOM_INT_ARRAY);
        PrintUtil.print("排序后---------------------------------");
        Arrays.stream(RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }

    @Test
    public void SelectionSortTest2() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        Arrays.stream(RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 创建随机数组并执行排序
        SelectionSort.selectionSortImproved(RANDOM_INT_ARRAY);
        PrintUtil.print("排序后---------------------------------");
        Arrays.stream(RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }

    @Test
    public void SelectionSortTest3() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        Arrays.stream(RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 创建随机数组并执行排序
        SelectionSort.selectionSortWithTwoPointers(RANDOM_INT_ARRAY);
        PrintUtil.print("排序后---------------------------------");
        Arrays.stream(RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }
}
