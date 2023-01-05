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
