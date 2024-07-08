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
package com.mobaijun.common.exception.service;

/**
 * Description: [异常接口]
 * Author: [mobaijun]
 * Date: [2024/7/5 15:15]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public interface ResultCode {

    /**
     * 获取业务码
     *
     * @return 业务码
     */
    Integer getCode();

    /**
     * 获取信息
     *
     * @return 返回结构体中的信息
     */
    String getMessage();
}
