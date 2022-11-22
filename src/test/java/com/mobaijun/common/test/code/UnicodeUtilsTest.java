package com.mobaijun.common.test.code;

import com.mobaijun.common.code.UnicodeUtils;
import com.mobaijun.common.util.PrintUtils;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: UnicodeUtilsTest
 * class description: unicode 测试类
 *
 * @author MoBaiJun 2022/11/22 14:16
 */
@Deprecated
public class UnicodeUtilsTest {

    public static void main(String[] args) {
        // 有点问题，期待优化
        PrintUtils.println(UnicodeUtils.converterCodePoints(""));
    }
}
