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
package com.mobaijun.common.algorithm;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: BoyerMoore<br>
 * class description: Boyer-Moore算法实现
 * <p>
 * Boyer-Moore算法是一种用于字符串匹配的高效算法，其核心思想是尽可能地跳过匹配失败的字符
 * </p>
 *
 * @author MoBaiJun 2023/2/20 9:08
 */
public final class BoyerMoore {

    /**
     * Boyer-Moore算法的主要实现，用于匹配源字符串和匹配字符串。<br/>
     * Boyer-Moore算法的时间复杂度是O(n+m)，其中n是源字符串的长度，m是匹配字符串的长度。<br/>
     * 因此，在匹配大字符串时，Boyer-Moore算法比朴素的字符串匹配算法要快得多。
     *
     * @param s 源字符串
     * @param p 匹配字符串
     * @return 返回匹配到的第一个位置，未匹配返回-1
     */
    public static int boyerMoore(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (n < m) {
            return -1;
        }

        // 生成坏字符表和好后缀表
        int[] bc = generateBC(p);
        int[] gs = generateGS(p);

        // i表示s与p匹配的第一个字符位置
        int i = 0;
        while (i <= n - m) {
            int j = m - 1;
            // 从后往前匹配，直到不匹配或p完全匹配为止
            while (j >= 0 && s.charAt(i + j) == p.charAt(j)) {
                j--;
            }
            // 若完全匹配，则返回第一个匹配位置i
            if (j < 0) {
                return i;
            }
            // 计算坏字符规则下的移动距离
            int x = j - bc[(int) s.charAt(i + j)];
            int y = 0;
            // 若存在好后缀，则计算好后缀规则下的移动距离
            if (j < m - 1) {
                y = moveByGS(j, m, gs);
            }
            // 取移动距离较大的值
            i += Math.max(x, y);
        }
        // 未匹配成功
        return -1;
    }

    /**
     * 生成坏字符表
     *
     * @param p 匹配字符串
     * @return 坏字符表
     */
    private static int[] generateBC(String p) {
        int[] bc = new int[256];
        // 初始化坏字符表为-1
        for (int i = 0; i < 256; i++) {
            bc[i] = -1;
        }
        // 计算每个字符在p中最后出现的位置
        for (int i = 0; i < p.length(); i++) {
            bc[(int) p.charAt(i)] = i;
        }
        return bc;
    }

    /**
     * 生成好后缀表
     *
     * @param p 匹配字符串
     * @return 好后缀表
     */
    private static int[] generateGS(String p) {
        int m = p.length();
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        int[] gs = new int[m];

        // 计算后缀子串
        for (int i = m - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < m && p.charAt(i) == p.charAt(j)) {
                suffix[++i] = j++;
            }
            if (j == m) {
                prefix[i] = true;
            }
        }

        // 初始化好后缀表
        for (int i = 0; i < m; i++) {
            gs[i] = m;
        }

        // 计算匹配好后缀的位置和移动距离
        for (int i = 0, j = m - 1; j >= 0; j--) {
            if (prefix[j]) {
                while (i < m - 1 && j < suffix[i + 1]) {
                    i++;
                }
                gs[i] = j - suffix[i] + m - 1 - i;
            }
        }

        // 根据suffix数组更新gs数组，以确保在某个位置出现坏字符时，能够移动至正确的位置
        for (int i = 0; i < m - 1; i++) {
            gs[m - 1 - suffix[i]] = m - 1 - i;
        }
        return gs;
    }

    /**
     * 根据好后缀规则移动模式串的位置
     *
     * @param j  当前比较字符在模式串中的位置
     * @param m  模式串长度
     * @param gs 好后缀规则数组
     * @return 移动模式串的距离
     */
    private static int moveByGS(int j, int m, int[] gs) {
        // 计算好后缀的长度
        int k = m - 1 - j;
        // 如果存在和好后缀匹配的子串
        if (gs[k] != m) {
            // 移动模式串到匹配位置
            return k - gs[k] + 1;
        }
        // 否则尝试找到与好后缀匹配的最长后缀子串
        for (int r = j + 2; r <= m - 1; r++) {
            if (gs[m - r] == r - j) {
                return r - j;
            }
        }
        // 如果不存在匹配的后缀子串，则移动整个模式串
        return m;
    }
}
