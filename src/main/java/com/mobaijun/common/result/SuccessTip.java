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
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Software：IntelliJ IDEA 2021.3.2<br>
 * ClassName: SuccessTip<br>
 * 类描述： 成功提示
 *
 * @author MoBaiJun 2022/4/22 17:25
 */
@Getter
@Setter
public class SuccessTip<T> extends AbstractTip<T> implements Serializable {

    /**
     * 返回数据
     */
    private T data;

    /**
     * 返回信息
     */
    public SuccessTip() {
        super.code = HttpStatus.OK.getCode();
        super.message = HttpStatus.OK.getMessage();
    }

    /**
     * 返回信息
     *
     * @param data 返回对象
     */
    public SuccessTip(T data) {
        this.data = data;
        super.code = HttpStatus.OK.getCode();
        super.message = HttpStatus.OK.getMessage();
    }
}