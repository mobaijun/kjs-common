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
package com.mobaijun.common.enums.file;

import java.net.URLConnection;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: ImageType<br>
 * enum description： 获取文件类型
 *
 * @author MoBaiJun 2022/6/10 14:02
 */
public enum ImageType {

    /**
     * // 标签图像文件格式（Tagged Image File Format，简写为TIFF）是一种主要用来存储包括照片和艺术图在内的图像的文件格式。
     * 它最初由Aldus公司与微软公司一起为PostScript打印开发。
     */
    PNG(".png", "image/png"),
    JPG(".jpg", "image/jpeg"),
    BMP(".bmp", "image/bmp"),
    JPEG(".jpeg", "image/jpeg"),
    GIF(".gif", "image/gif"),
    TIF(".tif", "image/tiff"),
    TIFF(".tiff", "image/tiff"),
    FAX(".fax", "image/fax"),
    ICO(".ico", "image/x-icon"),
    JFIF(".jfif", "image/jpeg"),
    JPE(".jpe", "image/jpeg"),
    NET(".net", "image/pnetvue"),
    WBMP(".wbmp", "image/vnd.wap.wbmp");

    /**
     * 后缀名
     */
    private final String mSuffix;
    private final String mMIME;

    ImageType(String suffix, String mime) {
        this.mSuffix = suffix;
        this.mMIME = mime;
    }

    public static String getSuffixFromUrl(String url) {

        for (ImageType fileType : values()) {
            if (url.contains(fileType.suffix())) {
                return fileType.suffix();
            }
        }
        String contentType = getMimeTypeFromUrl(url);
        if (contentType == null) {
            return null;
        }
        return mimeMakingSuffix(contentType);
    }

    public static String getMimeTypeFromUrl(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }
        return URLConnection.guessContentTypeFromName(url);
    }

    /**
     * mime类型对应的后缀名
     */
    public static String mimeMakingSuffix(String mime) {
        for (ImageType fileType : values()) {
            if (fileType.mime().equals(mime)) {
                return fileType.suffix();
            }
        }
        return null;
    }

    public String mime() {
        return mMIME;
    }

    /**
     * 获取后缀名 * * @return 指定类型的后缀名，如'.mp4'
     */
    public String suffix() {
        return this.mSuffix;
    }
}