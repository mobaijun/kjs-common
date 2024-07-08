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
 * enum name: BucketAuthType<br>
 * enum description：桶的权限策略枚举
 *
 * @author MoBaiJun 2022/5/12 13:18
 */
@Getter
@AllArgsConstructor
public enum BucketAuthType {
    /**
     * 私有的（仅有 owner 可以读写）
     */
    PRIVATE,

    /**
     * 公有读，私有写（ owner 可以读写， 其他客户可以读）
     */
    PUBLIC_READ,

    /**
     * 公共读写（即所有人都可以读写，慎用）
     */
    PUBLIC_READ_WRITE,

    /**
     * 只写 （其他客户端只有写入文件权限，无读取文件权限）
     * <br>
     * 即公有写，私有读（ owner 可以读写， 其他客户可以写）
     */
    MINIO_WRITE_ONLY,
}