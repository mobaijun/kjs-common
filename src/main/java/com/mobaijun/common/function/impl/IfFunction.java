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
package com.mobaijun.common.function.impl;

import com.mobaijun.common.function.JudgeFunction;

import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: IfFunction
 * class description：代替'if else' 和 'switch'的方法
 *
 * @param <K> 限定的参数类型
 * @author MoBaiJun 2022/9/29 8:34
 */
public class IfFunction<K> {

    /**
     * 通过map保存
     */
    private final Map<K, JudgeFunction> map;

    /**
     * 通过map类型来保存对应的条件key和方法
     *
     * @param map a map
     */
    public IfFunction(Map<K, JudgeFunction> map) {
        this.map = map;
    }

    /**
     * 添加条件
     *
     * @param key      需要验证的条件（key）
     * @param function 要执行的方法
     * @return this.
     */
    public IfFunction<K> add(K key, JudgeFunction function) {
        this.map.put(key, function);
        return this;
    }

    /**
     * 确定key是否存在，如果存在，则执行相应的方法。
     *
     * @param key the key need to verify
     */
    public void doIf(K key) {
        if (this.map.containsKey(key)) {
            map.get(key).invoke();
        }
    }

    /**
     * 确定key是否存在，如果存在，则执行相应的方法。
     * 否则将执行默认方法
     *
     * @param key             需要验证的条件（key）
     * @param defaultFunction 要执行的方法
     */
    public void doIfWithDefault(K key, JudgeFunction defaultFunction) {
        if (this.map.containsKey(key)) {
            map.get(key).invoke();
        } else {
            defaultFunction.invoke();
        }
    }
}