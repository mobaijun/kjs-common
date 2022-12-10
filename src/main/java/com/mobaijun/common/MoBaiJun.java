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
import com.mobaijun.common.util.StringUtil;

import java.util.Set;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: MoBaiJun<br/>
 * class description：根类<br>
 * <img src="https://tencent.cos.mobaijun.com/img/icon/avatar.jpg" alt="migrate" height="300" width="400"><br>
 *
 * @author MoBaiJun 2022/7/13 16:15
 */
public class MoBaiJun {

    private static Set<Class<?>> getAllUtils(String packageName, String suffix) {
        return ClassUtil.scanPackage(packageName,
                (clazz) -> (!clazz.isInterface()) && StringUtil.endWith(clazz.getSimpleName(), suffix));
    }

    /**
     * 控制台打印所有工具类
     */
    public static void printAllUtils(String packageName, String suffix) {
        final Set<Class<?>> allUtils = getAllUtils(packageName, suffix);
        final ConsoleTable consoleTable = ConsoleTable.create().addHeader("工具类名", "所在包");
        allUtils.forEach(temp -> consoleTable.addBody(temp.getSimpleName(), temp.getPackage().getName()));
        consoleTable.print();
    }
}