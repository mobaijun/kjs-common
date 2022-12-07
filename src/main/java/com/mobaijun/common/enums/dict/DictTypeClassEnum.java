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
package com.mobaijun.common.enums.dict;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: DictTypeClassEnum<br>
 * enum description：字典类型的分类枚举
 *
 * @author MoBaiJun 2022/5/12 14:06
 */
@Getter
public enum DictTypeClassEnum {
    /**
     * 业务类型
     */
    BUSINESS_TYPE(1),

    /**
     * 系统类型
     */
    SYSTEM_TYPE(2);

    private final Integer code;

    DictTypeClassEnum(Integer code) {
        this.code = code;
    }
}