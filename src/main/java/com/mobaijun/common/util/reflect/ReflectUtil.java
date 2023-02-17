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
package com.mobaijun.common.util.reflect;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: ReflectUtils<br>
 * class description：反射工具类 2.0<br>
 *
 * @author MoBaiJun 2022/5/31 11:21
 */
@Slf4j
public class ReflectUtil {

    private static final Map<Class<?>, Class<?>> PRIMITIVE_AND_WRAP = new HashMap<>(10);

    static {
        PRIMITIVE_AND_WRAP.put(byte.class, Byte.class);
        PRIMITIVE_AND_WRAP.put(short.class, Short.class);
        PRIMITIVE_AND_WRAP.put(int.class, Integer.class);
        PRIMITIVE_AND_WRAP.put(long.class, Long.class);
        PRIMITIVE_AND_WRAP.put(float.class, Float.class);
        PRIMITIVE_AND_WRAP.put(double.class, Double.class);
        PRIMITIVE_AND_WRAP.put(char.class, Character.class);
        PRIMITIVE_AND_WRAP.put(boolean.class, Boolean.class);
    }

    /**
     * 判断是不是基本类型
     *
     * @param type 类型
     * @return 如果type是基本类型，则返回true，否则返回false
     */
    public static boolean isPrimitive(Class<?> type) {
        return PRIMITIVE_AND_WRAP.containsKey(type);
    }

