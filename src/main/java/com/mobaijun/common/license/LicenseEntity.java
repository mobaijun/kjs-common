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
package com.mobaijun.common.license;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: LicenseEntity<br>
 * class description: 许可证实体
 *
 * @author MoBaiJun 2023/2/22 0:35
 */
@Getter
@Setter
@ToString
public class LicenseEntity {

    /**
     * 魔数
     */
    public static final byte[] MAGIC_NUM = "kjs-license".getBytes();

    /**
     * 公钥
     */
    private final byte[] publicKeys;

    /**
     * 申请时间
     */
    private final long applyTime = System.currentTimeMillis();

    /**
     * 过期时间
     */
    private final long expireTime;

    /**
     * 申请方
     */
    private String applicant;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 原文
     */
    private transient byte[] data;

    public LicenseEntity(long expireTime, byte[] publicKeys) {
        this.expireTime = expireTime;
        this.publicKeys = publicKeys;
    }
}
