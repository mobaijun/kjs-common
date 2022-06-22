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
     * @return {@link V}
     */
    public V get(Object key1, Object key2, Object... keys) {
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
