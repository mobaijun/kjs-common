package com.mobaijun.common.test.algorithm;

import com.mobaijun.common.algorithm.MergeSort;
import com.mobaijun.common.test.algorithm.constant.Constant;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: MergeSortTest<br>
 * class description: 归并排序算法测试
 *
 * @author MoBaiJun 2023/2/20 0:15
 */
public class MergeSortTest {

    @Test
    public void mergeSortTest() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        // 执行算法并打印
        MergeSort.mergeSort(Constant.RANDOM_INT_ARRAY);
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }
}
