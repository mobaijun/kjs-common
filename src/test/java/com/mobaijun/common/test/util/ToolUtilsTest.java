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
package com.mobaijun.common.test.util;

import com.mobaijun.common.cache.HashMapSingletonCacheUtils;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.tool.ToolUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: ToolUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 17:49
 */
public class ToolUtilsTest {

    @Test
    public void toolUtilsTest() {
        // 判断一个对象是否是时间类型
        PrintUtil.println(ToolUtil.dateType(new Date().getTime()));

        // 获取异常的具体信息
        PrintUtil.println(ToolUtil.getExceptionMsg(new NullPointerException("空指针异常！")));

        // 比较两个对象是否相等
        PrintUtil.println(ToolUtil.equals(LocalDate.now(), LocalDate.now()));

        // 计算对象长度，如果是字符串调用其length函数，集合类调用其size函数，数组调用其length属性，其他可遍历对象遍历计算长度
        PrintUtil.println(ToolUtil.length(HashMapSingletonCacheUtils.getInstance()));

        // 对象中是否包含元素
        PrintUtil.println(ToolUtil.contains(HashMapSingletonCacheUtils.getInstance(), 1));

        // 对象是否不为空(新增)
        PrintUtil.println(ToolUtil.isNotEmpty(LocalDate.now()));

        // 对象是否为空
        PrintUtil.println(ToolUtil.isEmpty(LocalDate.now()));
    }
}
