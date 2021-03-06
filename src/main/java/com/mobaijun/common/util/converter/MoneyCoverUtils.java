package com.mobaijun.common.util.converter;

import org.apache.commons.lang3.StringUtils;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: MoneyCoverUtils
 * class description： 金额转换器
 *
 * @author MoBaiJun 2022/5/31 11:16
 */
public class MoneyCoverUtils {

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
     * @throws Exception Exception
     */
    public static String converseChinese(int money) throws Exception {
        if (money < 0) {
            throw new Exception("请核对金额，金额不能小于0");
        }
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
     * @throws Exception Exception
     */
    public static String converseChinese(double money) throws Exception {
        if (money < 0) {
            throw new Exception("请核对金额，金额不能小于0");
        }
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
        StringUtils.replace(String.valueOf(stringBuffer), "零亿", "零");
        StringUtils.replace(String.valueOf(stringBuffer), "零万", "零");
        StringUtils.replace(String.valueOf(stringBuffer), "零仟", "零");
        StringUtils.replace(String.valueOf(stringBuffer), "零佰", "零");
        StringUtils.replace(String.valueOf(stringBuffer), "零十", "零");
        StringUtils.replace(String.valueOf(stringBuffer), "零零", "零");
        StringUtils.replace(String.valueOf(stringBuffer), "零元", "元");
        StringUtils.replace(String.valueOf(stringBuffer), "零角", "零");
        StringUtils.replace(String.valueOf(stringBuffer), "零分", "");
    }

    private static void handleHeader(StringBuffer stringBuffer) {
    }

    public static int charToNum(char c) {
        return (int) c - 48;
    }
}
