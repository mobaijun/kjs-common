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

import com.mobaijun.common.util.file.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: FileUtilTest<br>
 * class description: 文件工具测试用例
 *
 * @author MoBaiJun 2023/3/2 0:07
 */
public class FileUtilTest {

    @Test
    public void testWriteBytes() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String filePath = "D:\\ideaProject\\kjs-projects\\kjs-common\\src\\test\\resources\\1.jpg";
        String content = "Hello, world!";
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.flush();
        writer.close();
        FileUtil.writeBytes(filePath, outputStream);
        String result = outputStream.toString();
        Assert.assertEquals(content, result);
    }
}
