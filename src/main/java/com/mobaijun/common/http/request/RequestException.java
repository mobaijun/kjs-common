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
