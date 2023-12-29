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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: ListUtils<br>
 * class description: list 工具类
 *
 * @author MoBaiJun 2022/11/23 9:42
 */
public class ListUtil {

    /**
     * 将 Map 数组添加到现有 List 集合中。
     *
     * @param list 现有的 List 集合
     * @param maps 要添加的 Map 数组
     * @param <K>  键的类型
     * @param <V>  值的类型
     */
    @SafeVarargs
    public static <K, V> void addAllMapsToList(List<Map<K, V>> list, Map<K, V>... maps) {
        list.addAll(Arrays.stream(maps)
                .filter(Objects::nonNull)
                .toList());
    }


    /**
     * 执行全外连接操作，将两个排序列表的结果合并，包括两个列表中未匹配的元素。
     *
     * @param left       第一个排序列表。
     * @param right      第二个排序列表。left 和 right 的排序顺序必须基本兼容，并由比较器参数所尊重。
     * @param comparator 用于比较左列表和右列表项目的比较器。
     *                   返回负整数表示左项小于右项，返回0表示相等，返回正整数表示右项大于左项。
     * @param combiner   用于组合 T 的实例和 U 的实例，并生成一个新的 R 的组合器。
     *                   在全外连接中，T 或 U 可能为 null，因此组合器需要能够创建一个带有一个参数为 null 的 R。
     * @return 包含全外连接结果的 List<R>，按照原始列表的排序顺序排序。
     */
    public static <T, U, R> List<R> fullOuterJoin(
            List<T> left, List<U> right,
            BiFunction<T, U, Integer> comparator, BiFunction<T, U, R> combiner) {

        List<R> result = new LinkedList<>();
        Iterator<T> leftIterator = left.iterator();
        Iterator<U> rightIterator = right.iterator();

        Supplier<Optional<U>> rightItemSupplier = () -> rightIterator.hasNext() ? Optional.of(rightIterator.next()) : Optional.empty();
        Optional<U> rightItem = rightItemSupplier.get();

        while (leftIterator.hasNext()) {
            T leftItem = leftIterator.next();

            while (rightItem.isPresent() && comparator.apply(leftItem, rightItem.get()) > 0) {
                result.add(combiner.apply(null, rightItem.get()));
                rightItem = rightItemSupplier.get();
            }

            if (rightItem.isPresent() && comparator.apply(leftItem, rightItem.get()) == 0) {
                result.add(combiner.apply(leftItem, rightItem.get()));
                rightItem = rightItemSupplier.get();
            } else {
                result.add(combiner.apply(leftItem, null));
            }
        }

        while (rightItem.isPresent()) {
            result.add(combiner.apply(null, rightItem.get()));
            rightItem = rightItemSupplier.get();
        }

        return result;
    }

    /**
     * 给定两个列表，返回仅存在于其中一个列表中的元素的列表，即对称差集。具体来说，返回两个列表的差集（list1 - list2）和（list2 - list1）的并集。
     *
     * @param <E>   泛型类型
     * @param list1 第一个列表
     * @param list2 另一个列表
     * @return 包含两个列表差集的列表
     * 如果 list1 为 null 或为空，则返回 list2；
     * 如果 list2 为 null 或为空，则返回 list1；
     * 如果两个列表都为空，则返回一个空列表。
     */
    public static <E> List<E> getListDiff(List<E> list1, List<E> list2) {
        if (list1 == null || list1.isEmpty()) {
            return list2 == null || list2.isEmpty() ? new ArrayList<>() : list2;
        }

        if (list2 == null || list2.isEmpty()) {
            return list1 == null || list1.isEmpty() ? new ArrayList<>() : list1;
        }

        // 使用 Set 处理差集和交集
        Set<E> diffSet = new HashSet<>(list1);
        Set<E> setOfCommonElements = new HashSet<>(list2);

        // 求并集
        diffSet.addAll(list2);

        // 求交集
        setOfCommonElements.retainAll(list1);

        // 求差集
        diffSet.removeAll(setOfCommonElements);

        // 转换为 ArrayList 并返回结果
        return new ArrayList<>(diffSet);
    }

    /**
     * 获取指定索引位置周围的子列表。
     *
     * @param <T>    列表元素的类型
     * @param list   原始列表
     * @param index  子列表的中心索引
     * @param offset 索引的偏移量，表示从中心索引向左和向右延伸的元素数量
     * @return 子列表，从索引 (index - offset) 到索引 (index + offset) 结束
     * 如果列表为 null 或为空，则返回原始列表
     */
    public static <T> List<T> subList(List<T> list, int index, int offset) {
        if (list == null || list.isEmpty()) {
            return list;
        }

        // 计算子列表的起始和结束索引，确保在有效范围内
        int start = Math.max(0, index - offset);
        int end = Math.min(list.size(), index + offset + 1);

        // 返回子列表
        return list.subList(start, end);
    }
}