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
package com.mobaijun.common.enums.regex;

import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: FlagsType<br>
 * enum description: 正则匹配模式枚举
 *
 * @author MoBaiJun 2022/11/23 17:46
 */
@Getter
@AllArgsConstructor
public enum FlagsType {

    /**
     * {@link java.util.regex.Pattern}
     */
    UNIX_LINES(Pattern.UNIX_LINES),

    /**
     * 不区分大小写
     * <br>
     * {@link java.util.regex.Pattern}
     */
    CASE_INSENSITIVE(Pattern.CASE_INSENSITIVE),

    /**
     * 忽略空白字符，可以多行书写，并使用 # 进行注释说明
     * <br>
     * {@link java.util.regex.Pattern}
     */
    COMMENTS(Pattern.COMMENTS),

    /**
     * 多行模式，此模式下 ^ 和 $ 可以分别匹配行首和行尾
     * <br>
     * {@link java.util.regex.Pattern}
     */
    MULTILINE(Pattern.MULTILINE),

    /**
     * {@link java.util.regex.Pattern}
     */
    LITERAL(Pattern.LITERAL),

    /**
     * {@link java.util.regex.Pattern}
     */
    DOTALL(Pattern.DOTALL),

    /**
     * {@link java.util.regex.Pattern}
     */
    UNICODE_CASE(Pattern.UNICODE_CASE),

    /**
     * {@link java.util.regex.Pattern}
     */
    CANON_EQ(Pattern.CANON_EQ),

    /**
     * {@link java.util.regex.Pattern}
     */
    UNICODE_CHARACTER_CLASS(Pattern.UNICODE_CHARACTER_CLASS);

    /**
     * 值
     */
    private final int value;
}
