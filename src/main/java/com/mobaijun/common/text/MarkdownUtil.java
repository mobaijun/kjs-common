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
package com.mobaijun.common.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * software：IntelliJ IDEA 2023.1.1<br>
 * class name: MarkdownUtil<br>
 * class description: markdown 图片解析工具类
 *
 * @author MoBaiJun 2023/4/12 22:39
 */
public class MarkdownUtil {

    /**
     * markdown 文件后缀
     */
    private static final String MARKDOWN_FILE_EXTENSION = ".md";

    /**
     * 正则表达式
     */
    private static final Pattern IMAGE_URL_PATTERN = Pattern.compile("!\\[.*?\\]\\((.*?)\\)");

    /**
     * 获取指定文件夹下的所有Markdown文件路径
     *
     * @param folderPath 文件夹路径
     * @return Markdown文件路径列表
     */
    public static List<String> getMarkdownFilePaths(String folderPath) {
        File folder = new File(folderPath);
        return Stream.of(Objects.requireNonNull(folder.listFiles()))
                .filter(file -> file.isFile() && file.getName().endsWith(MARKDOWN_FILE_EXTENSION))
                .map(File::getPath)
                .toList();
    }

    /**
     * 获取指定Markdown文件中的文本内容
     *
     * @param filePath Markdown文件路径
     * @return Markdown文本
     */
    public static String getMarkdownText(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    /**
     * 获取Markdown文本中的所有图片URL
     *
     * @param markdownText Markdown文本
     * @return 图片URL列表
     */
    public static List<String> getImageUrlsFromMarkdown(String markdownText) {
        Matcher matcher = IMAGE_URL_PATTERN.matcher(markdownText);
        Iterable<String> iterable = () -> new Iterator<>() {
            String nextMatch = matcher.find() ? matcher.group(1) : null;

            @Override
            public boolean hasNext() {
                return nextMatch != null;
            }

            @Override
            public String next() {
                String currentMatch = nextMatch;
                nextMatch = matcher.find() ? matcher.group(1) : null;
                return currentMatch;
            }
        };
        return StreamSupport.stream(iterable.spliterator(), false)
                .toList();
    }

    /**
     * 获取指定Markdown文件中的所有图片URL
     *
     * @param filePath Markdown文件路径
     * @return 图片URL列表
     */
    public static List<String> getImageUrlsFromMarkdownFile(String filePath) {
        String markdownText;
        try {
            markdownText = getMarkdownText(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return getImageUrlsFromMarkdown(markdownText);
    }

    /**
     * 获取指定文件夹下所有Markdown文件中的所有图片URL
     *
     * @param folderPath 文件夹路径
     * @return 所有Markdown文件中的图片URL列表
     */
    public static List<String> getImageUrlsFromMarkdownFolder(String folderPath) {
        return getMarkdownFilePaths(folderPath).parallelStream()
                .flatMap(filePath -> {
                    try {
                        return getImageUrlsFromMarkdownFile(filePath).stream();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return Stream.empty();
                    }
                })
                .toList();
    }
}
