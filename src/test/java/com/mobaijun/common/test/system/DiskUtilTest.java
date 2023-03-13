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
package com.mobaijun.common.test.system;

import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.system.DiskUtil;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: DiskUtilTest<br>
 * class description: <br>
 *
 * @author MoBaiJun 2022/12/13 11:15
 */
public class DiskUtilTest {

    @Test
    public void diskUtilTest() {
        // 获取内存使用情况
        Map<String, String> memoryInfo = DiskUtil.getMemoryInfo();
        PrintUtil.println(memoryInfo);

        // disks 返回 ArrayList 形式的硬盘分区
        ArrayList<File> files = DiskUtil.diskInformation();
        PrintUtil.println(files);
    }
}
