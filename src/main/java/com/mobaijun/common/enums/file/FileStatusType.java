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
package com.mobaijun.common.enums.file;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: FileStatusType<br>
 * enum description：文件状态
 *
 * @author MoBaiJun 2022/5/12 13:19
 */
@Getter
@AllArgsConstructor
public enum FileStatusType {

    /**
     * 新文件
     * <br>
     * 如果code相同，每次版本号替换都会把当前文件设置成最新文件
     */
    NEW("1"),

    /**
     * 旧文件
     */
    OLD("0");

    /**
     * 文件状态code
     */
    private final String code;
}