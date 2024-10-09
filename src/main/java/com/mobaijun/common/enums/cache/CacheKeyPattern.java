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

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Description: [缓存键模式枚举]
 * Author: [mobaijun]
 * Date: [2024/8/12 15:12]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@RequiredArgsConstructor
public enum CacheKeyPattern {

    /**
     * 类型-值模式，直接拼接类型和值
     */
    TYPE_VALUE {
        @Override
        public String format(String... args) {
            return String.format("%s%s", args[0], args[1]);
        }
    },

    /**
     * 类型-默认值模式，使用冒号分隔类型和默认值
     */
    TYPE_DEFAULT {
        @Override
        public String format(String... args) {
            return String.format("%s:%s", args[0], args[1]);
        }
    },

    /**
     * 模块-类型-默认值模式，使用冒号分隔模块、类型和默认值
     */
    MODULE_TYPE_DEFAULT {
        @Override
        public String format(String... args) {
            return String.format("%s:%s:%s", args[0], args[1], args[2]);
        }
    };

    /**
     * 格式化缓存键
     *
     * @param args 参数数组
     * @return 格式化后的缓存键
     */
    public abstract String format(String... args);
}
