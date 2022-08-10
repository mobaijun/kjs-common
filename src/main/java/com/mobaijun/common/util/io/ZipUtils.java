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
package com.mobaijun.common.util.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ZipUtils
 * class description： 压缩工具类
 *
 * @author MoBaiJun 2022/5/18 10:27
 */
@SuppressWarnings("all")
public class ZipUtils {
    private static final int BUFFER_SIZE = 1024 * 4;


    /**
     * 压缩集合中的文件到指定路径
     *
     * @param files       files
     * @param zipFilePath zipFilePath
     */
    public static void zipFile(List<File> files, String zipFilePath) {
        int len = -1;
        byte[] b;
        BufferedInputStream bis = null;
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(Paths.get(zipFilePath))));
            for (File file : files) {
                if (file.isFile()) {
                    b = new byte[BUFFER_SIZE];
                    bis = new BufferedInputStream(Files.newInputStream(file.toPath()));
                    ZipEntry ze = new ZipEntry(file.getName());
                    zos.putNextEntry(ze);
                    while ((len = bis.read(b)) != -1) {
                        zos.write(b, 0, len);
                    }
                    zos.flush();
                    bis.close();
                    bis = null;
                }
            }
            zos.close();
            zos = null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (zos != null) {
                    zos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩给定路径的文件或文件夹到指定路径
     *
     * @param srcFilePath srcFilePath
     * @param zipFilePath zipFilePath
     */
    public static void zip(String srcFilePath, String zipFilePath) {
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(Paths.get(zipFilePath))));
            zip(new File(srcFilePath), zos, "");
            zos.close();
            zos = null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (zos != null) {
                    zos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void zip(File file, ZipOutputStream zos, String base) {
        if (file.isDirectory()) {
            base += file.getName() + "/";
            try {
                zos.putNextEntry(new ZipEntry(base));
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (File f : Objects.requireNonNull(file.listFiles())) {
                zip(f, zos, base);
            }
        } else {
            int len = -1;
            byte[] b = new byte[BUFFER_SIZE];
            BufferedInputStream bis = null;
            try {
                bis = new BufferedInputStream(Files.newInputStream(file.toPath()));
                zos.putNextEntry(new ZipEntry(base + file.getName()));
                while ((len = bis.read(b)) != -1) {
                    zos.write(b, 0, len);
                }
                zos.flush();
                bis.close();
                bis = null;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bis != null) {
                        bis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 解压给定路径的文件到指定路径
     *
     * @param zipFilePath  文件路径
     * @param destFilePath 指定路径
     */
    public static void unzip(String zipFilePath, String destFilePath) {
        int len = -1;
        byte[] b;
        ZipFile zipFile = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            zipFile = new ZipFile(zipFilePath);
            Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
            while (zipEntries.hasMoreElements()) {
                ZipEntry zipEntry = zipEntries.nextElement();
                if (zipEntry.isDirectory()) {
                    new File(destFilePath, zipEntry.getName()).mkdirs();
                    continue;
                }
                File file = new File(destFilePath, zipEntry.getName());
                File parent = file.getParentFile();
                if (parent != null && !parent.exists()) {
                    parent.mkdirs();
                }
                b = new byte[BUFFER_SIZE];
                bis = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                bos = new BufferedOutputStream(Files.newOutputStream(file.toPath()));
                while ((len = bis.read(b)) != -1) {
                    bos.write(b, 0, len);
                }
                bos.flush();
                bos.close();
                bos = null;
                bis.close();
                bis = null;
            }
            zipFile.close();
            zipFile = null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}