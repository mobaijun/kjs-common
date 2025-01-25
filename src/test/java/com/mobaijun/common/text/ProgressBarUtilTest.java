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
package com.mobaijun.common.text;

import junit.framework.TestCase;

public class ProgressBarUtilTest extends TestCase {

    public void testMain() throws InterruptedException {
        // 自定义进度条参数
        ProgressBarUtil.Builder builder = new ProgressBarUtil.Builder()
                .setBarLength(60)
                .setProgressChar('=')
                .setHeadChar('>')
                .setRemainingChar('-');

        builder.apply();  // 应用设置

        // 初始化进度条
        long total = 100;
        ProgressBarUtil.init(total);

        for (int i = 0; i < total; i++) {
            ProgressBarUtil.update(1);
            // 模拟任务处理时间
            Thread.sleep(50);
        }

        ProgressBarUtil.complete();
    }
}