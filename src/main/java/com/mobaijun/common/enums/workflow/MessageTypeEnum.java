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
package com.mobaijun.common.enums.workflow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [消息类型]
 * Author: [mobaijun]
 * Date: [2024/11/12 10:36]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@AllArgsConstructor
public enum MessageTypeEnum {

    /**
     * 站内信
     */
    SYSTEM_MESSAGE("1", "站内信"),

    /**
     * 邮箱
     */
    EMAIL_MESSAGE("2", "邮箱"),

    /**
     * 短信
     */
    SMS_MESSAGE("3", "短信");

    /**
     * 消息类型
     */
    private final static Map<String, MessageTypeEnum> MESSAGE_TYPE_ENUM_MAP = new ConcurrentHashMap<>(MessageTypeEnum.values().length);

    static {
        for (MessageTypeEnum messageType : MessageTypeEnum.values()) {
            MESSAGE_TYPE_ENUM_MAP.put(messageType.code, messageType);
        }
    }

    /**
     * 索引
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;

    /**
     * 根据消息类型 code 获取 MessageTypeEnum
     *
     * @param code 消息类型code
     * @return MessageTypeEnum
     */
    public static MessageTypeEnum getByCode(String code) {
        return MESSAGE_TYPE_ENUM_MAP.get(code);
    }
}