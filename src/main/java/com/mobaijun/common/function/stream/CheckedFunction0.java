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
package com.mobaijun.common.function.stream;

/**
 * 函数式接口，表示一个可以抛出受检异常的无参操作。
 *
 * <p>该接口用于定义不接受任何输入参数，但可能抛出受检异常的方法。</p>
 *
 * @param <R> 返回值的类型
 */
@FunctionalInterface
public interface CheckedFunction0<R> {

    /**
     * 执行操作并返回结果，允许抛出受检异常。
     *
     * @return 操作的结果
     * @throws Throwable 允许抛出受检异常
     */
    R apply() throws Throwable;
}
