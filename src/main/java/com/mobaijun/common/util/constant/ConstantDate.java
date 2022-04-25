package com.mobaijun.common.util.constant;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: ConstantDate
 * 类描述： 日期常量
 *
 * @author MoBaiJun 2022/4/22 18:52
 */
public class ConstantDate {

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YY_YY_MM_DD_HH_MM_SS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String YY_YY_MM_DD = "yyyyMMdd";

    public static String YMD = "yyyy年MM月dd日";

    private static final String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};
}
