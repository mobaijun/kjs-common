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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: R<br>
 * class description：返回体结构
 *
 * @author MoBaiJun 2022/6/30 15:01
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public static <T> R<T> ok() {
        return ok(null);
    }

    public static <T> R<T> ok(T data) {
        return new R<T>().setCode(HttpStatus.OK.getCode()).setData(data)
                .setMessage(HttpStatus.OK.getMessage());
    }

    public static <T> R<T> ok(T data, String message) {
        return new R<T>().setCode(HttpStatus.OK.getCode()).setData(data).setMessage(message);
    }

    public static <T> R<T> failed(int code, String message) {
        return new R<T>().setCode(code).setMessage(message);
    }

    public static <T> R<T> failed(HttpStatus failMsg) {
        return new R<T>().setCode(failMsg.getCode()).setMessage(failMsg.getMessage());
    }

    public static <T> R<T> failed(HttpStatus failMsg, String message) {
        return new R<T>().setCode(failMsg.getCode()).setMessage(message);
    }
}