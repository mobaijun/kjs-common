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
package com.mobaijun.common.enums;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: YesOrNotEnum
 * enum description：是或否的枚举，一般用在数据库字段，例如del_flag字段，char(1)，填写Y或N
 *
 * @author MoBaiJun 2022/5/12 11:23
 */
@Getter
public enum YesOrNotEnum {
    /**
     * 是
     */
    Y("Y", "是"),

    /**
     * 否
     */
    N("N", "否");

    public final String code;

    public final String message;

    YesOrNotEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}