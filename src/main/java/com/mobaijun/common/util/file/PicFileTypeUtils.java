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
