package com.mobaijun.common.util;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Description: [UrlParamsUtilTest测试类]
 * Author: [mobaijun]
 * Date: [2023/12/21 9:59]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class UrlParamsUtilTest {

    @Test
    public void testSplit() {
        Map<String, String> result = UrlParamsUtil.
                split("http://localhost:8080/sys/monitor-process-property/list?PId=39bb8e4e211dc01e32fd06c801715d40&pageindex=0&pagesize=10");
        assertEquals(result, result);
    }

    @Test
    public void testSplit2() {
        Map<String, String> result = UrlParamsUtil.split("http://localhost:8080/sys/monitor-process-property/list?PId=39bb8e4e211dc01e32fd06c801715d40&pageindex=0&pagesize=10", "=");
        assertEquals(result, result);
    }

    @Test
    public void testBuild() {

    }

    @Test
    public void testAdd() {
        UrlParamsUtil.add(Map.of("originMap", "originMap"), "keyValues");
    }
}