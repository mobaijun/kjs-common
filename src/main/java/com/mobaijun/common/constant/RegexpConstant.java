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
package com.mobaijun.common.constant;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: Regx<br>
 * class description： 正则表达式<br>
 *
 * @author MoBaiJun 2022/5/18 10:07
 */
public final class RegexpConstant {

    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[579])|(15[0-35-9])|(17[0-35-8])|(18[0-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\\u4e00-\\u9fa5]{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

    /**
     * 正则表达式：mac地址校验
     */
    public static final String REGEX_MAC = "^([0-9A-Fa-f]{2}[:-]){5}[0-9A-Fa-f]{2}$";

    /**
     * 正则表达式：检测邮箱是否合法
     */
    public static final String PATH_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    /**
     * 域名
     */
    public static final String REGEX_DOMAIN_NAME = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?";

    /**
     * 网络地址
     */
    public static final String REGEX_INTERNET_URL = "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";

    /**
     * 手机号码
     */
    public static final String REGEX_PHONE = "^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";

    /**
     * 弱密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)：
     */
    public static final String REGEX_WEAK_PASSWORD = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 8-20 之间)：
     */
    public static final String REGEX_STRONG_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,20}$";

    /**
     * xml文件
     */
    public static final String REGEX_XML = "^([a-zA-Z]+-?)+[a-zA-Z0-9]+\\.[x|X][m|M][l|L]$";

    /**
     * QQ号
     */
    public static final String REGEX_QQ = "[1-9][0-9]{4,}";

    /**
     * 中国邮政编码： (中国邮政编码为6位数字)
     */
    public static final String REGEX_CHINA_POST = "[1-9]\\d{5}(?!\\d)";

    /**
     * IP地址
     */
    public static final String REGEX_IP_ADDRESS = "\\d+\\.\\d+\\.\\d+\\.\\d+";

    /**
     * 长度为3-20的所有字符
     */
    public static final String REGEX_CHAR_ALL = "^.{3,20}$";

    /**
     * COORDINATE_PATTERN 是一个用于匹配 GPS 坐标字符串格式的正则表达式模式。
     * 这个正则表达式的目的是匹配形如 "40.7128, -74.0060" 的 GPS 坐标字符串，其中经度和纬度之间由逗号分隔，且可以包含小数。
     * 如果传入的字符串不符合这个格式，parseGpsCoordinate 方法将抛出 IllegalArgumentException。
     */
    public static final String COORDINATE_PATTERN = "^(-?\\d{1,3}(\\.\\d+)?),\\s*(-?\\d{1,3}(\\.\\d+)?)$";

    /**
     * 车牌号正则校验
     */
    public static final String REGEX_CAR_LICENSE = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";

    /**
     * 数字：匹配任意数字。
     */
    public static final String DIGITS = "^[0-9]*$";

    /**
     * n位的数字：匹配精确n位的数字。
     */
    public static final String N_DIGITS = "^\\d{n}$";

    /**
     * 至少n位的数字：匹配最少n位的数字。
     */
    public static final String AT_LEAST_N_DIGITS = "^\\d{n,}$";

    /**
     * m-n位的数字：匹配m到n位的数字。
     */
    public static final String M_TO_N_DIGITS = "^\\d{m,n}$";

    /**
     * 零和非零开头的数字：匹配以0或非零数字开头的数字。
     */
    public static final String ZERO_OR_NON_ZERO_DIGITS = "^(0|[1-9][0-9]*)$";

    /**
     * 非零开头的最多带两位小数的数字：匹配非零开头的小数，最多带两位小数。
     */
    public static final String NON_ZERO_WITH_TWO_DECIMALS = "^([1-9][0-9]*)+(\\.[0-9]{1,2})?$";

    /**
     * 带1-2位小数的正数或负数：匹配带1到2位小数的正数或负数。
     */
    public static final String ONE_OR_TWO_DECIMALS = "^(\\-)?\\d+(\\.\\d{1,2})?$";

    /**
     * 正数、负数和小数：匹配正数、负数或小数。
     */
    public static final String POSITIVE_NEGATIVE_OR_DECIMAL = "^(\\-|\\+)?\\d+(\\.\\d+)?$";

    /**
     * 有两位小数的正实数：匹配带两位小数的正实数。
     */
    public static final String POSITIVE_REAL_WITH_TWO_DECIMALS = "^[0-9]+(\\.[0-9]{2})?$";

    /**
     * 有1~3位小数的正实数：匹配带1到3位小数的正实数。
     */
    public static final String POSITIVE_REAL_WITH_ONE_TO_THREE_DECIMALS = "^[0-9]+(\\.[0-9]{1,3})?$";

    /**
     * 非零的正整数：匹配非零的正整数。
     */
    public static final String NON_ZERO_POSITIVE_INTEGER = "^[1-9]\\d*$";

    /**
     * 非零的负整数：匹配非零的负整数。
     */
    public static final String NON_ZERO_NEGATIVE_INTEGER = "^\\-[1-9]\\d*$";

    /**
     * 非负整数：匹配非负整数（正整数或0）。
     */
    public static final String NON_NEGATIVE_INTEGER = "^\\d+$";

    /**
     * 非正整数：匹配非正整数（负整数或0）。
     */
    public static final String NON_POSITIVE_INTEGER = "^-[1-9]\\d*|0$";

    /**
     * 非负浮点数：匹配非负浮点数。
     */
    public static final String NON_NEGATIVE_FLOAT = "^\\d+(\\.\\d+)?$";

    /**
     * 非正浮点数：匹配非正浮点数。
     */
    public static final String NON_POSITIVE_FLOAT = "^((\\-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";

    /**
     * 正浮点数：匹配正浮点数。
     */
    public static final String POSITIVE_FLOAT = "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";

    /**
     * 负浮点数：匹配负浮点数。
     */
    public static final String NEGATIVE_FLOAT = "^\\-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*)$";

    /**
     * 浮点数：匹配任意浮点数。
     */
    public static final String FLOAT = "^(\\-?\\d+)(\\.\\d+)?$";

    /**
     * 匹配汉字
     * 允许 0 个或多个汉字字符
     */
    public static final String CHINESE_CHARACTERS = "^[\\u4e00-\\u9fa5]{0,}$";

    /**
     * 匹配英文和数字
     * 允许一个或多个英文或数字字符
     */
    public static final String ALPHANUMERIC = "^[A-Za-z0-9]+$";

    /**
     * 匹配长度为 4 到 40 位的英文和数字
     */
    public static final String ALPHANUMERIC_4_TO_40 = "^[A-Za-z0-9]{4,40}$";

    /**
     * 匹配长度为 3 到 20 的任意字符
     */
    public static final String ANY_CHARACTER_3_TO_20 = "^.{3,20}$";

    /**
     * 匹配由 26 个英文字母组成的字符串
     */
    public static final String ALPHABETIC = "^[A-Za-z]+$";

    /**
     * 匹配由 26 个大写英文字母组成的字符串
     */
    public static final String UPPERCASE_ALPHABETIC = "^[A-Z]+$";

    /**
     * 匹配由 26 个小写英文字母组成的字符串
     */
    public static final String LOWERCASE_ALPHABETIC = "^[a-z]+$";

    /**
     * 匹配由数字和 26 个英文字母组成的字符串
     */
    public static final String ALPHANUMERIC_ONLY = "^[A-Za-z0-9]+$";

    /**
     * 匹配由数字、26 个英文字母或下划线组成的字符串
     */
    public static final String ALPHANUMERIC_UNDERSCORE = "^\\w+$";

    /**
     * 匹配长度为 3 到 20 的数字、26 个英文字母或下划线组成的字符串
     */
    public static final String ALPHANUMERIC_UNDERSCORE_3_TO_20 = "^\\w{3,20}$";

    /**
     * 匹配中文、英文、数字和下划线组成的字符串
     */
    public static final String CHINESE_ALPHANUMERIC_UNDERSCORE = "^[\\u4E00-\\u9FA5A-Za-z0-9_]+$";

    /**
     * 匹配中文、英文、数字组成的字符串，不包含下划线
     */
    public static final String CHINESE_ALPHANUMERIC_NO_UNDERSCORE = "^[\\u4E00-\\u9FA5A-Za-z0-9]+$";

    /**
     * 匹配长度为 2 到 20 的中文、英文、数字组成的字符串，不包含下划线
     */
    public static final String CHINESE_ALPHANUMERIC_NO_UNDERSCORE_2_TO_20 = "^[\\u4E00-\\u9FA5A-Za-z0-9]{2,20}$";

    /**
     * 匹配可以输入的字符串，允许包含 ^%&',;=?$\" 等字符
     */
    public static final String ALLOW_SPECIAL_CHARACTERS = "[^%&',;=?$\\x22]+";

    /**
     * 匹配禁止输入包含 ~ 字符的字符串
     */
    public static final String FORBID_TILDE = "[^~\\x22]+";

    /**
     * 匹配除换行符 \n 以外的任何字符
     */
    public static final String MATCH_ANY_CHARACTER_EXCEPT_NEWLINE = ".*";

    /**
     * 匹配汉字
     * 范围：\u4E00 到 \u9FA5
     */
    public static final String MATCH_CHINESE_CHARACTERS = "[\\u4E00-\\u9FA5]";

    /**
     * 匹配全角符号
     * 范围：\uFF00 到 \uFFFF
     */
    public static final String MATCH_FULLWIDTH_CHARACTERS = "[\\uFF00-\\uFFFF]";

    /**
     * 匹配半角符号
     * 范围：\u0000 到 \u00FF
     */
    public static final String MATCH_HALFWIDTH_CHARACTERS = "[\\u0000-\\u00FF]";

    /**
     * 正则表达式：匹配域名
     */
    public static final String REGEX_DOMAIN = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?";

    /**
     * 正则表达式：匹配 URL 地址
     */
    public static final String REGEX_URL = "[a-zA-z]+://[^\\s]*";

    /**
     * 正则表达式：匹配电话号码（可带区号）
     */
    public static final String REGEX_TEL = "^((\\d{3,4}-)|\\d{3.4}-)?\\d{7,8}$";

    /**
     * 正则表达式：匹配国内电话号码（带区号）
     */
    public static final String REGEX_TEL_CN = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";

    /**
     * 正则表达式：匹配短身份证号（支持 x 或 X 结尾）
     */
    public static final String REGEX_ID_SHORT = "^([0-9]{7,18})(x|X)?$";

    /**
     * 正则表达式：匹配合法的账户名（字母开头，5-16位）
     */
    public static final String REGEX_ACCOUNT = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";

    /**
     * 正则表达式：匹配日期格式（yyyy-MM-dd）
     */
    public static final String REGEX_DATE = "^\\d{4}-\\d{1,2}-\\d{1,2}$";

    /**
     * 正则表达式：匹配一年中的12个月（01-12）
     */
    public static final String REGEX_MONTH = "^(0?[1-9]|1[0-2])$";

    /**
     * 正则表达式：匹配一个月的31天（01-31）
     */
    public static final String REGEX_DAY = "^((0?[1-9])|((1|2)[0-9])|30|31)$";

    /**
     * 正则表达式：匹配金额（允许两位小数）
     */
    public static final String REGEX_MONEY = "^[0-9]+(\\.[0-9]{1,2})?$";

    /**
     * 正则表达式：匹配双字节字符（包括汉字）
     */
    public static final String REGEX_DOUBLE_BYTE = "[^\\x00-\\xff]";

    /**
     * 正则表达式：匹配空白行
     */
    public static final String REGEX_BLANK_LINE = "\\n\\s*\\r";

    /**
     * 正则表达式：匹配 HTML 标签
     */
    public static final String REGEX_HTML_TAG = "<(\\S*?)[^>]*>.*?</\\1>|<.*? />";

    /**
     * 正则表达式：匹配行首尾空白字符
     */
    public static final String REGEX_TRIM = "^\\s*|\\s*$";

    /**
     * 正则表达式：匹配中国邮政编码
     */
    public static final String REGEX_POSTAL_CODE = "[1-9]\\d{5}(?!\\d)";

    /**
     * 正则表达式：匹配 IP 地址
     */
    public static final String REGEX_IP = "\\d+\\.\\d+\\.\\d+\\.\\d+";

    /**
     * 正则表达式：匹配 IP v4 地址
     */
    public static final String REGEX_IPV4 = "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";

    /**
     * 正则表达式：校验 IP v6 地址
     */
    public static final String REGEX_IPV6 = "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))";

    /**
     * 正则表达式：校验IPv4地址和端口是否正确
     */
    private static final String IP_PORT_REGEX = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(:([0-9]{1,5}))?$";
}