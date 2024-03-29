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
package com.mobaijun.common.function;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * interface name: VoidMethod<br>
 * interface description：无返回值
 *
 * @author MoBaiJun 2022/9/2 14:14
 */
@FunctionalInterface
public interface VoidMethod {

    /**
     * 只执行 无返回值
     */
    void run();
}