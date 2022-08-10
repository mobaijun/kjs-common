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
package com.mobaijun.common.enums.dict;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: DictSelectTagHead
 * enum description：字典下拉选头类型
 *
 * @author MoBaiJun 2022/5/12 14:13
 */
@Getter
public enum DictSelectTagHeadEnum {
    /**
     * 全部
     */
    ALL("1", "全部"),

    /**
     * 请选择
     */
    SELECT("2", "请选择");

    private final String code;

    private final String name;

    DictSelectTagHeadEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据code获取枚举
     *
     * @param code code
     * @return DictSelectTagHeadEnum
     */
    public static DictSelectTagHeadEnum codeToEnum(String code) {
        if (null != code) {
            for (DictSelectTagHeadEnum e : DictSelectTagHeadEnum.values()) {
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
    public static String codeToName(String code) {
        if (null != code) {
            for (DictSelectTagHeadEnum e : DictSelectTagHeadEnum.values()) {
                if (e.getCode().equals(code)) {
                    return e.getName();
                }
            }
        }
        return "未知";
    }
}