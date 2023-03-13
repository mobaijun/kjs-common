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
package com.mobaijun.common.algorithm;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: BruteForce<br>
 * class description: 暴力匹配算法
 * <p>
 * 暴力匹配算法又称为朴素匹配算法，是一种简单粗暴的字符串匹配算法。它的基本思想是：从主串的第一个字符开始，与模式串的第一个字符比较，如果相同，则继续比较主串和模式串的下一个字符，直到模式串的最后一个字符匹配成功。
 * 如果某一字符匹配失败，主串回退到上一个字符位置的下一个字符，模式串重新从第一个字符开始匹配，以此类推，直到主串和模式串匹配成功或者主串遍历结束。
 * </p>
 *
 * @author MoBaiJun 2023/2/20 8:07
 */
public final class BruteForce {

    /**
     * 暴力匹配算法实现
     * <img src="https://img-blog.csdnimg.cn/img_convert/0e2f5958a03b17d807be5cadcab9a7c8.gif"/>
     *
     * @param pattern 待匹配的字符串
     * @param text    匹配的文本
     * @return 匹配的起始位置，如果未匹配返回-1
     */
    public static int bruteForceMatch(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();

        // 遍历文本
        for (int i = 0; i <= n - m; i++) {
            // 遍历模式串
            int j = 0;
            while (j < m && pattern.charAt(j) == text.charAt(i + j)) {
                j++;
            }

            // 如果遍历完整个模式串，说明找到了匹配
            if (j == m) {
                return i;
            }
        }

        // 未找到匹配
        return -1;
    }
}
