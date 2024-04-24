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
package com.mobaijun.common.collection;

import com.mobaijun.common.tool.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * Description: [ListUtilTest测试类]
 * Author: [mobaijun]
 * Date: [2023/12/29 8:55]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class ListUtilTest {


    /**
     * Test for addMapsToList.
     */
    @Test
    public void testAddMapsToList() {
        // Arrange
        List<Map<String, Integer>> existingList = new ArrayList<>();
        existingList.add(Map.of("key1", 1));

        Map<String, Integer> map1 = Map.of("a", 1, "b", 2);
        Map<String, Integer> map2 = Map.of("x", 10, "y", 20);

        // Act
        System.out.println("Existing List before: " + existingList);
        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);

        ListUtil.addAllMapsToList(existingList, map1, map2);
        Console.println("existingList:" + existingList);
    }

    /**
     * Test for fullOuterJoin.
     */
    @Test
    public void testFullOuterJoin() {
        // Perform the method call
        // 准备测试数据
        List<Map<String, Integer>> leftList = List.of(
                Map.of("id", 1, "value", 10),
                Map.of("id", 2, "value", 20),
                Map.of("id", 4, "value", 40)
        );

        List<Map<String, Integer>> rightList = List.of(
                Map.of("id", 2, "value", 200),
                Map.of("id", 3, "value", 300),
                Map.of("id", 4, "value", 400)
        );

        // 执行测试
        List<Map<String, Integer>> resultList = ListUtil.fullOuterJoin(
                leftList, rightList,
                (left, right) -> Integer.compare(left.get("id"), right.get("id")),
                (left, right) -> {
                    if (left == null) {
                        return Map.of("leftValue", null, "rightValue", right.get("value"));
                    } else if (right == null) {
                        return Map.of("leftValue", left.get("value"), "rightValue", null);
                    } else {
                        return Map.of("leftValue", left.get("value"), "rightValue", right.get("value"));
                    }
                }
        );

        // 验证结果
        for (Map<String, Integer> resultItem : resultList) {
            System.out.println(resultItem);
        }
    }
}