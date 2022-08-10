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
package com.mobaijun.common.exception;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: AbstractExceptionEnum
 * interface description：
 * 接口描述：
 *
 * @author MoBaiJun 2022/5/12 11:24
 */
public interface AbstractExceptionEnum {

    /**
     * 获取异常的状态码
     *
     * @return String
     */
    Integer getErrorCode();

    /**
     * 获取给用户提示信息
     *
     * @return String
     */
    String getUserTip();
}