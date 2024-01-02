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
package com.mobaijun.common.util;

import org.junit.Test;

import java.util.Map;

/**
 * Description: [UrlParamsUtilTest测试类]
 * Author: [mobaijun]
 * Date: [2023/12/21 9:59]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class UrlParamsUtilTest {

    @Test
    public void testSplit() {
        Map<String, String> result = UrlParamsUtil.
                parseUrlParams("http://localhost:8080/sys/monitor-process-property/list?PId=39bb8e4e211dc01e32fd06c801715d40&pageindex=0&pagesize=10");
        PrintUtil.print(result);
    }

    @Test
    public void testSplit2() {
        Map<String, String> result = UrlParamsUtil.parseUrlParams("http://localhost:8080/sys/monitor-process-property/list?PId=39bb8e4e211dc01e32fd06c801715d40&pageindex=0&pagesize=10", "=");
        PrintUtil.print(result);
    }
}