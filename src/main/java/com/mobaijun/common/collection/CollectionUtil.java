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

import com.mobaijun.common.text.StringUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: CollectionUtil<br>
 * 类描述： 集合工具类
 *
 * @author MoBaiJun 2022/4/22 16:16
 */
public class CollectionUtil {

    /**
     * 将以,分隔符分割的字符串转换为 List
     *
     * @param str       待转换的字符串
     * @param separator 分隔符
     * @return List<String>
     */
    public static List<String> splitToList(String str, String separator) {
        if (str == null || separator == null) {
            return null;
        }
        return Arrays.stream(str.split(separator))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }


    /**
     * Adds all elements in the array to the given collection.
     *
     * @param collection the collection to add to, must not be null
     * @param elements   the array of elements to add, must not be null
     * @throws NullPointerException if the collection or array is null
     */
    public static <T> void addAll(Collection<T> collection, T[] elements) {
        collection.addAll(Arrays.asList(elements));
    }

    /**
     * 以 conjunction 为分隔符将集合转换为字符串
     *
     * @param <T>         被处理的集合
     * @param collection  集合
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static <T> String join(Iterable<T> collection, String conjunction) {
        return sb(collection, conjunction);
    }

    private static <T> String sb(Iterable<T> collection, String conjunction) {
        StringBuilder sb = new StringBuilder();
        AtomicBoolean isFirst = new AtomicBoolean(true);
        boolean finalIsFirst = isFirst.get();
        collection.forEach(item -> {
            if (finalIsFirst) {
                isFirst.set(false);
            } else {
                sb.append(conjunction);
            }
            sb.append(item);
        });
        return sb.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     *
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static <T> String join(T[] array, String conjunction) {
        return Arrays.stream(array)
                .map(String::valueOf)
                .collect(Collectors.joining(conjunction));
    }

    /**
     * 将Set排序（根据Entry的值）
     *
     * @param set 被排序的Set
     * @return 排序后的Set
     */
    public static <K, V extends Comparable<? super V>> Set<Entry<K, V>> sortSetByValue(Set<Entry<K, V>> set) {
        return set.stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * 切取部分数据
     *
     * @param stack 原数据
     * @param size  每部分数据的长度
     * @return 切取出的数据或null
     */
    public static <T> List<T> subListFromStack(Stack<T> stack, int size) {
        List<T> list = new ArrayList<>();
        while (size-- > 0 && !stack.empty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 从列表中截取一部分数据
     *
     * @param list   待处理的列表
     * @param offset 开始位置（从0开始计数）
     * @param limit  截取的数量
     * @param <T>    列表中元素的类型
     * @return 截取后的子列表
     */
    public static <T> List<T> subList(List<T> list, int offset, int limit) {
        // 将列表转换为流
        Stream<T> stream = list.stream();
        Optional<Stream<T>> optionalStream = Optional.ofNullable(stream);

        // 跳过offset个元素
        optionalStream = optionalStream.map(s -> s.skip(offset));

        // 取前limit个元素
        optionalStream = optionalStream.map(s -> s.limit(limit));

        // 转换为List并返回
        return optionalStream.map(s -> s.collect(Collectors.toList())).orElse(null);
    }

    /**
     * 新建一个HashMap
     *
     * @param <K> Key
     * @param <V> Value
     * @return HashMap对象
     */
    public static <K, V> Map<K, V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 新建一个HashMap
     *
     * @param size 初始大小，由于默认负载因子0.75，传入的size会实际初始大小为size / 0.75
     * @param <K>  Key
     * @param <V>  Value
     * @return HashMap对象
     */
    public static <K, V> Map<K, V> newHashMap(int size) {
        return new HashMap<>((int) (size / 0.75));
    }

    /**
     * 新建一个ConcurrentHashMap
     *
     * @param <K> Key
     * @param <V> Value
     * @return ConcurrentHashMap对象
     */
    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap<>();
    }

    /**
     * 新建一个ConcurrentHashMap
     *
     * @param size 初始大小，由于默认负载因子0.75，传入的size会实际初始大小为size / 0.75
     * @param <K>  Key
     * @param <V>  Value
     * @return ConcurrentHashMap对象
     */
    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap(int size) {
        return new ConcurrentHashMap<>((int) (size / 0.75));
    }

    /**
     * 创建一个新的HashSet
     *
     * @param <T> 集合元素类型
     * @return HashSet实例
     */
    public static <T> HashSet<T> newHashSet() {
        return new HashSet<>();
    }

    /**
     * 新建一个HashSet
     *
     * @param ts  集合对象
     * @param <T> 集合对象
     * @return HashSet对象
     */
    @SafeVarargs
    public static <T> HashSet<T> newHashSet(T... ts) {
        HashSet<T> set = newHashSet();
        Collections.addAll(set, ts);
        return set;
    }

    /**
     * 新建一个ArrayList
     *
     * @param <T> ArrayList对象
     * @return ArrayList对象
     */
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * 新建一个ArrayList
     *
     * @param values 数据列表
     * @param <T>    ArrayList对象
     * @return ArrayList对象
     */
    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... values) {
        return new ArrayList<>(Arrays.asList(values));
    }

    /**
     * 将新元素添加到已有数组中<br>
     * 添加新元素会生成一个新的数组，不影响原数组
     *
     * @param originalArray 已有数组
     * @param newElement    新元素
     * @return 新数组
     */
    public static <T> T[] addToArray(T[] originalArray, T newElement) {
        return Stream.concat(Arrays.stream(originalArray), Stream.of(newElement))
                .toArray(size -> Arrays.copyOf(originalArray, size));
    }

    /**
     * 生成一个新的重新设置大小的数组
     *
     * @param array       原数组
     * @param newSize     新的数组大小
     * @param elementType 数组元素类型
     * @param <T>         调整后的新数组
     * @return 调整后的新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] resizeArray(T[] array, int newSize, Class<?> elementType) {
        T[] newArray = (T[]) newArray(elementType, newSize);
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        return newArray;
    }


    /**
     * 生成一个新的重新设置大小的数组，新数组的类型为原数组的类型
     *
     * @param array   原数组
     * @param newSize 新的数组大小
     * @param <T>     调整后的新数组
     * @return 调整后的新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] resizeArray(T[] array, int newSize) {
        // 获取原数组的类型
        Class<? extends Object[]> type = array.getClass();

        // 使用反射创建新数组
        T[] newArray = (T[]) Array.newInstance(type.getComponentType(), newSize);

        // 复制原数组元素到新数组中
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        return newArray;
    }

    /**
     * 新建一个空数组
     *
     * @param type   元素类型
     * @param length 大小
     * @param <T>    元素类型
     * @return 空数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<T> type, int length) {
        return (T[]) Array.newInstance(type, length);
    }

    /**
     * 将多个数组合并在一起<br>
     * 忽略null的数组
     *
     * @param arrays 数组集合
     * @param <T>    数组集合
     * @return 合并后的数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] concatArrays(T[]... arrays) {
        return Arrays.stream(arrays)
                .filter(Objects::nonNull)
                .flatMap(Arrays::stream)
                .toArray(size -> (T[]) Array.newInstance(
                        arrays.getClass().getComponentType().getComponentType(), size));
    }

    /**
     * 克隆数组
     *
     * @param array 被克隆的数组
     * @param <T>   被克隆的数组
     * @return 新数组
     */
    public static <T> T[] cloneArray(T[] array) {
        return Arrays.copyOf(array, array.length);
    }

    /**
     * 截取数组的部分
     *
     * @param array      被截取的数组
     * @param startIndex 开始位置（包含）
     * @param endIndex   结束位置（不包含）
     * @param <T>        被截取的数组
     * @return 截取后的数组，当开始位置超过最大时，返回null
     */
    public static <T> T[] subArray(T[] array, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > array.length || startIndex > endIndex) {
            throw new IllegalArgumentException("Invalid startIndex or endIndex");
        }
        return Arrays.copyOfRange(array, startIndex, endIndex);
    }

