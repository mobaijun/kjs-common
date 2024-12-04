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

import com.mobaijun.common.collection.diff.Diff2;
import com.mobaijun.common.collection.util.Op;
import com.mobaijun.common.enums.comm.Sort;
import com.mobaijun.common.model.Role;
import com.mobaijun.common.model.User;
import com.mobaijun.common.tool.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * Description: [StreamUtilTest测试类]
 * Author: [mobaijun]
 * Date: [2023/12/29 8:56]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class StreamUtilTest {


    /**
     * Test for map.
     */
    @Test
    public void testMap() {
        // Perform the method call
    }

    /**
     * Test for filter.
     */
    @Test
    public void testFilter() {
        // Perform the method call
    }

    /**
     * Test for sorted.
     */
    @Test
    public void testSorted() {
        // Perform the method call
    }

    /**
     * Test for distinct.
     */
    @Test
    public void testDistinct() {
        // Perform the method call
    }

    /**
     * Test for distinctByKey.
     */
    @Test
    public void testDistinctByKey() {
        // Perform the method call
    }

    /**
     * Test for anyMatch.
     */
    @Test
    public void testAnyMatch() {
        // Perform the method call
    }

    /**
     * Test for join.
     */
    @Test
    public void testJoin() {
        // Perform the method call
        String result = StreamUtil.join(List.of("data"), "join");

        // Print the result using your Console
        Console.println(result);
    }

    /**
     * Test for singletonList.
     */
    @Test
    public void testSingletonList() {
        // Perform the method call
    }

    /**
     * Test for toList.
     */
    @Test
    public void testToList() {
        // Perform the method call
    }

    /**
     * Test for addAll.
     */
    @Test
    public void testAddAll() {
        // Perform the method call
    }

    /**
     * Test for addAll.
     */
    @Test
    public void testAddAll2() {

    }

    /**
     * Test for setToList.
     */
    @Test
    public void testSetToList() {

    }

    /**
     * Test for emptyList.
     */
    @Test
    public void testEmptyList() {
        // Perform the method call

    }

    /**
     * Test for emptyMap.
     */
    @Test
    public void testEmptyMap() {
        // Perform the method call

    }

    /**
     * Test for emptySet.
     */
    @Test
    public void testEmptySet() {
        // Perform the method call

    }

    /**
     * Test for strToLong.
     */
    @Test
    public void testStrToLong() {
        // Perform the method call
        List<Long> result = StreamUtil.strToLong(List.of("list"));

        // Print the result using your Console
        Console.println(result);
    }

    /**
     * Test for toString.
     */
    @Test
    public void testToString() {
        // Perform the method call

    }

    /**
     * Test for doubleToString.
     */
    @Test
    public void testDoubleToString() {
        // Perform the method call
        List<Double> result = StreamUtil.doubleToString(List.of("list"));

        // Print the result using your Console
        Console.println(result);
    }

    /**
     * Test for stringToInteger.
     */
    @Test
    public void testStringToInteger() {
        // Perform the method call
        List<Integer> result = StreamUtil.stringToInteger(List.of("list"));

        // Print the result using your Console
        Console.println(result);
    }

    @Test
    public void testStringToInteger2() {
        final List<User> jdkList = StreamUtil.list(
                        new User("Alice", 20, 168),
                        new User("Bob", 17, 178),
                        new User("Charlie", 19, 155),
                        new User("David", null, 158),
                        new User("Eve", 5, 158),
                        new User("Jack", 5, 152)
                )
                .toList();
        final List<User> myList = StreamUtil.clone(jdkList);

        boolean anyMatch = StreamUtil.list(myList).anyMatch(e -> e.getAge() > 19);
        System.out.println("anyMatch = " + anyMatch);
        boolean noneMatch = StreamUtil.list(myList).noneMatch(e -> e.getAge() > 119);
        System.out.println("noneMatch = " + noneMatch);

        final User clone = StreamUtil.clone(myList.get(0));

        StreamUtil.list(myList).count();

        StreamUtil.list(myList)
                .map(User::getAge)
                .map(String::valueOf)
                .toList();

        StreamUtil.list(jdkList)
                .concat(StreamUtil.asList(new User("Yama", 17, 201)))
                .toList();

        StreamUtil.list(myList)
                .isNotNull(User::getAge)
                .map(User::getName)
                .toList();
        StreamUtil.list(myList)
                .isNotBlank(User::getAge)
                .map(User::getName)
                .toList();
        StreamUtil.list(myList)
                .filterNotBlank(User::getAge)
                .map(User::getName)
                .toList();

        StreamUtil.list(myList)
                .isNull(User::getAge)
                .map(User::getName)
                .toList();
        StreamUtil.list(myList)
                .isBlank(User::getAge)
                .map(User::getName)
                .toList();
        StreamUtil.list(myList)
                .filterBlank(User::getAge)
                .map(User::getName)
                .toList();

        StreamUtil.list(myList)
                .distinct(User::getName)
                .toList();

        StreamUtil.list(myList)
                .filterOrs(
                        e -> "Alice".equals(e.getName()),
                        e -> "Bob".equals(e.getName())
                )
                .count();

        StreamUtil.list(myList)
                .filters(e -> e.getAge() != null,
                        e -> e.getAge() > 17)
                .count();

        StreamUtil.list(myList)
                .findFirst();

        List<List<Integer>> list = new ArrayList<>();
        list.add(StreamUtil.asList(1, 2, 3, 4, 5));
        list.add(StreamUtil.asList(6, 7, 8, 9, 10));
        list.add(StreamUtil.asList(11, 12, 13, 14, 15));

        StreamUtil.list(list)
                .flatMap(e -> e)
                .toList();

        StreamUtil.list(myList)
                .forEach(e -> System.out.println(e.getAge()));


        StreamUtil.list(myList)
                .groupBy(User::getAge, User::getName)
                .toMap();


        StreamUtil.list(myList)
                .groupBy(User::getAge)
                .valueStream(e -> e.map(User::getName).toList())
                .toMap();

        Map<Integer, Map<String, Long>> myGroup = StreamUtil.list(myList)
                .groupBy(User::getAge)
                .valueStream(e -> e.groupBy(User::getName).valueStream(ListStream::count).toMap())
                .toMap();

        Map<Integer, Map<String, Long>> myGroup2 = StreamUtil.list(myList)
                .groupingBy(
                        User::getAge,
                        Collectors.groupingBy(User::getName, Collectors.counting())
                )
                .toMap();

        StreamUtil.list(myList)
                .map(User::getName)
                .joining(",");

        StreamUtil.list(myList)
                .limit(3)
                .toList();

        StreamUtil.asList(1, 2, 3, 4);

        StreamUtil.list(1, 2, 3, 4)
                .map(e -> e + 1)
                .toList();

        final Map<Integer, String> my = StreamUtil.asMap(1, "2");

        final Map<Integer, String> my2 = StreamUtil.map(1, "2")
                .put(2, "3")
                .toMap();

        final Map<Integer, String> my3 = StreamUtil.map(1, "2")
                .put(2, "3")
                .hasKey(2, System.out::println) // 2
                .hasKey(4, "4", System.out::println) // 4
                .toMap();

        Op<User> op = StreamUtil.op(myList.get(0));
        op.isNotBlank(user -> System.out.println("my isNotBlank"));
        op.isNotBlankOrElse(user -> System.out.println("my isNotBlankOrElse isNotBlank"), () -> {
            System.out.println("my isNotBlankOrElse else");
        });
        if (op.isNotBlank()) {
            User my4 = op.get();
            System.out.println("my isNotBlank");
        }
        op.isBlank(user -> {
            System.out.println("my isBlank " + user);
        });
        op.isBlankOrElse(user -> {
            System.out.println("my isBlankOrElse isBlank " + user);
        }, () -> {
            System.out.println("my isBlankOrElse else");
        });
        if (op.isBlank()) {
            User my5 = op.get(jdkList.get(0));
            System.out.println("my isBlank get default value " + my);
        }
        String name = StreamUtil.op(jdkList.get(0))
                .map(User::getName)
                .get();

        StreamUtil.list(myList)
                .peek(e -> e.setName(e.getName() + "123"))
                .map(User::getName)
                .toList();

        List<String> my6 = StreamUtil.list(myList)
                .peekStream(e -> e
                        .filters(t -> t.getAge() > 17)
                        .forEach(t -> t.setName(t.getName() + "123"))
                )
                .map(User::getName)
                // 输出 myList 但是 t.getAge() > 17 的两个值被修改
                .toList();

        StreamUtil.list(myList)
                .isNotNull(User::getAge)
                .map(User::getAge)
                .reduce(ArrayList::new, ArrayList::add);


        StreamUtil.list(myList)
                .isNotNull(User::getAge)
                .reduce(ArrayList::new, User::getAge, ArrayList::add);


        StreamUtil.list(myList)
                .sort(User::getAge, Sort.Asc)
                .reversed()
                .toList();

        StreamUtil.list(myList)
                .skip(3)
                .toList();

        StreamUtil.list(myList)
                .sortDesc(User::getAge)
                .map(User::getAge)
                .toList();
        StreamUtil.list(myList)
                .sortAsc(User::getAge)
                .map(User::getAge)
                .toList();

        StreamUtil.list(myList)
                .sort(
                        s -> s.createComparator(User::getAge, Sort.Desc, Sort.NullLast),
                        s -> s.createComparator(User::getHeight, Sort.Desc, Sort.NullLast)
                )
                .toList();

        StreamUtil.list(myList)
                .sort(User::getAge, Sort.Desc, Sort.NullFirst)
                .toList();

        StreamUtil.list(myList)
                .sort(Comparator.comparing(User::getAge))
                .toList();

        StreamUtil.list(myList)
                .map(User::getAge)
                .sort(Integer::compareTo)
                .toList();

        StreamUtil.list(jdkList)
                .split(1, l -> {
                    assert l.size() == 1;
                });

        StreamUtil.list(myList)
                .sub(3)
                .toList();

        StreamUtil.list(myList)
                .sub(2, 4)
                .toList();

        StreamUtil.list(myList)
                .filterNotNull(User::getAge)
                .map(User::getAge)
                .sumInt();
        StreamUtil.list(myList)
                .filterNotNull(User::getAge)
                .sumInt(User::getAge);
        StreamUtil.list(jdkList)
                .filterNotNull(User::getAge)
                .map(User::getName)
                .sumInt();
        StreamUtil.list(myList)
                .filterNotNull(User::getAge)
                .map(User::getAge)
                .sumDouble();
        StreamUtil.list(myList)
                .filterNotNull(User::getAge)
                .sumDouble(User::getAge);
        StreamUtil.list(jdkList)
                .filterNotNull(User::getAge)
                .map(User::getName)
                .sumDouble();
        StreamUtil.list(myList)
                .filterNotNull(User::getAge)
                .map(User::getAge)
                .sumLong();
        StreamUtil.list(myList)
                .filterNotNull(User::getAge)
                .sumLong(User::getAge);
        StreamUtil.list(jdkList)
                .filterNotNull(User::getAge)
                .map(User::getName)
                .sumLong();

        final Map<String, User> map = StreamUtil.list(myList)
                .toMap(User::getName);
        final Map<String, Integer> map1 = StreamUtil.list(myList)
                .isNotNull(User::getAge)
                .toMap(User::getName, User::getAge);
        Map<String, Integer> map2 = StreamUtil.list(myList)
                .isNotNull(User::getAge)
                .toMap(User::getName, User::getAge, (a, b) -> b);
        Map<String, Integer> map3 = StreamUtil.list(myList)
                .isNotNull(User::getAge)
                .toLinkedMap(User::getName, User::getAge);

        boolean equals = StreamUtil.tryBegin(() -> {
                    System.out.println("success");
                    return "123";
                })
                .andThen(() -> System.out.println("success2"))
                .andThen(val -> System.out.println(val))
                .andFinally(() -> System.out.println("finally"))
                .onFailure(throwable -> {
                    System.out.println("error");
                })
                .get().equals("123");

        StreamUtil.tryBegin(() -> {
                    System.out.println("success");
                    return "123";
                })
                .andThen(() -> {
                    throw new RuntimeException("1213");
                })
                .andThen(() -> {
                    System.out.println("success2");
                })
                .andThen(val -> {
                    System.out.println(val);
                })
                .andThen(() -> {
                    throw new RuntimeException("1213");
                })
                .andFinally(() -> {
                    System.out.println("finally");
                })
                .onFailure(throwable -> {
                    System.out.println("error");
                })
                .isFailure();


        StreamUtil.getDiff(jdkList, myList, (oldUser, newUser) -> oldUser.getName().equals(newUser.getName()))
                .addConsumer((t, l) -> {
                    assert l.size() == 2;
                })
                .updateConsumer((l, changeMap) -> {
                    assert changeMap.size() == 4;
                })
                .delConsumer((t, l) -> {
                    assert l.size() == 2;
                });


        final List<Role> roleList = StreamUtil.asList(
                // 名字相同
                new Role("Alice", 1),
                new Role("user", 2),
                new Role("rootUser", 3),
                new Role("admin", null),
                new Role("admin", 3)
        );

        Diff2<Role, User> roleUserDiff2 = StreamUtil.getDiff2(roleList, jdkList,
                        (role, user) -> role.getRoleName().equals(user.getName())
                )
                .addConsumer((t, l) -> {
                    assert l.size() == 5;
                })
                .updateConsumer((l, changeMap) -> {
                    assert changeMap.size() == 1;
                })
                .delConsumer((t, l) -> {
                    assert l.size() == 4;
                });

        // 超长链式调用
        Map<Integer, List<String>> result = StreamUtil.list(myList)
                // 过滤年龄大于10
                .filter(user -> user.getAge() != null && user.getAge() > 10)
                .isNotNull(User::getAge)
                .isNull(User::getAge)
                .ors(e -> e.getAge() > 10,
                        e -> e.getAge() < 100)
                .ands(e -> e.getAge() > 10,
                        e -> e.getAge() < 100)
                .skip(10)
                .sub(10)
                .sub(1, 10)
                .concat(StreamUtil.asList(new User("zs", 50, 167)))
                .add(new User("zs", 50, 167))
                .reversed()
                // 获取名字
                .map(User::getName)
                // 去重
                .distinct()
                // 排序
                .sort(Comparator.naturalOrder())
                .peek(n -> System.out.println("Processing name: " + n))
                // 转换为大写
                .map(String::toUpperCase)
                // 过滤以"A"开头的名字
                .filter(n -> n.startsWith("A"))
                // 限制结果数量
                .limit(5)
                .map(n -> new User(n, 50, 167))
                .groupBy(User::getAge)
                .valueStream(e -> e.map(User::getName).toList())
                .toMap();
    }
}