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
package com.mobaijun.common.tool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: MavenClear<br>
 * 类描述： maven 清理工具类<br>
 *
 * @author MoBaiJun 2022/4/22 18:14
 */
@Slf4j
public class MavenUtil {

    /**
     * 记录数
     */
    private static long total;

    /**
     * 耗时
     */
    private static long time;

    /**
     * 根据文件路径清理不完整 maven 包
     *
     * @param filePath 文件路径
     */
    public static void mavenClear(String filePath) {
        Path dirPath = Paths.get(filePath);
        if (!Files.isDirectory(dirPath)) {
            System.exit(0);
        } else {
            Instant startNow = Instant.now();
            delFile(dirPath.toFile());
            Instant endNow = Instant.now();
            time = Duration.between(startNow, endNow).toMillis();
        }
        log.info("Number of deletes: {} Time taken: {} milliseconds", total, time);
    }

    /**
     * 删除文件
     *
     * @param file 文件
     */
    private static void delFile(File file) {
        try (Stream<Path> paths = Files.walk(file.toPath())) {
            paths.sorted((p1, p2) -> -p1.compareTo(p2))
                    .forEach(p -> {
                        File f = p.toFile();
                        if (f.isDirectory()) {
                            if ("unknown".equals(f.getName())) {
                                delAll(f);
                            } else if (f.getName().startsWith("${") && f.getName().endsWith("}")) {
                                delAll(f);
                                deleteFile(f);
                            } else if (Objects.requireNonNull(f.listFiles()).length == 0) {
                                deleteFile(f);
                            }
                        } else if (f.getName().endsWith(".lastUpdated")) {
                            deleteFile(f);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除文件夹下的所有文件夹、文件及其子文件夹、文件
     *
     * @param file file
     */
    private static void delAll(File file) {
        try (Stream<Path> paths = Files.walk(file.toPath())) {
            paths.sorted((p1, p2) -> -p1.compareTo(p2))
                    .forEach(p -> {
                        File f = p.toFile();
                        deleteFile(f);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除文件并更新总计数
     *
     * @param file 要删除的文件
     */
    private static void deleteFile(File file) {
        try {
            Files.delete(file.toPath());
            total++;
            log.info("Removed: {}", file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}