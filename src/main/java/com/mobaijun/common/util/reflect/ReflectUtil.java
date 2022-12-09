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

import cn.hutool.log.Log;

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
public class ReflectUtil {
    /**
     * tools log
     */
    private static final Log log = Log.get(ReflectUtil.class);

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
     * 调用构造函数创建对象
     *
     * @param type   要创建对象的类型
     * @param params 参数
     * @param <T>    返回类型
     * @return 调用构造函数创建的对象
     */
    public static <T> T create(Class<T> type, Object... params) {
        try {
            return type.cast(getConstructor(type, getTypes(params)).newInstance(params));
        } catch (Exception e) {
            throw new RuntimeException(String.format("Cannot invoke constructor of \"%s\" with parameters %s.",
                    type.getCanonicalName(), Arrays.toString(params)), e);
        }
    }

    /**
     * 调用静态方法
     *
     * @param type       类型
     * @param methodName 方法名
     * @param params     参数
     * @param <T>        返回类型
     * @return 静态方法的返回值
     */
    @SuppressWarnings("unchecked")
    public static <T> T call(Class<?> type, String methodName, Object... params) {
        try {
            Method method = getMethod(type, methodName, getTypes(params));
            method.setAccessible(true);
            return (T) method.invoke(null, params);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Cannot invoke static method \"%s\" of \"%s\" with parameters %s.",
                    methodName, type.getCanonicalName(), Arrays.toString(params)), e);
        }
    }

    /**
     * 调用实例方法
     *
     * @param obj        实例对象
     * @param methodName 方法名
     * @param params     参数
     * @param <T>        返回类型
     * @return 实例方法的返回值
     */
    @SuppressWarnings("unchecked")
    public static <T> T call(Object obj, String methodName, Object... params) {
        try {
            Method method = getMethod(obj.getClass(), methodName, getTypes(params));
            method.setAccessible(true);
            return (T) method.invoke(obj, params);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Cannot invoke method \"%s\" of \"%s\" with parameters %s.",
                    methodName, obj.getClass().getCanonicalName(), Arrays.toString(params)), e);
        }
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
     * 获取方法返回值类型
     *
     * @param type           方法所属的类
     * @param methodName     方法名
     * @param parameterTypes 参数类型数组
     * @return 方法返回值类型
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getReturnType(Class<T> type, String methodName, Class<?>... parameterTypes) {
        return (Class<T>) getMethod(type, methodName, parameterTypes).getReturnType();
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
     * 根据参数类型获取构造函数
     */
    private static Constructor<?> getConstructor(Class<?> type, Class<?>[] parameterTypes) {
        try {
            return type.getConstructor(parameterTypes);
        } catch (Exception e) {
            for (Constructor<?> constructor : type.getConstructors()) {
                if (constructor.getParameterCount() == parameterTypes.length) {
                    if (match(constructor.getParameterTypes(), parameterTypes)) {
                        return constructor;
                    }
                }
            }
            throw new RuntimeException(String.format("Cannot find constructor of \"%s\" with parameter types %s.",
                    type.getCanonicalName(), Arrays.toString(parameterTypes)), e);
        }
    }

    /**
     * 根据参数类型和方法名获取方法
     */
    private static Method getMethod(Class<?> type, String name, Class<?>[] parameterTypes) {
        try {
            return type.getMethod(name, parameterTypes);
        } catch (Exception e) {
            for (Method method : type.getMethods()) {
                if (method.getName().equals(name) && method.getParameterCount() == parameterTypes.length) {
                    if (match(method.getParameterTypes(), parameterTypes)) {
                        return method;
                    }
                }
            }
            throw new RuntimeException(String.format("Cannot find method \"%s\" of \"%s\" with parameter types %s.",
                    name, type.getCanonicalName(), Arrays.toString(parameterTypes)), e);
        }
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
     * 直接读取对象的属性值, 忽略 private/protected 修饰符, 也不经过 getter
     */
    @SuppressWarnings("unchecked")
    public static <T> T getFieldValue(Object object, String fieldName) {
        Field field = getDeclaredField(object, fieldName);
        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        }
        makeAccessible(field);
        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {
            log.error(e, "getFieldValue:{}", e.getMessage());
        }
        return (T) result;
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
            log.error(e, "setFieldValue:{}", e.getMessage());
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
                log.error(e, "NoSuchFieldException:{}", e.getMessage());
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
            log.error(e, "invokeMethod:{}", e.getMessage());
        }
        return null;
    }
}