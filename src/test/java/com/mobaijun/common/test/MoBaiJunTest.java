package com.mobaijun.common.test;

import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.number.RandomUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: MoBaiJunTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 15:03
 */
public class MoBaiJunTest {

    public static final int[] chars = RandomUtil.generateRandomArray(10000000, 1, 1000000);

    @Test
    public void foreachTest() {
        long start = System.currentTimeMillis();
        for (int i : chars) {
            System.out.println("i = " + i);
        }
        long end = System.currentTimeMillis();
        PrintUtil.println((end - start) / 1000);
    }


    @Test
    public void streamTest() {
        long start = System.currentTimeMillis();
        Arrays.stream(chars).forEach(System.out::println);
        long end = System.currentTimeMillis();
        PrintUtil.println((end - start) / 1000);
    }
}
