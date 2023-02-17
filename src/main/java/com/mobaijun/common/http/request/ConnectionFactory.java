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
package com.mobaijun.common.http.request;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * interface name: ConnectionFactory<br>
 * interface description: Creates {@link HttpURLConnection HTTP connections} for<br>
 *
 * @author MoBaiJun 2023/1/5 14:06
 */
public interface ConnectionFactory {

    /**
     * Open an {@link HttpURLConnection} for the specified {@link URL}.
     *
     * @throws IOException IOException
     */
    HttpURLConnection create(URL url) throws IOException;

    /**
     * Open an {@link HttpURLConnection} for the specified {@link URL}
     * and {@link Proxy}.
     *
     * @throws IOException IOException
     */
    HttpURLConnection create(URL url, Proxy proxy) throws IOException;

    /**
     * A {@link ConnectionFactory} which uses the built-in
     * {@link URL#openConnection()}
     */
    ConnectionFactory DEFAULT = new ConnectionFactory() {
        public HttpURLConnection create(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }

        public HttpURLConnection create(URL url, Proxy proxy) throws IOException {
            return (HttpURLConnection) url.openConnection(proxy);
        }
    };
}
