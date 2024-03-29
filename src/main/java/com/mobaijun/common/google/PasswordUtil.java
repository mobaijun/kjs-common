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
package com.mobaijun.common.google;

import com.mobaijun.common.constant.NumberConstant;
import com.mobaijun.common.constant.StringConstant;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: PasswordUtil<br>
 * class description: Google密码清理器
 *
 * @author MoBaiJun 2023/4/6 10:52
 */
@Slf4j
public class PasswordUtil {

    /**
     * 超时时间
     */
    private static final int TIMEOUT_MS = 10000;

    /**
     * 从CSV文件中读取密码数据，并返回一个PasswordEntry对象的列表
     *
     * @param filePath CSV文件路径
     * @return PasswordEntry对象列表
     */
    public static List<PasswordEntry> readCsvFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // 跳过文件的第一行头部信息
            reader.readLine();

            return reader.lines()
                    .map(line -> {
                        String[] fields = line.split(StringConstant.COMMA, NumberConstant.MINUS_ONE);
                        if (fields.length < NumberConstant.FIVE) {
                            fields = new String[]{StringConstant.BLANK, StringConstant.BLANK, StringConstant.BLANK, StringConstant.BLANK, StringConstant.BLANK};
                        }
                        return fields;
                    }).map(fields -> new PasswordEntry(fields[0], fields[1], fields[2], fields[3], fields[4]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Failed to read csv file {}", e.getMessage());
            throw new IOException("Failed to read csv file", e);
        }
    }

    /**
     * 用于删除不可达URL的方法
     *
     * @param passwordEntries 要处理的PasswordEntry对象的列表
     * @param proxyHost       代理地址
     * @param port            代理端口
     */
    public static void removeInaccessiblePasswordEntries(List<PasswordEntry> passwordEntries, String proxyHost, Integer port) {
        // 用于存储所有的CompletableFuture对象
        List<CompletableFuture<Boolean>> futures = new ArrayList<>();

        // 遍历PasswordEntry列表中的每个对象，为每个PasswordEntry对象创建一个异步任务，检查它的URL是否可访问
        for (PasswordEntry passwordEntry : passwordEntries) {
            futures.add(CompletableFuture.supplyAsync(() -> isUrlAccessible(passwordEntry.getUrl(), proxyHost, port)));
        }

        // 处理所有异步任务，移除不可访问的PasswordEntry对象
        List<PasswordEntry> toRemove = new ArrayList<>();
        for (int i = 0; i < passwordEntries.size(); i++) {
            Boolean result = futures.get(i).join();
            if (!result) {
                toRemove.add(passwordEntries.get(i));
            }
        }
        passwordEntries.removeAll(toRemove);

        // 遍历待删除的PasswordEntry列表，逐个输出它们的信息
        log.warn("The following Password Entry object was deleted because the URL was inaccessible:");
        for (PasswordEntry entry : toRemove) {
            log.warn("entry :{}", entry);
        }
    }

    /**
     * 写入 cvs 文件
     *
     * @param passwordEntries 密码列表
     * @param csvFilePath     cvs 文件地址
     * @throws IOException IOException
     */
    public static void writeCsv(List<PasswordEntry> passwordEntries, String csvFilePath) throws IOException {
        File file = new File(csvFilePath);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // 写入标题行
        bufferedWriter.write("name,username,password,url,note");
        bufferedWriter.newLine();

        // 写入数据行
        for (PasswordEntry passwordEntry : passwordEntries) {
            String line = passwordEntry.getName() + "," +
                    passwordEntry.getUsername() + "," +
                    passwordEntry.getPassword() + "," +
                    passwordEntry.getUrl() + "," +
                    passwordEntry.getNote();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        fileWriter.close();
    }

    /**
     * 检查URL是否可访问的方法
     *
     * @param url 要检查的URL
     * @return 如果可访问则返回true，否则返回false
     */
    private static boolean isUrlAccessible(String url, String proxyHost, Integer port) {
        HttpURLConnection connection = null;
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, port));
            connection = (HttpURLConnection) new URL(url).openConnection(proxy);
            connection.setRequestMethod("HEAD");
            // 1000毫秒的连接超时
            connection.setConnectTimeout(TIMEOUT_MS);
            // 1000毫秒的读取超时
            connection.setReadTimeout(TIMEOUT_MS);
            return (connection.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            return false;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
