package com.mobaijun.common.util;


import com.mobaijun.common.util.constant.ConstantStr;

import java.util.Collection;
import java.util.Map;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: StringUtils
 * 类描述： String 工具类
 *
 * @author MoBaiJun 2022/4/22 16:47
 */
public class StringUtils {

    /**
     * 获取参数不为空值
     *
     * @param value        要判断的value
     * @param defaultValue 要判断的value
     * @param <T>
     * @return value 返回值
     */
    public static <T> T isEmpty(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    /**
     * 校验字符串序列是否含有空值
     *
     * @param str 字符串序列
     * @return 只要有一个字符串为空时就返回 true，否则返回 false
     */
    public static boolean isEmpty(String[] str) {
        return isEmpty(str);
    }

    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll) {
        return ObjectUtils.isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个对象数组是否为空
     *
     * @param objects 要判断的对象数组
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects) {
        return ObjectUtils.isNull(objects) || (objects.length == 0);
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return ObjectUtils.isNull(map) || map.isEmpty();
    }

    /**
     * * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str) {
        return ObjectUtils.isNull(str) || ConstantStr.NULLSTR.equals(str.trim());
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }


    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }


    /**
     * * 判断一个字符串是否为非空串
     *
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 去空格
     *
     * @param str 要去除字符串
     * @return 取出后结果
     */
    public static String trim(String str) {
        return (str == null ? "" : str.trim());
    }

    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param start 开始
     * @return 结果
     */
    public static String substring(final String str, int start) {
        if (str == null) {
            return ConstantStr.NULLSTR;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return ConstantStr.NULLSTR;
        }

        return str.substring(start);
    }

    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param start 开始
     * @param end   结束
     * @return 结果
     */
    public static String substring(final String str, int start, int end) {
        if (str == null) {
            return ConstantStr.NULLSTR;
        }

        if (end < 0) {
            end = str.length() + end;
        }
        if (start < 0) {
            start = str.length() + start;
        }

        if (end > str.length()) {
            end = str.length();
        }

        if (start > end) {
            return ConstantStr.NULLSTR;
        }

        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * 下划线转驼峰命名
     *
     * @param str 字符串
     * @return 转换后字符串
     */
    public static String toUnderScoreCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // 前置字符是否大写
        boolean preCharIsUpperCase = true;
        // 当前字符是否大写
        boolean curreCharIsUpperCase = true;
        // 下一字符是否大写
        boolean nexteCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i > 0) {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            } else {
                preCharIsUpperCase = false;
            }

            curreCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1)) {
                nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase) {
                sb.append(ConstantStr.SEPARATOR);
            } else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase) {
                sb.append(ConstantStr.SEPARATOR);
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (str != null && strs != null) {
            for (String s : strs) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String convertToCamelCase(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母大写
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 首字母大写
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    /**
     * 去除两符号间内容
     *
     * @param context context
     * @param left    left
     * @param right   right
     * @return String
     */
    public static String clearBracket(String context, char left, char right) {
        int head = context.indexOf(left);
        if (head == -1) {
            return context;
        } else {
            int next = head + 1;
            int count = 1;
            do {
                if (context.charAt(next) == left) {
                    count++;
                } else if (context.charAt(next) == right) {
                    count--;
                }
                next++;
                if (count == 0) {
                    String temp = context.substring(head, next);
                    context = context.replace(temp, "");
                    head = context.indexOf(left);
                    next = head + 1;
                    count = 1;
                }
            } while (head != -1);
        }
        return context;
    }

    /**
     * 判断字符串数组是否为 null
     *
     * @param str str
     * @return boolean
     */
    public static boolean notEmpty(String[] str) {
        for (String strIndex : str) {
            if (isEmpty(strIndex)) {
                return false;
            }
        }
        return true;
    }
}
