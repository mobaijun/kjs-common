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
package com.mobaijun.common.cache;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: HashMapSingletonCacheUtils<br>
 * class description： hash map 单例缓存工具类
 *
 * @author MoBaiJun 2022/7/11 16:56
 */
public class HashMapSingletonCacheUtils {

    private static volatile HashMapSingletonCacheUtils INSTANCE;
    private static ConcurrentHashMap<String, Object> CACHE_SINGLETON_MAP;

    private HashMapSingletonCacheUtils() {
        CACHE_SINGLETON_MAP = new ConcurrentHashMap<>(Double.SIZE);
    }

    /**
     * 单例模式，懒汉式
     *
     * @return HashMapSingletonCacheUtils
     */
    public static synchronized HashMapSingletonCacheUtils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HashMapSingletonCacheUtils();
        }
        return INSTANCE;
    }

    /**
     * 添加到内存
     */
    public <T> void add(String key, T data) {
        CACHE_SINGLETON_MAP.put(key, data);
    }

    /**
     * 获取缓存值
     *
     * @param key 缓存 key
     * @return 缓存值，如果 key 不存在则返回 Optional.empty()
     */
    public <T> Optional<T> get(String key) {
        @SuppressWarnings("unchecked")
        T data = (T) CACHE_SINGLETON_MAP.get(key);
        return Optional.ofNullable(data);
    }

    /**
     * 从内存中清除
     */
    public void remove(String key) {
        CACHE_SINGLETON_MAP.remove(key);
    }

    /**
     * 检查是否存在在key
     *
     * @param key 键名称
     * @return true 或 false
     */
    public boolean contains(String key) {
        return CACHE_SINGLETON_MAP.containsKey(key);
    }

    /**
     * 清空缓存
     */
    public void removeAll() {
        CACHE_SINGLETON_MAP.clear();
    }

    /**
     * 获取所有缓存
     *
     * @return 集合对象
     */
    @SuppressWarnings("unchecked")
    public <K, V> ConcurrentHashMap<K, V> getAll() {
        ConcurrentHashMap<K, V> hashMap = new ConcurrentHashMap<>(Double.SIZE);
        // 获取所有缓存数据
        CACHE_SINGLETON_MAP.keySet().forEach(k -> hashMap.put((K) k, (V) CACHE_SINGLETON_MAP.get(k)));
        return hashMap;
    }
}