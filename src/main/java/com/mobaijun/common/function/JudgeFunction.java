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
package com.mobaijun.common.function;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * interface name: judgeFunction<br>
 * interface description：公共判断方法<br>
 *
 * @author MoBaiJun 2022/9/29 8:24
 */
@FunctionalInterface
public interface JudgeFunction {

    /**
     * 要做的事情
     */
    void invoke();
}