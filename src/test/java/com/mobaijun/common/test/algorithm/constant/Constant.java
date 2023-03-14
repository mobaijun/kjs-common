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
package com.mobaijun.common.test.algorithm.constant;

import com.mobaijun.common.constant.NumberConstant;
import com.mobaijun.common.util.number.RandomUtil;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: Constant<br>
 * class description: 通用常量
 *
 * @author MoBaiJun 2023/2/20 0:17
 */
public final class Constant {

    /**
     * 通用随机数
     */
    public static final int[] RANDOM_INT_ARRAY = RandomUtil.generateRandomArray(100000, 1, 100000);

    /**
     * 随机字符串
     */
    public static final String CONSTANT_STRING = RandomUtil.randomString(NumberConstant.BASE_CHAR, 24);
}
