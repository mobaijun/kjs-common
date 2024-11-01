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
package com.mobaijun.common.system;

import com.mobaijun.common.exception.UtilException;
import com.mobaijun.common.jdk.JdkUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: WindowsCleaner<br>
 * class description: 提供系统清理功能，包括清理临时文件夹和清空回收站。
 *
 * @author MoBaiJun 2023/2/20 7:41
 */
@Slf4j
public class WindowsCleaner {

    /**
     * 获取管理员权限
     */
    public static final Process GET_ADMIN;

    static {
        try {
            GET_ADMIN = Runtime.getRuntime().exec("runas /user:Administrator");
        } catch (IOException e) {
            throw new UtilException(e);
        }
    }

    /**
     * 清理 Windows 系统的临时文件夹。
     * 该方法会遍历临时文件夹中的所有文件和子文件夹，并尝试删除它们。
     * 在删除过程中如果发生错误，将记录错误信息。
     */
    public static void cleanTempFolder() {
        // 获取系统临时文件夹路径
        Path tempFolderPath = Paths.get(JdkUtil.getTmpdir());

        // 遍历临时文件夹中的所有文件和子文件夹
        try (var pathsStream = Files.walk(tempFolderPath)) {
            pathsStream
                    // 先删除子文件夹再删除父文件夹
                    .sorted((p1, p2) -> -p1.compareTo(p2))
                    .forEach(path -> {
                        try {
                            // 删除文件或文件夹
                            Files.deleteIfExists(path);
                        } catch (IOException e) {
                            log.error("Error cleaning temp folder: {}", e.getMessage());
                        }
                    });
            log.info("Temp folder cleaned successfully.");
        } catch (IOException e) {
            log.error("Error walking through temp folder: {}", e.getMessage());
        }
    }

    /**
     * 清空 Windows 系统的回收站。
     * 该方法会遍历回收站目录中的所有文件和子文件夹，并尝试删除它们。
     * 如果回收站目录不存在或删除过程中发生错误，将记录错误信息。
     */
    public static void emptyRecycleBin() {
        // 获取回收站目录路径
        String recycleBinPath = "C:\\$Recycle.Bin";

        // 判断回收站目录是否存在
        File recycleBinDir = new File(recycleBinPath);
        if (!recycleBinDir.exists()) {
            log.error("Recycle bin directory not found.");
            return;
        }

        // 遍历回收站目录中的所有文件和子文件夹
        try (var pathsStream = Files.walk(Paths.get(recycleBinPath))) {
            pathsStream
                    // 先删除子文件夹再删除父文件夹
                    .sorted((p1, p2) -> -p1.compareTo(p2))
                    .forEach(path -> {
                        try {
                            // 删除文件或文件夹
                            Files.deleteIfExists(path);
                        } catch (IOException e) {
                            log.error("Error emptying recycle bin: {}", e.getMessage());
                        }
                    });
            log.info("Recycle bin emptied successfully.");
        } catch (IOException e) {
            log.error("Error walking through recycle bin: {}", e.getMessage());
        }
    }
}
