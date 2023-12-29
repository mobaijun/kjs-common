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

import com.mobaijun.common.assertions.Assert;
import com.mobaijun.common.model.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: MapUtil
 * class description: map 工具类
 *
 * @author MoBaiJun 2022/12/10 17:29
 */
public class MapUtil {

    /**
     * 批量获取 Map 中的值
     *
     * @param source Map 实例
     * @param keys   键的集合
     * @param <K>    键的泛型
     * @param <V>    值的泛型
     * @return 值的泛型的集合
     */
    @SafeVarargs
    public static <K, V> List<V> getValues(Map<K, V> source, K... keys) {
        Objects.requireNonNull(keys);
        return Arrays.stream(keys)
                .map(source::get)
                .collect(Collectors.toList());
    }

    /**
     * 批量获取 Map 中的值
     *
     * @param source Map 实例
     * @param keys   键的集合
     * @param <K>    键的泛型
     * @param <V>    值的泛型
     * @return 值的泛型的集合
     */
    public static <K, V> List<V> getValues(Map<K, V> source, Iterable<K> keys) {
        if (source == null || source.isEmpty() || keys == null) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(keys.spliterator(), false)
                .map(source::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * 批量获取 Map 中的值，并根据比较器排序
     *
     * @param source     Map 实例
     * @param keys       键的集合
     * @param comparator 排序器
     * @param <K>        键的泛型
     * @param <V>        值的泛型
     * @return 值的泛型的集合
     */
    public static <K, V> List<V> getValues(Map<K, V> source, Iterable<K> keys, Comparator<V> comparator) {
        Objects.requireNonNull(source, "source map cannot be null");
        Objects.requireNonNull(keys, "keys iterable cannot be null");
        Objects.requireNonNull(comparator, "comparator cannot be null");
        return StreamSupport.stream(keys.spliterator(), false)
                .map(source::get)
                .filter(Objects::nonNull)
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    /**
     * 将 Map 转换成 List
     *
     * @param source 原始 Map 实例
     * @param <K>    Key 类型
     * @param <V>    Value 类型
     * @return 返回 Model 类型集合
     */
    public static <K, V> List<Model<K, V>> mapToList(Map<K, V> source) {
        Objects.requireNonNull(source);
        return source.entrySet().stream()
                .map(e -> new Model<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * 将 Map 转换成 List，并根据比较器排序
     *
     * @param source 原始 Map 实例
     * @param <K>    Key 类型
     * @param <V>    Value 类型
     * @return 返回 Model 类型集合
     */
    public static <K, V> List<Model<K, V>> mapToList(Map<K, V> source, Comparator<Model<K, V>> comparator) {
        Objects.requireNonNull(source);
        List<Model<K, V>> list = source.entrySet().stream()
                .map(e -> new Model<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        if (comparator != null) {
            list.sort(comparator);
        }
        return list;
    }

    /**
     * 从给定的 Map 实例中获取指定 key 的值，如果 Map 为 null 或 key 不存在则返回默认值。
     *
     * @param map          给定的 Map 实例，允许为 null
     * @param key          要获取的 key，允许为 null
     * @param defaultValue 默认值，如果 Map 为 null 或 key 不存在则返回该值，允许为 null
     * @param <K>          key 的类型
     * @param <V>          value 的类型
     * @return Map 中指定 key 的 value，如果 Map 为 null 或 key 不存在则返回默认值
     */
    public static <K, V> V getOrDefault(Map<K, V> map, K key, V defaultValue) {
        return Optional.ofNullable(map).map(e -> e.getOrDefault(key, defaultValue)).orElse(defaultValue);
    }

    /**
     * 将 Map 转成 String，可以指定分隔符
     *
     * @param map       Map
     * @param delimiter 分隔符
     * @return 转换后的字符串
     */
    public static <K, V> String mapToString(Map<K, V> map, String delimiter) {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(delimiter));
    }

    /**
     * 将keyValues转成Map
     *
     * @param keyClass   键的类型
     * @param valueClass 值的类型
     * @param keyValues  键值对数组
     * @param <K>        键类型
     * @param <V>        值类型
     * @return 转换后的Map
     */
    public static <K, V> Map<K, V> build(Class<K> keyClass, Class<V> valueClass, Object... keyValues) {
        Assert.assertTrue(keyValues.length % 2 == 0, "键值对数量必须是偶数");

        if (keyValues.length == 0) {
            return Map.of();
        }

        Map<K, V> result = new HashMap<>();

        for (int i = 0; i < keyValues.length; i += 2) {
            K key = keyClass.cast(keyValues[i]);
            V value = valueClass.cast(keyValues[i + 1]);
            result.put(key, value);
        }

        return result;
    }

    /**
     * 在原Map添加keyValues
     *
     * @param <K>       键类型
     * @param <V>       值类型
     * @param originMap 原始 Map
     * @param keyType   键的类型
     * @param valueType 值的类型
     * @param keyValues 键值对数组
     */
    public static <K, V> void add(Map<K, V> originMap, Class<K> keyType, Class<V> valueType, Object... keyValues) {
        if (originMap == null || originMap.isEmpty()) {
            return;
        }

        if (keyValues.length % 2 != 0) {
            throw new IllegalArgumentException("键值对数量必须是偶数");
        }

        for (int i = 0; i < keyValues.length; i += 2) {
            K key = keyType.cast(keyValues[i]);
            V value = valueType.cast(keyValues[i + 1]);
            originMap.put(key, value);
        }
    }

    /**
     * 在原Map添加键值对集合
     *
     * @param <K>         键类型
     * @param <V>         值类型
     * @param originMap   原始 Map
     * @param keyType     键的类型
     * @param valueType   值的类型
     * @param keyValueMap 键值对集合
     */
    public static <K, V> void add(Map<K, V> originMap, Class<K> keyType, Class<V> valueType, Map<? extends K, ? extends V> keyValueMap) {
        if (originMap == null || originMap.isEmpty() || keyValueMap == null || keyValueMap.isEmpty()) {
            return;
        }

        originMap.putAll(keyValueMap);
    }
}