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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 封装了对 Map 中值列表的操作，提供流式处理的能力。
 *
 * @param <K> 键的类型
 * @param <V> 值的类型（列表中的元素类型）
 */
public final class MapListStream<K, V> {

    /**
     * 封装了 Map 中值列表的 Map。
     */
    private final Map<K, List<V>> map;

    /**
     * 构造方法，初始化 MapListStream。
     *
     * @param map 键和值为列表的 Map
     */
    public MapListStream(Map<K, List<V>> map) {
        this.map = map;
    }

    /**
     * 将当前的 {@link MapListStream} 转换为 {@link Map}。
     *
     * @return 当前的 {@link Map} 实例
     */
    public Map<K, List<V>> toMap() {
        return map;
    }

    /**
     * 根据键获取对应的值列表。如果 Map 中不包含该键，返回一个空列表。
     *
     * @param key 键
     * @return 与键对应的值列表，如果不存在，则返回一个空列表
     */
    public List<V> getValues(K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return new ArrayList<>();
    }

    /**
     * 将 Map 中每个键的值列表转换为流式操作的结果，并返回一个新的 {@link MapStream}。
     *
     * @param <R>  转换后的结果类型
     * @param func 转换操作，接受一个 {@link ListStream} 并返回一个结果
     * @return 一个新的 {@link MapStream}，其中包含转换后的键和值
     */
    public <R> MapStream<K, R> valueStream(Function<ListStream<V>, R> func) {
        final Map<K, R> newMap = new LinkedHashMap<>();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            final K key = entry.getKey();
            final List<V> values = entry.getValue();
            newMap.put(key, func.apply(new ListStream<>(values)));
        }
        return new MapStream<>(newMap);
    }
}