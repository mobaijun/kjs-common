package com.mobaijun.common.http.request;

import java.io.IOException;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: RequestException<br>
 * class description: <br>
 *
 * @author MoBaiJun 2023/1/5 14:11
 */
public class RequestException extends RuntimeException {

    /**
     * Create a new HttpRequestException with the given cause
     */
    public RequestException(final IOException cause) {
        super(cause);
    }

    /**
     * Get {@link IOException} that triggered this request exception
     *
     * @return {@link IOException} cause
     */
    @Override
    public IOException getCause() {
        return (IOException) super.getCause();
    }

}
