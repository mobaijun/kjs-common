package com.mobaijun.common.test.util;

import com.mobaijun.common.util.NamingUtils;
import com.mobaijun.common.util.PrintUtils;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: NamingUtilsTest
 * class description: 名称转换测试类
 *
 * @author MoBaiJun 2022/12/1 16:09
 */
public class NamingUtilsTest {
    public static void main(String[] args) {
        // 驼峰转中划线
        PrintUtils.println(NamingUtils.humpToMidline("userName"));
        // 驼峰转下划线
        PrintUtils.println(NamingUtils.humpToUnderline("userName"));
        // 下划线转驼峰
        PrintUtils.println(NamingUtils.underlineToHump("user_name"));
    }
}
