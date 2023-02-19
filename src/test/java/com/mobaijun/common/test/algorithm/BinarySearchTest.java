package com.mobaijun.common.test.algorithm;

import com.mobaijun.common.algorithm.BinarySearch;
import com.mobaijun.common.algorithm.InsertionSort;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.number.RandomUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: BinarySearchTest<br>
 * class description: 二分查找算法测试
 *
 * @author MoBaiJun 2023/2/20 0:23
 */
public class BinarySearchTest {

    @Test
    public void binaySearch() {
        // 生成不可重复数组
        int[] randomArray = RandomUtil.generateRandomArrays(100, 1, 100);
        InsertionSort.insertionSort(randomArray);
        Arrays.stream(randomArray).forEach(PrintUtil::println);
        int key = 7;
        int actualIndex = BinarySearch.binarySearch(randomArray, key);
        PrintUtil.println(actualIndex);
    }
}
