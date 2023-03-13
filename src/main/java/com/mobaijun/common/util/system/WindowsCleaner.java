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
package com.mobaijun.common.util.system;

import com.mobaijun.common.util.JdkUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: WindowsCleaner<br>
 * class description: Windows清理垃圾工具
 *
 * @author MoBaiJun 2023/2/20 7:41
 */
public class WindowsCleaner {

    /**
     * 获取管理员权限
     */
    private static final Process GET_ADMIN;

    static {
        try {
            GET_ADMIN = Runtime.getRuntime().exec("runas /user:Administrator");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 清理 Windows 系统的临时文件夹
     */
    public static void cleanTempFolder() {
        // 获取系统临时文件夹路径
        Path tempFolderPath = Paths.get(JdkUtil.getTmpdir());

        // 遍历临时文件夹中的所有文件和子文件夹
        try {
            Files.walk(tempFolderPath)
                    .sorted((p1, p2) -> -p1.compareTo(p2))
                    .forEach(path -> {
                        try {
                            // 删除文件或文件夹
                            Files.deleteIfExists(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Temp folder cleaned successfully.");
    }

    /**
     * 清空 Windows 系统的回收站
     */
    public static void emptyRecycleBin() {
        // 获取回收站目录路径
        String recycleBinPath = "C:\\$Recycle.Bin";

        // 判断回收站目录是否存在
        File recycleBinDir = new File(recycleBinPath);
        if (!recycleBinDir.exists()) {
            System.out.println("Recycle bin directory not found.");
            return;
        }
        // 遍历回收站目录中的所有文件和子文件夹
        try {
            Files.walk(Paths.get(recycleBinPath))
                    .sorted((p1, p2) -> -p1.compareTo(p2))
                    .forEach(path -> {
                        try {
                            // 删除文件或文件夹
                            Files.deleteIfExists(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Recycle bin emptied successfully.");
    }
}
