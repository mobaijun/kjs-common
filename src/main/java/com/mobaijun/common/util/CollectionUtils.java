package com.mobaijun.common.util;

import java.util.Collection;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: CollectionUtil
 * 类描述： 集合工具类
 *
 * @Author MoBaiJun 2022/4/22 16:16
 */
public class CollectionUtils {

    /**
     * 判断集合是否为 null
     */
    public static boolean isEmpty(Collection<Object> collection) {
        return collection == null;
    }
}
