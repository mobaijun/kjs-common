/*
 * Copyright (C) 2022 [%s]
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
package com.mobaijun.common.collection;

import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Description: [CollectionUtilTest测试类]
 * Author: [mobaijun]
 * Date: [2023/12/29 8:50]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class CollectionUtilTest {


    /**
     * Test for splitToList.
     */
    @Test
    public void testSplitToList() {
        // Perform the method call
        List<String> result = CollectionUtil.splitToList("str", "separator");

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for addAll.
     */
    @Test
    public void testAddAll() {
    }

    /**
     * Test for join.
     */
    @Test
    public void testJoin() {
    }

    /**
     * Test for join.
     */
    @Test
    public void testJoin2() {
    }

    /**
     * Test for sortSetByValue.
     */
    @Test
    public void testSortSetByValue() {
    }

    /**
     * Test for subListFromStack.
     */
    @Test
    public void testSubListFromStack() {
        // Perform the method call
    }

    /**
     * Test for subList.
     */
    @Test
    public void testSubList() {
        // Perform the method call
    }

    /**
     * Test for newHashMap.
     */
    @Test
    public void testNewHashMap() {
        // Perform the method call
    }

    /**
     * Test for newHashMap.
     */
    @Test
    public void testNewHashMap2() {
        // Perform the method call
    }

    /**
     * Test for newConcurrentHashMap.
     */
    @Test
    public void testNewConcurrentHashMap() {
        // Perform the method call
    }

    /**
     * Test for newConcurrentHashMap.
     */
    @Test
    public void testNewConcurrentHashMap2() {
        // Perform the method call
    }

    /**
     * Test for newHashSet.
     */
    @Test
    public void testNewHashSet() {
        // Perform the method call
    }

    /**
     * Test for newHashSet.
     */
    @Test
    public void testNewHashSet2() {
        // Perform the method call
    }

    /**
     * Test for newArrayList.
     */
    @Test
    public void testNewArrayList() {
        // Perform the method call
    }

    /**
     * Test for newArrayList.
     */
    @Test
    public void testNewArrayList2() {
        // Perform the method call
    }

    /**
     * Test for addToArray.
     */
    @Test
    public void testAddToArray() {
        // Perform the method call
    }

    /**
     * Test for resizeArray.
     */
    @Test
    public void testResizeArray() {
        // Perform the method call
    }

    /**
     * Test for resizeArray.
     */
    @Test
    public void testResizeArray2() {
        // Perform the method call
    }

    /**
     * Test for newArray.
     */
    @Test
    public void testNewArray() {
        // Perform the method call
    }

    /**
     * Test for concatArrays.
     */
    @Test
    public void testConcatArrays() {
        // Perform the method call
    }

    /**
     * Test for cloneArray.
     */
    @Test
    public void testCloneArray() {
        // Perform the method call
    }

    /**
     * Test for subArray.
     */
    @Test
    public void testSubArray() {
        // Perform the method call
    }

    /**
     * Test for zip.
     */
    @Test
    public void testZip() {
        // Perform the method call
    }

    /**
     * Test for zip.
     */
    @Test
    public void testZip2() {
        // Perform the method call
        Map<String, String> result = CollectionUtil.zip("keys", "values", "delimiter");

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for zip.
     */
    @Test
    public void testZip3() {
        // Perform the method call
    }

    /**
     * Test for contains.
     */
    @Test
    public void testContains() {
        // Perform the method call
    }

    /**
     * Test for toHashMap.
     */
    @Test
    public void testToHashMap() {
        // Perform the method call
    }

    /**
     * Test for toTreeSet.
     */
    @Test
    public void testToTreeSet() {
        // Perform the method call
    }

    /**
     * Test for sortList.
     */
    @Test
    public void testSortList() {
        // Perform the method call
    }

    /**
     * Test for wrap.
     */
    @Test
    public void testWrap() {
        // Perform the method call
        Integer[] result = CollectionUtil.wrap(0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for wrap.
     */
    @Test
    public void testWrap2() {
        // Perform the method call
        Long[] result = CollectionUtil.wrap(0L);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for wrap.
     */
    @Test
    public void testWrap3() {
        // Perform the method call
        Character[] result = CollectionUtil.wrap('a');

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for wrap.
     */
    @Test
    public void testWrap4() {
        // Perform the method call
        Byte[] result = CollectionUtil.wrap((byte) 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for wrap.
     */
    @Test
    public void testWrap5() {
        // Perform the method call
        Short[] result = CollectionUtil.wrap((short) 0);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for wrap.
     */
    @Test
    public void testWrap6() {
        // Perform the method call
        Float[] result = CollectionUtil.wrap(0f);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for wrap.
     */
    @Test
    public void testWrap7() {
        // Perform the method call
        Double[] result = CollectionUtil.wrap(0d);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for wrap.
     */
    @Test
    public void testWrap8() {
        // Perform the method call
        Boolean[] result = CollectionUtil.wrap(true);

        // Print the result using your PrintUtil
        PrintUtil.println(result);
    }

    /**
     * Test for isArray.
     */
    @Test
    public void testIsArray() {
        // Perform the method call
    }

    /**
     * Test for isEqualCollection.
     */
    @Test
    public void testIsEqualCollection() {
        // Perform the method call
    }

    /**
     * Test for partition.
     */
    @Test
    public void testPartition() {
        // Perform the method call
    }

    /**
     * Test for min.
     */
    @Test
    public void testMin() {
        // Perform the method call
    }

    /**
     * Test for max.
     */
    @Test
    public void testMax() {
        // Perform the method call
    }

    /**
     * Test for toCol.
     */
    @Test
    public void testToCol() {
        // Perform the method call
    }

    /**
     * Test for toCol.
     */
    @Test
    public void testToCol2() {
        // Perform the method call
    }

    /**
     * Test for toObj.
     */
    @Test
    public void testToObj() {
        // Perform the method call
    }

    /**
     * Test for max.
     */
    @Test
    public void testMax2() {
        // Perform the method call
    }

    /**
     * Test for max.
     */
    @Test
    public void testMax3() {
        // Perform the method call
    }

    /**
     * Test for max.
     */
    @Test
    public void testMax4() {
        // Perform the method call
    }

    /**
     * Test for min.
     */
    @Test
    public void testMin2() {
        // Perform the method call
    }

    /**
     * Test for min.
     */
    @Test
    public void testMin3() {
        // Perform the method call
    }

    /**
     * Test for min.
     */
    @Test
    public void testMin4() {
        // Perform the method call
    }

}