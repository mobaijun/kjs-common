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
package com.mobaijun.common.util.collection;

import com.mobaijun.common.model.Model;
import com.mobaijun.common.util.converter.EntityUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        return getCollection(source, Arrays.asList(keys));
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
        List<V> result = CollectionUtil.newArrayList();
        if (source != null && !source.isEmpty() && keys != null) {
            keys.forEach(key -> Optional.ofNullable(source.get(key)).ifPresent(result::add));
        }
        return result;
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
        Objects.requireNonNull(comparator);
        List<V> result = getCollection(source, keys);
        result.sort(comparator);
        return result;
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
     * 讲Map中 value进行转换
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
        Map<K, T> hashMap = CollectionUtil.newHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), EntityUtil.toObj(entry.getValue(), valueAction));
        }
        return hashMap;
    }


    /**
     * <p>从{@code Map}实例中取值 防止因{@code Map}实例为<code>null</code>而发生运行时空指针异常</p>
     * <p>如果{@code Map}实例为<code>null</code>，则返回<code>null</code></p>
     *
     * @param map {@code Map}实例 允许为<code>null</code>
     * @param key Key的值 允许为<code>null</code>
     * @param <K> Key的类型
     * @param <V> Value的类型
     * @return 从{@code Map}实例通过Key取出的Value值
     */
    public static <K, V> V getObj(Map<K, V> map, K key) {
        return getObj(map, key, null);
    }

    /**
     * <p>从{@code Map}实例中取值 防止因{@code Map}实例为<code>null</code>而发生运行时空指针异常</p>
     *
     * @param map          {@code Map}实例 允许为<code>null</code>
     * @param key          Key的值 允许为<code>null</code>
     * @param defaultValue 默认值 允许为<code>null</code>
     * @param <K>          Key的类型
     * @param <V>          Value的类型
     * @return 从{@code Map}实例通过Key取出的Value值
     */
    public static <K, V> V getObj(Map<K, V> map, K key, V defaultValue) {
        return Optional.ofNullable(map).map(e -> e.get(key)).orElse(defaultValue);
    }
}