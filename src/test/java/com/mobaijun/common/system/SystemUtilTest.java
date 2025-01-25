/*
 * Copyright (C) 2022 [www.mobaijun.com]
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
package com.mobaijun.common.system;

import com.mobaijun.common.tool.Console;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * Description: [SystemUtilTest测试类]
 * Author: [mobaijun]
 * Date: [2024/4/23 10:48]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class SystemUtilTest {

    @Test
    public void getSystemInfo() {
        List<Map<String, Object>> systemInfo = SystemUtil.getSystemInfo();
        Console.println(systemInfo);
    }

    @Test
    public void processList() {
        List<List<String>> lists = SystemUtil.processList();
        Console.println(lists);
    }

    @Test
    public void getPidS() {
        List<String> pidS = SystemUtil.getPidS();
        Console.println(pidS);
    }

    @Test
    public void getProcessInfo() {
        // 获取进程ID列表
        List<String> pidList = SystemUtil.getPidS();
        // 使用 Lambda 表达式遍历进程ID列表，并打印每个进程的信息
        pidList.forEach(pid -> {
            String processInfo = SystemUtil.getProcessInfo(pid);
            Console.println(processInfo);
        });
    }
}