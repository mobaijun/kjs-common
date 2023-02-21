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
 * class name: IntMap<br>
 * class description: 过滤器BitMap在32位机器上.这个类能发生更好的效果.一般情况下建议使用此类
 *
 * @author MoBaiJun 2023/2/22 0:01
 */
public class IntMap implements BitMap, Serializable {

    private final int[] ints;

    /**
     * 构造
     */
    public IntMap() {
        ints = new int[93750000];
    }

    /**
     * 构造
     *
     * @param size 容量
     */
    public IntMap(int size) {
        ints = new int[size];
    }

    @Override
    public void add(long i) {
        int r = (int) (i / BitMap.MACHINE32);
        int c = (int) (i & (BitMap.MACHINE32 - 1));
        ints[r] = ints[r] | (1 << c);
    }

    @Override
    public boolean contains(long i) {
        int r = (int) (i / BitMap.MACHINE32);
        int c = (int) (i & (BitMap.MACHINE32 - 1));
        return ((ints[r] >>> c) & 1) == 1;
    }

    @Override
    public void remove(long i) {
        int r = (int) (i / BitMap.MACHINE32);
        int c = (int) (i & (BitMap.MACHINE32 - 1));
        ints[r] &= ~(1 << c);
    }
}
