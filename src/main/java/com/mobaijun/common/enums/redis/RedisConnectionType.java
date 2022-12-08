/*
 * Copyright (C) 2022 www.mobaijun.com
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
package com.mobaijun.common.enums.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: RedisConnectionType<br>
 * enum description: Redis连接方式<br>
 * <p>
 * 包含:standalone-单节点部署方式
 * sentinel-哨兵部署方式
 * cluster-集群方式
 * master slave-主从部署方式
 * </p>
 *
 * @author MoBaiJun 2022/12/8 9:44
 */
@Getter
@AllArgsConstructor
public enum RedisConnectionType {

    /**
     * 单节点部署方式
     */
    STANDALONE("standalone", "单节点部署方式"),

    /**
     * 哨兵部署方式
     */
    SENTINEL("sentinel", "哨兵部署方式"),

    /**
     * 集群部署方式
     */
    CLUSTER("cluster", "集群方式"),

    /**
     * 主从部署方式
     */
    MASTER_SLAVE("master_slave", "主从部署方式");

    private final String connection_type;
    private final String connection_desc;
}