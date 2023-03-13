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
package com.mobaijun.common.idcreator;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: SnowflakeIdGenerator<br>
 * class description: SnowflakeIdGenerator id生成器
 * <p>
 * 基于Snowflake的ID生成器
 * ID长度64位，结构如下:
 * <p>
 * +--------+-----------------+---------------+-------------+------------+
 * |  1bit  |      41bit      |     5bit      |   7bit      |   10bit    |
 * +--------+-----------------+---------------+-------------+------------+
 * |  sign  | delta timestamp |  data center  | machine id  |  sequence  |
 * +--------+-----------------+---------------+-------------+------------+
 * <p>
 * 各段含义如下：
 * ----------------------------------------------------------------------------
 * |      sign      |  1位  |  符号位  |  取值为0，保证id值不为负                  |
 * ----------------------------------------------------------------------------
 * |    timestamp   |  41位 |  时间戳  |  当前时间与开始时间的时间戳差              |
 * ----------------------------------------------------------------------------
 * |   data center  |  5位  | 数据中心 |  0~31,最多32个数据中心                   |
 * ----------------------------------------------------------------------------
 * |    machine id  |  7位  | 机器标识 |  0~127，每个数据中心最多可以部署128台机器   |
 * ----------------------------------------------------------------------------
 * |    sequence    |  10位 | 序列计数 |  每个机器同一毫秒内最多可以产生1024个id号   |
 * ----------------------------------------------------------------------------
 * <p>
 * 注意：
 * timestamp 取值不是当前的时间戳，而是当前时间与开始时间的时间戳差，开始时间一般设置为系统开始使用时间。
 * 从开始时间，此id生成器可以保证69年内不产生重复id。((1L<<41)/(365*24*60*60*1000)=69)
 * <p>
 * 理论上，每台机器1秒最多产生1024*1000(100w)个id
 * <p>
 * 实测结果如下：
 * 机器: 2021款 code 01
 * CPU: AMD Ryzen 7 4800H with Radeon Graphics 2.90 GHz
 * 内存: 64GB / 3200MHZ / DDR4
 * MAX: 90w
 * MIN: 72w
 * AVG: 91w
 * </p>
 *
 * @author MoBaiJun 2023/2/21 23:34
 */
public class SnowflakeIdGenerator {

    /**
     * 计时起始点 1989-10-11 08:00:00.000
     * <p>
     * After 69 years, where are u and where am I?
     * Would u still remember me over that long time ...
     */
    private static final long START = 624067200000L;

    /**
     * Data Center 位数
     */
    private static final long DATACENTER_BIT_COUNT = 5;

    /**
     * Machine id 位数
     */
    private static final long MACHINE_ID_BIT_COUNT = 7;

    /**
     * 最大机器ID
     * <p>
     * 机器ID不能超过此值
     */
    private static final long MAX_MACHINE_ID = ~(-1L << MACHINE_ID_BIT_COUNT);

    /**
     * 最大数据中心ID
     * <p>
     * 数据中心ID不能超过此值
     */
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_BIT_COUNT);

    /**
     * 序列位数
     */
    private static final long SEQUENCE_BIT_COUNT = 10;

    private static final long TIMESTAMP_LEFT_SHIFT =
            DATACENTER_BIT_COUNT + MACHINE_ID_BIT_COUNT + SEQUENCE_BIT_COUNT;

    private static final long DATA_CENTER_SHIFT = MACHINE_ID_BIT_COUNT + SEQUENCE_BIT_COUNT;

    private static final long MACHINE_ID_SHIFT = SEQUENCE_BIT_COUNT;

    /**
     * 序列的位板
     */
    private static final int SEQUENCE_MASK = ~(-1 << SEQUENCE_BIT_COUNT);
    public final long dataCenterID;
    public final long machineId;
    private final long dataCenterTag;
    private final long machineIdTag;
    /**
     * 当前序列值
     */
    private int cursor = 0;
    /**
     * 最后一次请求时间戳
     */
    private volatile long lastTimestamp = -1L;

    public SnowflakeIdGenerator(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATACENTER_ID || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format(
                    "data center Id can't be greater than %d or less than 0", MAX_DATACENTER_ID));
        }
        if (machineId > MAX_MACHINE_ID || machineId < 0) {
            throw new IllegalArgumentException(String
                    .format("machine Id can't be greater than %d or less than 0", MAX_MACHINE_ID));
        }
        this.dataCenterID = dataCenterId;
        this.machineId = machineId;
        dataCenterTag = dataCenterId << DATA_CENTER_SHIFT;
        machineIdTag = machineId << MACHINE_ID_SHIFT;
    }

    private static long tilNextMillis(long currentTimeMillis) {
        long timestamp = System.currentTimeMillis() - START;
        while (timestamp <= currentTimeMillis) {
            timestamp = System.currentTimeMillis() - START;
        }
        return timestamp;
    }

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis() - START;
        //校验时间，如果时间被回拨，1秒内可以等待
        //超过1秒，生成失败
        if (timestamp < lastTimestamp) {
            if (lastTimestamp - timestamp < 3000) {
                //1秒以内，暂停进行矫正
                timestamp = tilNextMillis(lastTimestamp);
            } else {
                throw new RuntimeException(String.format(
                        "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                        lastTimestamp - timestamp));
            }
        }
        if (lastTimestamp == timestamp) {
            cursor = (cursor + 1) & SEQUENCE_MASK;
            if (cursor == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            cursor = 0;
        }
        lastTimestamp = timestamp;
        return (timestamp << TIMESTAMP_LEFT_SHIFT) | dataCenterTag | machineIdTag | cursor;
    }
}
