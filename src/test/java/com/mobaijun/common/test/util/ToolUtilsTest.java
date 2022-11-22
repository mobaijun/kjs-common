package com.mobaijun.common.test.util;

import com.mobaijun.common.cache.map.HashMapSingletonCacheUtils;
import com.mobaijun.common.util.PrintUtils;
import com.mobaijun.common.util.ToolUtils;

import java.time.LocalDate;
import java.util.Date;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: ToolUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 17:49
 */
public class ToolUtilsTest {
    public static void main(String[] args) {
        // 获取随机位数的字符串
        PrintUtils.println(ToolUtils.getRandomString(10));

        // 判断一个对象是否是时间类型
        PrintUtils.println(ToolUtils.dateType(new Date().getTime()));

        // 获取异常的具体信息
        PrintUtils.println(ToolUtils.getExceptionMsg(new NullPointerException("空指针异常！")));

        // 比较两个对象是否相等
        PrintUtils.println(ToolUtils.equals(LocalDate.now(), LocalDate.now()));

        // 计算对象长度，如果是字符串调用其length函数，集合类调用其size函数，数组调用其length属性，其他可遍历对象遍历计算长度
        PrintUtils.println(ToolUtils.length(HashMapSingletonCacheUtils.getInstance()));

        // 对象中是否包含元素
        PrintUtils.println(ToolUtils.contains(HashMapSingletonCacheUtils.getInstance(),1));

        // 对象是否不为空(新增)
        PrintUtils.println(ToolUtils.isNotEmpty(LocalDate.now()));

        // 对象是否为空
        PrintUtils.println(ToolUtils.isEmpty(LocalDate.now()));
    }
}
