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

/**
 * Description: [MavenUtilTest 测试类]
 * Author: [mobaijun]
 * Date: [2023/12/19 15:00]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class MavenUtilTest {

    @Test
    public void mavenClear() {
        // 删除无效文件
        MavenUtil.mavenClear("D:\\repository");
    }
}