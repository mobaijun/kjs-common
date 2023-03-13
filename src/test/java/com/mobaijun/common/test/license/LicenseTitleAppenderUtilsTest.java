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
package com.mobaijun.common.test.license;

import com.mobaijun.common.constant.LicenseConstant;
import com.mobaijun.common.license.LicenseTitleAppenderUtil;
import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: LicenseTitleAppenderUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 17:48
 */
public class LicenseTitleAppenderUtilsTest {

    @Test
    public void licenseTitleAppenderUtilTest() {
        LicenseTitleAppenderUtil.append("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\main\\java\\com\\mobaijun\\common"
                , String.format(LicenseConstant.APACHE_2, "www.mobaijun.com"));
        LicenseTitleAppenderUtil.append("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\test\\java\\com\\mobaijun\\common"
                , String.format(LicenseConstant.APACHE_2, "www.mobaijun.com"));
    }

    @Test
    public void remove() {
        // 删除开源协议
        LicenseTitleAppenderUtil.removeLicense("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\test", "/*");
        LicenseTitleAppenderUtil.removeLicense("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\main\\java\\com\\mobaijun\\common", "/*");
    }
}
