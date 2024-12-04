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

import com.mobaijun.common.enums.comm.Sort;
import java.util.Comparator;
import java.util.function.Function;

/**
 * 封装排序操作的类，提供根据键提取函数、排序方向和空值位置来创建比较器。
 *
 * @param <T> 排序对象的类型
 */
public final class SortStream<T> {

    /**
     * 根据提供的键提取函数、排序方向（升序或降序）以及空值位置（空值排前或排后），
     * 创建一个用于排序的比较器。
     *
     * @param <U>          排序键的类型，必须实现 {@link Comparable}
     * @param keyExtractor 提取排序键的函数
     * @param order        排序方向（升序或降序）
     * @param nullPosition 排序时空值的位置（空值排前或排后）
     * @return 基于提供参数的 {@link Comparator} 实例
     * @throws IllegalArgumentException 如果 `order` 或 `nullPosition` 参数无效
     */
    public <U extends Comparable<? super U>> Comparator<T> createComparator(
            Function<? super T, ? extends U> keyExtractor,
            Sort order,
            Sort nullPosition) {

        // 验证 order 参数
        validateSortParameters(order, nullPosition);

        // 基础比较器，使用提取的排序键进行比较
        return (o1, o2) -> {
            U key1 = keyExtractor.apply(o1);
            U key2 = keyExtractor.apply(o2);

            // 处理空值情况
            if (key1 == null && key2 == null) {
                return 0;
            }
            if (key1 == null) {
                return nullPosition == Sort.NullFirst ? -1 : 1;
            }
            if (key2 == null) {
                return nullPosition == Sort.NullFirst ? 1 : -1;
            }

            // 正常比较
            int comparison = key1.compareTo(key2);
            return order == Sort.Asc ? comparison : -comparison;
        };
    }

    /**
     * 验证排序参数是否合法。
     *
     * @param order        排序方向
     * @param nullPosition 空值位置
     * @throws IllegalArgumentException 如果参数无效
     */
    private void validateSortParameters(Sort order, Sort nullPosition) {
        // 验证 order 参数
        if (order != Sort.Asc && order != Sort.Desc) {
            throw new IllegalArgumentException("order must be either Asc or Desc");
        }

        // 验证 nullPosition 参数
        if (nullPosition != Sort.NullFirst && nullPosition != Sort.NullLast) {
            throw new IllegalArgumentException("nullPosition must be either NullFirst or NullLast");
        }
    }
}