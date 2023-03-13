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
package com.mobaijun.common.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: ListUtils<br>
 * class description: list 工具类
 *
 * @author MoBaiJun 2022/11/23 9:42
 */
public class ListUtil {

    /**
     * map 数组添加到 list
     *
     * @param map map
     * @param <K> 键
     * @param <V> 值
     * @return list 集合
     */
    @SafeVarargs
    public static <K, V> List<Map<K, V>> mapList(Map<K, V>... map) {
        List<Map<K, V>> mapList = new ArrayList<>(map.length);
        Collections.addAll(mapList, map);
        return mapList;
    }
}