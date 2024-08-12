package com.mobaijun.common.enums.cache;

/**
 * Description: [
 * 缓存键生成器
 * <p>
 * 提供根据不同的模式生成缓存键的功能。
 * ]
 * Author: [mobaijun]
 * Date: [2024/8/12 15:12]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class CacheKeyGenerator {

    /**
     * 根据指定的模式生成缓存键
     *
     * @param pattern 缓存键模式
     * @param args    用于生成缓存键的参数
     * @return 生成的缓存键
     */
    public static String getValue(CacheKeyPattern pattern, String... args) {
        return pattern.format(args);
    }
}

