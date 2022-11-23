package com.mobaijun.common.util.collection;

import cn.hutool.core.collection.ListUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: ListUtils
 * class description: list 工具类
 *
 * @author MoBaiJun 2022/11/23 9:42
 */
public class ListUtils extends ListUtil {

    /**
     * map 添加到 list
     *
     * @param map map
     * @param <K> 键
     * @param <V> 值
     * @return list 集合
     */
    public static <K, V> List<Map<K, V>> mapList(Map<K, V> map) {
        List<Map<K, V>> mapList = CollectionUtils.newArrayList();
        mapList.add(map);
        return mapList;
    }

    /**
     * map 数组添加到 list
     *
     * @param map map
     * @param <K> 键
     * @param <V> 值
     * @return list 集合
     */
    @SafeVarargs
    public static <K, V> List<Map<K, V>> mapList(Map<K, V>... map) {
        List<Map<K, V>> mapList = CollectionUtils.newArrayList();
        mapList.addAll(Arrays.asList(map));
        return mapList;
    }
}
