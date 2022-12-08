package com.mobaijun.common.test.util;

import com.mobaijun.common.cache.map.HashMapSingletonCacheUtils;
import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.ToolUtil;

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
        // 判断一个对象是否是时间类型
        PrintUtil.println(ToolUtil.dateType(new Date().getTime()));

        // 获取异常的具体信息
        PrintUtil.println(ToolUtil.getExceptionMsg(new NullPointerException("空指针异常！")));

        // 比较两个对象是否相等
        PrintUtil.println(ToolUtil.equals(LocalDate.now(), LocalDate.now()));

        // 计算对象长度，如果是字符串调用其length函数，集合类调用其size函数，数组调用其length属性，其他可遍历对象遍历计算长度
        PrintUtil.println(ToolUtil.length(HashMapSingletonCacheUtils.getInstance()));

        // 对象中是否包含元素
        PrintUtil.println(ToolUtil.contains(HashMapSingletonCacheUtils.getInstance(), 1));

        // 对象是否不为空(新增)
        PrintUtil.println(ToolUtil.isNotEmpty(LocalDate.now()));

        // 对象是否为空
        PrintUtil.println(ToolUtil.isEmpty(LocalDate.now()));
    }
}
