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
package com.mobaijun.common.test.lambda;

import com.mobaijun.common.lambda.LambdaExceptionUtil;
import com.mobaijun.common.lambda.LambdaExceptionUtil.BiConsumerWithExceptions;
import com.mobaijun.common.lambda.LambdaExceptionUtil.BiFunctionWithExceptions;
import com.mobaijun.common.lambda.LambdaExceptionUtil.ConsumerWithExceptions;
import com.mobaijun.common.lambda.LambdaExceptionUtil.FunctionWithExceptions;
import com.mobaijun.common.lambda.LambdaExceptionUtil.SupplierWithExceptions;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: LambdaExceptionUtilTest
 * class description: lambda 方法测试
 *
 * @author MoBaiJun 2022/11/22 14:33
 */
public class LambdaExceptionUtilTest {

    @Test
    public void testWrapFunction() {
        Function<Integer, String> function = i -> Integer.toString(i);
        FunctionWithExceptions<Integer, String, Exception> functionWithExceptions = i -> Integer.toString(i);
        Function<Integer, String> wrappedFunction = LambdaExceptionUtil.wrapFunction(functionWithExceptions);
        assertEquals(wrappedFunction.apply(123), function.apply(123));
        Assert.assertThrows(Exception.class, () -> wrappedFunction.apply(null));
    }

    @Test
    public void testWrapBiFunction() {
        BiFunction<Integer, Double, String> biFunction = (i, d) -> Integer.toString(i) + d;
        BiFunctionWithExceptions<Integer, Double, String, Exception> biFunctionWithExceptions = (i, d) -> i + Double.toString(d);
        BiFunction<Integer, Double, String> wrappedBiFunction = LambdaExceptionUtil.wrapBiFunction(biFunctionWithExceptions);
        assertEquals(wrappedBiFunction.apply(123, 4.56), biFunction.apply(123, 4.56));
        Assert.assertThrows(Exception.class, () -> wrappedBiFunction.apply(null, 4.56));
    }

    @Test
    public void testWrapConsumer() {
        ConsumerWithExceptions<String, Exception> consumerWithExceptions = System.out::println;
        Consumer<String> wrappedConsumer = LambdaExceptionUtil.wrapConsumer(consumerWithExceptions);
        wrappedConsumer.accept("hello world");
        assertThrows(Exception.class, () -> wrappedConsumer.accept(null));
    }

    @Test
    public void testWrapBiConsumer() {
        BiConsumerWithExceptions<String, Integer, Exception> biConsumerWithExceptions = (s, i) -> System.out.println(s + i);
        BiConsumer<String, Integer> wrappedBiConsumer = LambdaExceptionUtil.wrapBiConsumer(biConsumerWithExceptions);
        wrappedBiConsumer.accept("hello world ", 123);
        assertThrows(Exception.class, () -> wrappedBiConsumer.accept(null, 123));
    }

    @Test
    public void testWrapSupplier() {
        Supplier<String> supplier = () -> "hello world";
        SupplierWithExceptions<String, Exception> supplierWithExceptions = () -> "hello world";
        Supplier<String> wrappedSupplier = LambdaExceptionUtil.wrapSupplier(supplierWithExceptions);
        assertEquals(wrappedSupplier.get(), supplier.get());
        assertThrows(Exception.class, wrappedSupplier::get);
    }
}
