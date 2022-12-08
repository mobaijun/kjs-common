package com.mobaijun.common.test.util;

import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.UrlParamsUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: UrlParamsUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 17:48
 */
public class UrlParamsUtilsTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(10);
        map.put("1", "mobai");
        map.put("2", "mobaijun");
        map.put("3", "mobai123");
        // 将Map转成String, 可以指定分隔符
        PrintUtil.println(UrlParamsUtil.join(map, ","));

        // 解析ulr参数为map
        PrintUtil.println(UrlParamsUtil.split("https://www.mobaijun.com/test/demo_form.php?name1=value1&name2=value2"));
    }
}
