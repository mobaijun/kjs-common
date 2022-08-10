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
package com.mobaijun.common.enums.message;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: MessageReadFlagEnum
 * enum description：消息阅读状态
 *
 * @author MoBaiJun 2022/5/12 14:07
 */
@Getter
public enum MessageReadFlagEnum {
    /**
     * 未读
     */
    UNREAD(0, "未读"),

    /**
     * 已读
     */
    READ(1, "已读");

    private final Integer code;

    private final String name;

    MessageReadFlagEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(Integer code) {
        if (code == null) {
            return null;
        }
        for (MessageReadFlagEnum flagEnum : MessageReadFlagEnum.values()) {
            if (flagEnum.getCode().equals(code)) {
                return flagEnum.name;
            }
        }
        return null;
    }
}