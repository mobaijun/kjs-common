/*
 * Copyright (C) 2022 [mobaijun]
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
package com.mobaijun.common.enums.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Description: [协议类型枚举，包含常见协议的名称和值。]
 * Author: [mobaijun]
 * Date: [2024/2/1 8:24]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@RequiredArgsConstructor
public enum ProtocolType {

    /**
     * HTTP 协议
     */
    HTTP("HTTP", "http://"),

    /**
     * HTTPS 协议
     */
    HTTPS("HTTPS", "https://"),

    /**
     * FTP 协议
     */
    FTP("FTP", "ftp://"),

    /**
     * SMTP 协议
     */
    SMTP("SMTP", "smtp://"),

    /**
     * POP3 协议
     */
    POP3("POP3", "pop3://"),

    /**
     * IMAP 协议
     */
    IMAP("IMAP", "imap://"),

    /**
     * TCP 协议
     */
    TCP("TCP", "tcp://"),

    /**
     * UDP 协议
     */
    UDP("UDP", "udp://"),

    /**
     * SSH 协议
     */
    SSH("SSH", "ssh://"),

    /**
     * WebSocket (WS) 协议
     */
    WS("WebSocket", "ws://");

    /**
     * 协议名称
     */
    private final String name;

    /**
     * 协议值
     */
    private final String value;

    /**
     * 根据协议名称获取协议值。
     *
     * @param protocolName 协议名称
     * @return 对应的协议值，如果未找到则返回 null
     */
    public static String getValueByName(String protocolName) {
        for (ProtocolType protocol : ProtocolType.values()) {
            if (protocol.getName().equalsIgnoreCase(protocolName)) {
                return protocol.getValue();
            }
        }
        // 如果未找到匹配的协议名称，返回 null
        return null;
    }
}
