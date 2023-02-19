package com.mobaijun.common.test.algorithm;

import com.mobaijun.common.algorithm.QuickSort;
import com.mobaijun.common.test.algorithm.constant.Constant;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: QuickSortTest<br>
 * class description: 快速排序测试
 *
 * @author MoBaiJun 2023/2/20 0:06
 */
public class QuickSortTest {

    @Test
    public void quickSortTest() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        // 执行算法并打印
        QuickSort.quickSort(Constant.RANDOM_INT_ARRAY, 0, Constant.RANDOM_INT_ARRAY.length - 1);
        Arrays.stream(Constant.RANDOM_INT_ARRAY).forEach(PrintUtil::println);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }
}
