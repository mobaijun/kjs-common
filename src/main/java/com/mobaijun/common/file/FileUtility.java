package com.mobaijun.common.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;

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
            log.warn("Provided path is not a directory.");
            return;
        }

        // 递归删除空文件夹
        deleteEmptyDirectoriesRecursive(directory);
        // 删除未知文件
        deleteUnknownExtensionFiles(directoryPath);
    }

    /**
     * 递归删除空文件夹
     *
     * @param directory 要删除的目录
     */
    public static void deleteEmptyDirectoriesRecursive(File directory) {
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
                log.info("Deleted empty directory: {}", directory.getAbsolutePath());
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
    public static void deleteUnknownExtensionFilesRecursive(File directory) {
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

    /**
     * 列出指定目录下的所有文件
     *
     * @param directoryPath 要列出的目录路径
     * @return 目录下的所有文件流
     * @throws java.io.IOException 如果无法访问目录或者发生I/O错误
     */
    public static Stream<Path> listFiles(String directoryPath) throws IOException {
        try {
            return Files.walk(Paths.get(directoryPath))
                    .filter(Files::isRegularFile);
        } catch (IOException e) {
            log.info("Failed to list files: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * 扫描指定目录下所有文件内容并删除文件大小为0KB的文件
     *
     * @param directoryPath 要扫描的目录路径
     */
    public static void scanAndDeleteEmptyFiles(String directoryPath) {
        try (Stream<Path> files = listFiles(directoryPath)) {
            files.forEach(file -> {
                try {
                    if (Files.size(file) == 0) {
                        Files.delete(file);
                        log.info("Deleted empty file: {}", file.toAbsolutePath());
                    }
                } catch (IOException e) {
                    log.info("Failed to delete file: {}", file.toAbsolutePath());
                }
            });
        } catch (IOException e) {
            log.info("Failed to delete empty files: {}", e.getMessage());
        }
    }

    /**
     * 获取指定文件夹中所有文件的路径列表。
     *
     * @param folder   文件夹
     * @param fullPath 是否返回文件的全路径
     * @return 文件路径列表
     */
    public static List<String> getAllFilesInDirectory(File folder, boolean fullPath) {
        try {
            return Files.walk(folder.toPath())
                    .filter(Files::isRegularFile)
                    .map(path -> fullPath ? path.toString() : path.getFileName().toString())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.warn("Error occurred while getting all files in directory: {}", e.getMessage());
            return List.of();
        }
    }

    /**
     * 获取所有本地文件列表
     *
     * @param downloadDirectory 下载文件存储的目录路径
     * @return 所有本地文件列表，键为文件类型，值为该类型的文件列表
     */
    public static Map<String, List<String>> getAllLocalFiles(String downloadDirectory) {
        // 实现获取本地文件列表的逻辑
        File directory = new File(downloadDirectory);
        Map<String, List<String>> localFilesMap = new HashMap<>();

        if (directory.exists() && directory.isDirectory()) {
            // 获取目录下所有子目录
            File[] subDirectories = directory.listFiles(File::isDirectory);

            if (subDirectories != null) {
                for (File subDirectory : subDirectories) {
                    String directoryName = subDirectory.getName();
                    // 获取子目录中的所有文件列表
                    List<String> allFilesInDirectory = getAllFilesInDirectory(subDirectory, false);
                    // 将文件列表存储到Map中
                    localFilesMap.put(directoryName, allFilesInDirectory);
                }
            }
        }
        return localFilesMap;
    }

    /**
     * 删除指定目录下所有文件夹中大小等于指定大小的文件
     *
     * @param directoryPath 目录路径
     * @param sizeInBytes   文件大小（字节数）
     */
    public static void deleteFilesBySize(String directoryPath, long sizeInBytes) {
        File directory = new File(directoryPath);

        // 检查目录是否存在且是目录
        if (directory.exists() && directory.isDirectory()) {
            // 获取目录下所有子目录
            File[] subDirectories = directory.listFiles(File::isDirectory);

            // 遍历子目录
            if (subDirectories != null) {
                for (File subDirectory : subDirectories) {
                    // 删除子目录中大小等于指定大小的文件
                    deleteFilesBySizeInDirectory(subDirectory, sizeInBytes);
                }
            }
        }
    }

    /**
     * 删除指定目录中大小等于指定大小的文件
     *
     * @param directory   目录
     * @param sizeInBytes 文件大小（字节数）
     */
    public static void deleteFilesBySizeInDirectory(File directory, long sizeInBytes) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                // 如果是文件夹，则递归删除其中的文件
                if (file.isDirectory()) {
                    deleteFilesBySizeInDirectory(file, sizeInBytes);
                } else {
                    // 确保文件不为空
                    if (file.length() == sizeInBytes) {
                        // 删除文件
                        if (file.delete()) {
                            log.info("Deleted file: {}", file.getAbsolutePath());
                        } else {
                            log.warn("Failed to delete file: {}", file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取文件实际占用的存储空间大小
     *
     * @param filePath 文件路径
     * @return 文件实际占用的存储空间大小（字节数）
     */
    public static long getFileStorageSize(String filePath) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r");
             FileChannel channel = file.getChannel()) {
            return channel.size();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除损坏的文件。
     *
     * @param file 要检查和删除的文件路径
     */
    public static void checkAndDeleteIfCorrupt(String file) {
        Path imgPath = Paths.get(file);
        try {
            if (Files.exists(imgPath) && !isImageValid(imgPath)) {
                if (Files.deleteIfExists(imgPath)) {
                    log.info("Corrupt file deleted: {}", imgPath);
                } else {
                    log.info("Unable to delete corrupt file: {}", imgPath);
                }
            }
        } catch (IOException e) {
            log.warn("Error occurred while checking and deleting corrupt file: {}", e.getMessage());
        }
    }

    /**
     * 检查图片文件是否有效。
     *
     * @param file 图片文件路径
     * @return 图片是否有效
     */
    public static boolean isImageValid(Path file) {
        try {
            // 读取图片文件
            BufferedImage image = ImageIO.read(file.toFile());

            // 如果image为null，说明文件损坏
            return image != null && image.getWidth() > 0 && image.getHeight() > 0;
        } catch (IOException e) {
            // 发生异常，说明文件损坏
            return false;
        }
    }

    /**
     * 获取指定目录下的所有文件夹
     *
     * @param directoryPath 目录路径
     * @return 所有文件夹列表
     */
    public static List<File> getAllFolders(String directoryPath) {
        try {
            return Files.walk(Paths.get(directoryPath))
                    .filter(Files::isDirectory)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.warn("Error occurred while getting all folders: {}", e.getMessage());
            return List.of();
        }
    }
}
