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

import com.mobaijun.common.constant.NumberConstant;
import com.mobaijun.common.util.date.DateFormat;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
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

    /**
     * 系统的临时文件夹
     */
    private static File tempDir;

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
        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException(filePath);
            }
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length;
            while ((length = fis.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
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
     * 获取目录下所有文件路径
     *
     * @param path 地址
     * @throws IOException IO 异常
     */
    private static void getFileList(File path) throws IOException {
        File[] listFile = path.listFiles();
        assert listFile != null;
        for (File a : listFile) {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(a.toPath(), BasicFileAttributes.class);
            if (basicFileAttributes.isDirectory()) {
                // 递归调用getFile()方法
                getFileList(new File(a.getAbsolutePath()));
            } else if (basicFileAttributes.isRegularFile()) {
                FILE_LIST.add(a.getAbsolutePath());
            }
        }
    }

    /**
     * 下载文件
     *
     * @param filePath   下载地址
     * @param outPutPath 输出地址
     */
    public static boolean download(String filePath, String outPutPath) {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new URL(filePath).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(outPutPath);
            byte[] data = new byte[NumberConstant.FIRST_CLASS];
            int byteContent;
            while ((byteContent = inputStream.read(data, NumberConstant.ZERO, NumberConstant.FIRST_CLASS)) != NumberConstant.MINUS_ONE) {
                fileOutputStream.write(data, NumberConstant.ZERO, byteContent);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            // handles IO exceptions
            e.printStackTrace();
            return false;
        }
        return true;
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

    public static File getSystemTempDir() {
        return new File(System.getProperty("java.io.tmpdir"));
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
            file = new File(tempDir, System.currentTimeMillis() + "." + name);
        } while (!file.createNewFile());
        return file;
    }

    /**
     * 根据网络路径获取文件输入流
     */
    public static InputStream getInputStreamByUrlPath(String path) throws IOException {
        // 校验URL的合法性
        URL url;
        try {
            url = new URL(path);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL: " + path);
        }

        // 从文件链接里获取文件流
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setConnectTimeout(5 * 1000);
        httpConnection.setReadTimeout(5 * 1000);

        try {
            return new BufferedInputStream(httpConnection.getInputStream());
        } catch (IOException e) {
            httpConnection.disconnect();
            throw e;
        }
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
        List<File> fileList = new ArrayList<>();
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directoryPath + " is not a directory");
        }
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                fileList.addAll(getAllFilesInDirectory(file.getAbsolutePath()));
            } else {
                fileList.add(file);
            }
        }
        return fileList;
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
    public static void writeUtf8Lines(ArrayList<Object> newLines, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Object line : newLines) {
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
    public static boolean appendToFile(Collection<?> lines, String fileName, boolean append) {
        if (lines == null) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            for (Object line : lines) {
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
        if (dotIndex == -1) {
            return fileName;
        }
        return fileName.substring(0, dotIndex);
    }

    /**
     * 获取文件的创建时间等详情
     *
     * @param filePath 文件路径
     * @return 文件创建时间等详情
     */
    public static String getFileDetails(String filePath) {
        Path path = new File(filePath).toPath();
        BasicFileAttributes attributes;
        try {
            attributes = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LocalDateTime creationTime = LocalDateTime.ofInstant(attributes.creationTime().toInstant(), ZoneId.systemDefault());
        LocalDateTime lastAccessTime = LocalDateTime.ofInstant(attributes.lastAccessTime().toInstant(), ZoneId.systemDefault());
        LocalDateTime lastModifiedTime = LocalDateTime.ofInstant(attributes.lastModifiedTime().toInstant(), ZoneId.systemDefault());
        return String.format("Creation time: %s, Last access time: %s, Last modified time: %s", creationTime.format(DateFormat.YYYY_MM_DD_HH_MM_SS), lastAccessTime.format(DateFormat.YYYY_MM_DD_HH_MM_SS), lastModifiedTime.format(DateFormat.YYYY_MM_DD_HH_MM_SS));
    }
}