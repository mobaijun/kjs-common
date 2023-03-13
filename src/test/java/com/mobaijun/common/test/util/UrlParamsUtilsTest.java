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
package com.mobaijun.common.test.util;

import com.mobaijun.common.collection.MapUtil;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.UrlParamsUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: UrlParamsUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 17:48
 */
public class UrlParamsUtilsTest {

    @Test
    public void urlParamsUtilsTest() {
        Map<String, String> map = new HashMap<>(10);
        map.put("1", "mobai");
        map.put("2", "mobaijun");
        map.put("3", "mobai123");
        // 将Map转成String, 可以指定分隔符
        PrintUtil.println(MapUtil.mapToString(map, ","));

        // 解析ulr参数为map
        PrintUtil.println(UrlParamsUtil.split("https://www.mobaijun.com/test/demo_form.php?name1=value1&name2=value2"));
    }
}
