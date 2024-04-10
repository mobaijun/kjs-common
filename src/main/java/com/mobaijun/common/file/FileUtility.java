package com.mobaijun.common.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Objects;

/**
 * Description: [文件操作工具类，用于删除空文件夹和未知后缀的文件]
 * Author: [mobaijun]
 * Date: [2024/3/23 23:34]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Slf4j
public class FileUtility {

    /**
     * 删除指定目录下的空文件夹
     *
     * @param directoryPath 要扫描的目录路径
     */
    public static void deleteEmptyDirectories(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.err.println("Provided path is not a directory.");
            return;
        }

        // 递归删除空文件夹
        deleteEmptyDirectoriesRecursive(directory);
    }

    /**
     * 递归删除空文件夹
     *
     * @param directory 要删除的目录
     */
    private static void deleteEmptyDirectoriesRecursive(File directory) {
        if (!directory.isDirectory()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteEmptyDirectoriesRecursive(file);
                }
            }
        }

        // 删除空文件夹
        if (directory.isDirectory() && Objects.requireNonNull(directory.list()).length == 0) {
            if (directory.delete()) {
                log.info("Deleted empty directory: " + directory.getAbsolutePath());
            } else {
                System.err.println("Could not delete empty directory: " + directory.getAbsolutePath());
            }
        }
    }

    /**
     * 删除指定目录下的未知后缀的文件或无后缀的文件
     *
     * @param directoryPath 要扫描的目录路径
     */
    public static void deleteUnknownExtensionFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            log.info("Provided path is not a directory.");
            return;
        }

        // 递归删除未知后缀的文件或无后缀的文件
        deleteUnknownExtensionFilesRecursive(directory);
    }

    /**
     * 递归删除未知后缀的文件或无后缀的文件
     *
     * @param directory 要删除的目录
     */
    private static void deleteUnknownExtensionFilesRecursive(File directory) {
        if (!directory.isDirectory()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteUnknownExtensionFilesRecursive(file);
                } else {
                    // 如果文件名中没有后缀，则删除
                    if (file.getName().lastIndexOf('.') == -1) {
                        if (file.delete()) {
                            log.info("Deleted file with unknown extension: {}", file.getAbsolutePath());
                        } else {
                            log.info("Could not delete file with unknown extension: {}", file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}
