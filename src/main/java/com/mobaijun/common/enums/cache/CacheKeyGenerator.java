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

