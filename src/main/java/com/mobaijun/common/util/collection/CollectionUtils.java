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

import cn.hutool.core.util.StrUtil;
import com.mobaijun.common.constant.StringConstant;
import com.mobaijun.common.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: CollectionUtil<br>
 * 类描述： 集合工具类
 *
 * @author MoBaiJun 2022/4/22 16:16
 */
public class CollectionUtils {

    /**
     * 判断单列集合是否为 null
     *
     * @param collection collection
     * @param <T>        未定义
     * @return boolean
     */
    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断 map 是否为 null
     *
     * @param <K>  未定义
     * @param <V>  未定义
     * @param data map集合数据
     * @return boolean
     */
    public static <K, V> boolean isEmpty(Map<K, V> data) {
        return data == null || data.isEmpty();
    }

    /**
     * 判断数组是空数组
     *
     * @param array 待判断的数据
     * @return true：空 / false：非空
     */
    public static boolean isEmpty(String[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组不是空数组
     *
     * @param array 待判断的数据
     * @return true：非空 / false：空
     */
    public static boolean isNotEmpty(String[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断list是否为 null
     *
     * @param data 集合对象
     * @param <T>  泛型参数
     * @return boolean
     */
    public static <T> boolean isNull(List<T> data) {
        return isEmpty(data);
    }

    /**
     * 判断Set集合是否为null
     *
     * @param data 集合对象
     * @param <T>  泛型参数
     * @return boolean
     */
    public static <T> boolean isNull(Set<T> data) {
        return isEmpty(data);
    }

    /**
     * 判断 map 是否为 null
     *
     * @param data 集合对象
     * @param <K>  未定义参数
     * @param <V>  未定义参数
     * @return boolean
     */
    public static <K, V> boolean isNull(Map<K, V> data) {
        return isEmpty(data);
    }


    /**
     * 将以“,”分隔的字符串转成为Collection
     *
     * @param str String
     * @return Collection
     */
    public static Collection<? extends Serializable> stringToCollection(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        } else {
            String[] strArray = str.split(StringConstant.COMMA);
            final Long[] longs = new Long[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                longs[i] = strToLong(strArray[i], 0L);
            }
            return arrayToCollection(longs);
        }
    }

    /**
     * 将字组转换成Collection
     *
     * @param longArray Long[]
     * @return Collection
     */
    public static Collection<? extends Serializable> arrayToCollection(Long[] longArray) {
        Collection<? extends Serializable> collection = newArrayList();
        CollectionUtils.addAll(Collections.singleton(collection), longArray);
        return collection;
    }


    /**
     * Adds all elements in the array to the given collection.
     *
     * @param collection the collection to add to, must not be null
     * @param elements   the array of elements to add, must not be null
     * @throws NullPointerException if the collection or array is null
     */
    public static void addAll(Collection<Object> collection, Object[] elements) {
        collection.addAll(Arrays.asList(elements));
    }

    /**
     * 字符串转换为 long
     *
     * @param str          字符串
     * @param defaultValue 默认
     * @return long
     */
    public static long strToLong(final String str, final long defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(str);
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * 字符串转换为long
     *
     * @param str          字符串
     * @param defaultValue 默认
     * @return long
     */
    public static long objectToLong(final Object str, final long defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(String.valueOf(str));
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
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
     * @param <T>         被处理的集合
     * @param array       数组
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static <T> String join(T[] array, String conjunction) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (T item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * 将Set排序（根据Entry的值）
     *
     * @param set 被排序的Set
     * @return 排序后的Set
     */
    public static List<Entry<Long, Long>> sortEntrySetToList(Set<Entry<Long, Long>> set) {
        List<Entry<Long, Long>> list = new LinkedList<>(set);
        list.sort(Entry.comparingByValue());
        return list;
    }

    /**
     * 切取部分数据
     *
     * @param <T>            集合元素类型
     * @param surplusAlaData 原数据
     * @param partSize       每部分数据的长度
     * @return 切取出的数据或null
     */
    public static <T> List<T> popPart(Stack<T> surplusAlaData, int partSize) {
        if (surplusAlaData == null || surplusAlaData.size() == 0) {
            return null;
        }

        final List<T> currentAlaData = newArrayList();
        int size = surplusAlaData.size();
        // 切割
        if (size > partSize) {
            for (int i = 0; i < partSize; i++) {
                currentAlaData.add(surplusAlaData.pop());
            }
        } else {
            for (int i = 0; i < size; i++) {
                currentAlaData.add(surplusAlaData.pop());
            }
        }
        return currentAlaData;
    }

    /**
     * 新建一个HashMap
     *
     * @param <T> 未定义
     * @param <K> 未定义
     * @return HashMap对象
     */
    public static <T, K> HashMap<T, K> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 新建一个ConcurrentHashMap
     *
     * @param <T> 未定义
     * @param <K> 未定义
     * @return ConcurrentHashMap对象
     */
    public static <T, K> ConcurrentHashMap<T, K> newConcurrentHashMap() {
        return new ConcurrentHashMap<>();
    }

    /**
     * 新建一个ConcurrentHashMap
     *
     * @param size 初始大小，由于默认负载因子0.75，传入的size会实际初始大小为size / 0.75
     * @param <T>  未定义
     * @param <K>  未定义
     * @return ConcurrentHashMap对象
     */
    public static <T, K> ConcurrentHashMap<T, K> newConcurrentHashMap(int size) {
        return new ConcurrentHashMap<>((int) (size / 0.75));
    }

    /**
     * 新建一个HashMap
     *
     * @param size 初始大小，由于默认负载因子0.75，传入的size会实际初始大小为size / 0.75
     * @param <T>  未定义
     * @param <K>  未定义
     * @return HashMap对象
     */
    public static <T, K> HashMap<T, K> newHashMap(int size) {
        return new HashMap<>((int) (size / 0.75));
    }

    /**
     * 新建一个HashSet
     *
     * @param <T> 未定义
     * @return 新建一个HashSet
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
        HashSet<T> set = new HashSet<>();
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
     * @param buffer     已有数组
     * @param newElement 新元素
     * @param <T>        新数组
     * @return 新数组
     */
    public static <T> T[] append(T[] buffer, T newElement) {
        T[] t = resize(buffer, buffer.length + 1, newElement.getClass());
        t[buffer.length] = newElement;
        return t;
    }

    /**
     * 生成一个新的重新设置大小的数组
     *
     * @param buffer        原数组
     * @param newSize       新的数组大小
     * @param componentType 数组元素类型
     * @param <T>           调整后的新数组
     * @return 调整后的新数组
     */
    public static <T> T[] resize(T[] buffer, int newSize, Class<?> componentType) {
        T[] newArray = newArray(componentType, newSize);
        System.arraycopy(buffer, 0, newArray, 0, Math.min(buffer.length, newSize));
        return newArray;
    }

    /**
     * 生成一个新的重新设置大小的数组，新数组的类型为原数组的类型
     *
     * @param buffer  原数组
     * @param newSize 新的数组大小
     * @param <T>     调整后的新数组
     * @return 调整后的新数组
     */
    public static <T> T[] resize(T[] buffer, int newSize) {
        return resize(buffer, newSize, buffer.getClass().getComponentType());
    }

    /**
     * 新建一个空数组
     *
     * @param componentType 元素类型
     * @param newSize       大小
     * @param <T>           元素类型
     * @return 空数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<?> componentType, int newSize) {
        return (T[]) Array.newInstance(componentType, newSize);
    }

    /**
     * 将多个数组合并在一起<br>
     * 忽略null的数组
     *
     * @param arrays 数组集合
     * @param <T>    数组集合
     * @return 合并后的数组
     */
    @SafeVarargs
    public static <T> T[] addAll(T[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }

        int length = 0;
        for (T[] array : arrays) {
            if (array == null) {
                continue;
            }
            length += array.length;
        }
        T[] result = newArray(arrays.getClass().getComponentType().getComponentType(), length);

        length = 0;
        for (T[] array : arrays) {
            if (array == null) {
                continue;
            }
            System.arraycopy(array, 0, result, length, array.length);
            length += array.length;
        }
        return result;
    }

    /**
     * 克隆数组
     *
     * @param array 被克隆的数组
     * @param <T>   被克隆的数组
     * @return 新数组
     */
    public static <T> T[] clone(T[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    /**
     * 生成一个数字列表<br>
     * 自动判定正序反序
     *
     * @param excludedEnd 结束的数字（不包含）
     * @return 数字列表
     */
    public static int[] range(int excludedEnd) {
        return range(0, excludedEnd, 1);
    }

    /**
     * 生成一个数字列表<br>
     * 自动判定正序反序
     *
     * @param includedStart 开始的数字（包含）
     * @param excludedEnd   结束的数字（不包含）
     * @return 数字列表
     */
    public static int[] range(int includedStart, int excludedEnd) {
        return range(includedStart, excludedEnd, 1);
    }

    /**
     * 生成一个数字列表<br>
     * 自动判定正序反序
     *
     * @param includedStart 开始的数字（包含）
     * @param excludedEnd   结束的数字（不包含）
     * @param step          步进
     * @return 数字列表
     */
    public static int[] range(int includedStart, int excludedEnd, int step) {
        if (includedStart > excludedEnd) {
            int tmp = includedStart;
            includedStart = excludedEnd;
            excludedEnd = tmp;
        }

        if (step <= 0) {
            step = 1;
        }

        int deviation = excludedEnd - includedStart;
        int length = deviation / step;
        if (deviation % step != 0) {
            length += 1;
        }
        int[] range = new int[length];
        for (int i = 0; i < length; i++) {
            range[i] = includedStart;
            includedStart += step;
        }
        return range;
    }

    /**
     * 截取数组的部分
     *
     * @param list  被截取的数组
     * @param start 开始位置（包含）
     * @param end   结束位置（不包含）
     * @param <T>   被截取的数组
     * @return 截取后的数组，当开始位置超过最大时，返回null
     */
    public static <T> List<T> sub(List<T> list, int start, int end) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        if (start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }

        final int size = list.size();
        if (end > size) {
            if (start >= size) {
                return null;
            }
            end = size;
        }

        return list.subList(start, end);
    }

    /**
     * 截取集合的部分
     *
     * @param list  被截取的数组
     * @param start 开始位置（包含）
     * @param end   结束位置（不包含）
     * @param <T>   被截取的数组
     * @return 截取后的数组，当开始位置超过最大时，返回null
     */
    public static <T> List<T> sub(Collection<T> list, int start, int end) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        return sub(new ArrayList<>(list), start, end);
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @param <T>   数组
     * @return 是否为空
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @param <T>   数组
     * @return 是否为非空
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }


    /**
     * Map是否为非空
     *
     * @param map 集合
     * @param <V> 值列表
     * @param <K> 键列表
     * @return 是否为非空
     */
    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
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
        if (isEmpty(keys) || isEmpty(values)) {
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
        return zip(StrUtil.split(keys, delimiter), StrUtil.split(values, delimiter));
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
        if (isEmpty(keys) || isEmpty(values)) {
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
     * @param <T>   未定义
     * @return 是否包含
     */
    public static <T> boolean contains(T[] array, T value) {
        final Class<?> componentType = array.getClass().getComponentType();
        boolean isPrimitive = false;
        if (null != componentType) {
            isPrimitive = componentType.isPrimitive();
        }
        for (T t : array) {
            if (t == value) {
                return true;
            } else if (!isPrimitive && null != value && value.equals(t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将Entry集合转换为HashMap
     *
     * @param entryCollection entry集合
     * @param <T>             未定义
     * @param <K>             未定义
     * @return Map
     */
    public static <T, K> HashMap<T, K> toMap(Collection<Entry<T, K>> entryCollection) {
        HashMap<T, K> map = newHashMap();
        for (Entry<T, K> entry : entryCollection) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
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
        final TreeSet<T> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(collection);
        return treeSet;
    }

    /**
     * 排序集合
     *
     * @param collection 集合
     * @param comparator 比较器
     * @param <T>        未定义
     * @return treeSet
     */
    public static <T> List<T> sort(Collection<T> collection, Comparator<T> comparator) {
        List<T> list = new ArrayList<>(collection);
        list.sort(comparator);
        return list;
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
     * @param obj 对象
     * @return 是否为数组类型
     */
    public static boolean isArray(Object obj) {
        return obj.getClass().isArray();
    }

    /**
     * 数组或集合转 String
     *
     * @param obj 集合或数组对象
     * @return 数组字符串，与集合转字符串格式相同
     */
    public static String toString(Object obj) {
        if (null == obj) {
            return null;
        }
        if (isArray(obj)) {
            try {
                return Arrays.deepToString((Object[]) obj);
            } catch (Exception e) {
                final String className = obj.getClass().getComponentType().getName();
                switch (className) {
                    case "long":
                        return Arrays.toString((long[]) obj);
                    case "int":
                        return Arrays.toString((int[]) obj);
                    case "short":
                        return Arrays.toString((short[]) obj);
                    case "char":
                        return Arrays.toString((char[]) obj);
                    case "byte":
                        return Arrays.toString((byte[]) obj);
                    case "boolean":
                        return Arrays.toString((boolean[]) obj);
                    case "float":
                        return Arrays.toString((float[]) obj);
                    case "double":
                        return Arrays.toString((double[]) obj);
                    default:
                        throw new ClassCastException(e.getMessage());
                }
            }
        }
        return obj.toString();
    }

    /**
     * 比较连个集合元素是否相同
     *
     * @param listA 集合a
     * @param listB 集合b
     * @return true false
     */
    public static boolean isListEquals(List<?> listA, List<?> listB) {
        if (listA == null && listB == null) {
            return true;
        }
        if (listA == null) {
            return false;
        }
        if (listB == null) {
            return false;
        }
        if (listA.size() == listB.size()) {
            if (listA.size() == 0) {
                return true;
            }
            for (Object temp : listA) {
                if (!listB.contains(temp)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 对集合按照指定长度分段，每一个段为单独的集合，返回这个集合的列表
     *
     * @param <T>        集合元素类型
     * @param collection 集合
     * @param size       每个段的长度
     * @return 分段列表
     */
    public static <T> List<List<T>> split(Collection<T> collection, int size) {
        final List<List<T>> result = newArrayList();
        if (isEmpty(collection)) {
            return result;
        }

        ArrayList<T> subList = new ArrayList<>(size);
        for (T t : collection) {
            if (subList.size() >= size) {
                result.add(subList);
                subList = new ArrayList<>(size);
            }
            subList.add(t);
        }
        result.add(subList);
        return result;
    }

    /**
     * 取得Collection的第一个元素，如果collection为空返回null.
     */
    public static <T> T getFirst(Collection<T> collection) {
        if (isEmpty(collection)) {
            return null;
        }
        if (collection instanceof List) {
            return ((List<T>) collection).get(0);
        }
        return collection.iterator().next();
    }

    /**
     * 返回无序集合中的最小值，使用元素默认排序
     */
    public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll) {
        return Collections.min(coll);
    }

    /**
     * 返回无序集合中的最小值
     */
    public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp) {
        return Collections.min(coll, comp);
    }

    /**
     * 返回无序集合中的最大值，使用元素默认排序
     */
    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
        return Collections.max(coll);
    }

    /**
     * 返回无序集合中的最大值
     */
    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
        return Collections.max(coll, comp);
    }
}