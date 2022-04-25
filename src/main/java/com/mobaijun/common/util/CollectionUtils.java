package com.mobaijun.common.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: CollectionUtil
 * 类描述： 集合工具类
 *
 * @author MoBaiJun 2022/4/22 16:16
 */
public class CollectionUtils {

    /**
     * 判断单列集合是否为 null
     */
    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null;
    }

    /**
     * 判断 map 是否为 null
     */
    public static <K, V> boolean isEmpty(Map<K, V> data) {
        return data == null;
    }


    /**
     * 判断list是否weinull
     *
     * @param data 集合对象
     * @param <T>  泛型参数
     */
    public static <T> boolean isNull(List<T> data) {
        return isEmpty(data);
    }

    /**
     * 判断Set集合是否为null
     *
     * @param data 集合对象
     * @param <T>  泛型参数
     */
    public static <T> boolean isNull(Set<T> data) {
        return isEmpty(data);
    }

    /**
     * 判断 map 是否为 null
     *
     * @param data 集合对象
     */
    public static <K, V> boolean isNull(Map<K, V> data) {
        return isEmpty(data);
    }
}
