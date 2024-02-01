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
package com.mobaijun.common.license;

import com.mobaijun.common.file.FileUtil;
import com.mobaijun.common.text.Charsets;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: LicenseTitleAppenderUtil<br>
 * class description：一键添加开源协议许可<br>
 *
 * @author MoBaiJun 2022/5/12 11:35
 */
@Slf4j
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

    /**
     * 从指定目录下的所有文件中删除包含指定许可证头部的内容。
     *
     * @param codeDirectory 指定的目录
     * @param licenseHeader 许可证头部
     */
    public static void removeLicense(String codeDirectory, String licenseHeader) {
        try (Stream<Path> paths = Files.walk(Paths.get(codeDirectory))) {
            // 遍历指定目录下的所有文件，过滤掉非普通文件（例如目录或符号链接），
            // 并将路径转换成对应的File对象
            paths.filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(file -> {
                        try {
                            // 读取文件的所有行到List中
                            List<String> fileLines = Files.readAllLines(file.toPath(), Charsets.UTF_8);
                            // 找到第一行包含许可证头部的行号
                            OptionalInt startLineIndex = IntStream.range(0, fileLines.size())
                                    .filter(i -> fileLines.get(i).contains(licenseHeader))
                                    .findFirst();
                            if (startLineIndex.isPresent()) {
                                // 找到最后一行包含 */ 的行号
                                OptionalInt endLineIndex = IntStream.range(startLineIndex.getAsInt(), fileLines.size())
                                        .filter(i -> "*/".equals(fileLines.get(i)))
                                        .findFirst();
                                if (endLineIndex.isPresent()) {
                                    // 将第一行到最后一行之间的内容替换为一个空List
                                    List<String> newLines = Stream.concat(
                                                    fileLines.subList(0, startLineIndex.getAsInt()).stream(),
                                                    fileLines.subList(endLineIndex.getAsInt() + 1, fileLines.size()).stream())
                                            .collect(Collectors.toList());
                                    // 将新内容写入文件
                                    Files.write(file.toPath(), newLines, Charsets.UTF_8);
                                }
                            }
                        } catch (IOException e) {
                            log.error("Content reading and writing failed:" + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            log.error("Content reading and writing failed:" + e.getMessage());
        }
    }
}