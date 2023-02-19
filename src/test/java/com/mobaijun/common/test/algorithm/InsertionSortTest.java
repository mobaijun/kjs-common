package com.mobaijun.common.test.algorithm;

import com.mobaijun.common.algorithm.InsertionSort;
import com.mobaijun.common.test.algorithm.constant.Constant;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: InsertionSortTest
 * class description: 插入排序测试
 *
 * @author MoBaiJun 2023/2/19 23:09
 */
public class InsertionSortTest {

    @Test
    public void insertionSortTest1() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 创建随机数组并执行排序
        InsertionSort.insertionSort(Constant.RANDOM_INT_ARRAY);
        PrintUtil.print("排序后---------------------------------");
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }

    @Test
    public void insertionSortTest2() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 创建随机数组并执行排序
        InsertionSort.insertionSortOptimized(Constant.RANDOM_INT_ARRAY);
        PrintUtil.print("排序后---------------------------------");
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }
}
