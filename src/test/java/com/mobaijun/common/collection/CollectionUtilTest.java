package com.mobaijun.common.collection;

import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: CollectionUtilTest<br>
 * class description:
 *
 * @author MoBaiJun 2023/3/13 18:29
 */
public class CollectionUtilTest {

    @Test
    public void toObjectArray() {
        Object[] objects = CollectionUtil.toObjectArray(true, false, true);
    }
}