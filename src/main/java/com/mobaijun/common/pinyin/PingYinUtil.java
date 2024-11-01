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
package com.mobaijun.common.pinyin;

import com.mobaijun.common.text.Charsets;
import java.util.Random;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: PingYinUtils<br>
 * class description: 提供中文字符串转换为拼音首字母的功能。
 *
 * @author MoBaiJun 2022/11/22 12:16
 */
@Slf4j
@NoArgsConstructor
public final class PingYinUtil {

    /**
     * 返回给定中文字符串的拼音首字母。
     *
     * @param strChinese 中文字符串
     * @param bUpCase    是否返回大写字母
     * @return 拼音首字母字符串，如果输入为空或发生异常则返回null
     */
    public static String getPyIndexStr(String strChinese, boolean bUpCase) {
        try {
            StringBuilder buffer = new StringBuilder();
            // 将中文字符串转换为GBK编码的字节数组
            byte[] chineseBytes = strChinese.getBytes(Charsets.GBK_NAME);
            for (int i = 0; i < chineseBytes.length; i++) {
                if ((chineseBytes[i] & 255) > 128) {
                    int char1 = chineseBytes[i++] & 255;
                    char1 <<= 8;
                    int chart = char1 + (chineseBytes[i] & 255);
                    buffer.append(getPyIndexChar((char) chart, bUpCase));
                    continue;
                }
                char c = (char) chineseBytes[i];
                // 如果字符不是合法的Java标识符的一部分，则用'A'替代
                if (!Character.isJavaIdentifierPart(c)) {
                    c = 'A';
                }
                buffer.append(c);
            }
            return buffer.toString();
        } catch (Exception e) {
            log.warn("获取中文拼音首字母时出现错误: {}", e.getMessage());
        }
        return null;
    }

    /**
     * 根据GBK编码的字符获取对应的拼音首字母。
     *
     * @param charGbk GBK编码的字符
     * @param bUpCase 是否返回大写字母
     * @return 对应的拼音首字母
     */
    @SuppressWarnings("AlibabaUndefineMagicConstant")
    private static char getPyIndexChar(char charGbk, boolean bUpCase) {
        char result;
        // 根据字符的GBK值范围确定拼音首字母
        if (charGbk >= 45217 && charGbk <= 45252) {
            result = 'A';
        } else if (charGbk >= 45253 && charGbk <= 45760) {
            result = 'B';
        } else if (charGbk >= 45761 && charGbk <= 46317) {
            result = 'C';
        } else if (charGbk >= 46318 && charGbk <= 46825) {
            result = 'D';
        } else if (charGbk >= 46826 && charGbk <= 47009) {
            result = 'E';
        } else if (charGbk >= 47010 && charGbk <= 47296) {
            result = 'F';
        } else if (charGbk >= 47297 && charGbk <= 47613) {
            result = 'G';
        } else if (charGbk >= 47614 && charGbk <= 48118) {
            result = 'H';
        } else if (charGbk >= 48119 && charGbk <= 49061) {
            result = 'J';
        } else if (charGbk >= 49062 && charGbk <= 49323) {
            result = 'K';
        } else if (charGbk >= 49324 && charGbk <= 49895) {
            result = 'L';
        } else if (charGbk >= 49896 && charGbk <= 50370) {
            result = 'M';
        } else if (charGbk >= 50371 && charGbk <= 50613) {
            result = 'N';
        } else if (charGbk >= 50614 && charGbk <= 50621) {
            result = 'O';
        } else if (charGbk >= 50622 && charGbk <= 50905) {
            result = 'P';
        } else if (charGbk >= 50906 && charGbk <= 51386) {
            result = 'Q';
        } else if (charGbk >= 51387 && charGbk <= 51445) {
            result = 'R';
        } else if (charGbk >= 51446 && charGbk <= 52217) {
            result = 'S';
        } else if (charGbk >= 52218 && charGbk <= 52697) {
            result = 'T';
        } else if (charGbk >= 52698 && charGbk <= 52979) {
            result = 'W';
        } else if (charGbk >= 52980 && charGbk <= 53688) {
            result = 'X';
        } else if (charGbk >= 53689 && charGbk <= 54480) {
            result = 'Y';
        } else if (charGbk >= 54481 && charGbk <= 55289) {
            result = 'Z';
        } else {
            // 随机字母
            result = (char) (65 + (new Random()).nextInt(25));
        }

        // 根据参数决定返回大写或小写
        return bUpCase ? result : Character.toLowerCase(result);
    }
}