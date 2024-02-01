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
package com.mobaijun.common.date;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: DateFormat<br>
 * class description: 日期格式化
 *
 * @author MoBaiJun 2022/11/23 13:45
 */
public final class DateFormat {

    /**
     * YYYY_MM_DD_HH_MM_SS
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern(DatePattern.YYYY_MM_DD_HH_MM_SS);

    /**
     * YYYY_MM_DD
     */
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern(DatePattern.YYYY_MM_DD);

    /**
     * HH_MM_SS
     */
    public static final DateTimeFormatter HH_MM_SS = DateTimeFormatter.ofPattern(DatePattern.HH_MM_SS);

    /**
     * MM_US
     */
    public static final DateTimeFormatter MM_US = DateTimeFormatter.ofPattern("MM", Locale.US);

    /**
     * MMM_US
     */
    public static final DateTimeFormatter MMM_US = DateTimeFormatter.ofPattern("MMM", Locale.US);

    /**
     * MMMM_US
     */
    public static final DateTimeFormatter MMMM_US = DateTimeFormatter.ofPattern("MMMM", Locale.US);

    /**
     * MM_ZH_CN
     */
    public static final DateTimeFormatter MM_ZH_CN = DateTimeFormatter.ofPattern("MM", Locale.SIMPLIFIED_CHINESE);

    /**
     * MMM_ZH_CN
     */
    public static final DateTimeFormatter MMM_ZH_CN = DateTimeFormatter.ofPattern("MMM", Locale.SIMPLIFIED_CHINESE);

    /**
     * MMMM_ZH_CN
     */
    public static final DateTimeFormatter MMMM_ZH_CN = DateTimeFormatter.ofPattern("MMMM", Locale.SIMPLIFIED_CHINESE);

    /**
     * MM_ZH_TW
     */
    public static final DateTimeFormatter MM_ZH_TW = DateTimeFormatter.ofPattern("MM", Locale.TRADITIONAL_CHINESE);

    /**
     * MMM_ZH_TW
     */
    public static final DateTimeFormatter MMM_ZH_TW = DateTimeFormatter.ofPattern("MMM", Locale.TRADITIONAL_CHINESE);

    /**
     * MMMM_ZH_TW
     */
    public static final DateTimeFormatter MMMM_ZH_TW = DateTimeFormatter.ofPattern("MMMM", Locale.TRADITIONAL_CHINESE);
}
