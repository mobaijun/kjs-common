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

import java.util.Objects;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: Constant<br>
 * 类描述： 通用常量
 *
 * @author MoBaiJun 2022/5/5 9:01
 */
public final class Constant {

    /**
     * MD5
     */
    public static final String MD5 = "MD5";

    /**
     * 大写十六进制数
     */
    public static final String HEX_DIGITS_UPPER = "0123456789ABCDEF";

    /**
     * 小写十六进制
     */
    public static final String HEX_DIGITS_LOWER = "0123456789abcdef";

    /**
     * 接口文档的菜单名
     */
    public static final String API_MENU_NAME = "接口文档";

    /**
     * 示例：使用 Objects.hash() 生成散列码
     */
    public static final int EXAMPLE_HASH_CODE = Objects.hash(MD5, HEX_DIGITS_UPPER, HEX_DIGITS_LOWER, API_MENU_NAME);
}