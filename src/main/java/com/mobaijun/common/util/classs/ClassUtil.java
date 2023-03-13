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
package com.mobaijun.common.util.classs;

import com.mobaijun.common.assertions.Assert;
import com.mobaijun.common.constant.DateConstant;
import com.mobaijun.common.constant.NumberConstant;
import com.mobaijun.common.constant.StringConstant;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: ClassUtils<br>
 * class description： 类处理工具<br>
 * 这个类是方便控制台输出object，主要应用java反射机制。 因为考虑到使用性和美观性，没有使用无限递归。<br>
 * 而是在toStr方法中加入一个boolean recursion ，是否递归。<br>
 * 当然我们也可以将boolean recursion换成int recursion，控制递归次数。<br>
 * 其实就我使用经验来看，复杂数据 toString，用 json 工具转化成 json 输出是一个不错的方式。
 *
 * @author MoBaiJun NumberConstant.TWO0NumberConstant.TWONumberConstant.TWO/5/18 9:19
 */
public class ClassUtil {

    /**
     * 这是我用的方式，boolean recursion是否递归
     * public static int add(int i,boolean recursion){
     * sum+=i;
     * if(recursion)
     * add(i, false);
     * return sum;
     * }
     * // 也可以这样，int recursion表示递归次数
     * public static int add(int i,int recursion){
     * sum+=i;
     * if(recursion > 0){
     * recursion--;
     * add(i, recursion);
     * }
     * return sum;
     * }
     */
    private static final String MY_SIGN = "KLG_print";

    private static final char PACKAGE_SEPARATOR = '.';

    /**
     * 代理 class 的名称
     */
    private static final List<String> PROXY_CLASS_NAMES = Arrays.asList("net.sf.cglib.proxy.Factory"
            // cglib
            , "org.springframework.cglib.proxy.Factory"
            , "javassist.util.proxy.ProxyObject"
            // javassist
            , "org.apache.ibatis.javassist.util.proxy.ProxyObject");

    private static ClassLoader systemClassLoader;

    /**
     * 将集合类型toString方法
     *
     * @param object    object
     * @param recursion 是否递归
     * @return String
     */
    private static String collectionToStr(Object object, boolean recursion) {
        if (object == null) {
            return StringConstant.EMPTY_STRING;
        }
        Object[] a;
        // 将集合类型转换成数组类型
        if (isArrayType(object)) {
            a = (Object[]) object;
        } else {
            a = ((Collection<?>) object).toArray();
        }
        if (isSimpleArr(a) || !recursion) {
            return Arrays.toString(a);
        } else {
            return complexArrToStr(a);
        }
    }

    /**
     * Arrays有toString方法，但是对象内容太多，在一行显示 还有就是没有显示index信息
     */
    private static String complexArrToStr(Object[] a) {
        if (a == null) {
            return StringConstant.EMPTY_STRING;
        }
        int iMax = a.length - NumberConstant.ONE;
        if (iMax == NumberConstant.MINUS_ONE) {
            return StringConstant.SQUARE_BRACKETS;
        }
        StringBuilder b = new StringBuilder();
        for (int i = NumberConstant.ZERO; ; i++) {
            String value = objToStr(a[i], false);
            b.append(StringConstant.LEFT_SQUARE_BRACKETS)
                    .append(i)
                    .append(StringConstant.RIGHT_SQUARE_BRACKETS)
                    .append(StringConstant.LEFT_ARROW)
                    .append(value);
            if (i == iMax) {
                return b.toString();
            }
            b.append(", \r\n");
        }
    }

    /**
     * map类型toString方法
     *
     * @param map       map
     * @param recursion 是否递归
     * @return String
     */
    private static String mapToStr(Map<String, Object> map, boolean recursion) {
        if (map == null) {
            return StringConstant.EMPTY_STRING;
        }
        if (isSimpleMap(map) || !recursion) {
            return simpleMapToStr(map);
        } else {
            return complexMapToStr(map);
        }
    }

