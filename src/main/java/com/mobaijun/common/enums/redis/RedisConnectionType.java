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
