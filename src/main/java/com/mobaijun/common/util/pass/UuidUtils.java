package com.mobaijun.common.util.pass;

import java.util.UUID;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: UuidUtils
 * 类描述： UUID工具类
 *
 * @author MoBaiJun 2022/4/22 18:56
 */
public class UuidUtils {

    /**
     * 生成uuid ，b166868e-ee39-429e-91a9-2f4e847368bd
     *
     * @return String
     */
    public static String getUid() {
        return UUID.randomUUID().toString();
    }

    /**
     * UUID随机生成方法 95acc97927d14e0b855daccc894887d9
     *
     * @return uuid
     */
    public static String getUUID() {
        // 把-替换为空
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 随机uuid
     *
     * @param string 随机字符串
     * @return uuid 39356163-6339-3739-3839-343838376439
     */
    public static UUID stringToUUID(String string) {
        long firstLong = 0;
        long secondLong = 0;
        for (int i = 0; i < 8; i++) {
            firstLong <<= 8;
            firstLong |= string.charAt(i);
        }
        for (int i = 8; i < string.length(); i++) {
            secondLong <<= 8;
            secondLong |= string.charAt(i);
        }
        return new UUID(firstLong, secondLong);
    }
}
