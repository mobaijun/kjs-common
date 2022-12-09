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
package com.mobaijun.common.util.time;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: TimeUtils<br>
 * 类描述： 时间工具类<br>
 *
 * @author MoBaiJun 2022/4/24 11:23
 */
public class TimeUtil {

    /**
     * @return 当前毫秒数
     */
    public static long nowMs() {
        return System.currentTimeMillis();
    }

    /**
     * 当前毫秒与起始毫秒差
     *
     * @param startMillis 开始纳秒数
     * @return 时间差
     */
    public static long diffMs(long startMillis) {
        return diffMs(startMillis, nowMs());
    }

    /**
     * 计算两个毫秒时间差
     *
     * @param startMillis 开始豪秒数
     * @param endMillis   结束毫秒数
     * @return 时间差
     */
    public static long diffMs(long startMillis, long endMillis) {
        return endMillis - startMillis;
    }

    /**
     * @return 当前纳秒数
     */
    public static long nowNano() {
        return System.nanoTime();
    }

    /**
     * 当前纳秒与开始纳秒差
     *
     * @param startNano 开始纳秒数
     * @return 时间差
     */
    public static long diffNano(long startNano) {
        return diffNano(startNano, nowNano());
    }

    /**
     * 计算两个纳秒时间差
     *
     * @param startNano 开始纳秒数
     * @param endNano   结束纳秒数
     * @return 时间差
     */
    public static long diffNano(long startNano, long endNano) {
        return endNano - startNano;
    }
}