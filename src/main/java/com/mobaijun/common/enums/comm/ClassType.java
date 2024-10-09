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

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: ClassType<br>
 * enum description: class 类型管理
 *
 * @author MoBaiJun 2023/2/22 17:51
 */
@Getter
@RequiredArgsConstructor
public enum ClassType {

    /**
     * 接口
     */
    INTERFACE(0),

    /**
     * 抽象类
     */
    ABSTRACT_CLASS(1),

    /**
     * 普通类
     */
    GENERAL_CLASS(2);

    /**
     * 下标索引
     */
    private final int index;
}
