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
package com.mobaijun.common.enums;

import java.util.EnumSet;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: EnumUtils
 * class description： 枚举工具类
 *
 * @author MoBaiJun 2022/7/11 10:00
 */
public class EnumUtils {

    /**
     * 将若干个枚举值转换为long(按bits 1,2,4,8...的方式叠加)，用于使用long保存多个选项的情况.
     */
    public static <E extends Enum<E>> long generateBits(final Class<E> enumClass, final Iterable<? extends E> values) {
        return org.apache.commons.lang3.EnumUtils.generateBitVector(enumClass, values);
    }

    /**
     * 将若干个枚举值转换为long(按bits 1,2,4,8...的方式叠加)，用于使用long保存多个选项的情况.
     */
    @SafeVarargs
    public static <E extends Enum<E>> long generateBits(final Class<E> enumClass, final E... values) {
        return org.apache.commons.lang3.EnumUtils.generateBitVector(enumClass, values);
    }

    /**
     * long重新解析为若干个枚举值，用于使用long保存多个选项的情况.
     */
    public static <E extends Enum<E>> EnumSet<E> processBits(final Class<E> enumClass, final long value) {
        return org.apache.commons.lang3.EnumUtils.processBitVector(enumClass, value);
    }

    /**
     * Enum转换为String
     */
    public static String toString(Enum e) {
        return e.name();
    }

    /**
     * String转换为Enum
     */
    public static <T extends Enum<T>> T fromString(Class<T> enumClass, String value) {
        return Enum.valueOf(enumClass, value);
    }
}