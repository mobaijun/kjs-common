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
package com.mobaijun.common.enums.file;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [文件类型枚举]
 * Author: [mobaijun]
 * Date: [2024/5/6 17:45]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@AllArgsConstructor
public enum FileType {

    /**
     * JPG图片格式
     */
    JPG(".jpg", "JPG"),

    /**
     * PNG图片格式
     */
    PNG(".png", "PNG"),

    /**
     * GIF图片格式
     */
    GIF(".gif", "GIF"),

    /**
     * ICO图标格式
     */
    ICO(".ico", "ICO"),

    /**
     * WEBP图片格式
     */
    WEBP(".webp", "WEBP"),

    /**
     * JPE图片格式
     */
    JPE(".jpe", "JPE"),

    /**
     * BMP图片格式
     */
    BMP(".bmp", "BMP"),

    /**
     * TXT文本文件格式
     */
    TXT(".txt", "TXT"),

    /**
     * SQL文件后缀
     */
    SQL(".sql", "SQL"),

    /**
     * Java文件
     */
    JAVA(".java", "JAVA"),

    /**
     * 临时文件后缀
     */
    TEMP(".temp", "临时文件");

    /**
     * 名称
     */
    private final String name;

    /**
     * 后缀描述
     */
    private final String desc;

    /**
     * 构建后缀到枚举值的映射
     */
    private static final Map<String, FileType> BY_NAME = new HashMap<>();

    static {
        for (FileType fileType : values()) {
            BY_NAME.put(fileType.name, fileType);
        }
    }

    /**
     * 根据文件后缀获取枚举值
     *
     * @param name 文件后缀
     * @return 对应的枚举值，如果不存在则返回null
     */
    public static FileType byName(String name) {
        return BY_NAME.get(name.toLowerCase());
    }
}
