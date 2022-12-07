/*
 * Copyright (C) 2022 www.mobaijun.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.common.util.system;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: Arity<br>
 * class description： 内存算法<br>
 *
 * @author MoBaiJun 2022/5/11 14:54
 */
public class Arity {
    /**
     * 默認除法運算精度
     */
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 這個類不能實例化
     */
    private Arity() {
    }

    /**
     * 提供精確的加法運算。
     *
     * @param v1 被加數
     * @param v2 加數
     * @return 兩個參數的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精確的減法運算。
     *
     * @param v1 被減數
     * @param v2 減數
     * @return 兩個參數的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精確的乘法運算。
     *
     * @param v1 被乘數
     * @param v2 乘數
     * @return 兩個參數的積
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相對）精確的除法運算，當發生除不盡的情況時，精確到 小數點以後10位元，以後的數字四捨五入。
     *
     * @param v1 被除數
     * @param v2 除數
     * @return 兩個參數的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相對）精確的除法運算。當發生除不盡的情況時，由scale參數指 定精度，以後的數字四捨五入。
     *
     * @param v1    被除數
     * @param v2    除數
     * @param scale 表示表示需要精確到小數點以後幾位。
     * @return 兩個參數的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 提供精確的小數位四捨五入處理。
     *
     * @param v     需要四捨五入的數位
     * @param scale 小數點後保留幾位
     * @return 四捨五入後的結果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, RoundingMode.HALF_UP).doubleValue();
    }
}