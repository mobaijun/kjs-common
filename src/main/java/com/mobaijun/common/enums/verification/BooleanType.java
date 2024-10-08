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
package com.mobaijun.common.enums.verification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: BooleanType<br>
 * description: BooleanType 枚举类型
 *
 * @author 2022/5/21 16:56 url:<a href="https://www.mobaijun.com">...</a>
 */
@Getter
@RequiredArgsConstructor
public enum BooleanType {

    /**
     * 否
     */
    FALSE(0),

    /**
     * 是
     */
    TRUE(1);

    /**
     * 枚举值
     */
    private final int code;
}