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
package com.mobaijun.common.util.file;

import java.util.HashSet;
import java.util.Set;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: PicFileTypeUtil<br>
 * class description：文件类型识别工具类
 *
 * @author MoBaiJun 2022/5/12 13:21
 */
public class PicFileTypeUtil {

    private static final HashSet<String> PIC_TYPES;

    static {
        // 主流图片格式
        PIC_TYPES = new HashSet<>();
        PIC_TYPES.add("jpg");
        PIC_TYPES.add("jpeg");
        PIC_TYPES.add("png");
        PIC_TYPES.add("gif");
        PIC_TYPES.add("bmp");
        PIC_TYPES.add("webp");
        PIC_TYPES.add("ico");
        PIC_TYPES.add("tif");
        PIC_TYPES.add("tiff");
        PIC_TYPES.add("indd");
        PIC_TYPES.add("svg");
        PIC_TYPES.add("ai");
        PIC_TYPES.add("eps");
        PIC_TYPES.add("psd");
        PIC_TYPES.add("pdf");
        PIC_TYPES.add("raw");
        PIC_TYPES.add("tga");
        PIC_TYPES.add("wbmp");
    }

    /**
     * 根据文件名称获取文件是否为图片类型
     *
     * @param fileName 文件名称
     * @return boolean true-是图片类型，false-不是图片类型
     */
    public static boolean getFileImgTypeFlag(String fileName) {
        if (fileName.isEmpty()) {
            return false;
        }
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        Set<String> imageExtensions = new HashSet<>(PIC_TYPES);
        return imageExtensions.contains(fileExtension);
    }
}