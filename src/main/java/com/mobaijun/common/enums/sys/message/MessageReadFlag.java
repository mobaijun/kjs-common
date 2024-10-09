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
package com.mobaijun.common.enums.sys.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: MessageReadFlag<br>
 * enum description：消息阅读状态
 *
 * @author MoBaiJun 2022/5/12 14:07
 */
@Getter
@RequiredArgsConstructor
public enum MessageReadFlag {
    /**
     * 未读
     */
    UNREAD(0, "未读"),

    /**
     * 已读
     */
    READ(1, "已读");

    /**
     * 消息阅读状态
     */
    private final Integer code;

    /**
     * 消息阅读状态描述
     */
    private final String name;

    public static String getName(Integer code) {
        if (code == null) {
            return null;
        }
        for (MessageReadFlag flagEnum : MessageReadFlag.values()) {
            if (flagEnum.getCode().equals(code)) {
                return flagEnum.name;
            }
        }
        return null;
    }
}