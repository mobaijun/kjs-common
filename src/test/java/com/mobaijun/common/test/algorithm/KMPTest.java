package com.mobaijun.common.test.algorithm;

import com.mobaijun.common.algorithm.KMP;
import com.mobaijun.common.test.algorithm.constant.Constant;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: KMPTest<br>
 * class description:
 *
 * @author MoBaiJun 2023/3/13 20:07
 */
public class KMPTest {

    @Test
    public void kmp() {
        // 记录程序开始时间
        long startTime = System.currentTimeMillis();
        String constantString = Constant.CONSTANT_STRING;
        PrintUtil.println(constantString);
        int a = KMP.kmp(constantString, "a");
        PrintUtil.println(a);
        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 计算程序执行时间（秒）
        long durationInSeconds = (endTime - startTime) / 1000;
        System.out.println("程序执行时间：" + durationInSeconds + " 秒");
    }
}