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

import com.mobaijun.common.constant.StringConstant;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [任务状态]
 * Author: [mobaijun]
 * Date: [2024/11/12 10:37]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@AllArgsConstructor
public enum TaskStatusEnum {

    /**
     * 撤销
     */
    CANCEL("cancel", "撤销"),

    /**
     * 通过
     */
    PASS("pass", "通过"),

    /**
     * 待审核
     */
    WAITING("waiting", "待审核"),

    /**
     * 作废
     */
    INVALID("invalid", "作废"),
    /**
     * 退回
     */
    BACK("back", "退回"),

    /**
     * 终止
     */
    TERMINATION("termination", "终止"),

    /**
     * 转办
     */
    TRANSFER("transfer", "转办"),

    /**
     * 委托
     */
    PENDING("pending", "委托"),

    /**
     * 抄送
     */
    COPY("copy", "抄送"),

    /**
     * 加签
     */
    SIGN("sign", "加签"),

    /**
     * 减签
     */
    SIGN_OFF("sign_off", "减签"),

    /**
     * 超时
     */
    TIMEOUT("timeout", "超时");

    /**
     * 状态
     */
    private final String status;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 任务业务状态
     *
     * @param status 状态
     */
    public static String findByStatus(String status) {
        if (status.isBlank()) {
            return StringConstant.BLANK;
        }

        return Arrays.stream(TaskStatusEnum.values())
                .filter(statusEnum -> statusEnum.getStatus().equals(status))
                .findFirst()
                .map(TaskStatusEnum::getDesc)
                .orElse(StringConstant.BLANK);
    }
}