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

import com.mobaijun.common.util.NamingUtil;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: NamingUtilsTest
 * class description: 名称转换测试类
 *
 * @author MoBaiJun 2022/12/1 16:09
 */
public class NamingUtilsTest {

    @Test
    public void namingUtilsTest() {
        // 驼峰转中划线
        PrintUtil.println(NamingUtil.humpToMidline("userName"));
        // 驼峰转下划线
        PrintUtil.println(NamingUtil.humpToUnderline("userName"));
        // 下划线转驼峰
        PrintUtil.println(NamingUtil.underlineToHump("user_name"));
    }
}
