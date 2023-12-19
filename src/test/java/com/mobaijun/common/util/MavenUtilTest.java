package com.mobaijun.common.util;

import org.junit.Test;

/**
 * Description: [MavenUtilTest 测试类]
 * Author: [mobaijun]
 * Date: [2023/12/19 15:00]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class MavenUtilTest {

    @Test
    public void mavenClear() {
        // 删除无效文件
        MavenUtil.mavenClear("D:\\repository");
    }
}