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

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: MavenClear<br>
 * 类描述： maven 清理工具类<br>
 *
 * @author MoBaiJun 2022/4/22 18:14
 */
public class MavenUtils {

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
        File dir = new File(filePath);
        if (!dir.isDirectory()) {
            System.exit(0);
        } else {
            Instant startNow = Instant.now();
            MavenUtils.delFile(dir);
            Instant endNow = Instant.now();
            time = Duration.between(startNow, endNow).toMillis();
        }
        System.out.printf("删除数量：%d 耗时：%d 毫秒", total, time);
    }

    /**
     * 删除文件
     *
     * @param file 文件
     */
    private static void delFile(File file) {
        File[] list = file.listFiles();
        assert list != null;
        for (File f : list) {
            if (f.isDirectory()) {
                delFile(f);
                if ("unknown".equals(f.getName())) {
                    delAll(f);
                    total++;
                    System.out.println("删除：" + f.getAbsolutePath());
                } else if (f.getName().startsWith("${") && f.getName().endsWith("}")) {
                    // 如果 文件夹名称是以 ${ 开头 } 结尾，那么将这个文件夹及其下面所有文件全部删除
                    delAll(f);
                    f.delete();
                    total++;
                    System.out.println("删除：" + f.getAbsolutePath());
                } else if (Objects.requireNonNull(f.listFiles()).length == 0) {
                    // 删除空文件夹
                    f.delete();
                    total++;
                    System.out.println("删除：" + f.getAbsolutePath());
                }
            } else {
                if (f.getName().endsWith(".lastUpdated")) {
                    f.delete();
                    total++;
                    System.out.println("删除：" + f.getAbsolutePath());
                }
            }
        }
    }

    /**
     * 删除文件夹下的所有文件夹、文件及其子文件夹、文件
     *
     * @param file file
     */
    private static void delAll(File file) {
        File[] list = file.listFiles();
        assert list != null;
        for (File f : list) {
            if (f.isFile()) {
                // 是文件就删除
                f.delete();
            } else {
                // 先将文件夹下的文件夹和文件全部删除再删除源文件夹
                delAll(f);
            }
            total++;
            System.out.println("删除：" + f.getAbsolutePath());
        }
    }
}