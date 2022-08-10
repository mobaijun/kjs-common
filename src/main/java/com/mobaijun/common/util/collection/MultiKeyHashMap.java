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

import java.util.HashMap;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: MultiKeyHashMap
 * class description：可以映射多个key到一个value的HashMap实现
 *
 * @author MoBaiJun 2022/5/31 11:34
 */
public class MultiKeyHashMap<K, V> extends HashMap<K, V> {

    /**
     * 通过多个key来获取值，返回不为空的key值
     */
    public V get(Object key1, Object key2) {
        V v = super.get(key1);
        if (v != null) {
            return v;
        }
        return super.get(key2);
    }

    /**
     * 通过多个key来获取值，返回不为空的key值
     *
     * @param key1 key1
     * @param key2 key2
     * @param keys 键
     */
    @SafeVarargs
    public final <T> V get(T key1, T key2, T... keys) {
        V v = super.get(key1);
        if (v != null) {
            return v;
        }
        v = super.get(key2);
        if (v != null) {
            return v;
        }
        if (keys != null) {
            for (Object key : keys) {
                v = super.get(key);
                if (v != null) {
                    return v;
                }
            }
        }
        return null;
    }


    public V put(K key, K key2, V value) {
        super.put(key, value);
        return super.put(key2, value);
    }

    @SafeVarargs
    public final V putValue(V value, K key, K... keys) {
        V v = super.put(key, value);
        if (keys != null) {
            for (K k : keys) {
                super.put(k, value);
            }
        }
        return v;
    }
}