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
package com.mobaijun.common.util.converter;

import com.mobaijun.common.collection.CollectionUtil;
import com.mobaijun.common.lang.ArrayCollector;
import com.mobaijun.common.util.reflect.ReflectUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: EntityUtil
 * class description: 对象转换器
 * <p>{@code EntityUtils}工具类用于基于Lambda表达式实现类型转换，具有如下优点：</p>
 * <p>1. 实现对象转对象；集合转集合；分页对象转分页对象</p>
 * <p>2. 实体类转Vo、实体类转DTO等都能应用此工具类</p>
 * <p>3. 转换参数均为不可变类型，业务更加安全</p>
 *
 * @author MoBaiJun 2022/12/10 17:26
 */
public class EntityUtil {

    private EntityUtil() {
    }

    /**
     * 将对象集合按照一定规则映射后收集为另一种形式的集合
     *
     * @param <R>       最终结果的泛型
     * @param <S>       原始集合元素的类泛型
     * @param <T>       转换后元素的中间状态泛型
     * @param <A>       最终结果收集器泛型
     * @param source    最原始的集合实例
     * @param action    转换规则
     * @param collector 收集器的类型
     * @return 变换后存储新元素的集合实例
     */
    public static <R, S, T, A> R collectCommon(final Collection<S> source, Function<? super S, ? extends T> action, Collector<? super T, A, R> collector) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(collector);
        return source.stream().map(action).collect(collector);
    }

    /**
     * 将对象集合按照一定规则映射后收集为另一种形式的集合
     *
     * @param <S>    原始集合元素的类泛型
     * @param <T>    转换后元素的中间状态泛型
     * @param source 最原始的集合实例
     * @param action 转换规则
     * @return 变换后存储新元素的集合实例
     */
    @SafeVarargs
    public static <S, T> Set<T> collectSet(Function<? super S, ? extends T> action, final S... source) {
        Objects.requireNonNull(source);
        return collectSet(Arrays.asList(source), action);
    }


    /**
     * 将对象集合按照一定规则映射后收集为另一种形式的集合
     *
     * @param <S>    原始集合元素的类泛型
     * @param <T>    转换后元素的中间状态泛型
     * @param source 最原始的集合实例
     * @param action 转换规则
     * @return 变换后存储新元素的集合实例
     */
    public static <S, T> Set<T> collectSet(final Collection<S> source, Function<? super S, ? extends T> action) {
        Objects.requireNonNull(source);
        return source.stream().map(action).collect(Collectors.toSet());
    }

    /**
     * 将对象集合按照一定规则映射后收集为List集合
     *
     * @param <S>    原始集合元素的类泛型
     * @param source 最原始的集合实例
     * @param action 转换规则
     * @return 变换后存储新元素的集合实例
     */
    public static <S> List<? extends S> collectList(final Collection<S> source, Function<? super S, ? extends S> action) {
        return collectCommon(source, action, Collectors.toList());
    }

    /**
     * 将对象以一种类型转换成另一种类型
     *
     * @param <T>    源数据类型
     * @param <R>    变换后数据类型
     * @param obj    源对象实例
     * @param action 映射 Lambda 表达式
     * @return 变换后的类型，如果source为null,则返回null
     */
    public static <T, R> R toObj(final T obj, final Function<? super T, ? extends R> action) {
        Objects.requireNonNull(action);
        return Optional.ofNullable(obj).map(action).orElse(null);
    }

    /**
     * <p>将{@code List}集合换成另一种类型</p>
     * <pre>
     *     public class User {
     *         private Long userId;
     *         private String userName;
     *         private String sex;
     *     }
     * </pre>
     * <p>通过方法引用获得任意列组成的新{@code List}集合</p>
     * <pre>
     *     List&lt;Long&gt; userIds = EntityUtils.toList(list,User::getUserId)
     * </pre>
     * <p>在{@code User}类中添加有如下构造器</p>
     * <pre>
     *     public User(User user) {
     *         if(user != null) {
     *             this.userId = user.userId;
     *             this.userName = user.userName;
     *             this.sex = user.sex;
     *         }
     *     }
     * </pre>
     * <pre>
     *     public class UserVo extends User {
     *         private String deptName;
     *
     *         public UserVo (User user) {
     *             super(user);
     *         }
     *     }
     * </pre>
     * 通过如下代码可实现DO 转 VO
     * <pre>
     *     List&lt;Long&gt; userVos = EntityUtils.toList(list,UserVo::new)
     * </pre>
     *
     * @param <T>    源数据类型
     * @param <R>    变换后数据类型
     * @param data   源List集合
     * @param action 映射Lmabda表达式
     * @return 变换后的类型集合，如果source为null,则返回空集合
     */
    public static <T, R> List<R> toList(final Collection<T> data, final Function<? super T, ? extends R> action) {
        Objects.requireNonNull(action);
        if (Objects.nonNull(data)) {
            return data.stream().map(action).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }


    /**
     * 将集合{@code List<T>}实例按照参数<code>action</code>映射关系转换后 生成{@code R[]}数组
     *
     * <pre>
     *     String[] userNames = EntityUtils.toArray(userList, User::getUserName)
     * </pre>
     *
     * @param data   集合实例 不允许为<code>null</code>
     * @param action 映射关系 不允许为<code>null</code>
     * @param <T>    集合元素的类型
     * @param <R>    转换后数组的类型
     * @return {@code R[]}数组实例
     */
    public static <T, R> R[] toArray(final List<T> data, final Function<? super T, ? extends R> action) {
        Objects.requireNonNull(action);
        if (Objects.isNull(data) || data.size() == 0) {
            return null;
        }
        Class<?> rClazz = toObj(CollectionUtil.toObj(data), action).getClass();
        ArrayCollector<R> collector = new ArrayCollector<>(ReflectUtil.getClass(rClazz));
        return data.stream().map(action).collect(collector);
    }


    /**
     * <p>将{@code T}元素类型的集合转换成另{@code R}元素类型的数组</p>
     * <p>更优雅的实现参考{@link EntityUtil#toArray(List, Function)}</p>
     *
     * @param data      以{@code T}元素为类型的集合实例
     * @param action    转换规则（方法引用表示）
     * @param generator 以{@code R}元素为类型数组{@code Class}对象
     * @param <T>       原始的数据类型（泛型）
     * @param <R>       目标类型（泛型）
     * @return 以{@code R}元素为类型数组实例
     * @see #toArray(List, Function, Class)
     */
    public static <T, R> R[] toArray(final List<T> data, final Function<? super T, ? extends R> action, IntFunction<R[]> generator) {
        Objects.requireNonNull(action);
        if (Objects.isNull(data) || data.size() == 0) {
            return null;
        }
        return data.stream().map(action).toArray(generator);
    }

    /**
     * <p>将{@code T}元素类型的集合转换成另{@code R}元素类型的数组</p>
     * <p>更优雅的实现参考{@link EntityUtil#toArray(List, Function)}</p>
     * <pre>
     *     EntityUtils.toArray(userList, User::getUserName, String[].class)
     * </pre>
     *
     * @param data   以{@code T}元素为类型的集合实例
     * @param action 转换规则（方法引用表示）
     * @param clazz  以{@code R}元素为类型数组{@code Class}对象
     * @param <T>    原始的数据类型（泛型）
     * @param <R>    目标类型（泛型）
     * @return 以{@code R}元素为类型数组实例
     */
    @SuppressWarnings("unchecked")
    public static <T, R> R[] toArray(final List<T> data, final Function<? super T, ? extends R> action, final Class<R[]> clazz) {
        Objects.requireNonNull(action);
        Objects.requireNonNull(clazz);
        Class<?> itemCls = clazz.isArray() ? clazz.getComponentType() : clazz;
        IntFunction<R[]> generator = e -> (R[]) Array.newInstance(itemCls, e);
        return toArray(data, action, generator);
    }

    /**
     * 将IPaged对象以一种类型转换成另一种类型
     *
     * @param page   源Page
     * @param action 转换规则
     * @param <E>    源Page类型泛型
     * @param <T>    源实体类
     * @param <R>    目标Page类型泛型
     * @return 变换后的分页类型
     */
    // public static <E extends IPage<T>, T, R> IPage<R> toPage(E page, final Function<? super T, ? extends R> action) {
    //     Objects.requireNonNull(page);
    //     Objects.requireNonNull(action);
    //     return page.convert(action);
    // }

    /**
     * 将集合转化成Map
     *
     * @param data      集合实例
     * @param keyAction key转换规则
     * @param <T>       集合实体类泛型
     * @param <K>       Key实体类型泛型
     * @return Map实例
     */
    public static <T, K> Map<K, T> toMap(final Collection<T> data, Function<? super T, ? extends K> keyAction) {
        Objects.requireNonNull(data);
        Objects.requireNonNull(keyAction);
        return data.stream().collect(Collectors.toMap(keyAction, Function.identity()));
    }

    /**
     * 将集合转化成Map
     *
     * @param data        集合实例
     * @param keyAction   key转换规则
     * @param valueAction value转换规则
     * @param <T>         集合实体类泛型
     * @param <K>         Key实体类型泛型
     * @param <V>         Value实体类型泛型
     * @return Map实例
     */
    public static <T, K, V> Map<K, V> toMap(final Collection<T> data, Function<? super T, ? extends K> keyAction, Function<? super T, ? extends V> valueAction) {
        Objects.requireNonNull(data);
        Objects.requireNonNull(keyAction);
        Objects.requireNonNull(valueAction);
        return data.stream().collect(Collectors.toMap(keyAction, valueAction));
    }

    /**
     * 将List集合以一种类型转换成Set集合
     *
     * @param <T>    源数据类型
     * @param <R>    变换后数据类型
     * @param data   源List集合
     * @param action 映射Lambda表达式
     * @return 变换后的类型集合，如果source为null,则返回空集合
     */
    public static <T, R> Set<R> toSet(final Collection<T> data, final Function<? super T, ? extends R> action) {
        Objects.requireNonNull(action);
        if (Objects.nonNull(data)) {
            return data.stream().map(action).collect(Collectors.toSet());
        }
        return new HashSet<>();
    }

    /**
     * <p>对集合中元素按照指定列进行分组</p>
     * <p>返回值是{@code Map}，其中Key为分组列，Value为当前元素</p>
     *
     * @param data    集合实例
     * @param gColumn 分组列（方法引用表示）
     * @param <E>     集合元素泛型
     * @param <R>     分组列数据类型泛型
     * @return {@code Map}实例
     */
    public static <E, R> Map<R, List<E>> groupBy(final Collection<E> data, final Function<E, R> gColumn) {
        Objects.requireNonNull(gColumn);
        if (Objects.nonNull(data)) {
            return data.stream().collect(Collectors.groupingBy(gColumn));
        }
        return new HashMap<>();
    }

    /**
     * <p>对集合中元素按照指定列进行分组</p>
     * <p>返回值是{@code Map}，其中Key为分组列</p>
     *
     * @param data    集合实例
     * @param gColumn 分组列（方法引用表示）
     * @param action  转换行为
     * @param <U>     Value集合元素类型泛型
     * @param <E>     集合元素泛型
     * @param <G>     分组列数据类型泛型
     * @return {@code Map}实例
     */
    public static <E, G, U> Map<G, List<U>> groupBy(final Collection<E> data, final Function<E, G> gColumn, final Function<E, U> action) {
        Objects.requireNonNull(gColumn);
        if (Objects.nonNull(data)) {
            return data.stream().collect(Collectors.groupingBy(gColumn, Collectors.mapping(action, Collectors.toList())));
        }
        return new HashMap<>(16);
    }
}