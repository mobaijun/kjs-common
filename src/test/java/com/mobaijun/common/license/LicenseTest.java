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
package com.mobaijun.common.license;

import com.mobaijun.common.enums.comm.LicenseType;
import org.junit.Test;

/**
 * Description: [LicenseTest测试类]
 * Author: [mobaijun]
 * Date: [2024/1/2 10:31]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class LicenseTest {

    /**
     * Test for append.
     */
    @Test
    public void testAppend() {
        // Perform the method call
        LicenseTitleAppenderUtil.append(
                "src/main/java/com/mobaijun/common",
                String.format(LicenseType.APACHE_2.getValue(), "www.mobaijun.com"));
    }

    /**
     * Test for removeLicense.
     */
    @Test
    public void testRemoveLicense() {
        // Perform the method call
        LicenseTitleAppenderUtil.removeLicense("D:\\ideaProject\\my-project\\kjs-comm\\src\\test\\java\\com\\mobaijun\\comm\\collection\\", "/*");
    }
}
