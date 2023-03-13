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
package com.mobaijun.common.enums;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: EnvEnum<br>
 * enum description：环境枚举<br>
 *
 * @author MoBaiJun 2022/5/18 9:50
 */
public enum EnvEnum {

    /**
     * Development environment
     * 开发环境，外部用户无法访问，开发人员使用，版本变动很大。
     */
    DEV,

    /**
     * System Integration Test
     * 系统集成测试，开发人员自己测试流程是否走通。
     */
    SIT,

    /**
     * 测试环境，外部用户无法访问，专门给测试人员使用的，版本相对稳定。
     */
    TEST,

    /**
     * Feature Acceptance Test environment
     * 功能验收测试环境，用于软件测试者测试使用
     */
    FAT,

    /**
     * User Acceptance Test environment
     * 用户验收测试环境，用于生产环境下的软件测试者测试使用。
     */
    UAT,

    /**
     * 灰度环境，外部用户可以访问，但是服务器配置相对低，其它和生产一样，外部用户可以访问，版本发布初期，正式版本发布前。
     */
    PRE,

    /**
     * Production environment
     * 生产环境，面向外部用户的环境，连接上互联网即可访问的正式环境。真正上线的环境
     */
    PRO
}