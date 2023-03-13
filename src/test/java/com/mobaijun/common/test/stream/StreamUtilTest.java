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
package com.mobaijun.common.test.stream;


import com.mobaijun.common.collection.CollectionUtil;
import com.mobaijun.common.collection.StreamUtil;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: StreamUtilTest<br>
 * class description: <br>
 *
 * @author MoBaiJun 2022/12/13 10:18
 */
public class StreamUtilTest {

    @Test
    public void streamUtilTest() {
        Map<String, String> map = CollectionUtil.newHashMap();
        map.put("mobaijun", "123");
        Map<String, String> maps = CollectionUtil.newHashMap();
        maps.put("s", "ss");
        // 两个Map进行合并
        StreamUtil.addAll(map, maps);
        PrintUtil.println(map);

        // 生成list
        List<String> list = StreamUtil.toList("2", "2", "3", "4");
        PrintUtil.println(list);
    }
}
