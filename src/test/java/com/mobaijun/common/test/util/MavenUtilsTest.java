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
package com.mobaijun.common.test.util;

import com.mobaijun.common.util.MavenUtil;
import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: MavenUtilsTest
 * class description: maven 清理工具类
 *
 * @author MoBaiJun 2022/11/22 18:50
 */
public class MavenUtilsTest {

    @Test
    public void mavenCleanTest() {
        // maven 清理无效 jar 包
        MavenUtil.mavenClear("F:\\repository");
    }
}
