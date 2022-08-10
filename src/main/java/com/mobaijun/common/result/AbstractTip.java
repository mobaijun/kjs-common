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

import lombok.Getter;
import lombok.Setter;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: Tip
 * 类描述： 返回给前台的提示（最终转化为json形式）
 *
 * @author MoBaiJun 2022/4/22 17:22
 */
@Getter
@Setter
public abstract class AbstractTip<T> {

    /**
     * 状态码
     */
    protected int code;

    /**
     * 返回消息
     */
    protected String message;

    /**
     * 返回数据
     */
    protected T data;
}