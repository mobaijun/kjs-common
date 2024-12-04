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
package com.mobaijun.common.collection.functional;

import java.util.Iterator;
import java.util.function.Function;

/**
 * 用于实现扁平化迭代的内部类。
 * 该类通过提供一个映射函数，将每个元素转换为一个可迭代的集合，从而实现扁平化的迭代过程。
 *
 * @param <T> 源元素类型
 * @param <R> 扁平化后的元素类型
 */
public class FlatteningIterable<T, R> implements Iterable<R> {

    /**
     * 源元素的可迭代对象
     */
    private final Iterable<? extends T> source;

    /**
     * 用于映射每个元素到一个可迭代集合的函数
     */
    private final Function<? super T, ? extends Iterable<? extends R>> mapper;

    /**
     * 构造方法，初始化源集合和映射函数。
     *
     * @param source 源集合
     * @param mapper 用于将源集合的每个元素转换为可迭代集合的函数
     */
    public FlatteningIterable(Iterable<? extends T> source,
                              Function<? super T, ? extends Iterable<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    /**
     * 返回一个扁平化的迭代器。
     *
     * @return 扁平化迭代器
     */
    @Override
    public Iterator<R> iterator() {
        return new FlatteningIterator<>(source.iterator(), mapper);
    }
}