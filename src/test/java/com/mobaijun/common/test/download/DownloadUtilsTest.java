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
package com.mobaijun.common.test.download;

import com.mobaijun.common.download.DownloadUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: DownloadUtilsTest
 * class description: 下载测试工具类
 *
 * @author MoBaiJun 2022/11/22 14:27
 */
public class DownloadUtilsTest {
    /**
     * 文件下载测试
     * @throws Exception
     */
    @Test
    public void downloadFileTest() throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\test\\qqqq.txt"));
        boolean b = DownloadUtil.downloadFile("D:\\test\\111.txt", fileOutputStream);
        System.out.println("downloadFile is "+ b);
    }
}
