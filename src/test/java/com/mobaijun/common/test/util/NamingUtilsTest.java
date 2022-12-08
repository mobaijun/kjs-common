package com.mobaijun.common.test.util;

import com.mobaijun.common.util.NamingUtil;
import com.mobaijun.common.util.PrintUtil;

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
        PrintUtil.println(NamingUtil.humpToMidline("userName"));
        // 驼峰转下划线
        PrintUtil.println(NamingUtil.humpToUnderline("userName"));
        // 下划线转驼峰
        PrintUtil.println(NamingUtil.underlineToHump("user_name"));
    }
}
