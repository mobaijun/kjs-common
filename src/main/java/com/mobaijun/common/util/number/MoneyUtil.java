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
package com.mobaijun.common.util.number;

import com.mobaijun.common.util.StringUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: MoneyUtils<br>
 * class description：
 *
 * @author MoBaiJun 2022/7/11 10:20
 */
public class MoneyUtil {
    private static final ThreadLocal<DecimalFormat> DEFAULT_FORMAT = createThreadLocalNumberFormat("0.00");

    private static final ThreadLocal<DecimalFormat> PRETTY_FORMAT = createThreadLocalNumberFormat("#,##0.00");

    /**
     * ThreadLocal重用MessageDigest
     *
     * @param pattern String
     * @return ThreadLocal
     */
    private static ThreadLocal<DecimalFormat> createThreadLocalNumberFormat(final String pattern) {
        return ThreadLocal.withInitial(() -> {
            DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
            df.applyPattern(pattern);
            return df;
        });
    }

    /**
     * 人民币金额单位转换，分转换成元，取两位小数 例如：150 => 1.5
     */
    public static BigDecimal fen2yuan(BigDecimal num) {
        return num.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
    }

    /**
     * 人民币金额单位转换，分转换成元，取两位小数 例如：150 => 1.5
     */
    public static BigDecimal fen2yuan(long num) {
        return fen2yuan(new BigDecimal(num));
    }

    /**
     * 人民币金额单位转换，分转换成元，取两位小数 例如：150 => 1.5
     */
    public static BigDecimal fen2yuan(String num) {
        if (StringUtil.isEmpty(num)) {
            return new BigDecimal(0);
        }
        return fen2yuan(new BigDecimal(num));
    }

    /**
     * 人民币金额单位转换，元转换成分，例如：1 => 100
     */
    public static BigDecimal yuan2fen(String y) {
        return new BigDecimal(Math.round(new BigDecimal(y).multiply(new BigDecimal(100)).doubleValue()));
    }

    /**
     * 人民币金额单位转换，元转换成分，例如：1 => 100
     */
    public static BigDecimal yuan2fen(double y) {
        return yuan2fen(String.valueOf(y));
    }

    /**
     * 人民币金额单位转换，元转换成分，例如：1 => 100
     */
    public static BigDecimal yuan2fen(BigDecimal y) {
        if (y != null) {
            return yuan2fen(y.toString());
        } else {
            return new BigDecimal(0);
        }
    }

    /**
     * 格式化金额，例如：1=>1.00
     */
    public static String format(BigDecimal number) {
        return format(number.doubleValue());
    }

    /**
     * 格式化金额，默认格式：00.0 ,例如：1=>1.00
     */
    public static String format(double number) {
        return DEFAULT_FORMAT.get().format(number);
    }

    /**
     * 格式化金额，默认格式：#,##0.00 ,例如：33999999932.3333d 输出：33,999,999,932.33
     */
    public static String prettyFormat(BigDecimal number) {
        return prettyFormat(number.doubleValue());
    }

    /**
     * 格式化金额，默认格式：#,##0.00 ,例如：33999999932.3333d 输出：33,999,999,932.33
     */
    public static String prettyFormat(double number) {
        return PRETTY_FORMAT.get().format(number);
    }

    /**
     * 格式化金额，当pattern为空时，pattern默认为#,##0.00
     */
    public static String format(BigDecimal number, String pattern) {
        return format(number.doubleValue(), pattern);
    }

    /**
     * 格式化金额，当pattern为空时，pattern默认为#,##0.00
     */
    public static String format(double number, String pattern) {
        DecimalFormat df;
        if (StringUtil.isEmpty(pattern)) {
            df = PRETTY_FORMAT.get();
        } else {
            df = (DecimalFormat) DecimalFormat.getInstance();
            df.applyPattern(pattern);
        }

        return df.format(number);
    }

    /**
     * 分析格式为0.00格式的字符串
     */
    public static BigDecimal parseString(String numberStr) throws ParseException {
        return BigDecimal.valueOf(DEFAULT_FORMAT.get().parse(numberStr).doubleValue());
    }

    /**
     * 分析格式为#,##0.00格式的字符串
     */
    public static BigDecimal parsePrettyString(String numberStr) throws ParseException {
        return BigDecimal.valueOf(PRETTY_FORMAT.get().parse(numberStr).doubleValue());
    }

    /**
     * 按格式分析字符串，当pattern为空时，pattern默认为#,##0.00
     */
    public static BigDecimal parseString(String numberStr, String pattern) throws ParseException {
        DecimalFormat df;
        if (StringUtil.isEmpty(pattern)) {
            df = PRETTY_FORMAT.get();
        } else {
            df = (DecimalFormat) DecimalFormat.getInstance();
            df.applyPattern(pattern);
        }
        return BigDecimal.valueOf(df.parse(numberStr).doubleValue());
    }
}