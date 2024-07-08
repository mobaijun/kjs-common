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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: FileLocationType<br>
 * enum description：文件存储位置
 *
 * @author MoBaiJun 2022/5/12 13:18
 */
@Getter
@AllArgsConstructor
public enum FileLocationType {

    /**
     * 阿里云
     */
    ALIYUN(1),

    /**
     * 腾讯云
     */
    TENCENT(2),

    /**
     * minio服务器
     */
    MINIO(3),

    /**
     * 本地
     */
    LOCAL(4),

    /**
     * 数据库中
     */
    DB(5);

    /**
     * 文件存储位置编码
     */
    private final Integer code;
}