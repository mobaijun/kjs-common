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

import java.util.Map;
import java.util.function.Consumer;

/**
 * 封装对 Map 进行流式操作的能力，提供了便捷的 Map 操作方法。
 *
 * @param <K> 键的类型
 * @param <V> 值的类型
 */
public final class MapStream<K, V> {

    /**
     * 封装的 Map 对象。
     */
    private final Map<K, V> map;

    /**
     * 构造方法，初始化 MapStream 实例。
     *
     * @param map 要封装的 Map
     */
    public MapStream(Map<K, V> map) {
        this.map = map;
    }

    /**
     * 判断 Map 是否包含指定的键，并在键存在时执行给定的消费者操作。
     *
     * @param key      要查找的键
     * @param consumer 如果键存在，则执行的操作
     * @return 当前的 MapStream 实例，以支持链式调用
     */
    public MapStream<K, V> hasKey(K key, Consumer<V> consumer) {
        if (map.containsKey(key)) {
            consumer.accept(map.get(key));
        }
        return this;
    }

    /**
     * 判断 Map 是否包含指定的键，并在键存在时执行给定的消费者操作；
     * 如果键不存在，则使用默认值执行消费者操作。
     *
     * @param key          要查找的键
     * @param defaultValue 如果键不存在时使用的默认值
     * @param consumer     如果键存在或使用默认值时执行的操作
     * @return 当前的 MapStream 实例，以支持链式调用
     */
    public MapStream<K, V> hasKey(K key, V defaultValue, Consumer<V> consumer) {
        if (map.containsKey(key)) {
            consumer.accept(map.getOrDefault(key, defaultValue));
        } else {
            consumer.accept(defaultValue);
        }
        return this;
    }

    /**
     * 向 Map 中添加一个键值对。
     *
     * @param k 键
     * @param v 值
     * @return 当前的 MapStream 实例，以支持链式调用
     */
    public MapStream<K, V> put(K k, V v) {
        map.put(k, v);
        return this;
    }

    /**
     * 返回当前的 Map 实例。
     *
     * @return 当前的 Map 实例
     */
    public Map<K, V> toMap() {
        return map;
    }
}