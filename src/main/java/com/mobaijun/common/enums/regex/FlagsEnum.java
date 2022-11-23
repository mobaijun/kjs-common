package com.mobaijun.common.enums.regex;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.regex.Pattern;

/**
 * software：IntelliJ IDEA 2022.2.3
 * enum name: FlagsEnum
 * enum description: 正则匹配模式枚举
 *
 * @author MoBaiJun 2022/11/23 17:46
 */
@Getter
@AllArgsConstructor
public enum FlagsEnum {

    /**
     * {@link java.util.regex.Pattern}
     */
    UNIX_LINES(Pattern.UNIX_LINES),

    /**
     * 不区分大小写
     * <p>
     * {@link java.util.regex.Pattern}
     */
    CASE_INSENSITIVE(Pattern.CASE_INSENSITIVE),

    /**
     * 忽略空白字符，可以多行书写，并使用 # 进行注释说明
     * <p>
     * {@link java.util.regex.Pattern}
     */
    COMMENTS(Pattern.COMMENTS),

    /**
     * 多行模式，此模式下 ^ 和 $ 可以分别匹配行首和行尾
     * <p>
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
