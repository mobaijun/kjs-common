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
package com.mobaijun.common.test.download;

import com.mobaijun.common.download.DownloadUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: DownloadUtilTest<br>
 * class description:
 *
 * @author MoBaiJun 2023/3/13 11:47
 */
public class DownloadUtilTest {

    @Test
    public void testDownloadFile() throws IOException {
        DownloadUtil.downloadFile("https://tencent.cos.mobaijun.com/img/banner/2.jpg",
                "D:\\ideaProject\\kjs-projects\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\test\\download\\2.jpg");
    }

    @Test
    public void testCopyFile() {
        DownloadUtil.copyFile(new File("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\test\\download\\2.jpg"),
                new File("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\test\\download\\3.jpg"));
    }
}
