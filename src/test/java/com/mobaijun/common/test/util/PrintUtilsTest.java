package com.mobaijun.common.test.util;

import com.mobaijun.common.util.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: PrintUtilsTest
 * class description: 打印
 *
 * @author MoBaiJun 2022/11/22 18:55
 */
public class PrintUtilsTest {
    public static void main(String[] args) {
        // 打印异常信息
        PrintUtil.println("空的", Long.class);

        // 不换行输出
        PrintUtil.print("Hello World!");

        // 打印空格
        PrintUtil.print();

        // 换行打印输出
        PrintUtil.println("Hello World!");

        // 单列集合打印
        List<String> list = new ArrayList<>(10);
        list.add("mobaijun");
        list.add("框架师");
        PrintUtil.println(list);

        // 格式化输出
        PrintUtil.printf("%s", "mobaijun");

        // println String map key and value
        Map<String, String> map = new HashMap<>(10);
        map.put("1", "mobaijun1");
        map.put("2", "mobaijun2");
        map.put("3", "mobaijun3");
        PrintUtil.println(map);

        // println  map values
        PrintUtil.mapValue(map);

        // println String map key
        PrintUtil.mapKey(map);
    }
}
