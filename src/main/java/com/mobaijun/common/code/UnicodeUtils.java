package com.mobaijun.common.code;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: UnicodeUtils
 * class description：Unicode 工具类
 *
 * @author MoBaiJun 2022/7/12 14:22
 */
public class UnicodeUtils {

    /**
     * 转义 Unicode 字符输出 emoji
     * @param unicode 字符
     * @return char 数组
     */
    public static char[] converterCodePoints(String unicode) {
        return Character.toChars(Integer.valueOf(unicode.substring(2), 16));
    }
}
