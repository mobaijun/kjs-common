/*
 * Copyright (C) 2022 [mobaijun]
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

/**
 * Description: [根据 code 获取名称接口]
 * Author: [mobaijun]
 * Date: [2024/1/24 9:54]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public interface CodeNameConvertible {

    /**
     * 获取 code
     *
     * @return code 值
     */
    String getCode();

    /**
     * 获取 value
     *
     * @return value 值
     */
    String getValue();
}
