/*
 * Copyright (C) 2022 www.mobaijun.com
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
package com.mobaijun.common.test.cache;

import com.mobaijun.common.cache.HashMapSingletonCacheUtils;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.Optional;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: HashMapSingletonCacheUtilsTest
 * class description: 单例缓存
 *
 * @author MoBaiJun 2022/11/22 14:13
 */
public class HashMapSingletonCacheUtilsTest {

    @Test
    public void hashMapSingletonCacheUtilsTest() {
        HashMapSingletonCacheUtils instance = HashMapSingletonCacheUtils.getInstance();
        instance.add("name", "mobaijun");
        PrintUtil.println(instance.getAll());
        PrintUtil.println(instance.contains("name"));

        // 存在即输出
        Optional<Object> name = instance.get("name");
        name.ifPresent(PrintUtil::println);

        instance.remove("name");
        instance.removeAll();
    }
}
