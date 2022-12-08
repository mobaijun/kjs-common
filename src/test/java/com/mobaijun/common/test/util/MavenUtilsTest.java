package com.mobaijun.common.test.util;

import com.mobaijun.common.util.MavenUtil;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: MavenUtilsTest
 * class description: maven 清理工具类
 *
 * @author MoBaiJun 2022/11/22 18:50
 */
public class MavenUtilsTest {
    public static void main(String[] args) {
        // maven 清理无效 jar 包
        MavenUtil.mavenClear("F:\\repository");
    }
}
