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
package com.mobaijun.common.bloomfilter.bitMap;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * interface name: BitMap<br>
 * interface description: BitMap接口，用于将某个int或long值映射到一个数组中，从而判定某个值是否存在
 *
 * @author MoBaiJun 2023/2/22 0:01
 */
public interface BitMap {

    int MACHINE32 = 32;

    int MACHINE64 = 64;

    /**
     * 加入值
     *
     * @param i 值
     */
    void add(long i);

    /**
     * 检查是否包含值
     *
     * @param i 值
     * @return 是否包含
     */
    boolean contains(long i);

    /**
     * 移除值
     *
     * @param i 值
     */
    void remove(long i);
}
