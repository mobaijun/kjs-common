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
package com.mobaijun.common.enums.file;

import java.net.URLConnection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: ImageType<br>
 * enum description： 获取文件类型
 *
 * @author MoBaiJun 2022/6/10 14:02
 */
@Getter
@RequiredArgsConstructor
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

    /**
     * 文件类型
     */
    private final String mMIME;

    /**
     * 从给定的URL中提取文件后缀名。
     * <p>
     * 此方法首先尝试通过匹配预定义的文件类型（ImageType枚举中的值）来直接获取URL中的文件后缀名。
     * 如果找不到匹配的后缀名，则尝试通过URL的文件名部分来猜测MIME类型，并基于该MIME类型来映射一个文件后缀名。
     * 如果两种方法都无法确定后缀名，则返回null。
     *
     * @param url 要从中提取后缀名的URL字符串。
     * @return URL中文件的后缀名，如果无法确定则返回null。
     */
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

    /**
     * 根据给定的URL字符串猜测其MIME类型。
     * <p>
     * 此方法使用URL的字符串（通常是文件名部分）来尝试猜测其MIME类型。
     * 如果URL为空或无法从文件名推断出MIME类型，则返回null。
     *
     * @param url 要猜测MIME类型的URL字符串。
     * @return 猜测的MIME类型字符串，如果无法确定则返回null。
     */
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