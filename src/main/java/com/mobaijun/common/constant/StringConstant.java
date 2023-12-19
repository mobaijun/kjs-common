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
package com.mobaijun.common.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: StringConstant<br>
 * class description： 字符串常量<br>
 *
 * @author MoBaiJun 2022/5/18 9:49
 */
public final class StringConstant {

    /**
     * VERTICAL_BAR
     */
    public static final String VERTICAL_BAR = "|";

    /**
     * DOT
     */
    public static final String DOT = ".";

    /**
     * PERIOD
     */
    public static final String PERIOD = "。";

    /**
     * ASTERISK
     */
    public static final String ASTERISK = "*";

    /**
     * COMMA
     */
    public static final String COMMA = ",";

    /**
     * COLON
     */
    public static final String COLON = ":";

    /**
     * QUESTION_MARK
     */
    public static final String QUESTION_MARK = "?";

    /**
     * SEMICOLON
     */
    public static final String SEMICOLON = ";";

    /**
     * HYPHEN
     */
    public static final String HYPHEN = "-";

    /**
     * UNDERLINE
     */
    public static final String UNDERLINE = "_";

    /**
     * BLANK
     */
    public static final String BLANK = "";

    /**
     * AND
     */
    public static final String AND = "&";

    /**
     * EMPTY_STRING
     */
    public static final String EMPTY_STRING = " ";

    /**
     * EQUAL
     */
    public static final String EQUAL = "=";

    /**
     * LEFT_BIG_PARENTHESES
     */
    public static final String LEFT_BIG_PARENTHESES = "{";

    /**
     * RIGHT_BIG_PARENTHESES
     */
    public static final String RIGHT_BIG_PARENTHESES = "}";

    /**
     * BIG_PARENTHESES
     */
    public static final String BIG_PARENTHESES = "{}";

    /**
     * SQUARE_BRACKETS
     */
    public static final String SQUARE_BRACKETS = "[]";

    /**
     * LEFT_SQUARE_BRACKETS
     */
    public static final String LEFT_SQUARE_BRACKETS = "[";

    /**
     * RIGHT_SQUARE_BRACKETS
     */
    public static final String RIGHT_SQUARE_BRACKETS = "]";

    /**
     * PARENTHESES
     */
    public static final String PARENTHESES = "()";

    /**
     * LEFT_PARENTHESES
     */
    public static final String LEFT_PARENTHESES = "(";

    /**
     * RIGHT_PARENTHESES
     */
    public static final String RIGHT_PARENTHESES = ")";

    /**
     * LEFT_ARROW
     */
    public static final String LEFT_ARROW = " -> ";

    /**
     * AT
     */
    public static final String AT = "@";

    /**
     * NULL
     */
    public static final String NULL = "null";

    /**
     * PACKAGE_NAME
     */
    public static final String PACKAGE_NAME = "com.mobaijun";

    /**
     * CHINESE_CHARACTERS
     */
    public static final String[] CHINESE_CHARACTERS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    /**
     * UNIT
     */
    public static final String[][] UNIT = {{"元", "万", "亿"}, {"拾", "佰", "仟"}};

    /**
     * FRACTION
     */
    public static final String[] FRACTION = {"角", "分"};

    /**
     * HTTP_PREFIX
     */
    public static final String HTTP_PREFIX = "http://";

    /**
     * HTTPS_PREFIX
     */
    public static final String HTTPS_PREFIX = "https://";

    /**
     * DOLLAR
     */
    public static final String DOLLAR = "$";

    /**
     * PERCENT
     */
    public static final String PERCENT = "%";

    /**
     * SLASH
     */
    public static final String SLASH = "/";

    /**
     * BACK_SLASH
     */
    public static final String BACK_SLASH = "\\";

    /**
     * FULL_WIDTH_LESS
     */
    public static String FULL_WIDTH_LESS = "＜";

    /**
     * FULL_WIDTH_GREATER
     */
    public static String FULL_WIDTH_GREATER = "＞";

    /**
     * HALF_WIDTH_LESS
     */
    public static String HALF_WIDTH_LESS = "<";

    /**
     * HALF_WIDTH_GREATER
     */
    public static String HALF_WIDTH_GREATER = ">";

    /**
     * INDEX_NOT_FOUND
     */
    public static final int INDEX_NOT_FOUND = -1;

    /**
     * TAB
     */
    public static final String TAB = "\t";

    /**
     * DOUBLE_DOT
     */
    public static final String DOUBLE_DOT = "..";

    /**
     * CR
     */
    public static final String CR = "\r";

    /**
     * LF
     */
    public static final String LF = "\n";

    /**
     * v
     */
    public static final String CRLF = "\r\n";

    /**
     * HTML_NBSP
     */
    public static final String HTML_NBSP = "&nbsp;";

