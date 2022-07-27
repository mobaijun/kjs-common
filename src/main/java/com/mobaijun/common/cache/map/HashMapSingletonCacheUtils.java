package com.mobaijun.common.cache.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: HashMapSingletonCacheUtils
 * class description： hash map 单例缓存工具类
 *
 * @author MoBaiJun 2022/7/11 16:56
 */
@SuppressWarnings("all")
public class HashMapSingletonCacheUtils {

    private static volatile HashMapSingletonCacheUtils cacheSingletonUtil;
    private static ConcurrentHashMap<String, Object> CACHE_SINGLETON_MAP = new ConcurrentHashMap<>(Double.SIZE);

    private HashMapSingletonCacheUtils() {
        CACHE_SINGLETON_MAP = new ConcurrentHashMap<>();
    }

    /**
     * 懒汉式单例模式
     * 单例模式有两种类型
     * 懒汉式：在真正需要使用对象时才去创建该单例类对象
     * 饿汉式：在类加载时已经创建好该单例对象，等待被程序使用
     *
     * @return HashMapSingletonCacheUtils
     */
    public static HashMapSingletonCacheUtils getInstance() {
        // 线程A和线程B同时看到cacheSingletonUtil = null，如果不为null，则直接返回cacheSingletonUtil
        if (cacheSingletonUtil == null) {
            // 线程A或线程B获得该锁进行初始化
            synchronized (HashMapSingletonCacheUtils.class) {
                // 其中一个线程进入该分支，另外一个线程则不会进入该分支
                if (cacheSingletonUtil == null) {
                    cacheSingletonUtil = new HashMapSingletonCacheUtils();
                }
            }
        }
        return cacheSingletonUtil;
    }

    /**
     * 添加到内存
     */
    public void addCacheData(String key, Object obj) {
        CACHE_SINGLETON_MAP.put(key, obj);
    }

    /**
     * 从内存中取出
     */
    public <T> T getCacheData(String key) {
        return (T) CACHE_SINGLETON_MAP.get(key);
    }

    /**
     * 从内存中清除
     */
    public void removeCacheData(String key) {
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
    public <K, V> ConcurrentHashMap<K, V> getAll() {
        ConcurrentHashMap<K, V> hashMap = new ConcurrentHashMap<>(Double.SIZE);
        // 获取所有缓存数据
        CACHE_SINGLETON_MAP.keySet().forEach(k -> hashMap.put((K) k, (V) CACHE_SINGLETON_MAP.get(k)));
        return (ConcurrentHashMap<K, V>) hashMap;
    }
}