    /**
     * map的value是简单类型的，复制Map.toString，我给它加了换行10个换行
     *
     * @param map map
     * @return String
     */
    private static String simpleMapToStr(Map<String, Object> map) {
        Iterator<Entry<String, Object>> i = map.entrySet().iterator();
        if (!i.hasNext()) {
            return StringConstant.BIG_PARENTHESES;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(StringConstant.LEFT_BIG_PARENTHESES);
        for (int t = NumberConstant.ONE; ; t++) {
            Entry<String, Object> e = i.next();
            sb.append(e.getKey())
                    .append(StringConstant.EMPTY_STRING)
                    .append(StringConstant.EQUAL)
                    .append(StringConstant.EMPTY_STRING)
                    .append(e.getValue());
            if (!i.hasNext()) {
                return sb.append(StringConstant.RIGHT_BIG_PARENTHESES).toString();
            }
            sb.append(StringConstant.COMMA).append(StringConstant.EMPTY_STRING);
            if (t % NumberConstant.TEN == NumberConstant.ZERO && t != NumberConstant.ZERO) {
                sb.append("\r\n ");
            }
        }
    }

    /**
     * 复杂的映射到 Str
     *
     * @param map map
     * @return String
     */
    private static String complexMapToStr(Map<String, Object> map) {
        Iterator<Entry<String, Object>> i = map.entrySet().iterator();
        if (!i.hasNext()) {
            return StringConstant.EMPTY_STRING;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringConstant.LEFT_BIG_PARENTHESES);
        for (int t = NumberConstant.ONE; ; t++) {
            Entry<String, Object> e = i.next();
            String key = String.valueOf(e.getKey());
            Object value = e.getValue();
            sb.append(indent(NumberConstant.TWO, " ")).append(key).append(" = ");
            if (isSimpleType(value)) {
                sb.append(value);
            } else {
                sb.append(objToStr(value, false));
            }
            if (!i.hasNext()) {
                return sb.append("\r\n}").toString();
            }
            sb.append(',').append("\r\n");
        }
    }


    private static String beanToStr(Object object, boolean recursion) {
        if (object == null) {
            return StringConstant.EMPTY_STRING;
        }
        Class<?> clazz = object.getClass();
        StringBuilder sb = new StringBuilder();
        // 返回源代码中给出的底层类的简称
        sb.append(clazz.getSimpleName()).append("[");
        Field[] fields = sortFieldByType(clazz.getDeclaredFields());
        int iMax = fields.length - 1;
        if (iMax == -1) {
            return sb.append("]").toString();
        }
        for (int i = 0; ; i++) {
            Field field = fields[i];
            // 设置些属性是可以访问的
            field.setAccessible(true);
            // 取得field的名称
            String name = field.getName();
            if ("serialVersionUID".equals(name)) {
                continue;
            }
            try {
                // 得到此属性的值
                Object value = field.get(object);
                if (isSimpleType(value) || !recursion) {
                    sb
                            .append(name)
                            .append(" = ")
                            .append(value);
                } else {
                    sb
                            .append("\r\n")
                            .append(indent(clazz.getSimpleName().length() + NumberConstant.TWO, " "))
                            .append(objToStr(value, false))
                            .append("\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i == iMax) {
                return sb.append("]").append(",").toString();
            }
        }
    }


    private static String indent(int length, String sign) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(sign);
        }
        return sb.toString();
    }

    private static boolean isSimpleType(Object obj) {
        if (obj == null) {
            return true;
        } else {
            Class<?> objectClass = obj.getClass();
            return isSimpleType(objectClass);
        }
    }

    private static boolean isSimpleType(Class<?> objectClass) {
        return objectClass == boolean.class || objectClass == Boolean.class
                || objectClass == short.class || objectClass == Short.class
                || objectClass == byte.class || objectClass == Byte.class
                || objectClass == int.class || objectClass == Integer.class
                || objectClass == long.class || objectClass == Long.class
                || objectClass == float.class || objectClass == Float.class
                || objectClass == char.class || objectClass == Character.class
                || objectClass == double.class || objectClass == Double.class
                || objectClass == String.class;
    }

    /**
     * Method isCollectionType
     *
     * @param obj Object
     * @return boolean
     */
    private static boolean isCollectionType(Object obj) {
        if (obj == null) {
            return false;
        }
        return (obj.getClass().isArray() || (obj instanceof Collection));
    }

    private static boolean isArrayType(Object obj) {
        if (obj == null) {
            return false;
        }
        return (obj.getClass().isArray());
    }

    private static boolean isMapType(Object obj) {
        if (obj == null) {
            return false;
        }
        return (obj instanceof Map);
    }

    private static boolean isDateType(Object obj) {
        if (obj == null) {
            return false;
        }
        return (obj instanceof Date);
    }

    private static boolean isBeanType(Object obj) {
        return !isSimpleType(obj) && !isCollectionType(obj) && !isMapType(obj);
    }

    private static boolean isSimpleArr(Object[] a) {
        if (a == null || a.length < 1) {
            return true;
        }
        boolean flag = true;
        for (Object o : a) {
            if (!isSimpleType(o)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean isSimpleMap(Map<String, Object> map) {
        if (map == null) {
            return true;
        }
        Iterator<Entry<String, Object>> i = map.entrySet().iterator();
        boolean flag = true;
        while (i.hasNext()) {
            Entry<String, Object> e = i.next();
            if (!isSimpleType(e.getValue())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 将简单类型排在前面
     *
     * @param fields 参数
     * @return Field
     */
    public static Field[] sortFieldByType(Field[] fields) {
        for (int i = 0; i < fields.length; i++) {
            if (isSimpleType(fields[i].getType()))
            // fields[i]是简单类型不管
            {
                continue;
            }
            // fields[i]是复杂类型
            // int j = i+1，从fields[i]之后开始比较
            for (int j = i + 1; j < fields.length; j++) {
                Field fieldTmp;
                // 与后面的第一个简单类型交互
                if (isSimpleType(fields[j].getType())) {
                    fieldTmp = fields[i];
                    fields[i] = fields[j];
                    fields[j] = fieldTmp;
                    // 后面的循环，是没有意义de
                    break;
                }
            }
        }
        return fields;
    }

    /**
     * 这个方法是递归方法，并且并多个地方调用，考虑到循环引用和显示格式， boolean recursion取得确保递归可以被终止。
     *
     * @param object    object
     * @param recursion 是否需要更深一层显示
     * @return String
     */
    @SuppressWarnings("all")
    private static String objToStr(Object object, boolean recursion) {
        if (object == null) {
            return StringConstant.EMPTY_STRING;
        }
        if (isDateType(object)) {
            return new SimpleDateFormat(DateConstant.YYYY_MM_DD_HH_MM_SS).format((Date) object);
        } else if (isBeanType(object)) {
            return beanToStr(object, recursion);
        } else if (isCollectionType(object)) {
            return collectionToStr(object, recursion);
        } else if (isMapType(object)) {
            return mapToStr((Map<String, Object>) object, recursion);
        } else {
            return String.valueOf(object);
        }
    }

    public static String objToStr(Object obj) {
        return objToStr(obj, true);
    }

    private static void print(Object obj, String sign, String content) {
        String begin = indent(15, StringConstant.EQUAL) + "  " + obj.getClass().getSimpleName()
                + "  >> " + sign + "  " + indent(10, StringConstant.EQUAL);
        int length = (begin.length() - sign.length() - 5) / NumberConstant.TWO;

        String end = indent(length, StringConstant.EQUAL) + "  " + sign + "  " + indent(length, StringConstant.EQUAL);
        System.out.println(begin + "\r\n" + content + "\r\n" + end);

    }

    public static void print(Object obj) {
        print(obj, MY_SIGN, objToStr(obj));
    }

    public static void printWithSign(String sign, Object obj) {
        print(obj, sign, objToStr(obj));
    }

    private static final Map<String, Boolean> CACHE = new ConcurrentHashMap<>(8);

    /**
     * 确定class是否可以被加载
     *
     * @param className   完整类名
     * @param classLoader 类加载
     */
    public static boolean isPresent(String className, ClassLoader classLoader) {
        if (CACHE.containsKey(className)) {
            return CACHE.get(className);
        }
        try {
            Class.forName(className, true, classLoader);
            CACHE.put(className, true);
            return true;
        } catch (Exception ex) {
            CACHE.put(className, false);
            return false;
        }
    }

    /**
     * 获取对象的泛型
     *
     * @param src   待获取泛型对象
     * @param index 泛型的位置
     * @param <T>   泛型
     * @return 泛型Class类
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getInstance(Object src, int index) {
        if (src == null || index < 0) {
            return null;
        }
        Class<?> aClass = src.getClass();
        Type gSuperclass = aClass.getGenericSuperclass();
        if (gSuperclass instanceof ParameterizedType) {
            try {
                ParameterizedType pType = (ParameterizedType) gSuperclass;
                Type[] types = pType.getActualTypeArguments();
                if (index < types.length) {
                    return (Class<T>) types[index];
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 判断传入的类型是否是布尔类型
     *
     * @param type 类型
     * @return 如果是原生布尔或者包装类型布尔，均返回 true
     */
    public static boolean isBoolean(Class<?> type) {
        return type == boolean.class || Boolean.class == type;
    }

    /**
     * 判断是否为代理对象
     *
     * @param clazz 传入 class 对象
     * @return 如果对象class是代理 class，返回 true
     */
    public static boolean isProxy(Class<?> clazz) {
        if (clazz != null) {
            for (Class<?> cls : clazz.getInterfaces()) {
                if (PROXY_CLASS_NAMES.contains(cls.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <br>
     * 获取当前对象的 class
     * </p>
     *
     * @param clazz 传入
     * @return 如果是代理的class，返回父 class，否则返回自身
     */
    public static Class<?> getUserClass(Class<?> clazz) {
        Assert.notNull(clazz, "Class must not be null");
        return isProxy(clazz) ? clazz.getSuperclass() : clazz;
    }

    /**
     * <br>
     * 获取当前对象的class
     * </p>
     *
     * @param object 对象
     * @return 返回对象的 user class
     */
    public static Class<?> getUserClass(Object object) {
        Assert.notNull(object, "Instance must not be null");
        return getUserClass(object.getClass());
    }

    /**
     * <br>
     * 根据指定的 class ， 实例化一个对象，根据构造参数来实例化
     * </p>
     * <br>
     * 在 java9 及其之后的版本 Class.newInstance() 方法已被废弃
     * </p>
     *
     * @param clazz 需要实例化的对象
     * @param <T>   类型，由输入类型决定
     * @return 返回新的实例
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new InvalidParameterException("实例化对象时出现错误,请尝试给 %s 添加无参的构造方法");
        }
    }
}