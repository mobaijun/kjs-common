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
package com.mobaijun.common.text;

import com.mobaijun.common.constant.StringConstant;
import static com.mobaijun.common.constant.StringConstant.EMPTY_STRING;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: StringUtils<br>
 * 类描述： String 工具类<br>
 *
 * @author MoBaiJun 2022/4/22 16:47
 */
public class StringUtil {

    /**
     * The maximum size to which the padding constant(s) can expand.
     */
    private static final int PAD_LIMIT = 8192;

    /**
     * A String for a space character.
     */
    public static final String SPACE = " ";

    /**
     * 获取参数不为空值
     *
     * @param value        要判断的value
     * @param defaultValue 要判断的value
     * @param <T>          未定义
     * @return value 返回值
     */
    public static <T> T isEmpty(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    /**
     * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll) {
        return Objects.isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个对象数组是否为空
     *
     * @param objects 要判断的对象数组
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects) {
        return Objects.isNull(objects) || (objects.length == 0);
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return Objects.isNull(map) || map.isEmpty();
    }

    /**
     * * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || EMPTY_STRING.equals(str.trim());
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
            return EMPTY_STRING;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return EMPTY_STRING;
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
            return EMPTY_STRING;
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
            return EMPTY_STRING;
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
        boolean preCharIsUpperCase;
        // 当前字符是否大写
        boolean cureCharIsUpperCase;
        // 下一字符是否大写
        boolean nextCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i > 0) {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            } else {
                preCharIsUpperCase = false;
            }

            cureCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1)) {
                nextCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && cureCharIsUpperCase && !nextCharIsUpperCase) {
                sb.append(StringConstant.UNDERLINE);
            } else if ((i != 0 && !preCharIsUpperCase) && cureCharIsUpperCase) {
                sb.append(StringConstant.UNDERLINE);
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 是否包含字符串
     *
     * @param str   验证字符串
     * @param stirs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... stirs) {
        if (str != null && stirs != null) {
            for (String s : stirs) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。
     * 例如：HELLO_WORLD--HelloWorld
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
    public static boolean isEmpty(String[] str) {
        for (String strIndex : str) {
            if (isEmpty(strIndex)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 首字母变大写
     *
     * @param str String
     * @return String
     */
    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 首字母变小写
     *
     * @param str String
     * @return String
     */
    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 使用指定字符左填充字符串。
     *
     * @param str     要填充的字符串，可能为null
     * @param size    填充后的目标大小
     * @param padChar 用于填充的字符
     * @return 左填充后的字符串，或者原始字符串（如果不需要填充），
     * 如果输入字符串为null，则返回null
     *
     * <p>示例：</p>
     * <pre>
     * StringUtils.leftPad(null, *, *)     = null
     * StringUtils.leftPad("", 3, 'z')     = "zzz"
     * StringUtils.leftPad("bat", 3, 'z')  = "bat"
     * StringUtils.leftPad("bat", 5, 'z')  = "zzbat"
     * StringUtils.leftPad("bat", 1, 'z')  = "bat"
     * StringUtils.leftPad("bat", -1, 'z') = "bat"
     * </pre>
     */
    public static String leftPad(final String str, final int size, final char padChar) {
        if (str == null) {
            return null;
        }
        final int pads = size - str.length();
        if (pads <= 0) {
            // 返回原始字符串（如果可能）
            return str;
        }
        if (pads > PAD_LIMIT) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return repeat(padChar, pads).concat(str);
    }

    /**
     * 返回使用指定字符重复到给定长度的填充字符串。
     *
     * @param ch     要重复的字符
     * @param repeat 重复字符的次数，负数视为零
     * @return 填充后的字符串
     *
     * <p>示例：</p>
     * <pre>
     * StringUtils.repeat('e', 0)  = ""
     * StringUtils.repeat('e', 3)  = "eee"
     * StringUtils.repeat('e', -2) = ""
     * </pre>
     *
     * <p>注意：此方法不支持用
     * <a href="http://www.unicode.org/glossary/#supplementary_character">Unicode补充字符</a>
     * 进行填充，因为它们需要一对{@code char}表示。
     * 如果需要支持完整的国际化应用程序，</p>
     */
    public static String repeat(final char ch, final int repeat) {
        if (repeat <= 0) {
            return EMPTY_STRING;
        }
        final char[] buf = new char[repeat];
        Arrays.fill(buf, ch);
        return new String(buf);
    }

    /**
     * 使用指定字符串左填充字符串。
     *
     * @param str    要填充的字符串，可能为null
     * @param size   填充后的目标大小
     * @param padStr 用于填充的字符串，null或空字符串视为单个空格
     * @return 左填充后的字符串，或者原始字符串（如果不需要填充），
     * 如果输入字符串为null，则返回null
     *
     * <p>示例：</p>
     * <pre>
     * StringUtils.leftPad(null, *, *)      = null
     * StringUtils.leftPad("", 3, "z")      = "zzz"
     * StringUtils.leftPad("bat", 3, "yz")  = "bat"
     * StringUtils.leftPad("bat", 5, "yz")  = "yzbat"
     * StringUtils.leftPad("bat", 8, "yz")  = "yzyzybat"
     * StringUtils.leftPad("bat", 1, "yz")  = "bat"
     * StringUtils.leftPad("bat", -1, "yz") = "bat"
     * StringUtils.leftPad("bat", 5, null)  = "  bat"
     * StringUtils.leftPad("bat", 5, "")    = "  bat"
     * </pre>
     */
    public static String leftPad(final String str, final int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = SPACE;
        }
        final int padLen = padStr.length();
        final int strLen = str.length();
        final int pads = size - strLen;
        if (pads <= 0) {
            // 返回原始字符串（如果可能）
            return str;
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return leftPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            final char[] padding = new char[pads];
            final char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }

    /**
     * 左位数不足补0
     *
     * @param str       待补位的字符
     * @param strLength 限制位数
     * @return 字符
     */
    public static String appendZero(String str, int strLength) {
        int strLen = str.length();
        StringBuilder sb;
        while (strLen < strLength) {
            sb = new StringBuilder();
            // 左补0
            sb.append("0").append(str);
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }

    /**
     * 将某字符串置于给定大小的中间.
     *
     * @param str     字符串
     * @param size    总大小
     * @param padChar 填充字符
     * @return 字符串结果
     */
    public static String center(String str, int size, char padChar) {
        if (str != null && size > 0) {
            int strLen = str.length();
            int pads = size - strLen;
            if (pads > 0) {
                str = leftPad(str, strLen + pads / 2, padChar);
                str = rightPad(str, size, padChar);
            }
        }
        return str;
    }

    /**
     * 对给定的字符串和大小进行右填充.
     *
     * @param str     字符串
     * @param size    填充的总大小
     * @param padChar 填充字符
     * @return 填充结果
     */
    private static String rightPad(final String str, int size, char padChar) {
        int pads = size - str.length();
        return pads <= 0 ? str : str.concat(repeat(padChar, pads));
    }

    /**
     * 一个输入字符串和一个分隔符字符串。如果输入字符串为空或null，则返回一个空数组。如果分隔符为空或null，则返回包含输入字符串的单元素数组。
     * 否则，该方法将使用Java正则表达式中的Pattern.quote()方法对分隔符字符串进行转义，并将其传递给输入字符串的split()方法，以便将输入字符串分割成一个字符串数组。
     *
     * @param input     输入字符串
     * @param delimiter 分隔符
     * @return 字符串数组
     */
    public static String[] split(String input, String delimiter) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        if (delimiter == null || delimiter.isEmpty()) {
            return new String[]{input};
        }
        return input.split(Pattern.quote(delimiter));
    }

    /**
     * 格式化字符串
     *
     * @param format 格式化字符串
     * @param args   参数列表
     * @return 字符串
     */
    public static String format(String format, Object... args) {
        return String.format(format, args);
    }

    /**
     * 替换字符串
     */
    public static String replace(StringBuffer sb, String from, String to) {
        int index = sb.indexOf(from);
        while (index != -1) {
            sb.replace(index, index + from.length(), to);
            index = sb.indexOf(from, index + to.length());
        }
        return sb.toString();
    }

    /**
     * 将数组转换为字符串
     *
     * @param arr       数组
     * @param delimiter 分隔符
     * @return 字符串
     */
    public static <T> String arrToStr(T[] arr, String delimiter) {
        return Arrays.stream(arr)
                .map(String::valueOf)
                .collect(Collectors.joining(delimiter));
    }

    /**
     * 将集合转换为字符串
     *
     * @param collection 集合
     * @param delimiter  分隔符
     * @return 字符串
     */
    public static <T> String collToStr(Collection<T> collection, String delimiter) {
        return collection.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(delimiter));
    }

    /**
     * 在原始字符串中的指定位置插入另一个字符串。
     *
     * @param original 原始字符串
     * @param insert   要插入的字符串
     * @param position 要插入的位置（从0开始计数）
     * @return 插入后的新字符串
     */
    public static String insertStr(String original, String insert, int position) {
        if (original == null || insert == null) {
            return original;
        }

        if (position < 0 || position > original.length()) {
            throw new IllegalArgumentException("Insert position outside string range");
        }

        return IntStream.range(0, original.length())
                .mapToObj(i -> (i == position) ? insert : String.valueOf(original.charAt(i)))
                .collect(Collectors.joining());
    }

    /**
     * 将字符串数组中的元素按指定分隔符连接起来
     *
     * @param array     字符串数组
     * @param delimiter 分隔符
     * @return 拼接后的字符串
     */
    public static String join(String[] array, String delimiter) {
        if (array == null || array.length == 0) {
            return "";
        }

        StringJoiner joiner = new StringJoiner(delimiter);
        for (String element : array) {
            joiner.add(element);
        }
        return joiner.toString();
    }
}