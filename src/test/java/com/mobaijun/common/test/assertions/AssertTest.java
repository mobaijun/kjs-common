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
package com.mobaijun.common.test.assertions;

import com.mobaijun.common.assertions.Assert;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: AssertTest<br>
 * class description: 断言测试类
 *
 * @author MoBaiJun 2023/3/12 11:13
 */
public class AssertTest {

    @Test
    public void assert1() {
        // 此方法无法校验""
        // Assert.notNull(null,"字符串不能为空");
        // Assert.notNull(null,"name","字符串不能为空");

        // Assert.assertTrue(false, "结果错误！");

        // 打印map
        // Map<String, String> map = new HashMap<>(Collections.emptyMap());
        // map.put("1", "1");
        // PrintUtil.println(Assert.nullToEmptyMap(map));

        // 集合
        List<String> list = new LinkedList<>();
        list.add("1");
        list.clear();
        PrintUtil.println(Assert.nullToEmptyCollection(list));
    }
}
