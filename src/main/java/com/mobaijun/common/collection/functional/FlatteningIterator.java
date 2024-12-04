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

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * 用于实现扁平化迭代的迭代器，将嵌套的集合展平成单层集合。
 *
 * <p>该迭代器将会遍历一个由嵌套集合组成的源集合（`sourceIterator`），并根据提供的映射函数，
 * 将每个元素映射为一个集合，然后展平这些嵌套的集合。</p>
 *
 * @param <T> 源集合中元素的类型
 * @param <R> 扁平化后元素的类型
 */
public class FlatteningIterator<T, R> implements Iterator<R> {

    /**
     * 源集合的迭代器。
     */
    private final Iterator<? extends T> sourceIterator;

    /**
     * 映射函数，将每个元素转换为一个可迭代的集合。
     */
    private final Function<? super T, ? extends Iterable<? extends R>> mapper;

    /**
     * 当前迭代器。
     */
    private Iterator<? extends R> currentIterator;

    /**
     * 是否已经计算过是否有下一个元素。
     */
    private boolean hasNextComputed;

    /**
     * 是否有下一个元素。
     */
    private boolean hasNextResult;

    /**
     * 构造方法，初始化源迭代器和映射函数。
     *
     * @param sourceIterator 源集合的迭代器
     * @param mapper         映射函数，将每个元素转换为一个可迭代的集合
     */
    public FlatteningIterator(Iterator<? extends T> sourceIterator,
                              Function<? super T, ? extends Iterable<? extends R>> mapper) {
        this.sourceIterator = sourceIterator;
        this.mapper = mapper;
        this.currentIterator = Collections.emptyIterator();
    }

    /**
     * 判断是否还有下一个元素。如果当前的元素已经消费完毕，尝试获取下一个元素。
     *
     * @return 如果有下一个元素，返回 {@code true}，否则返回 {@code false}
     */
    @Override
    public boolean hasNext() {
        if (!hasNextComputed) {
            computeNext();
        }
        return hasNextResult;
    }

    /**
     * 获取下一个元素。
     *
     * @return 下一个元素
     * @throws NoSuchElementException 如果没有下一个元素
     */
    @Override
    public R next() {
        if (!hasNextComputed) {
            computeNext();
        }
        if (!hasNextResult) {
            throw new NoSuchElementException();
        }
        hasNextComputed = false;
        return currentIterator.next();
    }

    /**
     * 计算下一个可用元素。遍历源集合中的每个元素，并使用映射函数获取其对应的集合，
     * 然后继续从该集合中取元素，直到找到一个可用的元素。
     */
    private void computeNext() {
        while (!currentIterator.hasNext() && sourceIterator.hasNext()) {
            T nextElement = sourceIterator.next();
            if (nextElement != null) {
                Iterable<? extends R> nextIterable = mapper.apply(nextElement);
                if (nextIterable != null) {
                    currentIterator = nextIterable.iterator();
                }
            }
        }
        hasNextResult = currentIterator.hasNext();
        hasNextComputed = true;
    }
}