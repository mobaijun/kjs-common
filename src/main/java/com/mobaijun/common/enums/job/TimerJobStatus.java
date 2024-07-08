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
package com.mobaijun.common.enums.job;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: TimerJobStatus<br>
 * enum description： 定时任务状态
 *
 * @author MoBaiJun 2022/5/12 13:43
 */
@Getter
@AllArgsConstructor
public enum TimerJobStatus {

    /**
     * 启动状态
     */
    RUNNING(1),

    /**
     * 停止状态
     */
    STOP(2);

    /**
     * 状态码
     */
    private final Integer code;
}