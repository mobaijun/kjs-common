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
package com.mobaijun.common.enums.comm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: RouteRepositoryType<br>
 * enum description: 路由存储枚举
 *
 * @author MoBaiJun 2022/12/5 8:59
 */
@Getter
@RequiredArgsConstructor
public enum RouteRepositoryType {

    /**
     * 磁盘
     */
    DISK,

    /**
     * MySQL
     */
    MYSQL,

    /**
     * 云
     */
    CLOUD,

    /**
     * EUREKA
     */
    EUREKA,

    /**
     * NA_COS
     */
    NA_COS,

    /**
     * ORACLE
     */
    ORACLE
}