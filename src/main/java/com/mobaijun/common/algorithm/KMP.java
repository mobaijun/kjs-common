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
 * class name: KMP<br>
 * class description: KMP算法
 * <p>
 * KMP算法是一种用于在一个字符串中查找一个子串出现位置的高效算法。其基本思路是对子串进行预处理，生成一个next数组，用于在查找过程中进行匹配失败时的回退。
 * <p>
 * KMP算法的实现包含两个主要部分：生成next数组和查找子串。
 * <p>
 * 生成next数组的过程如下：
 * <p>
 * 1.初始化next数组，next[0]=-1，i=0，j=-1；<br/>
 * 2.循环执行以下步骤直到i=p.length()-1：<br/>
 * --1.如果j=-1或p[i]==p[j]，则i++，j++，并将next[i]=j；<br/>
 * --2.否则，将j赋值为next[j]；<br/>
 * 3.返回next数组。<br/>
 * 在查找子串的过程中，维护两个指针i和j，分别指向原字符串和子串中的当前字符，不断进行匹配，如果匹配失败，则根据next数组回退j指针。
 * <p>
 * 具体地，查找过程如下：
 * <p>
 * 1.初始化i=0，j=0；<br/>
 * 2.循环执行以下步骤直到i=s.length()或j=p.length()：<br/>
 * --1.如果j=-1或s[i]==p[j]，则i++，j++；<br/>
 * --2.否则，将j赋值为next[j]；<br/>
 * 3.如果j==p.length()，则表示匹配成功，返回i-j；<br/>
 * 否则，表示未找到子串，返回-1。
 * </p>
 *
 * @author MoBaiJun 2023/2/20 9:02
 */
public final class KMP {

    /**
     * KMP算法，用于在字符串s中查找是否包含子串p，如果存在则返回第一次出现的位置，否则返回-1<br/>
     * 这里的实现还对查找过程中的比较操作进行了优化，使用了字符数组而非字符串的charAt方法，避免了不必要的临时对象创建和字符拆箱装箱操作。
     *
     * @param s 被查找的字符串
     * @param p 要查找的子串
     * @return 第一次出现的位置或-1
     */
    public static int kmp(String s, String p) {
        // 获取p的next数组
        int[] next = getNext(p);
        int i = 0, j = 0;
        // 在s中查找是否包含p
        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                // 失配时回溯到next[j]
                j = next[j];
            }
        }
        if (j == p.length()) {
            // 找到了p
            return i - j;
        }
        // 未找到p
        return -1;
    }

    /**
     * 获取模式串的next数组
     *
     * @param p 模式串
     * @return next数组
     */
    private static int[] getNext(String p) {
        int[] next = new int[p.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < p.length() - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                // 失配时回溯到next[j]
                j = next[j];
            }
        }
        return next;
    }
}
