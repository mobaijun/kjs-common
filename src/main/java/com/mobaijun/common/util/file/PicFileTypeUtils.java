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
package com.mobaijun.common.util.file;

import com.mobaijun.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: PicFileTypeUtil
 * class description： 文件类型识别工具类
 *
 * @author MoBaiJun 2022/5/12 13:21
 */
public class PicFileTypeUtils {

    private static final List<String> PIC_TYPES;

    static {
        PIC_TYPES = new ArrayList<>();
        PIC_TYPES.add("jpg");
        PIC_TYPES.add("png");
        PIC_TYPES.add("jpeg");
        PIC_TYPES.add("tif");
        PIC_TYPES.add("gif");
        PIC_TYPES.add("bmp");
    }

    /**
     * 根据文件名称获取文件是否为图片类型
     *
     * @param fileName 文件名称
     * @return boolean true-是图片类型，false-不是图片类型
     */
    public static boolean getFileImgTypeFlag(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return false;
        }
        for (String picType : PIC_TYPES) {
            if (fileName.toLowerCase().endsWith(picType)) {
                return true;
            }
        }
        return false;
    }
}