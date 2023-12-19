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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: ListUtils<br>
 * class description: list 工具类
 *
 * @author MoBaiJun 2022/11/23 9:42
 */
public class ListUtil {

    /**
     * map 数组添加到 list
     *
     * @param list list集合
     * @param maps map集合
     * @param <K>  键
     * @param <V>  值
     * @return list 集合
     */
    @SafeVarargs
    public static <K, V> List<Map<K, V>> addMapsToList(List<Map<K, V>> list, Map<K, V>... maps) {
        return Stream.of(maps)
                .filter(Objects::nonNull)
                .peek(list::add)
                .collect(Collectors.toList());
    }

    /**
     * 执行全外连接操作，将两个排序列表（left 和 right）的结果合并，包括两个列表中未匹配的元素。
     *
     * @param left       第一个列表，必须是排序的。
     * @param right      第二个列表，必须是排序的。left 和 right 的排序顺序必须基本兼容，并由比较器参数所尊重。
     * @param comparator 一个函数，用于比较左列表（T）的项目和右列表（U）的项目。
     *                   如果左项小于右项，则返回负整数；如果它们相等，则返回0；如果右项大于左项，则返回正整数。
     * @param combiner   一个函数，接受 T 的实例和 U 的实例，并生成一个新的 R。
     *                   在全外连接中，T 或 U 可能为 null，因此组合器需要能够创建一个带有一个参数为 null 的 R。
     * @param <T>        左列表元素的类型
     * @param <U>        右列表元素的类型
     * @param <R>        结果列表元素的类型
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
}