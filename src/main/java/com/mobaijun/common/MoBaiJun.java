/*
 * Copyright (C) 2022 www.mobaijun.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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