    /**
     * 获取包装类型
     *
     * @param type 类型
     * @return 如果type是基本类型，则返回对应的包装类型，否则返回type
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getWrap(Class<T> type) {
        if (!isPrimitive(type)) {
            return type;
        }
        return (Class<T>) PRIMITIVE_AND_WRAP.get(type);
    }


    /**
     * 设置JavaBean的属性
     *
     * @param bean         JavaBean实例
     * @param propertyName 属性名
     * @param value        值
     */
    public static void setProperty(Object bean, String propertyName, Object value) {
        try {
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, bean.getClass());
            Method setter = pd.getWriteMethod();
            setter.invoke(bean, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 创建数组
     *
     * @param elementType 元素类型
     * @param elements    元素
     * @param <T>         返回类型
     * @return 用指定元素创建的数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T createArray(Class<?> elementType, Object... elements) {
        Object array = Array.newInstance(elementType, elements.length);
        for (int i = 0; i < elements.length; ++i) {
            Array.set(array, i, elements[i]);
        }
        return (T) array;
    }

    /**
     * 获取指定包中的所有类
     *
     * @param packageName 包名
     * @return 包中的所有类列表类列表
     */
    public static List<Class<?>> getPackageClasses(String packageName) {
        String packagePath = packageName.replace(".", File.separator);
        File classpath = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getFile());
        File root = new File(classpath, packagePath);
        List<Class<?>> classes = new ArrayList<>();
        traverseAllClassFiles(classpath.getAbsolutePath(), root, classes);
        return classes;
    }

    /**
     * 遍历所有.class文件
     */
    private static void traverseAllClassFiles(String classPath, File file, List<Class<?>> classes) {
        if (!file.isDirectory()) {
            if (file.getName().endsWith(".class")) {
                String classFilePath = file.getAbsolutePath();
                String fullClassName = classFilePath.substring(classPath.length() + 1, classFilePath.length() - 6).replace(File.separator, ".");
                try {
                    classes.add(Class.forName(fullClassName));
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            return;
        }

        for (File f : Objects.requireNonNull(file.listFiles())) {
            traverseAllClassFiles(classPath, f, classes);
        }
    }

    /**
     * 根据参数数组获取类型数组
     */
    private static Class<?>[] getTypes(Object... params) {
        return Arrays.stream(params).map(Object::getClass).toArray(Class<?>[]::new);
    }

    /**
     * 判断两个类型是否匹配（相同或者为包装类型关系）
     */
    private static boolean match(Class<?> declaredType, Class<?> actualType) {
        return getWrap(declaredType).isAssignableFrom(getWrap(actualType));
    }

    /**
     * 判断两个类型列表是否匹配（列表长度相同且对应位置的类型相匹配）
     */
    private static boolean match(Class<?>[] c1, Class<?>[] c2) {
        if (c1.length == c2.length) {
            for (int i = 0; i < c1.length; ++i) {
                if (!match(c1[i], c2[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 通过反射获取父类属性
     *
     * @param object 对象
     * @return 属性数组
     */
    public static Field[] getAllFields(Object object) {
        Class<?> clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (Object.class != clazz) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        return fieldList.toArray(new Field[0]);
    }

    /**
     * 直接设置对象属性值, 忽略 private/protected 修饰符, 也不经过 setter
     */
    public static void setFieldValue(Object object, String fieldName, Object value) {
        Field field = getDeclaredField(object, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        }
        makeAccessible(field);
        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            log.error("setFieldValue:{}", e.getMessage());
        }
    }


    /**
     * 通过反射, 获得定义 Class 时声明的父类的泛型参数的类型
     * 如: public EmployeeDao extends BaseDao<Employee, String>
     */

    @SuppressWarnings("unchecked")
    public static <T> Class<T> getSuperClassGenericType(Class<T> clazz, int index) {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return (Class<T>) Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return (Class<T>) Object.class;
        }

        if (!(params[index] instanceof Class)) {
            return (Class<T>) Object.class;
        }
        return (Class<T>) params[index];
    }

    /**
     * 通过反射, 获得 Class 定义中声明的父类的泛型参数类型
     * 如: public EmployeeDao extends BaseDao
     */
    public static <T> Class<T> getSuperGenericType(Class<T> clazz) {
        return getSuperClassGenericType(clazz, 0);
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredMethod
     */
    public static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes) {
        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {
                // Method 不在当前类定义, 继续向上转型
            }
        }
        return null;
    }

    /**
     * 使 filed 变为可访问
     */
    public static void makeAccessible(Field field) {
        if (!Modifier.isPublic(field.getModifiers())) {
            field.setAccessible(true);
        }
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     */
    public static Field getDeclaredField(Object object, String filedName) {

        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(filedName);
            } catch (NoSuchFieldException e) {
                // Field 不在当前类定义, 继续向上转型
                log.error("NoSuchFieldException:{}", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 直接调用对象方法, 而忽略修饰符(private, protected)
     */
    @SuppressWarnings("unchecked")
    public static <T> T invokeMethod(T object, String methodName, Class<T>[] parameterTypes, T[] parameters) throws InvocationTargetException {
        Method method = getDeclaredMethod(object, methodName, parameterTypes);

        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
        }
        method.setAccessible(true);
        try {
            return (T) method.invoke(object, (Object) parameters);
        } catch (IllegalAccessException e) {
            log.error("invokeMethod:{}", e.getMessage());
        }
        return null;
    }

    /**
     * 通过Clazz对象创建实例
     *
     * @param clazz CLass对象
     * @param <T>   泛型
     * @return 泛型实例
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>显示化获得{@code Class<T>}对象的类型</p>
     * <p>本方法的作用时避免在显示强转时出现<i>未检查警告</i></p>
     * <p>注意{@code Class<\?>}与{@code Class<T>}是同一个类型才能强转</p>
     *
     * @param clazz Class对象实例
     * @param <T>   元素类型
     * @return 如果参数<code>clazz</code>不为<code>null</code>，则返回强转后的对象，否则返回<code>null</code>
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClass(Class<?> clazz) {
        return (Class<T>) clazz;
    }

    /**
     * 通过构造器创建对象
     *
     * @param constructor 以泛型{@code VO}为类型的构造器实例
     * @param initargs    以泛型{@code DO}为类型的参数实例
     * @param <DO>        {@code DO}泛型
     * @param <VO>        {@code VO}泛型
     * @return 以泛型{@code VO}为类型的对象实例
     */
    @SafeVarargs
    public static <DO, VO extends DO> VO newInstance(Constructor<VO> constructor, DO... initargs) {
        try {
            return constructor.newInstance((Object) initargs);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}