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
package com.mobaijun.common.util.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: PageResult
 * class description： 分页返回结果
 *
 * @author MoBaiJun 2022/7/1 9:24
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class PageResult<T> {
    /**
     * 分页数据
     */
    protected List<T> records = Collections.emptyList();

    /**
     * 数据总量
     */
    protected Long total = 0L;

    public PageResult() {
    }

    public PageResult(long total) {
        this.total = total;
    }

    public PageResult(List<T> records, long total) {
        this.records = records;
        this.total = total;
    }
}