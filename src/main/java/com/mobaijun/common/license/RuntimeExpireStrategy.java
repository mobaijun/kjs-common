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
package com.mobaijun.common.license;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * interface name: RuntimeExpireStrategy<br>
 * interface description: 软件运行时过期
 *
 * @author MoBaiJun 2023/2/22 0:35
 */
public interface RuntimeExpireStrategy {

    /**
     * 许可过期配置
     *
     * @param entity 许可证实体
     */
    void expire(LicenseEntity entity);
}
