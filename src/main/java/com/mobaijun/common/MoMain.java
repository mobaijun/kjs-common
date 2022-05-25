package com.mobaijun.common;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: MoMain
 * class description： Test
 *
 * @author MoBaiJun 2022/5/20 17:27
 */
public class MoMain {
    public static void main(String[] args) {
        // 得到该链接的 html字符串
        String listContent = HttpUtil.get("https://tool.lu/ip?ip=61.140.232.187");
        System.out.println("listContent = " + listContent);
        // 使用正则匹配
        List<String> titles = ReUtil.findAll("\n" +
                "IP 地址：", listContent, 1);
        for (String title : titles) {
            Console.log(title);
        }
    }
}
