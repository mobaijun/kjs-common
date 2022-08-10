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
package com.mobaijun.common.util.sensitive;

import cn.hutool.core.date.DateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: TestDemo
 * class description：
 *
 * @author MoBaiJun 2022/5/18 10:55
 */
@Getter
@Setter
public class TestDemo {
    @Mask(prefixNoMaskLen = 3, suffixNoMaskLen = 4)
    private String arced;

    @Mask(prefixNoMaskLen = 1)
    private String name;

    @Mask(prefixNoMaskLen = 4)
    private String birthday;

    @Mask(prefixNoMaskLen = 1, suffixNoMaskLen = 8,maskStr = "-")
    private String email;

    @Override
    public String toString() {
        // 重写toString（）方法
        return new MaskToStringBuilder(this).toString();
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.setArced("4547665157465765");
        testDemo.setName("墨白君");
        testDemo.setEmail("mobaijun8@163.com");
        testDemo.setBirthday(DateTime.now().toString());
        System.out.println("testDemo = " + testDemo);
    }
}