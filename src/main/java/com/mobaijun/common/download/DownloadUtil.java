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
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: DownloadUtils<br>
 * 类描述： 文件下载
 *
 * @author MoBaiJun 2022/5/5 8:59
 */
public class DownloadUtil {

    /**
     * 文件下载
     *
     * @param url         保存的文件路径
     * @param destination 需要存的文件流
     * @return 是|否
     */
    public static void downloadFile(String url, String destination) throws IOException {
        URL fileUrl = new URL(url);
        URLConnection connection = fileUrl.openConnection();
        try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
             BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(Paths.get(destination)))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    /**
     * 文件拷贝
     * @param source 拷贝的文件源路径
     * @param target 拷贝的目标路径
     */
    public static void fileCopy(String source, String target) {
        try (FileChannel in = new FileInputStream(source).getChannel();
             FileChannel out = new FileOutputStream(target, true).getChannel()) {
            out.transferFrom(in, 0, in.size());
        } catch (Exception e) {
            System.out.println("fileCopyError:" + e);
        }
    }
}