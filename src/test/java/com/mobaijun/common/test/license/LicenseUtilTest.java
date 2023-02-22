/*
 * Copyright (c) 2020-2020, org.smartboot. All rights reserved.
 * project name: smart-license
 * file name: LicenseTest.java
 * Date: 2020-03-22
 * Author: sandao (zhengjunweimail@163.com)
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
