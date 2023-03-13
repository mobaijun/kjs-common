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

import com.mobaijun.common.license.LicenseEntity;
import com.mobaijun.common.license.LicenseUtil;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: LicenseUtilTest<br>
 * class description: 许可证测试类
 *
 * @author MoBaiJun 2023/2/22 0:52
 */
public class LicenseUtilTest {

    @Test
    public void licenseUtilTest() throws IOException {
        InputStream inputStream = LicenseUtilTest.class.getClassLoader().getResourceAsStream("License");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int size;
        byte[] buffer = new byte[1024];
        while (true) {
            assert inputStream != null;
            if (!((size = inputStream.read(buffer)) > 0)) break;
            byteArrayOutputStream.write(buffer, 0, size);
        }
        inputStream.close();
        LicenseUtil license = new LicenseUtil();
        LicenseEntity licenseData = license.loadLicense(byteArrayOutputStream.toByteArray());
        System.out.println(new String(licenseData.getData()));
    }
}
