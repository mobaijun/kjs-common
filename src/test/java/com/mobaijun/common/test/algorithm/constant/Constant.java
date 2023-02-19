package com.mobaijun.common.test.algorithm.constant;

import com.mobaijun.common.util.number.RandomUtil;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: Constant<br>
 * class description: 通用常量
 *
 * @author MoBaiJun 2023/2/20 0:17
 */
public final class Constant {

    /**
     * 通用随机数
     */
    public static final int[] RANDOM_INT_ARRAY = RandomUtil.generateRandomArray(100000, 1, 100000);
}
