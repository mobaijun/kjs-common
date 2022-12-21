package com.mobaijun.common.test.cache;

import com.mobaijun.common.cache.HashMapSingletonCacheUtils;
import com.mobaijun.common.util.PrintUtil;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: HashMapSingletonCacheUtilsTest
 * class description: 单例缓存
 *
 * @author MoBaiJun 2022/11/22 14:13
 */
public class HashMapSingletonCacheUtilsTest {
    public static void main(String[] args) {
        HashMapSingletonCacheUtils instance = HashMapSingletonCacheUtils.getInstance();
        instance.addCacheData("name", "mobaijun");
        PrintUtil.println(instance.getAll());
        PrintUtil.println(instance.contains("name"));

        String name = instance.getCacheData("name");
        PrintUtil.println(name);

        instance.removeCacheData("name");
        instance.removeAll();
    }
}
