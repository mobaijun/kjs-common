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
package com.mobaijun.common.test.system;

import com.mobaijun.common.collection.CollectionUtil;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.system.HostUtil;
import org.junit.Test;

import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: HostUtilTest
 * class description: host 测试用例
 *
 * @author MoBaiJun 2022/12/10 0:45
 */
public class HostUtilTest {

    /**
     * 52.74.223.119 github.com
     * 69.171.248.65 github.global.ssl.fastly.net
     * 185.199.111.153 assets-cdn.github.com
     */
    @Test
    public void hostUtilTest() {
        Map<String, String> map = CollectionUtil.newHashMap(10);
        map.put("69.171.248.65", "github.global.ssl.fastly.net");
        map.put("52.74.223.119", "github.com");
        map.put("185.199.111.153", "assets-cdn.github.com");
        // 打印是否修改成功
        map.forEach((key, value) -> PrintUtil.println(HostUtil.append(key, value)));

        // 打印修改后的结果
        PrintUtil.println(HostUtil.readHosts());
    }
}
