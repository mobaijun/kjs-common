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
package com.mobaijun.common.result;

import com.mobaijun.common.result.enums.HttpStatus;
import com.mobaijun.common.util.ObjectUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: ErrorTip<br>
 * 类描述： 异常提示
 *
 * @author MoBaiJun 2022/4/22 17:24
 */
@Getter
@Setter
public class ErrorTip<T> extends AbstractTip<T> implements Serializable {

    /**
     * 返回数据
     */
    private T data;

    public ErrorTip() {
        super();
        super.code = HttpStatus.ERROR.getCode();
        super.message = HttpStatus.ERROR.getMessage();
    }

    /**
     * 判断数据是否异常
     *
     * @param data 数据
     */
    public ErrorTip(T data) {
        super();
        if (ObjectUtil.isEmpty(data)) {
            super.code = HttpStatus.ERROR.getCode();
            super.message = HttpStatus.ERROR.getMessage();
        }
    }

    /**
     * 返回状态码和消息
     *
     * @param code    状态码
     * @param message 消息
     */
    public ErrorTip(int code, String message) {
        super();
        super.code = code;
        super.message = message;
    }

    /**
     * 返回异常信息和状态码
     *
     * @param code    状态码
     * @param message 异常信息
     * @param data    消息体
     */
    public ErrorTip(int code, String message, T data) {
        super();
        if (ObjectUtil.isEmpty(data)) {
            super.code = code;
            super.message = message;
            this.data = data;
        }
    }

    /**
     * 返回异常信息
     *
     * @param message 异常信息
     */
    public ErrorTip(String message) {
        super();
        super.message = message;
    }
}