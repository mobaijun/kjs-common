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
package com.mobaijun.common.license;

import com.mobaijun.common.util.file.FileUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: LicenseTitleAppenderUtil<br>
 * class description：一键添加开源协议许可<br>
 *
 * @author MoBaiJun 2022/5/12 11:35
 */
public class LicenseTitleAppenderUtil {

    /**
     * 为指定目录下所有java文件添加开源协议
     *
     * @param codeDirectory 代码路径
     * @param licenseHeader 协议头
     */
    @SuppressWarnings("all")
    public static void append(String codeDirectory, String licenseHeader) {
        List<File> files = FileUtil.getAllFilesInDirectory(codeDirectory);
        files.stream().filter(file -> file.getName().endsWith(".java"))
                .forEach(file -> {
                    List<String> strings = FileUtil.readLines(file, StandardCharsets.UTF_8);
                    if (!"/*".equals(strings.get(0))) {
                        ArrayList<Object> newLines = new ArrayList<>(32);
                        newLines.add(licenseHeader);
                        newLines.addAll(strings);
                        FileUtil.writeUtf8Lines(newLines, file);
                    }
                });
    }
}