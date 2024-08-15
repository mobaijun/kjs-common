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
package com.mobaijun.common.tree;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Description: [结构函数包装器]
 * Author: [mobaijun]
 * Date: [2024/8/15 14:02]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 *
 * @param keyExtractor       节点 key 提取器。
 * @param parentKeyExtractor 父节点 key 提取器。
 * @param childrenSetter     子节点设置器。
 * @param childrenGetter     子节点获取器。
 */
public record TreeFunctionWrapper<T, I>(Function<T, I> keyExtractor, Function<T, I> parentKeyExtractor,
                                        BiConsumer<T, List<T>> childrenSetter, Function<T, List<T>> childrenGetter) {
}
