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
package com.mobaijun.common.util.base;

import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: BaseWrapper
 * interface description：基础包装接口
 *
 * @author MoBaiJun 2022/5/12 14:02
 */
public interface BaseWrapper<T> {

    /**
     * 具体包装的过程
     *
     * @param beWrappedModel 被包装的原始对象，可以是obj，list，page，PageResult
     * @return 包装后增加的增量集合
     */
    <K, V> Map<K, V> doWrap(T beWrappedModel);
}