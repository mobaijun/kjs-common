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
