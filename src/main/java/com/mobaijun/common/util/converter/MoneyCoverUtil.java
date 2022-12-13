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
package com.mobaijun.common.util.converter;

import com.mobaijun.common.util.StringUtil;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: MoneyCoverUtils<br>
 * class description： 金额转换器
 *
 * @author MoBaiJun 2022/5/31 11:16
 */
public class MoneyCoverUtil {

    /**
     * 数字大写
     */
    private final static char[] NUMBER = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};

    /**
     * 整数单位
     */
    private final static char[] INTEGER_UNIT = {'元', '十', '佰', '仟', '万', '十', '佰', '仟', '万', '亿'};

    /**
     * 小数单位
     */
    private final static char[] DECIMAL_UNIT = {'角', '分'};

    /**
     * 整数金额转化中文大写
     *
     * @param money int
     * @return String
     */
    public static String converseChinese(int money) {
        StringBuffer converseResult = new StringBuffer();
        StringBuilder moneyStr = new StringBuilder(String.valueOf(money));
        for (int i = 0, j = moneyStr.length() - 1; i < moneyStr.length() && j >= 0; i++, j--) {
            converseResult.append(NUMBER[charToNum(moneyStr.charAt(i))]);
            converseResult.append(INTEGER_UNIT[j]);
        }
        handle(converseResult);
        handleHeader(converseResult);
        return converseResult.toString();
    }

    /**
     * 小数金额转化中文大写
     *
     * @param money double
     * @return String
     */
    public static String converseChinese(double money) {
        String moneyStr = String.valueOf(money);
        StringBuffer converseResult = new StringBuffer();
        String[] moneys = moneyStr.split("\\.");
        int integerMoney = Integer.parseInt(moneys[0]);
        converseResult.append(converseChinese(integerMoney));
        StringBuilder decimal = new StringBuilder(moneys[1]);
        for (int i = 0; i < decimal.length(); i++) {
            converseResult.append(NUMBER[charToNum(decimal.charAt(i))]);
            converseResult.append(DECIMAL_UNIT[i]);
        }
        handle(converseResult);
        return converseResult.toString();
    }

    private static void handle(StringBuffer stringBuffer) {
        StringUtil.replace(String.valueOf(stringBuffer), "零亿", "零");
        StringUtil.replace(String.valueOf(stringBuffer), "零万", "零");
        StringUtil.replace(String.valueOf(stringBuffer), "零仟", "零");
        StringUtil.replace(String.valueOf(stringBuffer), "零佰", "零");
        StringUtil.replace(String.valueOf(stringBuffer), "零十", "零");
        StringUtil.replace(String.valueOf(stringBuffer), "零零", "零");
        StringUtil.replace(String.valueOf(stringBuffer), "零元", "元");
        StringUtil.replace(String.valueOf(stringBuffer), "零角", "零");
        StringUtil.replace(String.valueOf(stringBuffer), "零分", "");
    }

    private static void handleHeader(StringBuffer stringBuffer) {
    }

    public static int charToNum(char c) {
        return (int) c - 48;
    }
}