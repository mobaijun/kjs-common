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
package com.mobaijun.common.util.system;

import com.mobaijun.common.constant.JdkConstant;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: Server<br>
 * class description： 服务器相关信息<br>
 *
 * @author MoBaiJun 2022/5/12 11:10
 */
@Getter
@Setter
public class Server {

    private static final int OSHI_WAIT_SECOND = 1000;

    /**
     * CPU相关信息
     */
    private SysCpu cpu = new SysCpu();

    /**
     * 內存相关信息
     */
    private SysMem mem = new SysMem();

    /**
     * JVM相关信息
     */
    private SysJvm jvm = new SysJvm();

    /**
     * 服务器相关信息
     */
    private System sys = new System();

    /**
     * 磁盘相关信息
     */
    private List<SysFile> sysFiles = new LinkedList<>();

    /**
     * 设置Java虚拟机
     */
    private void setJvmInfo() {
        Properties props = java.lang.System.getProperties();
        jvm.setTotal(Runtime.getRuntime().totalMemory());
        jvm.setMax(Runtime.getRuntime().maxMemory());
        jvm.setFree(Runtime.getRuntime().freeMemory());
        jvm.setVersion(props.getProperty(JdkConstant.VERSION));
        jvm.setHome(props.getProperty(JdkConstant.HOME));
    }

    /**
     * 字节转换
     *
     * @param size 字节大小
     * @return 转换后值
     */
    public String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else {
            return String.format("%d B", size);
        }
    }
}