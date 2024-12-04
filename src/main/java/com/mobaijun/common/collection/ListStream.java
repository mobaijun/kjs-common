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

import com.mobaijun.common.collection.functional.FlatteningIterable;
import com.mobaijun.common.enums.comm.Sort;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Description: [list stream 操作]
 * Author: [mobaijun]
 * Date: [2024/12/3 15:21]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class ListStream<T> {

    /**
     * 该类表示一个流，允许对流中的元素进行一系列操作。
     */
    private final Iterable<T> source;

    /**
     * 构造一个ListStream，传入一个Iterable作为数据源
     *
     * @param source 数据源，必须非空
     */
    public ListStream(Iterable<T> source) {
        this.source = source;
    }

    /**
     * 创建一个ListStream实例
     *
     * @param source 数据源，必须非空
     * @param <T>    元素类型
     * @return ListStream实例
     */
    public static <T> ListStream<T> of(Iterable<T> source) {
        return new ListStream<>(Objects.requireNonNull(source));
    }

    /**
     * 向当前流中添加一个元素
     *
     * @param t 要添加的元素
     * @return 返回添加元素后的新的ListStream
     */
    public ListStream<T> add(T t) {
        final List<T> list = toList();
        list.add(t);
        return this;
    }

    /**
     * 在指定位置插入一个元素
     *
     * @param index 插入位置的索引
     * @param t     要插入的元素
     * @return 返回插入元素后的新的ListStream
     */
    public ListStream<T> add(int index, T t) {
        final List<T> list = toList();
        list.add(index, t);
        return this;
    }

    /**
     * 向当前流中添加多个元素
     *
     * @param ts 要添加的元素列表
     * @return 返回添加多个元素后的新的ListStream
     */
    public ListStream<T> addAll(List<T> ts) {
        final List<T> list = toList();
        list.addAll(ts);
        return this;
    }

    /**
     * 合并当前流和指定的元素列表，返回一个新的ListStream
     *
     * @param ts 要合并的元素列表
     * @return 合并后的新的ListStream
     */
    public ListStream<T> concat(List<T> ts) {
        final List<T> list = toList();
        list.addAll(ts);
        return of(list);
    }

    /**
     * 向当前流中添加多个元素
     *
     * @param ts 要添加的元素数组
     * @return 返回添加多个元素后的新的ListStream
     */
    @SafeVarargs
    public final ListStream<T> add(T... ts) {
        final List<T> list = toList();
        list.addAll(StreamUtil.asList(ts));
        return this;
    }

    /**
     * 跳过流中前skipIndex个元素，返回一个新的ListStream
     *
     * @param skipIndex 要跳过的元素个数
     * @return 跳过元素后的新的ListStream
     */
    public ListStream<T> skip(int skipIndex) {
        AtomicInteger i = new AtomicInteger(1);
        return of(createFilteredIterable(elem -> i.getAndIncrement() > skipIndex));
    }


    /**
     * 返回一个新的 ListStream，包含原始列表的子列表，从索引 0 开始，长度为 subLen。
     *
     * @param subLen 子列表的长度
     * @return 新的 ListStream 包含指定长度的子列表
     * @throws IllegalArgumentException 如果 subLen 为负数
     */
    public ListStream<T> sub(int subLen) {
        if (subLen < 0) {
            throw new IllegalArgumentException("subLen must be non-negative");
        }
        return sub(0, subLen);
    }

    /**
     * 返回一个新的 ListStream，包含原始列表的子列表，从索引 subBegin 开始，到索引 subEnd 结束（不包含）。
     *
     * @param subBegin 子列表的起始索引（包含）
     * @param subEnd   子列表的结束索引（不包含）
     * @return 新的 ListStream 包含指定范围的子列表
     * @throws IllegalArgumentException 如果 subBegin 为负数，或者 subEnd 小于 subBegin
     */
    public ListStream<T> sub(int subBegin, int subEnd) {
        if (subBegin < 0) {
            throw new IllegalArgumentException("subBegin must be non-negative");
        }
        if (subEnd < subBegin) {
            throw new IllegalArgumentException("subEnd must not be less than subBegin");
        }

        return of(() -> new Iterator<T>() {
            private final Iterator<T> iterator = source.iterator();
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < subEnd && iterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T next = iterator.next();
                currentIndex++;
                if (currentIndex <= subBegin) {
                    // 跳过 subBegin 之前的元素
                    return this.next();
                }
                return next;
            }
        });
    }

    public ListStream<T> reversed() {
        // 反转列表
        List<T> list = toList();
        Collections.reverse(list);
        return of(list);
    }

    /**
     * 判断是否存在符合任一条件的元素
     *
     * @param predicates 用于判断的多个条件
     * @return 如果有元素满足任一条件，则返回true；否则返回false
     */
    @SafeVarargs
    @SuppressWarnings("unused")
    public final boolean anyMatch(Predicate<T>... predicates) {
        Iterable<T> filteredIterable = createFilteredIterable(elem ->
                Arrays.stream(predicates).anyMatch(predicate -> predicate.test(elem)));
        return of(filteredIterable).isNotEmpty();
    }

    /**
     * 判断是否没有符合任一条件的元素
     *
     * @param predicates 用于判断的多个条件
     * @return 如果没有元素满足任何一个条件，则返回true；否则返回false
     */
    @SafeVarargs
    @SuppressWarnings("unused")
    public final boolean noneMatch(Predicate<T>... predicates) {
        Iterable<T> filteredIterable = createFilteredIterable(elem ->
                Arrays.stream(predicates).anyMatch(predicate -> predicate.test(elem)));
        return of(filteredIterable).isEmpty();
    }

    /**
     * 获取流中的第一个元素
     *
     * @return 第一个元素，如果流为空，则返回null
     */
    public T findFirst() {
        Iterator<T> iterator = source.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    /**
     * 对流进行限制，返回前size个元素
     *
     * @param size 要返回的元素个数
     * @return 限制后的ListStream
     */
    public ListStream<T> limit(int size) {
        return of(() -> new Iterator<T>() {
            private final Iterator<T> iterator = source.iterator();
            private int doneSize = 0;

            @Override
            public boolean hasNext() {
                final boolean hasNext = iterator.hasNext();
                return hasNext && doneSize < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T next = iterator.next();
                doneSize++;
                return next;
            }
        });
    }

    /**
     * 将流中的元素按指定分隔符连接成一个字符串
     *
     * @param symbol 用于连接元素的分隔符
     * @return 连接后的字符串
     */
    public String joining(CharSequence symbol) {
        StringJoiner sb = new StringJoiner(symbol);
        for (T t : source) {
            if (t instanceof CharSequence) {
                sb.add((CharSequence) t);
            } else {
                if (t != null) {
                    sb.add(t.toString());
                }
            }
        }
        return sb.toString();
    }

    /**
     * 过滤符合任一条件的元素，返回新的ListStream
     *
     * @param predicates 用于判断的多个条件
     * @return 符合条件的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> filterOrs(Predicate<T>... predicates) {
        return ors(predicates);
    }

    /**
     * 过滤符合任一条件的元素，返回新的ListStream
     *
     * @param predicates 用于判断的多个条件
     * @return 符合条件的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> ors(Predicate<T>... predicates) {
        return of(createFilteredIterable(elem ->
                Arrays.stream(predicates).anyMatch(predicate -> predicate.test(elem))));
    }

    /**
     * 过滤符合所有条件的元素，返回新的ListStream
     *
     * @param predicate 用于判断的条件
     * @return 符合条件的元素组成的ListStream
     */
    public ListStream<T> filter(Predicate<? super T> predicate) {
        return filters(predicate);
    }

    /**
     * 过滤符合所有条件的元素，返回新的ListStream
     *
     * @param predicates 用于判断的多个条件
     * @return 符合条件的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> ands(Predicate<T>... predicates) {
        return filters(predicates);
    }

    /**
     * 过滤符合所有条件的元素，返回新的ListStream
     *
     * @param predicates 用于判断的多个条件
     * @return 符合条件的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> filters(Predicate<? super T>... predicates) {
        Objects.requireNonNull(predicates);
        return of(createFilteredIterable(elem ->
                Arrays.stream(predicates).allMatch(predicate -> predicate.test(elem))));
    }

    /**
     * 过滤为空的元素，返回新的ListStream
     *
     * @param functions 用于判断元素是否为空的函数
     * @return 为空的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> filterNull(Function<T, ?>... functions) {
        return filterBlank(functions);
    }

    /**
     * 过滤非空的元素，返回新的ListStream
     *
     * @param functions 用于判断元素是否非空的函数
     * @return 非空的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> filterNotNull(Function<T, ?>... functions) {
        return filterNotBlank(functions);
    }

    /**
     * 过滤为空的元素，返回新的ListStream
     *
     * @param getters 用于判断元素是否为空的函数
     * @return 为空的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> isNull(Function<T, ?>... getters) {
        return filterBlank(getters);
    }

    /**
     * 过滤非空的元素，返回新的ListStream
     *
     * @param getters 用于判断元素是否非空的函数
     * @return 非空的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> isNotNull(Function<T, ?>... getters) {
        return filterNotBlank(getters);
    }

    /**
     * 过滤为空的元素，返回新的ListStream
     *
     * @param getters 用于判断元素是否为空的函数
     * @return 为空的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> isBlank(Function<T, ?>... getters) {
        return filterBlank(getters);
    }

    /**
     * 过滤非空的元素，返回新的ListStream
     *
     * @param getters 用于判断元素是否非空的函数
     * @return 非空的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> isNotBlank(Function<T, ?>... getters) {
        return filterNotBlank(getters);
    }

    /**
     * 过滤符合非空条件的元素，返回新的ListStream
     *
     * @param functions 用于判断元素是否非空的函数
     * @return 非空的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> filterNotBlank(Function<T, ?>... functions) {
        return of(createFilteredIterable(elem -> isNotBlankElement(elem, functions)));
    }

    /**
     * 过滤符合为空条件的元素，返回新的ListStream
     *
     * @param functions 用于判断元素是否为空的函数
     * @return 为空的元素组成的ListStream
     */
    @SafeVarargs
    public final ListStream<T> filterBlank(Function<T, ?>... functions) {
        return of(createFilteredIterable(elem -> isBlankElement(elem, functions)));
    }

    /**
     * 将元素转换为Map，使用keyMapper生成key
     * 如果有重复的key，保留最后一个值
     *
     * @param keyMapper 用于生成key的函数
     * @param <K>       生成的key的类型
     * @return 生成的Map
     */
    public <K> Map<K, T> toMap(Function<T, K> keyMapper) {
        return toMap(keyMapper, Function.identity());
    }

    /**
     * 将元素转换为Map，使用keyMapper生成key，valueMapper生成value
     * 如果有重复的key，保留最后一个值
     *
     * @param keyMapper   用于生成key的函数
     * @param valueMapper 用于生成value的函数
     * @param <K>         生成的key的类型
     * @param <V>         生成的value的类型
     * @return 生成的Map
     */
    public <K, V> Map<K, V> toMap(Function<T, K> keyMapper, Function<T, V> valueMapper) {
        return toMap(keyMapper, valueMapper, (v1, v2) -> v2);
    }

    /**
     * 将元素转换为Map，使用keyMapper生成key，valueMapper生成value
     * 如果有重复的key，使用mergeFunction合并值
     *
     * @param keyMapper     用于生成key的函数
     * @param valueMapper   用于生成value的函数
     * @param mergeFunction 合并重复key时的值的函数
     * @param <K>           生成的key的类型
     * @param <V>           生成的value的类型
     * @return 生成的Map
     */
    public <K, V> Map<K, V> toMap(
            Function<T, K> keyMapper,
            Function<T, V> valueMapper,
            BinaryOperator<V> mergeFunction) {
        Objects.requireNonNull(keyMapper, "keyMapper cannot be null");
        Objects.requireNonNull(valueMapper, "valueMapper cannot be null");
        Objects.requireNonNull(mergeFunction, "mergeFunction cannot be null");

        if (isEmpty()) {
            return new HashMap<>();
        }

        Map<K, V> result = new HashMap<>();
        for (T element : source) {
            if (element != null) {
                K key = keyMapper.apply(element);
                if (key != null) {
                    V value = valueMapper.apply(element);
                    result.merge(key, value, mergeFunction);
                }
            }
        }
        return result;
    }

    /**
     * 将元素转换为Map，使用keyMapper生成key
     * 如果有重复的key，将值收集到List中
     *
     * @param keyMapper 用于生成key的函数
     * @param <K>       生成的key的类型
     * @return 按key分组后的MapListStream
     */
    public <K> MapListStream<K, T> groupBy(Function<T, K> keyMapper) {
        return groupBy(keyMapper, Function.identity());
    }

    /**
     * 将元素转换为Map，使用keyMapper生成key，valueMapper生成value
     * 如果有重复的key，将值收集到List中
     *
     * @param keyMapper   用于生成key的函数
     * @param valueMapper 用于生成value的函数
     * @param <K>         生成的key的类型
     * @param <V>         生成的value的类型
     * @return 按key分组后的MapListStream
     */
    public <K, V> MapListStream<K, V> groupBy(
            Function<T, K> keyMapper,
            Function<T, V> valueMapper) {
        Objects.requireNonNull(keyMapper, "keyMapper cannot be null");
        Objects.requireNonNull(valueMapper, "valueMapper cannot be null");

        Map<K, List<V>> result = new HashMap<>();
        if (isEmpty()) {
            return new MapListStream<>(result);
        }

        for (T element : source) {
            if (element != null) {
                K key = keyMapper.apply(element);
                V value = valueMapper.apply(element);
                result.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
            }
        }
        return new MapListStream<>(result);
    }

    /**
     * 将元素转换为Map，进行分组并使用Collector进行累积
     *
     * @param keyMapper 用于生成key的函数
     * @param collector 用于处理分组后值的Collector
     * @param <S>       分组后的key类型
     * @param <A>       累积器的类型
     * @param <V>       最终分组结果的类型
     * @return 分组并累积后的MapStream
     */
    public <S, A, V> MapStream<S, V> groupingBy(
            Function<T, S> keyMapper,
            Collector<T, A, V> collector
    ) {
        // 获取collector的组件
        Supplier<A> supplier = collector.supplier();
        BiConsumer<A, T> accumulator = collector.accumulator();
        Function<A, V> finisher = collector.finisher();

        // 同时进行分组和累加，避免两次遍历
        Map<S, A> accumulatorMap = new HashMap<>();
        for (T element : source) {
            S key = keyMapper.apply(element);
            // 获取或创建累加器
            A acc = accumulatorMap.computeIfAbsent(key, k -> supplier.get());
            // 直接累加元素
            accumulator.accept(acc, element);
        }

        // 对每个分组应用finisher得到最终结果
        Map<S, V> finalResult = new HashMap<>(accumulatorMap.size());
        for (Map.Entry<S, A> entry : accumulatorMap.entrySet()) {
            finalResult.put(entry.getKey(), finisher.apply(entry.getValue()));
        }

        return new MapStream<>(finalResult);
    }

    /**
     * 将元素转换为LinkedHashMap，保持插入顺序
     *
     * @param keyMapper 用于生成key的函数
     * @param <K>       生成的key的类型
     * @return 按插入顺序生成的LinkedHashMap
     */
    public <K> Map<K, T> toLinkedMap(Function<T, K> keyMapper) {
        return toLinkedMap(keyMapper, Function.identity());
    }

    /**
     * 将元素转换为LinkedHashMap，保持插入顺序
     *
     * @param keyMapper   用于生成key的函数
     * @param valueMapper 用于生成value的函数
     * @param <K>         生成的key的类型
     * @param <V>         生成的value的类型
     * @return 按插入顺序生成的LinkedHashMap
     */
    public <K, V> Map<K, V> toLinkedMap(
            Function<T, K> keyMapper,
            Function<T, V> valueMapper) {
        Objects.requireNonNull(keyMapper, "keyMapper cannot be null");
        Objects.requireNonNull(valueMapper, "valueMapper cannot be null");

        if (isEmpty()) {
            return new LinkedHashMap<>();
        }

        Map<K, V> result = new LinkedHashMap<>();
        for (T element : source) {
            if (element != null) {
                K key = keyMapper.apply(element);
                if (key != null) {
                    V value = valueMapper.apply(element);
                    result.put(key, value);
                }
            }
        }
        return result;
    }

    /**
     * 对流中的元素进行映射操作，返回一个新的ListStream。
     *
     * @param mapper 用于转换每个元素的函数
     * @param <R>    转换后的元素类型
     * @return 映射后的ListStream
     */
    public <R> ListStream<R> map(Function<? super T, ? extends R> mapper) {
        Objects.requireNonNull(mapper);
        return of(() -> new Iterator<>() {
            final Iterator<T> iterator = source.iterator();

            public boolean hasNext() {
                return iterator.hasNext();
            }

            public R next() {
                return mapper.apply(iterator.next());
            }
        });
    }

    /**
     * 对流中的元素进行求和操作，返回一个double类型的结果。
     *
     * @param mapper 用于提取数字的函数
     * @return 元素之和（double类型）
     */
    public double sumDouble(Function<T, Number> mapper) {
        return sumBigDecimal(mapper).doubleValue();
    }

    /**
     * 对流中的元素进行求和操作，返回一个int类型的结果。
     *
     * @param mapper 用于提取数字的函数
     * @return 元素之和（int类型）
     */
    public int sumInt(Function<T, Number> mapper) {
        return sumBigDecimal(mapper).intValue();
    }

    /**
     * 对流中的元素进行求和操作，返回一个long类型的结果。
     *
     * @param mapper 用于提取数字的函数
     * @return 元素之和（long类型）
     */
    public long sumLong(Function<T, Number> mapper) {
        return sumBigDecimal(mapper).longValue();
    }

    /**
     * 对流中的元素进行求和操作，返回一个BigDecimal类型的结果。
     *
     * @param mapper 用于提取数字的函数
     * @return 元素之和（BigDecimal类型）
     */
    public BigDecimal sumBigDecimal(Function<T, Number> mapper) {
        BigDecimal sum = new BigDecimal("0.0");
        for (T t : source) {
            Number r = mapper.apply(t);
            sum = sum.add(new BigDecimal(String.valueOf(r)));
        }
        return sum;
    }

    /**
     * 对流中的元素进行求和操作，返回一个double类型的结果（默认按原值求和）。
     *
     * @return 元素之和（double类型）
     */
    public Double sumDouble() {
        return sumBigDecimal().doubleValue();
    }

    /**
     * 对流中的元素进行求和操作，返回一个int类型的结果（默认按原值求和）。
     *
     * @return 元素之和（int类型）
     */
    public Integer sumInt() {
        return sumBigDecimal().intValue();
    }

    /**
     * 对流中的元素进行求和操作，返回一个long类型的结果（默认按原值求和）。
     *
     * @return 元素之和（long类型）
     */
    public Long sumLong() {
        return sumBigDecimal().longValue();
    }

    /**
     * 对流中的元素进行求和操作，返回一个BigDecimal类型的结果（默认按原值求和）。
     *
     * @return 元素之和（BigDecimal类型）
     */
    public BigDecimal sumBigDecimal() {
        BigDecimal sum = new BigDecimal("0.0");
        for (T t : source) {
            if (t instanceof Number) {
                sum = sum.add(new BigDecimal(String.valueOf(t)));
            } else {
                throw new IllegalArgumentException("不是数字,不能计算");
            }
        }
        return sum;
    }

    /**
     * 对流中的元素进行排序，使用给定的比较器。
     *
     * @param comparator 用于排序的比较器
     * @return 排序后的ListStream
     */
    @SuppressWarnings("unused")
    public ListStream<T> sort(Comparator<T> comparator) {
        // 转换为List以进行排序
        List<T> sortedList = toList();
        // 执行排序
        sortedList.sort(comparator);
        return of(sortedList);
    }

    /**
     * 根据提取的比较键对元素进行排序，支持指定排序顺序。
     *
     * @param keyExtractor 键提取函数
     * @param order        排序顺序（升序/降序）
     * @return 排序后的ListStream
     */
    public <U extends Comparable<? super U>> ListStream<T> sort(
            Function<? super T, ? extends U> keyExtractor,
            Sort order) {
        return sort(keyExtractor, order, Sort.NullLast);
    }

    /**
     * 根据提取的比较键对元素进行排序，支持指定排序顺序和空值位置。
     *
     * @param keyExtractor 键提取函数
     * @param order        排序顺序（升序/降序）
     * @param nullPosition 空值位置（前/后）
     * @return 排序后的ListStream
     */
    public <U extends Comparable<? super U>> ListStream<T> sort(
            Function<? super T, ? extends U> keyExtractor,
            Sort order,
            Sort nullPosition) {
        Objects.requireNonNull(keyExtractor, "keyExtractor cannot be null");
        Objects.requireNonNull(order, "order cannot be null");
        Objects.requireNonNull(nullPosition, "nullPosition cannot be null");

        if (isEmpty()) {
            return this;
        }

        SortStream<T> sortStream = new SortStream<>();

        // 转换为List以进行排序
        List<T> sortedList = toList();

        // 创建比较器
        Comparator<T> comparator = sortStream.createComparator(keyExtractor, order, nullPosition);

        // 执行排序
        sortedList.sort(comparator);

        return of(sortedList);
    }

    /**
     * 根据提取的比较键对元素进行排序，支持多个排序条件。
     *
     * @param streamOperation 可变参数，用于提供多个排序操作
     * @return 排序后的ListStream
     */
    @SafeVarargs
    public final <U extends Comparable<? super U>> ListStream<T> sort(Function<SortStream<T>, Comparator<T>>... streamOperation) {

        if (isEmpty()) {
            return this;
        }

        // 转换为List以进行排序
        List<T> sortedList = toList();

        Comparator<T> comparator = null;
        for (Function<SortStream<T>, Comparator<T>> comparatorFunction : streamOperation) {
            if (comparator == null) {
                comparator = comparatorFunction.apply(new SortStream<>());
            } else {
                comparator = comparator.thenComparing(comparatorFunction.apply(new SortStream<>()));
            }
        }

        // 执行排序
        sortedList.sort(comparator);

        return of(sortedList);
    }

    /**
     * 简化版排序方法 - 升序，空值在最后。
     *
     * @param keyExtractor 键提取函数
     * @return 排序后的ListStream
     */
    public <U extends Comparable<? super U>> ListStream<T> sortAsc(
            Function<? super T, ? extends U> keyExtractor) {
        return sort(keyExtractor, Sort.Asc, Sort.NullLast);
    }

    /**
     * 简化版排序方法 - 降序，空值在最后。
     *
     * @param keyExtractor 键提取函数
     * @return 排序后的ListStream
     */
    public <U extends Comparable<? super U>> ListStream<T> sortDesc(
            Function<? super T, ? extends U> keyExtractor) {
        return sort(keyExtractor, Sort.Desc, Sort.NullLast);
    }

    /**
     * 将嵌套的集合展平成单层集合。
     *
     * @param mapper 将元素转换为Iterable的函数
     * @param <R>    转换后的元素类型
     * @return 新的ListStream
     */
    public <R> ListStream<R> flatMap(Function<? super T, ? extends Iterable<? extends R>> mapper) {
        Objects.requireNonNull(mapper, "mapper cannot be null");

        if (isEmpty()) {
            return of(new ArrayList<>());
        }

        return of(new FlatteningIterable<>(source, mapper));
    }

    /**
     * 在遍历流的过程中对每个元素进行操作，但不修改流内容。
     *
     * @param consumer 用于消费每个元素的操作
     * @return 新的ListStream
     */
    public final ListStream<T> peek(Consumer<T> consumer) {
        return of(() -> new Iterator<>() {
            final Iterator<T> iterator = source.iterator();

            public boolean hasNext() {
                return iterator.hasNext();
            }

            public T next() {
                final T item = iterator.next();
                consumer.accept(item);
                return item;
            }
        });
    }

    /**
     * 执行给定的流操作（peek），用于查看流中的元素。
     *
     * @param streamOperation 对流的操作
     * @return 当前ListStream实例
     */
    public ListStream<T> peekStream(Consumer<ListStream<T>> streamOperation) {
        streamOperation.accept(of(source));
        return this;
    }

    /**
     * 对流中的元素进行归约操作，最终返回一个结果。
     *
     * @param func     初始值的提供者
     * @param consumer 对每个元素应用的归约操作
     * @param <R>      归约结果的类型
     * @return 归约后的结果
     */
    public <R> R reduce(Supplier<R> func, BiConsumer<R, T> consumer) {
        R r = func.get();
        for (T t : source) {
            consumer.accept(r, t);
        }
        return r;
    }

    /**
     * 对流中的元素进行归约操作，首先通过提供的函数转换元素，再应用归约操作。
     *
     * @param supplier 初始值的提供者
     * @param func     元素转换的函数
     * @param consumer 对每个转换后的元素应用的归约操作
     * @param <S>      初始值的类型
     * @param <E>      转换后的元素类型
     * @param <R>      归约结果的类型
     * @return 归约后的结果
     */
    public <S, E, R> R reduce(Supplier<R> supplier, Function<T, E> func, BiConsumer<R, E> consumer) {
        R r = supplier.get();
        for (T t : source) {
            E e = func.apply(t);
            consumer.accept(r, e);
        }
        return r;
    }

    /**
     * 对流中的每个元素执行给定的操作。
     *
     * @param action 操作
     */
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        source.forEach(action);
    }

    /**
     * 将流中的元素分割成多个指定大小的部分，并对每部分执行给定的操作。
     *
     * @param size     每个部分的大小
     * @param consumer 对每部分的操作
     */
    public void split(int size, Consumer<List<T>> consumer) {
        List<List<T>> parts = new ArrayList<>();
        int i = 0;
        List<T> temp = null;
        for (T t : source) {
            if (temp == null || i % size == 0) {
                temp = new ArrayList<>(size);
                parts.add(temp);
            }
            temp.add(t);
            ++i;
        }

        for (List<T> part : parts) {
            consumer.accept(part);
        }
    }

    /**
     * 判断流是否为空。
     *
     * @return 如果为空，返回true；否则返回false
     */
    private boolean isNotEmpty() {
        return !isEmpty();
    }

    /**
     * 判断流是否为空。
     *
     * @return 如果为空，返回true；否则返回false
     */
    public boolean isEmpty() {
        if (source == null) {
            return true;
        }

        // 如果是Collection类型，直接使用isEmpty()方法
        if (source instanceof Collection) {
            return ((Collection<?>) source).isEmpty();
        }

        // 如果是普通Iterable，检查是否有第一个元素
        return !source.iterator().hasNext();
    }

    /**
     * 根据指定的属性进行去重操作。
     *
     * @param keyExtractor 用于提取去重依据的函数
     * @return 去重后的ListStream
     */
    public ListStream<T> distinct(Function<T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return of(createFilteredIterable(elem -> {
            if (seen.contains(keyExtractor.apply(elem))) {
                return false;
            }
            seen.add(keyExtractor.apply(elem));
            return true;
        }));
    }

    /**
     * 对流中的元素进行去重操作（默认去重）。
     *
     * @return 去重后的ListStream
     */
    public ListStream<T> distinct() {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return of(createFilteredIterable(elem -> {
            if (seen.contains(elem)) {
                return false;
            }
            seen.add(elem);
            return true;
        }));
    }

    /**
     * 获取流中元素的数量。
     *
     * @return 流中元素的数量
     */
    public long size() {
        return count();
    }

    /**
     * 计算流中元素的数量。
     *
     * @return 流中元素的数量
     */
    public long count() {
        if (isEmpty()) {
            return 0;
        }
        // 如果是Collection类型，直接返回size
        if (source instanceof Collection) {
            return ((Collection<?>) source).size();
        }
        // 否则遍历计数
        long count = 0;
        for (T ignored : source) {
            count++;
        }
        return count;
    }

    /**
     * 将流中的元素转换成List。
     *
     * @return 包含所有元素的List
     */
    public List<T> toList() {
        // 如果是Collection类型，直接返回size
        if (source instanceof List<T>) {
            return (List<T>) source;
        }
        List<T> result = new ArrayList<>();
        source.forEach(result::add);
        return result;
    }

    /**
     * 将流中的元素转换成Set。
     *
     * @return 包含所有元素的Set
     */
    public Set<T> toSet() {
        // 如果是Collection类型，直接返回size
        if (source instanceof Set<T>) {
            return (Set<T>) source;
        }
        Set<T> result = new HashSet<>();
        source.forEach(result::add);
        return result;
    }

    /**
     * 判断元素是否为空元素
     *
     * @param elem      元素
     * @param functions 用于处理元素的函数数组
     * @return 如果元素为null或者根据给定的函数数组的返回值判断为空，返回true；否则返回false
     */
    private boolean isBlankElement(T elem, Function<T, ?>[] functions) {
        if (functions == null || functions.length == 0) {
            if (elem == null) {
                return true;
            }
            if (elem instanceof CharSequence str) {
                return str.isEmpty() || "".contentEquals(str);
            }
            return false;
        }

        return Arrays.stream(functions).allMatch(fun -> {
            Object value = fun.apply(elem);
            if (value == null) {
                return true;
            }
            if (value instanceof CharSequence str) {
                return str.isEmpty() || "".contentEquals(str);
            }
            return false;
        });
    }

    /**
     * 判断元素是否为非空元素
     *
     * @param elem      元素
     * @param functions 用于处理元素的函数数组
     * @return 如果元素不为空并且根据给定的函数数组的返回值判断不为空，返回true；否则返回false
     */
    private boolean isNotBlankElement(T elem, Function<T, ?>[] functions) {
        if (functions == null || functions.length == 0) {
            if (elem == null) {
                return false;
            }
            if (elem instanceof CharSequence str) {
                return !str.isEmpty() && !"".contentEquals(str);
            }
            return true;
        }

        return Arrays.stream(functions).allMatch(fun -> {
            Object value = fun.apply(elem);
            if (value == null) {
                return false;
            }
            if (value instanceof CharSequence) {
                return !value.toString().isEmpty();
            }
            return true;
        });
    }

    /**
     * 创建一个根据给定过滤条件的可迭代对象
     *
     * @param filterCondition 过滤条件
     * @return 过滤后的元素可迭代对象
     */
    private Iterable<T> createFilteredIterable(Predicate<T> filterCondition) {
        return () -> new Iterator<>() {
            final Iterator<T> iterator = source.iterator();
            T nextElement;
            boolean hasNextComputed = false;
            boolean hasNextResult = false;

            @Override
            public boolean hasNext() {
                if (!hasNextComputed) {
                    computeNext(filterCondition);
                }
                return hasNextResult;
            }

            @Override
            public T next() {
                if (!hasNextComputed) {
                    computeNext(filterCondition);
                }
                if (!hasNextResult) {
                    throw new NoSuchElementException();
                }
                hasNextComputed = false;
                return nextElement;
            }

            private void computeNext(Predicate<T> condition) {
                while (iterator.hasNext()) {
                    T elem = iterator.next();
                    if (condition.test(elem)) {
                        nextElement = elem;
                        hasNextResult = true;
                        hasNextComputed = true;
                        return;
                    }
                }
                hasNextResult = false;
                hasNextComputed = true;
            }
        };
    }
}