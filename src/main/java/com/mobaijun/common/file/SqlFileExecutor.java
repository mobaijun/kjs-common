package com.mobaijun.common.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: [SQL 脚本执行工具]
 * Author: [mobaijun]
 * Date: [2024/5/10 16:17]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class SqlFileExecutor {

    /**
     * 从 SQL 文件中加载 SQL 语句
     *
     * @param sqlFile SQL 脚本文件
     * @return List<String> 包含 SQL 语句的列表
     */
    public static List<String> loadSQLFromFile(Path sqlFile) {
        try (BufferedReader reader = Files.newBufferedReader(sqlFile, StandardCharsets.UTF_8)) {
            return reader.lines()
                    .map(line -> line.replaceAll("--.*", ""))
                    .collect(Collectors.groupingBy(
                            line -> line.trim().endsWith(";"),
                            Collectors.joining("\n")
                    ))
                    .getOrDefault(true, "")
                    .lines()
                    .toList();
        } catch (IOException e) {
            // 抛出异常
            throw new RuntimeException(e);
        }
    }
}
