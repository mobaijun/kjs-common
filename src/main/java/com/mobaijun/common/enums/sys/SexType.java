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
package com.mobaijun.common.enums.sys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: Sex<br>
 * enum description： 性别
 *
 * @author MoBaiJun 2022/5/11 11:36
 */
@Getter
@ToString
@RequiredArgsConstructor
public enum SexType {

    /**
     * 男
     */
    M("M", "男"),

    /**
     * 女
     */
    F("F", "女"),

    /**
     * 非二元性别（gender non-binary）
     */
    G("G", "非二元性别"),

    /**
     * Trans/Transgender(跨性别者)
     */
    T("T", "跨性别者"),

    /**
     * 未知
     */
    N("N", "未知");

    /**
     * 性别编码
     */
    private final String code;

    /**
     * 性别中文含义
     */
    private final String message;

    /**
     * 根据code获取枚举
     *
     * @param code String
     * @return SexType
     */
    public static SexType codeToEnum(String code) {
        if (null != code) {
            for (SexType e : SexType.values()) {
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * 编码转化成中文含义
     *
     * @param code String
     * @return String
     */
    public static String codeToMessage(String code) {
        if (null != code) {
            for (SexType e : SexType.values()) {
                if (e.getCode().equals(code)) {
                    return e.getMessage();
                }
            }
        }
        return "unknown";
    }
}