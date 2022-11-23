package com.mobaijun.common.test.collection;

import com.mobaijun.common.util.PrintUtils;
import com.mobaijun.common.util.collection.CollectionUtils;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: CollectionUtilsTest
 * class description: 集合工具类
 *
 * @author MoBaiJun 2022/11/22 15:19
 */
public class CollectionUtilsTest {
    public static void main(String[] args) {
        PrintUtils.println(CollectionUtils.isEmpty(CollectionUtils.newArrayList()));
        PrintUtils.println(CollectionUtils.isEmpty(CollectionUtils.newHashMap()));
    }
}
