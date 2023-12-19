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
package com.mobaijun.common.function.impl;

import com.mobaijun.common.function.JudgeFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: IfFunction<br>
 * class description：代替 'if else' 和 'switch' 的条件执行方法类
 *
 * @param <K> 限定的参数类型
 * @author MoBaiJun 2022/9/29 8:34
 */
public class IfFunction<K> {

    /**
     * 保存条件(key)与对应方法的映射关系
     */
    private final Map<K, JudgeFunction> map;

    /**
     * 构造函数，初始化条件与方法的映射关系
     *
     * @param map 条件与方法的映射关系
     */
    public IfFunction(Map<K, JudgeFunction> map) {
        // 使用浅复制以确保构造函数参数 map 的不可变性
        this.map = new HashMap<>(map);
    }

    /**
     * 添加条件与方法的映射关系
     *
     * @param key      需要验证的条件（key）
     * @param function 要执行的方法
     * @return 返回当前 IfFunction 实例，支持链式调用
     */
    public IfFunction<K> add(K key, JudgeFunction function) {
        // 添加条件与方法的映射关系
        this.map.put(key, function);
        return this;
    }

    /**
     * 根据条件执行对应的方法
     *
     * @param key 需要验证的条件（key）
     */
    public void doIf(K key) {
        // 如果条件存在，执行相应方法
        Optional.ofNullable(map.get(key))
                .ifPresent(JudgeFunction::invoke);
    }

    /**
     * 根据条件执行对应的方法，如果条件不存在，则执行默认方法
     *
     * @param key             需要验证的条件（key）
     * @param defaultFunction 默认方法
     */
    public void doIf(K key, JudgeFunction defaultFunction) {
        // 如果条件存在，执行相应方法，否则执行默认方法
        Optional.ofNullable(map.getOrDefault(key, defaultFunction))
                .ifPresent(JudgeFunction::invoke);
    }
}