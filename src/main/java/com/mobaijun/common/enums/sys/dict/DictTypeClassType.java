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
package com.mobaijun.common.enums.sys.dict;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: DictTypeClassType<br>
 * enum description：字典类型的分类枚举
 *
 * @author MoBaiJun 2022/5/12 14:06
 */
@Getter
@AllArgsConstructor
public enum DictTypeClassType {

    /**
     * 业务类型
     */
    BUSINESS_TYPE(1),

    /**
     * 系统类型
     */
    SYSTEM_TYPE(2),

    /**
     * 调度类型
     */
    SCHEDULING_TYPE(3),

    /**
     * 异常类型
     */
    EXCEPTION_TYPE(4),

    /**
     * 暴露的api类型
     */
    EXPOSED_API_TYPE(5),

    /**
     * 第三方组件类型
     */
    THIRD_PARTY_COMPONENT_TYPE(6);

    /**
     * 编码
     */
    private final Integer code;
}