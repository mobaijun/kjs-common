package com.mobaijun.common;

import cn.hutool.core.lang.ConsoleTable;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.mobaijun.common.util.PrintUtils;
import com.mobaijun.common.util.stream.StreamUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: KjsCommon
 * 类描述：
 *
 * @author MoBaiJun 2022/4/24 9:42
 */
public class KjsCommon {

    /**
     * 显示所有的工具类
     *
     * @return 工具类名集合
     */
    public static Set<Class<?>> getAllUtils() {
        return ClassUtil.scanPackage("com.mobaijun.common",
                (clazz) -> (!clazz.isInterface()) && StrUtil.endWith(clazz.getSimpleName(), "Utils"));
    }


    /**
     * 控制台打印所有工具类
     */
    public static void printAllUtils() {
        final Set<Class<?>> allUtils = getAllUtils();
        final ConsoleTable consoleTable = ConsoleTable.create().addHeader("工具类名", "所在包");
        for (Class<?> clazz : allUtils) {
            consoleTable.addBody(clazz.getSimpleName(), clazz.getPackage().getName());
        }
        consoleTable.print();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        PrintUtils.println(list);
        PrintUtils.print();
        List<String> distinct = StreamUtils.distinct(list);
        assert distinct != null;
        distinct.forEach(System.out::println);
    }
}
