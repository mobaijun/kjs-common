package com.mobaijun.common.enums.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [缓存键模式枚举]
 * Author: [mobaijun]
 * Date: [2024/8/12 15:12]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@AllArgsConstructor
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
