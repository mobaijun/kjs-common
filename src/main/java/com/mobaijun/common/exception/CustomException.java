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
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: CustomException
 * 类描述： 自定义异常信息
 *
 * @author MoBaiJun 2022/4/22 16:57
 */
public class CustomException extends BaseException {

    public CustomException(Integer errorCode, String userTip) {
        super(errorCode, userTip);
    }
}