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
package com.mobaijun.common.util.regx;

import java.util.regex.Pattern;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: Regx<br>
 * class description： 正则表达式<br>
 *
 * @author MoBaiJun 2022/5/18 10:07
 */
public final class RegxConstant {
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
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[5,7,9])|(15[^4,\\D])|(17[0,1,3,5-8])|(18[0-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

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
    public static final String REGEX_MAC = "^(([0-9a-fA-F]){1,2}[:-]){5}([0-9a-fA-F]){1,2}";

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
     * 驼峰
     */
    public static final Pattern HUMP_PATTERN = Pattern.compile("[A-Z]");

    /**
     * 大驼峰模式
     */
    public static final Pattern UNDERLINE_PATTERN = Pattern.compile("_(\\w)");
}