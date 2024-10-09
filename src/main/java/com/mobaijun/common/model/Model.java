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
package com.mobaijun.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: Model
 * class description: 用户存储 K、V 结构的 Model 实体类
 *
 * @author MoBaiJun 2022/12/10 17:12
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Model", description = "用户存储 K、V 结构的 Model 实体类")
public class Model<K, V> extends HashMap<K, V> {

    /**
     * 键
     */
    @Schema(title = "键", description = "键")
    private K key;

    /**
     * 值
     */
    @Schema(title = "值", description = "值")
    private V value;
}