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
package com.mobaijun.common.minitable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: Row<br>
 * class description: 表格每行的类型和数据的实体类<br>
 *
 * @author MoBaiJun 2022/12/29 9:28
 */
@Getter
@Setter
@ToString
public class Row {

    /**
     * 行类型.
     */
    private RowType rowType;

    /**
     * 行数据.
     */
    private List<String> data;

    /**
     * 构造方法.
     *
     * @param rowType 行类型
     * @param data    行数据集
     */
    Row(RowType rowType, List<String> data) {
        this.rowType = rowType;
        this.data = data;
    }
}
