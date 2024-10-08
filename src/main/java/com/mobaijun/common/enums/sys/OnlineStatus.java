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
package com.mobaijun.common.enums.sys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: OnlineStatus<br>
 * enum description： 用户状态
 *
 * @author MoBaiJun 2022/5/12 9:19
 */
@Getter
@RequiredArgsConstructor
public enum OnlineStatus {

    /**
     * 在线
     */
    ON_LINE("在线"),

    /**
     * 离线
     */
    OFF_LINE("离线");

    /**
     * 用户状态
     */
    private final String info;
}