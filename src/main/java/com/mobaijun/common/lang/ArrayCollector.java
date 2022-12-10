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
package com.mobaijun.common.lang;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: ArrayCollector
 * class description: 数组收集器
 *
 * @author MoBaiJun 2022/12/10 17:24
 */
public class ArrayCollector<R> implements Collector<R, List<R>, R[]> {

    private static final Set<Characteristics> CHARACTERISTICS = Collections.emptySet();

    private final Class<R> elementType;

    /**
     * Constructs a new instance for the given element type.
     *
     * @param elementType The element type.
     */
    public ArrayCollector(final Class<R> elementType) {
        this.elementType = elementType;
    }

    @Override
    public BiConsumer<List<R>, R> accumulator() {
        return List::add;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return CHARACTERISTICS;
    }

    @Override
    public BinaryOperator<List<R>> combiner() {
        return (left, right) -> {
            left.addAll(right);
            return left;
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public Function<List<R>, R[]> finisher() {
        return list -> {
            final R[] array = (R[]) Array.newInstance(elementType, list.size());
            return list.toArray(array);
        };
    }

    @Override
    public Supplier<List<R>> supplier() {
        return ArrayList::new;
    }
}