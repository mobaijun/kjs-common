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
package com.mobaijun.common.collection.diff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 表示两个集合之间的差异，包括添加、删除和更新的项，支持不同类型的元素。
 *
 * @param <T> 旧集合中元素的类型
 * @param <R> 新集合中元素的类型
 */
@Data
@Accessors(chain = true)
public class Diff2<T, R> {

    /**
     * 新增的元素列表
     */
    private List<R> addList;

    /**
     * 删除的元素列表
     */
    private List<T> delList;

    /**
     * 已存在的对象集合对应的新值
     */
    private Map<T, R> updateMap;

    /**
     * 获取所有发生变化的元素列表，包括新增和未变更的元素。
     *
     * @return 包含新增元素和更新后的元素的列表
     */
    public List<Object> getEffectList() {
        final List<Object> list = new ArrayList<>(addList);
        list.addAll(getExistsList());
        return list;
    }

    /**
     * 执行传入的 {@link BiConsumer} 操作，针对新增的元素列表。
     *
     * @param biConsumer {@link BiConsumer} 操作，接收 Diff2 对象和新增的元素列表
     * @return 当前的 Diff2 实例，以支持链式调用
     */
    public Diff2<T, R> addConsumer(BiConsumer<Diff2<T, R>, List<R>> biConsumer) {
        if (isNotEmpty(addList)) {
            biConsumer.accept(this, addList);
        }
        return this;
    }

    /**
     * 执行传入的 {@link BiConsumer} 操作，针对删除的元素列表。
     *
     * @param biConsumer {@link BiConsumer} 操作，接收 Diff2 对象和删除的元素列表
     * @return 当前的 Diff2 实例，以支持链式调用
     */
    public Diff2<T, R> delConsumer(BiConsumer<Diff2<T, R>, List<T>> biConsumer) {
        if (isNotEmpty(delList)) {
            biConsumer.accept(this, delList);
        }
        return this;
    }

    /**
     * 执行传入的 {@link BiConsumer} 操作，针对已有的元素列表。
     *
     * @param biConsumer {@link BiConsumer} 操作，接收 Diff2 对象和已有的元素列表
     * @return 当前的 Diff2 实例，以支持链式调用
     */
    public Diff2<T, R> existsConsumer(BiConsumer<Diff2<T, R>, List<T>> biConsumer) {
        final List<T> existsList = getExistsList();
        if (isNotEmpty(existsList)) {
            biConsumer.accept(this, existsList);
        }
        return this;
    }

    /**
     * 执行传入的 {@link BiConsumer} 操作，针对更新的元素。
     *
     * @param biConsumer {@link BiConsumer} 操作，接收 Diff2 对象和更新的元素 Map
     * @return 当前的 Diff2 实例，以支持链式调用
     */
    public Diff2<T, R> updateConsumer(BiConsumer<Diff2<T, R>, Map<T, R>> biConsumer) {
        if (updateMap != null && !updateMap.isEmpty()) {
            biConsumer.accept(this, updateMap);
        }
        return this;
    }

    /**
     * 执行传入的 {@link BiConsumer} 操作，遍历更新元素的键和值。
     *
     * @param biConsumer {@link BiConsumer} 操作，接收更新前的元素（键）和更新后的元素（值）
     * @return 当前的 Diff2 实例，以支持链式调用
     */
    public Diff2<T, R> forEachUpdateMapConsumer(BiConsumer<T, R> biConsumer) {
        if (updateMap != null && !updateMap.isEmpty()) {
            for (Map.Entry<T, R> entry : updateMap.entrySet()) {
                final T oldPo = entry.getKey();
                final R newPo = entry.getValue();
                biConsumer.accept(oldPo, newPo);
            }
        }
        return this;
    }

    /**
     * 判断列表是否为空。
     *
     * @param list 要检查的列表
     * @return 如果列表不为空，返回 {@code true}，否则返回 {@code false}
     */
    private <X> boolean isNotEmpty(List<X> list) {
        return list != null && !list.isEmpty();
    }

    /**
     * 获取所有更新元素的键（旧值）。
     *
     * @return 更新元素的键列表
     */
    public List<T> getExistsList() {
        return getUpdateMapKeys();
    }

    /**
     * 获取更新元素的键（旧值）的列表。
     *
     * @return 更新元素的键列表
     */
    public List<T> getUpdateMapKeys() {
        return new ArrayList<>(updateMap.keySet());
    }

    /**
     * 获取更新元素的值（新值）的列表。
     *
     * @return 更新元素的值列表
     */
    public List<R> getUpdateMapValues() {
        return new ArrayList<>(updateMap.values());
    }
}