package com.mobaijun.common.util.image;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: Base64Utils
 * 类描述： Base64工具类
 *
 * @author MoBaiJun 2022/4/22 18:59
 */
public class Base64Utils {

    /**
     * 将图片转换成base64字符串
     *
     * @param imagePath 图片地址
     * @return 压缩码
     */
    public static String getImageStr(String imagePath) {
        InputStream is = null;
        byte[] data = null;
        try {
            is = new FileInputStream(imagePath);
            data = new byte[is.available()];
            is.read();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encode(data));
        return encoder.encode(data);
    }
}
