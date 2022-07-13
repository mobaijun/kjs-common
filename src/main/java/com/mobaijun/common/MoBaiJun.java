package com.mobaijun.common;

import cn.hutool.core.lang.ConsoleTable;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Set;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: MoBaiJun
 * class description：<img src="https://www.ghibli.jp/gallery/redturtle049.jpg" alt="migrate" height="400" width="800">
 *
 * @author MoBaiJun 2022/7/13 16:15
 */
public class MoBaiJun {
    public static void main(String[] args) {
        printAllUtils();
    }


    private static Set<Class<?>> getAllUtils() {
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
}
