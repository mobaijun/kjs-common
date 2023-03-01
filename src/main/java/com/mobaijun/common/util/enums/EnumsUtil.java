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
package com.mobaijun.common.util.enums;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: EnumsUtils<br>
 * class description: 增强枚举工具类
 *
 * @author MoBaiJun 2022/11/23 21:01
 */
public final class EnumsUtil {

    /**
     * 获取枚举类中指定名称的枚举值
     *
     * @param clazz 枚举类
     * @param name  枚举名称
     * @return 枚举值，如果不存在则返回 null
     */
    public static <T extends Enum<T>> T getEnumByName(Class<T> clazz, String name) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.name().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * 获取枚举类中指定属性值的枚举值
     *
     * @param clazz        枚举类
     * @param propertyName 属性名称
     * @param value        属性值
     * @return 枚举值，如果不存在则返回 null
     */
    public static <T extends Enum<T>> T getEnumByProperty(Class<T> clazz, String propertyName, Object value) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> getPropertyValue(e, propertyName).equals(value))
                .findFirst()
                .orElse(null);
    }

    /**
     * 获取枚举类中所有枚举值指定属性的值集合
     *
     * @param clazz        枚举类
     * @param propertyName 属性名称
     * @return 属性值集合
     */
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>, V> Set<V> getPropertyValues(Class<T> clazz, String propertyName) {
        return (Set<V>) Arrays.stream(clazz.getEnumConstants())
                .map(e -> getPropertyValue(e, propertyName))
                .collect(Collectors.toSet());
    }

    /**
     * 获取枚举值指定属性的值
     *
     * @param enumValue    枚举值
     * @param propertyName 属性名称
     * @return 属性值
     */
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>, V> V getPropertyValue(T enumValue, String propertyName) {
        try {
            Field field = enumValue.getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            return (V) field.get(enumValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通用方法获取枚举key或者value
     *
     * @param enumClass 枚举实例
     * @param isKey     是否获取key，true为获取key，false为获取value(默认智能获取key，无法获取value，如需要获取value，请在枚举添加getvalue方法后重新封装此方法)
     * @param <T>       枚举类型
     * @return key或者value，如果枚举实例为null则返回null
     */
    public static <T extends Enum<T>> List<String> getEnumValues(Class<T> enumClass, boolean isKey) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(e -> isKey ? e.name() : e.toString())
                .collect(Collectors.toList());
    }
}
