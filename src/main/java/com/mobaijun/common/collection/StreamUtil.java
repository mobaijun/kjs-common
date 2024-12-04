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

import com.mobaijun.common.collection.diff.Diff;
import com.mobaijun.common.collection.diff.Diff2;
import com.mobaijun.common.collection.functional.Failure;
import com.mobaijun.common.collection.functional.Success;
import com.mobaijun.common.collection.functional.Try;
import com.mobaijun.common.collection.util.Op;
import com.mobaijun.common.constant.StringConstant;
import com.mobaijun.common.function.stream.CheckedFunction0;
import com.mobaijun.common.function.stream.CheckedRunnable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
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
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
     * 返回一个空的 List 集合。
     *
     * @param <T> 泛型，表示集合元素的类型
     * @return 返回一个空的不可修改的 List 集合
     */
    public static <T> List<T> emptyList() {
        // 返回一个空的不可修改的 List
        return Collections.emptyList();
    }

    /**
     * 返回一个空的 Map 集合。
     *
     * @param <K> 键的类型
     * @param <V> 值的类型
     * @return 返回一个空的不可修改的 Map
     */
    public static <K, V> Map<K, V> emptyMap() {
        // 返回一个空的不可修改的 Map
        return Collections.emptyMap();
    }

    /**
     * 返回一个空的 Set 集合。
     *
     * @param <T> 泛型类型，集合元素的类型
     * @return 返回一个空的不可修改的 Set
     */
    public static <T> Set<T> emptySet() {
        // 返回一个空的不可修改的 Set
        return Collections.emptySet();
    }

    /**
     * 将 Collection 过滤，返回符合条件的元素。
     *
     * @param collection 需要过滤的集合
     * @param function   过滤方法（条件）
     * @param <E>        集合元素类型
     * @return 过滤后的 List，若 Collection 为空，返回空的 List
     */
    public static <E> List<E> filter(Collection<E> collection, Predicate<E> function) {
        if (collection.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        // 注意此处不要使用 .toList() 新语法 因为返回的是不可变List 会导致序列化问题
        return collection.stream().filter(function).collect(Collectors.toList());  // 使用 toList() 收集符合条件的元素
    }

    /**
     * 对 List 中的元素进行过滤，返回符合条件的元素组成的新 List。
     *
     * @param data List 数据
     * @param pre  用于过滤条件的 Predicate
     * @param <T>  List 中的元素类型
     * @return 过滤后的 List，如果 List 为空则返回一个空 List
     */
    public static <T> List<T> filter(List<T> data, Predicate<T> pre) {
        return data.isEmpty() ? Collections.emptyList() : data.stream().filter(pre).toList();
    }

    /**
     * 在 Collection 中找到第一个满足条件的元素。
     *
     * @param collection 需要查询的集合
     * @param function   过滤方法（条件）
     * @param <E>        集合元素类型
     * @return 满足条件的第一个元素，如果没有则返回 null
     */
    public static <E> E findFirst(Collection<E> collection, Predicate<E> function) {
        if (collection.isEmpty()) {
            return null;
        }
        // 使用流查找第一个符合条件的元素
        return collection.stream().filter(function).findFirst()
                // 返回第一个符合条件的元素，若没有则返回 null
                .orElse(null);
    }

    /**
     * 在 Collection 中找到任意一个满足条件的元素。
     *
     * @param collection 需要查询的集合
     * @param function   过滤方法（条件）
     * @param <E>        集合元素类型
     * @return 满足条件的任意一个元素，若没有则返回 Optional.empty()
     */
    public static <E> Optional<E> findAny(Collection<E> collection, Predicate<E> function) {
        if (collection.isEmpty()) {
            // 若集合为空，返回 Optional.empty()
            return Optional.empty();
        }
        // 使用流查找任意一个符合条件的元素
        return collection.stream().filter(function).findAny();  // 返回任意符合条件的元素
    }

    /**
     * 将 Collection 中的元素拼接成一个字符串，默认使用逗号作为分隔符。
     *
     * @param collection 需要拼接的集合
     * @param function   用于将元素转换为字符串的 Lambda 表达式
     * @param <E>        集合元素类型
     * @return 拼接后的字符串，若集合为空返回空字符串
     */
    public static <E> String join(Collection<E> collection, Function<E, String> function) {
        // 默认使用逗号作为分隔符
        return join(collection, function, StringConstant.COMMA);
    }

    /**
     * 将 Collection 中的元素拼接成一个字符串，可以指定自定义的分隔符。
     *
     * @param collection 需要拼接的集合
     * @param function   用于将元素转换为字符串的 Lambda 表达式
     * @param delimiter  拼接的分隔符
     * @param <E>        集合元素类型
     * @return 拼接后的字符串，若集合为空返回空字符串
     */
    public static <E> String join(Collection<E> collection, Function<E, String> function, CharSequence delimiter) {
        if (collection.isEmpty()) {
            // 如果集合为空，返回空字符串
            return StringConstant.BLANK;
        }
        // 使用流将元素映射为字符串，并拼接成一个最终的字符串
        return collection.stream()
                // 将每个元素通过 function 转换为字符串
                .map(function)
                // 过滤掉 null 元素
                .filter(Objects::nonNull)
                // 使用指定的分隔符拼接字符串
                .collect(Collectors.joining(delimiter));
    }

    /**
     * 将 List 中的元素连接成一个字符串，元素之间用指定的分隔符分隔。
     *
     * @param data List 数据
     * @param join 分隔符
     * @return 连接后的字符串，如果 List 为空则返回 null
     */
    public static String join(List<String> data, String join) {
        if (data.isEmpty()) {
            return null;
        }
        // 使用 Collectors.joining() 将 List 元素连接成字符串
        return data.stream().collect(Collectors.joining(join == null ? "" : join));
    }

    /**
     * 对 List 进行排序，返回一个新的排序后的 List。
     *
     * @param data       List 数据
     * @param comparator 比较器，用于定义排序规则
     * @param <T>        List 元素类型
     * @return 排序后的 List，如果 data 为空则返回一个新的空 List
     */
    public static <T> List<T> sorted(List<T> data, Comparator<T> comparator) {
        if (data.isEmpty()) {
            // 如果 data 为空，返回一个空的 ArrayList
            return CollectionUtil.newArrayList();
        }
        // 使用流进行排序并返回排序后的 List
        return data.stream().sorted(comparator).toList();
    }

    /**
     * 将 Collection 排序。
     *
     * @param collection 需要排序的集合
     * @param comparing  排序方法
     * @param <E>        集合元素的类型
     * @return 排序后的 List，如果 Collection 为空，返回一个空的 List
     */
    public static <E> List<E> sorted(Collection<E> collection, Comparator<E> comparing) {
        if (collection.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        // 使用流对集合进行排序，并返回排序后的 List
        return collection.stream()
                // 过滤掉 null 元素
                .filter(Objects::nonNull)
                // 根据提供的排序方法进行排序
                .sorted(comparing)
                // 收集成 List
                .toList();
    }

    /**
     * 将 Collection 转化为类型不变的 Map（key 为通过 Function 转换得到的类型，value 为原 Collection 的元素）。
     *
     * @param collection 需要转换的集合
     * @param key        用于将 V 类型转换为 K 类型的 Lambda 表达式
     * @param <V>        Collection 中的元素类型
     * @param <K>        Map 中的 key 类型
     * @return 转换后的 Map
     */
    public static <V, K> Map<K, V> toIdentityMap(Collection<V> collection, Function<V, K> key) {
        if (collection.isEmpty()) {
            return MapUtil.newHashMap();
        }
        // 使用流对集合进行转换并生成 Map
        return collection.stream()
                // 过滤掉 null 元素
                .filter(Objects::nonNull)
                // 使用 key 转换生成 Map
                .collect(Collectors.toMap(key, Function.identity(), (l, r) -> l));
    }

    /**
     * 将 Collection 转化为 Map（value 类型与 Collection 的泛型不同）。
     *
     * @param collection 需要转换的集合
     * @param key        用于将 E 类型转换为 K 类型的 Lambda 表达式
     * @param value      用于将 E 类型转换为 V 类型的 Lambda 表达式
     * @param <E>        Collection 中的元素类型
     * @param <K>        Map 中的 key 类型
     * @param <V>        Map 中的 value 类型
     * @return 转换后的 Map
     */
    public static <E, K, V> Map<K, V> toMap(Collection<E> collection, Function<E, K> key, Function<E, V> value) {
        if (collection.isEmpty()) {
            return MapUtil.newHashMap();
        }
        // 使用流对集合进行转换并生成 Map
        return collection.stream()
                // 过滤掉 null 元素
                .filter(Objects::nonNull)
                // 根据 key 和 value 生成 Map
                .collect(Collectors.toMap(key, value, (l, r) -> l));
    }

    /**
     * 将 Collection 按照指定的规则进行分组，返回一个 Map，Map 的 value 为 List。
     *
     * @param collection 需要分类的集合
     * @param key        分类的规则，用于提取 key
     * @param <E>        Collection 中的元素类型
     * @param <K>        Map 中的 key 类型
     * @return 按照规则分组后的 Map
     */
    public static <E, K> Map<K, List<E>> groupByKey(Collection<E> collection, Function<E, K> key) {
        if (collection.isEmpty()) {
            return MapUtil.newHashMap();
        }
        // 使用流对集合进行分组，并生成 Map<K, List<E>>
        return collection.stream()
                // 过滤掉 null 元素
                .filter(Objects::nonNull)
                // 按照 key 分组
                .collect(Collectors.groupingBy(key, LinkedHashMap::new, Collectors.toList()));
    }

    /**
     * 将 Collection 按照两个规则进行分组，返回一个双层 Map，Map 的 value 为 List。
     *
     * @param collection 需要分类的集合
     * @param key1       第一个分类的规则，用于提取 key1
     * @param key2       第二个分类的规则，用于提取 key2
     * @param <E>        集合元素类型
     * @param <K>        第一个 Map 中的 key 类型
     * @param <U>        第二个 Map 中的 key 类型
     * @return 按照两个规则分组后的双层 Map
     */
    public static <E, K, U> Map<K, Map<U, List<E>>> groupBy2Key(Collection<E> collection, Function<E, K> key1, Function<E, U> key2) {
        if (collection.isEmpty()) {
            return MapUtil.newHashMap();
        }
        // 使用流对集合进行两层分组，并生成一个双层 Map
        return collection.stream()
                .filter(Objects::nonNull)  // 过滤掉 null 元素
                .collect(Collectors.groupingBy(key1, LinkedHashMap::new,
                        // 两层分组
                        Collectors.groupingBy(key2, LinkedHashMap::new, Collectors.toList())));
    }

    /**
     * 将 Collection 按照两个规则进行分组，返回一个双层 Map，Map 的 value 为单一元素。
     *
     * @param collection 需要分类的集合
     * @param key1       第一个分类的规则，用于提取 key1
     * @param key2       第二个分类的规则，用于提取 key2
     * @param <T>        第一个 Map 中的 key 类型
     * @param <U>        第二个 Map 中的 key 类型
     * @param <E>        Collection 中的元素类型
     * @return 按照两个规则分组后的双层 Map，其中 Map 的 value 为元素本身
     */
    public static <E, T, U> Map<T, Map<U, E>> group2Map(Collection<E> collection, Function<E, T> key1, Function<E, U> key2) {
        if (collection.isEmpty() || key1 == null || key2 == null) {
            return MapUtil.newHashMap();
        }
        // 使用流对集合进行两层分组，并生成一个双层 Map，其中 value 为元素本身
        return collection.stream()
                .filter(Objects::nonNull)  // 过滤掉 null 元素
                .collect(Collectors.groupingBy(key1, LinkedHashMap::new,
                        // 两层分组
                        Collectors.toMap(key2, Function.identity(), (l, r) -> l)));
    }

    /**
     * 生成一个新的 List，将传入的元素添加到集合中。
     *
     * @param elements 元素，可以传入多个元素
     * @param <T>      泛型，表示元素类型
     * @return 返回一个包含传入元素的 List
     */
    @SafeVarargs
    public static <T> List<T> toList(T... elements) {
        // 使用 CollectionUtil 创建一个新的 ArrayList
        List<T> list = CollectionUtil.newArrayList();
        // 判断传入的元素是否为空
        if (Objects.nonNull(elements)) {
            // 遍历传入的元素数组，将非空元素添加到 list 中
            Arrays.stream(elements).forEach(item -> {
                if (Objects.nonNull(item)) {
                    list.add(item);
                }
            });
        }
        return list;
    }

    /**
     * 将 Collection 转换为 List 集合，且两者的泛型不同。
     *
     * @param collection 需要转换的集合
     * @param function   用于将 Collection 中元素转换为 List 中元素的 Lambda 表达式
     * @param <E>        Collection 中的元素类型
     * @param <T>        List 中的元素类型
     * @return 转换后的 List，如果 Collection 为空，返回一个空的 List
     */
    public static <E, T> List<T> toList(Collection<E> collection, Function<E, T> function) {
        if (collection.isEmpty()) {
            return CollectionUtil.newArrayList();
        }
        // 使用流进行转换并返回转换后的 List
        return collection
                .stream()
                // 将每个元素映射为目标类型
                .map(function)
                // 过滤掉为 null 的元素
                .filter(Objects::nonNull)
                // 收集成一个 List
                .toList();
    }

    /**
     * 将 Collection 转换为 Set 集合，且两者的泛型不同。
     *
     * @param collection 需要转换的集合
     * @param function   用于将 Collection 中元素转换为 Set 中元素的 Lambda 表达式
     * @param <E>        Collection 中的元素类型
     * @param <T>        Set 中的元素类型
     * @return 转换后的 Set，如果 Collection 为空或 `function` 为 null，返回一个空的 Set
     */
    public static <E, T> Set<T> toSet(Collection<E> collection, Function<E, T> function) {
        if (collection.isEmpty() || function == null) {
            return CollectionUtil.newHashSet();
        }
        // 使用流进行转换并返回转换后的 Set
        return collection
                .stream()
                // 将每个元素映射为目标类型
                .map(function)
                // 过滤掉为 null 的元素
                .filter(Objects::nonNull)
                // 收集成一个 Set
                .collect(Collectors.toSet());
    }

    /**
     * 合并两个具有相同 key 类型的 Map。
     *
     * @param map1  第一个需要合并的 Map
     * @param map2  第二个需要合并的 Map
     * @param merge 合并操作的 Lambda 表达式，将 key, value1 和 value2 合并成最终的值
     * @param <K>   Map 中的 key 类型
     * @param <X>   第一个 Map 的 value 类型
     * @param <Y>   第二个 Map 的 value 类型
     * @param <V>   合并后的最终 Map 的 value 类型
     * @return 合并后的 Map
     */
    public static <K, X, Y, V> Map<K, V> merge(Map<K, X> map1, Map<K, Y> map2, BiFunction<X, Y, V> merge) {
        // 使用Objects.requireNonNullElse避免map为空时默认返回空Map
        map1 = Objects.requireNonNullElse(map1, Collections.emptyMap());
        map2 = Objects.requireNonNullElse(map2, Collections.emptyMap());

        // 获取两个 Map 的所有键
        Set<K> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        // 合并 Map
        Map<K, X> finalMap = map1;
        Map<K, Y> finalMap1 = map2;
        return keys.stream()
                .map(key -> new AbstractMap.SimpleEntry<>(key, merge.apply(finalMap.get(key), finalMap1.get(key))))
                // 过滤掉 null 值
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * 对 List 中的每个元素应用一个函数，并返回转换后的新 List。
     *
     * @param data List 数据
     * @param fun  用于转换每个元素的函数
     * @param <T>  List 中的元素类型
     * @param <R>  转换后的元素类型
     * @return 转换后的 List，如果 List 为空则返回一个空 List
     */
    public static <T, R> List<R> map(List<T> data, Function<T, R> fun) {
        return data.isEmpty() ? Collections.emptyList() : data.stream().map(fun).toList();
    }

    /**
     * 对 List 进行去重，返回一个新的去重后的 List。
     *
     * @param data List 数据
     * @param <T>  List 元素类型
     * @return 去重后的 List，如果 data 为空则返回一个新的空 List
     */
    public static <T> List<T> distinct(List<T> data) {
        if (data.isEmpty()) {
            // 如果 data 为空，返回一个空的 ArrayList
            return CollectionUtil.newArrayList();
        }
        // 使用流进行去重并返回去重后的 List
        return data.stream().distinct().toList();
    }

    /**
     * 根据主键去重，返回一个 Predicate 用于判断是否重复。
     *
     * @param keyExtractor 提取主键的函数
     * @param <T>          类型
     * @return 去重后的 Predicate，确保每个元素的主键唯一
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = CollectionUtil.newConcurrentHashMap(1);
        // putIfAbsent 方法：如果 Map 中没有该 key，则返回 null 并添加 key-value；如果存在，则返回已存在的值
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * 判断 List 是否包含符合条件的元素。
     *
     * @param data List 数据
     * @param pre  Predicate，用于匹配条件
     * @param <T>  元素类型
     * @return 如果 List 中有任何元素匹配条件则返回 true，否则返回 false
     */
    public static <T> boolean anyMatch(List<T> data, Predicate<T> pre) {
        if (data.isEmpty()) {
            return false;
        }
        // 使用 parallelStream 提升匹配效率
        return data.parallelStream().anyMatch(pre);
    }

    /**
     * 创建一个包含单个元素的 List。
     *
     * @param data 数据对象
     * @param <T>  元素类型
     * @return 包含单个元素的 List
     */
    public static <T> List<T> singletonList(T data) {
        // 返回一个包含单个元素的 List
        return Collections.singletonList(data);
    }

    /**
     * 将一个集合的所有元素添加到另一个集合中。
     *
     * @param collection 原始集合
     * @param add        待添加的集合
     * @param <T>        元素的类型
     */
    public static <T> void addAll(Collection<T> collection, Collection<T> add) {
        // 如果 add 集合和 collection 集合都不为空，则添加
        if (!add.isEmpty() && !collection.isEmpty()) {
            collection.addAll(add);
        }
    }

    /**
     * 将两个 Map 进行合并，第二个 Map 的元素会被添加到第一个 Map 中。
     *
     * @param map 原始 Map
     * @param add 要合并的 Map
     * @param <K> 键的类型
     * @param <V> 值的类型
     */
    public static <K, V> void addAll(Map<K, V> map, Map<K, V> add) {
        // 如果 add 和 map 都不为空，则执行合并
        if (!add.isEmpty() && !map.isEmpty()) {
            map.putAll(add);
        }
    }

    /**
     * 将一个 Set 集合转换为 List 集合。
     *
     * @param set Set 集合
     * @param <T> 元素类型
     * @return 转换后的 List 集合
     */
    public static <T> List<T> setToList(Set<T> set) {
        // 如果 set 不为空，则返回其转换后的 List
        if (!set.isEmpty()) {
            return new ArrayList<>(set);
        } else {
            // 如果 set 为空，返回一个空的 ArrayList
            return CollectionUtil.newArrayList();
        }
    }

    /**
     * 将一个字符串集合转换为长整型集合。
     *
     * @param list 字符串集合
     * @return 一个长整型集合
     * @throws NumberFormatException 如果字符串不能解析为 Long 类型，将抛出该异常
     */
    public static List<Long> strToLong(List<String> list) {
        // 使用流操作将每个字符串转换为 Long，并返回一个新的集合
        return list.stream()
                // 将字符串转换为 long
                .mapToLong(item -> Long.parseLong(item.trim()))
                // 将原始类型的 long 转换为 Long 对象
                .boxed()
                // 收集为 List
                .toList();
    }

    /**
     * 将一个 long 集合转换为字符串集合。
     *
     * @param list long 类型集合
     * @return 一个字符串集合
     */
    public static <T> List<String> toString(List<T> list) {
        // 将集合中的每个元素转换为字符串，并返回一个新的字符串集合
        return list.stream()
                // 将每个元素转换为字符串
                .map(String::valueOf)
                // 收集为 List
                .toList();
    }

    /**
     * 将一个字符串集合转换为 double 类型集合。
     *
     * @param list 字符串集合
     * @return 一个 double 类型集合
     * @throws NumberFormatException 如果字符串不能解析为 Double 类型，将抛出该异常
     */
    public static List<Double> doubleToString(List<String> list) {
        // 使用流操作将每个字符串转换为 Double，并返回一个新的集合
        return list.stream()
                // 将字符串转换为 double
                .mapToDouble(Double::valueOf)
                // 将原始类型的 double 转换为 Double 对象
                .boxed()
                // 收集为 List
                .toList();
    }

    /**
     * 将一个字符串集合转换为整型集合。
     *
     * @param list 字符串集合
     * @return 一个整型集合
     * @throws NumberFormatException 如果字符串不能解析为 Integer 类型，将抛出该异常
     */
    public static List<Integer> stringToInteger(List<String> list) {
        // 使用流操作将每个字符串转换为 Integer，并返回一个新的集合
        return list.stream()
                // 将字符串转换为 int
                .mapToInt(Integer::valueOf)
                // 将原始类型的 int 转换为 Integer 对象
                .boxed()
                // 收集为 List
                .toList();
    }

    /**
     * 静态工厂方法，将传入的元素数组转换为 ListStream。
     *
     * @param <T>      元素的类型
     * @param elements 可变参数，元素数组
     * @return 包含传入元素的 ListStream 对象
     */
    @SafeVarargs
    public static <T> ListStream<T> list(T... elements) {
        // 将元素数组转换为 ArrayList，并通过 ListStream.of 转换为 ListStream 对象
        return ListStream.of(asList(elements));
    }

    /**
     * 将传入的元素数组转换为一个新的 ArrayList。
     * 如果元素为空或者数组长度为 0，则返回一个空的 ArrayList。
     *
     * @param <T>      元素的类型
     * @param elements 可变参数，元素数组
     * @return 包含传入元素的 ArrayList，如果元素为空则返回空的 ArrayList
     */
    @SafeVarargs
    public static <T> List<T> asList(T... elements) {
        // 如果元素为空或者数组长度为 0，则返回一个空的 ArrayList
        if (elements == null || elements.length == 0) {
            return new ArrayList<>();
        }
        // 将元素数组转换为 ArrayList 并返回
        return new ArrayList<>(Arrays.asList(elements));
    }

    /**
     * 判断给定的 map 是否包含指定的 key，并执行相应的操作。
     * 如果 map 包含该 key，则执行 has 操作；否则执行 noHas 操作，并捕获异常。
     *
     * @param <K>   键的类型
     * @param <V>   值的类型
     * @param map   要检查的 Map
     * @param key   要检查的键
     * @param has   如果 map 包含该 key，则执行该操作
     * @param noHas 如果 map 不包含该 key，则执行该操作
     */
    public static <K, V> void hasKey(Map<K, V> map, K key, Consumer<V> has, CheckedRunnable noHas) {
        // 判断 map 是否包含指定的 key
        if (map.containsKey(key)) {
            final V v = map.get(key);
            // 如果包含该 key，则执行 has 操作
            has.accept(v);
        } else {
            try {
                // 如果没有该 key，则执行 noHas 操作，并捕获异常
                noHas.run();
            } catch (Throwable e) {
                // 如果执行 noHas 操作时抛出异常，则抛出 RuntimeException
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 将给定的键值对封装到一个新的 HashMap 中，并返回该 map。
     *
     * @param <K> 键的类型
     * @param <V> 值的类型
     * @param k   键
     * @param v   值
     * @return 包含给定键值对的 HashMap
     */
    public static <K, V> Map<K, V> asMap(K k, V v) {
        // 创建一个新的 HashMap，并放入键值对
        final Map<K, V> map = new HashMap<>();
        map.put(k, v);
        return map;
    }

    /**
     * 将给定的键值对封装到一个新的 HashMap 中，并返回一个 MapStream 对象。
     *
     * @param <K> 键的类型
     * @param <V> 值的类型
     * @param k   键
     * @param v   值
     * @return 包含给定键值对的 MapStream 对象
     */
    public static <K, V> MapStream<K, V> map(K k, V v) {
        // 创建一个新的 HashMap，并放入键值对
        final Map<K, V> map = new HashMap<>();
        map.put(k, v);
        // 返回封装 Map 的 MapStream 对象
        return new MapStream<>(map);
    }

    /**
     * 静态工厂方法，将传入的 List 转换为 ListStream。
     * 如果 List 为 null，则返回一个空的 ArrayList。
     *
     * @param <T>  元素的类型
     * @param list 待转换的 List
     * @return 包含传入 List 的 ListStream 对象
     */
    public static <T> ListStream<T> list(List<T> list) {
        // 如果传入的 List 为 null，则返回一个空的 ArrayList
        return ListStream.of(list == null ? new ArrayList<>() : list);
    }

    /**
     * 将传入的值封装为 Op 对象并返回。
     *
     * @param <V> 值的类型
     * @param v   待封装的值
     * @return 封装传入值的 Op 对象
     */
    public static <V> Op<V> op(V v) {
        // 将传入的值封装为 Op 对象并返回
        return new Op<>(v);
    }

    /**
     * 根据某个比较逻辑，计算出两个列表之间的差异，返回一个包含新增、删除和未变更元素的 Diff 对象
     *
     * @param <T>          待处理列表中元素的类型
     * @param oldList      旧的列表数据，不能为 null
     * @param newList      新的列表数据，不能为 null
     * @param keyExtractor 用来判断元素是否为同一元素的比较逻辑
     * @return 包含三个 List 的 Diff 对象，分别表示新增、删除和未变更的元素
     */
    public static <T> Diff<T> getDiff(List<T> oldList,
                                      List<T> newList,
                                      BiFunction<T, T, Boolean> keyExtractor) {
        // 计算交集（存在的元素）
        List<T> existsList = oldList.stream()
                .filter(s -> newList.stream().anyMatch(t -> keyExtractor.apply(t, s)))
                .collect(Collectors.toCollection(ArrayList::new));

        // 使用映射存储交集中的元素
        Map<T, T> map = new LinkedHashMap<>();
        for (T t1 : existsList) {
            for (T t2 : newList) {
                if (keyExtractor.apply(t1, t2)) {
                    map.put(t1, t2);
                    break;
                }
            }
        }

        // 计算新增的元素（在新列表中但不在旧列表中）
        List<T> addList = newList.stream()
                .filter(s -> existsList.stream().noneMatch(t -> keyExtractor.apply(t, s)))
                .collect(Collectors.toCollection(ArrayList::new));

        // 计算删除的元素（在旧列表中但不在新列表中）
        List<T> delList = oldList.stream()
                .filter(s -> existsList.stream().noneMatch(t -> keyExtractor.apply(t, s)))
                .collect(Collectors.toCollection(ArrayList::new));

        // 返回包含新增、删除和未变更元素的 Diff 对象
        return new Diff<T>().setAddList(addList).setDelList(delList).setUpdateMap(map);
    }

    /**
     * 根据某个比较逻辑，计算出两个列表之间的差异，返回一个包含新增、删除和未变更元素的 Diff2 对象
     *
     * @param <T>          旧列表中元素的类型
     * @param <R>          新列表中元素的类型
     * @param oldList      旧的列表数据，不能为 null
     * @param newList      新的列表数据，不能为 null
     * @param keyExtractor 用来判断元素是否为同一元素的比较逻辑
     * @return 包含三个 List 的 Diff2 对象，分别表示新增、删除和未变更的元素
     */
    public static <T, R> Diff2<T, R> getDiff2(List<T> oldList,
                                              List<R> newList,
                                              BiFunction<T, R, Boolean> keyExtractor) {
        // 计算交集（存在的元素）
        List<T> existsList = oldList.stream()
                .filter(s -> newList.stream().anyMatch(t -> keyExtractor.apply(s, t)))
                .collect(Collectors.toCollection(ArrayList::new));

        // 使用映射存储交集中的元素
        Map<T, R> map = new LinkedHashMap<>();
        for (T t : existsList) {
            for (R r : newList) {
                if (keyExtractor.apply(t, r)) {
                    map.put(t, r);
                    break;
                }
            }
        }

        // 计算新增的元素（在新列表中但不在旧列表中）
        List<R> addList = newList.stream()
                .filter(s -> existsList.stream().noneMatch(t -> keyExtractor.apply(t, s)))
                .collect(Collectors.toCollection(ArrayList::new));

        // 计算删除的元素（在旧列表中但不在新列表中）
        List<T> delList = oldList.stream()
                .filter(s -> newList.stream().noneMatch(t -> keyExtractor.apply(s, t)))
                .collect(Collectors.toCollection(ArrayList::new));

        // 返回包含新增、删除和未变更元素的 Diff2 对象
        return new Diff2<T, R>().setAddList(addList).setDelList(delList).setUpdateMap(map);
    }

    /**
     * 深拷贝一个对象，要求该对象实现 Serializable 接口。
     *
     * @param <T> 对象类型
     * @param obj 要克隆的对象，必须实现 Serializable 接口
     * @return 克隆后的对象
     * @throws RuntimeException 如果对象未实现 Serializable 接口，或克隆过程中发生异常
     */
    @SuppressWarnings("all")
    public static <T> T clone(T obj) {
        // 判断对象是否实现 Serializable 接口
        if (!(obj instanceof Serializable)) {
            throw new RuntimeException("对象没有实现 Serializable 接口");
        }
        try {
            // 使用字节流进行深拷贝
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            // 将对象写入字节流
            oos.writeObject(obj);
            oos.close();

            // 从字节流中读取对象，进行反序列化
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            // 读取对象
            Object newObj = ois.readObject();
            ois.close();

            // 返回克隆后的对象
            return (T) newObj;
        } catch (Exception e) {
            // 如果发生异常，则抛出 RuntimeException
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行一个可能会抛出异常的操作，返回一个 Try 对象表示操作的结果。
     *
     * @param <T>      操作返回的结果类型
     * @param supplier 包含操作逻辑的函数，可能会抛出异常
     * @return 返回一个 Try 对象，如果操作成功则包含成功的结果，否则包含异常
     * @throws NullPointerException 如果 supplier 为 null
     */
    @SuppressWarnings("all")
    public static <T> Try<T> tryBegin(CheckedFunction0<T> supplier) {
        // 检查 supplier 是否为 null
        Objects.requireNonNull(supplier, "supplier is null");
        try {
            // 如果操作成功，返回一个 Success 对象
            return new Success<>(supplier.apply());
        } catch (Throwable t) {
            // 如果操作抛出异常，返回一个 Failure 对象
            return new Failure<>(t);
        }
    }

    /**
     * 执行一个可能会抛出异常的操作，返回一个 Try 对象表示操作的结果。
     *
     * @param <T>      操作返回的结果类型
     * @param supplier 一个 Supplier 函数，可能会抛出异常
     * @return 返回一个 Try 对象，表示操作的结果，如果操作成功则包含结果，如果失败则包含异常
     * @throws NullPointerException 如果 supplier 为 null
     */
    public static <T> Try<T> trySupplier(Supplier<? extends T> supplier) {
        // 检查 supplier 是否为 null
        Objects.requireNonNull(supplier, "supplier is null");
        // 调用 tryBegin 执行 Supplier 操作
        return tryBegin(supplier::get);
    }

    /**
     * 执行一个没有返回值的操作，返回一个 Try 对象表示操作的结果。
     *
     * @param runnable 一个没有返回值的操作，可能会抛出异常
     * @return 返回一个 Try 对象，如果操作成功则返回 Success<Void>，否则返回 Failure
     * @throws NullPointerException 如果 runnable 为 null
     */
    @SuppressWarnings("all")
    public static Try<Void> tryRun(CheckedRunnable runnable) {
        // 检查 runnable 是否为 null
        Objects.requireNonNull(runnable, "runnable is null");
        try {
            // 执行操作
            runnable.run();
            // 如果成功，返回一个 Success 对象，表示没有返回值
            return new Success<>(null);
        } catch (Throwable t) {
            // 如果操作抛出异常，返回一个 Failure 对象
            return new Failure<>(t);
        }
    }
}