    /**
     * 映射键值（参考Python的zip()函数）<br>
     * 例如：<br>
     * keys = [a,b,c,d]<br>
     * values = [1,2,3,4]<br>
     * 则得到的Map是 {a=1, b=2, c=3, d=4}<br>
     * 如果两个数组长度不同，则只对应最短部分
     *
     * @param keys   键列表
     * @param values 值列表
     * @param <T>    值列表
     * @param <K>    键列表
     * @return Map
     */
    public static <T, K> Map<T, K> zip(T[] keys, K[] values) {
        if (keys.length == 0 || values.length == 0) {
            return null;
        }

        final int size = Math.min(keys.length, values.length);
        final Map<T, K> map = newHashMap();
        for (int i = 0; i < size; i++) {
            map.put(keys[i], values[i]);
        }

        return map;
    }

    /**
     * 映射键值（参考Python的zip()函数）<br>
     * 例如：<br>
     * keys = a,b,c,d<br>
     * values = 1,2,3,4<br>
     * delimiter = ,
     * 则得到的Map是 {a=1, b=2, c=3, d=4}<br>
     * 如果两个数组长度不同，则只对应最短部分
     *
     * @param keys      键列表
     * @param values    值列表
     * @param delimiter 未定义
     * @return Map
     */
    public static Map<String, String> zip(String keys, String values, String delimiter) {
        return zip(StringUtil.split(keys, delimiter), StringUtil.split(values, delimiter));
    }

