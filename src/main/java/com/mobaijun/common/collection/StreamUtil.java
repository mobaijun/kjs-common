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

import com.mobaijun.common.constant.StringConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: StreamUtils<br>
 * 类描述： Stream工具类<br>
 *
 * @author MoBaiJun 2022/4/24 11:27
 */
public class StreamUtil {

    /**
     * 将collection过滤
     *
     * @param collection 需要转化的集合
     * @param function   过滤方法
     * @return 过滤后的list
     */
    public static <E> List<E> filter(Collection<E> collection, Predicate<E> function) {
        if (collection.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        // 注意此处不要使用 .toList() 新语法 因为返回的是不可变List 会导致序列化问题
        return collection.stream().filter(function).collect(Collectors.toList());
    }

    /**
     * 找到流中满足条件的第一个元素
     *
     * @param collection 需要查询的集合
     * @param function   过滤方法
     * @return 找到符合条件的第一个元素，没有则返回null
     */
    public static <E> E findFirst(Collection<E> collection, Predicate<E> function) {
        if (collection.isEmpty()) {
            return null;
        }
        return collection.stream().filter(function).findFirst().orElse(null);
    }

    /**
     * 找到流中任意一个满足条件的元素
     *
     * @param collection 需要查询的集合
     * @param function   过滤方法
     * @return 找到符合条件的任意一个元素，没有则返回null
     */
    public static <E> Optional<E> findAny(Collection<E> collection, Predicate<E> function) {
        if (collection.isEmpty()) {
            return Optional.empty();
        }
        return collection.stream().filter(function).findAny();
    }

    /**
     * 将collection拼接
     *
     * @param collection 需要转化的集合
     * @param function   拼接方法
     * @return 拼接后的list
     */
    public static <E> String join(Collection<E> collection, Function<E, String> function) {
        return join(collection, function, StringConstant.COMMA);
    }

    /**
     * 将collection拼接
     *
     * @param collection 需要转化的集合
     * @param function   拼接方法
     * @param delimiter  拼接符
     * @return 拼接后的list
     */
    public static <E> String join(Collection<E> collection, Function<E, String> function, CharSequence delimiter) {
        if (collection.isEmpty()) {
            return StringConstant.BLANK;
        }
        return collection.stream().map(function).filter(Objects::nonNull).collect(Collectors.joining(delimiter));
    }

    /**
     * 将collection排序
     *
     * @param collection 需要转化的集合
     * @param comparing  排序方法
     * @return 排序后的list
     */
    public static <E> List<E> sorted(Collection<E> collection, Comparator<E> comparing) {
        if (collection.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        // 注意此处不要使用 .toList() 新语法 因为返回的是不可变List 会导致序列化问题
        return collection.stream().filter(Objects::nonNull).sorted(comparing).collect(Collectors.toList());
    }

    /**
     * 将collection转化为类型不变的map<br>
     * <B>{@code Collection<V>  ---->  Map<K,V>}</B>
     *
     * @param collection 需要转化的集合
     * @param key        V类型转化为K类型的lambda方法
     * @param <V>        collection中的泛型
     * @param <K>        map中的key类型
     * @return 转化后的map
     */
    public static <V, K> Map<K, V> toIdentityMap(Collection<V> collection, Function<V, K> key) {
        if (collection.isEmpty()) {
            return MapUtil.newHashMap();
        }
        return collection.stream().filter(Objects::nonNull).collect(Collectors.toMap(key, Function.identity(), (l, r) -> l));
    }

    /**
     * 将Collection转化为map(value类型与collection的泛型不同)<br>
     * <B>{@code Collection<E> -----> Map<K,V>  }</B>
     *
     * @param collection 需要转化的集合
     * @param key        E类型转化为K类型的lambda方法
     * @param value      E类型转化为V类型的lambda方法
     * @param <E>        collection中的泛型
     * @param <K>        map中的key类型
     * @param <V>        map中的value类型
     * @return 转化后的map
     */
    public static <E, K, V> Map<K, V> toMap(Collection<E> collection, Function<E, K> key, Function<E, V> value) {
        if (collection.isEmpty()) {
            return MapUtil.newHashMap();
        }
        return collection.stream().filter(Objects::nonNull).collect(Collectors.toMap(key, value, (l, r) -> l));
    }

    /**
     * 将collection按照规则(比如有相同的班级id)分类成map<br>
     * <B>{@code Collection<E> -------> Map<K,List<E>> } </B>
     *
     * @param collection 需要分类的集合
     * @param key        分类的规则
     * @param <E>        collection中的泛型
     * @param <K>        map中的key类型
     * @return 分类后的map
     */
    public static <E, K> Map<K, List<E>> groupByKey(Collection<E> collection, Function<E, K> key) {
        if (collection.isEmpty()) {
            return MapUtil.newHashMap();
        }
        return collection
                .stream().filter(Objects::nonNull)
                .collect(Collectors.groupingBy(key, LinkedHashMap::new, Collectors.toList()));
    }

    /**
     * 将collection按照两个规则(比如有相同的年级id,班级id)分类成双层map<br>
     * <B>{@code Collection<E>  --->  Map<T,Map<U,List<E>>> } </B>
     *
     * @param collection 需要分类的集合
     * @param key1       第一个分类的规则
     * @param key2       第二个分类的规则
     * @param <E>        集合元素类型
     * @param <K>        第一个map中的key类型
     * @param <U>        第二个map中的key类型
     * @return 分类后的map
     */
    public static <E, K, U> Map<K, Map<U, List<E>>> groupBy2Key(Collection<E> collection, Function<E, K> key1, Function<E, U> key2) {
        if (collection.isEmpty()) {
            return MapUtil.newHashMap();
        }
        return collection
                .stream().filter(Objects::nonNull)
                .collect(Collectors.groupingBy(key1, LinkedHashMap::new, Collectors.groupingBy(key2, LinkedHashMap::new, Collectors.toList())));
    }

    /**
     * 将collection按照两个规则(比如有相同的年级id,班级id)分类成双层map<br>
     * <B>{@code Collection<E>  --->  Map<T,Map<U,E>> } </B>
     *
     * @param collection 需要分类的集合
     * @param key1       第一个分类的规则
     * @param key2       第二个分类的规则
     * @param <T>        第一个map中的key类型
     * @param <U>        第二个map中的key类型
     * @param <E>        collection中的泛型
     * @return 分类后的map
     */
    public static <E, T, U> Map<T, Map<U, E>> group2Map(Collection<E> collection, Function<E, T> key1, Function<E, U> key2) {
        if (collection.isEmpty() || key1 == null || key2 == null) {
            return MapUtil.newHashMap();
        }
        return collection
                .stream().filter(Objects::nonNull)
                .collect(Collectors.groupingBy(key1, LinkedHashMap::new, Collectors.toMap(key2, Function.identity(), (l, r) -> l)));
    }

    /**
     * 将collection转化为List集合，但是两者的泛型不同<br>
     * <B>{@code Collection<E>  ------>  List<T> } </B>
     *
     * @param collection 需要转化的集合
     * @param function   collection中的泛型转化为list泛型的lambda表达式
     * @param <E>        collection中的泛型
     * @param <T>        List中的泛型
     * @return 转化后的list
     */
    public static <E, T> List<T> toList(Collection<E> collection, Function<E, T> function) {
        if (collection.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        return collection
                .stream()
                .map(function)
                .filter(Objects::nonNull)
                // 注意此处不要使用 .toList() 新语法 因为返回的是不可变List 会导致序列化问题
                .collect(Collectors.toList());
    }

    /**
     * 将collection转化为Set集合，但是两者的泛型不同<br>
     * <B>{@code Collection<E>  ------>  Set<T> } </B>
     *
     * @param collection 需要转化的集合
     * @param function   collection中的泛型转化为set泛型的lambda表达式
     * @param <E>        collection中的泛型
     * @param <T>        Set中的泛型
     * @return 转化后的Set
     */
    public static <E, T> Set<T> toSet(Collection<E> collection, Function<E, T> function) {
        if (collection.isEmpty() || function == null) {
            return CollectionUtil.newHashSet();
        }
        return collection
                .stream()
                .map(function)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    /**
     * 合并两个相同key类型的map
     *
     * @param map1  第一个需要合并的 map
     * @param map2  第二个需要合并的 map
     * @param merge 合并的lambda，将key  value1 value2合并成最终的类型,注意value可能为空的情况
     * @param <K>   map中的key类型
     * @param <X>   第一个 map的value类型
     * @param <Y>   第二个 map的value类型
     * @param <V>   最终map的value类型
     * @return 合并后的map
     */
    public static <K, X, Y, V> Map<K, V> merge(Map<K, X> map1, Map<K, Y> map2, BiFunction<X, Y, V> merge) {
        if (MapUtil.isEmpty(map1) && MapUtil.isEmpty(map2)) {
            return MapUtil.newHashMap();
        } else if (MapUtil.isEmpty(map1)) {
            map1 = MapUtil.newHashMap();
        } else if (MapUtil.isEmpty(map2)) {
            map2 = MapUtil.newHashMap();
        }
        Set<K> key = new HashSet<>();
        key.addAll(map1.keySet());
        key.addAll(map2.keySet());
        Map<K, V> map = new HashMap<>();
        for (K t : key) {
            X x = map1.get(t);
            Y y = map2.get(t);
            V z = merge.apply(x, y);
            if (z != null) {
                map.put(t, z);
            }
        }
        return map;
    }

    /**
     * 映射
     *
     * @param data 不能为空
     * @param fun  fun
     * @param <T>  未定义
     * @param <R>  未定义
     * @return data为空抛出异常IllegalArgumentException
     */
    public static <T, R> List<R> map(List<T> data, Function<T, R> fun) {
        if (data.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        return data.stream().map(fun).collect(Collectors.toList());
    }

    /**
     * 过滤
     *
     * @param data data
     * @param pre  pre
     * @param <T>  List
     * @return data为空返回data
     */
    public static <T> List<T> filter(List<T> data, Predicate<T> pre) {
        if (data.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        return data.stream().filter(pre).collect(Collectors.toList());
    }

    /**
     * 排序
     *
     * @param data       data
     * @param comparator comparator
     * @param <T>        List
     * @return data为空返回data
     */
    public static <T> List<T> sorted(List<T> data, Comparator<T> comparator) {
        if (data.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        return data.stream().sorted(comparator).collect(Collectors.toList());
    }

    /**
     * 去重
     *
     * @param data data
     * @param <T>  List
     * @return data为空返回data
     */
    public static <T> List<T> distinct(List<T> data) {
        if (data.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        return data.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 根据主键去重
     *
     * @param keyExtractor key
     * @param <T>          类型
     * @return 去重后的值
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = CollectionUtil.newConcurrentHashMap(1);
        // putIfAbsent方法添加键值对，如果map集合中没有该key对应的值，则直接添加，并返回null，如果已经存在对应的值，则依旧为原来的值。
        // 如果返回null表示添加数据成功(不重复)，不重复(null==null :TRUE)
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * 判断是否包含匹配元素
     *
     * @param data data
     * @param pre  pre
     * @param <T>  未定义
     * @return boolean
     */
    public static <T> boolean anyMatch(List<T> data, Predicate<T> pre) {
        if (data.isEmpty()) {
            return false;
        }
        return data.parallelStream().anyMatch(pre);
    }

    /**
     * 将list进行join操作
     *
     * @param data data
     * @param join join
     * @return 返回join之后的字符串, data为空返回null
     */
    public static String join(List<String> data, String join) {
        if (data.isEmpty()) {
            return null;
        }
        return data.stream().collect(Collectors.joining(join == null ? "" : join));
    }

    /**
     * 生成 list 集合
     *
     * @param data 数据对象
     * @param <T>  未定义类型
     * @return List 集合
     */
    public static <T> List<T> singletonList(T data) {
        return Collections.singletonList(data);
    }

    /**
     * 生成list
     *
     * @param elements 元素
     * @param <T>      泛型
     * @return List
     */

    @SafeVarargs
    public static <T> List<T> toList(T... elements) {
        List<T> list = CollectionUtil.newArrayList();
        if (Objects.nonNull(elements)) {
            Arrays.stream(elements).forEach(item -> {
                if (Objects.nonNull(item)) {
                    list.add(item);
                }
            });
        }
        return list;
    }

    /**
     * 添加到 list 集合
     *
     * @param collection 集合
     * @param add        待添加的集合
     * @param <T>        未定义类型
     */
    public static <T> void addAll(Collection<T> collection, Collection<T> add) {
        if (!add.isEmpty() && !collection.isEmpty()) {
            collection.addAll(add);
        }
    }

    /**
     * 两个Map进行合并
     *
     * @param map 原始 map
     * @param add 要合并的 map
     * @param <K> key 泛型
     * @param <V> 值泛型
     */
    public static <K, V> void addAll(Map<K, V> map, Map<K, V> add) {
        if (!add.isEmpty() && !map.isEmpty()) {
            map.putAll(add);
        }
    }

    /**
     * set 转 list
     *
     * @param set set 集合
     * @param <T> 未定义类型
     * @return list 集合
     */
    public static <T> List<T> setToList(Set<T> set) {
        if (!set.isEmpty()) {
            return new ArrayList<>(set);
        } else {
            return CollectionUtil.newArrayList();
        }
    }

    /**
     * 返回空集合
     *
     * @param <T> 泛型
     * @return List
     */
    public static <T> List<T> emptyList() {
        return Collections.emptyList();
    }

    /**
     * 返回空 map
     *
     * @param <K> 键
     * @param <V> 值
     * @return 空 map
     */
    public static <K, V> Map<K, V> emptyMap() {
        return Collections.emptyMap();
    }

    /**
     * 返回空集合
     *
     * @param <T> 泛型
     * @return set
     */
    public static <T> Set<T> emptySet() {
        return Collections.emptySet();
    }

    /**
     * string 集合转 long
     *
     * @param list string集合
     * @return long 集合
     */
    public static List<Long> strToLong(List<String> list) {
        return list.stream()
                .mapToLong(item -> Long.parseLong(item.trim()))
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * 转 string 集合
     *
     * @param list long 集合
     * @return string 集合
     */
    public static <T> List<String> toString(List<T> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    /**
     * string 转 double
     *
     * @param list string 集合
     * @return double 集合
     */
    public static List<Double> doubleToString(List<String> list) {
        return list.stream()
                .mapToDouble(Double::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * string 转 integer
     *
     * @param list string 集合
     * @return integer 集合
     */
    public static List<Integer> stringToInteger(List<String> list) {
        return list.stream()
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }
}