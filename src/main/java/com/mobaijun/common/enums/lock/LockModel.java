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
package com.mobaijun.common.enums.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [锁的类型]
 * Author: [mobaijun]
 * Date: [2024/7/8 15:33]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */

@Getter
@AllArgsConstructor
public enum LockModel {

    /**
     * 可重入锁
     */
    REENTRANT,

    /**
     * 公平锁
     */
    FAIR,

    /**
     * 联锁(可以把一组锁当作一个锁来加锁和释放)
     */
    MULTIPLE,

    /**
     * 红锁
     */
    REDLOCK,

    /**
     * 读锁
     */
    READ,

    /**
     * 写锁
     */
    WRITE,

    /**
     * 自动模式,当参数只有一个.使用 REENTRANT 参数多个 REDLOCK
     */
    AUTO
}
