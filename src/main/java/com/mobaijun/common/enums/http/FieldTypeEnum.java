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
package com.mobaijun.common.enums.http;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: FieldTypeEnum
 * enum description：解析字段元数据时，各种情况的枚举
 *
 * @author MoBaiJun 2022/5/12 13:27
 */
@Getter
public enum FieldTypeEnum {
    /**
     * 基本类型，描述java中的int、long、Integer、String、Double、BigDecimal等
     */
    BASIC(1),

    /**
     * 基础数组类型，描述java中的数组，例如long[]
     */
    BASE_ARRAY(2),

    /**
     * 实体类型的数组（需要解析其中具体字段），例如SysUser[]
     */
    ARRAY_WITH_OBJECT(3),

    /**
     * 基础集合类型，Collection等，单纯的集合，没带泛型，不需要再解析实体，例如List
     */
    BASE_COLLECTION(4),

    /**
     * 集合类型，Collection携带泛型的，需要具体解析泛型中实体的，例如List String
     */
    COLLECTION_WITH_OBJECT(5),

    /**
     * 单纯对象类型，不带泛型，例如SysUser
     */
    OBJECT(6),

    /**
     * 对象类型携带泛型的，需要再解析泛型中的实体，例如pojo
     */
    OBJECT_WITH_GENERIC(7),

    /**
     * 带T类型的泛型对象，需要从所属类上拿到具体泛型，例如字段pojo，List
     */
    WITH_UNKNOWN_GENERIC(8),

    /**
     * 其他类型，未知
     */
    OTHER(9);

    FieldTypeEnum(Integer code) {
        this.code = code;
    }

    private final Integer code;
}