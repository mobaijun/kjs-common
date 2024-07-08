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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: IsMenu<br>
 * enum description： 是否是菜单
 *
 * @author MoBaiJun 2022/5/12 9:23
 */
@Getter
@AllArgsConstructor
public enum IsMenu {

    /**
     * 是
     */
    YES(1, "是"),
    /**
     * 不是菜单的是按钮
     */
    NO(0, "不是");

    /**
     * 菜单编码
     */
    private final int code;

    /**
     * 菜单描述
     */
    private final String message;
}