    /**
     * HTML_AMP
     */
    public static final String HTML_AMP = "&amp;";

    /**
     * HTML_QUOTE
     */
    public static final String HTML_QUOTE = "&quot;";

    /**
     * HTML_APOS
     */
    public static final String HTML_APOS = "&apos;";

    /**
     * HTML_LT
     */
    public static final String HTML_LT = "&lt;";

    /**
     * HTML_GT
     */
    public static final String HTML_GT = "&gt;";

    /**
     * ISO_8859_1
     */
    private final static String ISO_8859_1 = "ISO-8859-1";

    /**
     * GB2312
     */
    private final static String GB2312 = "GB2312";

    /**
     * UTF_8
     */
    private final static String UTF_8 = "UTF-8";

    /**
     * // (浓汤)乳脂,番茄等-------// 薄雾玫瑰-------// 金---// 纯绿 ---------// 适中的绿宝石-----------// 爱丽丝蓝--// 板岩暗蓝灰色//  深粉色
     * "255, 228, 196",---"255, 228, 225",---"255, 215, 0",---"0, 128, 0",--------"72, 209, 204",----"240, 248, 255"--"106, 90, 205""255, 20, 147"
     * // 深橙色---// 鲜肉(鲑鱼)色---// 玉米色---// 深绿色----------// 浅海洋绿---// 钢蓝--// 深岩暗蓝灰色// 适中的紫罗兰红色
     * "255, 140, 0",---"250, 128, 114",---"255, 248, 220",---"0, 100, 0",--------"32, 178, 170",-----"70, 130, 180"--"72, 61, 139""199, 21, 133"
     * // 亚麻布---// 雪---// 秋麒麟---// 查特酒绿----------// 绿宝石------// 淡蓝色--// 熏衣草花的淡紫色// 兰花的紫色
     * "250, 240, 230",---"255, 250, 250",---"218, 165, 32",---"127, 255, 0",--------"64, 224, 208",--"135, 206, 250"--"230, 230, 250""218, 112, 214"
     * // 秘鲁---// 淡珊瑚色---// 花的白色---// 草坪绿----------// 绿玉\碧绿色-------// 天蓝色--// 幽灵的白色// 蓟
     * "205, 133, 63",---"240, 128, 128",---"255, 250, 240",---"124, 252, 0",--------"127, 255, 170",-"135, 206, 235"--"248, 248, 255""216, 191, 216"
     * // 桃色---// 玫瑰棕色---// 老饰带---// 绿黄色----------// 适中的碧绿色---------// 深天蓝--// 纯蓝// 李子
     * "255, 218, 185",---"188, 143, 143",---"253, 245, 230",---"173, 255, 47",--------"0, 250, 154",-"0, 191, 255"--"0, 0, 255""221, 160, 221"
     * // 沙棕色---// 印度红---// 鹿皮鞋---// 橄榄土褐色----------// 薄荷奶油-------// 淡蓝--// 午夜的蓝色// 紫罗兰
     * "244, 164, 96",---"205, 92, 92",---"255, 228, 181",---"85, 107, 47",--------"0, 255, 127",-----"173, 216, 230"--"25, 25, 112""238, 130, 238"
     * // 巧克力---// 棕色---// 橙色---// 米色(浅褐色)----------// 春天的绿色-------// 火药蓝--// 深蓝色// 洋红
     * "210, 105, 30",---"165, 42, 42",---"255, 165, 0",---"107, 142, 35",--------"60, 179, 113",-----"176, 224, 230"--"0, 0, 139""255, 0, 255"
     * // 马鞍棕色---// 耐火砖---// 番木瓜---// 浅秋麒麟黄----------// 海洋绿-----// 军校蓝--// 海军蓝// 深洋红色
     * "139, 69, 19",---"178, 34, 34",---"255, 239, 213",---"250, 250, 210",--------"46, 139, 87",----"95, 158, 160"--"0, 0, 128""139, 0, 139"
     * // 海贝壳---// 深红色---// 漂白的杏仁---// 象牙----------// 蜂蜜---------// 蔚蓝色--// 皇军蓝// 紫色
     * "255, 245, 238",---"139, 0, 0",---"255, 235, 205",---"255, 255, 240",--------"240, 255, 240",--"240, 255, 255"--"65, 105, 225""128, 0, 128"
     * // 黄土赭色---// 栗色---// 古代的白色---// 浅黄色----------// 淡绿色--------// 淡青色--// 矢车菊的蓝色// 适中的兰花紫
     * "160, 82, 45",---"128, 0, 0",---"250, 235, 215",---"255, 255, 224",--------"144, 238, 144",----"225, 255, 255"--"100, 149, 237""186, 85, 211"
     * // 浅鲜肉(鲑鱼)色---// 白烟---// 晒黑---// 纯黄----------// 苍白的绿色----// 苍白的绿宝石--// 淡钢蓝// 深紫罗兰色
     * "255, 160, 122",---"245, 245, 245",---"210, 180, 140",---"255, 255, 0",----------"152, 251, 152","175, 238, 238"--"176, 196, 222""148, 0, 211"
     * // 珊瑚---// 浅灰色---// 结实的树---// 橄榄----------// 深海洋绿------// 青色--// 浅石板灰// 深兰花紫
     * "255, 127, 80",---"211, 211, 211",---"222, 184, 135",---"128, 128, 0",----------"143, 188, 143",-"0, 255, 255"--"119, 136, 153""153, 50, 204"
     * // 橙红色---// 银白色------// 深卡其布----------// 酸橙绿--------// 深绿宝石--// 石板灰// 靛青
     * "255, 69, 0",---"192, 192, 192",------"189, 183, 107",----------"50, 205, 50",-----------------"0, 206, 209"--"112, 128, 144""75, 0, 130"
     * // 深鲜肉(鲑鱼)色---// 暗淡的灰色------// 柠檬薄纱----------// 酸橙色------// 深石板灰--// 道奇蓝// 深紫罗兰的蓝色---//  粉红---//  脸红的淡紫色
     * "233, 150, 122",---"105, 105, 105",------"255, 250, 205",----------"0, 255, 0",----------"47, 79, 79"--"30, 144, 255""138, 43, 226"---"255, 192, 203"---"255, 240, 245"
     * // 番茄---// 纯黑------// 灰秋麒麟----------// 森林绿------// 深青色--// 适中的紫色---//  猩红---//  苍白的紫罗兰红色 "255, 182, 193"
     * "255, 99, 71",---"0, 0, 0"------"238, 232, 170",----------"34, 139, 34",--------"0, 139, 139"--"147, 112, 219"---"220, 20, 60"---"219, 112, 147"
     */
    public static final String[] COLOR_LIST = {
            "255,182,193", "255,192,203", "220,20,60", "255,240,245", "219,112,147", "255,105,180", "255,20,147", "148,0,211", "153,50,204",
            "199,21,133", "218,112,214", "216,191,216", "221,160,221", "238,130,238", "255,0,255", "139,0,139", "128,0,128", "186,85,211",
            "75,0,130", "138,43,226", "147,112,219", "123,104,238", "106,90,205", "72,61,139", "230,230,250", "248,248,255", "0,0,255",
            "25,25,112", "0,0,139", "0,0,128", "65,105,225", "100,149,237", "176,196,222", "119,136,153", "112,128,144", "30,144,255",
            "240,248,255", "70,130,180", "135,206,250", "135,206,235", "0,191,255", "173,216,230", "176,224,230", "95,158,160",
            "240,255,255", "225,255,255", "175,238,238", "0,255,255", "0,206,209", "47,79,79", "0,139,139", "0,128,128", "72,209,204",
            "32,178,170", "64,224,208", "127,255,170", "0,250,154", "0,255,127", "60,179,113", "46,139,87", "240,255,240", "173,255,47",
            "144,238,144", "152,251,152", "143,188,143", "50,205,50", "0,255,0", "34,139,34", "0,128,0", "0,100,0", "127,255,0", "124,252,0",
            "85,107,47", "107,142,35", "250,250,210", "255,255,240", "255,255,224", "255,255,0", "128,128,0", "189,183,107", "255,250,205",
            "238,232,170", "240,230,140", "255,215,0", "255,248,220", "218,165,32", "255,250,240", "253,245,230", "255,228,181", "255,165,0",
            "255,239,213", "255,235,205", "250,235,215", "210,180,140", "222,184,135", "255,228,196", "255,140,0", "250,240,230",
            "255,218,185", "244,164,96", "210,105,30", "139,69,19", "255,245,238", "160,82,45", "255,160,122", "255,127,80", "255,69,0",
            "233,150,122", "255,99,71", "255,228,225", "250,128,114", "255,250,250", "240,128,128", "188,143,143", "205,92,92", "205,133,63",
            "165,42,42", "178,34,34", "139,0,0", "128,0,0", "245,245,245", "211,211,211", "192,192,192", "105,105,105", "0,0,0", "255,0,0",};


    /**
     * a-z、0-9的数组常量
     */
    public static final char[] ALPHANUMERIC = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

    /**
     * 去重处理，去除重复的字符串常量
     */
    public static void removeDuplicates() {
        Set<String> uniqueConstants = new HashSet<>();
        for (String constant : COLOR_LIST) {
            if (!uniqueConstants.add(constant)) {
                System.out.println("Duplicate constant: " + constant);
            }
        }
    }
}