    /**
     * 映射键值（参考Python的zip()函数）<br>
     * 例如：<br>
     * keys = [a,b,c,d]<br>
     * values = [1,2,3,4]<br>
     * 则得到的Map是 {a=1, b=2, c=3, d=4}<br>
     * 如果两个数组长度不同，则只对应最短部分
     *
     * @param keys   键列表
     * @param values 值列表
     * @param <T>    键列表
     * @param <K>    值列表
     * @return Map
     */
    public static <T, K> Map<T, K> zip(Collection<T> keys, Collection<K> values) {
        if (keys.isEmpty() || values.isEmpty()) {
            return null;
        }

        final List<T> keyList = new ArrayList<>(keys);
        final List<K> valueList = new ArrayList<>(values);

        final int size = Math.min(keys.size(), values.size());
        final Map<T, K> map = new HashMap<>((int) (size / 0.75));
        for (int i = 0; i < size; i++) {
            map.put(keyList.get(i), valueList.get(i));
        }

        return map;
    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static <T> boolean contains(T[] array, T value) {
        return Arrays.asList(array).contains(value);
    }

    /**
     * 将Entry集合转换为HashMap
     *
     * @param entry entry集合
     * @return Map
     */
    public static <K, V> Map<K, V> toHashMap(Collection<Entry<K, V>> entry) {
        return entry.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    /**
     * 将集合转换为排序后的TreeSet
     *
     * @param collection 集合
     * @param comparator 比较器
     * @param <T>        未定义
     * @return treeSet
     */
    public static <T> TreeSet<T> toTreeSet(Collection<T> collection, Comparator<T> comparator) {
        return collection.stream().collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

    /**
     * 集合排序
     *
     * @param list 集合
     * @return List
     */
    public static <T extends Comparable<? super T>> List<T> sortList(List<T> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // ------------------------------------------------------------------- 基本类型的数组转换为包装类型数组

    /**
     * 将基本类型数组包装为包装类型
     *
     * @param values 基本类型数组
     * @return 包装类型数组
     */
    public static Integer[] wrap(int... values) {
        final int length = values.length;
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装为包装类型
     *
     * @param values 基本类型数组
     * @return 包装类型数组
     */
    public static Long[] wrap(long... values) {
        final int length = values.length;
        Long[] array = new Long[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装为包装类型
     *
     * @param values 基本类型数组
     * @return 包装类型数组
     */
    public static Character[] wrap(char... values) {
        final int length = values.length;
        Character[] array = new Character[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装为包装类型
     *
     * @param values 基本类型数组
     * @return 包装类型数组
     */
    public static Byte[] wrap(byte... values) {
        final int length = values.length;
        Byte[] array = new Byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装为包装类型
     *
     * @param values 基本类型数组
     * @return 包装类型数组
     */
    public static Short[] wrap(short... values) {
        final int length = values.length;
        Short[] array = new Short[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装为包装类型
     *
     * @param values 基本类型数组
     * @return 包装类型数组
     */
    public static Float[] wrap(float... values) {
        final int length = values.length;
        Float[] array = new Float[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装为包装类型
     *
     * @param values 基本类型数组
     * @return 包装类型数组
     */
    public static Double[] wrap(double... values) {
        final int length = values.length;
        Double[] array = new Double[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装为包装类型
     *
     * @param values 基本类型数组
     * @return 包装类型数组
     */
    public static Boolean[] wrap(boolean... values) {
        final int length = values.length;
        Boolean[] array = new Boolean[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 判定给定对象是否为数组类型
     *
     * @param data 对象
     * @return 是否为数组类型
     */
    public static <T> boolean isArray(T data) {
        return data != null && data.getClass().isArray();
    }

    /**
     * 比较两个集合元素是否相同
     *
     * @param collection1 集合1
     * @param collection2 集合2
     * @return true：集合元素相同；false：集合元素不同
     */
    public static <T> boolean isEqualCollection(Collection<T> collection1, Collection<T> collection2) {
        if (collection1 == collection2) {
            return true;
        }

        if (collection1 == null || collection2 == null || collection1.size() != collection2.size()) {
            return false;
        }

        return collection2.containsAll(collection1) && collection1.containsAll(collection2);
    }

    /**
     * 对集合按照指定长度分段，每一个段为单独的集合，返回这个集合的列表
     *
     * @param list 集合
     * @param size 每个段的长度
     * @return 分段列表
     */
    public static <T> List<List<T>> partition(List<T> list, int size) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }

        return IntStream.range(0, (list.size() + size - 1) / size)
                .mapToObj(i -> list.subList(i * size, Math.min((i + 1) * size, list.size())))
                .collect(Collectors.toList());
    }

    /**
     * 返回无序集合中的最小值，使用元素默认排序
     */
    public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll) {
        return Collections.min(coll);
    }

    /**
     * 返回无序集合中的最大值，使用元素默认排序
     */
    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
        return Collections.max(coll);
    }

    /**
     * 将单个对象转化为集合
     *
     * @param e   对象实例
     * @param <E> 对象类型
     * @return 包含对象的集合实例
     */
    public static <E> List<E> toCol(E e) {
        return toCol(e, ArrayList::new);
    }

    /**
     * 将单个对象转化为集合
     *
     * @param t        对象实例
     * @param supplier 集合工厂
     * @param <E>      对象类型
     * @param <C>      集合类型
     * @return 包含对象的集合实例
     */
    public static <E, C extends List<E>> List<E> toCol(E t, Supplier<C> supplier) {
        if (t == null) {
            return newArrayList();
        }
        return Stream.of(t).collect(Collectors.toCollection(supplier));
    }

    /**
     * 取出集合中第一个元素
     *
     * @param collection 集合实例
     * @param <E>        集合中元素类型
     * @return 泛型类型
     */
    public static <E> E toObj(Collection<E> collection) {
        // 处理集合空指针异常
        Collection<E> coll = Optional.ofNullable(collection).orElseGet(ArrayList::new);
        // 此处可以对流进行排序，然后取出第一个元素
        return coll.stream().findFirst().orElse(null);
    }

    /**
     * 以指定列为排序规则 获取排序列最大值所对应的对象
     *
     * @param data   集合实例
     * @param column 比较排序列
     * @param <E>    集合中元素泛型
     * @return 最大的元素对象
     */
    public static <E> E max(Collection<E> data, ToIntFunction<? super E> column) {
        if (data == null) {
            return null;
        }
        return data.stream().max(Comparator.comparingInt(column)).orElse(null);
    }

    /**
     * @param data   集合实例
     * @param column 比较排序列
     * @param <E>    集合中元素泛型
     * @param <U>    排序列对应的对象泛型 如果是非基础数据类型 需要实现{@code Comparable}
     * @return 最大的元素对象
     */
    public static <E, U extends Comparable<? super U>> E max(Collection<E> data, Function<? super E, ? extends U> column) {
        if (data == null) {
            return null;
        }
        return data.stream().max(Comparator.comparing(column)).orElse(null);
    }

    /**
     * @param data       集合实例
     * @param comparator 比较排序列
     * @param <E>        集合中元素泛型
     * @return 最小的元素对象
     */
    public static <E> E max(Collection<E> data, Comparator<? super E> comparator) {
        if (data == null) {
            return null;
        }
        return data.stream().max(comparator).orElse(null);
    }

    /**
     * 以指定列为排序规则 获取最小元素的对象
     *
     * @param data   集合实例
     * @param column 比较排序列
     * @param <E>    集合元素泛型
     * @return 最小的元素对象
     */
    public static <E> E min(Collection<E> data, ToIntFunction<? super E> column) {
        if (data == null) {
            return null;
        }
        return data.stream().min(Comparator.comparingInt(column)).orElse(null);
    }

    /**
     * @param data   集合实例
     * @param column 比较排序列
     * @param <E>    集合中元素泛型
     * @param <U>    排序列对应的对象泛型 如果是非基础数据类型 需要实现{@code Comparable}
     * @return 最小的元素对象
     */
    public static <E, U extends Comparable<? super U>> E min(Collection<E> data, Function<? super E, ? extends U> column) {
        if (data == null) {
            return null;
        }
        return data.stream().min(Comparator.comparing(column)).orElse(null);
    }

    /**
     * @param data       集合实例
     * @param comparator 比较排序列
     * @param <E>        集合中元素泛型
     * @return 最小的元素对象
     */
    public static <E> E min(Collection<E> data, Comparator<? super E> comparator) {
        if (data == null) {
            return null;
        }
        return data.stream().min(comparator).orElse(null);
    }
}