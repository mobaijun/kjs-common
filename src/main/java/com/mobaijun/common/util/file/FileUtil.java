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
package com.mobaijun.common.util.file;

import com.mobaijun.common.constant.JdkConstant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: FileUtils<br>
 * 类描述： 文件工具类
 *
 * @author MoBaiJun 2022/4/22 17:06
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {

    private static final File SYSTEM_TEMP_DIR = new File(System.getProperty("java.io.tmpdir"));

    /**
     * 存储文件列表
     */
    private static final ArrayList<String> FILE_LIST = new ArrayList<>();

    /**
     * 正则
     */
    private static final String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+";

    static {
        updateTmpDir("april");
    }

    /**
     * 输出指定文件的byte数组
     *
     * @param filePath 文件路径
     * @param os       输出流
     * @throws IOException IOException
     */
    public static void writeBytes(String filePath, OutputStream os) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new FileNotFoundException(filePath);
        }
        Files.copy(path, os);
    }

    /**
     * 删除文件
     *
     * @param filePath 文件
     */
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (!file.isFile() && !file.exists()) {
            return false;
        }
        return file.delete();
    }

    /**
     * 文件名称验证
     *
     * @param filename 文件名称
     * @return true 正常 false 非法
     */
    public static boolean isValidFilename(String filename) {
        return filename.matches(FILENAME_PATTERN);
    }

    /**
     * 复制文件
     *
     * @param src  源地址
     * @param dest 目标地址
     * @return 是否成功
     */
    public static boolean copyFile(File src, File dest) {
        try {
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取系统临时文件
     *
     * @return 临时文件
     */
    public static File getSystemTempDir() {
        return new File(System.getProperty(JdkConstant.TMPDIR));
    }

    /**
     * 更新临时文件路径
     */
    public static void updateTmpDir(String dirName) {
        Path tempDirPath = Paths.get(SYSTEM_TEMP_DIR.getPath(), dirName);
        try {
            Files.createDirectories(tempDirPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取临时文件, 不会创建文件
     */
    public static File getTemplateFile(String name) throws IOException {
        File file;
        do {
            file = new File(JdkConstant.TMPDIR, System.currentTimeMillis() + "." + name);
        } while (!file.createNewFile());
        return file;
    }

    /**
     * 根据网络路径获取文件输入流
     */
    public static InputStream getInputStreamByUrlPath(String path) throws IOException {
        URL url;
        try {
            url = new URL(path);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL: " + path, e);
        }

        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setConnectTimeout(5 * 1000);
        httpConnection.setReadTimeout(5 * 1000);

        return httpConnection.getInputStream();
    }

    /**
     * 从路径中读取文件内容字符串
     *
     * @param path 相对于resource目录的相对路径
     * @return 文件内容字符串
     */
    public static String readTemplate(String path) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

        if (inputStream == null) {
            throw new RuntimeException("读取文件失败");
        } else {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            Stream<String> streamOfString = new BufferedReader(inputStreamReader).lines();
            return streamOfString.collect(Collectors.joining());
        }
    }

    /**
     * 获取目录下所有文件
     *
     * @param directoryPath 目录地址
     * @return 文件列表
     */
    public static List<File> getAllFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directoryPath + " is not a directory");
        }
        return Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .flatMap(file -> file.isDirectory() ? getAllFilesInDirectory(file.getAbsolutePath()).stream() : Stream.of(file))
                .collect(Collectors.toList());
    }

    /**
     * 读取文件内容并指定文件和编码
     *
     * @param file    文件
     * @param charset 字符编码
     * @return 文本列表
     */
    public static List<String> readLines(File file, Charset charset) {
        List<String> lines = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath()), charset))) {
                String line;
                while (true) {
                    try {
                        if ((line = reader.readLine()) == null) {
                            break;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    lines.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return lines;
    }

    /**
     * 内容写入文件
     *
     * @param newLines 文本列表
     * @param file     文件
     */
    public static <T> void writeUtf8Lines(ArrayList<T> newLines, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (T line : newLines) {
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 追加写入文件
     *
     * @param lines    文件列表
     * @param fileName 文件名
     * @param append   是否链接
     */
    public static <T> boolean appendToFile(Collection<T> lines, String fileName, boolean append) {
        if (lines == null) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            for (T line : lines) {
                writer.write(line.toString());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 该方法首先判断传入的文件名是否为null，如果是，则直接返回null。
     * 否则，使用lastIndexOf方法查找文件名中最后一个点号的位置，如果不存在点号，
     * 则说明该文件名没有后缀，直接返回原文件名；否则，使用substring方法截取文件名中点号之前的部分，即为文件前缀。
     * 最后将截取到的文件前缀返回即可。
     *
     * @param fileName 文件名称
     * @return 文件名
     */
    public static String getFilePrefix(String fileName) {
        if (fileName == null) {
            return null;
        }
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }
}