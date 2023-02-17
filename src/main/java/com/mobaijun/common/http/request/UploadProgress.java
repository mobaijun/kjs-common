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

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * interface name: UploadProgress<br>
 * interface description: <br>
 *
 * @author MoBaiJun 2023/1/5 14:10
 */
public interface UploadProgress {
    /**
     * Callback invoked as data is uploaded by the request.
     *
     * @param uploaded The number of bytes already uploaded
     * @param total    The total number of bytes that will be uploaded or -1 if
     *                 the length is unknown.
     */
    void onUpload(long uploaded, long total);

    UploadProgress DEFAULT = (uploaded, total) -> {
    };
}
