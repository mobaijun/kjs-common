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
import com.mobaijun.common.reflect.ReflectUtil;
import com.mobaijun.common.text.StringUtil;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
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
     * 默认初始大小
     */
    public static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * 默认增长因子，当Map的size达到 容量*增长因子时，开始扩充Map
     */
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * Map是否为空
     *
     * @param map 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * Map是否为非空
     *
     * @param map 集合
     * @return 是否为非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return null != map && !map.isEmpty();
    }

    /**
     * 如果提供的集合为{@code null}，返回一个不可变的默认空集合，否则返回原集合<br>
     * 空集合使用{@link Collections#emptyMap()}
     *
     * @param <K> 键类型
     * @param <V> 值类型
     * @param set 提供的集合，可能为null
     * @return 原集合，若为null返回空集合
     */
    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> set) {
        return (null == set) ? Collections.emptyMap() : set;
    }

    /**
     * 如果给定Map为空，返回默认Map
     *
     * @param <T>        集合类型
     * @param <K>        键类型
     * @param <V>        值类型
     * @param map        Map
     * @param defaultMap 默认Map
     * @return 非空（empty）的原Map或默认Map
     */
    public static <T extends Map<K, V>, K, V> T defaultIfEmpty(T map, T defaultMap) {
        return isEmpty(map) ? defaultMap : map;
    }

    // ----------------------------------------------------------------------------------------------- new HashMap

    /**
     * 新建一个HashMap
     *
     * @param <K> Key类型
     * @param <V> Value类型
     * @return HashMap对象
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 新建一个HashMap
     *
     * @param <K>      Key类型
     * @param <V>      Value类型
     * @param size     初始大小，由于默认负载因子0.75，传入的size会实际初始大小为size / 0.75 + 1
     * @param isLinked Map的Key是否有序，有序返回 {@link java.util.LinkedHashMap}，否则返回 {@link HashMap}
     * @return HashMap对象
     */
    public static <K, V> HashMap<K, V> newHashMap(int size, boolean isLinked) {
        final int initialCapacity = (int) (size / DEFAULT_LOAD_FACTOR) + 1;
        return isLinked ? new LinkedHashMap<>(initialCapacity) : new HashMap<>(initialCapacity);
    }

    /**
     * 新建一个HashMap
     *
     * @param <K>  Key类型
     * @param <V>  Value类型
     * @param size 初始大小，由于默认负载因子0.75，传入的size会实际初始大小为size / 0.75 + 1
     * @return HashMap对象
     */
    public static <K, V> HashMap<K, V> newHashMap(int size) {
        return newHashMap(size, false);
    }

    /**
     * 新建一个HashMap
     *
     * @param <K>      Key类型
     * @param <V>      Value类型
     * @param isLinked Map的Key是否有序，有序返回 {@link LinkedHashMap}，否则返回 {@link HashMap}
     * @return HashMap对象
     */
    public static <K, V> HashMap<K, V> newHashMap(boolean isLinked) {
        return newHashMap(DEFAULT_INITIAL_CAPACITY, isLinked);
    }

    /**
     * 新建TreeMap，Key有序的Map
     *
     * @param <K>        key的类型
     * @param <V>        value的类型
     * @param comparator Key比较器
     * @return TreeMap
     */
    public static <K, V> TreeMap<K, V> newTreeMap(Comparator<? super K> comparator) {
        return new TreeMap<>(comparator);
    }

    /**
     * 新建TreeMap，Key有序的Map
     *
     * @param <K>        key的类型
     * @param <V>        value的类型
     * @param map        Map
     * @param comparator Key比较器
     * @return TreeMap
     * @since 3.2.3
     */
    public static <K, V> TreeMap<K, V> newTreeMap(Map<K, V> map, Comparator<? super K> comparator) {
        final TreeMap<K, V> treeMap = new TreeMap<>(comparator);
        if (!isEmpty(map)) {
            treeMap.putAll(map);
        }
        return treeMap;
    }

    /**
     * 创建键不重复Map
     *
     * @param <K>  key的类型
     * @param <V>  value的类型
     * @param size 初始容量
     * @return {@link java.util.IdentityHashMap}
     * @since 4.5.7
     */
    public static <K, V> Map<K, V> newIdentityMap(int size) {
        return new IdentityHashMap<>(size);
    }

    /**
     * 新建一个初始容量为{@link MapUtil#DEFAULT_INITIAL_CAPACITY} 的ConcurrentHashMap
     *
     * @param <K> key的类型
     * @param <V> value的类型
     * @return ConcurrentHashMap
     */
    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap<>(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * 新建一个ConcurrentHashMap
     *
     * @param size 初始容量，当传入的容量小于等于0时，容量为{@link MapUtil#DEFAULT_INITIAL_CAPACITY}
     * @param <K>  key的类型
     * @param <V>  value的类型
     * @return ConcurrentHashMap
     */
    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap(int size) {
        final int initCapacity = size <= 0 ? DEFAULT_INITIAL_CAPACITY : size;
        return new ConcurrentHashMap<>(initCapacity);
    }

    /**
     * 传入一个Map将其转化为ConcurrentHashMap类型
     *
     * @param map map
     * @param <K> key的类型
     * @param <V> value的类型
     * @return ConcurrentHashMap
     */
    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap(Map<K, V> map) {
        if (isEmpty(map)) {
            return new ConcurrentHashMap<>(DEFAULT_INITIAL_CAPACITY);
        }
        return new ConcurrentHashMap<>(map);
    }

    /**
     * 创建Map<br>
     * 传入抽象Map{@link java.util.AbstractMap}和{@link Map}类将默认创建{@link HashMap}
     *
     * @param <K>     map键类型
     * @param <V>     map值类型
     * @param mapType map类型
     * @return {@link Map}实例
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> createMap(Class<?> mapType) {
        if (null == mapType || mapType.isAssignableFrom(AbstractMap.class)) {
            return new HashMap<>();
        } else {
            try {
                return (Map<K, V>) ReflectUtil.newInstance(mapType);
            } catch (RuntimeException e) {
                // 不支持的map类型，返回默认的HashMap
                return new HashMap<>();
            }
        }
    }

    // ----------------------------------------------------------------------------------------------- value of

    /**
     * 将单一键值对转换为Map
     *
     * @param <K>   键类型
     * @param <V>   值类型
     * @param key   键
     * @param value 值
     * @return {@link HashMap}
     */
    public static <K, V> HashMap<K, V> of(K key, V value) {
        return of(key, value, false);
    }

    /**
     * 将单一键值对转换为Map
     *
     * @param <K>     键类型
     * @param <V>     值类型
     * @param key     键
     * @param value   值
     * @param isOrder 是否有序
     * @return {@link HashMap}
     */
    public static <K, V> HashMap<K, V> of(K key, V value, boolean isOrder) {
        final HashMap<K, V> map = newHashMap(isOrder);
        map.put(key, value);
        return map;
    }

    /**
     * 根据给定的Pair数组创建Map对象
     *
     * @param <K>     键类型
     * @param <V>     值类型
     * @param entries 键值对
     * @return Map
     * @see #entry(Object, Object)
     */
    @SafeVarargs
    public static <K, V> Map<K, V> ofEntries(Map.Entry<K, V>... entries) {
        final Map<K, V> map = new HashMap<>();
        for (Map.Entry<K, V> pair : entries) {
            map.put(pair.getKey(), pair.getValue());
        }
        return map;
    }

    /**
     * 将数组转换为Map（HashMap），支持数组元素类型为：
     *
     * <pre>
     * Map.Entry
     * 长度大于1的数组（取前两个值），如果不满足跳过此元素
     * Iterable 长度也必须大于1（取前两个值），如果不满足跳过此元素
     * Iterator 长度也必须大于1（取前两个值），如果不满足跳过此元素
     * </pre>
     *
     * <pre>
     * Map&lt;Object, Object&gt; colorMap = MapUtil.of(new String[][] {
     *    { "RED", "#FF0000" },
     *    { "GREEN", "#00FF00" },
     *    { "BLUE", "#0000FF" }
     * });
     * </pre>
     * <p>
     * 参考：commons-lang
     *
     * @param array 数组。元素类型为Map.Entry、数组、Iterable、Iterator
     * @return {@link HashMap}
     */
    @SuppressWarnings("rawtypes")
    public static HashMap<Object, Object> of(Object[] array) {
        if (array == null) {
            return null;
        }
        final HashMap<Object, Object> map = new HashMap<>((int) (array.length * 1.5));
        for (int i = 0; i < array.length; i++) {
            final Object object = array[i];
            if (object instanceof Map.Entry entry) {
                map.put(entry.getKey(), entry.getValue());
            } else if (object instanceof Object[] entry) {
                if (entry.length > 1) {
                    map.put(entry[0], entry[1]);
                }
            } else if (object instanceof Iterable) {
                final Iterator iter = ((Iterable) object).iterator();
                if (iter.hasNext()) {
                    final Object key = iter.next();
                    if (iter.hasNext()) {
                        final Object value = iter.next();
                        map.put(key, value);
                    }
                }
            } else if (object instanceof Iterator iter) {
                if (iter.hasNext()) {
                    final Object key = iter.next();
                    if (iter.hasNext()) {
                        final Object value = iter.next();
                        map.put(key, value);
                    }
                }
            } else {
                throw new IllegalArgumentException(StringUtil.format("Array element {}, '{}', is not type of Map.Entry or Array or Iterable or Iterator", i, object));
            }
        }
        return map;
    }

    /**
     * 根据给定的entry列表，根据entry的key进行分组;
     *
     * @param <K>     键类型
     * @param <V>     值类型
     * @param entries entry列表
     * @return entries
     */
    public static <K, V> Map<K, List<V>> grouping(Iterable<Map.Entry<K, V>> entries) {
        final Map<K, List<V>> map = new HashMap<>();
        if (!entries.iterator().hasNext()) {
            return map;
        }
        for (final Map.Entry<K, V> pair : entries) {
            final List<V> values = map.computeIfAbsent(pair.getKey(), k -> new ArrayList<>());
            values.add(pair.getValue());
        }
        return map;
    }

    /**
     * 将键值对转换为二维数组，第一维是key，第二维是value
     *
     * @param map map
     * @return 数组
     */
    public static Object[][] toObjectArray(Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        final Object[][] result = new Object[map.size()][2];
        if (map.isEmpty()) {
            return result;
        }
        int index = 0;
        for (Entry<?, ?> entry : map.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }
        return result;
    }

    /**
     * Map的键和值互换<br>
     * 互换键值对不检查值是否有重复，如果有则后加入的元素替换先加入的元素<br>
     * 值的顺序在HashMap中不确定，所以谁覆盖谁也不确定，在有序的Map中按照先后顺序覆盖，保留最后的值
     *
     * @param <K> 键和值类型
     * @param <V> 键和值类型
     * @param map Map对象
     * @return 互换后的Map
     */
    public static <K, V> Map<V, K> inverse(Map<K, V> map) {
        final Map<V, K> result = createMap(map.getClass());
        map.forEach((key, value) -> result.put(value, key));
        return result;
    }

    /**
     * 排序已有Map，Key有序的Map，使用默认Key排序方式（字母顺序）
     *
     * @param <K> key的类型
     * @param <V> value的类型
     * @param map Map
     * @return TreeMap
     * @see #newTreeMap(Map, Comparator)
     */
    public static <K, V> TreeMap<K, V> sort(Map<K, V> map) {
        return sort(map, null);
    }

    /**
     * 排序已有Map，Key有序的Map
     *
     * @param <K>        key的类型
     * @param <V>        value的类型
     * @param map        Map，为null返回null
     * @param comparator Key比较器
     * @return TreeMap，map为null返回null
     * @see #newTreeMap(Map, Comparator)
     */
    public static <K, V> TreeMap<K, V> sort(Map<K, V> map, Comparator<? super K> comparator) {
        if (null == map) {
            return null;
        }

        if (map instanceof TreeMap<K, V> result) {
            // 已经是可排序Map，此时只有比较器一致才返回原map
            if (null == comparator || comparator.equals(result.comparator())) {
                return result;
            }
        }

        return newTreeMap(map, comparator);
    }

    /**
     * 按照值排序，可选是否倒序
     *
     * @param map    需要对值排序的map
     * @param <K>    键类型
     * @param <V>    值类型
     * @param isDesc 是否倒序
     * @return 排序后新的Map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean isDesc) {
        Map<K, V> result = new LinkedHashMap<>();
        Comparator<Entry<K, V>> entryComparator = Entry.comparingByValue();
        if (isDesc) {
            entryComparator = entryComparator.reversed();
        }
        map.entrySet().stream().sorted(entryComparator).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }

    /**
     * 去掉Map中指定key的键值对，修改原Map
     *
     * @param <K>  Key类型
     * @param <V>  Value类型
     * @param map  Map
     * @param keys 键列表
     * @return 修改后的key
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> removeAny(Map<K, V> map, final K... keys) {
        for (K key : keys) {
            map.remove(key);
        }
        return map;
    }

    /**
     * 重命名键<br>
     * 实现方式为移除然后重新put，当旧的key不存在直接返回<br>
     * 当新的key存在，抛出{@link IllegalArgumentException} 异常
     *
     * @param <K>    key的类型
     * @param <V>    value的类型
     * @param map    Map
     * @param oldKey 原键
     * @param newKey 新键
     * @return map
     * @throws IllegalArgumentException 新key存在抛出此异常
     * @since 4.5.16
     */
    public static <K, V> Map<K, V> renameKey(Map<K, V> map, K oldKey, K newKey) {
        if (isNotEmpty(map) && map.containsKey(oldKey)) {
            if (map.containsKey(newKey)) {
                throw new IllegalArgumentException(StringUtil.format("The key '{}' exist !", newKey));
            }
            map.put(newKey, map.remove(oldKey));
        }
        return map;
    }

    /**
     * 去除Map中值为{@code null}的键值对<br>
     * 注意：此方法在传入的Map上直接修改。
     *
     * @param <K> key的类型
     * @param <V> value的类型
     * @param map Map
     * @return map
     * @since 4.6.5
     */
    public static <K, V> Map<K, V> removeNullValue(Map<K, V> map) {
        if (isEmpty(map)) {
            return map;
        }

        final Iterator<Entry<K, V>> iter = map.entrySet().iterator();
        Entry<K, V> entry;
        while (iter.hasNext()) {
            entry = iter.next();
            if (null == entry.getValue()) {
                iter.remove();
            }
        }

        return map;
    }

    /**
     * 返回一个空Map
     *
     * @param <K> 键类型
     * @param <V> 值类型
     * @return 空Map
     * @see Collections#emptyMap()
     * @since 5.3.1
     */
    public static <K, V> Map<K, V> empty() {
        return Collections.emptyMap();
    }

    /**
     * 根据传入的Map类型不同，返回对应类型的空Map，支持类型包括：
     *
     * <pre>
     *     1. NavigableMap
     *     2. SortedMap
     *     3. Map
     * </pre>
     *
     * @param <K>      键类型
     * @param <V>      值类型
     * @param <T>      Map类型
     * @param mapClass Map类型，null返回默认的Map
     * @return 空Map
     * @since 5.3.1
     */
    @SuppressWarnings("unchecked")
    public static <K, V, T extends Map<K, V>> T empty(Class<?> mapClass) {
        if (null == mapClass) {
            return (T) Collections.emptyMap();
        }
        if (NavigableMap.class == mapClass) {
            return (T) Collections.emptyNavigableMap();
        } else if (SortedMap.class == mapClass) {
            return (T) Collections.emptySortedMap();
        } else if (Map.class == mapClass) {
            return (T) Collections.emptyMap();
        }

        // 不支持空集合的集合类型
        throw new IllegalArgumentException(StringUtil.format("[{}] is not support to get empty!", mapClass));
    }

    /**
     * 清除一个或多个Map集合内的元素，每个Map调用clear()方法
     *
     * @param maps 一个或多个Map
     */
    public static void clear(Map<?, ?>... maps) {
        for (Map<?, ?> map : maps) {
            if (isNotEmpty(map)) {
                map.clear();
            }
        }
    }

    /**
     * 从Map中获取指定键列表对应的值列表<br>
     * 如果key在map中不存在或key对应值为null，则返回值列表对应位置的值也为null
     *
     * @param <K>  键类型
     * @param <V>  值类型
     * @param map  {@link Map}
     * @param keys 键列表
     * @return 值列表
     * @since 5.7.20
     */
    public static <K, V> ArrayList<V> valuesOfKeys(Map<K, V> map, Iterator<K> keys) {
        final ArrayList<V> values = new ArrayList<>();
        while (keys.hasNext()) {
            values.add(map.get(keys.next()));
        }
        return values;
    }

    /**
     * 将键和值转换为{@link AbstractMap.SimpleImmutableEntry}<br>
     * 返回的Entry不可变
     *
     * @param key   键
     * @param value 值
     * @param <K>   键类型
     * @param <V>   值类型
     * @return {@link AbstractMap.SimpleImmutableEntry}
     * @since 5.8.0
     */
    public static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return entry(key, value, true);
    }

    /**
     * 将键和值转换为{@link AbstractMap.SimpleEntry} 或者 {@link AbstractMap.SimpleImmutableEntry}
     *
     * @param key         键
     * @param value       值
     * @param <K>         键类型
     * @param <V>         值类型
     * @param isImmutable 是否不可变Entry
     * @return {@link AbstractMap.SimpleEntry} 或者 {@link AbstractMap.SimpleImmutableEntry}
     * @since 5.8.0
     */
    public static <K, V> Map.Entry<K, V> entry(K key, V value, boolean isImmutable) {
        return isImmutable ?
                new AbstractMap.SimpleImmutableEntry<>(key, value) :
                new AbstractMap.SimpleEntry<>(key, value);
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
        Assert.assertTrue(keyValues.length % 2 == 0, "The number of key-value pairs must be an even number");

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
            throw new IllegalArgumentException("The number of key-value pairs must be an even number");
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