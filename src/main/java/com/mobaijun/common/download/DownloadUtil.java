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
package com.mobaijun.common.download;

import java.io.*;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: DownloadUtils<br>
 * 类描述： 文件下载
 *
 * @author MoBaiJun 2022/5/5 8:59
 */
public class DownloadUtil {
    /**
     * @param fileUrl      保存的文件路径
     * @param outputStream  需要存的文件流
     * @return 是|否
     */
    public static boolean downloadFile(String fileUrl, OutputStream outputStream) throws Exception {
        File file = new File(fileUrl);
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             OutputStream os = outputStream;) {
            byte[] buffer = new byte[1024];
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            file.delete();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}