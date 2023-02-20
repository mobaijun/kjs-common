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
package com.mobaijun.common.test.function;

import com.mobaijun.common.collection.CollectionUtil;
import com.mobaijun.common.function.VoidMethod;
import com.mobaijun.common.function.impl.IfFunction;
import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: FunctionTest
 * class description: lambda 方法测试
 *
 * @author MoBaiJun 2022/11/22 14:33
 */
public class FunctionTest {

    @Test
    public void functionTest() {
        VoidMethod voidMethod = FunctionTest::start;

        IfFunction<String> ifFunction = new IfFunction<>(CollectionUtil.newHashMap(10));
        // 定义好要判断的条件和对应执行的方法
        ifFunction.add("1", () -> System.out.println("苹果"))
                .add("2", () -> System.out.println("西瓜"))
                .add("3", () -> System.out.println("橙子"));

        // 要进入的条件
        ifFunction.doIf("3");
        // 执行默认方法
        ifFunction.doIfWithDefault("4", () -> System.out.println("默认方法"));
    }

    private static void start() {
        System.out.println("true = " + true);
    }
}
