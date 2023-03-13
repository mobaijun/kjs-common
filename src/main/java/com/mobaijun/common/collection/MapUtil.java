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

import com.mobaijun.common.model.Model;
import com.mobaijun.common.util.converter.EntityUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
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
     * 批量取出Map中的值
     *
     * @param source map实例
     * @param keys   键的集合
     * @param <K>    key的泛型
     * @param <V>    value的泛型
     * @return value的泛型的集合
     */
    @SafeVarargs
    public static <K, V> List<V> getCollection(Map<K, V> source, K... keys) {
        Objects.requireNonNull(keys);
        return Arrays.stream(keys)
                .map(source::get)
                .collect(Collectors.toList());
    }

    /**
     * 批量取出Map中的值
     *
     * @param source map实例
     * @param keys   键的集合
     * @param <K>    key的泛型
     * @param <V>    value的泛型
     * @return value的泛型的集合
     */
    public static <K, V> List<V> getCollection(Map<K, V> source, Iterable<K> keys) {
        if (source == null || source.isEmpty() || keys == null) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(keys.spliterator(), false)
                .map(source::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * 批量取出Map中的值
     *
     * @param source     map实例
     * @param keys       键key集合
     * @param comparator 排序器
     * @param <K>        key的泛型
     * @param <V>        value的泛型
     * @return value的泛型的集合
     */
    public static <K, V> List<V> getCollection(Map<K, V> source, Iterable<K> keys, Comparator<V> comparator) {
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
     * 将Map转化成List
     *
     * @param source 原始Map实例
     * @param <K>    Key类型
     * @param <V>    Value类型
     * @return 返回KVModel类型集合
     */
    public static <K, V> List<Model<K, V>> mapToList(Map<K, V> source) {
        Objects.requireNonNull(source);
        return source.entrySet().stream()
                .map(e -> new Model<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * 将Map转化成List/自定义排序
     *
     * @param source 原始Map实例
     * @param <K>    Key类型
     * @param <V>    Value类型
     * @return 返回KVModel类型集合
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
     * 将 Map 中 value 进行转换
     *
     * @param map         原始Map实例
     * @param valueAction value转换的行为
     * @param <K>         Key的类型
     * @param <V>         原始value的类型
     * @param <T>         目标value类型
     * @return 转换后的Map
     */
    public static <K, V, T> Map<K, T> transMap(Map<K, V> map, Function<? super V, ? extends T> valueAction) {
        Objects.requireNonNull(map);
        Objects.requireNonNull(valueAction);
        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> EntityUtil.toObj(e.getValue(), valueAction)));
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
    public static <K, V> V getObj(Map<K, V> map, K key, V defaultValue) {
        return Optional.ofNullable(map).map(e -> e.getOrDefault(key, defaultValue)).orElse(defaultValue);
    }

    /**
     * 将Map转成String, 可以指定分隔符
     *
     * @param map       map
     * @param delimiter 分隔符
     * @return res
     */
    public static String mapToString(Map<?, ?> map, String delimiter) {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(delimiter));
    }
}