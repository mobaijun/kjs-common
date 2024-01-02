package com.mobaijun.common.util.file;

import org.junit.Assert;
import org.junit.Test;

/**
 * Description: [MimeTypeUtilTest测试类]
 * Author: [xzh]
 * Date: [2023/12/27 17:45]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2021.1.4]
 */
public class MimeTypeUtilTest {

    @Test
    public void testGetExtension() throws Exception {
        String result = MimeTypeUtil.getExtension("image/png");
        Assert.assertEquals("png", result);
    }
}
