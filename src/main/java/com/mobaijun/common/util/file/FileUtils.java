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
package com.mobaijun.common.util.file;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import com.mobaijun.common.util.constant.Constant;
import com.mobaijun.common.util.constant.NumberConstant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: FileUtils
 * 类描述： 文件工具类
 *
 * @author MoBaiJun 2022/4/22 17:06
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtils {

    private static final File SYSTEM_TEMP_DIR = new File(System.getProperty("java.io.tmpdir"));

    /**
     * 存储文件列表
     */
    private static final ArrayList<String> FILE_LIST = new ArrayList<>();

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
        return filename.matches(Constant.FILENAME_PATTERN);
    }

    /**
     * 获取目录下所有文件路径
     *
     * @param path 地址
     * @return 文件集合
     * @throws IOException IO 异常
     */
    private static ArrayList<String> getFileList(File path) throws IOException {
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
        return FILE_LIST;
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
        tempDir = new File(SYSTEM_TEMP_DIR, dirName);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
    }

    /**
     * 获取临时文件, 不会创建文件
     */
    public static File getTemplateFile(String name) throws IOException {
        File file;
        do {
            file = new File(tempDir, System.currentTimeMillis() + "." + name);
        }
        while (!file.createNewFile());
        return file;
    }

    /**
     * 根据网络路径获取文件输入流
     */
    public static InputStream getInputStreamByUrlPath(String path) throws IOException {
        // 从文件链接里获取文件流
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置超时间为3秒
        conn.setConnectTimeout(5 * 1000);
        // 得到输入流
        return conn.getInputStream();
    }

    /**
     * 根据图片地址获取所有图片 base 编码
     *
     * @param path 图片地址
     * @return base64 集合
     */
    public static List<String> imageToBase64(String path) {
        List<String> base64List = new LinkedList<>();
        // 转流处理
        Arrays.stream(FileUtil.ls(path))
                .forEach(file -> {
                    // 转 base64
                    base64List.add(Base64.encode(FileUtil.readBytes(file)));
                });
        return base64List;
    }

    /**
     * base64 转指定格式文件
     *
     * @param data     base64s数据
     * @param fileName 文件名称
     */
    public static void base64ToImage(byte[] data, String fileName) {
        FileUtil.writeBytes(Base64.decode(data), fileName);
    }
}