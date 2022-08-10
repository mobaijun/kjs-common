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
package com.mobaijun.common.util.collection;

import java.util.HashMap;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: CountMap
 * class description：计数map
 *
 * @author MoBaiJun 2022/5/31 11:35
 */
public class CountMap<KEY> extends HashMap<KEY, Integer> {

    public void increment(KEY key) {
        put(key, get(key) + 1);
    }

    public void increment(KEY key, int step) {
        put(key, get(key) + step);
    }

    @Override
    public Integer get(Object key) {
        Integer integer = super.get(key);
        return integer == null ? 0 : integer;
    }
}