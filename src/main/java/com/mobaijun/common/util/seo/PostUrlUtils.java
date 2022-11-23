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
package com.mobaijun.common.util.seo;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mobaijun.common.util.ObjectUtils;
import com.mobaijun.common.util.StringUtils;
import com.mobaijun.common.constant.NumberConstant;
import com.mobaijun.common.constant.StringConstant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: PostUrlUtils
 * class description：Java implements batch submission of web links on Baidu webmaster platform
 *
 * @author MoBaiJun 2022/5/25 11:29
 */
public class PostUrlUtils {

    /**
     * 返回状态码
     */
    private final static int SUCCESS_200 = 200;
    private final static int ERROR_400 = 400;
    private final static int ERROR_401 = 401;
    private final static int ERROR_404 = 404;
    private final static int ERROR_500 = 500;

    /**
     * 提交链接到百度站长
     *
     * @param urls        链接集合
     * @param baiDuApiUrl 站长提交地址
     * @return 结果集
     * @throws IOException IO 异常
     */
    public static String postUrl(Vector<String> urls, String baiDuApiUrl) throws IOException {
        URLConnection urlConnection = urlConnection(baiDuApiUrl);
        HttpURLConnection httpUrlConnection = (HttpURLConnection) urlConnection;
        PrintWriter postPrintWriter = new PrintWriter(httpUrlConnection.getOutputStream());
        // 构造请求参数
        StringBuffer param = new StringBuffer();
        urls.forEach(s -> {
            if (!StringUtils.isEmpty(s)) {
                // 去除两头空格
                String tmpUrl = s.trim();
                if (tmpUrl.contains(StringConstant.HTTP_PREFIX) || tmpUrl.contains(StringConstant.HTTPS_PREFIX)) {
                    param.append(tmpUrl).append("\n");
                }
            }
        });
        // 发送参数
        postPrintWriter.print(param);
        // 刷新输出流缓冲
        postPrintWriter.flush();
        return bufferedReader(httpUrlConnection.getResponseCode(), urlConnection).toString();
    }

    /**
     * 封装请求信息
     *
     * @param baiDuApiUrl 百度站长地址
     * @return 连接信息
     * @throws IOException io异常
     */
    private static URLConnection urlConnection(String baiDuApiUrl) throws IOException {
        URLConnection urlConnection = new URL(baiDuApiUrl).openConnection();
        urlConnection.setRequestProperty("Content-Type", "text/plain");
        urlConnection.setRequestProperty("User-Agent", "curl/7.12.1");
        urlConnection.setRequestProperty("Host", "data.zz.baidu.com");
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        return urlConnection;
    }

    private static StringBuilder bufferedReader(int code, URLConnection urlConnection) throws IOException {
        StringBuilder result = new StringBuilder();
        switch (code) {
            case SUCCESS_200:
                //通过BufferedReader输入流来读取Url的响应
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while (!ObjectUtils.isEmpty((line = bufferedReader.readLine()))) {
                    result.append(line);
                }
                String resultT = result.toString();
                JSONObject jsonObject = JSONUtil.parseObj(resultT);
                Object site = jsonObject.get("not_same_site");
                if (!ObjectUtils.isEmpty(site)) {
                    result.append("接口调用地址与提交的网址不匹配");
                }
                Object success = jsonObject.get("success");
                if (success.equals(NumberConstant.ZERO)) {
                    result.delete(NumberConstant.ONE, result.length());
                    result.append("提交失败,");
                } else if (success.equals(NumberConstant.ONE)) {
                    result.delete(NumberConstant.ZERO, result.length());
                    result.append("提交成功");
                }
                break;
            case ERROR_400:
                result.append("站点未在站长平台验证");
                break;
            case ERROR_401:
                result.append("接口调用地址错误");
                break;
            case ERROR_404:
                result.append("接口地址填写错误");
                break;
            case ERROR_500:
                result.append("服务器偶然异常，通常重试就会成功");
                break;
            default:
                result.append("未知错误");
                break;
        }
        return result;
    }
}