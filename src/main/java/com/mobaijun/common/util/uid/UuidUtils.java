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
package com.mobaijun.common.util.uid;

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
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 随机UUID
     */
    public static String fastUUID() {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID() {
        return UUID.fastUUID().toString(true);
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