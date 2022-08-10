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
package com.mobaijun.common.base.controller;

import com.mobaijun.common.base.BaseWrapper;
import com.mobaijun.common.exception.CustomException;
import com.mobaijun.common.result.enums.HttpStatus;
import com.mobaijun.common.util.ObjectUtils;
import com.mobaijun.common.util.StringUtils;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: BaseController
 * 类描述： 通用数据处理
 *
 * @author MoBaiJun 2022/4/22 16:54
 */
public class BaseController {

    /**
     * 成功
     */
    protected static String SUCCESS = "SUCCESS";

    /**
     * 错误
     */
    protected static String ERROR = "ERROR";

    /**
     * 重定向
     */
    protected static String REDIRECT = "redirect:";

    /**
     * 转发
     */
    protected static String FORWARD = "forward:";

    /**
     * 参数是否为空的校验
     *
     * @param object  对象
     * @param message 消息
     */
    public void assertNotNull(Object object, String message) {
        if (ObjectUtils.isEmpty(object)) {
            throw new CustomException(HttpStatus.ERROR.getCode(), message);
        }
    }

    /**
     * 参数是否为空的校验
     *
     * @param str     字符串
     * @param message 消息
     */
    public void assertNotEmpty(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            throw new CustomException(HttpStatus.ERROR.getCode(), message);
        }
    }

    /**
     * 判断条件是否符合
     *
     * @param condition 判断条件
     * @param message   消息
     */
    public void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new CustomException(HttpStatus.ERROR.getCode(), message);
        }
    }

    /**
     * 包装一个list，让list增加额外属性
     *
     * @param wrapper wrapper
     * @return Object
     */
    @SuppressWarnings("all")
    protected <T> T warpObject(BaseWrapper wrapper) {
        return (T) wrapper.warp();
    }
}