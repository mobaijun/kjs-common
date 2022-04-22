package com.mobaijun.common.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * Author: https://www.mobaijun.com
 * Date: 2022/2/25 17:44
 * ClassName:DateUtil
 * 类描述： 时间日期工具类
 */
public class DateUtils {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("墨白君1");
        list.add("墨白君2");
        list.add("墨白君3");
        list.add("墨白君4");
        list.add("墨白君5");
        list.add("墨白君6");
        PrintUtils.println(list);
        PrintUtils.print();
        Map<String, String> map = new HashMap<>(100);
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        map.put("6", "1");
        PrintUtils.println(map);
        MavenUtils.mavenClear("F:\\repository");
    }
}
