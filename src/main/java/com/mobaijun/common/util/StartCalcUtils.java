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
package com.mobaijun.common.util;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: StartCalcUtil<br>
 * class description：开始时间的计时工具<br>
 *
 * @author MoBaiJun 2022/5/12 14:05
 */
public class StartCalcUtils {
    /**
     * 项目开始启动时间
     */
    public static Date startDate = null;

    /**
     * 初始化项目开始时间
     *
     * @param date 开始日期
     */
    public static void init(Date date) {
        startDate = date;
    }

    /**
     * 计算是否项目已经启动
     *
     * @param date                 日期
     * @param startInterValSeconds 启动时间毫秒值
     * @return true启动 false 未启动
     */
    public static boolean calcEnable(Date date, long startInterValSeconds) {
        return DateUtil.between(startDate, date, DateUnit.SECOND) > startInterValSeconds;
    }
}