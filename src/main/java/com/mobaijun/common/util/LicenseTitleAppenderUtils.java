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
package com.mobaijun.common.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: LicenseTitleAppenderUtil
 * class description：一键添加开源协议头
 *
 * @author MoBaiJun 2022/5/12 11:35
 */
public class LicenseTitleAppenderUtils {

    /**
     * 为指定目录下所有java文件添加开源协议
     *
     * @param codeDirectory 代码路径
     * @param licenseHeader 协议头
     */
    @SuppressWarnings("all")
    public static void append(String codeDirectory, String licenseHeader) {
        List<File> files = FileUtil.loopFiles(codeDirectory);
        files.stream().filter(file -> file.getName().endsWith(".java"))
                .forEach(file -> {
                    List<String> strings = FileUtil.readLines(file, CharsetUtil.UTF_8);
                    if (!"/*".equals(strings.get(0))) {
                        ArrayList<Object> newLines = new ArrayList<>(32);
                        newLines.add(licenseHeader);
                        newLines.addAll(strings);
                        FileUtil.writeUtf8Lines(newLines, file);
                    }
                });
    }

    public static void main(String[] args) {
        append("F:\\IdeaProjects\\kjs-common\\src\\main\\java\\com\\mobaijun\\common","/*\n" +
                " * Copyright (C) 2022 www.mobaijun.com\n" +
                " *\n" +
                " * Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                " * you may not use this file except in compliance with the License.\n" +
                " * You may obtain a copy of the License at\n" +
                " *\n" +
                " *         https://www.apache.org/licenses/LICENSE-2.0\n" +
                " *\n" +
                " * Unless required by applicable law or agreed to in writing, software\n" +
                " * distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                " * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                " * See the License for the specific language governing permissions and\n" +
                " * limitations under the License.\n" +
                " */");
    }
}