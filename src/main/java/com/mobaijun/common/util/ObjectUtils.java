package com.mobaijun.common.util;

import com.sun.istack.internal.Nullable;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: ObjectUtils
 * 类描述： 对象操作工具类
 *
 * @Author MoBaiJun 2022/4/22 16:17
 */
public class ObjectUtils {

    /**
     * 判断对象是否为 null
     */
    public static boolean isEmpty(@Nullable Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Optional) {
            return !((Optional<?>) obj).isPresent();
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        }
        return false;
    }

    /**
     * 判断对象数组是否为 null
     */
    public static boolean isEmpty(@Nullable Object[] array) {
        return (array == null || array.length == 0);
    }
}
