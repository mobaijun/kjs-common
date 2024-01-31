/*
 * Copyright (C) 2022 [www.mobaijun.com]
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

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: StartCalcUtil<br>
 * class description：项目启动时间管理工具类。<br>
 *
 * @author MoBaiJun 2022/5/12 14:05
 */
public class StartCalcUtil {

    /**
     * 项目的启动时间。
     */
    private static LocalDateTime projectStartTime = null;

    /**
     * 初始化项目的启动时间。
     *
     * @param startDateTime 项目的开始日期和时间。
     */
    public static void initializeProjectStartTime(LocalDateTime startDateTime) {
        projectStartTime = startDateTime;
    }

    /**
     * 检查项目是否已启动。
     *
     * @param currentDateTime      当前的日期和时间。
     * @param startIntervalSeconds 用于判定项目已启动的时间间隔，以秒为单位。
     * @return 如果项目已启动，则返回true；否则返回false。
     */
    public static boolean hasStarted(LocalDateTime currentDateTime, long startIntervalSeconds) {
        if (projectStartTime == null || currentDateTime == null) {
            throw new IllegalArgumentException("项目启动时间和当前时间不能为null");
        }

        LocalDateTime currentProjectTime = getCurrentTime();
        long elapsedSeconds = ChronoUnit.SECONDS.between(projectStartTime, currentProjectTime);
        return elapsedSeconds >= startIntervalSeconds;
    }

    /**
     * 获取当前时间。
     *
     * @return 当前时间。
     */
    private static LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}