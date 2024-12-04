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
package com.mobaijun.common.enums.comm;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: StreamUtils<br>
 * 类描述： 排序方向和空值位置的枚举类。<br>
 * <p>此枚举用于指定排序时的方向和空值（null）的位置。</p>
 *
 * @author MoBaiJun 2022/4/24 11:27
 */
public enum Sort {

    /**
     * 升序排序。
     */
    Asc,

    /**
     * 降序排序。
     */
    Desc,

    /**
     * 排序时，将空值排在前面。
     */
    NullFirst,

    /**
     * 排序时，将空值排在最后。
     */
    NullLast
}
