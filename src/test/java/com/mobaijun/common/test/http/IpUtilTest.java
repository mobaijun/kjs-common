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
package com.mobaijun.common.test.http;

import com.mobaijun.common.http.IpUtil;
import com.mobaijun.common.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: IpUtilTest<br>
 * class description: IP测试工具类
 *
 * @author MoBaiJun 2023/3/1 23:29
 */
public class IpUtilTest {


    @Test
    public void ipUtilTest() {
        // 获取当前机器的hostname
        PrintUtil.println(IpUtil.getHostName());

        // 获取本机IP地址
        PrintUtil.println(IpUtil.getLocalIpAddress());

        // 用于判断该IP地址是否为内部IP地址
        PrintUtil.println(IpUtil.internalIp("157.148.134.11"));

        // [-99, -108, -122, 11]
        System.out.println("bytes = " + Arrays.toString(IpUtil.textToNumericFormatV4("157.148.134.11")));

        // 192.168.1.2 转为 192168001002
        PrintUtil.println(IpUtil.getRegroupIp("157.148.134.11"));

        // 判断是网络地址还是本地地址（不知道这样准不准确）
        PrintUtil.println(IpUtil.isOnLineSource("https://github.com/"));

        // 获取服务端口/java.util.NoSuchElementException
        // PrintUtil.println(IpUtil.getServicePort());

        // 判断指定IP地址是否可访问
        PrintUtil.println(IpUtil.isReachable("157.148.134.11"));

        // 获取局域网内的所有IP地址
        Arrays.stream(Objects.requireNonNull(IpUtil.getLocalIpAddresses())).forEach(PrintUtil::println);
    }
}
