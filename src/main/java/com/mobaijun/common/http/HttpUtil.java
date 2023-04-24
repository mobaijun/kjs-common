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
package com.mobaijun.common.http;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: HttpUtils<br>
 * class description： http 工具类
 *
 * @author MoBaiJun 2022/7/18 10:05
 */
public class HttpUtil {

    /**
     * 判断是否为http链接
     *
     * @param urlString url链接
     * @return 是|否
     */
    public static boolean isHttp(String urlString) {
        try {
            URL url = new URL(urlString);
            String protocol = url.getProtocol();
            return "http".equals(protocol);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断是否为https链接
     *
     * @param urlString url链接
     * @return 是|否
     */
    public static boolean isHttps(String urlString) {
        try {
            URL url = new URL(urlString);
            String protocol = url.getProtocol();
            return "https".equals(protocol);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void disableSSLVerification() {
        // 创建一个信任所有证书的TrustManager数组
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    // 返回接受的证书，这里直接返回null
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    // 忽略客户端证书验证
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    // 忽略服务端证书验证
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };
        // 获取TLS协议的SSLContext实例
        SSLContext sc;
        try {
            sc = SSLContext.getInstance("TLS");
            // 初始化SSLContext，第一个参数是null表示使用默认的KeyManager，第二个参数是trustAllCerts数组表示信任所有证书，第三个参数是一个随机数生成器
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
        // 将当前应用的默认SSLSocketFactory设置为SSLContext中的SSLSocketFactory
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
}