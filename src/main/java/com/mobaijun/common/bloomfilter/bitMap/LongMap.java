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

import java.io.Serializable;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: LongMap<br>
 * class description: 过滤器BitMap在64位机器上.这个类能发生更好的效果.一般机器不建议使用
 *
 * @author MoBaiJun 2023/2/22 0:03
 */
public class LongMap implements BitMap, Serializable {

    private final long[] longs;

    /**
     * 构造
     */
    public LongMap() {
        longs = new long[93750000];
    }

    /**
     * 构造
     *
     * @param size 容量
     */
    public LongMap(int size) {
        longs = new long[size];
    }

    @Override
    public void add(long i) {
        int r = (int) (i / BitMap.MACHINE64);
        long c = i & (BitMap.MACHINE64 - 1);
        longs[r] = longs[r] | (1L << c);
    }

    @Override
    public boolean contains(long i) {
        int r = (int) (i / BitMap.MACHINE64);
        long c = i & (BitMap.MACHINE64 - 1);
        return ((longs[r] >>> c) & 1) == 1;
    }

    @Override
    public void remove(long i) {
        int r = (int) (i / BitMap.MACHINE64);
        long c = i & (BitMap.MACHINE64 - 1);
        longs[r] &= ~(1L << c);
    }
}
